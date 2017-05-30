package edu.telecomstet.cep.nfahelpers2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.openhft.koloboke.collect.map.hash.HashIntLongMaps;
import net.openhft.koloboke.collect.map.hash.HashIntObjMaps;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomst.graph.processing.GraphEvent;
import edu.telecomstet.cep.rulesmodel.NFAData;

/**
 * This class represents a state from NFA.
 * 
 * @author Syed
 * 
 */
public final class State {

	// public Edge incoming_Edge;
	// public boolean incoming_Edge_Status;
	/**
	 * The line in the nfa file for this state
	 */
	//private String nfaLine;
   
	/**
	 * The type of the state, normal, kleene closure or negation
	 */
	
	private boolean partialMatched=false;
	private String stateType;

	//private NFAData statefullnessData;
	
	
	//private long tiptopTime=0;
	/**
	 * The event type for this state
	 */
	// String eventType;
	
	private   HashSet<Integer> stateStatus;

	private String graphType;

	private int kleeneCounter;

	private String stateQuery; // /Is it useful?
	// TupleQuery stateTupleExpr;

	/**
	 * The order of this state
	 */
	int order;

	/**
	 * Denoting whether this state is the first state
	 */
	boolean isStart;
	// Repository repo;
	// RepositoryConnection conn;
	/**
	 * Denoting whether this state is the last state
	 */
	boolean isEnding;

	public Set<Long> evetType;
	/**
	 * Denoting whether this state is a kleene closure state
	 */
	boolean isKleeneClosure;

	boolean isNegation;
	boolean isBeforeNegation;
	boolean isAfterNegation;
	final private NFAData _nfaData;
	int statefullness;
	/**
	 * For optional State
	 */
	private boolean isOptional;

	/**
	 * Hash Map for the manager state to take care of the Timestamps
	 */
	
	//TODO: check if these timestamps are also removed from the hashmap, when the run is deleted
	private Map<Integer, Long> _timestampRuns ;
	//TODO: add another map containing the buffered events w.r.t each run
	
	
	/**
	 * HashMap that contains the buffered Event w.r.t to a run
	 */
	private Map<Integer, List<GraphEvent>> _bufferdEvents ;
	
	/**
	 * The edges from this state
	 */
	public Edge[] edges;

	/**
	 * Representation for this state in the fast query format, usually 'a' for
	 * the first state, 'b' for the second state, etc.
	 */
	String tag;
	private int stateDependencyID;

	private boolean isManager;
	private Multimap<Long, State> substates;
    private int substatesType; ///1: for Union, and 2: for OR 
	
	public State(final List<NFAData> nfadatalist, int stateType){
		this._nfaData=null;
		this.isManager=true;
		this.substatesType=stateType;
		this.substates=ArrayListMultimap.create();
		
		///// Initialise a HashMap to check the timestamp with the run ID
		this._timestampRuns=  HashIntLongMaps.newMutableMap();
		
		///Initialise a HashMap containing the buffered events and the run ID
		this._bufferdEvents =  HashIntObjMaps.newMutableMap();
		
		//this.stateStatus= new HashSet<>();
		/////
		this.stateType = "normal";
		this.isKleeneClosure = false;
		this.isNegation = false;
		this.edges = new Edge[1];
		this.edges[0] = new Edge(null, 0);
		this.evetType = new HashSet<>();
		
		//////
		
		
		for(NFAData sdata:nfadatalist){
		//create a state
			
			State nState= new State(sdata,sdata.getOrder());
			this.evetType.addAll(nState.getEvetType());
			this.substates.put(sdata.getStreamList().get(0).getMappedStreamURI(),nState);
		}
	}
	
	public State(final NFAData nfaData, int order) {

		
		//System.out.println("NFA ID: "+ order);
		this.stateStatus= new HashSet<>(); //only create it when you need it
		_nfaData = nfaData;
		this.order = order;

		this.evetType = new HashSet<>();

		this.kleeneCounter = 0;

		this.stateDependencyID = nfaData.getStateDependencyID();
		// //for event type put the value of from stream
		nfaData.getStreamList().stream().forEach((sData) -> {
			this.evetType.add(sData.getMappedStreamURI());
		});

		this.stateType = nfaData.getPatterndata().getPattType();

		if (this.stateType == null || this.stateType.equals("n")) {
			this.stateType = "normal";
			this.isKleeneClosure = false;
			this.isNegation = false;
			this.edges = new Edge[1];
			this.edges[0] = new Edge(nfaData, 0);

			// TODO: change the sign of the kleene closure and later change the
			// stateType from string to int, or even remove it of its not useful
		} else if (this.stateType.equals("+")) {
			this.stateType = "kleeneClosure";
			this.isKleeneClosure = true;
			this.isNegation = false;
			this.edges = new Edge[3];
			for (int i = 0; i < 3; i++) {
				this.edges[i] = new Edge(nfaData, i);
			}
		} else if (this.stateType.equals("!")) {
			this.stateType = "negation";
			this.isKleeneClosure = false;
			this.isNegation = true;
			this.edges = new Edge[1];
			this.edges[0] = new Edge(nfaData, 0);

		} else if (this.stateType.equals("?")) {
			this.stateType = "optional";
			this.isKleeneClosure = false;
			this.isNegation = false;
			this.isOptional = true;
			this.edges = new Edge[1];
			this.edges[0] = new Edge(nfaData, 0);

		}

	}

