
package edu.telecomstet.cep.engine.optimised;

import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecomstet.cep.nfahelpers2.NFA;
import edu.telecomstet.cep.nfahelpers2.State;

/**
 * This class represents a run.
 * 
 * @author sydgillani
 *
 */
public class RunOptimised implements Cloneable {

	/**
	 * Flags of the state status 0 represents for no event, 1 represents for
	 * there is event for this state, but predicates has not been finished. 2
	 * represents all is done. 3 represents for kleene closure state, this
	 * position already has some event/events, but it can accept new events.
	 */

	private int id;
	
	
	public long key;

	private int clone; // 1 for yes, otherwise 0

	private int[] state;
	/**
	 * The number of states
	 */
	private int size;
	/**
	 * The number of events selected so far
	 */
	private int count;
	/**
	 * The nfa for the query
	 */
	private NFA nfa;
	/**
	 * Flag denoting whether the run is alive
	 */
	private boolean alive;
	/**
	 * Which state the run is at current state describes where the run is at,
	 * this value is initialized as 0, every time we add an event, we will
	 * increase the current state by 1 except for when the current state is a
	 * kleene closure state. When this run is full, we will not increase it
	 * anymore.
	 */
	private int currentState;
	/**
	 * Flag denoting whether the run is ready to make a match
	 */
	private boolean isComplete;
	/**
	 * The run is full of events, but maybe some predicates has not been
	 * evaluated
	 */
	private boolean isFull;

	/**
	 * The starting time of this run
	 */

	private long lifeTimeBegin;
	/**
	 * The timestamp of the first event selected by this run
	 */
	private long startTimeStamp;
	/**
	 * Flag denoting whether the kleene closure state in the query (if it
	 * contains) is initialized
	 */
	private boolean kleeneClosureInitialized;

	private long partitonId;

	private int kleeneCounter;

	// private int beforeNegationTimestamp;
	// private int afterNegationTimestamp;

	// private ArrayList<StateFull_Cache> cache;

	// private HashMap<Integer, MultiBiMap<SP, OP> > cache;

	// private HashMap<RunStateMap,MultiBiMap<Long,Long>> cacheStateful;

	// public HashMap<RunStateMap, MultiBiMap<Long, Long>> getCacheStateful() {
	// return cacheStateful;
	// }
	//
	// public void setCacheStateful(HashMap<RunStateMap, MultiBiMap<Long, Long>>
	// cacheStateful) {
	// this.cacheStateful = cacheStateful;
	// }
	//
	/**
	 * Default constructor.
	 */
	public RunOptimised() {
		this.alive = false;

	}

	/**
	 * Constructor, initialized by the nfa for a query
	 * 
	 * @param nfa
	 *            the nfa for a query
	 */
	public RunOptimised(NFA nfa, long time, int id) {
		this.initializeRun(nfa, time, id);
	}

	/**
	 * Initializes a run, sets it as alive
	 * 
	 * @param nfa
	 *            the nfa for a query
	 */
	public void initializeRun(NFA nfa, long time, int id) {
		this.id = id;
		this.clone = 0;
		this.nfa = nfa;
		this.size = this.nfa.getStates().length; /// TODO: change it
		this.setLifeTimeBegin(time);
		state = new int[size];
		// this.eventIds = new ArrayList<Integer>();
		// cache = new HashMap();
		currentState = 0;
		this.alive = true;
		this.isFull = false;
		this.isComplete = false;
		this.count = 0;
		this.kleeneClosureInitialized = false;
		this.kleeneCounter = 0;
		/// this.cacheStateful = new HashMap<>();

		// System.out.println(id);

	}

	/**
	 * resets a run
	 */
	public void resetRun() {

		// this.cache=null;
		this.nfa = null;
		// this.eventIds = null;
		this.state = null;
		this.alive = false;
		this.currentState = -1;
		this.isComplete = false;
		this.isFull = false;
		this.count = 0;
		this.kleeneClosureInitialized = false;

	}

	/**
	 * Checks whether the match is ready to make a match
	 * 
	 * @return the check result, boolean format
	 */
	public boolean checkMatch() {
		if (!this.isFull)
			return false;
		for (int i = 0; i < state.length; i++) {

			if (state[i] != 2) {
				return false;
			}
		}
		this.isComplete = true;
		return true;
	}

