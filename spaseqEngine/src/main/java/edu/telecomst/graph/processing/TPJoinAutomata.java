/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomst.graph.processing;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.graph.automata.AutomataState;
import edu.telecomstet.cep.model.Filter;
import edu.telecomstet.cep.rulesmodel.Dependability;
import edu.telecomstet.cep.statefull.StateDependability;
import edu.telecomstet.cep.utils.LiteralComparisonImpl;

/**
 *
 * @author sydgillani
 */
public class TPJoinAutomata {
	private LiteralComparisonImpl compLiteral = new LiteralComparisonImpl();
	// private HashMap<Integer, MultiBiMap<Long, Long> > hm =new HashMap();
	// private int newID=0;
	private long queryTimer = 0;
	// private int count=0;
	private int stop = 0;
	private boolean checker = false;
	// private int testCounter=0;
	// private int proceed=0;
	private long indexCount;

	private final KBJoinerWithEvents kbJoins = new KBJoinerWithEvents();

	// Later Implents the API for this class

	/**
	 *
	 * @param automata
	 * @param dic
	 * @param c
	 */

	public boolean run(Automata automata, DictionaryOpImpl dic, Map<RunStateMap, MultiBidirectionalIndex> c,
			Map<KBindex, MultiBiMap<Long, SP>> kbcache, int r, int st) {
		// if(proceed==0){

		if (automata.getStates().stream().filter(x -> x.getRule().getC2().size() > 0).count() == automata.getStates()
				.size()) {
			// proceed=1;
			/// automata.getfR2().clear();///remove this
			//// Clearing should be done somewhere else

			for (AutomataState s : automata.getStates()) {

				if (!s.getEdge().getRreal().getR().isEmpty()) {
					s.getEdge().getRreal().getR().clear();
					s.getEdge().getRreal().getrIndex().clear();
				}
				if (!s.getEdge().getrCopied().getR().isEmpty()) {
					s.getEdge().getrCopied().getR().clear();
					s.getEdge().getrCopied().getrIndex().clear();
				}

			}

			return tpJoinStart(automata, dic, c, kbcache, r, st);
		}
		return false;
	}

	public boolean tpJoinStart(Automata automata, DictionaryOpImpl dic, Map<RunStateMap, MultiBidirectionalIndex> c,
			Map<KBindex, MultiBiMap<Long, SP>> kbcache, int r, int st) {

		for (AutomataState s : automata.getStates()) {

			tripleJoinStage1(s, automata, dic, c, r);

			if (stop == 1) {

				stop = 0;
				return false;

				// break;
			}

		}

		/**
		 * Check if there exists am external KB that is required to be joined
		 * with the current event
		 */

		if (automata.getContainsKB() == 1) {

			/// The KB join Function

			kbJoins.kbJoinerwithAutomata(automata, kbcache, r, st);
		}

		/**
		 * Extract the results from the joined tables using the incrementally
		 * produced indexes
		 */

		Set<Long> keys = null;

		int min = 0;
		if (!automata.getStates().get(0).getEdge().getRreal().getrIndex().isEmpty()) {
			min = automata.getStates().get(0).getEdge().getRreal().getrIndex().keySize();
		} else {
			min = automata.getStates().get(0).getEdge().getrCopied().getrIndex().keySize();
		}
		/// if the resulted
		for (int i = 1; i < automata.getStates().size(); i++) {

			if (!automata.getStates().get(i).getEdge().getRreal().getrIndex().isEmpty()
					&& automata.getStates().get(i).getEdge().getRreal().getrIndex().keySize() <= min) {
				min = automata.getStates().get(i).getEdge().getRreal().getrIndex().keySize();
				keys = automata.getStates().get(i).getEdge().getRreal().getrIndex().keySet();
			} else if (automata.getStates().get(i).getEdge().getrCopied().getrIndex().keySize() <= min) {
				min = automata.getStates().get(i).getEdge().getrCopied().getrIndex().keySize();
				keys = automata.getStates().get(i).getEdge().getrCopied().getrIndex().keySet();
			}
		}
		/*
		 * If there is just one triple pattern, then put all the things from C
		 * in the stateful cache
		 */
		if (keys == null && automata.getStates().size() == 1) {
			MultiBidirectionalIndex result = null;
			AutomataState aS = automata.getStates().get(0);
			RunStateMap res = new RunStateMap(st, r, aS.getStateId());
			if (c.containsKey(res)) {
				result = c.get(res);
			} else {
				result = new MultiBidirectionalIndex();
			}
			Iterator<Entry<Long, Long>> it = aS.getRule().getC2().entries().iterator();
			while (it.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry) it.next();
				result.getrIndex().put(aS.getRule().getPredicate().getMappedValue(),
						new SP((Long) pair.getKey(), (Long) pair.getValue()));
			}

			result.getR().putAll(aS.getRule().getC2());
			c.put(new RunStateMap(st, r, aS.getStateId()), result);
			return true;
		}

		for (long index : keys) {

			/// issue here
			for (AutomataState s : automata.getStates()) {
				final MultiBidirectionalIndex result = new MultiBidirectionalIndex();
				Set<SP> sp = null;
				if (!s.getEdge().getRreal().getrIndex().isEmpty()) {
					sp = s.getEdge().getRreal().getrIndex().get(index);

				} else {
					sp = s.getEdge().getrCopied().getrIndex().get(index);
				}

				for (SP out : sp) {

					//// put in the r and rIndex with the predicates as indexes

					// System.out.println(s.getRule().getObject().getProjection()+"
					// "+dic.getResourceAdaptive(out.getSub())+" " +
					// out.getPred());
					result.getR().put(out.getSub(), out.getPred());
					result.getrIndex().put(s.getRule().getPredicate().getMappedValue(), out);

				}

				c.put(new RunStateMap(st, r, s.getStateId()), result);

			}

		}

		/// do it over here

		//

		////////
		/// external KB computation
		/*
		 * if(!automata.getKbBinds().isEmpty()){ //
		 * kbJoinManipulation(automata);
		 * 
		 * automata.getKbBinds().get(automata.getKbBinds().size()-1).getR().
		 * entries().forEach((x)->{
		 * 
		 * 
		 * 
		 * 
		 * 
		 * System.out.println(dic.getResourcePersistant(x.getKey().getSub()) +
		 * "    " + dic.getResourcePersistant(x.getKey().getPred()) + "   "+
		 * dic.getResourcePersistant(x.getValue().getObj())+
		 * dic.getBnodePersistant(x.getValue().getObj()));
		 * 
		 * 
		 * 
		 * 
		 * }); }
		 */

		// c.put(aut, null)

