package edu.telecomstet.graph.processing;

import java.util.Collection;
import java.util.Objects;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import com.google.common.collect.Multimap;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.graph.automata.AutomataState;
import edu.telecomstet.cep.rulesmodel.Rule;

/**
 *
 * @author sydgillani
 */
public class SummaryGraphGenerator {

	// TODO: change it to one function and use the mulitthreading to process
	// each triple pattern with a thread for inserion of the objects
	/// Use a queue which will be a supplier to all the threads

	private int change = 0;

	public void summaryGraphGeneration(Automata a, Node[] iTriple, DictionaryOpImpl dic, long timeStamp,
			Multimap<Long, AutomataState> predmap) {
		// _predicate = dic.predicateTest((Resource)iTriple[1]);
		if (dic.predicateTest((Resource) iTriple[1]) != 0) { // genius, check if
																// the coming
																// predicate
			/// then iterate over the whole autonata and the

			// pruningTriples(a,dic.predicateTest((Resource)iTriple[1]),
			// iTriple,dic,timeStamp);
			/// long p=dic.predicateTest((Resource)iTriple[1]);
			purningtriples(predmap.get(dic.predicateTest((Resource) iTriple[1])), iTriple, dic, timeStamp);

		}

	}

	public void purningtriples(Collection<AutomataState> states, Node[] iTriple, DictionaryOpImpl dic, Long timeStamp) {

		/// Do the time stuff over here, remove the triples that are not in the
		/// window, may be slower over here, as you need to calculate the time
		/// for each and every one
		for (AutomataState s : states) {
			if (!(s.getRule().getSubject().isProjection()) && (dic.subjectTest((Resource) iTriple[0]) == 0 || !Objects
					.equals(s.getRule().getSubject().getMappedValue(), dic.subjectTest((Resource) iTriple[0])))) {
				continue;
			} else if (!(s.getRule().getObject().isProjection()) && !pushAtomicFilter(s.getRule(), iTriple, dic)) {

				/// first check the filter type and the operator on the filter
				/// Then if its = and !=, convert them into long and then
				/// compare it, otheriwse use the Literal value to compare it
				continue;
			}

			s.setChange(1);
			change = 1;
			// long sub=dic.addSubject(iTriple[0]);

			// long obj=dic.addObject(iTriple[2]);

			s.getRule().getC2().put(dic.addSubject(iTriple[0]), dic.addObject(iTriple[2]));

			// s.getRule().getTimeSOpairs().put(timeStamp, new SO(sub,obj));
			// System.out.println("Here ");

		}
	}

	public void pruningTriples(Automata automata, long _pred, Node[] iTriple, DictionaryOpImpl dic, long timeStamp) {
		for (AutomataState s : automata.getStates()) {
			if (!(s.getRule().getPredicate().getMappedValue() == _pred)) {
				continue;
			} else if (!(s.getRule().getSubject().isProjection()) && (dic.subjectTest((Resource) iTriple[0]) == 0
					|| !Objects.equals(s.getRule().getSubject().getMappedValue(),
							dic.subjectTest((Resource) iTriple[0])))) {
				continue;
			} else if (!(s.getRule().getObject().isProjection()) && !pushAtomicFilter(s.getRule(), iTriple, dic)) {
				continue;
				/// first check the filter type and the operator on the filter
				/// Then if its = and !=, convert them into long and then
				/// compare it, otheriwse use the Literal value to compare it

			}

			s.setChange(1);
			change = 1;
			// long sub=dic.addSubject(iTriple[0]);

			// long obj=dic.addObject(iTriple[2]);

			s.getRule().getC2().put(dic.addSubject(iTriple[0]), dic.addObject(iTriple[2]));

			// s.getRule().getTimeSOpairs().put(timeStamp, new SO(sub,obj));
			// s.setChange(1);

		}
	}

	public boolean pushAtomicFilter(Rule r, Node[] iTriple, DictionaryOpImpl dic) {
		if

		(!r.isFilterFlag() && !r.getObject().isProjection()
				&& r.getObject().getMappedValue() == dic.objectTest(iTriple[2])) {
			return true;
		}
		if (r.isFilterFlag() && r.getFilterType() == 1 && r.getFilterType1Operator().equals("=")
				&& r.getObject().getMappedValue() == dic.objectTest(iTriple[2])) {
			return true;
		} else if (r.isFilterFlag() && r.getFilterType() == 1 && r.getFilterType1Operator().equals("!=")
				&& r.getObject().getMappedValue() != dic.objectTest(iTriple[2])) {

			return true;
		} else if (r.isFilterFlag() && r.getFilterType() == 1 && !r.getFilterType1Operator().equals("!=")
				&& !r.getFilterType1Operator().equals("=") && atomicFilterCompariosn(r, (Literal) iTriple[2], dic)) {
			return true;
		}

		return false;
	}

