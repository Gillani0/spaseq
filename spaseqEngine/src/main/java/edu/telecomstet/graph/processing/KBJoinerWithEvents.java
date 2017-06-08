package edu.telecomstet.graph.processing;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.graph.automata.AutomataState;
import edu.telecomstet.cep.knowledgebase.KBRule;
import edu.telecomstet.cep.rulesmodel.Dependability;

public class KBJoinerWithEvents {
	private boolean checker = false;
    private long indexCount=0;
    
   private int stop=0;
  private int num=1000000;
  private 	int id=0;
    
    public void kbJoinerwithAutomata(Automata a,Map<KBindex, MultiBiMap<Long,SP>> kbcache,int r,int st){
    	///go around the list of KB rules and its dependency list
    	
    	stop=0;
    	checker=false;
    	indexCount=0;
    	
    
    	
    	for(KBRule kb: a.get_kbRuleList2()){
    		
    		
    		///go around its dependency list
    		
    		for(Dependability dd: kb.getDepends()){
    			if(dd.isStateDependability()){
    				///then join it by locating the required state
    				if(!kb.getRreal2().getR().isEmpty()){
    					kb.getRreal2().getR().clear();
    					kb.getRreal2().getrIndex().clear();
    				}
    			
    				
    				
    	    AutomataState sJoin= a.getStates().get(dd.getDependabilty_id());
    	       this.initiate(kb, sJoin, dd);
    	    ///check what kind of join is it.
   
    			}
    		}
    	}
    	
    	
    	/**
    	 * Get the results in the kb cache
    	 */
    	
    	extractResults(a.get_kbRuleList2(),a,kbcache,r,st);
    }
    
    
    private void extractResults(List<KBRule> klist, Automata a,Map<KBindex, MultiBiMap<Long,SP>> kbcache,int r,int st){
    	   
        Set<Long> keys=null;
        keys=klist.get(id).getRreal2().getrIndex().keySet();
        
        ///loop over the indexed keys
        
      KBindex mapid= new KBindex (r,st);
      MultiBiMap<Long,SP> result= new MultiBiMap<Long,SP>();
        
		for (KBRule kb : klist) {
			for (Long index : keys) {
				Set<SP> sp = kb.getRreal2().getrIndex().get(index);
				
				
				result.putAll(kb.getPredicate().getMappedValue(), sp);
			}
		}
		
		kbcache.put(mapid, result);
    }
    