		return true;
	}

	// TODO: change it for other join types as well

	private void stateFulJoin(AutomataState currState, Automata a, DictionaryOpImpl dic,
			Map<RunStateMap, MultiBidirectionalIndex> c, int r) {

		for (StateDependability sd : currState.getRule().getS_depends()) {

			/// TODO: check if the state dependability is equal to the normal
			/// dependability
			if (dependabilityComparison(currState.getRule().getDepends(), sd, currState.getStateId()) > 0) {
				continue;
			}

			MultiBidirectionalIndex statef = c.get(new RunStateMap(sd.getIdNFA(), r, sd.getD_id()));

			if (statef == null) {
				stop = 0;
				continue;
			}

			if (sd.getD_On() == 1 && sd.getD_part() == 1) {

				// System.out.println("Dependqbility ID; "+ sd.getIdNFA());

				if (!currState.getEdge().getRreal().getR().isEmpty()) {
					this.ssJoinOptimisedForRRStateful(statef.getR(), currState.getEdge().getRreal(),
							currState.getEdge().getrCopied());

					if (checker) {
						checker = false;

						currState.getEdge().getRreal().getR().clear();
						currState.getEdge().getRreal().getrIndex().clear();
					} else {
						stop = 1;
						break;
					}

				} else if (!currState.getEdge().getrCopied().getR().isEmpty()) {

					this.ssJoinOptimisedForRRStateful(statef.getR(), currState.getEdge().getrCopied(),
							currState.getEdge().getRreal());

					if (checker) {
						checker = false;

						currState.getEdge().getrCopied().getR().clear();
						currState.getEdge().getrCopied().getrIndex().clear();
					} else {
						stop = 1;
						break;
					}

				} else if (currState.getEdge().getRreal().getR().isEmpty()
						&& currState.getEdge().getrCopied().getR().isEmpty()) {

					this.ssJoinOptimisedForCCStateful(statef.getR(), currState.getRule().getC2(),
							currState.getEdge().getRreal());

					if (checker) {
						checker = false;

					} else {
						stop = 1;
						break;
					}

				}

			} else if (sd.getD_On() == 0 && sd.getD_part() == 0 && stop == 0) {

				this.ooHashJoinCCStateful(statef.getR(), currState.getRule().getC2(), currState.getEdge().getRreal());
				if (checker) {
					checker = false;

				} else {
					stop = 1;
					break;
				}
			} else if (sd.getD_On() == 1 && sd.getD_part() == 0 && stop == 0) {
				this.osHashJoinCCStateful(statef.getR(), currState.getRule().getC2(), currState.getEdge().getRreal());
				if (checker) {
					checker = false;

				} else {
					stop = 1;
					break;
				}

			} else if (sd.getD_On() == 0 && sd.getD_part() == 1 && stop == 0) {
				this.soHashJoinCCStateful(statef.getR(), currState.getRule().getC2(), currState.getEdge().getRreal());
				if (checker) {
					checker = false;

				} else {
					stop = 1;
					break;
				}
			}

		}

	}

	/// Change the function for multiple filter clause and for stateful join
	/// there could be only 1 triple patter
	/// Plus used the older index value and do not update the index value even
	/// after the join

	private long dependabilityComparison(List<Dependability> dd, StateDependability sd, int id) {

		return dd.stream().filter(x -> x.getDependability_On() == sd.getD_On()
				&& x.getDependability_part() == sd.getD_part() && x.getDependabilty_id() < id).count();

	}

	private void stateFulFilterJoin(AutomataState currState, DictionaryOpImpl dic,
			Map<RunStateMap, MultiBidirectionalIndex> c, int r) {

		/// check if there are any filter of type 2 in this rule
		/// Loop around it

		for (Filter filter : currState.getRule().getFilter()) {

			if (currState.getRule().getFilterType() == 2 && filter.getStateFulness() == 1) {

				// AutomataState s
				// =automata.getStates().stream().filter(x->x.getStateId()==currState.getRule().getFilterRuleID()).findFirst().orElse(null);
				// System.out.println(filter.getD().getIdNFA());
				/// System.out.println(filter.getD().getD_id());
				/// use the dd to put the value trple by triple instead of
				// states

				MultiBiMap<Long, Long> stateful = c
						.get(new RunStateMap(filter.getD().getIdNFA(), r, filter.getD().getD_id())).getR();

				if (stateful == null) {
					stop = 0;
					continue;
				}
				// if(!s.getEdge().getR().isEmpty()){
				switch (currState.getRule().getFilterType1Operator()) {
				case "=": {

					// ooEqualJoin(s.getEdge().getR(),
					// currState.getRule().getC(),
					// currState.getEdge().getRCopied(),currState.getRule().getPredicate().getMappedValue());
					if (!currState.getEdge().getRreal().getR().isEmpty()) {
						this.ooHashJoinCCStateful(stateful, currState.getEdge().getRreal().getR(),
								currState.getEdge().getrCopied());
						/// TODO: change the cc join and check every thing, it
						/// could be
						if (checker) {
							currState.getEdge().getRreal().getR().clear();
							currState.getEdge().getRreal().getrIndex().clear();
						}

					} else {
						this.ooHashJoinCCStateful(stateful, currState.getEdge().getrCopied().getR(),
								currState.getEdge().getRreal());

						if (checker) {
							currState.getEdge().getrCopied().getR().clear();
							currState.getEdge().getrCopied().getrIndex().clear();
						}
					}

				}
					break;
				case "!=": {
					// ooNonEqualJoin(s.getEdge().getR(),
					// currState.getRule().getC(),
					// currState.getEdge().getRCopied(),s.getRule().getPredicate().getMappedValue());

					if (!currState.getEdge().getRreal().getR().isEmpty()) {
						this.ooNonequiHashJoin(stateful, currState.getEdge().getRreal().getR(),
								currState.getEdge().getrCopied());

						if (checker) {
							currState.getEdge().getRreal().getR().clear();
							currState.getEdge().getRreal().getrIndex().clear();
						}

					} else {
						this.ooNonequiHashJoin(stateful, currState.getEdge().getrCopied().getR(),
								currState.getEdge().getRreal());

						if (checker) {
							currState.getEdge().getrCopied().getR().clear();
							currState.getEdge().getrCopied().getrIndex().clear();
						}

					}
				}
					break;

				case ">":
				case "<":
				case ">=":
				case "<=": {
					// ooComplexJoin(s.getEdge().getR(),
					// currState.getRule().getC(),
					// currState.getEdge().getRCopied(),dic,currState.getRule().getFilterType1Operator(),currState.getStateDataType());
					if (!currState.getEdge().getRreal().getR().isEmpty()) {

						// this.complexFilterJoin(stateful,
						// currState.getEdge().getRreal().getR(),
						// currState.getEdge().getrCopied(), dic,
						// currState.getRule().getFilterType1Operator(),
						// currState.getStateDataType());
						complexFilterforR(stateful, currState.getEdge().getRreal(), currState.getEdge().getrCopied(),
								dic, currState.getRule().getFilterType1Operator(), currState.getStateDataType());

						if (checker) {
							currState.getEdge().getRreal().getR().clear();
							currState.getEdge().getRreal().getrIndex().clear();
						}

					} else if (!currState.getEdge().getrCopied().getR().isEmpty()) {
						// this.complexFilterJoin(stateful,
						// currState.getEdge().getrCopied().getR(),
						// currState.getEdge().getRreal(), dic,
						// currState.getRule().getFilterType1Operator(),
						// currState.getStateDataType());

						complexFilterforR(stateful, currState.getEdge().getrCopied(), currState.getEdge().getRreal(),
								dic, currState.getRule().getFilterType1Operator(), currState.getStateDataType());

						if (checker) {
							currState.getEdge().getrCopied().getR().clear();
							currState.getEdge().getrCopied().getrIndex().clear();
						}

					} else if (currState.getEdge().getRreal().getR().isEmpty()
							&& currState.getEdge().getrCopied().getR().isEmpty()
							&& !currState.getRule().getC2().isEmpty()) {
						/// new Complex Filter Statement
						this.complexFilterforC(stateful, currState.getRule().getC2(), currState.getEdge().getRreal(),
								dic, currState.getRule().getFilterType1Operator(), currState.getStateDataType());
					}

					// TODO: add one more IF caluse for C if both Rreal and
					// Rcopied are empty
				}
					break;

				}
				if (!checker) {
					stop = 1;
				} else {
					checker = false;
				}

				// }
			}

		}

	}

	private void tripleJoinStage1(AutomataState currState, Automata a, DictionaryOpImpl dic,
			Map<RunStateMap, MultiBidirectionalIndex> c, int r) {

		// stateFulJoin(AutomataState currState, Automata a, DictionaryOpImpl
		// dic,HashMap<RunStateMap, MultiBiMap<Long, Long>> c,int r);
		this.stateFulJoin(currState, a, dic, c, r);

		if (stop == 0) {
			for (Dependability dd : currState.getRule().getDepends()) {
				if (dd.getJoined() == 0) {
					/// find the join state
					AutomataState sJoin = null; // a.getStates().stream().filter(x->x.getStateId()==dd.getDependabilty_id()).findFirst().get();
					// resultHandler=true;
					/// check the type of the Join

					for (AutomataState s : a.getStates()) { /// WTF
						if (s.getStateId() == dd.getDependabilty_id()) {
							sJoin = s;
							//// firs check the dependability of the state
							if (!s.getRule().getDepends().isEmpty()
									&& s.getRule().getDepends().get(0).getDependabilty_id() == currState.getStateId()) {
								s.getRule().getDepends().get(0).setJoined(1);
							} else if (!s.getRule().getDepends().isEmpty() && s.getRule().getDepends().size() > 1
									&& s.getRule().getDepends().get(0).getDependabilty_id() == currState.getStateId()) {
								s.getRule().getDepends().get(1).setJoined(1);
							}
							break;
						}
					}

					if (dd.getDependability_On() == 1 && dd.getDependability_part() == 1 && stop == 0) {

						/// incrementalSSJoinStage1(sJoin,currState,a);
						IncrementalSSJoinStage2(currState, sJoin);

					} else if (dd.getDependability_On() == 1 && dd.getDependability_part() == 0 && stop == 0) {
						/// s for current stae
						// incrementalOSJoin(currState,sJoin,a);

						this.incrementalOSJoinStage2(currState, sJoin);

					} else if (dd.getDependability_On() == 0 && dd.getDependability_part() == 1 && stop == 0) {

						this.incrementalSOJoinStage2(currState, sJoin);
					} else if (dd.getDependability_On() == 0 && dd.getDependability_part() == 0 && stop == 0) {
						incrementalOOJoinStage2(currState, sJoin);
					}

				}
			}

			// }
			if (stop == 0) { // may move it}
				stateFulFilterJoin(currState, dic, c, r);
			}
		}
		//
	}

	private void IncrementalSSJoinStage2(AutomataState currState, AutomataState joinState) {

		/// if the join state r and r join are empty

		if (joinState.getEdge().getRreal().getR().isEmpty() && joinState.getEdge().getrCopied().getR().isEmpty()) { /// the
																													/// use
																													/// the
																													/// both
																													/// C
																													/// and
																													/// put
																													/// it
																													/// in
																													/// Rreal
																													/// of
																													/// both

			/// first check if the r is empty or ecopied is emptied for the
			/// currstate

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getRule().getC2().keySize() < joinState.getRule().getC2().keySize()) {

					this.ssJoinOptimisedForCC(currState.getRule().getC2(), joinState.getRule().getC2(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				} else {
					this.ssJoinOptimisedForCC(joinState.getRule().getC2(), currState.getRule().getC2(),
							joinState.getEdge().getRreal(), currState.getEdge().getRreal());
				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				this.ssJoinOptimisedForRC(joinState.getRule().getC2(), currState.getEdge().getRreal(),
						joinState.getEdge().getRreal(), currState.getEdge().getrCopied());

				if (checker) {

					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {
				this.ssJoinOptimisedForRC(joinState.getRule().getC2(), currState.getEdge().getrCopied(),
						joinState.getEdge().getRreal(), currState.getEdge().getRreal());

				if (checker) {

					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
			// joinState.getRule().getC2(), currState.getEdge().getRreal(),
			// joinState.getEdge().getRreal());

		} else if (!joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) {
			// use Real
			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				this.ssJoinOptimisedForRC(currState.getRule().getC2(), joinState.getEdge().getRreal(),
						currState.getEdge().getRreal(), joinState.getEdge().getrCopied());

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				if (joinState.getEdge().getRreal().getR().keySize() < currState.getEdge().getRreal().getR().keySize()) {

					this.ssJoinOptimisedForRC2(joinState.getEdge().getRreal(), currState.getEdge().getRreal(),
							joinState.getEdge().getrCopied(), currState.getEdge().getrCopied());
				} else {
					this.ssJoinOptimisedForRC2(currState.getEdge().getRreal(), joinState.getEdge().getRreal(),
							currState.getEdge().getrCopied(), joinState.getEdge().getrCopied());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (joinState.getEdge().getRreal().getR().keySize() < currState.getEdge().getrCopied().getR()
						.keySize()) {
					this.ssJoinOptimisedForRC2(joinState.getEdge().getRreal(), currState.getEdge().getrCopied(),
							joinState.getEdge().getrCopied(), currState.getEdge().getRreal());
				} else {
					this.ssJoinOptimisedForRC2(currState.getEdge().getrCopied(), joinState.getEdge().getRreal(),
							currState.getEdge().getRreal(), joinState.getEdge().getrCopied());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
			// currState.getEdge().getRreal());

			// if(checker){
			// joinState.getEdge().getRreal().getR().clear();
			// joinState.getEdge().getRreal().getrIndex().clear();
			// }

		} else if (joinState.getEdge().getRreal().getR().isEmpty()
				&& !joinState.getEdge().getrCopied().getR().isEmpty()) {

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				this.ssJoinOptimisedForRC(currState.getRule().getC2(), joinState.getEdge().getrCopied(),
						currState.getEdge().getRreal(), joinState.getEdge().getRreal());

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();

				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				if (joinState.getEdge().getrCopied().getR().keySize() < currState.getEdge().getRreal().getR()
						.keySize()) {
					this.ssJoinOptimisedForRC2(joinState.getEdge().getrCopied(), currState.getEdge().getRreal(),
							joinState.getEdge().getRreal(), currState.getEdge().getrCopied());
				} else {
					this.ssJoinOptimisedForRC2(currState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
							currState.getEdge().getrCopied(), joinState.getEdge().getRreal());
				}
				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (joinState.getEdge().getrCopied().getR().keySize() < currState.getEdge().getrCopied().getR()
						.keySize()) {
					this.ssJoinOptimisedForRC2(joinState.getEdge().getrCopied(), currState.getEdge().getrCopied(),
							joinState.getEdge().getRreal(), currState.getEdge().getRreal());
				} else {
					this.ssJoinOptimisedForRC2(currState.getEdge().getrCopied(), joinState.getEdge().getrCopied(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				}

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getrCopied(), joinState.getEdge().getRreal(),
			// currState.getEdge().getRreal());

		}

		//// check the tablesomappedcopied

		////////////////
		if (checker) {
			currState.setJoined(1);
			joinState.setJoined(1);

			currState.setChange(0);
			// automata.getStates().get(id).getRule().getTableSOMapped().removeAll(
			// automata.getStates().get(id).getEdge().getTableSOMapped());
			// //change it
			// removeFromC(currState.getRule().getC(),currState.getEdge().getR());
			checker = false;

		} else {
			stop = 1;
		}

	}

	private void ssJoinOptimisedForCC(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2,
			MultiBidirectionalIndex _r1, MultiBidirectionalIndex _r2) {

		for (long key : _c1.keySet()) {

			if (_c2.containsKey(key)) {
				checker = true;
				_r1.getR().putAll(key, _c1.get(key));
				long index = ++indexCount;
				Set<Long> r1val = _c1.get(key);
				for (long val : r1val)
					_r1.getrIndex().put(index, new SP(key, val));

				_r2.getR().putAll(key, _c2.get(key));

				Set<Long> r2val = _c2.get(key);
				for (long val : r2val)
					_r2.getrIndex().put(index, new SP(key, val));

			}
			//
		}

	}

	private void ssJoinOptimisedForCCStateful(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2,
			MultiBidirectionalIndex _r2) {
		/// thats the issues CC statefull all the time, again two conditions

		for (long key : _c1.keySet()) {

			if (_c2.containsKey(key)) {
				checker = true;

				long index = ++indexCount;

				_r2.getR().putAll(key, _c2.get(key));

				Set<Long> r2val = _c2.get(key);
				for (long val : r2val)
					_r2.getrIndex().put(index, new SP(key, val));

			}
			//
		}

	}

	private void ssJoinOptimisedForRRStateful(MultiBiMap<Long, Long> _c1, MultiBidirectionalIndex _c2,
			MultiBidirectionalIndex _r2) {
		/// thats the issues CC statefull all the time, again two conditions

		for (long key : _c1.keySet()) {

			if (_c2.getR().containsKey(key)) {
				checker = true;

				_r2.getR().putAll(key, _c2.getR().get(key));

				Set<Long> r2val = _c2.getR().get(key);
				for (long val : r2val) {

					SP sp = new SP(key, val);

					_r2.getrIndex().put(_c2.getrIndex().getKey(sp), sp);
				}

			}
			//
		}
	}

	private void ssJoinOptimisedForRC(MultiBiMap<Long, Long> _c1, MultiBidirectionalIndex _r2,
			MultiBidirectionalIndex _r4, MultiBidirectionalIndex _r3) {

		if (_c1.keySize() < _r2.getR().keySize()) {

			for (long key : _c1.keySet()) {

				if (_r2.getR().containsKey(key)) {

					/// first get the index value from _r
					checker = true;
					// _r2.getR().getValue(key);

					long index = _r2.getrIndex().getKey(new SP(key, _r2.getR().getValue(key)));

					_r3.getR().putAll(key, _r2.getR().get(key));

					Set<Long> r2val = _r2.getR().get(key); // put all in the new
															// r whcich is r3
					for (long val : r2val)
						_r3.getrIndex().put(index, new SP(key, val));

					/// now put the stuff in r3 which is for the join state

					_r4.getR().putAll(key, _c1.get(key));

					Set<Long> c1val = _c1.get(key);
					for (long val2 : c1val)
						_r4.getrIndex().put(index, new SP(key, val2));

				}
				//
			}

		} else {

			for (long key : _r2.getR().keySet()) {

				if (_c1.containsKey(key)) {

					/// first get the index value from _r
					checker = true;
					// _r2.getR().getValue(key);

					long index = _r2.getrIndex().getKey(new SP(key, _r2.getR().getValue(key)));

					_r3.getR().putAll(key, _r2.getR().get(key));

					Set<Long> r2val = _r2.getR().get(key); // put all in the new
															// r whcich is r3
					for (long val : r2val)
						_r3.getrIndex().put(index, new SP(key, val));

					/// now put the stuff in r3 which is for the join state

					_r4.getR().putAll(key, _c1.get(key));

					Set<Long> c1val = _c1.get(key);
					for (long val2 : c1val)
						_r4.getrIndex().put(index, new SP(key, val2));

				}
				//
			}

		}

		/// clear every thing in the R2
		// _r2.getR().clear();
		// _r2.getrIndex().clear();

	}

	private void ssJoinOptimisedForRC2(MultiBidirectionalIndex _c1, MultiBidirectionalIndex _r2,
			MultiBidirectionalIndex _r4, MultiBidirectionalIndex _r3) {

		for (long key : _c1.getR().keySet()) {

			if (_r2.getR().containsKey(key)) {

				/// first get the index value from _r
				checker = true;
				// _r2.getR().getValue(key);

				long index = _r2.getrIndex().getKey(new SP(key, _r2.getR().getValue(key)));

				_r3.getR().putAll(key, _r2.getR().get(key));

				Set<Long> r2val = _r2.getR().get(key); // put all in the new r
														// whcich is r3
				for (long val : r2val)
					_r3.getrIndex().put(index, new SP(key, val));

				/// now put the stuff in r3 which is for the join state
				index = _c1.getrIndex().getKey(new SP(key, _c1.getR().getValue(key)));

				_r4.getR().putAll(key, _c1.getR().get(key));

				Set<Long> c1val = _c1.getR().get(key);
				for (long val2 : c1val)
					_r4.getrIndex().put(index, new SP(key, val2));

			}
			//
		}

		/// clear every thing in the R2
		// _r2.getR().clear();
		// _r2.getrIndex().clear();

	}

	/////////////////////// ######################################################################////////////////////////////////////////

	private void incrementalSOJoinStage2(AutomataState currState, AutomataState joinState) {

		if (joinState.getEdge().getRreal().getR().isEmpty() && joinState.getEdge().getrCopied().getR().isEmpty()) { /// the
																													/// use
																													/// the
																													/// both
																													/// C
																													/// and
																													/// put
																													/// it
																													/// in
																													/// Rreal
																													/// of
																													/// both

			/// first check if the r is empty or ecopied is emptied for the
			/// currstate

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
				// joinState.getRule().getC2(), currState.getEdge().getRreal(),
				// joinState.getEdge().getRreal());

				if (currState.getRule().getC2().size() < joinState.getRule().getC2().size()) {

					this.soHashJoinCC(currState.getRule().getC2(), joinState.getRule().getC2(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				} else {
					this.osHashJoinCC(joinState.getRule().getC2(), currState.getRule().getC2(),
							joinState.getEdge().getRreal(), currState.getEdge().getRreal());
				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				/// reverse function

				this.osHashJoinRC(joinState.getRule().getC2(), currState.getEdge().getRreal(),
						joinState.getEdge().getRreal(), currState.getEdge().getrCopied());
				if (checker) {

					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				// reverse function
				this.osHashJoinRC(joinState.getRule().getC2(), currState.getEdge().getrCopied(),
						joinState.getEdge().getRreal(), currState.getEdge().getRreal());

				if (checker) {

					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
			// joinState.getRule().getC2(), currState.getEdge().getRreal(),
			// joinState.getEdge().getRreal());

		} else if (!joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) {
			// use Real
			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				this.soHashJoinRC(currState.getRule().getC2(), joinState.getEdge().getRreal(),
						currState.getEdge().getRreal(), joinState.getEdge().getrCopied());

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getRreal().getR().size() < joinState.getEdge().getRreal().getR().size()) {

					soHashJoinRC2(currState.getEdge().getRreal(), joinState.getEdge().getRreal(),
							currState.getEdge().getrCopied(), joinState.getEdge().getrCopied());
				} else {
					osHashJoinRC2(joinState.getEdge().getRreal(), currState.getEdge().getRreal(),
							joinState.getEdge().getrCopied(), currState.getEdge().getrCopied());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getrCopied().getR().size() < joinState.getEdge().getRreal().getR().size()) {
					soHashJoinRC2(currState.getEdge().getrCopied(), joinState.getEdge().getRreal(),
							currState.getEdge().getRreal(), joinState.getEdge().getrCopied());
				} else {
					osHashJoinRC2(joinState.getEdge().getRreal(), currState.getEdge().getrCopied(),
							joinState.getEdge().getrCopied(), currState.getEdge().getRreal());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
			// currState.getEdge().getRreal());

			// if(checker){
			// joinState.getEdge().getRreal().getR().clear();
			// joinState.getEdge().getRreal().getrIndex().clear();
			// }

		} else if (joinState.getEdge().getRreal().getR().isEmpty()
				&& !joinState.getEdge().getrCopied().getR().isEmpty()) {

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				this.soHashJoinRC(currState.getRule().getC2(), joinState.getEdge().getrCopied(),
						currState.getEdge().getRreal(), joinState.getEdge().getRreal());

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();

				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getRreal().getR().size() < joinState.getEdge().getrCopied().getR().size()) {
					soHashJoinRC2(currState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
							currState.getEdge().getrCopied(), joinState.getEdge().getRreal());
				} else {
					osHashJoinRC2(joinState.getEdge().getrCopied(), currState.getEdge().getRreal(),
							joinState.getEdge().getRreal(), currState.getEdge().getrCopied());
				}

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getrCopied().getR().size() < joinState.getEdge().getrCopied().getR().size()) {
					soHashJoinRC2(currState.getEdge().getrCopied(), joinState.getEdge().getrCopied(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				} else {
					osHashJoinRC2(joinState.getEdge().getrCopied(), currState.getEdge().getrCopied(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				}

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

		}
		if (checker) {
			checker = false;

		} else {
			stop = 1;
		}
	}

	/////////////////////// ######################################################################////////////////////////////////////////
	private void incrementalOSJoinStage2(AutomataState currState, AutomataState joinState) {// AutomataState
																							// currState,
																							// AutomataState
																							// joinState,
																							// Automata
																							// a,
																							// long
																							// pred1,
																							// long
																							// pred2){

		if (joinState.getEdge().getRreal().getR().isEmpty() && joinState.getEdge().getrCopied().getR().isEmpty()) { /// the
																													/// use
																													/// the
																													/// both
																													/// C
																													/// and
																													/// put
																													/// it
																													/// in
																													/// Rreal
																													/// of
																													/// both

			/// first check if the r is empty or ecopied is emptied for the
			/// currstate

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
				// joinState.getRule().getC2(), currState.getEdge().getRreal(),
				// joinState.getEdge().getRreal());

				if (currState.getRule().getC2().size() < joinState.getRule().getC2().size()) {

					this.osHashJoinCC(currState.getRule().getC2(), joinState.getRule().getC2(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				} else {
					this.soHashJoinCC(joinState.getRule().getC2(), currState.getRule().getC2(),
							joinState.getEdge().getRreal(), currState.getEdge().getRreal());
				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				// this.osHashJoinRC(null, null, null, null);

				this.soHashJoinRC(joinState.getRule().getC2(), currState.getEdge().getRreal(),
						joinState.getEdge().getRreal(), currState.getEdge().getrCopied());

				if (checker) {

					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				this.soHashJoinRC(joinState.getRule().getC2(), currState.getEdge().getrCopied(),
						joinState.getEdge().getRreal(), currState.getEdge().getRreal());

				if (checker) {

					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
			// joinState.getRule().getC2(), currState.getEdge().getRreal(),
			// joinState.getEdge().getRreal());

		} else if (!joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) {
			// use Real
			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				this.osHashJoinRC(currState.getRule().getC2(), joinState.getEdge().getRreal(),
						currState.getEdge().getRreal(), joinState.getEdge().getrCopied());

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getRreal().getR().size() < joinState.getEdge().getRreal().getR().size()) {
					osHashJoinRC2(currState.getEdge().getRreal(), joinState.getEdge().getRreal(),
							currState.getEdge().getrCopied(), joinState.getEdge().getrCopied());
				} else {
					soHashJoinRC2(joinState.getEdge().getRreal(), currState.getEdge().getRreal(),
							joinState.getEdge().getrCopied(), currState.getEdge().getrCopied());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getrCopied().getR().size() < joinState.getEdge().getRreal().getR().size()) {
					osHashJoinRC2(currState.getEdge().getrCopied(), joinState.getEdge().getRreal(),
							currState.getEdge().getRreal(), joinState.getEdge().getrCopied());
				} else {
					soHashJoinRC2(joinState.getEdge().getRreal(), currState.getEdge().getrCopied(),
							joinState.getEdge().getrCopied(), currState.getEdge().getRreal());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
			// currState.getEdge().getRreal());

			// if(checker){
			// joinState.getEdge().getRreal().getR().clear();
			// joinState.getEdge().getRreal().getrIndex().clear();
			// }

		} else if (joinState.getEdge().getRreal().getR().isEmpty()
				&& !joinState.getEdge().getrCopied().getR().isEmpty()) {

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				this.osHashJoinRC(currState.getRule().getC2(), joinState.getEdge().getrCopied(),
						currState.getEdge().getRreal(), joinState.getEdge().getRreal());

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();

				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getRreal().getR().size() < joinState.getEdge().getrCopied().getR().size()) {
					osHashJoinRC2(currState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
							currState.getEdge().getrCopied(), joinState.getEdge().getRreal());
				} else {
					soHashJoinRC2(joinState.getEdge().getrCopied(), currState.getEdge().getRreal(),
							joinState.getEdge().getRreal(), currState.getEdge().getrCopied());
				}
				// osHashJoinRC2(currState.getEdge().getRreal(),joinState.getEdge().getrCopied()
				// ,
				// currState.getEdge().getrCopied(),joinState.getEdge().getRreal());

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (currState.getEdge().getrCopied().getR().size() < joinState.getEdge().getrCopied().getR().size()) {
					osHashJoinRC2(currState.getEdge().getrCopied(), joinState.getEdge().getrCopied(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				} else {
					soHashJoinRC2(joinState.getEdge().getrCopied(), currState.getEdge().getrCopied(),
							joinState.getEdge().getRreal(), currState.getEdge().getRreal());
				}

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

		}
		if (checker) {
			checker = false;

		} else {
			stop = 1;
		}
	}

	/////////////////////// ######################################################################////////////////////////////////////////

	private void incrementalOOJoinStage2(AutomataState currState, AutomataState joinState) {

		if (joinState.getEdge().getRreal().getR().isEmpty() && joinState.getEdge().getrCopied().getR().isEmpty()) { /// the
																													/// use
																													/// the
																													/// both
																													/// C
																													/// and
																													/// put
																													/// it
																													/// in
																													/// Rreal
																													/// of
																													/// both

			/// first check if the r is empty or ecopied is emptied for the
			/// currstate

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
				// joinState.getRule().getC2(), currState.getEdge().getRreal(),
				// joinState.getEdge().getRreal());

				if (currState.getRule().getC2().valueSize() < joinState.getRule().getC2().valueSize()) {
					this.ooHashJoinCC(currState.getRule().getC2(), joinState.getRule().getC2(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				} else {
					this.ooHashJoinCC(joinState.getRule().getC2(), currState.getRule().getC2(),
							joinState.getEdge().getRreal(), currState.getEdge().getRreal());
				}

				// this.ooHashJoinCC(currState.getRule().getC2(),
				// joinState.getRule().getC2(), currState.getEdge().getRreal(),
				// joinState.getEdge().getRreal());

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				// this.osHashJoinRC(null, null, null, null);
				this.ooHashJoinRC(joinState.getRule().getC2(), currState.getEdge().getRreal(),
						joinState.getEdge().getRreal(), currState.getEdge().getrCopied());
				if (checker) {

					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {
				this.ooHashJoinRC(joinState.getRule().getC2(), currState.getEdge().getrCopied(),
						joinState.getEdge().getRreal(), currState.getEdge().getRreal());

				if (checker) {

					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
			// joinState.getRule().getC2(), currState.getEdge().getRreal(),
			// joinState.getEdge().getRreal());

		} else if (!joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) {
			// use Real
			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				this.ooHashJoinRC(currState.getRule().getC2(), joinState.getEdge().getRreal(),
						currState.getEdge().getRreal(), joinState.getEdge().getrCopied());

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				if (joinState.getEdge().getRreal().getR().valueSize() < currState.getEdge().getRreal().getR()
						.valueSize()) {
					ooHashJoinRC2(joinState.getEdge().getRreal(), currState.getEdge().getRreal(),
							joinState.getEdge().getrCopied(), currState.getEdge().getrCopied());
				} else {
					ooHashJoinRC2(currState.getEdge().getRreal(), joinState.getEdge().getRreal(),
							joinState.getEdge().getrCopied(), currState.getEdge().getrCopied());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (joinState.getEdge().getRreal().getR().valueSize() < currState.getEdge().getrCopied().getR()
						.valueSize()) {
					ooHashJoinRC2(joinState.getEdge().getRreal(), currState.getEdge().getrCopied(),
							joinState.getEdge().getrCopied(), currState.getEdge().getRreal());
				} else {
					ooHashJoinRC2(currState.getEdge().getrCopied(), joinState.getEdge().getRreal(),
							currState.getEdge().getRreal(), joinState.getEdge().getrCopied());
				}

				if (checker) {
					joinState.getEdge().getRreal().getR().clear();
					joinState.getEdge().getRreal().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
			// currState.getEdge().getRreal());

			// if(checker){
			// joinState.getEdge().getRreal().getR().clear();
			// joinState.getEdge().getRreal().getrIndex().clear();
			// }

		} else if (joinState.getEdge().getRreal().getR().isEmpty()
				&& !joinState.getEdge().getrCopied().getR().isEmpty()) {

			if (currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {
				this.ooHashJoinRC(currState.getRule().getC2(), joinState.getEdge().getrCopied(),
						currState.getEdge().getRreal(), joinState.getEdge().getRreal());

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();

				}

			} else

			if (!currState.getEdge().getRreal().getR().isEmpty() && currState.getEdge().getrCopied().getR().isEmpty()) {

				if (joinState.getEdge().getrCopied().getR().valueSize() < currState.getEdge().getRreal().getR()
						.valueSize()) {
					ooHashJoinRC2(joinState.getEdge().getrCopied(), currState.getEdge().getRreal(),
							joinState.getEdge().getRreal(), currState.getEdge().getrCopied());
				} else {
					ooHashJoinRC2(currState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
							currState.getEdge().getrCopied(), joinState.getEdge().getRreal());
				}

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getRreal().getR().clear();
					currState.getEdge().getRreal().getrIndex().clear();

				}

			} else if (currState.getEdge().getRreal().getR().isEmpty()
					&& !currState.getEdge().getrCopied().getR().isEmpty()) {

				if (joinState.getEdge().getrCopied().getR().valueSize() < currState.getEdge().getrCopied().getR()
						.valueSize()) {
					ooHashJoinRC2(joinState.getEdge().getrCopied(), currState.getEdge().getrCopied(),
							joinState.getEdge().getRreal(), currState.getEdge().getRreal());
				} else {
					ooHashJoinRC2(currState.getEdge().getrCopied(), joinState.getEdge().getrCopied(),
							currState.getEdge().getRreal(), joinState.getEdge().getRreal());
				}

				if (checker) {
					joinState.getEdge().getrCopied().getR().clear();
					joinState.getEdge().getrCopied().getrIndex().clear();
					currState.getEdge().getrCopied().getR().clear();
					currState.getEdge().getrCopied().getrIndex().clear();

				}

			}

		}
		if (checker) {
			checker = false;

		} else {
			stop = 1;
		}

	}

	/////////////////////// ######################################################################////////////////////////////////////////
	/// s for current state
	private void osHashJoinCC(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2, MultiBidirectionalIndex _r1,
			MultiBidirectionalIndex _r2) {

		for (Long o : _c1.keySet()) {// change the order

			if (_c2.containsValue(o)) {
				checker = true;
				_r1.getR().putAll(o, _c1.get(o));
				long index = ++indexCount;
				Set<Long> val = _c1.get(o);
				for (long v : val)
					_r1.getrIndex().put(index, new SP(o, v));

				_r2.getR().put(_c2.getKey(o), o);
				_r2.getrIndex().put(index, new SP(_c2.getKey(o), o)); /// change
																		/// it
																		/// later

				/// get all the values of the with this key

			}

		}

	}

	private void osHashJoinCCStateful(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2,
			MultiBidirectionalIndex _r2) {

		for (Long o : _c1.keySet()) {// change the order

			if (_c2.containsValue(o)) {
				checker = true;
				// _r1.getR().putAll(o, _c1.get(o));
				long index = ++indexCount;
				// Set<Long> val=_c1.get(o);
				// for(long v:val)
				// _r1.getrIndex().put(index,new SP(o, v));

				_r2.getR().put(_c2.getKey(o), o);
				_r2.getrIndex().put(index, new SP(_c2.getKey(o), o)); /// change
																		/// it
																		/// later

				/// get all the values of the with this key

			}

		}

	}

	private void osHashJoinRC(MultiBiMap<Long, Long> _c1, MultiBidirectionalIndex _r2, MultiBidirectionalIndex _r4,
			MultiBidirectionalIndex _r3) {

		if (_c1.keySize() < _r2.getR().valueSize()) {

			for (long sub : _c1.keySet()) {

				if (_r2.getR().containsValue(sub)) {
					/// first get the index value from r2
					_r3.getR().put(_r2.getR().getKey(sub), sub);
					checker = true;

					SP sp = new SP(_r2.getR().getKey(sub), sub);
					long index = _r2.getrIndex().getKey(sp);

					_r3.getrIndex().put(index, sp);

					for (long val : _c1.get(sub)) {
						_r4.getR().put(sub, val);
						_r4.getrIndex().put(index, new SP(sub, val));
					}

				}

			}
		} else {

			for (long sub : _r2.getR().values()) {
				if (_c1.containsKey(sub)) {

					_r3.getR().put(_r2.getR().getKey(sub), sub);
					checker = true;
					SP sp = new SP(_r2.getR().getKey(sub), sub);
					long index = _r2.getrIndex().getKey(sp);
					_r3.getrIndex().put(index, sp);

					for (long val : _c1.get(sub)) {
						_r4.getR().put(sub, val);
						_r4.getrIndex().put(index, new SP(sub, val));
					}

				}

			}

		}

	}

	private void osHashJoinRC2(MultiBidirectionalIndex _c1, MultiBidirectionalIndex _r2, MultiBidirectionalIndex _r4,
			MultiBidirectionalIndex _r3) {

		for (long sub : _c1.getR().keySet()) {

			if (_r2.getR().containsValue(sub)) {
				/// first get the index value from r2
				_r3.getR().put(_r2.getR().getKey(sub), sub);
				checker = true;

				SP sp = new SP(_r2.getR().getKey(sub), sub);
				long index = _r2.getrIndex().getKey(sp);

				_r3.getrIndex().put(index, sp);
				index = _c1.getrIndex().getKey(new SP(sub, _c1.getR().getValue(sub)));
				for (long val : _c1.getR().get(sub)) {
					_r4.getR().put(sub, val);
					_r4.getrIndex().put(index, new SP(sub, val));
				}

			}

		}

	}

	/// o for current state
	private void soHashJoinCC(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2, MultiBidirectionalIndex _r1,
			MultiBidirectionalIndex _r2) {

		for (Long o : _c1.values()) {// change the order

			if (_c2.containsKey(o)) {
				checker = true;

				_r1.getR().put(_c1.getKey(o), o);
				long index = ++indexCount;

				_r1.getrIndex().put(index, new SP(_c1.getKey(o), o));

				Set<Long> val = _c2.get(o);
				for (long v : val) {
					_r2.getR().put(o, v);
					_r2.getrIndex().put(index, new SP(o, v));
				}

				/// get all the values of the with this key

			}

		}

	}

	private void soHashJoinCCStateful(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2,
			MultiBidirectionalIndex _r2) {

		for (Long o : _c1.values()) {// change the order

			if (_c2.containsKey(o)) {
				checker = true;

				// _r1.getR().put(_c1.getKey(o), o);
				long index = ++indexCount;

				// _r1.getrIndex().put(index,new SP(_c1.getKey(o), o));

				Set<Long> val = _c2.get(o);
				for (long v : val) {
					_r2.getR().put(o, v);
					_r2.getrIndex().put(index, new SP(o, v));
				}

				/// get all the values of the with this key

			}

		}

	}

	private void soHashJoinRC(MultiBiMap<Long, Long> _c1, MultiBidirectionalIndex _r2, MultiBidirectionalIndex _r3,
			MultiBidirectionalIndex _r4) {

		if (_c1.size() < _r2.getR().size()) {

			for (long sub : _c1.values()) {

				if (_r2.getR().containsKey(sub)) {
					checker = true;
					/// first get the index value from r2
					long index = _r2.getrIndex().getKey(new SP(sub, _r2.getR().getValue(sub)));
					for (long val : _r2.getR().get(sub)) {
						_r4.getR().put(sub, val);
						_r4.getrIndex().put(index, new SP(sub, val));
					}

					_r3.getR().put(_c1.getKey(sub), sub);

					_r3.getrIndex().put(index, new SP(_c1.getKey(sub), sub));

				}

			}
		} else {

			for (long sub : _r2.getR().keySet()) {
				if (_c1.containsValue(sub)) {

					checker = true;
					/// first get the index value from r2
					long index = _r2.getrIndex().getKey(new SP(sub, _r2.getR().getValue(sub)));
					for (long val : _r2.getR().get(sub)) {
						_r4.getR().put(sub, val);
						_r4.getrIndex().put(index, new SP(sub, val));
					}

					_r3.getR().put(_c1.getKey(sub), sub);

					_r3.getrIndex().put(index, new SP(_c1.getKey(sub), sub));

				}
			}

		}

	}

	private void soHashJoinRC2(MultiBidirectionalIndex _c1, MultiBidirectionalIndex _r2, MultiBidirectionalIndex _r3,
			MultiBidirectionalIndex _r4) {

		for (long sub : _c1.getR().values()) {

			if (_r2.getR().containsKey(sub)) {
				checker = true;
				/// first get the index value from r2
				long index = _r2.getrIndex().getKey(new SP(sub, _r2.getR().getValue(sub)));
				for (long val : _r2.getR().get(sub)) {
					_r4.getR().put(sub, val);
					_r4.getrIndex().put(index, new SP(sub, val));
				}

				SP sp = new SP(_c1.getR().getKey(sub), sub);

				_r3.getR().put(sp.getSub(), sub);

				index = _c1.getrIndex().getKey(sp);

				_r3.getrIndex().put(index, sp);

			}

		}

	}

	/////////////////////// ######################################################################////////////////////////////////////////

	private void ooHashJoinCC(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2, MultiBidirectionalIndex _r1,
			MultiBidirectionalIndex _r2) {

		for (Long obj : _c1.values()) {
			if (_c2.containsValue(obj)) {

				checker = true;
				_r1.getR().put(_c1.getKey(obj), obj);
				long index = ++indexCount;

				_r1.getrIndex().put(index, new SP(_c1.getKey(obj), obj));

				_r2.getR().put(_c2.getKey(obj), obj);

				_r2.getrIndex().put(index, new SP(_c2.getKey(obj), obj));

			}

		}
	}

	private void ooHashJoinCCStateful(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2,
			MultiBidirectionalIndex _r2) {

		for (Long obj : _c1.values()) {
			if (_c2.containsValue(obj)) {

				checker = true;

				long index = ++indexCount;

				_r2.getR().put(_c2.getKey(obj), obj);

				_r2.getrIndex().put(index, new SP(_c2.getKey(obj), obj));

			}

		}
	}

	private void ooHashJoinRC(MultiBiMap<Long, Long> _c1, MultiBidirectionalIndex _r2, MultiBidirectionalIndex _r3,
			MultiBidirectionalIndex _r4) {

		if (_c1.valueSize() < _r2.getR().valueSize()) {

			for (long obj : _c1.values()) {
				if (_r2.getR().containsValue(obj)) {

					checker = true;
					/// first get the index from the _r2
					long index = _r2.getrIndex().getKey(new SP(_r2.getR().getKey(obj), obj));

					_r3.getR().put(_c1.getKey(obj), obj);
					_r3.getrIndex().put(index, new SP(_c1.getKey(obj), obj));

					_r4.getR().put(_r2.getR().getKey(obj), obj);
					_r4.getrIndex().put(index, new SP(_r2.getR().getKey(obj), obj));

				}

			}

		} else {

			for (long obj : _r2.getR().values()) {
				if (_c1.containsValue(obj)) {

					checker = true;
					/// first get the index from the _r2
					long index = _r2.getrIndex().getKey(new SP(_r2.getR().getKey(obj), obj));

					_r3.getR().put(_c1.getKey(obj), obj);
					_r3.getrIndex().put(index, new SP(_c1.getKey(obj), obj));

					_r4.getR().put(_r2.getR().getKey(obj), obj);
					_r4.getrIndex().put(index, new SP(_r2.getR().getKey(obj), obj));

				}

			}

		}

	}

	private void ooHashJoinRC2(MultiBidirectionalIndex _c1, MultiBidirectionalIndex _r2, MultiBidirectionalIndex _r3,
			MultiBidirectionalIndex _r4) {

		for (long obj : _c1.getR().values()) {
			if (_r2.getR().containsValue(obj)) {

				checker = true;
				/// first get the index from the _r2
				SP sp1 = new SP(_c1.getR().getKey(obj), obj);

				long index = _c1.getrIndex().getKey(sp1);

				_r3.getR().put(sp1.getSub(), obj);
				_r3.getrIndex().put(index, sp1);

				SP sp = new SP(_r2.getR().getKey(obj), obj);
				index = _r2.getrIndex().getKey(sp);

				_r4.getR().put(sp.getSub(), obj);
				_r4.getrIndex().put(index, sp);

			}

		}

	}

	private void complexFilterforR(MultiBiMap<Long, Long> _c1, MultiBidirectionalIndex _r2, MultiBidirectionalIndex _r3,
			DictionaryOpImpl dic, String oper, int dataType) {
		// first entry is the statefull map
		for (Long op : _c1.values()) {
			for (Long op2 : _r2.getR().values()) {

				if (this.compLiteral.evaluateEventType(dic.getLiteralAdaptive(op), dic.getLiteralAdaptive(op2), oper,
						dataType, 1)) {
					checker = true;

					SP sp = new SP(_r2.getR().getKey(op2), op2);

					long index = _r2.getrIndex().getKey(sp);
					_r3.getR().put(sp.getSub(), op2);
					_r3.getrIndex().put(index, sp);
				}

			}

		}

	}

	private void complexFilterforC(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2, MultiBidirectionalIndex _r3,
			DictionaryOpImpl dic, String oper, int dataType) {
		for (Long op : _c1.values()) {
			for (Long op2 : _c2.values()) {

				if (this.compLiteral.evaluateEventType(dic.getLiteralAdaptive(op), dic.getLiteralAdaptive(op2), oper,
						dataType, 1)) {
					checker = true;

					SP sp = new SP(_c2.getKey(op2), op2);

					long index = ++this.indexCount;
					_r3.getR().put(sp.getSub(), op2);
					_r3.getrIndex().put(index, sp);
				}

			}

		}

	}

	private void complexFilterJoin(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2, MultiBidirectionalIndex _r2,
			DictionaryOpImpl dic, String oper, int dataType) {

		//// go around the both loops

		for (Long op : _c1.values()) {

			for (Long op2 : _c2.values()) {
				if (this.compLiteral.evaluateEventType(dic.getLiteralAdaptive(op), dic.getLiteralAdaptive(op2), oper,
						dataType, 1)) {
					checker = true;

					SP sp = new SP(_r2.getR().getKey(op2), op2);
					long index;
					if (_r2.getrIndex().isEmpty()) {
						index = ++indexCount;
					} else {
						index = _r2.getrIndex().getKey(sp);
					}

					_r2.getR().put(sp.getSub(), op2);
					_r2.getrIndex().put(index, sp);

				}

			}

		}

	}

	private void ooNonequiHashJoin(MultiBiMap<Long, Long> _c1, MultiBiMap<Long, Long> _c2,
			MultiBidirectionalIndex _r2) {

		for (Long obj : _c1.values()) {
			if (!_c2.containsValue(obj)) {

				checker = true;

				long index = ++indexCount;

				_r2.getR().put(_c2.getKey(obj), obj);

				_r2.getrIndex().put(index, new SP(_c2.getKey(obj), obj));

			}

		}

	}

}
