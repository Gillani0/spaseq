package edu.telecomstet.cep.UI;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.parser.NxParser;
import org.slf4j.LoggerFactory;

import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecom.stet.cep.events.MappedEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;

public class StreamHandler implements Runnable {

	protected final static org.slf4j.Logger logger = LoggerFactory.getLogger(StreamHandler.class);
	/// change it to the
	private DictionaryOpImpl _dictImpl;
	private final NxParser parser;
	private final int eventBoundries;
	protected BlockingQueue<GraphEvent> q = null;

	public StreamHandler(BlockingQueue<GraphEvent> q, String name, int waitTime, NxParser p, DictionaryOpImpl dic,
			int b) { /// send the nx over here in the file
		this.q = q;
		this.eventBoundries = b;
		parser = p;
		this._dictImpl = dic;
	}

	@Override
	public void run() {

		Node[] nxx = null;
		MappedEvent[] ep = new MappedEvent[2];
		int counter = 1;
		int i = 0;

		String c = "<http://example.org/main>";
		long contxt = this._dictImpl.addResourcePersistant(new Resource(c, true));
		while (parser.hasNext()) {

			/// create a new graph event

			nxx = parser.next();

			// mapE.add(new GraphTriple(nxx,this.getDictImpl()
			// ).getMappedEvent());

			ep[i] = new MappedEvent(nxx, this._dictImpl);

			i++;

			if (i == this.eventBoundries) {
				// TODO test of and close
				q.add(new GraphEvent(counter++, 0, this._dictImpl, contxt, ep));

				// q.add(new
				// GraphEvent(counter++,System.nanoTime(),this._dictImpl,contxt,ep));
				ep = new MappedEvent[2];
				i = 0;
			} // q.add(new Triple(parser.next(),1));
				// Thread.sleep(50);

		}

		// q.add(new Triple(null,0));

		q.add(new GraphEvent(-1, 0, null, 0, new MappedEvent[5]));
		// System.out.println("File Reading Completed...");
		// logger.info("File Reading Completed...");
		latch.countDown();
		// }

	}

	private CountDownLatch latch;

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}
}
