package edu.telecomstet.cep.UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

import javax.xml.datatype.DatatypeConfigurationException;

import org.antlr.runtime.RecognitionException;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.semanticweb.yars.nx.parser.NxParser;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import edu.junkYard.EngineController;
import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.query.helpers.QueryDescriptor;
import edu.telecomstet.cep.query.parser.QueryParser;

public class MainUI {

	public static void main(String[] args)
			throws RecognitionException, ParseException, DatatypeConfigurationException, IOException {
		Options options = new Options();

		// System.in.read();
		Option help = new Option("h", "help", false, "show help.");

		Option inputFile = new Option("f", "file", true, "Input stream file in NTriples/NQuad format");

		Option events = new Option("es", "file", true, "Number of triples within an event");
		// ; inputFile.setRequired(true);

		Option query = new Option("q", "query", true, "Input query file in .q format");

		Option kb = new Option("kb", "knbase", true, "optional external KB file in N-Triples format, ./kb.nt");
		// query.setRequired(true);
		// Option processType= new Option("et", "evalType", true,"Evaluation
		// Type, 1: For Event-based Evalution, 2: For Incremental Evalutaion" );
		// processType.setRequired(true);

		// window.setRequired(true);

		// eventBoundry.setRequired(true);
		options.addOption(help);
		options.addOption(events);
		options.addOption(inputFile);
		options.addOption(query);
		options.addOption(kb);
		// options.addOption(processType);

		/////////
		String kbase = "";
		String f = null;
		String q = null;

		int es = 2;

		FileInputStream is = null;

		/////////

		try {
			CommandLineParser parserCLI = new BasicParser();
			org.apache.commons.cli.CommandLine line = parserCLI.parse(options, args);

			if (line.hasOption("h")) {
				// initialise the member variable
				// String file = line.getOptionValue( "buildfile" );
				help(options);
			}

			if (line.hasOption("es")) {
				// initialise the member variable
				// String file = line.getOptionValue( "buildfile" );
				es = Integer.parseInt(line.getOptionValue("es"));
			}

			if (line.hasOption("kb")) {
				kbase = line.getOptionValue("kb");
			}
			if (line.hasOption("q")) {
				try {
					q = Files.toString(new File(line.getOptionValue("q")), Charsets.UTF_8);
				} catch (Exception ex) {
					System.out.println("Cannot find the Query File, please check your path again");
				}
			}

			if (line.hasOption("f")) {
				f = line.getOptionValue("f");
				try {

					is = new FileInputStream(f);
				} catch (Exception ex) {
					System.out.println("Cannot find the Stream Input File, please check your path again");
					System.exit(0);
				}
			}

		} catch (Exception e) {
			System.out.println(
					"Error in Parsing the Arguments of the Command Line, please check the arguments or use -h for Help");
			System.exit(0);
		}

		//// The Main stuff Starts over HERE/////

		BlockingQueue<GraphEvent> inputQueue = new LinkedBlockingQueue<GraphEvent>();
		DictionaryOpImpl dictimpl = new DictionaryOpImpl();

		final QueryDescriptor descriptor = QueryParser.parse(q, dictimpl, kbase);// "/Users/sydgillani/Documents/wwwTest/datasets/stateless/simpleStateless/externalKB.nq");

		EngineController myEngineController = new EngineController();

		myEngineController.setDict(dictimpl);
		myEngineController.setNFADataList(descriptor.getNfaDataList(), descriptor.getPattData());
		myEngineController.setConstrcutClaue(descriptor.getConstRules());

		myEngineController.setInputQueue(inputQueue);

		final CountDownLatch latch = new CountDownLatch(2);

		// String
		// f="/Users/sydgillani/Documents/wwwTest/datasets/stateful/complexFilter/data.nq";

		NxParser nxp = new NxParser(is);

		StreamHandler p = new StreamHandler(inputQueue, "Input Handler", 0, nxp, dictimpl, es);
		p.setLatch(latch);
		System.out.println("Stream Started .....");
		new Thread(p).start();
		// myEngineController.setInput(nxp);
		// myEngineController.setGraphSize(Integer.parseInt(args[3]));
		myEngineController.initializeEngine();
		// myEngineController.runEngine();
		myEngineController.getMyEngine().setLatch(latch);
		System.out.println("Query Process Started .....");
		new Thread(myEngineController.getMyEngine()).start();

		// System.out.println("\nProfiling results for repeat No. are as
		// follows:");

		// Profiling.printProfiling(nT,f);
		// System.out.println("Process Ended");

		////////////////////////////////////////

	}

	private static void help(Options opt) {
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();

		formater.printHelp("java -jar spaseq.jar [-f <STRING>] [-q <STRING>] [-es <NUM>] [-kb <STRING>]", opt);
		System.exit(0);
	}
}
