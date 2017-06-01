package fr.ujm.curien.cep.inter.face.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.parser.NxParser;

import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecom.stet.cep.events.MappedEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import fr.uim.curien.cep.inter.face.beans.StreamFiles;
import fr.uim.curien.cep.inter.face.beans.TripleFile;
import fr.ujm.curien.cep.inter.face.parser.StreamDirectorySpliterator;

public class StreamManager implements Runnable {

	private final DictionaryOpImpl dicImpl;

	private BlockingQueue<GraphEvent> queue;

	public int nextToRead = 0, xxx = 0;
	public int nbFile = 0;
	public int finishedStreams = 0;
	public NxParser[] readers;
	boolean finished = false;
	// TODO make it graphEvent type
	private int counterI = 0;
	public List<TripleFile> ListStreamFile = new ArrayList<>();
	public List<Integer> fileReaderList = new ArrayList<Integer>();

	private boolean random;
	private boolean systemTime;
	private long START_OF_THE_STREAM;

	/**
	 * read from stream files if random=false so the manager will send one
	 * graphEvent from each stream file in an order way if random=true so the
	 * manager will send one graphEvent from one stream chosen randomly
	 * 
	 * @param filepath
	 * @param random
	 * @param dicImpl
	 * @param queue
	 * @throws IOException
	 */
	public StreamManager(String filepath, boolean random, DictionaryOpImpl dicImpl, BlockingQueue<GraphEvent> queue,
			boolean systemTime) throws IOException {
		super();
		this.systemTime = systemTime;
		this.dicImpl = dicImpl;
		this.queue = queue;
		this.random = random;
		this.finishedStreams = 0;
		Path streamPath = Paths.get(filepath);
		Spliterator<String> streamlineSpliterator = Files.lines(streamPath).spliterator();
		Spliterator<StreamFiles> streamDirectorySpliterator = new StreamDirectorySpliterator(streamlineSpliterator);
		Stream<StreamFiles> streamDirectories = StreamSupport.stream(streamDirectorySpliterator, false);

		streamDirectories.forEach(o -> {
			this.ListStreamFile.add((TripleFile) o);
			this.nbFile++;
		});

		if (random == true) {
			for (int f = 0; f < nbFile; f++) {
				fileReaderList.add(f);
			}
		}
		readers = new NxParser[nbFile];
	}

