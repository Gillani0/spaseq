/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.cep.engine.optimised;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.parser.NxParser;

import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomst.graph.processing.ConstrcutCaluse;
import edu.telecomst.graph.processing.GraphEvent;
import edu.telecomst.graph.processing.GraphTriple;
import edu.telecomst.graph.processing.MappedEvent;
import edu.telecomstet.cep.UI.ResultWriter;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.knowledgebase.KBRule;
import edu.telecomstet.cep.nfahelpers2.Edge;
import edu.telecomstet.cep.nfahelpers2.NFA;
import edu.telecomstet.cep.nfahelpers2.State;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.Rule;

/**
 *
 * @author sydgillani
 */
public class EngineNormal implements Runnable {
	private List<NFAData> _nfaDataList;
	int test = 0; // TODO:delte
	private CountDownLatch latch;

	private List<Rule> constClause;

	//private int dummy = 0;
	private BlockingQueue<GraphEvent> queue;

	private long partitionKey;
	//private long currentTime = 0;

	private boolean diffEventorNot;
	int runCounter;
	private BlockingQueue<String> resultqueue;

	private DictionaryOpImpl _dictImpl;

	// private LocalTime timeCheck=null;

	private NxParser inputS;

	//private int graphsize = 11;
	//private int counter = 0;
	/**
	 * RDF Based Event Buffer // Can use a single one or set of buffers
	 * depending on states
	 */
	// private RDFEventBuffer rdfbuffer;

	HashMap<Long, ArrayList<RunOptimised>> activeRunsByPartition;

	private NFA nfa;

	//private int _stgy;
	// private HashMap<Integer, MultiBiMap<SP, OP> > cache;
	/**
	 * The run pool, which is used to reuse the run data structure.
	 */
	private RunPool engineRunController;
	/**
	 * The active runs in memory
	 */
	private ArrayList<RunOptimised> activeRuns;

	/**
	 * The runs which can be removed from the active runs.
	 */
	private ArrayList<RunOptimised> toDeleteRuns;
	private Thread writingThread;

	private ConstrcutCaluse constFunc;
	// private HashMap<RunStateMap, MultiBiMap<SP, OP> > tt=
	// newHashMapWithExpectedSize(5000);
	private final Map<RunStateMap, MultiBidirectionalIndex> _statefullcache = HashObjObjMaps.newMutableMap();

	private final Map<KBindex, MultiBiMap<Long, SP>> _kbstatefullcache = HashObjObjMaps.newMutableMap();

	// private final HashMap<RunStateMap, MultiBidirectionalIndex >
	// _statefullcache =newHashMapWithExpectedSize(10000);
	/**
	 * The matches
	 */

	

	public void initialise() {
		this.resultqueue = new ArrayBlockingQueue<>(10000);
		this.runCounter = 0;
		if (this.constClause != null) {
			constFunc = new ConstrcutCaluse(constClause, resultqueue);
		}
		engineRunController = new RunPool();
		/// cache = new ArrayList<>();
		// buffer = new EventBuffer();
		// this.cache=new HashMap();
		this.activeRuns = new ArrayList<RunOptimised>();
		this.activeRunsByPartition = new HashMap<Long, ArrayList<RunOptimised>>();
		this.toDeleteRuns = new ArrayList<RunOptimised>();

		///// Result Queue Stuff////

		final ResultWriter resultWriter = new ResultWriter(1, resultqueue);
		this.writingThread = new Thread(resultWriter);
		writingThread.setName("QPWriter" + 1);
		writingThread.start();

		Profiling.resetProfiling();
	}

