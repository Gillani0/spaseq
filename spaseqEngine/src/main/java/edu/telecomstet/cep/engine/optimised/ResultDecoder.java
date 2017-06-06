package edu.telecomstet.cep.engine.optimised;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Resource;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecomst.graph.processing.ConstrcutCaluse;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpApi;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.knowledgebase.KBRule;
import edu.telecomstet.cep.nfahelpers2.NFA;
import edu.telecomstet.cep.nfahelpers2.State;
import edu.telecomstet.cep.rulesmodel.Rule;

public class ResultDecoder {
	private final ConstrcutCaluse constFunc;

	private final Map<RunStateMap, MultiBidirectionalIndex> _statefullcache;

	private final Map<KBindex, MultiBiMap<Long, SP>> _kbstatefullcache;

	private final NFA nfa;

	private final DictionaryOpApi _dictImpl;

	private final BlockingQueue<String> resultqueue;

	private final Set<String> resultSet;

	public ResultDecoder(Map<RunStateMap, MultiBidirectionalIndex> statecache,
			Map<KBindex, MultiBiMap<Long, SP>> kbcache, ConstrcutCaluse constf, NFA n, DictionaryOpImpl dic,
			BlockingQueue<String> rqueue, Set<String> rset) {
		this.constFunc = constf;
		this._statefullcache = statecache;
		this._kbstatefullcache = kbcache;
		this.nfa = n;
		this._dictImpl = dic;
		this.resultqueue = rqueue;
		this.resultSet = rset;
	}

	public void outputMatches(GraphEvent e, RunOptimised r) {
		if (this.constFunc != null) {
			// this.constFunc.constrcutGraph(_statefullcache, r, _dictImpl);
		} else {
			this.outputSelectQuery(e, r);
		}

	}