	public boolean checkStateType(GraphEvent e) throws Exception {

		State s = this.nfa.getStates()[currentState];
		// && s.getKleeneCounter() >= 1
		if (s.getStateType().equalsIgnoreCase("kleeneClosure") && currentState != this.nfa.getSize() - 1
				|| (s.isManager() && s.getSubstatesType() == 2)) {

			return true;

		}

		return false;

	}

	/**
	 * Add an RDF Event to the RUN
	 */
	public void addGraphEvent(GraphEvent e) {// 1 incomplete, 2 complete ,3
												// kleene closure //Comment: For
												// the first RunOptimised If
												// state type is normal then
												// make
		// the state complete and move to the next state
		// String stateType = this.nfa.getStates()[currentState].getStateType();
		if (this.nfa.getStates()[currentState].getStateType().equalsIgnoreCase("normal")
				|| this.nfa.getStates()[currentState].getStateType().equalsIgnoreCase("negation")
				|| this.nfa.getStates()[currentState].getStateType().equalsIgnoreCase("optional")) {
			// this.eventIds.add(e.getId());
			state[currentState] = 2;
			this.count++;
			if (currentState == this.nfa.getSize() - 1) {
				this.setFull(true);
			} else {

				this.currentState++;
			}

		} else if (this.nfa.getStates()[currentState].getStateType().equalsIgnoreCase("kleeneClosure")) {
			// this.eventIds.add(e.getId());

			this.kleeneClosureInitialized = true;
			state[currentState] = 3;
			this.nfa.getStates()[currentState].setKleeneCounter(count);
			this.count++;
			/***
			 * Test
			 */

		}
		if (this.count == 1) {
			// this.startTimeStamp = e.getTimeStamp();
			this.lifeTimeBegin = e.getTimeStamp();
			// if(ConfigFlags.hasPartitionAttribute){
			// this.partitonId =
			// e.getAttributeByName(this.nfa.getPartitionAttribute()); ///Change
			// it
			// }
		} // if this is the first event of this run, initialize the start
			// timestamp;
	}

	public void addGraphEvent(GraphEvent e, long id) {// 1 incomplete, 2
														// complete ,3 kleene
														// closure //Comment:
														// For the first
														// RunOptimised If state
														// type is normal then
														// make
		// the state complete and move to the next state
		// String stateType = this.nfa.getStates()[currentState].getStateType();
		if (this.nfa.getStates()[currentState].getStateType().equalsIgnoreCase("normal")
				|| this.nfa.getStates()[currentState].getStateType().equalsIgnoreCase("negation")) {
			// this.eventIds.add(e.getId());
			state[currentState] = 2;
			this.count++;
			if (currentState == this.nfa.getSize() - 1) {
				this.setFull(true);
			} else {

				this.currentState++;
			}

		} else if (this.nfa.getStates()[currentState].getStateType().equalsIgnoreCase("kleeneClosure")) {
			// this.eventIds.add(e.getId());

			this.kleeneClosureInitialized = true;
			state[currentState] = 3;
			this.nfa.getStates()[currentState].setKleeneCounter(count);
			this.count++;
		}
		if (this.count == 1) {
			this.startTimeStamp = e.getTimeStamp();
			this.partitonId = id;
			// if(ConfigFlags.hasPartitionAttribute){
			// this.partitonId =
			// e.getAttributeByName(this.nfa.getPartitionAttribute()); ///Change
			// it
			// }
		} // if this is the first event of this run, initialize the start
			// timestamp;
	}

	/**
	 *
	 * @return the id of last selected event
	 */
	/*
	 * public int getPreviousEventId(){ return this.eventIds.get(this.count -
	 * 1); }
	 */

	/**
	 * Returns the last n event id last 1 means the last event last 2 means the
	 * last second event
	 * 
	 * @param n
	 *            the relative position
	 * @return the event id
	 */
	/*
	 * public int getLastNEventId(int n){ if (n > this.count){ return -1; }
	 * return this.eventIds.get(this.count - n); }
	 */

	/**
	 * Proceeds a kleene closure state
	 */
	public void proceed() {
		this.state[this.currentState] = 2;
		if (this.currentState == this.size - 1) {
			this.setFull(true);
			// this.checkMatch();??
		} else {
			this.currentState++;
		}
	}

	public boolean checkNextState() {
		return this.currentState == this.size - 1;
	}

