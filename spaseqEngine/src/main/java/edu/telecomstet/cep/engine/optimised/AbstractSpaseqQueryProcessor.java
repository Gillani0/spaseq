package edu.telecomstet.cep.engine.optimised;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;
import com.gs.collections.impl.multimap.list.FastListMultimap;
import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecomstet.cep.UI.ResultWriter;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.nfahelpers2.NFA;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.Rule;
import edu.telecomstet.graph.processing.ConstrcutCaluse;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

public abstract class AbstractSpaseqQueryProcessor implements Runnable {
	protected List<NFAData> _nfaDataList;
	int test = 0; // TODO:delte
	private final CountDownLatch latch;

	private final List<Rule> constClause;

	// private int dummy = 0;
	private final BlockingQueue<GraphEvent> queue;

	protected long partitionKey;
	// private long currentTime = 0;

	protected boolean diffEventorNot;
	int runCounter;
	protected BlockingQueue<String> resultqueue;

	protected final DictionaryOpImpl _dictImpl;
	protected final ResultDecoder results;

	protected HashMap<Long, ArrayList<RunOptimised>> activeRunsByPartition;

	protected final NFA nfa;

	/**
	 * Active Runs partition by the stream ID
	 */

	protected final MutableList<RunOptimised> streamPartitionedRuns;

	protected final FastListMultimap<Long, RunOptimised> activeRunsPart;

	/**
	 * The runs which can be removed from the active runs.
	 */

	private Thread writingThread;

	protected ConstrcutCaluse constFunc;

	protected final Map<RunStateMap, MultiBidirectionalIndex> _statefullcache;

	protected final Map<KBindex, MultiBiMap<Long, SP>> _kbstatefullcache;

	/**
	 * The matches
	 */

	private Set<String> resultSet;

	public AbstractSpaseqQueryProcessor(NFA nf, List<NFAData> nfalist, DictionaryOpImpl dic, List<Rule> constrc,
			BlockingQueue<GraphEvent> inputqueue, CountDownLatch l) {

		this.latch = l;
		resultSet = new HashSet<>();
		this.queue = inputqueue;
		this.constClause = constrc;
		this.nfa = nf;
		this._nfaDataList = nfalist;

		this._dictImpl = dic;

		_kbstatefullcache = HashObjObjMaps.newMutableMap();
		_statefullcache = HashObjObjMaps.newMutableMap();
		activeRunsPart = new FastListMultimap<Long, RunOptimised>();
		streamPartitionedRuns = FastList.newList();

		this.resultqueue = new ArrayBlockingQueue<>(10000);

		this.runCounter = 0;
		if (this.constClause != null) {
			constFunc = new ConstrcutCaluse(constClause, resultqueue);
		}

		/**
		 * Partition runs by the stream ID
		 */

		/**
		 * Partition Runs by the defined partition
		 */

		results = new ResultDecoder(_statefullcache, _kbstatefullcache, constFunc, nfa, _dictImpl, resultqueue,
				resultSet);

		this.activeRunsByPartition = new HashMap<Long, ArrayList<RunOptimised>>();

		initialiseWriter();
	}

	public void initialiseWriter() {

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

						streamPartitionedEngine(event);
					} else {

						break;
					}

				} catch (InterruptedException e) {

					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		}

		this.finish();

	}

	// protected abstract void runGraphEventProcessing(GraphEvent e) throws
	// CloneNotSupportedException, Exception;

	protected abstract void partitionBYEngine(GraphEvent e) throws CloneNotSupportedException, Exception;

	protected abstract void configPartitionBy();

	protected abstract void streamPartitionedEngine(GraphEvent e) throws CloneNotSupportedException, Exception;

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

		System.out.println("The Results are stored at ./result/queryResults.txt");
		System.out.println("Query Processing Completed");
	}

}