	/**
	 * Self description
	 */
	public String toString() {
		String temp = "";
		if (isStart)
			temp += " I am a starting state";
		if (isEnding)
			temp += " I am a ending state";
		if (isKleeneClosure)
			temp += " I am a kleene closure state";
		temp += " My state type is: " + this.stateType;
		//temp += "\n my description file = " + this.nfaLine;
		return "This is the " + order + " state, requiring events of "
				+ this.evetType + " event type, " + temp;
	}

	/*
	 * public boolean canStartWithEvent(Event e) { //Change this method for RDF
	 * 
	 * 
	 * if(!e.getEventType().equalsIgnoreCase(this.eventType)){
	 * 
	 * return false; } if(this.edges[0].evaluatePredicate(e,e)){ return true; }
	 * return false;
	 * 
	 * }
	 */

	/*
	 * RDF Based canStartWithEvent
	 */

	public boolean canStartWithGraphEvent(GraphEvent e,
			Map<RunStateMap, MultiBidirectionalIndex> cache,
			Map<KBindex, MultiBiMap<Long, SP>> kbcache, int r) throws Exception { // Change
																					// this
																					// method
	//TODO: Check for the negation and Kleene-+ for the first state										// for
																					// RDF

	//	boolean checker = false;
		//boolean result;

		
		if(this.evetType.contains(e.getMappedContext())){
			return  this.edges[0].evaluatePredicateandStatQuery(e, this, cache,kbcache, r);
		}
		
		
			return false;
		
		
		
	/*	for (Long contextURI : this.evetType) { // /check if the event has the
												// same context as of the
												// state's query
			if (!e.getMappedContext().equals(contextURI)) {
				checker = false;

			} else {
				checker = true;
				break;
			}
		}*/

		/**if checker == false and the first state is the negation state, then check the next state and match the event with it, and return 1 , 0, -1
		
		*the first state being the kleen-+ doesn't change anything as all the event are match to the first state, and a new run is initiated in case if it matches
		* so only consider the negation scenario.
		 * */
		
		
		

		/*if (!checker && "negation".equals(this.stateType)) {
			return true;
		} else if (!checker && !"negation".equals(this.stateType)) {

			return false;

		}*/

		// TODO: Change over here if the first state is the negation one

	

		// System.out.println("Query Match : "+result);

	/*	if (result && !"negation".equals(this.stateType)) {

			return true;

		} else if (result && "negation".equals(this.stateType)) {
			return false;
		} else if (!result && !"negation".equals(this.stateType)) {
			return false;
		} else if (!result && "negation".equals(this.stateType)) {
			return true;
		}*/

		//return false;
	}

	/**
	 * Check the next State of Kleene Star
	 * 
	 * @param e
	 * @return
	 * @throws java.lang.Exception
	 */
	/*
	 * RDF Based canStartWithEvent
	 */
/*
	public boolean canStartWithNextState(GraphEvent e,
			Map<RunStateMap, MultiBidirectionalIndex> cache,
			Map<KBindex, MultiBiMap<Long, SP>> kbcache, int r) throws Exception { // Change
																					// this
																					// method
																					// for
																					// RDF

		boolean checker = false;
		for (Long contextURI : this.evetType) { // /check if the event has the
												// same context as of the
												// state's query
			if (!e.getMappedContext().equals(contextURI)) {
				checker = false;

			} else {
				checker = true;
				break;
			}
		}

		if (!checker) {

			return false;
		} else if (this.edges[0].evaluatePredicateandStatQuery(e, this, cache,
				kbcache, r)) {

			return true;

		} else {
			return false;
		}

	}
*/	
	
