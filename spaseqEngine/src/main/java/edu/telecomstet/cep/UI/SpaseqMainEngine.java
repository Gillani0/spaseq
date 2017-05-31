package edu.telecomstet.cep.UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import javax.xml.datatype.DatatypeConfigurationException;

import org.antlr.v4.runtime.RecognitionException;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import edu.telecomst.graph.processing.GraphEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.engine.optimised.EngineController;
import edu.telecomstet.cep.query.helpers.QueryDescriptor;
import edu.telecomstet.cep.query.parser.QueryParser;
import fr.ujm.curien.cep.inter.face.manager.StreamManager;

public class SpaseqMainEngine {
	public static void main(String[] args) throws IOException,
			RecognitionException, ParseException,
			DatatypeConfigurationException,
			org.antlr.runtime.RecognitionException {

		DictionaryOpImpl dictimpl = new DictionaryOpImpl();
		BlockingQueue<GraphEvent> queue = new ArrayBlockingQueue<GraphEvent>(
				100);

		Options options = new Options();

		// ///////////////////////////////////////
		Option help = new Option("h", "help", false, "show help.");

		Option streams = new Option(
				"s",
				"streams",
				true,
				"input stream file containing the URI's of the streams and their repsective files");

		Option streamType = new Option("st", "streamt", true,
				"order of the stream, seqeuntial: false , random: true");

		Option timestamps = new Option(
				"t",
				"time",
				true,
				"take the timestamp from the stream file: false , use the system timestamps: true");
		// ; inputFile.setRequired(true);

		Option query = new Option("q", "query", true,
				"Input query file in .q format");
		Option kb = new Option("kb", "knbase", true,
				"optional external KB file in N-Triples format, ./kb.nt");

		// eventBoundry.setRequired(true);
		options.addOption(help);
		options.addOption(streamType);
		options.addOption(streams);
		options.addOption(query);
		options.addOption(kb);
		options.addOption(timestamps);
		// options.addOption(processType);

		// ///////
		boolean withsystemtimestamp = true;
		String q = null;
		String st = null;
		String kbase = "";
		boolean order = false;
		FileInputStream is = null;

		// ///////

		try {
			CommandLineParser parserCLI = new BasicParser();
			org.apache.commons.cli.CommandLine line = parserCLI.parse(options,
					args);

			if (line.hasOption("h")) {
				// initialise the member variable
				// String file = line.getOptionValue( "buildfile" );
				help(options);
			}

			if (line.hasOption("q")) {
				try {
					q = Files.toString(new File(line.getOptionValue("q")),
							Charsets.UTF_8);
				} catch (Exception ex) {
					System.out
							.println("Cannot find the Query File, please check your path again");
				}
			}

			if (line.hasOption("kb")) {
				kbase = line.getOptionValue("kb");
			}

			if (line.hasOption("t")) {

				withsystemtimestamp = Boolean.parseBoolean(line
						.getOptionValue("t"));
			}

			if (line.hasOption("s")) {
				// initialise the member variable
				// String file = line.getOptionValue( "buildfile" );
				st = line.getOptionValue("s");
			}

			if (line.hasOption("st")) {
				order = Boolean.valueOf(line.getOptionValue("st"));
			}

		} catch (Exception e) {
			System.out
					.println("Error in Parsing the Arguments of the Command Line, please check the arguments or use -h for Help");
			System.exit(0);
		}

		// /////////////////////////////////////

		// withsystemtimestamp = true;

		final QueryDescriptor descriptor = QueryParser
				.parse(q, dictimpl, kbase);

		EngineController myEngineController = new EngineController();

		myEngineController.setDict(dictimpl);
		myEngineController.setNFADataList(descriptor.getNfaDataList(),
				descriptor.getPattData());
		myEngineController.setConstrcutClaue(descriptor.getConstRules());

		myEngineController.setInputQueue(queue);

		final CountDownLatch latch = new CountDownLatch(2);
		// TODO add this to options
		// boolean withsystemtimestamp=false; ///if FALSE then take the
		// timestamp from the file ELSE if TRUE use the System timestamps
		StreamManager cepIU = new StreamManager(st, order, dictimpl, queue,
				withsystemtimestamp);

		cepIU.setLatch(latch);
		Thread producer = new Thread(cepIU);
		producer.setName("StreamManager");
		producer.start();
		System.out.println("Stream started...");

		myEngineController.initializeEngine();

		myEngineController.getMyEngine().setLatch(latch);
		new Thread(myEngineController.getMyEngine()).start();

	}

	private static void help(Options opt) {
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();

		formater.printHelp(
				"java -jar spaseq.jar  [-s <STRING>] [-q <STRING>]  [-st <STRING>] [-kb <STRING>] [-t <STRING>]",
				opt);
		System.exit(0);
	}

}
