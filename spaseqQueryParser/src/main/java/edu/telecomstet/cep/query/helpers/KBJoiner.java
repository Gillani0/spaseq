package edu.telecomstet.cep.query.helpers;

import java.util.List;
import java.util.Set;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.knowledgebase.KBRule;
import edu.telecomstet.cep.rulesmodel.Dependability;

public class KBJoiner {
	
	private boolean checker;
	private int stop=0;
	private long indexCount=0;
	
	private int greatestIndex= 10000000;
	
	private int indexID=0;
	
public void initiateKBJoins(List<KBRule> a){
	
	/**
	 * Execute all the joins for the KB rules.
	 */
	
	for(KBRule kbrule:a){
		
		this.kbJoin(kbrule, a);
		
	}
	
	/**
	 * Don't Extract the results from the KBjoins. In fact use it R or RCopied to check if the 
	 */
	
if(a.size()>1){
	for(KBRule s:a){
		s.getC2().clear();
 }	
}
	
//	KBRule fRule= a.stream().filter(x->x.getId()==this.indexID).findFirst().get();
//	
//	Set<Long> index=null ;
//	if(!fRule.getrCopied().getrIndex().isEmpty()){
//		index= fRule.getrCopied().getrIndex().keySet();
//	}else if(!fRule.getRreal().getrIndex().isEmpty()){
//		index = fRule.getRreal().getrIndex().keySet();
//	}
//	
//	
//	for(KBRule s:a){
//		s.getC2().clear();
//	}
//	
//	
//	for(Long i:index){
//		
//		
//		for(KBRule s:a){
//			
//		////remove the stuff from C and put the new stuff with the C
//			
//			  Set<SP> sp=null;
//	           if(!s.getRreal().getrIndex().isEmpty())
//	           {
//	             sp= s.getRreal().getrIndex().get(i);
//	              
//	             
//	               
//	               
//	           } else{
//	                sp= s.getrCopied().getrIndex().get(i);
//	           }
//	           
//	         
//	           
//	            for(SP out:sp){
//	                  
//	                
//	                
//	                ////put in the r and rIndex with the predicates as indexes
//	                
//	                 
//	             //   System.out.println(s.getRule().getObject().getProjection()+" "+dic.getResourceAdaptive(out.getSub())+" " +  out.getPred());
//	                s.getC2().put(out.getSub(), out.getPred());
//	            
//	                  
//	               
//	              }
//	            
//	      
//	            
//			
//		}
//		
//		
//	}
//	

	
}
	