	private boolean newatomicFilterComparison(Rule r, Literal obj, DictionaryOpImpl dic) {

		if (r.getObject().getObjectType() == 0) {
			final int oInteger;
			/// convert it to Integer
			try {
				oInteger = Integer.parseInt(obj.getValue().toString());
			} catch (Exception ex) {
				System.out.println("error in parsing the required data type, the results will not be correct");
				return false;
			}

			if (r.getFilterType1Operator().equals(">")
					&& ((Integer) ((Literal) (r.getObject().getValue())).getValue() < (Integer) (oInteger))) {
				return true;
			} else if (r.getFilterType1Operator().equals("<")
					&& (Integer) ((Literal) (r.getObject().getValue())).getValue() > (Integer) (oInteger)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=")
					&& (Integer) ((Literal) (r.getObject().getValue())).getValue() >= (Integer) (oInteger)) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=")
					&& (Integer) ((Literal) (r.getObject().getValue())).getValue() <= (Integer) (oInteger)) {
				return true;
			}

		}
		return false;
	}

	public boolean atomicFilterCompariosn(Rule r, Literal obj, DictionaryOpImpl dic) {

		if (r.getObject().getObjectType() == 0) {

			// System.out.println(obj.getValue().toString());
			final int oInteger;
			/// convert it to Integer
			try {
				oInteger = Integer.parseInt(obj.getValue().toString());
			} catch (Exception ex) {
				return false;
			}

			if (r.getFilterType1Operator().equals(">")
					&& ((Integer) ((Literal) (r.getObject().getValue())).getValue() < (Integer) (oInteger))) {
				return true;
			} else if (r.getFilterType1Operator().equals("<")
					&& (Integer) ((Literal) (r.getObject().getValue())).getValue() > (Integer) (oInteger)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=")
					&& (Integer) ((Literal) (r.getObject().getValue())).getValue() >= (Integer) (oInteger)) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=")
					&& (Integer) ((Literal) (r.getObject().getValue())).getValue() <= (Integer) (oInteger)) {
				return true;
			}

		} else if (r.getObject().getObjectType() == 1) {
			final float floatVal;
			try {
				floatVal = Float.valueOf(obj.getValue().toString().trim()).floatValue();
			} catch (Exception ex) {
				return false;
			}

			if (r.getFilterType1Operator().equals(">")
					&& (Float) ((Literal) (r.getObject().getValue())).getValue() < (Float) (floatVal)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<")
					&& (Float) ((Literal) (r.getObject().getValue())).getValue() > (Float) (floatVal)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=")
					&& (Float) ((Literal) (r.getObject().getValue())).getValue() >= (Float) (floatVal)) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=")
					&& (Float) ((Literal) (r.getObject().getValue())).getValue() <= (Float) (floatVal)) {
				return true;
			}

		} else if (r.getObject().getObjectType() == 4) {
			final double aDouble;
			try {
				aDouble = Double.parseDouble(obj.getValue().toString());
				// System.out.println(aDouble);
			} catch (Exception ex) {
				return false;
			}
			if (r.getFilterType1Operator().equals(">")
					&& (Double) ((Literal) (r.getObject().getValue())).getValue() < (Double) (aDouble)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<")
					&& (Double) ((Literal) (r.getObject().getValue())).getValue() > (Double) (aDouble)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=")
					&& (Double) ((Literal) (r.getObject().getValue())).getValue() >= (Double) (aDouble)) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=")
					&& (Double) ((Literal) (r.getObject().getValue())).getValue() <= (Double) (aDouble)) {
				return true;
			}
		} else if (r.getObject().getObjectType() == 6) {

			// 0: int, 1: float, 2: decimal, 3: DataTime, 4: Double, 5: string,
			// 6: Long

			final long olong;
			olong = Long.parseLong(obj.getValue().toString());

			if (r.getFilterType1Operator().equals(">")
					&& (Long) ((Literal) (r.getObject().getValue())).getValue() < (Long) (olong)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<")
					&& (Long) ((Literal) (r.getObject().getValue())).getValue() > (Long) (olong)) {
				return true;
			} else if (r.getFilterType1Operator().equals("<=")
					&& (Long) ((Literal) (r.getObject().getValue())).getValue() >= (Long) (olong)) {
				return true;

			} else if (r.getFilterType1Operator().equals(">=")
					&& (Long) ((Literal) (r.getObject().getValue())).getValue() <= (Long) (olong)) {
				return true;
			}
		}
		return false;

	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

}
