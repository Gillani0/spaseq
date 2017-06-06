/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomst.graph.processing;

import java.util.Map;
import java.util.Objects;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecom.stet.cep.events.MappedEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.graph.automata.AutomataState;
import edu.telecomstet.cep.rulesmodel.Rule;

/**
 *
 * @author sydgillani
 */
public class GraphPruning implements GraphPruningAPI {

	long insertTimer = 0;
	int i = 0;
	// private ArrayList<AutomataState> startStates= new ArrayList<>();
	// private ArrayList<AutomataState> chainStates= new ArrayList<>();
	// private ArrayList<AutomataState> bridgeStates= new ArrayList<>();
	private TPJoinAutomata _ga = new TPJoinAutomata();
	private int change;
	private long id = 0;

	/**
	 *
	 * @param automata
	 * @param inputGraph
	 * @param dic
	 * @param kb
	 */
	// @Override
	public boolean run(Automata automata, GraphEvent inputGraph, DictionaryOpImpl dic,
			Map<RunStateMap, MultiBidirectionalIndex> c, Map<KBindex, MultiBiMap<Long, SP>> kb, int r, int sn) {

		change = 0;

		i++;

		for (AutomataState s : automata.getStates()) { /// Sequential Pruning
														/// for each triple
														/// pattern

			// }

			if (!s.getRule().getC2().isEmpty()) {
				s.getRule().getC2().clear();
			}

			for (MappedEvent e : inputGraph.getMapped()) {

				if (!(s.getRule().getPredicate().isProjection())
						&& !(s.getRule().getPredicate().getMappedValue() == e.getProperties())) {
					continue;
				} else if (!(s.getRule().getSubject().isProjection())
						&& !Objects.equals(s.getRule().getSubject().getMappedValue(), e.getSubject())) {
					continue;
				} else if (!(s.getRule().getObject().isProjection()) && !pushAtomicFilter(s.getRule(), e, dic)) {
					continue;
				}

				/// put it in the incremental dictionary

				id++;

				change = 1;

				s.getRule().getC2().put(e.getSubject(), e.getObject());

				s.setStateDataType(e.getObjectDataType());

				/// incase of filtertype = 2 and filter operand is >,<, >=, <=
				/// put the values into another table which would be sorted

			}

			/// over here do the sorting on the other table, which is the
			/// smallest one? or just do the fucking sorting
			//
		}

		if (change == 1) {

			return _ga.run(automata, dic, c, kb, r, sn);
		}
		return false;

		// return _ga.run(automata, dic, c, sn, sn)
	}

	public void reArrangeAutomta(Automata automata) {

		/// rearrange th states according to the cardinality of the pruned set
		/// Carefull in rearranging as you need to first divide it into three
		/// types of the automta
		/// during rearranging keep an eye on the join ID as well, beacuse it
		/// will change with the rearrangement of states

		//
		// Collections.sort(automata.getStates(), new
		// Comparator<AutomataState>(){
		// @Override
		// public int compare(AutomataState e1, AutomataState e2){
		//
		// Integer
		// c=getSortingVal(e1.getRule().getC().keySize(),e1.getEdge().getR().keySize());
		// Integer
		// o=getSortingVal(e2.getRule().getC().keySize(),e2.getEdge().getR().keySize());
		// if(c==0 && o!=0){
		// return o;
		// }else if(o==0 && c!=0){
		// return c;
		// }
		//
		// return c.compareTo(o);
		// }
		// });
		//

		/*
		 * this.chainStates.stream().sorted((e1,e2)->{ Integer
		 * c=getSortingVal(e1.getRule().getTableSOMapped().size(),e1.getEdge().
		 * getTableSOMapped().size()); Integer
		 * o=getSortingVal(e2.getRule().getTableSOMapped().size(),e2.getEdge().
		 * getTableSOMapped().size()); return c.compareTo(o); });
		 * 
		 * 
		 * for(AutomataState cs:this.chainStates){ ///get the first state and
		 * finds its dependability for(Dependability d:
		 * cs.getRule().getDepends()){ List<AutomataState> state=
		 * chainStates.stream().filter(x->x.getRule().getId()==d.
		 * getDependabilty_id()).collect(Collectors.toList());
		 * if(!state.isEmpty()) d.setDependabilty_id(state.get(0).getStateId());
		 * 
		 * }
		 * 
		 * 
		 * if(cs.getRule().getFilterType() == 2 && !cs.getRule().isKb_flag()){
		 * 
		 * 
		 * 
		 * List<AutomataState> state=
		 * chainStates.stream().filter(x->x.getRule().getId()==cs.getRule().
		 * getFilterRuleID()).collect(Collectors.toList()); // if(
		 * s.getRule().getFilterRuleID()==this.automta.getStates().get(i).
		 * getRule().getId()){
		 * 
		 * if(!state.isEmpty())
		 * cs.getRule().setFilterRuleID(state.get(0).getStateId()); // break; //
		 * } }
		 * 
		 * 
		 * 
		 * }
		 */
		// automata.getStates().clear();

	}