	/**
	 * Clones the run itself
	 */
	public Object clone(int id) throws CloneNotSupportedException {

		RunOptimised o = null;
		o = (RunOptimised) super.clone();
		// this.even.clone();
		// o.setEventIds((ArrayList<Integer>)this.getEventIds().clone());
		o.setState((int[]) this.getState().clone());
		o.setNfa(nfa);
		// o.setCache(( HashMap<Integer, MultiBiMap<SP, OP> >
		// )this.getCache().clone());
		o.startTimeStamp = this.getStartTimeStamp();
		o.id = id;
		o.clone = 1;

		return o;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive
	 *            the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
		if (alive) {// if the run is used again, we need to update the beginning
					// of lifetime
			this.lifeTimeBegin = System.nanoTime();
		}
	}

	/**
	 * @return the currentState
	 */
	public int getCurrentState() {
		return currentState;
	}

	/**
	 * @param currentState
	 *            the currentState to set
	 */
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	/**
	 * @return the state
	 */
	public int[] getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int[] state) {
		this.state = state;
	}

	/**
	 * @return the nfa
	 */
	public NFA getNfa() {
		return nfa;
	}

	/**
	 * @param nfa
	 *            the nfa to set
	 */
	public void setNfa(NFA nfa) {
		this.nfa = nfa;
	}

	/**
	 * @return the lifeTimeBegin
	 */
	public long getLifeTimeBegin() {
		return lifeTimeBegin;
	}

	/**
	 * @param lifeTimeBegin
	 *            the lifeTimeBegin to set
	 */
	public void setLifeTimeBegin(long lifeTimeBegin) {
		this.lifeTimeBegin = lifeTimeBegin;
	}

	/**
	 * @return the isComplete
	 */
	public boolean isComplete() {
		return isComplete;
	}

	/**
	 * @param isComplete
	 *            the isComplete to set
	 */
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	/**
	 * @return the isFull
	 */
	public boolean isFull() {
		return isFull;
	}

	/**
	 * @param isFull
	 *            the isFull to set
	 */
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	/**
	 * @return the startTimeStamp
	 */
	public long getStartTimeStamp() {
		return startTimeStamp;
	}

	/**
	 * @param startTimeStamp
	 *            the startTimeStamp to set
	 */
	public void setStartTimeStamp(long startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}

	/**
	 * @return the eventIds
	 */
	/*
	 * public ArrayList<Integer> getEventIds() { return eventIds; }
	 */

	/**
	 * @param eventIds
	 *            the eventIds to set
	 */
	/*
	 * public void setEventIds(ArrayList<Integer> eventIds) { this.eventIds =
	 * eventIds; }
	 */

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the kleeneClosureInitialized
	 */
	public boolean isKleeneClosureInitialized() {
		return kleeneClosureInitialized;
	}

	/**
	 * @param kleeneClosureInitialized
	 *            the kleeneClosureInitialized to set
	 */
	public void setKleeneClosureInitialized(boolean kleeneClosureInitialized) {
		this.kleeneClosureInitialized = kleeneClosureInitialized;
	}

	//
	// /**
	// * @return the beforeNegationTimestamp
	// */
	// public int getBeforeNegationTimestamp() {
	// return beforeNegationTimestamp;
	// }
	// /**
	// * @param beforeNegationTimestamp the beforeNegationTimestamp to set
	// */
	// public void setBeforeNegationTimestamp(int beforeNegationTimestamp) {
	// this.beforeNegationTimestamp = beforeNegationTimestamp;
	// }
	// /**
	// * @return the afterNegationTimestamp
	// */
	// public int getAfterNegationTimestamp() {
	// return afterNegationTimestamp;
	// }
	// /**
	// * @param afterNegationTimestamp the afterNegationTimestamp to set
	// */
	// public void setAfterNegationTimestamp(int afterNegationTimestamp) {
	// this.afterNegationTimestamp = afterNegationTimestamp;
	// }

	/*
	 * public HashMap<Integer, MultiBiMap<SP, OP>> getCache() { return cache; }
	 * 
	 * public void setCache(HashMap<Integer, MultiBiMap<SP, OP>> cache) {
	 * this.cache.putAll(cache); }
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPartitonId() {
		return partitonId;
	}

	public void setPartitonId(long partitonId) {
		this.partitonId = partitonId;
	}

	public int getClone() {
		return clone;
	}

	public void setClone(int clone) {
		this.clone = clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clone;
		result = prime * result + id;
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
		RunOptimised other = (RunOptimised) obj;
		if (clone != other.clone)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
