
package edu.telecomstet.cep.nfahelpers2;

import java.util.Map;
import java.util.StringTokenizer;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecomstet.cep.engine.optimised.RunOptimised;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.graph.processing.GraphPruning;

/**
 * This class represents an edge of an NFA.
 * 
 * @author haopeng
 *
 */
// edgetype = begin & price < 100
public final class Edge {
	/**
	 * The original description in the nfa file
	 */
	private String edgeDescription;
	/**
	 * The type of the edge, begin, , take or proceed
	 */
	// private ArrayList<Rule> dependencyRule;
	// private final NFAData nfaData;
	// private ContinuousSPARQLEngineController spE = new
	// ContinuousSPARQLEngineController();

	private GraphPruning _gp = new GraphPruning();
	private String edgeType;

	boolean response = false;
	// String queryType;

	/**
	 * Predicates on this edge
	 */

	// HashSet<String> bindingSet;
	// public ArrayListMultimap<String, Value> bindings_Values;

	// PredicateOptimized predicates[]; ///remove it

	/**
	 * Constructor, based on the input string
	 * 
	 * @param edgeDescription
	 *            the description sentence in the nfa file
	 */

	public Edge(NFAData nfaData, int edgeTypeNum) {

		// this.nfaData=nfaData;
		// ArrayList<Rule> dependencyRule=new ArrayList<>();
		// SparqlEngineController spE = new SparqlEngineController();
		switch (edgeTypeNum) {
		case 0:
			this.edgeType = "begin";
			break;
		case 1:
			this.edgeType = "take";
			break;
		case 2:
			this.edgeType = "proceed";
			break;
		}
	}

	public boolean evaluatePredicateandStatQuery(GraphEvent event, State s,
			Map<RunStateMap, MultiBidirectionalIndex> cache, Map<KBindex, MultiBiMap<Long, SP>> kbcache, int r)
			throws Exception {
		/**
		 * Send Event to the Query Controller and If it returns some result then
		 * return True otherwise False
		 * 
		 */

		/// Change it to different engine, for incremenatl and event-based
		// System.out.println(r);
		// return new
		// GraphQueryAdapter().sparqlAdapter(event,s.getNfaData(),dependencyRule,spE,cache,r,s.getOrder())
		// ; //send the run id and state orderas well
		return this._gp.run(s.getNfaData().getAutomta(), event, s.getNfaData().getDicionary(), cache, kbcache, r,
				s.getOrder());
		// return true;

	}

	public boolean evaluateGraphEvent(GraphEvent currentEvent, RunOptimised r, State s,
			Map<RunStateMap, MultiBidirectionalIndex> cache, Map<KBindex, MultiBiMap<Long, SP>> kbcache)
			throws Exception {

		return this._gp.run(s.getNfaData().getAutomta(), currentEvent, s.getNfaData().getDicionary(), cache, kbcache,
				r.getId(), s.getNfaData().getOrder());

	}

	/**
	 * Evaluate predicate for the second run and so on
	 * 
	 */

	/**
	 * Parses the edge from the input string
	 * 
	 * @param edgeTypeDescription
	 *            the description string
	 */
	void parseEdgeType(String edgeTypeDescription) {
		StringTokenizer st = new StringTokenizer(edgeTypeDescription, "=");
		String left = st.nextToken().trim();
		String right = st.nextToken().trim();
		if (left.equalsIgnoreCase("edgetype"))
			this.edgeType = right;

	}

	/**
	 * Self-description
	 */
	public String toString() {
		String temp = "";
		temp += "I am an edge, my edge type is " + this.edgeType;
		temp += "\nmy edge descripton file is " + this.edgeDescription;
		// temp += "\nI have " + this.predicates.length + " predicates";
		return temp;
	}

	/**
	 * @return the edgeDescription
	 */
	public String getEdgeDescription() {
		return edgeDescription;
	}

	/**
	 * @param edgeDescription
	 *            the edgeDescription to set
	 */
	public void setEdgeDescription(String edgeDescription) {
		this.edgeDescription = edgeDescription;
	}

	/**
	 * @return the edgeType
	 */
	public String getEdgeType() {
		return edgeType;
	}

	/**
	 * @param edgeType
	 *            the edgeType to set
	 */
	public void setEdgeType(String edgeType) {
		this.edgeType = edgeType;
	}

	/**
	 * @return the predicates
	 */

}
