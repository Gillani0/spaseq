package edu.telecomstet.cep.engine.optimised;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecom.stet.cep.events.MappedEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.nfahelpers2.Edge;
import edu.telecomstet.cep.nfahelpers2.NFA;
import edu.telecomstet.cep.nfahelpers2.State;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.Rule;

public class SpsaseqQueryProcessor extends AbstractSpaseqQueryProcessor {

	public SpsaseqQueryProcessor(NFA nf, List<NFAData> nfalist, DictionaryOpImpl dic, List<Rule> constrc,
			BlockingQueue<GraphEvent> inputqueue, CountDownLatch latch) {
		super(nf, nfalist, dic, constrc, inputqueue, latch);

	}

	// @Override
	// public void runGraphEventProcessing(GraphEvent e) throws
	// CloneNotSupportedException, Exception {
	//
	// }

	@Override
	protected void partitionBYEngine(GraphEvent e) throws CloneNotSupportedException, Exception {
		evaluateRunsForPartitionContiguity(e);

		// if (this.toDeleteRuns.size() > 0) { /// do something about the
		// /// toDeleteRuns, concurrent
		// /// modifications can be avoided now
		// this.cleanRunsByPartition();
		// }
		createNewRunByPartition(e);

		Profiling.numberOfEvents += 1;

	}

	@Override
	protected void configPartitionBy() {
		if (!this._nfaDataList.get(0).getPatternByData().isEmpty()) {
			ConfigFlags.partitionByPred = this._nfaDataList.get(0).getPatternByData();
			for (int i = 1; i < this._nfaDataList.size()
					&& !this._nfaDataList.get(i).getPatternByData().isEmpty(); i++) {
				ConfigFlags.partitionByPred.putAll(this._nfaDataList.get(i).getPatternByData());

			}
		}

	}

	private void evaluateRunsForPartitionContiguity(GraphEvent e) throws CloneNotSupportedException, Exception {
		long key = evaluateKeyforthePartitionfromEvent(e); /// a function to
															/// find the
															/// partition key
		partitionKey = key;
		if (this.activeRunsByPartition.containsKey(key)) {
			ArrayList<RunOptimised> partitionedRuns = this.activeRunsByPartition.get(key);
			// int size = partitionedRuns.size();
			for (int i = 0; i < partitionedRuns.size(); i++) {
				RunOptimised r = partitionedRuns.get(i);
				if (r.isFull()) {
					continue;
				}

				switch (ConfigFlags.selectionStrategy) // 1: STN, 2: STA, 3: SC
				{
				case 1:
					this.evaluateFBOptimised(e, r);
					break;
				case 2:
					// this.evaluateSTA(e, r);
					break;
				case 3:
					this.evaluateIF(e, r);
					break;

				}
				// evaluateIF(e,r);
				/// this.evaluateEventForPartitonContiguityOptimized(e, r);//
				/// //change it
			}
		}
	}

	private long evaluateKeyforthePartitionfromEvent(GraphEvent e) {
		long key = 0;
		for (MappedEvent event : e.getMapped()) {
			if (ConfigFlags.partitionByPred.containsKey(event.getProperties())) {
				/// get the key and return it
				key = event.getSubject();
				break;
			}
		}

		return key;
	}

	/**
	 * To Evaluate Run for incoming events and Immediate Follow
	 * 
	 * @param e
	 * @param r
	 * @throws CloneNotSupportedException
	 */

