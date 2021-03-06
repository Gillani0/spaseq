
package edu.telecomstet.cep.engine.optimised;

/**
 * This class profiles the numbers of performance
 * 

 *
 */
public class Profiling {

	/**
	 * The total running time of the engine (nanoseconds)
	 */
	public static long totalRunTime = 0;
	/**
	 * The number of events processed
	 */
	public static long numberOfEvents = 0;
	/**
	 * The number of runs generated
	 */
	public static long numberOfRuns = 0;
	/**
	 * The total run lifetime
	 */
	public static long totalRunLifeTime = 0;
	/**
	 * The number of matches
	 */
	public static long numberOfMatches = 0;
	/**
	 * The number of runs which ends before reach the final state
	 */
	public static long numberOfRunsCutted = 0;
	/**
	 * The number of runs which are deleted because of they violate the time
	 * window constraint
	 */
	public static long numberOfRunsOverTimeWindow = 0;
	/**
	 * The cost on match construction
	 */
	public static long timeOfMatchConstruction = 0;

	public static long negatedMatches = 0;

	public static String outputDirectory = "";
	
	public static long sTime=0;
	public static long eTime=0;
	
	public static long timeToParseRDF=0;
	
	public static long timeforGPM=0;

	/**
	 * resets the profiling numbers
	 */
	public static void resetProfiling() {

		totalRunTime = 0;
		numberOfEvents = 0;
		numberOfRuns = 0;
		totalRunLifeTime = 0;
		numberOfMatches = 0;
		numberOfRunsCutted = 0;
		numberOfRunsOverTimeWindow = 0;
		timeOfMatchConstruction = 0;
		numberOfMergedRuns = 0;
		negatedMatches = 0;
	}

	/**
	 * prints the profiling numbers in console
	 */
	public static void printProfiling() {
	
	//	totalRunTime = eTime - sTime;
		System.out.println();
		System.out.println("**************Profiling Numbers*****************");
		 System.out.println("Total Running Time: " + totalRunTime + " Ns");
		System.out.println("Number Of Events Processed: " + numberOfEvents);
		System.out.println("Number Of Runs Created: " + numberOfRuns);
		System.out.println("Number Of Matches Found: " + numberOfMatches);
		System.out.println("Number Of Deleted Runs: " + numberOfRunsCutted);
		System.out.println("Time to Parse RDF Events: " + timeToParseRDF +" Ns");
		System.out.println("Time for GPM: " + timeforGPM+" Ns");
		System.out.println("Time for Checking Partial Matches: " + (totalRunTime- timeforGPM) +" Ns");
		
		long gpm= timeforGPM/1000000000;
		long tt = totalRunTime/1000000000;
		
		long dif = totalRunTime -timeforGPM;
		System.out.println("% TIme: " + (timeforGPM/totalRunTime));
		//System.out.println("Last Event Time: " + eTime);

		if (ConfigFlags.hasNegation) {
			System.out.println("Number of Negated Matches: " + negatedMatches);
		}

		long throughput1 = 0;
		 if(totalRunTime > 0){
		 throughput1 = numberOfEvents* 1000000000/totalRunTime ;
		 System.out.println("Throughput: " + throughput1 + " events/second");
		 }

	}

	// sharing numbers
	/**
	 * number of runs merged in the sharing engine
	 */
	public static long numberOfMergedRuns = 0;

	public static void resetSharingProfiling() {
		numberOfMergedRuns = 0;
	}

	/**
	 * outputs the extra profiling numbers for the sharing engine
	 */
	public static void printSharingProfiling() {
		System.out.println("#Merged Runs = " + numberOfMergedRuns);
	}

}