	private void outputSelectQuery(GraphEvent e, RunOptimised r) {

		// System.out.println("############## Run ID
		// "+r.getId()+"##########################");

		this.resultSet.clear();

		// String output = "";
		int ct = 0;
		for (int i = 0; i < this.nfa.getStates().length; i++) {

			// System.out.println("############ State
			// "+i+"############################");
			// TODO remove all the states properly, and get the data from all
			// the states

			State workingState = nfa.getStates()[i];

			if (workingState.isManager()) {

				for (State st : workingState.getSubstates().values()) {

					if (st.getStateStatus().contains(r.getId())) {

						for (int j = 0; j < st.getNfaData().getAutomta().getStates().size(); j++) {

							this.outputManagerState(st, st.getNfaData().getAutomta().getStates().get(j).getRule(), r, j,
									ct, e.getTimeStamp());
						}

					}

				}

				// return;
			} else {

				for (int j = 0; j < workingState.getNfaData().getAutomta().getStates().size(); j++) {

					/**
					 * Check if its the manager or not. In case of manager state
					 * get the NFAauotmat from the Substates
					 * 
					 */

					Rule outRule = workingState.getNfaData().getAutomta().getStates().get(j).getRule();

					if (outRule.isSelect()) {

						MultiBidirectionalIndex result = this._statefullcache
								.get(new RunStateMap(workingState.getOrder(), r.getId(), j));

						if (workingState.isNegation() || workingState.isOptional() && result == null) {
							continue;
						}

						// result.getR().size();

						// System.out.println(result.getR().size());
						// System.out.println(result.getrIndex().size());

						for (long key : result.getrIndex().keySet()) {

							Set<SP> sp = result.getrIndex().get(key);

							for (SP out : sp) {

								// its either subject or object
								if (outRule.isSelectSub()) {
									Resource res = _dictImpl.getResourceAdaptive(out.getSub());
									if (res == null) {
										// output = "?" +
										// outRule.getSubject().getProjection()
										// + " "
										// +
										// _dictImpl.getBnodeAdaptive(out.getSub())
										// + " ";
										if (!resultSet.contains(outRule.getSubject().getProjection() + " "
												+ _dictImpl.getBnodeAdaptive(out.getSub()))) {

											this.resultqueue.add("?" + outRule.getSubject().getProjection() + " "
													+ _dictImpl.getBnodeAdaptive(out.getSub()) + "\n");
											resultSet.add(outRule.getSubject().getProjection() + " "
													+ _dictImpl.getBnodeAdaptive(out.getSub()));
										}

									} else {
										// output = "?" +
										// outRule.getSubject().getProjection()
										// + " " + res + " ";

										if (!resultSet.contains(outRule.getSubject().getProjection() + " " + res)) {

											this.resultqueue
													.add("?" + outRule.getSubject().getProjection() + " " + res + "\n");
											resultSet.add(outRule.getSubject().getProjection() + " " + res);
										}

									}
								}

								if (outRule.isSelectObj()) {
									Literal lg = _dictImpl.getLiteralAdaptive(out.getPred());
									if (lg != null) {

										if (!resultSet.contains(
												outRule.getObject().getProjection() + " " + lg.getValue().toString())) {
											this.resultqueue.add("?" + outRule.getObject().getProjection() + " "
													+ lg.getValue().toString() + "\n");
											resultSet.add(outRule.getObject().getProjection() + " "
													+ lg.getValue().toString());
										}

									} else {
										Resource res = _dictImpl.getResourceAdaptive(out.getPred());
										if (res == null) {
											// output = output + "?" +
											// outRule.getObject().getProjection()
											// + " "
											// +
											// _dictImpl.getBnodeAdaptive(out.getPred())
											// + "\n";

											if (!resultSet.contains(outRule.getObject().getProjection() + " "
													+ _dictImpl.getBnodeAdaptive(out.getPred()))) {
												this.resultqueue.add("?" + outRule.getObject().getProjection() + " "

														+ _dictImpl.getBnodeAdaptive(out.getPred()) + "\n");

												resultSet.add(outRule.getObject().getProjection() + " "

														+ _dictImpl.getBnodeAdaptive(out.getPred()));
											}

										} else {
											// output = output + "?" +
											// outRule.getObject().getProjection()
											// + " " + res
											// + " \n";

											if (!resultSet.contains(outRule.getObject().getProjection() + " " + res)) {
												this.resultqueue.add(
														"?" + outRule.getObject().getProjection() + " " + res + "\n");
												resultSet.add(outRule.getObject().getProjection() + " " + res);

											}
										}
									}
								}

							}

						}
						// if (ct == 0) {
						// ct = 1;
						// output = output + " [" + r.getLifeTimeBegin() + "," +
						// e.getTimeStamp() + "] ";
						// }

					}

					/**
					 * Add the KB mappings found and use it for the output
					 */

					// first check if the state contains the KB graph or not

					if (workingState.getNfaData().getAutomta().getContainsKB() == 1) {

						// / loop though the kbcache and get the required
						// mappings
						// / from it
						// / get the kblist which has the isSelect option set to
						// true

						List<KBRule> krules = workingState.getNfaData().getAutomta().get_kbRuleList2().stream()
								.filter(x -> x.isSelect()).collect(Collectors.toList());

						if (!krules.isEmpty()) {
							MultiBiMap<Long, SP> kbresult = this._kbstatefullcache
									.get(new KBindex(r.getId(), workingState.getOrder()));

							for (KBRule out : krules) {
								for (Map.Entry<Long, SP> entry : kbresult.entries()) {

									if (out.isSelectSub() && entry.getKey() == out.getPredicate().getMappedValue()) {
										Resource res = _dictImpl.getResourcePersistant(entry.getValue().getSub());
										if (res == null) {
											// output = "?" +
											// out.getSubject().getProjection()
											// + " "
											// +
											// _dictImpl.getBnodePersistant(entry.getValue().getSub())
											// + " ";
											//
											this.resultqueue.add("?" + out.getSubject().getProjection() + " "
													+ _dictImpl.getBnodePersistant(entry.getValue().getSub()) + " ");

										} else {
											// output = "?" +
											// out.getSubject().getProjection()
											// + " " + res + " ";

											this.resultqueue
													.add("?" + out.getSubject().getProjection() + " " + res + "\n");
										}
									}
									if (out.isSelectObj() && entry.getKey() == out.getPredicate().getMappedValue()) {
										Literal lg = _dictImpl.getLiteralPersistant(entry.getValue().getPred());
										if (lg != null) {

											// output = output + "?" +
											// out.getObject().getProjection() +
											// " "
											// + lg.getValue().toString() +
											// "\n";
											this.resultqueue.add("?" + out.getObject().getProjection() + " "
													+ lg.getValue().toString() + "\n");

										} else {
											Resource res = _dictImpl.getResourcePersistant(entry.getValue().getPred());
											if (res == null) {
												// output = output + "?" +
												// outRule.getObject().getProjection()
												// + " "
												// +
												// _dictImpl.getBnodePersistant(entry.getValue().getPred())
												// + "\n";

												this.resultqueue.add("?" + outRule.getObject().getProjection() + " "
														+ _dictImpl.getBnodePersistant(entry.getValue().getPred())
														+ "\n");

											} else {
												// output = output + "?" +
												// outRule.getObject().getProjection()
												// + " " + res
												// + " \n";

												this.resultqueue.add(
														"?" + outRule.getObject().getProjection() + " " + res + " \n");
											}
										}
									}
								}
								// this.resultqueue.add(output);
							}

						}

					}

				}
			}

			// System.out.println("########################################");

			// ///// get the results

		}

		// if (ct == 0) {
		// ct = 1;
		// output = output + " [" + r.getLifeTimeBegin() + "," +
		// e.getTimeStamp() + "] ";

		this.resultqueue.add("[" + r.getLifeTimeBegin() + "," + e.getTimeStamp() + "]\n");

		// System.out.println();
	}