	@Override
	public void run() {
		this.openReaders();
		this.START_OF_THE_STREAM = System.nanoTime();
		if (random) {
			do {
				GraphEvent record = this.readRound();

				if (record != null) {
					try {
						this.queue.put(record);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} while (finishedStreams != nbFile);
			try {
				// GraphEvent(int id, long t, DictionaryOpImpl d, long
				// c,MappedEvent[] mp){
				this.queue.put(new GraphEvent(-1, 0, null, 0, new ArrayList<MappedEvent>()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			do {

				GraphEvent record = readRound123();

				if (record != null) {
					try {
						this.queue.put(record);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} while (finishedStreams != nbFile);

			try {
				this.queue.put(new GraphEvent(-1, 0, null, 0, new ArrayList<MappedEvent>()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void openReaders() {
		for (int i = 0; i < this.ListStreamFile.size(); i++) {
			try {
				this.readers[i] = new NxParser(new InputStreamReader(
						new FileInputStream(new File(this.ListStreamFile.get(i).getFilePath_()))));
			} catch (final Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	/**
	 *
	 * @return the next element to be sent
	 */
	private GraphEvent readRound123() {
		// System.out.print(nextToRead);
		final GraphEvent graph = readLine123(nextToRead);
		nextToRead++;
		if (nbFile - finishedStreams != 0) {
			nextToRead = nextToRead % (nbFile - finishedStreams);
			// if (nextToRead==0)
			// System.out.println(" ");
		}

		return graph;
	}

	public GraphEvent readLine123(final int i) {
		long id;
		Node nxx[];
		int graphsize;

		if (readers[i] != null) {

			if (!readers[i].hasNext()) {
				NxParser bb = readers[i];
				removeElements(readers, bb);
				finishedStreams++;
				return null;
			}

			if (ListStreamFile.get(i).getId() == -1) {
				// System.out.println(ListStreamFile.get(i).getStreamId_());
				id = this.dicImpl.addResourcePersistant(new Resource(ListStreamFile.get(i).getStreamId_()));
				ListStreamFile.get(i).setId(id);
			} else {
				id = ListStreamFile.get(i).getId();
			}
			graphsize = ListStreamFile.get(i).getGraphsize_();
			final MappedEvent[] mapE = new MappedEvent[graphsize];
			counterI = 0;
			while (readers[i].hasNext() && graphsize > 0) {
				nxx = readers[i].next();
				// System.out.println(nxx);
				graphsize--;

				mapE[counterI] = new MappedEvent(nxx, dicImpl);
				// System.out.println(" internal "+counterI);
				counterI++;
				if (!this.systemTime && graphsize == 1) {
					nxx = readers[i].next();
					// System.out.println(nxx);
					graphsize--;

					mapE[counterI] = new MappedEvent(nxx, dicImpl);
					// System.out.println(" internal "+counterI);
					counterI++;
					return new GraphEvent(1, Long.parseLong((String) ((Literal) nxx[2]).getValue()), dicImpl, id, mapE);
				}
			}
			return new GraphEvent(1, (System.nanoTime() - this.START_OF_THE_STREAM), dicImpl, id, mapE);
		} else {
			return null;
		}
	}

	/***
	 * 
	 * 
	 * 
	 * @param i
	 * @return
	 */
	public GraphEvent readLine(final int i) {
		long id;
		Node nxx[];
		int graphsize;

		if (readers[i] != null) {
			if (ListStreamFile.get(i).getId() == -1) {
				// System.out.println(ListStreamFile.get(i).getStreamId_());
				id = this.dicImpl.addResourcePersistant(new Resource(ListStreamFile.get(i).getStreamId_()));
				ListStreamFile.get(i).setId(id);
			} else {
				id = ListStreamFile.get(i).getId();
			}
			graphsize = ListStreamFile.get(i).getGraphsize_();

			final MappedEvent[] mapE = new MappedEvent[graphsize];
			counterI = 0;
			while (readers[i].hasNext() && graphsize > 0) {
				nxx = readers[i].next();
				// System.out.print(nxx);
				graphsize--;
				mapE[counterI] = new MappedEvent(nxx, dicImpl);
				// System.out.println(" internal "+counterI);
				counterI++;
				if (!this.systemTime && graphsize == 1) {
					nxx = readers[i].next();
					// System.out.println(nxx);
					graphsize--;

					mapE[counterI] = new MappedEvent(nxx, dicImpl);
					// System.out.println(" internal "+counterI);
					counterI++;
					return new GraphEvent(1, Long.parseLong((String) ((Literal) nxx[2]).getValue()), dicImpl, id, mapE);
				}

			}
			if (!readers[i].hasNext()) {

				readers[i] = null;
				// removeElements(readers, bb);
				finishedStreams++;
				fileReaderList.remove(0);

			}

			return new GraphEvent(1, (System.nanoTime() - this.START_OF_THE_STREAM), dicImpl, id, mapE);
		} else {
			return null;
		}
	}

	public NxParser[] removeElements(NxParser[] input, NxParser deleteMe) {
		List<NxParser> result = new LinkedList<NxParser>();

		for (NxParser item : input)
			if (!deleteMe.equals(item))
				result.add(item);

		return result.toArray(input);
	}

	/****
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @return
	 */
	public GraphEvent readRound() {
		// System.out.println(nextToRead);
		final GraphEvent line = readLine(nextToRead);
		if (line != null) {
			if (fileReaderList.size() == 0) {
				finished = true;
				return line;
			}
			Collections.shuffle(fileReaderList);
			nextToRead = fileReaderList.get(0);

		} else {
			if (fileReaderList.size() > 0) {
				Collections.shuffle(fileReaderList);
				nextToRead = fileReaderList.get(0);
			}
		}

		return line;
	}

	public static void main(String[] args) throws IOException {

		DictionaryOpImpl dictimpl = new DictionaryOpImpl();
		BlockingQueue<GraphEvent> queue = new ArrayBlockingQueue<GraphEvent>(100);

		StreamManager cepIU = new StreamManager("src/main/resources/data/streams.txt", true, dictimpl, queue, false);
		// cepIU.run();
		Thread producer = new Thread(cepIU);
		producer.setName("StreamManager");
		producer.start();

		EventGraphConsumer evc = new EventGraphConsumer(queue);
		Thread consumer = new Thread(evc);
		consumer.setName("Streamconsumer");
		consumer.start();
	}

	private CountDownLatch latch;

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}
}