	private void evaluateIF(GraphEvent e, RunOptimised r) throws CloneNotSupportedException, Exception {

		if (this.checkTimeWindow(e, r)) {

			int result = processEvent(e, r);
			if (result == 1) { // the predicate if ok.

				final int oldState = r.getCurrentState();
				r.addGraphEvent(e); // add the event to this run
				final int newState = r.getCurrentState();

				if (oldState == newState) {

					if (r.isFull()) {

						results.outputMatches(e, r);
						Profiling.numberOfMatches++;

						// TODO: proper function
						if (ConfigFlags.partitionByPred.isEmpty())
							clearTheRunFromRunList(r);
						else

							clearThePartitionedRun(r);

						// this.toDeleteRuns.add(r);

					} else {

						// Check the Kleene-+ state
						if (r.checkStateType(e)) {
							RunOptimised newerRun = this.cloneRun(r);

							newerRun.proceed(); // / Addition for the RDF
												// / Matching
							if (newerRun.isComplete()) {

								results.outputMatches(e, newerRun);
								Profiling.numberOfMatches++;
								if (ConfigFlags.partitionByPred.isEmpty())
									clearTheRunFromRunList(r);
								else
									clearThePartitionedRun(r);
								// this.toDeleteRuns.add(newerRun);
							} else {

								if (ConfigFlags.partitionByPred.isEmpty())
									addRunNormal(newerRun);
								else
									addRunByPartition(newerRun);
							}

						}
					}
				} else {
					/**
					 * change the partition of the Run, only if you're using the
					 * activeRunPar structure Use the older State to get the
					 * event Type and remove it from the map, and use the new
					 * state to put it back in the map
					 */

					Set<Long> oldsID = this.nfa.getStates()[oldState].getEvetType();

					for (long ls : oldsID) {
						this.activeRunsPart.remove(ls, r);

					}

					Set<Long> newsID = this.nfa.getStates()[newState].getEvetType();

					for (long ns : newsID) {
						this.activeRunsPart.put(ns, r);

					}

				}

			} else if (result <= 0) {

				if (ConfigFlags.partitionByPred.isEmpty())
					clearTheRunFromRunList(r);
				else

					clearThePartitionedRun(r);
				// this.toDeleteRuns.add(r);

			}

		} else {

			// /new to use the older state over here
			// this.toDeleteRuns.add(r);

			if (ConfigFlags.partitionByPred.isEmpty())
				clearTheRunFromRunList(r);
			else

				clearThePartitionedRun(r);
		}
	}

	/**
	 * 
	 * @param e
	 * @param r
	 * @return 0: false; -1: false to be deleted; 1 true
	 * @throws Exception
	 */

	private int processEvent(GraphEvent e, RunOptimised r) throws Exception {
		State s = this.nfa.getStates(r.getCurrentState());

		/// State newS=this.nfa.getStates(r.getCurrentState()+1);
		// TO check for the negation state, First check the event for the next
		/// state and for the previous state and if the events
		/// satisfies previous or next state predicate then dont consume that
		/// event, otherwise comsume it.

		// Still have to implement the negation at the first and the last state
		/// One of the most expensive operation of pattern matching...

		/// if its after negation then only create one run and thats it.....

		if (!s.isNegation() && !s.isOptional() && !s.isManager()) { /// Simple
																	/// State or
																	/// Kleene-+

			/// simple check the predicate
			if (checkRDFPredicate(e, r)) {
				return 1;

			} else {
				return 0;
			}
		} else if (s.isNegation() && !s.isEnding() && !s.isManager()) { /// Negation
																		/// state,
																		/// which
																		/// is
																		/// not
																		/// the
																		/// final
																		/// stae

			/*
			 * Check first the match with the current state, if the match is
			 * true, then off-course this event does not match to the negation
			 * operator. If the match is false, then send the event to the next
			 * state if the match is true for the next state, then it means the
			 * negation has been done "if the match returns true for the next
			 * state then make the state+2, else just this state".
			 */
			boolean negation = checkRDFPredicate(e, r);

			if (negation == true) {
				return 0; /// delete the run
			} else { /// match it with the next state, considering that the next
						/// state is not a negation state
				r.setCurrentState(r.getCurrentState() + 1); // TODO: over here
															// also check the
															// optional state
															// stuff as well
				boolean nextToNegation = checkRDFPredicate(e, r);

				// check for the optional state next to a negation state
				if (this.nfa.getStates(r.getCurrentState()).isOptional()) {
					return 1;
				}

				if (nextToNegation == true) {
					return 1; /// deal it in a normal way, if the next state is
								/// the kleene+ then create a new run and vice
								/// versa
				} else {

					/// if the next state is not matched then stay on the
					/// current negation state, and use the normal method to
					/// deal with the stuff
					r.setCurrentState(r.getCurrentState() - 1);
					return 1;
				}

			}

		} else if (s.isNegation() && s.isEnding() && !s.isManager()) { /// negation
																		/// state
																		/// which
																		/// is
																		/// the
																		/// final
																		/// state
			boolean negation = checkRDFPredicate(e, r);
			if (negation == true) { /// if the last state which is a negation
									/// matched then simply return 0 to delete
									/// the run
				return 0; /// delete the run
			} else {
				return 1; /// else return 1 and complete the run with a match
			}

		} else if (s.isOptional() && !s.isNegation() && !s.isManager()) {//// Optional
																			//// state

			checkRDFPredicate(e, r); /// match it even if its not matched just
										/// send the true

			return 1;

		} else if (s.isManager()) {
			//// send the e and r to a new function
			if (s.getSubstatesType() == 2) { /// 1: for Union, and 2: for OR
				return evaluateOR(e, r, s);
			} else if (s.getSubstatesType() == 1) {
				return evaluateAND(e, r, s);
			}
		}

		return 0;
	}

