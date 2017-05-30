package edu.telecomstet.cep.UI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultWriter implements Runnable {
	//final static Logger logger = LoggerFactory.getLogger(ResultWriter.class);

	/**
	 * Writer to write the output of the queries
	 */
	private BufferedWriter outputWriter;

	private final int id;

	public final BlockingQueue<String> resultqueue;

	public ResultWriter(final int id, final BlockingQueue<String> resultqueue) {
		super();
		this.id = id;
		this.resultqueue = resultqueue;
		// Initialize writer
		try {
			outputWriter = new BufferedWriter(new FileWriter(new File("result/queryResults.txt")));
		} catch (final IOException e) {
		System.out.println("Cannot open output file for ");
			System.exit(-1);
		}
	}

	@Override
	public void run() {
		// R�cup�rer dans la queue
		// Ecrire
		while(true){
			try {
				final String line = resultqueue.take();
				if(line!="DONE") {
				
					writeLine(line);
				}else{
					break;
				}
			} catch (final InterruptedException e) {
				
				e.printStackTrace();
			}
		}

		finish();

	}

	protected void writeLine(final String line) {
		try {
			outputWriter.write(line);
			outputWriter.newLine();
		} catch (final IOException e) {
			
			System.out.println("Could not write new line for query processor ");
			//logger.error("Could not write new line for query processor " + id + ", line content " + line, e);
		}

	}

	private void finish() {
		// Close writer
		try {
			outputWriter.flush();
			outputWriter.close();
		} catch (final IOException e) {
			System.out.println("Cannot property close the output file for query ");
			//logger.error("Cannot property close the output file for query " + id, e);
		}
	}

}
