/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.engine.optimised;

import edu.telecomst.graph.processing.GraphEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.nfahelpers2.NFA;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.PatternData;
import edu.telecomstet.cep.rulesmodel.Rule;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.semanticweb.yars.nx.parser.NxParser;

/**
 *
 * @author sydgillani
 */
public class EngineController {
   EngineOptimised myEngine;
   // EngineNormal myEngine;
    
    public EngineController() {
       myEngine = new EngineOptimised();
       // myEngine = new EngineNormal();
    }
    
    public void setInput(NxParser inputStream){
     
        myEngine.setInputS(inputStream);
       
    }
    public void setNFADataList(List<NFAData> nfaDataList,List<PatternData> pattData){
        myEngine.setNfaDataList(nfaDataList);
        /***
         * Addition of UNION and OR
         * get the list, merge them and then sort it
         */
        
        NFA nfa= new NFA(pattData,nfaDataList);
        
     //  NFA nfa=new NFA(nfaDataList);
        myEngine.setNfa(nfa);
    }
    
    public void setInputQueue(BlockingQueue<GraphEvent> queue){
    	myEngine.setQueue(queue);
    }
  
   public void setConstrcutClaue(List<Rule> cc){
	   myEngine.setConstClause(cc);
   }
    public void setDict( DictionaryOpImpl dictimpl){
       myEngine.setDictImpl(dictimpl);
    }
      public void initializeEngine() {
        myEngine.initialise();
    }
      /*public void runEngine() throws Exception  {
        myEngine.runEngine();

    }*/
      
//      public void setGraphSize(int s) throws Exception  {
//        myEngine.setGraphSize(s);
//
//    }

	public EngineOptimised getMyEngine() {
		return myEngine;
	}

	public void setMyEngine(EngineOptimised myEngine) {
		this.myEngine = myEngine;
	}
	
	
	/*public EngineNormal getMyEngine() {
		return myEngine;
	}

	public void setMyEngine(EngineNormal myEngine) {
		this.myEngine = myEngine;
	}*/
	
}