	/**
	 * 
	 * @param e
	 * @param r
	 * @param s
	 * @return 0: false, 1: true
	 * @throws Exception
	 */
	private int evaluateOR(GraphEvent e, RunOptimised r, State s) throws Exception {
		//// Calculate the OR over the Manager State

		// check first of the e is of type in the state
		if (!s.getSubstates().containsKey(e.getMappedContext())) {
			return -5;
		} else {
			///// get the list of states that corresponds to this URI

			Collection<State> substates = s.getSubstates().get(e.getMappedContext());
			/// iterate over the states and match the event with it, if its
			/// matches then return true, else return false

			for (State st : substates) {
				Edge beginEdge = st.getEdges(0);

				if (beginEdge.evaluateGraphEvent(e, r, st, this._statefullcache, this._kbstatefullcache)) {
					return 1;
				}
			}

		}

		return 0;

	}

	/**
	 * 
	 * @param e
	 * @param r
	 * @param s
	 * @return 0: dead, -5: dead for IF, and ok for FB, true, 0 false and the
	 *         run must be deleted
	 * @throws Exception
	 */
	private int evaluateAND(GraphEvent e, RunOptimised r, State s) throws Exception {

		/// Integrate the Manager State's hashmap for the timestamps

		if (!s.getSubstates().containsKey(e.getMappedContext()) && !s.get_timestampRuns().containsKey(r.getId())) {
			return -5;
		} else if (!s.getSubstates().containsKey(e.getMappedContext())) {
			return 0;
		} else {

			if (s.get_timestampRuns().containsKey(r.getId())) {
				long startTime = s.get_timestampRuns().get(r.getId());

				if (startTime != e.getTimeStamp()) {
					return 0; /// Why -1 over here should be 0
				}

			}

			Collection<State> substates = s.getSubstates().get(e.getMappedContext());
			/// iterate over the states and match the event with it, if its
			/// matches then return true, else return false

			for (State st : substates) {

				// if not yet matched
				if (!st.getStateStatus().contains(r.getId())) { /// There is an
																/// edge case
																/// over here
					Edge beginEdge = st.getEdges(0);

					if (beginEdge.evaluateGraphEvent(e, r, st, this._statefullcache, this._kbstatefullcache)) {

						/// First set computed to true, and copy the timestmap

						st.getStateStatus().add(r.getId());

						s.get_timestampRuns().put(r.getId(), e.getTimeStamp());

						/// Stuff for the AND operation

						/// if all the states are matches
						Collection<State> checkstate = s.getSubstates().values();

						/// if each substate contains the run id

						if (substates.stream().filter(x -> x.getStateStatus().contains(r.getId())).count() == checkstate
								.size()) {
							// check of stateful condition between sub-states of
							// the AND :: to be done on the next step

							return 1;
						} else {
							/// add an object over here to tell the other
							/// procedure that its a manager state
							return 5;

						}

					}
				}
			}
		}

		return 0;
	}

