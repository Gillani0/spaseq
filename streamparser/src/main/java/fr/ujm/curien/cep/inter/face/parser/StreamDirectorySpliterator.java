package fr.ujm.curien.cep.inter.face.parser;

import java.util.Spliterator;
import java.util.StringTokenizer;
import java.util.function.Consumer;

import fr.uim.curien.cep.inter.face.beans.StreamFiles;
import fr.uim.curien.cep.inter.face.beans.TripleFile;

public class StreamDirectorySpliterator implements Spliterator<StreamFiles> {
	private Spliterator<String> lineSpliterator;
	private StreamFiles streamfile;

	public StreamDirectorySpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super StreamFiles> action) {

		if (this.lineSpliterator.tryAdvance(line -> this.streamfile = createStreamFile(line))) {
			action.accept(this.streamfile);
			return true;
		} else {
			return false;
		}

	}

	private TripleFile createStreamFile(String line) {
		StringTokenizer tokens = new StringTokenizer(line, " ");
		String[] splited = new String[tokens.countTokens()];
		int index = 0;
		while (tokens.hasMoreTokens()) {
			splited[index] = tokens.nextToken();
			++index;
		}
		
			return new TripleFile(splited[0].substring(1, splited[0].length() - 1),
					splited[1].substring(1, splited[1].length() - 1), Integer.parseInt(splited[2]));
		
	
	}

	@Override
	public Spliterator<StreamFiles> trySplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return lineSpliterator.estimateSize();
	}

	@Override
	public int characteristics() {
		// TODO Auto-generated method stub
		return lineSpliterator.characteristics();
	}

}