	private void outputManagerState(State s, Rule outRule, RunOptimised r, int j, int ct, long timestmap) {
		if (outRule.isSelect()) {

			MultiBidirectionalIndex result = this._statefullcache.get(new RunStateMap(s.getOrder(), r.getId(), j));

			for (long key : result.getrIndex().keySet()) {

				Set<SP> sp = result.getrIndex().get(key);

				for (SP out : sp) {

					// its either subject or object
					if (outRule.isSelectSub()) {
						Resource res = _dictImpl.getResourceAdaptive(out.getSub());
						if (res == null) {
							// output = "?" +
							// outRule.getSubject().getProjection() + " "
							// + _dictImpl.getBnodeAdaptive(out.getSub()) + " ";

							this.resultqueue.add("?" + outRule.getSubject().getProjection() + " "
									+ _dictImpl.getBnodeAdaptive(out.getSub()) + "\n");

						} else {
							// output = "?" +
							// outRule.getSubject().getProjection() + " " + res
							// + " ";
							this.resultqueue.add("?" + outRule.getSubject().getProjection() + " " + res + "\n");
						}
					}

					if (outRule.isSelectObj()) {
						Literal lg = _dictImpl.getLiteralAdaptive(out.getPred());
						if (lg != null) {

							// output = output + "?" +
							// outRule.getObject().getProjection() + " " +
							// lg.getValue().toString()
							// + "\n";
							this.resultqueue.add(
									"?" + outRule.getObject().getProjection() + " " + lg.getValue().toString() + "\n");

						} else {
							Resource res = _dictImpl.getResourceAdaptive(out.getPred());
							if (res == null) {
								// output = output + "?" +
								// outRule.getObject().getProjection() + " "
								// + _dictImpl.getBnodeAdaptive(out.getPred()) +
								// "\n";

								this.resultqueue.add("?" + outRule.getObject().getProjection() + " "
										+ _dictImpl.getBnodeAdaptive(out.getPred()) + "\n");

							} else {
								// output = output + "?" +
								// outRule.getObject().getProjection() + " " +
								// res + " \n";
								this.resultqueue.add("?" + outRule.getObject().getProjection() + " " + res + " \n");

							}
						}
					}

				}

			}
			// if (ct == 0) {
			// ct = 1;
			// output = output + " [" + timestmap + "," + r.getLifeTimeBegin() +
			// "] ";
			// }

			// this.resultqueue.add(" [" + timestmap + "," +
			// r.getLifeTimeBegin() + "] \n ");

		}

		/**
		 * Add the KB mappings found and use it for the output
		 */

		// first check if the state contains the KB graph or not

		if (s.getNfaData().getAutomta().getContainsKB() == 1) {

			// / loop though the kbcache and get the required mappings
			// / from it
			// / get the kblist which has the isSelect option set to true

			List<KBRule> krules = s.getNfaData().getAutomta().get_kbRuleList2().stream().filter(x -> x.isSelect())
					.collect(Collectors.toList());

			if (!krules.isEmpty()) {
				MultiBiMap<Long, SP> kbresult = this._kbstatefullcache.get(new KBindex(r.getId(), s.getOrder()));

				for (KBRule out : krules) {
					for (Map.Entry<Long, SP> entry : kbresult.entries()) {

						if (out.isSelectSub() && entry.getKey() == out.getPredicate().getMappedValue()) {
							Resource res = _dictImpl.getResourcePersistant(entry.getValue().getSub());
							if (res == null) {
								// output = "?" +
								// out.getSubject().getProjection() + " "
								// +
								// _dictImpl.getBnodePersistant(entry.getValue().getSub())
								// + " ";

								this.resultqueue.add("?" + out.getSubject().getProjection() + " "
										+ _dictImpl.getBnodePersistant(entry.getValue().getSub()) + "\n");

							} else {
								// output = "?" +
								// out.getSubject().getProjection() + " " + res
								// + " ";
								this.resultqueue.add("?" + out.getSubject().getProjection() + " " + res + "\n");

							}
						}
						if (out.isSelectObj() && entry.getKey() == out.getPredicate().getMappedValue()) {
							Literal lg = _dictImpl.getLiteralPersistant(entry.getValue().getPred());
							if (lg != null) {

								// output = output + "?" +
								// out.getObject().getProjection() + " " +
								// lg.getValue().toString()
								// + "\n";
								this.resultqueue.add(
										"?" + out.getObject().getProjection() + " " + lg.getValue().toString() + "\n");

							} else {
								Resource res = _dictImpl.getResourcePersistant(entry.getValue().getPred());
								if (res == null) {
									// output = output + "?" +
									// outRule.getObject().getProjection() + " "
									// +
									// _dictImpl.getBnodePersistant(entry.getValue().getPred())
									// + "\n";

									this.resultqueue.add("?" + outRule.getObject().getProjection() + " "
											+ _dictImpl.getBnodePersistant(entry.getValue().getPred()) + "\n");

								} else {
									// output = output + "?" +
									// outRule.getObject().getProjection() + " "
									// + res + " \n";

									this.resultqueue.add("?" + outRule.getObject().getProjection() + " " + res + " \n");
								}
							}
						}
					}
					// this.resultqueue.add(output);
				}

			}
		}
	}
}