	/*
	 * private Long mappingSubIncremental(Long val,DictionaryOpImpl dic){ if(
	 * dic.getResourceAdaptive(val)!=null){ return
	 * dic.addResourceIncremental(dic.getResourceAdaptive(val)); }else
	 * if(dic.getBnodeAdaptive(val)!=null){ return
	 * dic.addBnodeIncremental(dic.getBnodeAdaptive(val)); }
	 * 
	 * 
	 * return null; }
	 * 
	 * 
	 * private Long mappingObjIncremental(Long val,DictionaryOpImpl dic){
	 * 
	 * if(dic.getLiteralAdaptive(val)!=null){ return
	 * dic.addLiteralIncremental(dic.getLiteralAdaptive(val)); }else if(
	 * dic.getResourceAdaptive(val)!=null){ return
	 * dic.addResourceIncremental(dic.getResourceAdaptive(val)); }else
	 * if(dic.getBnodeAdaptive(val)!=null){ return
	 * dic.addBnodeIncremental(dic.getBnodeAdaptive(val)); }
	 * 
	 * 
	 * return null; }
	 * 
	 */

	/**
	 *
	 * @param r
	 * @param e
	 * @return
	 */

	@Override
	public boolean pushAtomicFilter(Rule r, MappedEvent e, DictionaryOpImpl dic) {

		if (!r.isFilterFlag() && r.getObject().isProjection()) {
			return true;
		} else if

		(!r.isFilterFlag() && !r.getObject().isProjection() && r.getObject().getMappedValue() == e.getObject()) {
			return true;
		}

		if (r.isFilterFlag() && r.getFilterType() == 1 && r.getFilterType1Operator().equals("=")
				&& r.getObject().getMappedValue() == e.getObject()) {
			return true;

		} else if (r.isFilterFlag() && r.getFilterType() == 1 && r.getFilterType1Operator().equals("!=")
				&& r.getObject().getMappedValue() != e.getObject()) {

			return true;
		} else if (r.isFilterFlag() && r.getFilterType() == 1 && atomicFilterCompariosn(r, e, dic)) {
			return true;
		}

		return false;
	}

	/**
	 *
	 * @param r
	 * @param e
	 * @return
	 */
	@Override
	public boolean atomicFilterCompariosn(Rule r, MappedEvent e, DictionaryOpImpl dic) {

		if (r.getObject().getObjectType() == 0) {

			final int oInteger2;

			/// convert it to Integer
			try {
				oInteger2 = Integer.parseInt((dic.getLiteralAdaptive(e.getObject()).getValue().toString()));

			} catch (Exception ex) {
				return false;
			}

			/// need to parse it into integer
			if (r.getFilterType1Operator().equals(">") && ((Integer) ((r.getObject().getValue())) < oInteger2)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<") && (Integer) ((r.getObject().getValue())) > oInteger2) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=") && (Integer) ((r.getObject().getValue())) >= oInteger2) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=") && (Integer) ((r.getObject().getValue())) <= oInteger2) {

				// System.out.println(((Literal)
				// (r.getObject().getValue())).getValue() + " " + "" +
				// oInteger2);

				return true;
			}

		} else if (r.getObject().getObjectType() == 1) {
			if (r.getFilterType1Operator().equals(">") && (Float) ((r.getObject().getValue())) < (Float) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;
			} else if (r.getFilterType1Operator().equals("<") && (Float) ((r.getObject().getValue())) > (Float) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=") && (Float) ((r.getObject().getValue())) >= (Float) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=") && (Float) ((r.getObject().getValue())) <= (Float) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;
			}

		} else if (r.getObject().getObjectType() == 4) {

			final double aDouble;
			try {
				aDouble = Double.parseDouble(dic.getLiteralAdaptive(e.getObject()).getValue().toString());
				// System.out.println(aDouble);
			} catch (Exception ex) {
				return false;
			}

			if (r.getFilterType1Operator().equals(">") && (Double) ((r.getObject().getValue())) < aDouble) {
				return true;
			} else if (r.getFilterType1Operator().equals("<") && (Double) ((r.getObject().getValue())) > aDouble) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=") && (Double) ((r.getObject().getValue())) >= aDouble) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=") && (Double) ((r.getObject().getValue())) <= aDouble) {
				return true;
			}
		} else if (r.getObject().getObjectType() == 6) {
			if (r.getFilterType1Operator().equals(">") && (Long) ((r.getObject().getValue())) < (Long) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;
			} else if (r.getFilterType1Operator().equals("<") && (Double) ((r.getObject().getValue())) > (Long) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=") && (Double) ((r.getObject().getValue())) >= (Long) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=") && (Double) ((r.getObject().getValue())) <= (Long) (dic
					.getLiteralAdaptive(e.getObject()).getValue())) {
				return true;
			}
		}
		return false;

	}

}