	public void initiate(KBRule kbrule, AutomataState s, Dependability dd) {
		// /check the type of the joine

		if (dd.getDependability_On() == 1 && dd.getDependability_part() == 1) {
          this.incrementalSSJoinStage2(kbrule, s);
		}else if(dd.getDependability_On()==0 && dd.getDependability_part()==1){ //mean object as a variable
		this.incrementalOSJoinStage2(kbrule, s);	
		}else if(dd.getDependability_On()==1 && dd.getDependability_part()==0){
			this.incrementalSOJoinStage2(kbrule, s);
		}
		
		
		
		if(kbrule.getRreal2().getrIndex().size()<=num){
			
			num =kbrule.getRreal2().getrIndex().size();
		    id= kbrule.getId();
		}
		

	}

	

	
	private void incrementalSOJoinStage2(KBRule currState, AutomataState joinState) {

		// /if the join state r and r join are empty

		if (joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) { // / the
																		// use
																		// the
																		// both
																		// C and
																		// put
																		// it in
																		// Rreal
																		// of
																		// both

			// /first check if the r is empty or ecopied is emptied for the
			// currstate

			// /If no existing joins have been executed and we need to join the
			// KB C with the new States C
			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				 soHashJoinCC(joinState
							.getRule().getC2(),currState.getC2(),currState.getRreal2());
				
				

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				
				this.soHashJoinRC2(joinState.getRule().getC2(),currState.getRreal(),
						
						currState.getRreal2());

				

			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {
				
				
				this.soHashJoinRC2(joinState.getRule().getC2(),currState.getrCopied(),
						
						currState.getRreal2());

		            	}

			// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
			// joinState.getRule().getC2(), currState.getEdge().getRreal(),
			// joinState.getEdge().getRreal());

		} else if (!joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) {
			// use Real
			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				
				 soHashJoinCC(joinState.getEdge().getRreal().getR(),currState.getC2(),currState.getRreal2());
				
				
				
			

				

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {


				this.soHashJoinRC2(joinState.getEdge().getRreal().getR(),currState.getRreal(),
						
						currState.getRreal2());

					
				


			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {

				
				
	this.soHashJoinRC2(joinState.getEdge().getRreal().getR(),currState.getrCopied(),
						
						currState.getRreal2());
				
				
			
		

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
			// currState.getEdge().getRreal());

			// if(checker){
			// joinState.getEdge().getRreal().getR().clear();
			// joinState.getEdge().getRreal().getrIndex().clear();
			// }

		} else if (joinState.getEdge().getRreal().getR().isEmpty()
				&& !joinState.getEdge().getrCopied().getR().isEmpty()) {

			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {
				
				 soHashJoinCC(joinState.getEdge().getrCopied().getR(),currState.getC2(),currState.getRreal2());
				
			

			

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {
			
				
				
				
				
				
				
					this.soHashJoinRC2(joinState.getEdge().getrCopied().getR(),currState.getRreal(),
							
							currState.getRreal2());
					

			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {

				this.soHashJoinRC2(joinState.getEdge().getrCopied().getR(),currState.getrCopied(),
						
						currState.getRreal2());

				

			}

			
		}

		// // check the tablesomappedcopied

		// //////////////
		if (checker) {
			
			checker = false;

		}  
	}
    
	
	private void incrementalOSJoinStage2(KBRule currState, AutomataState joinState) {

		// /if the join state r and r join are empty

		if (joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) { // / the
																		// use
																		// the
																		// both
																		// C and
																		// put
																		// it in
																		// Rreal
																		// of
																		// both

			// /first check if the r is empty or ecopied is emptied for the
			// currstate

			// /If no existing joins have been executed and we need to join the
			// KB C with the new States C
			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				 osHashJoinCC(joinState
							.getRule().getC2(),currState.getC2(),currState.getRreal2());
				
				

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				
				this.osHashJoinRC2(joinState.getRule().getC2(),currState.getRreal(),
						
						currState.getRreal2());

				

			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {
				
				
				this.osHashJoinRC2(joinState.getRule().getC2(),currState.getrCopied(),
						
						currState.getRreal2());

		            	}

			// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
			// joinState.getRule().getC2(), currState.getEdge().getRreal(),
			// joinState.getEdge().getRreal());

		} else if (!joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) {
			// use Real
			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				
				 osHashJoinCC(joinState.getEdge().getRreal().getR(),currState.getC2(),currState.getRreal2());
				
				
				
			

				

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {


				this.osHashJoinRC2(joinState.getEdge().getRreal().getR(),currState.getRreal(),
						
						currState.getRreal2());

					
				


			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {

				
				
	this.osHashJoinRC2(joinState.getEdge().getRreal().getR(),currState.getrCopied(),
						
						currState.getRreal2());
				
				
			
		

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
			// currState.getEdge().getRreal());

			// if(checker){
			// joinState.getEdge().getRreal().getR().clear();
			// joinState.getEdge().getRreal().getrIndex().clear();
			// }

		} else if (joinState.getEdge().getRreal().getR().isEmpty()
				&& !joinState.getEdge().getrCopied().getR().isEmpty()) {

			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {
				
				 osHashJoinCC(joinState.getEdge().getrCopied().getR(),currState.getC2(),currState.getRreal2());
				
			

			

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {
			
				
				
				
				
				
				
					this.osHashJoinRC2(joinState.getEdge().getrCopied().getR(),currState.getRreal(),
							
							currState.getRreal2());
					

			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {

				this.osHashJoinRC2(joinState.getEdge().getrCopied().getR(),currState.getrCopied(),
						
						currState.getRreal2());

				

			}

			
		}

		// // check the tablesomappedcopied

		// //////////////
		if (checker) {
			
			checker = false;

		}  
	}
    
	
	
	private void incrementalSSJoinStage2(KBRule currState, AutomataState joinState) {

		// /if the join state r and r join are empty

		if (joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) { // / the
																		// use
																		// the
																		// both
																		// C and
																		// put
																		// it in
																		// Rreal
																		// of
																		// both

			// /first check if the r is empty or ecopied is emptied for the
			// currstate

			// /If no existing joins have been executed and we need to join the
			// KB C with the new States C
			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				if (currState.getC2().keySize() < joinState.getRule().getC2()
						.keySize()) {

					this.ssJoinOptimisedForCC(currState.getC2(), joinState
							.getRule().getC2(), currState.getRreal2());
				} else {
					this.ssJoinOptimisedForCC(joinState.getRule().getC2(),
							currState.getC2(), currState.getRreal2());
				}

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				ssJoinOptimisedForRC2(joinState.getRule().getC2(),currState.getRreal(),
						
						currState.getRreal2());

				

			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {
				this.ssJoinOptimisedForRC2(joinState.getRule().getC2(),currState.getrCopied(),
						
						currState.getRreal2());

		            	}

			// this.ssJoinOptimisedForCC(currState.getRule().getC2(),
			// joinState.getRule().getC2(), currState.getEdge().getRreal(),
			// joinState.getEdge().getRreal());

		} else if (!joinState.getEdge().getRreal().getR().isEmpty()
				&& joinState.getEdge().getrCopied().getR().isEmpty()) {
			// use Real
			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				this.ssJoinOptimisedForCC(currState.getC2(),joinState
						.getEdge().getRreal().getR(),  currState.getRreal2());

				

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {

				

					this.ssJoinOptimisedForRC2(joinState.getEdge().getRreal().getR(),currState.getRreal(),
							    currState.getRreal2());
				


			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {

				 this.ssJoinOptimisedForRC2(joinState.getEdge().getRreal().getR(),currState.getrCopied(),
					    currState.getRreal2());
		

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getRreal(), joinState.getEdge().getrCopied(),
			// currState.getEdge().getRreal());

			// if(checker){
			// joinState.getEdge().getRreal().getR().clear();
			// joinState.getEdge().getRreal().getrIndex().clear();
			// }

		} else if (joinState.getEdge().getRreal().getR().isEmpty()
				&& !joinState.getEdge().getrCopied().getR().isEmpty()) {

			if (currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {
				this.ssJoinOptimisedForCC(currState.getC2(),
						joinState.getEdge().getrCopied().getR(), currState
								.getRreal2());

			

			} else if (!currState.getRreal().getR().isEmpty()
					&& currState.getrCopied().getR().isEmpty()) {
			
					this.ssJoinOptimisedForRC2(joinState.getEdge().getrCopied().getR(),currState.getRreal(),  currState
									.getRreal2());
				

			} else if (currState.getRreal().getR().isEmpty()
					&& !currState.getrCopied().getR().isEmpty()) {

				

				this.ssJoinOptimisedForRC2( joinState.getEdge().getrCopied().getR(),currState.getrCopied(), currState
						.getRreal2());

			}

			// this.ssJoinOptimisedForRC(currState.getRule().getC2(),
			// joinState.getEdge().getrCopied(), joinState.getEdge().getRreal(),
			// currState.getEdge().getRreal());

		}

		// // check the tablesomappedcopied

		// //////////////
		if (checker) {
			
			checker = false;

		}  
	}
    
    private void ssJoinOptimisedForCC( MultiBiMap<Long, Long> _c1,MultiBiMap<Long, Long> _c2,MultiBidirectionalIndex _r1){
        
   ///c1 is the current state, c2 is the join state, r1 is currentstate Rreal2 
    
          for(long key:_c2.keySet()){
           
           if(_c1.containsKey(key)){
                checker=true;
               _r1.getR().putAll(key, _c1.get(key));
                long index=++indexCount;
                Set<Long> r1val=_c1.get(key);
                for(long val:r1val)
                _r1.getrIndex().put(index, new SP(key,val));

                
               
                
   
                
                
           }
        //  
       }
        
        
        
    
    }
    
    
    
    
    

    private void ssJoinOptimisedForRC2( MultiBiMap<Long, Long> _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex _r3){
     ///make c1 the joinstate R, r2 the currentstate Multibiindex, and r3 the currectstate rReal


       for(long key:_c1.keySet()){
        
        if(_r2.getR().containsKey(key)){
            
           ///first get the index value from _r
           
     
            
            
            Set<Long> r2val=_r2.getR().get(key);
            
            for(Long value:r2val){
            	Set<Long> index = _r2.getrIndex().getKeys(new SP(key, value));
                ///can be multple indexes
                
                ///now go through all the indexes
            	 _r3.getR().put(key, value);
                for(Long lin:index){
                	Set<SP> sps= _r2.getrIndex().get(lin);
                
                	for(SP sp:sps){
                		 _r3.getrIndex().put(lin, sp);
                	     }
                	
                	 
                
                }
            }
            
            
            
            
            
           
            
          
             
             
        }
     
    }
       
       
 
 
 }
 
    
    private void osHashJoinCC(MultiBiMap<Long, Long> _c1,MultiBiMap<Long, Long> _c2,MultiBidirectionalIndex _r1){
        ///C1 values has been used its means the object of the automatastate is joined on the subject of KB
    	///first entry is the automatastate
    	
    	
        for(Long o:_c1.keySet()){
           
           if(_c2.containsValue(o)){ ///its the KB map
                  checker=true;
             
                  ////put all the values in r1 for the c2
                  //first get all the keys of c2
                  
                  Set<Long> keys = _c2.getKeys(o);
                 
                  for(Long k:keys){
                	   _r1.getrIndex().put(++indexCount,new SP(k,o));
                	     _r1.getR().put(k,o);
                  
                  }
                  
                  
                  
             
               
               
              
               
               ///get all the values of the with this key
              
           }
           
       }  
      
      
      
      
      
      
  } 
    
 
    private void soHashJoinCC(MultiBiMap<Long, Long> _c1,MultiBiMap<Long, Long> _c2,MultiBidirectionalIndex _r1){
        ///C1 values has been used its means the object of the automatastate is joined on the subject of KB
    	///first entry is the automatastate
    	
    	
        for(Long o:_c1.values()){
           
           if(_c2.containsKey(o)){
                  checker=true;
             
                  ////put all the values in r1 for the c2
                  //first get all the values of this key of c2
                  
                  Set<Long> values = _c2.get(o);
                 
                  for(Long v:values){
                	   _r1.getrIndex().put(++indexCount,new SP(o,v));
                	     _r1.getR().put(o,v);
                  
                  }
                  
                  
                  
             
               
               
              
               
               ///get all the values of the with this key
              
           }
           
       }  
      
      
      
      
      
      
  } 
    private void soHashJoinRC2(MultiBiMap<Long, Long> _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex _r3){
        ///first is the automatastate
        for(long sub:_c1.values()){
            
            if(_r2.getR().containsKey(sub)){
                
                   
                   
                   
                   Set<Long> r2val=_r2.getR().get(sub); //get all the keys for this value
                   
                   
                   
                   
                   for(Long value:r2val){  ///go through the so pairs
                   	Set<Long> index = _r2.getrIndex().getKeys(new SP(sub, value));
                       ///can be multple indexes
                       
                       ///now go through all the indexes
                   	 _r3.getR().put(sub, value);
                       for(Long lin:index){
                       	Set<SP> sps= _r2.getrIndex().get(lin);
                       
                       	for(SP sp:sps){
                       		 _r3.getrIndex().put(lin, sp);
                       	     }
                       	
                       	 
                       
                       }
                   }
                   
                   
                   
                   
                   
                   
             
               
             
                
                
            }
            
        }
         
     }
      
    private void osHashJoinRC2(MultiBiMap<Long, Long> _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex _r3){
        ///first is the automatastate
        for(long sub:_c1.keySet()){
            
            if(_r2.getR().containsValue(sub)){
                
                   
                   
                   
                   Set<Long> r2val=_r2.getR().getKeys(sub); //get all the keys for this value
                   
                   
                   
                   
                   for(Long key:r2val){  ///go through the so pairs
                   	Set<Long> index = _r2.getrIndex().getKeys(new SP(key, sub));
                       ///can be multple indexes
                       
                       ///now go through all the indexes
                   	 _r3.getR().put(key, sub);
                       for(Long lin:index){
                       	Set<SP> sps= _r2.getrIndex().get(lin);
                       
                       	for(SP sp:sps){
                       		 _r3.getrIndex().put(lin, sp);
                       	     }
                       	
                       	 
                       
                       }
                   }
                   
                   
                   
                   
                   
                   
             
               
             
                
                
            }
            
        }
         
     }
      
    
    
}