	@Override
	public void run() {
		if (this._nfaDataList.get(0).getPatterndata().getPattSelection().equals(",")) {
			ConfigFlags.selectionStrategy = 3;
		} else {
			ConfigFlags.selectionStrategy = 1;
		}

		ConfigFlags.sequenceLength = this.nfa.getSize();

		ConfigFlags.hasNegation = this.nfa.isHasNegation();

		configPartitionBy();

		if (!ConfigFlags.partitionByPred.isEmpty()) {

			GraphEvent event = null;
			;
			for (;;) {

				try {
					event = this.queue.take();

					if (event.getId() != -1) {
						this.partitionBYEngine(event);
					} else {

						break;
					}

				} catch (InterruptedException e) {

					e.printStackTrace();
				} catch (CloneNotSupportedException e) {

					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		} else {

			GraphEvent event = null;
			;
			for (;;) {

				try {
					event = this.queue.take();

					if (event.getId() != -1) {
						this.runGraphEventProcessing(event);
					} else {

						break;
					}

				} catch (InterruptedException e) {

					e.printStackTrace();
				} catch (CloneNotSupportedException e) {

					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		}

		
		this.finish();
		// latch.countDown();
	}

	public void partitionBYEngine(GraphEvent e) throws CloneNotSupportedException, Exception {
		// GraphEvent e =null;//new
		// GraphEvent(counter,System.nanoTime(),mapE,this._dictImpl,this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI());

		// if(e.getId()==6){
		// System.out.println("d");
		// }
		evaluateRunsForPartitionContiguity(e);
		// this.evaluateRunsForPartitionContiguity(new
		// GraphEvent(counter,System.nanoTime(),mapE,this._dictImpl,this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI()),this._stgy);
		if (this.toDeleteRuns.size() > 0) {
			this.cleanRunsByPartition();
		}
		this.createNewRunByPartition(e);

		//////////

		// Profiling.totalRunTime += (System.nanoTime() - currentTime);
		Profiling.numberOfEvents += 1;
	}
/*
	public void runEngine() throws Exception {

		if (this._nfaDataList.get(0).getPatterndata().getPattSelection().equals(",")) {
			ConfigFlags.selectionStrategy = 3;
		} else {
			ConfigFlags.selectionStrategy = 1;
		}

		ConfigFlags.sequenceLength = this.nfa.getSize();

		ConfigFlags.hasNegation = this.nfa.isHasNegation();

		configPartitionBy();

		if (!ConfigFlags.partitionByPred.isEmpty()) {
			//runPartitionedByEngine();
		} else {
			runNormalEngine();
		}

	}

	*/
	
	/*
	public void runPartitionedByEngine() throws Exception {

		Node[] nxx = null;

		int i = 0;

		int counter = 0;
		// String context="<http://example.org/main>";

		List<MappedEvent> mapE = new ArrayList<>();

		// this.runSkipTillAnyRDFEngine(); ///map the events over here
		// long currentTime = 0;
		System.out.println("Process Started");
		while (inputS.hasNext()) {
			nxx = inputS.next();

			mapE.add(new GraphTriple(nxx, this.getDictImpl()).getMappedEvent());

			i++;
			if (i == graphsize) {

				/// make a new graph over here
				counter++; /// put it in the adaptive dictionary over here
				// System.out.println(counter);
				/// 1 skip till next, 2, skip till any, 3, strict contiguity
				// System.out.println(checker);

				// this.runGraphEventProcessing(new
				// GraphEvent(counter,System.nanoTime(),mapE,this._dictImpl,this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI()),this._stgy);
				i = 0;

				currentTime = System.nanoTime();
				//////////

			
				// replacing this
				// "this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI()"
				GraphEvent e = null;// new
									// GraphEvent(counter,System.nanoTime(),mapE,this._dictImpl,this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI());
				evaluateRunsForPartitionContiguity(e);
				// this.evaluateRunsForPartitionContiguity(new
				// GraphEvent(counter,System.nanoTime(),mapE,this._dictImpl,this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI()),this._stgy);
				if (this.toDeleteRuns.size() > 0) {
					this.cleanRunsByPartition();
				}
				this.createNewRunByPartition(e);

				//////////

				// Profiling.totalRunTime += (System.nanoTime() - currentTime);
				Profiling.numberOfEvents += 1;

				mapE.clear();

			}
		}

	}
*/
	/*
	public void runNormalEngine() throws Exception {

		Node[] nxx = null;

		int i = 0;
		int counter = 0;
		// String context="<http://example.org/main>";

		List<MappedEvent> mapE = new ArrayList<>();

		// this.runSkipTillAnyRDFEngine(); ///map the events over here
		// long currentTime = 0;
		System.out.println("Process Started");
		while (inputS.hasNext()) {
			nxx = inputS.next();

			// checker++;
			// nxx = inputS.next();
			mapE.add(new GraphTriple(nxx, this.getDictImpl()).getMappedEvent());
			// tripleSet.add(nxx);
			i++;
			if (i == graphsize) {
				/// make a new graph over here
				counter++; /// put it in the adaptive dictionary over here
				/// 1 skip till next, 2, skip till any, 3, strict contiguity
				// TODO: send the context according to the incoming event by
				/// replacing this
				/// "this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI()"
				// this.runGraphEventProcessing(new
				/// GraphEvent(counter,System.nanoTime(),mapE,this._dictImpl,this._nfaDataList.get(0).getStreamList().get(0).getMappedStreamURI()));
				i = 0;
				mapE.clear();
				// this._dictImpl.refresh();
				// mapE.add(new GraphTriple(nxx,this.getDictImpl()
				// ).getMappedEvent());
			}
		}

		////////////////////////

	}
*/
	public void runGraphEventProcessing(GraphEvent e) throws CloneNotSupportedException, Exception {

		//// update the incoming edges////////
		this.evaluateGraphRuns(e);// add the ID of the selection strategies 1:
									// STN, 2: STA, 3: SC
		/// if the event is comsumed during this procedure then there is no
		/// point of creating a new run?
		if (this.toDeleteRuns.size() > 0) {
			this.cleanRuns();
		}
		this.createNewGraphRun(e);// create new run starting with this event if
									// possible ///chenge into RDF ones

		Profiling.numberOfEvents += 1;

	}

	public void evaluateGraphRuns(GraphEvent e) throws CloneNotSupportedException, Exception {
		int size = this.activeRuns.size();
		for (int i = 0; i < size; i++) {
			RunOptimised r = this.activeRuns.get(i);

			if (r.isFull()) {
				this.toDeleteRuns.add(r); /// later change it

				continue;
			}

			switch (ConfigFlags.selectionStrategy) // 1: STN, 2: STA, 3: SC
			{
			case 1:
				// this.evaluateIF(e, r);
				this.evaluateFBOptimised(e, r);
				break;
			case 2:
				// this.evaluateSTA(e, r);
				break;
			case 3:
				this.evaluateIF(e, r);
				break;

			}
			/// over here the condition for selection strategy
		}
	}

	/**
	 * TO Evaluate Run for incoming events and Followed By
	 * 
	 * @param e
	 * @param r
	 * @throws CloneNotSupportedException
	 */
/*
	public void evaluateFB(GraphEvent e, RunOptimised r) throws CloneNotSupportedException, Exception {
		boolean checkResult = true;

		/// Before check the predicate check if the next state statisfies this
		/// event or not

		/// if so then do nothing else check it do the following normal stuff///

		if (checkNegationState(e, r)) {

			// if(r.getCurrentState()==2){
			// System.out.println("Here ");
			// }

			checkResult = this.checkRDFPredicate(e, r);// check predicate

			// TODO: In case if check result is not true, and the state is the
			// optional one, then go for it.
			if (checkOptionalState(r)) {
				/// if its an optional state, then simply check the checkRrsult
				checkResult = true;
			}

			if (checkResult) { // the predicate if ok.
				checkResult = this.checkTimeWindow(e, r); // the time window is
															// ok
				if (checkResult) {// predicate and time window are ok

					/// Check the type of the state
					/// if its normal then go about the same business, else use
					/// the kleene start stuff

					// this.rdfbuffer.bufferRDFEvent(e);// add the event to
					// buffer
					int oldState = 0; // make them gloabl variables
					int newState = 0;

					/// Run newRun = this.cloneRun(r); // clone this run

					oldState = r.getCurrentState();
					r.addGraphEvent(e); // add the event to this run
					newState = r.getCurrentState(); // Add the Branch Union
													// operator in add RDF stuff
					if (oldState == newState) {
						// this.activeRuns.add(newRun);
						// }else{//kleene closure

						//
						if (r.isFull()) {
							// check match and output match
							if (r.checkMatch()) {
								/// close the executor service
								// shutDownService(newRun);
								// this.outputMatch(new Match(newRun, this.nfa,
								/// this.rdfbuffer));

								/// Output the matches events
								/// this._dictImpl.refresh();
								outputMatches(e, r);
								Profiling.numberOfMatches++;
								// Profiling.totalRunLifeTime +=
								// (System.nanoTime() - r.getLifeTimeBegin());
								this.toDeleteRuns.add(r);
							}
						} else {

							if (r.checkStateType(e)) {
								RunOptimised newerRun = this.cloneRun(r);

								newerRun.proceed();
								// this.activeRuns.add(newerRun );///Addition
								// for the RDF Matching
								if (newerRun.isComplete()) {
									// newerRun.getNfa().getStates()
									// shutDownService(newerRun);
									//// close the executor service
									// this.outputMatch(new Match(r, this.nfa,
									// this.rdfbuffer));
									// this._dictImpl.refresh();
									outputMatches(e, newerRun);
									Profiling.numberOfMatches++;
									// Profiling.totalRunLifeTime +=
									// (System.nanoTime() -
									// r.getLifeTimeBegin());
									this.toDeleteRuns.add(newerRun);
								} else {
									this.activeRuns.add(newerRun);
								}
							}
						}
					}
				} else {
					this.toDeleteRuns.add(r);
				}

			}

		} // else{///It could be Kleene clouse state so check if the type of the
			// state is kleene clouse
			/// if so then send the event to the next one if the counter of the
			// kleene state is >=1
			//// check-proceed

		// checkKleeneProceed( r, e);
		// }
	}
*/
	/**
	 * TO Evaluate Run for incoming Graphs with skip-till-any match Strategy
	 * 
	 * @param e
	 * @param r
	 * @throws CloneNotSupportedException
	 */
	/*
	 * public void evaluateSTA(GraphEvent e, RunOptimised r) throws
	 * CloneNotSupportedException, Exception{ boolean checkResult = true;
	 * 
	 * /// Before check the predicate check if the next state statisfies this
	 * event or not
	 * 
	 * ///if so then do nothing else check it do the following normal stuff///
	 * 
	 * if(checkNegationState(e,r)) { ///some optimisation over here///
	 * 
	 * checkResult = this.checkRDFPredicate(e, r);// check predicate
	 * if(checkResult){ // the predicate if ok. checkResult =
	 * this.checkTimeWindow(e, r); // the time window is ok if(checkResult){//
	 * predicate and time window are ok
	 * 
	 * 
	 * ///Check the type of the state ///if its normal then go about the same
	 * business, else use the kleene start stuff
	 * 
	 * 
	 * // this.rdfbuffer.bufferRDFEvent(e);// add the event to buffer int
	 * oldState = 0; int newState = 0;
	 * 
	 * 
	 * RunOptimised newRun = this.cloneRun(r); // clone this run
	 * 
	 * 
	 * oldState = newRun.getCurrentState(); newRun.addGraphEvent(e); // add the
	 * event to this run newState = newRun.getCurrentState(); // Add the Branch
	 * Union operator in add RDF stuff if(oldState != newState){
	 * this.activeRuns.add(newRun); }else{//kleene closure
	 * 
	 * // if(newRun.isFull()){ //check match and output match
	 * if(newRun.checkMatch()){ ///close the executor service //
	 * shutDownService(newRun); //this.outputMatch(new Match(newRun, this.nfa,
	 * this.rdfbuffer)); // this._dictImpl.refresh(); Profiling.numberOfMatches
	 * ++; Profiling.totalRunLifeTime += (System.nanoTime() -
	 * r.getLifeTimeBegin());
	 * 
	 * } }else{ ///check the newRun.addEevent() checkStateType
	 * 
	 * ////add the newrun in the list
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //put the run in the active run list, instead of going for chek proceed
	 * //check proceed // if(this.checkProceed(newRun,e)){ ///change this
	 * Addition for RDf Matching if(newRun.checkStateType( e)){ RunOptimised
	 * newerRun = this.cloneRun(newRun); this.activeRuns.add(newRun);
	 * newerRun.proceed(); ///Addition for the RDF Matching
	 * if(newerRun.isComplete()){ // newerRun.getNfa().getStates() //
	 * shutDownService(newerRun); ////close the executor service
	 * //this.outputMatch(new Match(r, this.nfa, this.rdfbuffer)); //
	 * this._dictImpl.refresh(); Profiling.numberOfMatches ++;
	 * Profiling.totalRunLifeTime += (System.nanoTime() - r.getLifeTimeBegin());
	 * 
	 * }else { this.activeRuns.add(newerRun); } } } }
	 * 
	 * 
	 * 
	 * }else{ this.toDeleteRuns.add(r); }
	 * 
	 * }else{///It could be Kleene clouse state so check if the type of the
	 * state is kleene clouse ///if so then send the event to the next one if
	 * the counter of the kleene state is >=1 ////check-proceed
	 * 
	 * // checkKleeneProceed( r, e); } } }
	 * 
	 * 
	 * 
	 */

	public void evaluateFBOptimised(GraphEvent e, RunOptimised r) throws CloneNotSupportedException, Exception {
		// boolean checkResult = true;

		/// Before check the predicate check if the next state statisfies this
		/// event or not

		/// if so then do nothing else check it do the following normal stuff///

		if (this.checkTimeWindow(e, r)) {

			// if(checkNegationState(e,r)) {

			// checkResult = this.checkRDFPredicate(e, r);// check predicate
			//
			// if(checkOptionalState(r)){
			// ///if its an optional state, then simply check the checkRrsult
			// checkResult=true;
			// }

			//// if check result is false the check if the event belongs to the
			//// same stream or not
           int result=processEvent(e, r);
			if (result== 1) { // the predicate if ok.
				// checkResult = this.checkTimeWindow(e, r); // the time window
				// is ok
				// if(checkResult){// predicate and time window are ok

				/// Check the type of the state
				/// if its normal then go about the same business, else use the
				/// kleene start stuff

				// this.rdfbuffer.bufferRDFEvent(e);// add the event to buffer
				int oldState = 0; // make them gloabl variables
				int newState = 0;

				/// Run newRun = this.cloneRun(r); // clone this run

				oldState = r.getCurrentState();
				r.addGraphEvent(e); // add the event to this run
				newState = r.getCurrentState(); // Add the Branch Union operator
												// in add RDF stuff
				if (oldState == newState) {
					// this.activeRuns.add(newRun);
					// }else{//kleene closure

					//
					if (r.isFull()) {
						// check match and output match
						//if (r.checkMatch()) {
							/// close the executor service
							// shutDownService(newRun);
							// this.outputMatch(new Match(newRun, this.nfa,
							/// this.rdfbuffer));
							// this._dictImpl.refresh();

							this.outputMatches(e, r);
							Profiling.numberOfMatches++;
							// Profiling.totalRunLifeTime += (System.nanoTime()
							// - r.getLifeTimeBegin());
							// r.addGraphEvent(e);
							this.toDeleteRuns.add(r);
						//}
					} else {

						// put the run in the active run list, instead of going
						// for chek proceed
						// check proceed
						// if(this.checkProceed(newRun,e)){ ///change this
						// Addition for RDf Matching
						if (r.checkStateType(e)) {
							RunOptimised newerRun = this.cloneRun(r);
							// this.activeRuns.add(r);
							newerRun.proceed(); /// Addition for the RDF
												/// Matching
							if (newerRun.isComplete()) {
								// newerRun.getNfa().getStates()
								// shutDownService(newerRun);
								//// close the executor service
								// this.outputMatch(new Match(r, this.nfa,
								// this.rdfbuffer));
								// this._dictImpl.refresh();
								this.outputMatches(e, newerRun);
								Profiling.numberOfMatches++;
								// Profiling.totalRunLifeTime +=
								// (System.nanoTime() - r.getLifeTimeBegin());
								this.toDeleteRuns.add(newerRun);
							} else {
								this.activeRuns.add(newerRun);
							}

						}
					}
				}

			} else if (result==0){
				
				///over here check if its the AND state or NOT
				State s = this.nfa.getStates(r.getCurrentState());
				
				 if (!s.isManager()){
					
					if (!this.diffEventorNot) {
						this.toDeleteRuns.add(r);
					}
				}else{
					this.toDeleteRuns.add(r);
				}
				
				
			}
			// }//else{///It could be Kleene clouse state so check if the type
			// of the state is kleene clouse
			/// if so then send the event to the next one if the counter of the
			// kleene state is >=1
			//// check-proceed

			// checkKleeneProceed( r, e);
			// }
		} else {
			this.toDeleteRuns.add(r);
			/// if the window is not good anymoreelse{
		}

	}

	/**
	 * To Evaluate Run for incoming events and Immediate Follow
	 * 
	 * @param e
	 * @param r
	 * @throws CloneNotSupportedException
	 */

	private void evaluateIF(GraphEvent e, RunOptimised r) throws CloneNotSupportedException, Exception {
		// boolean checkResult = true;

		/// Before check the predicate check if the next state statisfies this
		/// event or not

		/// if so then do nothing else check it do the following normal stuff///

		if (this.checkTimeWindow(e, r)) {

			// if(checkNegationState(e,r)) {

			// checkResult = this.checkRDFPredicate(e, r);// check predicate
			//
			// if(checkOptionalState(r)){
			// ///if its an optional state, then simply check the checkRrsult
			// checkResult=true;
			// }
			int result = processEvent(e, r);
			if (result == 1) { // the predicate if ok.
				// checkResult = this.checkTimeWindow(e, r); // the time window
				// is ok
				// if(checkResult){// predicate and time window are ok

				/// Check the type of the state
				/// if its normal then go about the same business, else use the
				/// kleene start stuff

				// this.rdfbuffer.bufferRDFEvent(e);// add the event to buffer
				int oldState = 0; // make them gloabl variables
				int newState = 0;

				/// Run newRun = this.cloneRun(r); // clone this run

				oldState = r.getCurrentState();
				r.addGraphEvent(e); // add the event to this run
				newState = r.getCurrentState(); // Add the Branch Union operator
												// in add RDF stuff
				if (oldState == newState) {
					// this.activeRuns.add(newRun);
					// }else{//kleene closure

					//
					if (r.isFull()) {
						// check match and output match
					//	if (r.checkMatch()) {
							/// close the executor service
							// shutDownService(newRun);
							// this.outputMatch(new Match(newRun, this.nfa,
							/// this.rdfbuffer));
							// this._dictImpl.refresh();
							// TODO add this for output
							 this.outputMatches(e, r);
							Profiling.numberOfMatches++;
							// Profiling.totalRunLifeTime += (System.nanoTime()
							// - r.getLifeTimeBegin());
							this.toDeleteRuns.add(r);
					//	}
					} else {

						// put the run in the active run list, instead of going
						// for chek proceed
						// check proceed
						// if(this.checkProceed(newRun,e)){ ///change this
						// Addition for RDf Matching
						if (r.checkStateType(e)) { //TODO: WHY?
							RunOptimised newerRun = this.cloneRun(r);
							// this.activeRuns.add(r);
							newerRun.proceed(); /// Addition for the RDF
												/// Matching
							if (newerRun.isComplete()) {
								// newerRun.getNfa().getStates()
								// shutDownService(newerRun);
								//// close the executor service
								// this.outputMatch(new Match(r, this.nfa,
								// this.rdfbuffer));
								// this._dictImpl.refresh();
								this.outputMatches(e, newerRun);
								Profiling.numberOfMatches++;
								// Profiling.totalRunLifeTime +=
								// (System.nanoTime() - r.getLifeTimeBegin());
								this.toDeleteRuns.add(newerRun);
							} else {
								this.activeRuns.add(newerRun);
							}

						}
					}
				}

				// }

			} else if (result <=0){

				/// check for AND state, if the current state is a manager and
				/// is partially matched ==true then don't delete it
				
					this.toDeleteRuns.add(r);
			
			}

			// }

		} else {
			this.toDeleteRuns.add(r);
		}
	}

	/**
	 * TO create New Run and evaluate Graph on it
	 * 
	 * @param e
	 * @throws EvaluationException
	 * @throws IOException
	 * @throws edu.rpi.twc.sesamestream.QueryEngine.InvalidQueryException
	 * @throws edu.rpi.twc.sesamestream.QueryEngine.IncompatibleQueryException
	 */
	public void createNewGraphRun(GraphEvent e) throws Exception { /// not
																	/// handling
																	/// the
																	/// kleene
																	/// closure
																	/// and
																	/// contaction
																	/// at the
																	/// begining
																	/// of the
																	/// pattern
		//counter++;

		// send the count of the run and the state id as 1, then
		/// if the event is accepted then take it and use it

		/**
		 * Two different Cases //TODO: Case 1: if the first state is not the negation, Case 2: if the first state is the Negation one
		 * Case 1: Simple use the already implemented method.
		 * Case 2: Extension of the general case, where check the next state unless all the matched.
		 * 
		 */
		
		State firstState = this.nfa.getStates()[0];
		
		if(!firstState.isNegation()){
			
			
			
			startTheNon_Negation_Run(e,firstState);
			
			return;
		}
		
		
		
		// Case 2 Implementation ///
		
		///First check if the state and event has the same IRI

 int re= firstState.negationStateProcess(e,this._statefullcache, _kbstatefullcache,
			++this.runCounter);
  
  switch(re){
  
  case 1:
	  
	  break;
  case 0:
	  
	  ///delete the stuff from the cache and carry on
	  removeFromCacheForFirstState(0,this.runCounter);
	  break;
  case 2:
	  
	  if( this.nfa.getStates().length>=2)
	  startTheSecondState_for_Negation(e, this.nfa.getStates()[1]);
	  
	  break;
  
  }
  
  
	
	
	}
	
	
	private void startTheSecondState_for_Negation(GraphEvent e, State secondState) throws Exception{
		if (secondState.canStartWithGraphEvent(e, this._statefullcache, _kbstatefullcache,
				++this.runCounter)) { // Comment: Check if the incoming event
										// type can start the engine or not?
			// this.rdfbuffer.bufferRDFEvent(e); //If yes then add the event to
			// the buffer
			RunOptimised newRun = this.engineRunController.getRun();
			newRun.initializeRun(this.nfa, e.getTimeStamp(), this.runCounter); /// initialise
																				/// run
																				/// in
																				/// a
																				/// distributed
																				/// way

			newRun.addGraphEvent(e);

			newRun.addGraphEvent(e);

			// newRun.setCache(cache);
			// cache=null;
			// newRun= negationCount(e,newRun); later on for the negation engine
			// you to finialise it
			// this.numberOfRuns.update(1);
			Profiling.numberOfRuns++;
			this.activeRuns.add(newRun);

		} else {
			// TODO: URGENTLY REMOVE the new RUN STUFF if it does not match with
			// this one Revome stuff from the map
			// this._statefullcache.remove(new RunStateMap(this.runCounter,0));
			// this.runCounter--;
			
			removeFromCacheForFirstState(1,this.runCounter);
			//removeFromCache(this.runCounter);
		}
	}
	
	
	private void startTheNon_Negation_Run(GraphEvent e, State firstState) throws Exception{

		if (firstState.canStartWithGraphEvent(e, this._statefullcache, _kbstatefullcache,
				++this.runCounter)) { // Comment: Check if the incoming event
										// type can start the engine or not?
			// this.rdfbuffer.bufferRDFEvent(e); //If yes then add the event to
			// the buffer
			RunOptimised newRun = this.engineRunController.getRun();
			newRun.initializeRun(this.nfa, e.getTimeStamp(), this.runCounter); /// initialise
																				/// run
																				/// in
																				/// a
																				/// distributed
																				/// way

			newRun.addGraphEvent(e);

			// newRun.setCache(cache);
			// cache=null;
			// newRun= negationCount(e,newRun); later on for the negation engine
			// you to finialise it
			// this.numberOfRuns.update(1);
			Profiling.numberOfRuns++;
			this.activeRuns.add(newRun);

		} else {
			// TODO: URGENTLY REMOVE the new RUN STUFF if it does not match with
			// this one Revome stuff from the map
			// this._statefullcache.remove(new RunStateMap(this.runCounter,0));
			// this.runCounter--;
			
			
			removeFromCacheForFirstState(0,this.runCounter);
		//	removeFromCache(this.runCounter);
		}
	
	}

	/**
	 * Cleans useless runs
	 */
	public void cleanRuns() {

		// System.out.println("In here");
		int size = this.toDeleteRuns.size();
		RunOptimised tempRun = null;
		for (int i = 0; i < size; i++) {
			tempRun = toDeleteRuns.get(0);
			// Profiling.totalRunLifeTime += (System.nanoTime() -
			// tempRun.getLifeTimeBegin());

			if (tempRun.getClone() == 0) {
				this.removeFromCache(tempRun.getId());

			}
			tempRun.resetRun();
			this.activeRuns.remove(tempRun);

			this.toDeleteRuns.remove(0);
			Profiling.numberOfRunsCutted++;
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

	public RunOptimised cloneRun(RunOptimised r) throws CloneNotSupportedException {
		RunOptimised newRun = this.engineRunController.getRun();
		newRun = (RunOptimised) r.clone(r.getId());
		// System.out.println(newRun.getId());
		Profiling.numberOfRuns++;
		return newRun;
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
		// if(e.getTimeStamp() > this.getNfa().getTimeWindow()){
		// this.nfa.reloeadWindow();
		// }
		//

		// System.out.println(e.getTimeStamp()+" "+r.getLifeTimeBegin());

		// System.out.println(e.getTimeStamp()-r.getLifeTimeBegin() +"
		// "+this.getNfa().getTimeWindow());

		if (e.getTimeStamp() - r.getLifeTimeBegin() <= this.getNfa().getTimeWindow()) {
			return true;
		}

		// if(this.nfa.getTimeWindow() > r.getStartTimeStamp()){
		// return true;
		// }
		//
		return false;
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

		
		//boolean checker = false;
		this.diffEventorNot = false;
		
		
		
		if(!s.evetType.contains(e.getMappedContext())){ ///check if the new event has the same tyoe of the current state
			this.diffEventorNot = true;
			return false;
		}
		
		
		


//		if (!checker) {
//			this.diffEventorNot = true;
//			return false;
//		}


		if (!s.isKleeneClosure()) {
			Edge beginEdge = s.getEdges(0);
			// boolean result;
			// result = firstEdge.evaluatePredicate(e, r, buffer);

			return beginEdge.evaluateGraphEvent(e, r, s, this._statefullcache, this._kbstatefullcache);// Comments:evalutate
																										// predicate
																										// so
																										// instead
																										// of
																										// this
																										// add
																										// the
																										// query
																										// over
																										// here

		} else {
			if (r.isKleeneClosureInitialized()) {
				Edge takeEdge = s.getEdges(1);
				//boolean result;
				//result = takeEdge.evaluateGraphEvent(e, r, s, this._statefullcache, _kbstatefullcache);

				
				if (takeEdge.evaluateGraphEvent(e, r, s, this._statefullcache, _kbstatefullcache)) {
					
					return true;
				}
				
				
			} else {
				Edge beginEdge = s.getEdges(0);
			//	boolean result;

			//	result = beginEdge.evaluateGraphEvent(e, r, s, this._statefullcache, _kbstatefullcache);//
				// this.refreshStateBindings();
				if (beginEdge.evaluateGraphEvent(e, r, s, this._statefullcache, _kbstatefullcache)) {
					// evalCache(s, r);
					return true;
				}
			}
		}

		return false;

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
				return 0;  ///delete the run
			} else { ///match it with the next state, considering that the next state is not a negation state
				r.setCurrentState(r.getCurrentState() + 1);  //TODO: over here also check the optional state stuff as well
				boolean nextToNegation = checkRDFPredicate(e, r);
				
				                                       //check for the optional state next to a negation state
				if(this.nfa.getStates(r.getCurrentState()).isOptional() ){
					return 1;
				}
				
				
				if (nextToNegation == true) {
					return 1;  ///deal it in a normal way, if the next state is the kleene+ then create a new run and vice versa
				} else {
					r.setCurrentState(r.getCurrentState() - 1); /// if the next state is not matched then stay on the current negation state, and use the normal
					                                            //method to deal with the stuff
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
			if (negation == true) {  ///if the last state which is a negation matched then simply return 0 to delete the run
				return 0; ///delete the run
			} else {
				return 1; ///else return 1 and complete the run with a match
			}
			
			
			
			
		} else if (s.isOptional() && !s.isNegation() &&!s.isManager()) {//// Optional state
			
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
	 * @return 0: dead, -5: dead for IF, and ok for FB, true, 0 false and the run must be deleted
	 * @throws Exception
	 */
	private int evaluateAND(GraphEvent e, RunOptimised r, State s) throws Exception {

		///Integrate the Manager State's hashmap for the timestamps
		
		
		if (!s.getSubstates().containsKey(e.getMappedContext()) && !s.get_timestampRuns().containsKey(r.getId())) {
			return -5;
		}else if(!s.getSubstates().containsKey(e.getMappedContext()) ){
			return 0;
		}else{ 
			
		if(s.get_timestampRuns().containsKey(r.getId())){
			long startTime= s.get_timestampRuns().get(r.getId());
			
			if(startTime!=e.getTimeStamp()){
				return 0;  ///Why -1 over here should be 0
			}
			
		}
			
			
			
			Collection<State> substates = s.getSubstates().get(e.getMappedContext());
			/// iterate over the states and match the event with it, if its
			/// matches then return true, else return false
			// System.out.println(substates.stream().filter(x -> x.isComputed()
			// == true).count() );
			for (State st : substates) {

				// System.out.println("GPM ID: "+ st.getNfaData().getOrder());
				// System.out.println("State IDM "+ st.getOrder());
              
				
				// if not yet matched
				if (!st.getStateStatus().contains(r.getId())) { ///There is an edge case over here
					Edge beginEdge = st.getEdges(0);

					if (beginEdge.evaluateGraphEvent(e, r, st, this._statefullcache, this._kbstatefullcache)) {

						/// First set computed to true, and copy the timestmap
						//st.setComputed(true); ////Issues when mulitple runs share this.
                        st.getStateStatus().add(r.getId());
						//st.setTiptopTime(e.getTimeStamp());
						//s.setTiptopTime(e.getTimeStamp());
						s.get_timestampRuns().put(r.getId(), e.getTimeStamp());
						
						/// Stuff for the AND operation

						/// if all the states are matches
						Collection<State> checkstate = s.getSubstates().values();
				
						
						///if each substate contains the run id
					//	substates.stream().filter(x->x.getStateStatus().contains(r.getId())).count() 
						
						
						
						if (substates.stream().filter(x->x.getStateStatus().contains(r.getId())).count() == checkstate.size()) {
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

	/*private boolean checkNegationState(GraphEvent e, RunOptimised r) throws Exception {

		State s = this.nfa.getStates(r.getCurrentState());

		/// State newS=this.nfa.getStates(r.getCurrentState()+1);
		// TO check for the negation state, First check the event for the next
		/// state and for the previous state and if the events
		/// satisfies previous or next state predicate then dont consume that
		/// event, otherwise comsume it.

		// Still have to implement the negation at the first and the last state
		/// One of the most expensive operation of pattern matching...

		/// if its after negation then only create one run and thats it.....

		if (!s.isNegation()) {
			return true;
		} else {

			if (s.isNegation() && !s.isEnding() && this.nfa.getStates(r.getCurrentState() + 1).canStartWithGraphEvent(e,
					this._statefullcache, _kbstatefullcache, r.getId())) {// canStartWithRDFEvent(e)){

				return false;

			} else if (s.isNegation() && this.nfa.getStates(r.getCurrentState() - 1).canStartWithGraphEvent(e,
					this._statefullcache, _kbstatefullcache, this.runCounter++)) {
				return false;
			} /// Add the deltion of stuff from here....
		}
		/// check the event on the negation state as well...like if its equal or
		/// not

		return true;
	}
*/
	private void outputMatches(GraphEvent e, RunOptimised r) {
		if (this.constFunc != null) {
			this.constFunc.constrcutGraph(_statefullcache, r, _dictImpl);
		} else {
			this.outputSelectQuery(e, r);
		}

	}

	private void outputSelectQuery(GraphEvent e, RunOptimised r) {

		// System.out.println("############## Run ID
		// "+r.getId()+"##########################");

		String output = "";
		int ct = 0;
		for (int i = 0; i < this.nfa.getStates().length; i++) {

			// System.out.println("############ State
			// "+i+"############################");
			// TODO remove all the states properly, and get the data from all
			// the states
			
			State workingState= nfa.getStates()[i];
			

			if(workingState.isManager() ){
				
				for(State st:workingState.getSubstates().values()){
					
					if(st.getStateStatus().contains(r.getId()))
					{	
					
					for(int j=0;j< st.getNfaData().getAutomta().getStates().size();j++){
						
						this.outputManagerState(st,st.getNfaData().getAutomta().getStates().get(j).getRule(), r, j, output, ct, e.getTimeStamp());
					}
					
				    }
				
					
				}
				
				
				//return;
			} else {
			
			
			for (int j = 0; j < workingState.getNfaData().getAutomta().getStates().size(); j++) {
				output = "";
				
				/**
				 * Check if its the manager or not. In case of manager state get the NFAauotmat from the Substates
				 * 
				 */
				
				
				
				
				
				Rule outRule = workingState.getNfaData().getAutomta().getStates().get(j).getRule();

				if (outRule.isSelect()) {

					MultiBidirectionalIndex result = this._statefullcache.get(new RunStateMap(workingState.getOrder(), r.getId(), j));
					
					if(workingState.isNegation() || workingState.isOptional() && result ==null ){
						continue;
					}
					

					for (long key : result.getrIndex().keySet()) {

						Set<SP> sp = result.getrIndex().get(key);

						for (SP out : sp) {

							// its either subject or object
							if (outRule.isSelectSub()) {
								Resource res = _dictImpl.getResourceAdaptive(out.getSub());
								if (res == null) {
									output = "?" + outRule.getSubject().getProjection() + " "
											+ _dictImpl.getBnodeAdaptive(out.getSub()) + " ";
								} else {
									output = "?" + outRule.getSubject().getProjection() + " " + res + " ";
								}
							}

							if (outRule.isSelectObj()) {
								Literal lg = _dictImpl.getLiteralAdaptive(out.getPred());
								if (lg != null) {

									output = output + "?" + outRule.getObject().getProjection() + " "
											+ lg.getValue().toString() + "\n";
								} else {
									Resource res = _dictImpl.getResourceAdaptive(out.getPred());
									if (res == null) {
										output = output + "?" + outRule.getObject().getProjection() + " "
												+ _dictImpl.getBnodeAdaptive(out.getPred()) + "\n";
									} else {
										output = output + "?" + outRule.getObject().getProjection() + " " + res + " \n";
									}
								}
							}

						}

					}
					if (ct == 0) {
						ct = 1;
						output = output + "  [" + e.getTimeStamp() + "," + r.getLifeTimeBegin() + "]  ";
					}

					this.resultqueue.add(output);

				}

				/**
				 * Add the KB mappings found and use it for the output
				 */

				// first check if the state contains the KB graph or not

				if (workingState.getNfaData().getAutomta().getContainsKB() == 1) {

					/// loop though the kbcache and get the required mappings
					/// from it
					/// get the kblist which has the isSelect option set to true

					List<KBRule> krules = workingState.getNfaData().getAutomta().get_kbRuleList2().stream()
							.filter(x -> x.isSelect()).collect(Collectors.toList());

					if (!krules.isEmpty()) {
						MultiBiMap<Long, SP> kbresult = this._kbstatefullcache.get(new KBindex(r.getId(), workingState.getOrder()));

						for (KBRule out : krules) {
							for (Map.Entry<Long, SP> entry : kbresult.entries()) {

								if (out.isSelectSub() && entry.getKey() == out.getPredicate().getMappedValue()) {
									Resource res = _dictImpl.getResourcePersistant(entry.getValue().getSub());
									if (res == null) {
										output = "?" + out.getSubject().getProjection() + " "
												+ _dictImpl.getBnodePersistant(entry.getValue().getSub()) + " ";
									} else {
										output = "?" + out.getSubject().getProjection() + " " + res + " ";
									}
								}
								if (out.isSelectObj() && entry.getKey() == out.getPredicate().getMappedValue()) {
									Literal lg = _dictImpl.getLiteralPersistant(entry.getValue().getPred());
									if (lg != null) {

										output = output + "?" + out.getObject().getProjection() + " "
												+ lg.getValue().toString() + "\n";
									} else {
										Resource res = _dictImpl.getResourcePersistant(entry.getValue().getPred());
										if (res == null) {
											output = output + "?" + outRule.getObject().getProjection() + " "
													+ _dictImpl.getBnodePersistant(entry.getValue().getPred()) + "\n";
										} else {
											output = output + "?" + outRule.getObject().getProjection() + " " + res
													+ " \n";
										}
									}
								}
							}
							this.resultqueue.add(output);
						}

					}

				}

			}
		}

			// System.out.println("########################################");

			/////// get the results

		}

		// System.out.println();
	}

	/**
	 * Cleans useless runs by partition.
	 */
	public void cleanRunsByPartition() {

		int size = this.toDeleteRuns.size();
		RunOptimised tempRun = null;
		ArrayList<RunOptimised> partitionedRuns = null;
		for (int i = 0; i < size; i++) {
			tempRun = toDeleteRuns.get(0);
		
			tempRun.resetRun();

			removeFromCache(tempRun.getId());
			this.activeRuns.remove(tempRun);
			this.toDeleteRuns.remove(0);
			Profiling.numberOfRunsCutted++;
			partitionedRuns = this.activeRunsByPartition.get(tempRun.getPartitonId());
			partitionedRuns.remove(tempRun);
			if (partitionedRuns.size() == 0) {
				this.activeRunsByPartition.remove(partitionedRuns);
			}

		}

	}

	private void removeFromCache(int rID) {

		for (int i = 0; i < this.nfa.getStates().length; i++) {

			State rmoveState = nfa.getStates()[i];
			
			if (!rmoveState.isManager()) {

				for (int j = 0; j < rmoveState.getNfaData().getAutomta().getStates().size(); j++) {
					this._statefullcache.remove(new RunStateMap(rmoveState.getOrder(), rID, j));
				}

				if (rmoveState.getNfaData().getAutomta().getContainsKB() == 1) {

					this._kbstatefullcache.remove(new KBindex(rID, rmoveState.getOrder()));
				}
			}else {
				
				
				//get the substates
				
				for(State s:rmoveState.getSubstates().values()){
					
					
					
					
					///remove the hashmap stuff from here
					if(s.getStateStatus().contains(rID)){
						
						
						
						
						for (int j = 0; j <s.getNfaData().getAutomta().getStates().size(); j++) {
							this._statefullcache.remove(new RunStateMap(s.getOrder(), rID, j));
						}

						if (s.getNfaData().getAutomta().getContainsKB() == 1) {

							this._kbstatefullcache.remove(new KBindex(rID, s.getOrder()));
						}
						
						
			     	  rmoveState.get_timestampRuns().remove(rID);
						
						s.getStateStatus().remove(rID);
						
						//System.out.println();
					}
				}
				
			}
			
			////If its a Manager then go through the substates and first delete the stuff from the hashmap of manager state

		}

	}

	
	
	
	private void removeFromCacheForFirstState(int id, int rID){
		State rmoveState = nfa.getStates()[id];
		
		if (!rmoveState.isManager()) {

			for (int j = 0; j < rmoveState.getNfaData().getAutomta().getStates().size(); j++) {
				this._statefullcache.remove(new RunStateMap(rmoveState.getOrder(), rID, j));
			}

			if (rmoveState.getNfaData().getAutomta().getContainsKB() == 1) {

				this._kbstatefullcache.remove(new KBindex(rID, rmoveState.getOrder()));
			}
		}else {
			
			
			//get the substates
			
			for(State s:rmoveState.getSubstates().values()){
				if(s.getStateStatus().contains(rID)){
					
					
					
					
					for (int j = 0; j <s.getNfaData().getAutomta().getStates().size(); j++) {
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
	public NxParser getInputS() {
		return inputS;
	}

	public void setInputS(NxParser inputS) {
		this.inputS = inputS;
	}

	public List<NFAData> getNfaDataList() {
		return _nfaDataList;
	}

	public void setNfaDataList(List<NFAData> _nfaDataList) {
		this._nfaDataList = _nfaDataList;
	}

	public DictionaryOpImpl getDictImpl() {
		return _dictImpl;
	}

	public void setDictImpl(DictionaryOpImpl _dictImpl) {
		this._dictImpl = _dictImpl;
	}

	public NFA getNfa() {
		return nfa;
	}

	public void setNfa(NFA nfa) {
		this.nfa = nfa;
	}

//	public void setGraphSize(int s) {
//		this.graphsize = s;
//	}

	private void configPartitionBy() {

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
			int size = partitionedRuns.size();
			for (int i = 0; i < size; i++) {
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

	private void createNewRunByPartition(GraphEvent e) throws CloneNotSupportedException, Exception {
		if (this.nfa.getStates()[0].canStartWithGraphEvent(e, this._statefullcache, _kbstatefullcache,
				++this.runCounter)) {

			RunOptimised newRun = this.engineRunController.getRun();
			newRun.initializeRun(this.nfa, e.getTimeStamp(), this.runCounter);

			newRun.addGraphEvent(e, this.partitionKey);
			// this.numberOfRuns.update(1);
			Profiling.numberOfRuns++;
			this.activeRuns.add(newRun);
			this.addRunByPartition(newRun);

		}

	}

	public void addRunByPartition(RunOptimised newRun) {
		if (this.activeRunsByPartition.containsKey(newRun.getPartitonId())) {
			this.activeRunsByPartition.get(newRun.getPartitonId()).add(newRun);
		} else {
			ArrayList<RunOptimised> newPartition = new ArrayList<RunOptimised>();
			newPartition.add(newRun);
			this.activeRunsByPartition.put(newRun.getPartitonId(), newPartition);
		}
	}

	public void setConstClause(List<Rule> constClause) {
		this.constClause = constClause;
	}

	public BlockingQueue<GraphEvent> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<GraphEvent> queue) {
		this.queue = queue;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	protected void finish() {
		// Notify finish time

		Profiling.printProfiling();
		// Send poison pill to QPWriter
		this.resultqueue.add("DONE");
		// Ensure that QPWriter finishes
		try {
			this.writingThread.join();
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		// logger.info("Finsed Writing Results...");
		// Decrease latch count
		latch.countDown();
		System.out.println("Query Processing Completed");
	}

	
	
	private void outputManagerState(State s,Rule outRule, RunOptimised r,  int j, String output, int ct, long timestmap){
		if (outRule.isSelect()) {

			MultiBidirectionalIndex result = this._statefullcache.get(new RunStateMap(s.getOrder(), r.getId(), j));

			for (long key : result.getrIndex().keySet()) {

				Set<SP> sp = result.getrIndex().get(key);

				for (SP out : sp) {

					// its either subject or object
					if (outRule.isSelectSub()) {
						Resource res = _dictImpl.getResourceAdaptive(out.getSub());
						if (res == null) {
							output = "?" + outRule.getSubject().getProjection() + " "
									+ _dictImpl.getBnodeAdaptive(out.getSub()) + " ";
						} else {
							output = "?" + outRule.getSubject().getProjection() + " " + res + " ";
						}
					}

					if (outRule.isSelectObj()) {
						Literal lg = _dictImpl.getLiteralAdaptive(out.getPred());
						if (lg != null) {

							output = output + "?" + outRule.getObject().getProjection() + " "
									+ lg.getValue().toString() + "\n";
						} else {
							Resource res = _dictImpl.getResourceAdaptive(out.getPred());
							if (res == null) {
								output = output + "?" + outRule.getObject().getProjection() + " "
										+ _dictImpl.getBnodeAdaptive(out.getPred()) + "\n";
							} else {
								output = output + "?" + outRule.getObject().getProjection() + " " + res + " \n";
							}
						}
					}

				}

			}
			if (ct == 0) {
				ct = 1;
				output = output + "  [" + timestmap + "," + r.getLifeTimeBegin() + "]  ";
			}

			this.resultqueue.add(output);

		}

		/**
		 * Add the KB mappings found and use it for the output
		 */

		// first check if the state contains the KB graph or not

		if (s.getNfaData().getAutomta().getContainsKB() == 1) {

			/// loop though the kbcache and get the required mappings
			/// from it
			/// get the kblist which has the isSelect option set to true

			List<KBRule> krules = s.getNfaData().getAutomta().get_kbRuleList2().stream()
					.filter(x -> x.isSelect()).collect(Collectors.toList());

			if (!krules.isEmpty()) {
				MultiBiMap<Long, SP> kbresult = this._kbstatefullcache.get(new KBindex(r.getId(), s.getOrder()));

				for (KBRule out : krules) {
					for (Map.Entry<Long, SP> entry : kbresult.entries()) {

						if (out.isSelectSub() && entry.getKey() == out.getPredicate().getMappedValue()) {
							Resource res = _dictImpl.getResourcePersistant(entry.getValue().getSub());
							if (res == null) {
								output = "?" + out.getSubject().getProjection() + " "
										+ _dictImpl.getBnodePersistant(entry.getValue().getSub()) + " ";
							} else {
								output = "?" + out.getSubject().getProjection() + " " + res + " ";
							}
						}
						if (out.isSelectObj() && entry.getKey() == out.getPredicate().getMappedValue()) {
							Literal lg = _dictImpl.getLiteralPersistant(entry.getValue().getPred());
							if (lg != null) {

								output = output + "?" + out.getObject().getProjection() + " "
										+ lg.getValue().toString() + "\n";
							} else {
								Resource res = _dictImpl.getResourcePersistant(entry.getValue().getPred());
								if (res == null) {
									output = output + "?" + outRule.getObject().getProjection() + " "
											+ _dictImpl.getBnodePersistant(entry.getValue().getPred()) + "\n";
								} else {
									output = output + "?" + outRule.getObject().getProjection() + " " + res
											+ " \n";
								}
							}
						}
					}
					this.resultqueue.add(output);
				}

			}
	}
	}

	
}