	public void kbJoin(KBRule currState,List<KBRule> a){
	      for(Dependability dd:currState.getDepends()){
	            if(dd.getJoined()==0 && !dd.isStateDependability() ){
	                ///find the join state
	                KBRule sJoin = null; //a.getStates().stream().filter(x->x.getStateId()==dd.getDependabilty_id()).findFirst().get();
	                //  resultHandler=true;
	                 ///check the type of the Join
	                 
	                 
	                 for(KBRule s:a){ ///WTF
	                     if(s.getId()==dd.getDependabilty_id()){
	                         sJoin=s;
	                         ////firs check the dependability of the state
	                         if(!s .getDepends().isEmpty() && !s .getDepends().isEmpty()&& !s .getDepends().get(0).isStateDependability() && s .getDepends().get(0).getDependabilty_id()==currState.getId()){
	                          s .getDepends().get(0).setJoined(1);
	                         }else if(!s .getDepends().isEmpty() && s .getDepends().size()>1 && !s .getDepends().get(0).isStateDependability() &&  s .getDepends().get(0).getDependabilty_id()==currState.getId()){
	                             s .getDepends().get(1).setJoined(1);
	                         }
	                         break;
	                     }
	                 }
	                 
	                 
	                 
	                 if(dd.getDependability_On()==1 && dd.getDependability_part()==1 && stop==0){
	                      
	                        /// incrementalSSJoinStage1(sJoin,currState,a);
	                     IncrementalSSJoinStage2(currState,sJoin);
	                       
	                 }else if(dd.getDependability_On()==1 && dd.getDependability_part()==0 && stop==0 ){
	                     ///s for current stae
	                   //  incrementalOSJoin(currState,sJoin,a);
	                     
	                    this.incrementalOSJoinStage2(currState, sJoin);
	                     
	                 }else if(dd.getDependability_On()==0 && dd.getDependability_part()==1 && stop ==0){
	                
	                    
	                    this.incrementalSOJoinStage2(currState, sJoin);
	                 }else if(dd.getDependability_On()==0 && dd.getDependability_part()==0  && stop ==0){
	                    incrementalOOJoinStage2(currState,sJoin);
	                 }
	                 
	                 
	                 
	                 //TODO:check the smallest index over here
	                 
	                if(currState.getRreal().getrIndex().size() >0 && currState.getRreal().getrIndex().size()<= this.greatestIndex){
	                	
	                	
	                	///check the size of the joined index
	                	
	                	
	                	if(!sJoin.getRreal().getrIndex().isEmpty() && sJoin.getRreal().getrIndex().size() < currState.getRreal().getrIndex().size()){
	                		this.greatestIndex= sJoin.getRreal().getrIndex().size();
	                		this.indexID= sJoin.getId();
	                	}else if(!sJoin.getrCopied().getrIndex().isEmpty() && sJoin.getrCopied().getrIndex().size() < currState.getRreal().getrIndex().size()){
	                		this.greatestIndex= sJoin.getrCopied().getrIndex().size();
	                		this.indexID= sJoin.getId();
	                	}else{
	                		this.greatestIndex=currState.getRreal().getrIndex().size();
	                		this.indexID= currState.getId();
	                	}
	                	
	                	
	                	
	                	
	                	
	                }else if(currState.getrCopied().getrIndex().size() >0 && currState.getrCopied().getrIndex().size()<=this.greatestIndex){
	                	
	                	if(!sJoin.getRreal().getrIndex().isEmpty() && sJoin.getRreal().getrIndex().size() < currState.getRreal().getrIndex().size()){
	                		this.greatestIndex= sJoin.getRreal().getrIndex().size();
	                		this.indexID= sJoin.getId();
	                	}else if(!sJoin.getrCopied().getrIndex().isEmpty() && sJoin.getrCopied().getrIndex().size() < currState.getRreal().getrIndex().size()){
	                		this.greatestIndex= sJoin.getrCopied().getrIndex().size();
	                		this.indexID= sJoin.getId();
	                	}else{
	                		this.greatestIndex=currState.getrCopied().getrIndex().size();
	                		this.indexID= currState.getId();
	                	}
	                	
	                }
	            }
	        }
	}
	
	
	private void incrementalOOJoinStage2(KBRule currState, KBRule joinState){
        
        
		   if(joinState.getRreal().getR().isEmpty() && joinState.getrCopied().getR().isEmpty()){ /// the use the both C and put it in Rreal of both
		          
		                    ///first check if the r is empty or ecopied is emptied for the currstate
		                    
		                   
		                    if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                                 //  this.ssJoinOptimisedForCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
		                   
		                    if(currState.getC2().valueSize()<joinState.getC2().valueSize()){
		                        this.ooHashJoinCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
		                    }else{
		                         this.ooHashJoinCC(joinState.getC2(),currState.getC2(), joinState.getRreal(),currState.getRreal());
		                    }
		                    
		                   // this.ooHashJoinCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
		                    
		                    
		                    
		                    }else
		                    
		                    
		                    
		                    if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                     // this.osHashJoinRC(null, null, null, null);
		                      this.ooHashJoinRC(joinState.getC2(), currState.getRreal(), joinState.getRreal(),currState.getrCopied());
		                         if(checker){
		                 
		                     currState.getRreal().getR().clear();
		                      currState.getRreal().getrIndex().clear();
		                      
		                   
		               }
		                      
		                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
		                          this.ooHashJoinRC(joinState.getC2(), currState.getrCopied(), joinState.getRreal(),currState.getRreal());
		                   
		                    
		                     if(checker){
		                 
		                     currState.getrCopied().getR().clear();
		                      currState.getrCopied().getrIndex().clear();
		                      
		                   
		               }
		                    
		                    
		                    
		                    }
		                    
		                    
		                 //   this.ssJoinOptimisedForCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
		                    
		                    
		                    
		           
		       }else if(!joinState.getRreal().getR().isEmpty() && joinState.getrCopied().getR().isEmpty() ){ 
		           //use Real 
		           if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty()){
		                this.ooHashJoinRC(currState.getC2(), joinState.getRreal(),currState.getRreal(), joinState.getrCopied());
		           
		           
		            if(checker){
		               joinState.getRreal().getR().clear();
		               joinState.getRreal().getrIndex().clear();
		           }
		           
		           }else
		            
		                    if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                        if(joinState.getRreal().getR().valueSize()<currState.getRreal().getR().valueSize()){
		                        ooHashJoinRC2(joinState.getRreal(), currState.getRreal(), joinState.getrCopied(),currState.getrCopied());
		                        }else{
		                              ooHashJoinRC2( currState.getRreal(),joinState.getRreal(), joinState.getrCopied(),currState.getrCopied());
		                        }
		                        
		                         if(checker){
		                      joinState.getRreal().getR().clear();
		                      joinState.getRreal().getrIndex().clear();
		                     currState.getRreal().getR().clear();
		                      currState.getRreal().getrIndex().clear();
		                      
		                   
		               }
		                      
		                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
		                         
		                        if(joinState.getRreal().getR().valueSize()<currState.getrCopied().getR().valueSize()){
		                        ooHashJoinRC2(joinState.getRreal(), currState.getrCopied(), joinState.getrCopied(),currState.getRreal());
		                        }else{
		                              ooHashJoinRC2(currState.getrCopied(),joinState.getRreal(),currState.getRreal(), joinState.getrCopied());
		                        }
		                    
		                    if(checker){
		                      joinState.getRreal().getR().clear();
		                      joinState.getRreal().getrIndex().clear();
		                     currState.getrCopied().getR().clear();
		                      currState.getrCopied().getrIndex().clear();
		                      
		                   
		               }
		                    
		                    }
		                    
		           
		           
		           
		          // this.ssJoinOptimisedForRC(currState.getC2(), joinState.getRreal(), joinState.getrCopied(), currState.getRreal());
		      
		       //    if(checker){
		         //      joinState.getRreal().getR().clear();
		           //    joinState.getRreal().getrIndex().clear();
		          // }
		           
		       }else if(joinState.getRreal().getR().isEmpty() && !joinState.getrCopied().getR().isEmpty()){
		             
		           if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty()){
		                this.ooHashJoinRC(currState.getC2(), joinState.getrCopied(),  currState.getRreal(),joinState.getRreal()); 
		          
		           if(checker){
		                      joinState.getrCopied().getR().clear();
		                      joinState.getrCopied().getrIndex().clear();
		                   
		               }
		       
		           
		           }else
		           
		            if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                        
		                
		                
		                if(joinState.getrCopied().getR().valueSize()<currState.getRreal().getR().valueSize()){
		                       ooHashJoinRC2(joinState.getrCopied(), currState.getRreal(), joinState.getRreal(),currState.getrCopied());
		                }else{
		                      ooHashJoinRC2(currState.getRreal(),joinState.getrCopied(),currState.getrCopied(), joinState.getRreal());
		                }
		                
		                        
		                         if(checker){
		                      joinState.getrCopied().getR().clear();
		                      joinState.getrCopied().getrIndex().clear();
		                     currState.getRreal().getR().clear();
		                      currState.getRreal().getrIndex().clear();
		                      
		                   
		               }
		       
		                        
		                      
		                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
		                    
		                        
		                        if(joinState.getrCopied().getR().valueSize()<currState.getrCopied().getR().valueSize()){
		                        ooHashJoinRC2(joinState.getrCopied(), currState.getrCopied(), joinState.getRreal(),currState.getRreal());
		                        }else{
		                             ooHashJoinRC2(currState.getrCopied(),joinState.getrCopied(),currState.getRreal(), joinState.getRreal());
		                        }
		                    
		                    
		                      if(checker){
		                      joinState.getrCopied().getR().clear();
		                      joinState.getrCopied().getrIndex().clear();
		                     currState.getrCopied().getR().clear();
		                      currState.getrCopied().getrIndex().clear();
		                      
		                   
		               }
		                    
		                    
		                    }
		           
		           



		       }
		      if(checker){
		              checker=false;
		                 
		        }else{
		            stop=1;
		        }

		    
		     }
		    
		  
	
	private void incrementalSOJoinStage2(KBRule currState, KBRule joinState){
        
		   if(joinState.getRreal().getR().isEmpty() && joinState.getrCopied().getR().isEmpty()){ /// the use the both C and put it in Rreal of both
		          
		                    ///first check if the r is empty or ecopied is emptied for the currstate
		                    
		                   
		                    if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                                 //  this.ssJoinOptimisedForCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
		                   
		                    
		                   if(currState.getC2().size()<joinState.getC2().size()){
		                        
		                    
		                    this.soHashJoinCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
		                 }else{
		                       this.osHashJoinCC( joinState.getC2(),currState.getC2(), joinState.getRreal(),currState.getRreal());
		                   }
		                    
		                    
		                    }else
		                    
		                    
		                    
		                    if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                   
		                 ///reverse function
		                        
		                        this.osHashJoinRC(joinState.getC2(), currState.getRreal(), joinState.getRreal(),currState.getrCopied());
		                         if(checker){
		                 
		                     currState.getRreal().getR().clear();
		                      currState.getRreal().getrIndex().clear();
		                      
		                   
		               }
		                      
		                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
		                         
		                    
		                        
		                     //reverse function
		                        this.osHashJoinRC(joinState.getC2(), currState.getrCopied(), joinState.getRreal(),currState.getRreal());
		                   
		                    
		                     if(checker){
		                 
		                     currState.getrCopied().getR().clear();
		                      currState.getrCopied().getrIndex().clear();
		                      
		                   
		               }
		                    
		                    
		                    
		                    }
		                    
		                    
		                 //   this.ssJoinOptimisedForCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
		                    
		                    
		                    
		           
		       }else if(!joinState.getRreal().getR().isEmpty() && joinState.getrCopied().getR().isEmpty() ){ 
		           //use Real 
		           if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty()){
		                this.soHashJoinRC(currState.getC2(), joinState.getRreal(), currState.getRreal(), joinState.getrCopied());
		           
		           
		            if(checker){
		               joinState.getRreal().getR().clear();
		               joinState.getRreal().getrIndex().clear();
		           }
		           
		           }else
		            
		                    if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                      
		                        
		                        if(currState.getRreal().getR().size()<joinState.getRreal().getR().size()){
		                        
		                        soHashJoinRC2(currState.getRreal(),joinState.getRreal(), currState.getrCopied(),joinState.getrCopied());
		                        }else{
		                               osHashJoinRC2(joinState.getRreal(),currState.getRreal(),joinState.getrCopied(), currState.getrCopied());
		                        }
		                        
		                         if(checker){
		                      joinState.getRreal().getR().clear();
		                      joinState.getRreal().getrIndex().clear();
		                     currState.getRreal().getR().clear();
		                      currState.getRreal().getrIndex().clear();
		                      
		                   
		               }
		                      
		                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
		                        
		                    if(currState.getrCopied().getR().size()<joinState.getRreal().getR().size()){
		                        soHashJoinRC2(currState.getrCopied(),joinState.getRreal(), currState.getRreal(),joinState.getrCopied());
		                    }else{
		                          osHashJoinRC2(joinState.getRreal(),currState.getrCopied(), joinState.getrCopied(),currState.getRreal());
		                    }
		                    
		                    if(checker){
		                      joinState.getRreal().getR().clear();
		                      joinState.getRreal().getrIndex().clear();
		                     currState.getrCopied().getR().clear();
		                      currState.getrCopied().getrIndex().clear();
		                      
		                   
		               }
		                    
		                    }
		                    
		           
		           
		           
		          // this.ssJoinOptimisedForRC(currState.getC2(), joinState.getRreal(), joinState.getrCopied(), currState.getRreal());
		      
		       //    if(checker){
		         //      joinState.getRreal().getR().clear();
		           //    joinState.getRreal().getrIndex().clear();
		          // }
		           
		       }else if(joinState.getRreal().getR().isEmpty() && !joinState.getrCopied().getR().isEmpty()){
		             
		           if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty()){
		                this.soHashJoinRC(currState.getC2(), joinState.getrCopied(), currState.getRreal(), joinState.getRreal()); 
		          
		           if(checker){
		                      joinState.getrCopied().getR().clear();
		                      joinState.getrCopied().getrIndex().clear();
		                   
		               }
		       
		           
		           }else
		           
		            if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
		                   
		                
		             if(currState.getRreal().getR().size()<joinState.getrCopied().getR().size()){
		                   soHashJoinRC2(currState.getRreal(), joinState.getrCopied(), currState.getrCopied(),joinState.getRreal());
		             }else{
		                  osHashJoinRC2(joinState.getrCopied(),currState.getRreal(),joinState.getRreal(), currState.getrCopied());
		             }
		                 
		                        
		                         if(checker){
		                      joinState.getrCopied().getR().clear();
		                      joinState.getrCopied().getrIndex().clear();
		                     currState.getRreal().getR().clear();
		                      currState.getRreal().getrIndex().clear();
		                      
		                   
		               }
		       
		                        
		                      
		                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
		                     
		                       if(currState.getrCopied().getR().size()<joinState.getrCopied().getR().size()){
		                             soHashJoinRC2(currState.getrCopied(),joinState.getrCopied(), currState.getRreal(),joinState.getRreal());
		                       }else{
		                             osHashJoinRC2(joinState.getrCopied(),currState.getrCopied(), currState.getRreal(),joinState.getRreal());
		                       }
		                      
		                    
		                    
		                    
		                      if(checker){
		                      joinState.getrCopied().getR().clear();
		                      joinState.getrCopied().getrIndex().clear();
		                     currState.getrCopied().getR().clear();
		                      currState.getrCopied().getrIndex().clear();
		                      
		                   
		               }
		                    
		                    
		                    }
		           
		           



		       }
		      if(checker){
		              checker=false;
		                 
		        }else{
		            stop=1;
		        }
		        }
		    
  private void IncrementalSSJoinStage2(KBRule currState,KBRule joinState){
          
          
          ///if the join state r and r join are empty
          
          
          
                if(joinState .getRreal().getR().isEmpty() && joinState .getrCopied().getR().isEmpty()){ /// the use the both C and put it in Rreal of both
          
                    ///first check if the r is empty or ecopied is emptied for the currstate
                    
                   
                    if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
                                
                        
                        if(currState.getC2().keySize()<joinState .getC2().keySize()){
                        
                        this.ssJoinOptimisedForCC(currState.getC2(), joinState .getC2(), currState.getRreal(), joinState .getRreal());
                } else{
                              this.ssJoinOptimisedForCC(joinState .getC2(),currState.getC2(),  joinState .getRreal(), currState.getRreal());
                        }
                    
                    
                    }else
                    
                    
                    
                    if(!currState .getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
                        
                        
                        
                        
                        this.ssJoinOptimisedForRC(joinState .getC2(), currState.getRreal(), joinState .getRreal(),currState.getrCopied());
                         
                        
                        
                        
                        
                        if(checker){
                 
                     currState .getRreal().getR().clear();
                      currState .getRreal().getrIndex().clear();
                      
                   
               }
                      
                    }else if (currState .getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
                         this.ssJoinOptimisedForRC(joinState .getC2(), currState .getrCopied(), joinState .getRreal(),currState .getRreal());
                   
                    
                     if(checker){
                 
                     currState .getrCopied().getR().clear();
                      currState .getrCopied().getrIndex().clear();
                      
                   
               }
                    
                    
                    
                    }
                    
                    
                 //   this.ssJoinOptimisedForCC(currState .getC2(), joinState .getC2(), currState .getRreal(), joinState .getRreal());
                    
                    
                    
           
       }else if(!joinState .getRreal().getR().isEmpty() && joinState .getrCopied().getR().isEmpty() ){ 
           //use Real 
           if(currState .getRreal().getR().isEmpty() && currState .getrCopied().getR().isEmpty()){
               
               this.ssJoinOptimisedForRC(currState .getC2(), joinState .getRreal(), currState .getRreal(),joinState .getrCopied() );
           
           
            if(checker){
               joinState .getRreal().getR().clear();
               joinState .getRreal().getrIndex().clear();
           }
           
           }else
            
                    if(!currState .getRreal().getR().isEmpty() && currState .getrCopied().getR().isEmpty() ){
                        
                        if(joinState .getRreal().getR().keySize()<currState .getRreal().getR().keySize()){
                        
                        this.ssJoinOptimisedForRC2(joinState .getRreal(), currState .getRreal(), joinState .getrCopied(),currState .getrCopied());
                        }else{
                        this.ssJoinOptimisedForRC2(currState .getRreal(),joinState .getRreal(),currState .getrCopied(), joinState .getrCopied());
                             }
                        
                        
                         if(checker){
                      joinState .getRreal().getR().clear();
                      joinState .getRreal().getrIndex().clear();
                     currState .getRreal().getR().clear();
                      currState .getRreal().getrIndex().clear();
                      
                   
               }
                      
                    }else if (currState .getRreal().getR().isEmpty() && !currState .getrCopied().getR().isEmpty()){
                       
                        if(joinState .getRreal().getR().keySize()<currState .getrCopied().getR().keySize()){
                        this.ssJoinOptimisedForRC2(joinState .getRreal(), currState .getrCopied(), joinState .getrCopied(),currState .getRreal());
                        }else{
                            this.ssJoinOptimisedForRC2(currState .getrCopied(),joinState .getRreal(), currState .getRreal(),joinState .getrCopied()); 
                        }
                    
                    if(checker){
                      joinState .getRreal().getR().clear();
                      joinState .getRreal().getrIndex().clear();
                     currState .getrCopied().getR().clear();
                      currState .getrCopied().getrIndex().clear();
                      
                   
               }
                    
                    }
                    
           
           
           
          // this.ssJoinOptimisedForRC(currState .getC2(), joinState .getRreal(), joinState .getrCopied(), currState .getRreal());
      
       //    if(checker){
         //      joinState .getRreal().getR().clear();
           //    joinState .getRreal().getrIndex().clear();
          // }
           
       }else if(joinState .getRreal().getR().isEmpty() && !joinState .getrCopied().getR().isEmpty()){
             
           if(currState .getRreal().getR().isEmpty() && currState .getrCopied().getR().isEmpty()){
                this.ssJoinOptimisedForRC(currState .getC2(), joinState .getrCopied(), currState .getRreal(), joinState .getRreal()); 
          
           if(checker){
                      joinState.getrCopied().getR().clear();
                      joinState .getrCopied().getrIndex().clear();
                   
               }
       
           
           }else
           
            if(!currState .getRreal().getR().isEmpty() && currState .getrCopied().getR().isEmpty() ){
                       if(joinState .getrCopied().getR().keySize()< currState .getRreal().getR().keySize()) {
                        this.ssJoinOptimisedForRC2(joinState .getrCopied(), currState .getRreal(), joinState .getRreal(),currState .getrCopied());
                       }else{
                        this.ssJoinOptimisedForRC2(currState .getRreal(),joinState .getrCopied(), currState .getrCopied(),joinState .getRreal());
                       }    
                         if(checker){
                      joinState .getrCopied().getR().clear();
                      joinState .getrCopied().getrIndex().clear();
                     currState .getRreal().getR().clear();
                      currState .getRreal().getrIndex().clear();
                      
                   
               }
       
                        
                      
                    }else if (currState .getRreal().getR().isEmpty() && !currState .getrCopied().getR().isEmpty()){
                         
                        
                        if(joinState .getrCopied().getR().keySize()<currState .getrCopied().getR().keySize()){
                        this.ssJoinOptimisedForRC2(joinState .getrCopied(), currState .getrCopied(), joinState .getRreal(),currState .getRreal());
                        }else{
                              this.ssJoinOptimisedForRC2(currState .getrCopied(),joinState .getrCopied(), currState .getRreal(), joinState .getRreal());
                        }
                    
                    
                      if(checker){
                      joinState .getrCopied().getR().clear();
                      joinState .getrCopied().getrIndex().clear();
                     currState .getrCopied().getR().clear();
                      currState .getrCopied().getrIndex().clear();
                      
                   
               }
                    
                    
                    }
           
           
           
           
           
     //      this.ssJoinOptimisedForRC(currState .getC2(), joinState .getrCopied(), joinState .getRreal(), currState .getRreal());
      
    
           
       
       }
         
         
         
       
         
         
        
      //// check the tablesomappedcopied
        
       
        ////////////////
         if(checker)
            {
             
                checker=false;
              
            }else{
             stop=1;
            }
             
             
         
        
        
        
        
             
          
          
      }   
       
  private void ssJoinOptimisedForCC( MultiBiMap<Long, Long> _c1,MultiBiMap<Long, Long> _c2,MultiBidirectionalIndex _r1,MultiBidirectionalIndex  _r2){
      
      
      
      for(long key:_c1.keySet()){
       
       if(_c2.containsKey(key)){
            checker=true;
           _r1.getR().putAll(key, _c1.get(key));
            long index=++indexCount;
            Set<Long> r1val=_c1.get(key);
            for(long val:r1val)
            _r1.getrIndex().put(index, new SP(key,val));

            
            _r2.getR().putAll(key, _c2.get(key));
            
            Set<Long> r2val=_c2.get(key);
            for(long val:r2val)
            _r2.getrIndex().put(index, new SP(key,val));
            
            
       }
    //  
   }
    
    
    

}
   
  
  private void ssJoinOptimisedForRC(MultiBiMap<Long, Long> _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex  _r4,MultiBidirectionalIndex _r3){
      

      if(_c1.keySize()<_r2.getR().keySize()){
          
      
  
        for(long key:_c1.keySet()){
         
         if(_r2.getR().containsKey(key)){
             
            ///first get the index value from _r
             checker=true;
            // _r2.getR().getValue(key);
             
             long index = _r2.getrIndex().getKey(new SP(key, _r2.getR().getValue(key)));
             
             
             _r3.getR().putAll(key,_r2.getR().get(key));
             
              Set<Long> r2val=_r2.getR().get(key); //put all in the new r whcich is r3  
             for(long val:r2val)
              _r3.getrIndex().put(index, new SP(key,val));

              
             
             ///now put the stuff in r3 which is for the join state
             
             _r4.getR().putAll(key,_c1.get(key));

              Set<Long> c1val=_c1.get(key);
              for(long val2:c1val)
              _r4.getrIndex().put(index, new SP(key,val2));
              
              
         }
      //  
     }
        
      }else{
          
          
          
          for(long key:_r2.getR().keySet()){
         
         if(_c1.containsKey(key)){
             
            ///first get the index value from _r
             checker=true;
            // _r2.getR().getValue(key);
             
             long index = _r2.getrIndex().getKey(new SP(key, _r2.getR().getValue(key)));
             
             
             _r3.getR().putAll(key,_r2.getR().get(key));
             
              Set<Long> r2val=_r2.getR().get(key); //put all in the new r whcich is r3  
             for(long val:r2val)
              _r3.getrIndex().put(index, new SP(key,val));

              
             
             ///now put the stuff in r3 which is for the join state
             
             _r4.getR().putAll(key,_c1.get(key));

              Set<Long> c1val=_c1.get(key);
              for(long val2:c1val)
              _r4.getrIndex().put(index, new SP(key,val2));
              
              
         }
      //  
     }
          
      }
        
        
        
        
        ///clear every thing in the R2
    //    _r2.getR().clear();
      //  _r2.getrIndex().clear();
  
  
  }
  
  

  private void ssJoinOptimisedForRC2(MultiBidirectionalIndex _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex  _r4,MultiBidirectionalIndex _r3){
   


     for(long key:_c1.getR().keySet()){
      
      if(_r2.getR().containsKey(key)){
          
         ///first get the index value from _r
          checker=true;
         // _r2.getR().getValue(key);
          
          long index = _r2.getrIndex().getKey(new SP(key, _r2.getR().getValue(key)));
          
          
          _r3.getR().putAll(key,_r2.getR().get(key));
          
           Set<Long> r2val=_r2.getR().get(key); //put all in the new r whcich is r3  
          for(long val:r2val)
           _r3.getrIndex().put(index, new SP(key,val));

           
          
          ///now put the stuff in r3 which is for the join state
       index = _c1.getrIndex().getKey(new SP(key, _c1.getR().getValue(key)));
          
         _r4.getR().putAll(key,_c1.getR().get(key));

           Set<Long> c1val=_c1.getR().get(key);
           for(long val2:c1val)
           _r4.getrIndex().put(index, new SP(key,val2));
           
           
      }
   //  
  }
     
     
     ///clear every thing in the R2
 //    _r2.getR().clear();
   //  _r2.getrIndex().clear();


}




  private void incrementalOSJoinStage2(KBRule currState, KBRule joinState){//AutomataState currState, AutomataState joinState, Automata a, long pred1, long pred2){
      
      
	   if(joinState.getRreal().getR().isEmpty() && joinState.getrCopied().getR().isEmpty()){ /// the use the both C and put it in Rreal of both
	          
	                    ///first check if the r is empty or ecopied is emptied for the currstate
	                    
	                   
	                    if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
	                                 //  this.ssJoinOptimisedForCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
	                   
	                    if(currState.getC2().size()<joinState.getC2().size()){
	                    
	                    this.osHashJoinCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
	                    }else{
	                          this.soHashJoinCC(joinState.getC2(),currState.getC2(),joinState.getRreal(), currState.getRreal() );
	                    }
	                    
	                    
	                    }else
	                    
	                    
	                    
	                    if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
	                     // this.osHashJoinRC(null, null, null, null);
	                        
	                        
	                   
	                      this.soHashJoinRC(joinState.getC2(), currState.getRreal(), joinState.getRreal(),currState.getrCopied());
	                        
	                      
	                           if(checker){
	                 
	                     currState.getRreal().getR().clear();
	                      currState.getRreal().getrIndex().clear();
	                      
	                   
	               }
	                      
	                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
	                         
	                     
	                        this.soHashJoinRC(joinState.getC2(), currState.getrCopied(), joinState.getRreal(),currState.getRreal());
	                   
	                    
	                     if(checker){
	                 
	                     currState.getrCopied().getR().clear();
	                      currState.getrCopied().getrIndex().clear();
	                      
	                   
	               }
	                    
	                    
	                    
	                    }
	                    
	                    
	                 //   this.ssJoinOptimisedForCC(currState.getC2(), joinState.getC2(), currState.getRreal(), joinState.getRreal());
	                    
	                    
	                    
	           
	       }else if(!joinState.getRreal().getR().isEmpty() && joinState.getrCopied().getR().isEmpty() ){ 
	           //use Real 
	           if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty()){
	                this.osHashJoinRC(currState.getC2(), joinState.getRreal(),currState.getRreal(), joinState.getrCopied());
	           
	           
	            if(checker){
	               joinState.getRreal().getR().clear();
	               joinState.getRreal().getrIndex().clear();
	           }
	           
	           }else
	            
	                    if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
	                  
	                        
	                        
	                        if(currState.getRreal().getR().size()<joinState.getRreal().getR().size()){
	                              osHashJoinRC2(currState.getRreal(),joinState.getRreal(),currState.getrCopied(),joinState.getrCopied());
	                        }else{
	                             soHashJoinRC2(joinState.getRreal(),currState.getRreal(),joinState.getrCopied(),currState.getrCopied());
	                        }
	                        
	                      
	                        
	                        
	                         if(checker){
	                      joinState.getRreal().getR().clear();
	                      joinState.getRreal().getrIndex().clear();
	                     currState.getRreal().getR().clear();
	                      currState.getRreal().getrIndex().clear();
	                      
	                   
	               }
	                      
	                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
	                        
	                      if(currState.getrCopied().getR().size()<joinState.getRreal().getR().size()){
	                            osHashJoinRC2( currState.getrCopied(),joinState.getRreal(),currState.getRreal(), joinState.getrCopied());
	                      }else{
	                            soHashJoinRC2( joinState.getRreal(),currState.getrCopied(),joinState.getrCopied(),currState.getRreal());
	                      }
	                      
	                  
	                    
	                    if(checker){
	                      joinState.getRreal().getR().clear();
	                      joinState.getRreal().getrIndex().clear();
	                     currState.getrCopied().getR().clear();
	                      currState.getrCopied().getrIndex().clear();
	                      
	                   
	               }
	                    
	                    }
	                    
	           
	           
	           
	          // this.ssJoinOptimisedForRC(currState.getC2(), joinState.getRreal(), joinState.getrCopied(), currState.getRreal());
	      
	       //    if(checker){
	         //      joinState.getRreal().getR().clear();
	           //    joinState.getRreal().getrIndex().clear();
	          // }
	           
	       }else if(joinState.getRreal().getR().isEmpty() && !joinState.getrCopied().getR().isEmpty()){
	             
	           if(currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty()){
	                this.osHashJoinRC(currState.getC2(), joinState.getrCopied(),  currState.getRreal(),joinState.getRreal()); 
	          
	           if(checker){
	                      joinState.getrCopied().getR().clear();
	                      joinState.getrCopied().getrIndex().clear();
	                   
	               }
	       
	           
	           }else
	           
	            if(!currState.getRreal().getR().isEmpty() && currState.getrCopied().getR().isEmpty() ){
	                     
	                  
	                
	                if(currState.getRreal().getR().size()<joinState.getrCopied().getR().size()){
	                       osHashJoinRC2(currState.getRreal(),joinState.getrCopied() , currState.getrCopied(),joinState.getRreal());
	                }else{
	                      soHashJoinRC2(joinState.getrCopied() ,currState.getRreal(), joinState.getRreal(), currState.getrCopied());
	                }
	             //   osHashJoinRC2(currState.getRreal(),joinState.getrCopied() , currState.getrCopied(),joinState.getRreal());
	                        
	                         if(checker){
	                      joinState.getrCopied().getR().clear();
	                      joinState.getrCopied().getrIndex().clear();
	                      currState.getRreal().getR().clear();
	                      currState.getRreal().getrIndex().clear();
	                      
	                   
	               }
	       
	                        
	                      
	                    }else if (currState.getRreal().getR().isEmpty() && !currState.getrCopied().getR().isEmpty()){
	                     
	                        if(currState.getrCopied().getR().size()<joinState.getrCopied().getR().size()){
	                              osHashJoinRC2(currState.getrCopied(),joinState.getrCopied(), currState.getRreal(),joinState.getRreal());
	                        }else{
	                              soHashJoinRC2(joinState.getrCopied(),currState.getrCopied(), joinState.getRreal(),currState.getRreal());
	                        }
	                   
	                      
	                    
	                    
	                    
	                      if(checker){
	                      joinState.getrCopied().getR().clear();
	                      joinState.getrCopied().getrIndex().clear();
	                     currState.getrCopied().getR().clear();
	                      currState.getrCopied().getrIndex().clear();
	                      
	                   
	               }
	                    
	                    
	                    }
	           
	           



	       }
	      if(checker){
	              checker=false;
	                 
	        }else{
	            stop=1;
	        }
	    }
	    
	      
  private void osHashJoinCC(MultiBiMap<Long, Long> _c1,MultiBiMap<Long, Long> _c2,MultiBidirectionalIndex _r1,MultiBidirectionalIndex  _r2){
      
      for(Long o:_c1.keySet()){//change the order
         
         if(_c2.containsValue(o)){
             checker=true;
             _r1.getR().putAll(o, _c1.get(o));
              long index=++indexCount;
             Set<Long> val=_c1.get(o);
             for(long v:val)
              _r1.getrIndex().put(index,new SP(o, v));
             
             
             _r2.getR().put(_c2.getKey(o), o);
             _r2.getrIndex().put(index,new SP(_c2.getKey(o), o));  ///change it later
             
             ///get all the values of the with this key
            
         }
         
     }  
    
    
    
    
    
    
}
  private void soHashJoinCC(MultiBiMap<Long, Long> _c1,MultiBiMap<Long, Long> _c2,MultiBidirectionalIndex _r1,MultiBidirectionalIndex  _r2){
      
      for(Long o:_c1.values()){//change the order
         
         if(_c2.containsKey(o)){
                checker=true;
           
             _r1.getR().put(_c1.getKey(o), o);
              long index=++indexCount;
            
                 _r1.getrIndex().put(index,new SP(_c1.getKey(o), o));
              
              Set<Long> val=_c2.get(o);
             for(long v:val){
                  _r2.getR().put(o,v);
                    _r2.getrIndex().put(index,new SP(o, v));
             }
             
             
             
            
             
             ///get all the values of the with this key
            
         }
         
     }  
    
    
    
    
    
    
} 
  private void soHashJoinRC(MultiBiMap<Long, Long> _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex _r3,MultiBidirectionalIndex  _r4){
      
      
      if(_c1.size()<_r2.getR().size()){
      
     for(long sub:_c1.values()){
         
         if(_r2.getR().containsKey(sub)){
                checker=true;
             ///first get the index value from r2
             long index=_r2.getrIndex().getKey(new SP(sub,_r2.getR().getValue(sub)));
              for(long val:_r2.getR().get(sub)){
                 _r4.getR().put(sub, val);
                 _r4.getrIndex().put(index, new SP(sub,val));
             }
             
             
             
             
             _r3.getR().put(_c1.getKey(sub), sub);
             
             
            
             
             
             _r3.getrIndex().put(index, new SP(_c1.getKey(sub), sub));
            
          
             
             
         }
         
     }
      }else{
          
           for(long sub:_r2.getR().keySet()){
                if(_c1.containsValue(sub)){
                    
                     checker=true;
             ///first get the index value from r2
             long index=_r2.getrIndex().getKey(new SP(sub,_r2.getR().getValue(sub)));
              for(long val:_r2.getR().get(sub)){
                 _r4.getR().put(sub, val);
                 _r4.getrIndex().put(index, new SP(sub,val));
             }
             
             
             
             
             _r3.getR().put(_c1.getKey(sub), sub);
             
             
            
             
             
             _r3.getrIndex().put(index, new SP(_c1.getKey(sub), sub));
            
          
             
                    
                    
                    
                }
           }
          
          
          
          
          
          
          
          
          
          
          
          
      }
      
      
      
      
      
  }
  
  
  private void osHashJoinRC(MultiBiMap<Long, Long> _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex  _r4,MultiBidirectionalIndex _r3){
      
      
      if(_c1.keySize()<_r2.getR().valueSize()){
      
     for(long sub:_c1.keySet()){
         
         if(_r2.getR().containsValue(sub)){
             ///first get the index value from r2
             _r3.getR().put(_r2.getR().getKey(sub), sub);
                checker=true;
             
             SP sp= new SP(_r2.getR().getKey(sub), sub);
             long index=_r2.getrIndex().getKey(sp);
             
             _r3.getrIndex().put(index, sp);
             
             for(long val:_c1.get(sub)){
                 _r4.getR().put(sub, val);
                 _r4.getrIndex().put(index, new SP(sub,val));
             }
             
          
             
             
         }
         
     }
      }else{
     
     
     for(long sub:_r2.getR().values()){
          if(_c1.containsKey(sub)){
              
              _r3.getR().put(_r2.getR().getKey(sub), sub);
                checker=true;
                 SP sp= new SP(_r2.getR().getKey(sub), sub);
                 long index=_r2.getrIndex().getKey(sp);
                  _r3.getrIndex().put(index, sp);
                  
                   for(long val:_c1.get(sub)){
                 _r4.getR().put(sub, val);
                 _r4.getrIndex().put(index, new SP(sub,val));
             }
                  
                  
              
          }
         
     }
     
      }
     
     
     
      
  }
  
  private void osHashJoinRC2(MultiBidirectionalIndex _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex  _r4,MultiBidirectionalIndex _r3){
        
     for(long sub:_c1.getR().keySet()){
         
         if(_r2.getR().containsValue(sub)){
             ///first get the index value from r2
             _r3.getR().put(_r2.getR().getKey(sub), sub);
                checker=true;
             
             SP sp= new SP(_r2.getR().getKey(sub), sub);
             long index=_r2.getrIndex().getKey(sp);
             
             _r3.getrIndex().put(index, sp);
             index=_c1.getrIndex().getKey(new SP(sub,_c1.getR().getValue(sub)));
             for(long val:_c1.getR().get(sub)){
                 _r4.getR().put(sub, val);
                 _r4.getrIndex().put(index, new SP(sub,val));
             }
             
          
             
             
         }
         
     }
      
  }

  
  private void soHashJoinRC2(MultiBidirectionalIndex _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex _r3,MultiBidirectionalIndex  _r4){
        
     for(long sub:_c1.getR().values()){
         
         if(_r2.getR().containsKey(sub)){
                checker=true;
             ///first get the index value from r2
             long index=_r2.getrIndex().getKey(new SP(sub,_r2.getR().getValue(sub)));
              for(long val:_r2.getR().get(sub)){
                 _r4.getR().put(sub, val);
                 _r4.getrIndex().put(index, new SP(sub,val));
             }
             
             
             
             
              
              SP sp=new SP(_c1.getR().getKey(sub), sub);
           
              _r3.getR().put(sp.getSub(), sub);
             
            index= _c1.getrIndex().getKey(sp);
            
             
             
             _r3.getrIndex().put(index, sp);
            
          
             
             
         }
         
     }
      
  }
  private void ooHashJoinRC2(MultiBidirectionalIndex _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex _r3,MultiBidirectionalIndex  _r4){
      
      
      for(long obj:_c1.getR().values()){
          if(_r2.getR().containsValue(obj)){
              
              checker=true;
              ///first get the index from the _r2
              SP sp1 =new SP(_c1.getR().getKey(obj), obj);
              
             long index= _c1.getrIndex().getKey(sp1);
             
             _r3.getR().put(sp1.getSub(), obj);
             _r3.getrIndex().put(index,sp1);
             
             
             SP sp = new SP(_r2.getR().getKey(obj),obj);
              index= _r2.getrIndex().getKey(sp);
              
             _r4.getR().put(sp.getSub(),obj);
             _r4.getrIndex().put(index, sp);
             
             
              
              
          }
          
          
      }
      
      
      
      
  }
  
  
  private void ooHashJoinRC(MultiBiMap<Long, Long> _c1,MultiBidirectionalIndex _r2,MultiBidirectionalIndex _r3,MultiBidirectionalIndex  _r4){
      
      
   
      if(_c1.valueSize()<_r2.getR().valueSize()){
          
      
      for(long obj:_c1.values()){
          if(_r2.getR().containsValue(obj)){
              
              checker=true;
              ///first get the index from the _r2
             long index= _r2.getrIndex().getKey(new SP(_r2.getR().getKey(obj),obj));
             
             _r3.getR().put(_c1.getKey(obj), obj);
             _r3.getrIndex().put(index, new SP(_c1.getKey(obj), obj));
             
             
             _r4.getR().put(_r2.getR().getKey(obj),obj);
             _r4.getrIndex().put(index, new SP(_r2.getR().getKey(obj),obj));
             
             
              
              
          }
          
          
      }
      
      
      
      }else{
          
          
            for(long obj:_r2.getR().values()){
          if(_c1.containsValue(obj)){
              
              checker=true;
              ///first get the index from the _r2
             long index= _r2.getrIndex().getKey(new SP(_r2.getR().getKey(obj),obj));
             
             _r3.getR().put(_c1.getKey(obj), obj);
             _r3.getrIndex().put(index, new SP(_c1.getKey(obj), obj));
             
             
             _r4.getR().put(_r2.getR().getKey(obj),obj);
             _r4.getrIndex().put(index, new SP(_r2.getR().getKey(obj),obj));
             
             
              
              
          }
          
          
      }
      
          
      }
      
      
      
  }
  
  
  private void ooHashJoinCC(MultiBiMap<Long, Long> _c1,MultiBiMap<Long, Long> _c2,MultiBidirectionalIndex _r1,MultiBidirectionalIndex  _r2){
      
      
      for(Long obj:_c1.values()){
          if(_c2.containsValue(obj)){
              
                  checker=true;
              _r1.getR().put(_c1.getKey(obj), obj);
              long index =++indexCount;
              
              
              
              
              _r1.getrIndex().put(index, new SP(_c1.getKey(obj), obj));
             
              
              _r2.getR().put(_c2.getKey(obj), obj);
              
              _r2.getrIndex().put(index, new SP(_c2.getKey(obj),obj));
              
          }
          
      }
  }
  
  
       
}