	public void evaluateFBOptimised(GraphEvent e, RunOptimised r) throws CloneNotSupportedException, Exception {
		if (this.checkTimeWindow(e, r)) {

			int result = processEvent(e, r);
			if (result == 1) { // the predicate if ok.

				final int oldState = r.getCurrentState();
				r.addGraphEvent(e);
				// final int newState = r.getCurrentState();
				if (oldState == r.getCurrentState()) {

					//
					if (r.isFull()) {

						results.outputMatches(e, r);
						Profiling.numberOfMatches++;
						if (ConfigFlags.partitionByPred.isEmpty())
							clearTheRunFromRunList(r);
						else

							clearThePartitionedRun(r);
						// this.toDeleteRuns.add(r);
						// }
					} else {

						// put the run in the active run list, instead of going
						// Kleene-+ State Check
						if (r.checkStateType(e)) {
							RunOptimised newerRun = this.cloneRun(r);
							// this.activeRuns.add(r);
							newerRun.proceed();
							if (newerRun.isComplete()) { // is full?

								results.outputMatches(e, newerRun);
								Profiling.numberOfMatches++;
								if (ConfigFlags.partitionByPred.isEmpty())
									clearTheRunFromRunList(r);
								else

									clearThePartitionedRun(r);
								// this.toDeleteRuns.add(newerRun);
							} else {

								if (ConfigFlags.partitionByPred.isEmpty())
									addRunNormal(newerRun);
								else
									addRunByPartition(newerRun);

							}

						} // /For kleene-+ state
					}
				} else { // /change the partition of the Run, only if you're
							// using the activeRunPar structure
							// Use the older State to get the event Type and
							// remove it from the map, and use the new
							// state to put it back in the map

					Set<Long> oldsID = this.nfa.getStates()[oldState].getEvetType();

					for (long ls : oldsID) {
						this.activeRunsPart.remove(ls, r);

					}
					/// newRuns replaced
					Set<Long> newsID = this.nfa.getStates()[r.getCurrentState()].getEvetType();

					for (long ns : newsID) {
						this.activeRunsPart.put(ns, r);

					}

				}

			} else if (result == 0) {

				State s = this.nfa.getStates(r.getCurrentState());

				if (s.isManager()) {
					if (ConfigFlags.partitionByPred.isEmpty())
						clearTheRunFromRunList(r);
					else

						clearThePartitionedRun(r);
					// this.toDeleteRuns.add(r);
				}

			}

		} else {

			if (ConfigFlags.partitionByPred.isEmpty())
				clearTheRunFromRunList(r);
			else

				clearThePartitionedRun(r);
			// this.toDeleteRuns.add(r);
			// / if the window is not good anymoreelse{
		}

	}

	/**
	 * Clones a run
	 * 
	 * @param r
	 *            the run to be cloned
	 * @return the new run cloned from the input run.
	 * @throws CloneNotSupportedException
	 */

	private RunOptimised cloneRun(RunOptimised r) throws CloneNotSupportedException {
		RunOptimised newRun = new RunOptimised();

		// TODO: here edit the clone for kleene+

		newRun = (RunOptimised) r.clone(++runCounter);

		handleDataforKleene(newRun.getId(), r.getCurrentState(), r.getId());
		/// get the data of r and use it in newRun

		// System.out.println(newRun.getId());
		Profiling.numberOfRuns++;
		return newRun;
	}

	/**
	 * Checks whether the event satisfies the predicates of a run
	 * 
	 * @param e
	 *            the current event
	 * @param r
	 *            the current run
	 * @return the check result
	 */

