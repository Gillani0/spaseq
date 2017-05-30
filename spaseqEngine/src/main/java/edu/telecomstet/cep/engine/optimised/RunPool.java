
package edu.telecomstet.cep.engine.optimised;

import java.util.ArrayList;


/**
 * This class is used to reuse runs in memory
 * @author haopeng
 *
 */
public class RunPool {
	/**
	 * A Pool of runs
	 */
	ArrayList<RunOptimised> runPool;
	/**
	 * Default constructor
	 */
	public RunPool(){
		runPool = new ArrayList<RunOptimised>();
		
	}
	
	/**
	 * Returns a run
	 * @return a run
	 */
	public RunOptimised getRun(){
		int size = runPool.size();
		for(int i = 0; i < size ; i ++){
			if (!(runPool.get(i)).isAlive()){
				return runPool.get(i);
			}
		}
		runPool.add(new RunOptimised());
		return runPool.get(size);
		
	}
	

	
}