	public int negationStateProcess(GraphEvent e,
			Map<RunStateMap, MultiBidirectionalIndex> cache,
			Map<KBindex, MultiBiMap<Long, SP>> kbcache, int r) throws Exception{
		
		
		
		
		
		if(this.evetType.contains(e.getMappedContext()) ){
			
			
			if(this.edges[0].evaluatePredicateandStatQuery(e, this, cache,
					kbcache, r)){
				return 0; ///Its matched and its not suppose to be so return 0
			}
			
			return 1;
			
			
			
		}
		
		return 2;
	}
	
	
	

	/**
	 * @return the eventType
	 */

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * @return the isStart
	 */
	public boolean isStart() {
		return isStart;
	}

	/**
	 * @param isStart
	 *            the isStart to set
	 */
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	/**
	 * @return the isEnding
	 */
	public boolean isEnding() {
		return isEnding;
	}

	/**
	 * @param isEnding
	 *            the isEnding to set
	 */
	public void setEnding(boolean isEnding) {
		this.isEnding = isEnding;
	}

	/**
	 * @return the isKleeneClosure
	 */
	public boolean isKleeneClosure() {
		return isKleeneClosure;
	}

	/**
	 * @param isKleeneClosure
	 *            the isKleeneClosure to set
	 */
	public void setKleeneClosure(boolean isKleeneClosure) {
		this.isKleeneClosure = isKleeneClosure;
	}

	/**
	 * @return the nfaLine
	 */
//	public String getNfaLine() {
//		return nfaLine;
//	}
//
//	/**
//	 * @param nfaLine
//	 *            the nfaLine to set
//	 */
//	public void setNfaLine(String nfaLine) {
//		this.nfaLine = nfaLine;
//	}

	/**
	 * @return the stateType
	 */
	public String getStateType() {
		return stateType;
	}

	/**
	 * @param stateType
	 *            the stateType to set
	 */
	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	/**
	 * @return the edges
	 */
	public Edge[] getEdges() {
		return edges;
	}

	public Edge getEdges(int order) {
		return edges[order];
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(Edge[] edges) {
		this.edges = edges;
	}

	/**
	 * @return the isNegation
	 */
	public boolean isNegation() {
		return isNegation;
	}

	/**
	 * @param isNegation
	 *            the isNegation to set
	 */
	public void setNegation(boolean isNegation) {
		this.isNegation = isNegation;
	}

	/**
	 * @return the isBeforeNegation
	 */
	public boolean isBeforeNegation() {
		return isBeforeNegation;
	}

	/**
	 * @param isBeforeNegation
	 *            the isBeforeNegation to set
	 */
	public void setBeforeNegation(boolean isBeforeNegation) {
		this.isBeforeNegation = isBeforeNegation;
	}

	/**
	 * @return the isAfterNegation
	 */
	public boolean isAfterNegation() {
		return isAfterNegation;
	}

	/**
	 * @param isAfterNegation
	 *            the isAfterNegation to set
	 */
	public void setAfterNegation(boolean isAfterNegation) {
		this.isAfterNegation = isAfterNegation;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * 
	 * To Store the Sub-Sparql Query for a certain state
	 */
	public String getStateQuery() {
		return stateQuery;
	}

	public void setStateQuery(String stateQuery) {
		this.stateQuery = stateQuery;
	}

	public String getGraphType() {
		return graphType;
	}

	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}

	public NFAData getNfaData() {
		return _nfaData;
	}

	public int getKleeneCounter() {
		return kleeneCounter;
	}

	public void setKleeneCounter(int kleeneCounter) {
		this.kleeneCounter = kleeneCounter;
	}

	/*
	 * public int getStatefullness() { return statefullness; }
	 */

	public int getStateDependencyID() {
		return stateDependencyID;
	}

	public void setStateDependencyID(int stateDependencyID) {
		this.stateDependencyID = stateDependencyID;
	}

	public boolean isOptional() {
		return isOptional;
	}

	public boolean isManager() {
		return isManager;
	}

	public Multimap<Long, State> getSubstates() {
		return substates;
	}

	public int getSubstatesType() {
		return substatesType;
	}

	

	

	
	

	public boolean isPartialMatched() {
		return partialMatched;
	}

	public void setPartialMatched(boolean partialMatched) {
		this.partialMatched = partialMatched;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + order;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (order != other.order)
			return false;
		return true;
	}

	public Map<Integer, Long> get_timestampRuns() {
		return _timestampRuns;
	}

	public Set<Long> getEvetType() {
		return evetType;
	}

	public HashSet<Integer> getStateStatus() {
		return stateStatus;
	}

	public Map<Integer, List<GraphEvent>> get_bufferdEvents() {
		return _bufferdEvents;
	}

	
}