	public boolean checkRDFPredicate(GraphEvent e, RunOptimised r) throws Exception {

		State s = this.nfa.getStates(r.getCurrentState());

		// boolean checker = false;
		this.diffEventorNot = false;

		if (!s.evetType.contains(e.getMappedContext())) { /// check if the new
															/// event has the
															/// same tyoe of the
															/// current state
			this.diffEventorNot = true;
			return false;
		}

		if (!s.isKleeneClosure()) {
			Edge beginEdge = s.getEdges(0);

			return beginEdge.evaluateGraphEvent(e, r, s, this._statefullcache, this._kbstatefullcache);// Comments:evalutate
																										// predicate

		} else {
			if (r.isKleeneClosureInitialized()) {
				Edge takeEdge = s.getEdges(1);

				if (takeEdge.evaluateGraphEvent(e, r, s, this._statefullcache, _kbstatefullcache)) {

					return true;
				}

			} else {
				Edge beginEdge = s.getEdges(0);

				if (beginEdge.evaluateGraphEvent(e, r, s, this._statefullcache, _kbstatefullcache)) {

					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Checks whether the event satisfies the time window constraint of a run
	 * 
	 * @param e
	 *            the current event
	 * @param r
	 *            the current run
	 * @return the check result
	 * @throws InterruptedException
	 */

	public boolean checkTimeWindow(GraphEvent e, RunOptimised r) throws InterruptedException {

		/// First compare the timestamp of the newly arrived event and the
		/// window, if its greater than window, then move the window tumbling
		/// forward.
		//

		if (e.getTimeStamp() - r.getLifeTimeBegin() <= nfa.getTimeWindow()) {
			return true;
		}

		//
		return false;
	}

	/**
	 * Cleans useless runs by partition.
	 */
	// public void cleanRunsByPartition() {
	//
	// int size = this.toDeleteRuns.size();
	// RunOptimised tempRun = null;
	// ArrayList<RunOptimised> partitionedRuns = null;
	// for (int i = 0; i < size; i++) {
	// tempRun = toDeleteRuns.get(0);
	//
	// tempRun.resetRun();
	//
	// removeFromCache(tempRun.getId());
	// // TODO: change the active runs, they are not really used
	// // this.activeRuns.remove(tempRun);
	// this.toDeleteRuns.remove(0);
	// Profiling.numberOfRunsCutted++;
	// partitionedRuns =
	// this.activeRunsByPartition.get(tempRun.getPartitonId());
	// partitionedRuns.remove(tempRun);
	// if (partitionedRuns.size() == 0) {
	// this.activeRunsByPartition.remove(partitionedRuns);
	// }
	//
	// }
	//
	// }

	private void clearThePartitionedRun(RunOptimised tempRun) {
		removeFromCache(tempRun.getId());
		ArrayList<RunOptimised> partitionedRuns = null;

		partitionedRuns = this.activeRunsByPartition.get(tempRun.getPartitonId());
		// TODO: Can increase the processing speed by using a hashmap instead of
		// an array list
		partitionedRuns.remove(tempRun);
		if (partitionedRuns.size() == 0) {
			this.activeRunsByPartition.remove(partitionedRuns);
		}

		Profiling.numberOfRunsCutted++;

	}

	private void handleDataforKleene(int rID, int size, int oldrID) {

		for (int i = 0; i <= size; i++) {
			State copyState = nfa.getStates()[i];

			for (int j = 0; j < copyState.getNfaData().getAutomta().getStates().size(); j++) {
				// this._statefullcache.remove(new
				// RunStateMap(copyState.getOrder(), rID, j));

				_statefullcache.put(new RunStateMap(copyState.getOrder(), rID, j),
						_statefullcache.get(new RunStateMap(copyState.getOrder(), oldrID, j)));

			}

			if (copyState.getNfaData().getAutomta().getContainsKB() == 1) {

				// this._kbstatefullcache.remove(new KBindex(rID,
				// copyState.getOrder()));

				this._kbstatefullcache.put(new KBindex(rID, copyState.getOrder()),
						_kbstatefullcache.get(new KBindex(oldrID, copyState.getOrder())));
			}

		}

	}

	private void removeFromCache(int rID) {

		for (int i = 0; i < nfa.getStates().length; i++) {
			State rmoveState = nfa.getStates()[i];

			if (!rmoveState.isManager()) {

				for (int j = 0; j < rmoveState.getNfaData().getAutomta().getStates().size(); j++) {
					this._statefullcache.remove(new RunStateMap(rmoveState.getOrder(), rID, j));
				}

				if (rmoveState.getNfaData().getAutomta().getContainsKB() == 1) {

					this._kbstatefullcache.remove(new KBindex(rID, rmoveState.getOrder()));
				}
			} else {

				// get the substates

				for (State s : rmoveState.getSubstates().values()) {

					/// remove the hashmap stuff from here
					if (s.getStateStatus().contains(rID)) {

						for (int j = 0; j < s.getNfaData().getAutomta().getStates().size(); j++) {
							this._statefullcache.remove(new RunStateMap(s.getOrder(), rID, j));
						}

						if (s.getNfaData().getAutomta().getContainsKB() == 1) {

							this._kbstatefullcache.remove(new KBindex(rID, s.getOrder()));
						}

						rmoveState.get_timestampRuns().remove(rID);

						s.getStateStatus().remove(rID);

						// System.out.println();
					}
				}

			}

			//// If its a Manager then go through the substates and first delete
			//// the stuff from the hashmap of manager state

		}

	}

	private void createNewRunByPartition(GraphEvent e) throws CloneNotSupportedException, Exception {
		if (this.nfa.getStates()[0].canStartWithGraphEvent(e, this._statefullcache, _kbstatefullcache,
				++this.runCounter)) {

			RunOptimised newRun = new RunOptimised();// this.engineRunController.getRun();
			newRun.initializeRun(this.nfa, e.getTimeStamp(), this.runCounter);

			newRun.addGraphEvent(e, this.partitionKey);
			// this.numberOfRuns.update(1);
			Profiling.numberOfRuns++;
			// this.activeRuns.add(newRun);
			this.addRunByPartition(newRun);

		}

	}

	private void addRunNormal(RunOptimised newRun) {
		Set<Long> newsID = this.nfa.getStates()[newRun.getCurrentState()].getEvetType();

		for (long ns : newsID) {
			this.activeRunsPart.put(ns, newRun);

		}
	}

	private void addRunByPartition(RunOptimised newRun) {
		if (this.activeRunsByPartition.containsKey(newRun.getPartitonId())) {
			this.activeRunsByPartition.get(newRun.getPartitonId()).add(newRun);
		} else {
			ArrayList<RunOptimised> newPartition = new ArrayList<RunOptimised>();
			newPartition.add(newRun);
			this.activeRunsByPartition.put(newRun.getPartitonId(), newPartition);
		}
	}

	/**
	 * Cleans useless runs
	 */

	private void removeFromCacheForFirstState(int id, int rID) {
		State rmoveState = nfa.getStates()[id];

		if (!rmoveState.isManager()) {

			for (int j = 0; j < rmoveState.getNfaData().getAutomta().getStates().size(); j++) {
				this._statefullcache.remove(new RunStateMap(rmoveState.getOrder(), rID, j));
			}

			if (rmoveState.getNfaData().getAutomta().getContainsKB() == 1) {

				this._kbstatefullcache.remove(new KBindex(rID, rmoveState.getOrder()));
			}
		} else {

			// get the substates

			for (State s : rmoveState.getSubstates().values()) {
				if (s.getStateStatus().contains(rID)) {

					for (int j = 0; j < s.getNfaData().getAutomta().getStates().size(); j++) {
						this._statefullcache.remove(new RunStateMap(s.getOrder(), rID, j));
					}

					if (s.getNfaData().getAutomta().getContainsKB() == 1) {

						this._kbstatefullcache.remove(new KBindex(rID, s.getOrder()));
					}

					rmoveState.get_timestampRuns().remove(rID);

					s.getStateStatus().remove(rID);
				}
			}

		}
	}

	@Override
	protected void streamPartitionedEngine(GraphEvent e) throws CloneNotSupportedException, Exception {
		evaluateRunsForStreamPartition(e);

		// if (this.toDeleteRuns.size() > 0) {
		// this.cleanRunsForStreamPartition();
		// }
		this.createNewRunForStreamPartition(e);

		// ////////

		// Profiling.totalRunTime += (System.nanoTime() - currentTime);
		Profiling.numberOfEvents += 1;

	}

	private void cleanRunsForStreamPartition() {
		int size = this.toDeleteRuns.size();
		RunOptimised tempRun = null;
		for (int i = 0; i < size; i++) {
			tempRun = toDeleteRuns.get(0);
			// Profiling.totalRunLifeTime += (System.nanoTime() -
			// tempRun.getLifeTimeBegin());
			Set<Long> sIds = this.nfa.getStates()[tempRun.getCurrentState()].getEvetType();
			if (tempRun.getClone() == 0) {
				this.removeFromCache(tempRun.getId());

			}

			// this.activeRuns.remove(tempRun);

			for (Long id : sIds) {
				activeRunsPart.remove(id, tempRun);
			}

			tempRun.resetRun();

			this.toDeleteRuns.remove(0);
			Profiling.numberOfRunsCutted++;
		}

	}

	private void clearTheRunFromRunList(RunOptimised r) {
		Set<Long> sIds = this.nfa.getStates()[r.getCurrentState()].getEvetType();

		if (r.getClone() == 0) {
			this.removeFromCache(r.getId());

		}

		for (Long id : sIds) {
			activeRunsPart.remove(id, r);
		}
		r = null;
		Profiling.numberOfRunsCutted++;

	}

	private void evaluateRunsForStreamPartition(GraphEvent e) throws CloneNotSupportedException, Exception {

		if (this.activeRunsPart.containsKey(e.getMappedContext())) {

			streamPartitionedRuns.clear();
			streamPartitionedRuns.addAll(activeRunsPart.get(e.getMappedContext()));

			// MutableList<RunOptimised> partitionedRuns =
			// this.activeRunsPart.get(e.getMappedContext());

			// MutableBag<RunOptimised> partitionedRuns =
			// this.activeRunsPart.get(e.getMappedContext());
			// Iterator it= partitionedRuns.iterator();
			//
			// while(it.hasNext()){
			// RunOptimised r = (RunOptimised) it.next();
			// }

			for (int i = 0; i < streamPartitionedRuns.size(); i++) {
				RunOptimised r = streamPartitionedRuns.get(i);
				// RunOptimised r = partitionedRuns.get(i);
				if (r.isFull()) {
					continue;
				}

				switch (ConfigFlags.selectionStrategy) // 1: STN, 2: STA, 3: SC
				{
				case 1:
					this.evaluateFBOptimised(e, r);
					break;

				case 3:
					this.evaluateIF(e, r);
					break;

				}

			}
		}
	}

	private void createNewRunForStreamPartition(GraphEvent e) throws Exception {

		State firstState = this.nfa.getStates()[0];

		if (firstState.canStartWithGraphEvent(e, this._statefullcache, _kbstatefullcache, ++this.runCounter)) { // Check
																												// if
																												// the
																												// incoming
																												// event
																												// type
																												// can
																												// start
																												// the
																												// new
																												// run
																												// or
																												// not?

			RunOptimised newRun = new RunOptimised();// this.engineRunController.getRun();
			newRun.initializeRun(this.nfa, e.getTimeStamp(), this.runCounter);

			newRun.addGraphEvent(e);

			Profiling.numberOfRuns++;

			Set<Long> sIds = this.nfa.getStates()[newRun.getCurrentState()].getEvetType();

			for (Long id : sIds) {
				this.activeRunsPart.put(id, newRun);
			}

		} else {

			// Remove from the cache if the event doesn't match with the current
			// state

			removeFromCacheForFirstState(0, this.runCounter);

		}
	}

}
