

package edu.telecomstet.cep.engine.optimised;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * This ConfigFlags class sets the parameters for the Engine.<br>
 * @author sydgillani
 * 
 * 
 */
public class ConfigFlags {
	

	/**
	 * The engine will output the results in console if we set it as true.
	 */
	
	public static boolean printResults = true;
	
	/**
	 * The engine will generate random values for stream if we set it as true.
	 */
	
	public static boolean useRandomStream = false;
	/**
	 * This field denotes the selection strategy which is being used.
	 */
	
	public static int selectionStrategy = 0 ;
	
	/**
	 * This field describes the length of a query
	 */
	
	public static int sequenceLength;
	
	/**
	 * This field describes the time window in the query
	 */
	public static long timeWindow;
	
	/**
	 * This filed is used to denote whether or not using the sharing technique.
	 */
	
        public long partitionKey;

        
	public static boolean useSharing = false;
	
	/**
	 * This filed is used to denote whether the query has a partition attribute.
	 */
	
	public static boolean hasPartitionAttribute = false;
	
	/**
	 * This filed is used to denote the name of the partition attribute.
	 */
	public static String partitionAttribute;
	
	/**
	 * This field is used denote whether the query has a negation component.
	 */
	public static boolean hasNegation = false;
	
        /**
         * This is to store all the predicates of the partition by attribute
         * 
         */
        public static HashMap<Long,String> partitionByPred=new HashMap<>();
	
        
        
        
    public long getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(long partitionKey) {
        this.partitionKey = partitionKey;
    }
        
	
}
