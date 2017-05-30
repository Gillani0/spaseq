/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomst.graph.processing;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.OP;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.graph.automata.AutomataState;
import edu.telecomstet.cep.knowledgebase.KBbindings;
import edu.telecomstet.cep.rulesmodel.Dependability;
import edu.telecomstet.cep.utils.LiteralComparisonImpl;

import java.util.HashMap;

/**
 *
 * @author sydgillani
 */
public class GraphJoinAutomtaOptimised  {
//    private  LiteralComparisonImpl compLiteral=new LiteralComparisonImpl(); ///why every fucking time??
//    //private  HashMap<Integer, MultiBiMap<Long, Long> > hm =new  HashMap();
//    private int newID=0;
//    private long queryTimer=0;
//    private int count=0;
//    private int stop=0;
//    private  boolean checker=false;
//    private int testCounter=0;
//    private int proceed=0;
//    /**
//     *
//     * @param automata
//     * @param dic
//     */
//    
//    
//    
//    
//    //Later Implents the API for this class
//    
//    /**
//     *
//     * @param automata
//     * @param dic
//     * @param c
//     */
//    
//    public boolean run(Automata automata, DictionaryOpImpl dic,HashMap<RunStateMap, MultiBiMap<SP, OP>> c,int r,int st){
//        // if(proceed==0){
//        
//        
//        
//        if( automata.getStates().stream().filter(x->x.getRule().getC().size()>0).count()==automata.getStates().size()){
//            //    proceed=1;
//             automata.getfR().clear();
//             
//             
//            return  tpJoinStart(automata,dic,c,r,st);
//        }
//        return false;
//    }
//    
//    public boolean tpJoinStart(Automata automata, DictionaryOpImpl dic,HashMap<RunStateMap, MultiBiMap<SP, OP>> c,int r,int st){
//        int id=0;
//        
//        
//    //   if(st ==3){
//  //   System.out.println();
//      //  }
//        
//        for(AutomataState s: automata.getStates()){
//            
//          /*  if(!s.getEdge().getR().isEmpty()){
//                 s.getEdge().getR().clear();
//               
//            }
//            if(! s.getEdge().getRCopied().isEmpty()){
//                 s.getEdge().getRCopied().clear();
//            }*/
//      
//             
//          tripleJoin(s, automata,dic,id,c,r,st);
//            
//            if(stop==1){
//                
//                
//                
//                
//                break;
//            }
//            
//            id++;
//        }
//        //// If stop ==1 , then return false and don't store it in the cache, otherwise store it and replicate
//        ///to all the states
//        
//        /*  if( automata.getStates().stream().filter(x->x.getJoined()==1).count()==automata.getStates().size()){
//        
//        //  System.out.println("In Here"+ testCounter++);
//        
//        
//        ///remoce from c over here
//        
//        for(AutomataState s: automata.getStates()){
//        this.removeFromC( s.getRule().getC(),automata.getStates().get( automata.getStates().size()-1).getEdge().getR());
//        s.setChange(0);
//        }
//        
//        
//        automata.getfR().putAll(automata.getStates().get(automata.getStates().size()-1).getEdge().getR());
//        automata.getStates().get(automata.getStates().size()-1).getEdge().getR().clear();
//        }*/
//        
//        if(stop==1){
//            stop=0;
//            return false;
//        }
//        
//        
//        automata.setfR( automata.getStates().get(automata.getStates().size()-1).getEdge().getR());
//        
//        
//      /*  automata.getfR().entries().forEach((x)->{
//            
//            
//            
//            
//            
//            System.out.println(dic.getResourceAdaptive(x.getKey().getSub()) + "    " + dic.getResourceAdaptive(x.getKey().getPred()) + "   "+ dic.getResourceAdaptive(x.getValue().getObj())+ dic.getBnodeAdaptive(x.getValue().getObj()));
//            
//            
//            
//            
//        });*/
//        
//        ////over here use the kb based joins
//      //   private MultiBiMap<SP, OP> _R;
//        
//      ///for now ////  
//       
//       
//        MultiBiMap<SP, OP> result=new MultiBiMap();
//        result.putAll(automata.getfR());
//        c.put(new RunStateMap(r,st),  result);  ///do it over here
//        
//       // 
//        
//       //////// 
//        ///external KB computation
//        if(!automata.getKbBinds().isEmpty()){
//             kbJoinManipulation(automata);
//             
//               automata.getKbBinds().get(automata.getKbBinds().size()-1).getR().entries().forEach((x)->{
//            
//            
//            
//            
//            
//            System.out.println(dic.getResourcePersistant(x.getKey().getSub()) + "    " + dic.getResourcePersistant(x.getKey().getPred()) + "   "+ dic.getResourcePersistant(x.getValue().getObj())+ dic.getBnodePersistant(x.getValue().getObj()));
//            
//            
//            
//            
//        });
//        }
//        
//        
//       
//        
//        
//        
//        //c.put(aut, null)
//        
//        
//        return true;
//    }
//    
//    
//    
//    
//    
//    
//    private void kbJoinManipulation(Automata a){
//        for(KBbindings kb:a.getKbBinds()){
//            
//            if(kb.getStateFull_flag()==1){
//                
//                ///get the rule it joined with and its predicate,
//                ///depending on the type of the join send it for s-s or o-s join.
//                ///first s-s join
//                if(kb.getStateDepends().getD_On()==1 && kb.getStateDepends().getD_part()==1){ //s-s stateful join
//                    ///send the C of the KB, fR for the join, R to put the results
//                    this.ssKBStatefulJoin(kb.getC(), a.getfR(), kb.getR(), kb.getPred().getMappedValue(), a.getStates().get(kb.getStateDepends().getD_id()).getRule().getPredicate().getMappedValue());
//                    
//                }else { //o-s join
//                    
//                    this.osStatefulJoin(kb.getC(), a.getfR(), kb.getR(), kb.getPred().getMappedValue(), a.getStates().get(kb.getStateDepends().getD_id()).getRule().getPredicate().getMappedValue());
//                }
//            }else{
//                if(kb.getDepends().getDependability_On()==1 && kb.getDepends().getDependability_part()==1){ //s-s stateless join
//                    this.ssKBStatelessJoin(kb.getC(), a.getKbBinds().get(kb.getDepends().getDependabilty_id()-1).getR(), kb.getR(), kb.getPred().getMappedValue(), a.getKbBinds().get(kb.getDepends().getDependabilty_id()-1).getPred().getMappedValue());
//                }else{//o-s joins
//                       this.osKBStatelessJoin(kb.getC(), a.getKbBinds().get(kb.getDepends().getDependabilty_id()-1).getR(), kb.getR(), kb.getPred().getMappedValue(), a.getKbBinds().get(kb.getDepends().getDependabilty_id()-1).getPred().getMappedValue());
//                }
//                
//                
//            }
//            
//            
//            
//        }
//        
//        
//        
//        
//    }
//    
//    public void tripleJoin(AutomataState currState, Automata automata,DictionaryOpImpl dic, int id, HashMap<RunStateMap, MultiBiMap<SP, OP>> c,int r,int st){
//        /**
//         * If no KB join and no Complex Filter
//         */
//        if( currState.getRule().getFilterType() !=2  ){ ///join the subject or object get the smalles list and join it with the other list
//            if(currState.getRule().getQueryType()==1){
//                event_Chain_Join(currState,automata);
//            }else{
//                event_star_Join(currState,automata);
//            }
//            
//            
//            
//        }else if( currState.getRule().getFilterType() == 2){ ///if there is a complex filter, then first join with the previous state and then use that to join with the complex filter one
//            
//            
//            //first check the simple join
//          
//            this.complexFilterJoin(currState, automata, dic,c,r,st);
//            if(stop!=1)
//            this.joinAfterFilter(currState, automata);
//            
//            ///statefuljoin
//            //then check the complex join
//            
//        }
//        //first check if there are other joins or not then kb join
//       
//        
//        
//        
//        ////Statefull Join and then the KB join
//        
//        if(stop!=1 && !currState.getRule().getS_depends().isEmpty()){
//           
//            ///new function to check the query type and then initiate the star or chain join
//            stateFullJoins(currState,c.get(new RunStateMap(r, currState.getRule().getS_depends().get(0).getIdNFA())));
//            
//        }
//        
//        
//    }
//    
//    
//    private void joinAfterFilter(AutomataState currState, Automata a){
//        
//       if(currState.getRule().getQueryType()==1){///chain
//               this.joinAfterFilterChain(currState, a);
//            }else{ ///start
//                this.joinAfterFilterStar(currState, a);
//            }
//        
//        
//        
//        
//    }
//    
//    private void joinAfterFilterStar(AutomataState currState, Automata a){
//         AutomataState   joinState=null;
//         if(currState.getStateId()!=0){
//       joinState= a.getStates().get(currState.getStateId()-1);
//        }
//        if(currState.getStateId()==0 ){
//            
//            currState.getEdge().getR().putAll(currState.getEdge().getRCopied());
//           // currState.getEdge().setR(currState.getEdge().getRCopied());
//            //  a.setfR(joinState.getEdge().getR());
//        }else if(currState.getRule().getDepends().isEmpty() ){
//            
//            if(currState.getRule().getS_depends().isEmpty()){
//                 a.setfR(joinState.getEdge().getR());
//                  a.setfR(currState.getEdge().getRCopied());
//            }else{
//                 a.setfR(joinState.getEdge().getR());
//                  currState.getEdge().setR(currState.getEdge().getRCopied());
//            }
//            
//        } else if(currState.getRule().getDepends().get(0).getDependabilty_id()>currState.getStateId()){
//              currState.getEdge().setR(currState.getEdge().getRCopied());
//            a.setfR(joinState.getEdge().getR());
//        }else{
//             if(!joinState.getEdge().getR().isEmpty()  ){
//                this.ssJoin(joinState.getEdge().getR(), currState.getEdge().getRCopied(), currState.getEdge().getR(),joinState.getRule().getPredicate().getMappedValue(),currState.getRule().getPredicate().getMappedValue());
//                
//                if(checker)
//                {
//                    
//                  
//                    checker=false;
//                    
//                }else  {
//                    stop=1;
//                }
//            }//// chec
//        }
//    }
//    
//    
//    
//    private void joinAfterFilterChain(AutomataState currState, Automata a){
//        
//        if(currState.getStateId()== 0 || currState.getRule().getDepends().isEmpty()){
//          //  currState.getEdge().setR(currState.getEdge().getRCopied());
//            
//             currState.getEdge().getR().putAll(currState.getEdge().getRCopied());
//        }else if(  currState.getRule().getDepends().get(0).getDependabilty_id()>currState.getStateId()){
//            currState.getEdge().setR(currState.getEdge().getRCopied());
//            a.setfR(a.getStates().get(currState.getStateId()-1).getEdge().getR());
//            
//            newID=currState.getStateId();
//        }else{
//            Dependability d=currState.getRule().getDepends().get(0);
//            AutomataState s =  a.getStates().stream().filter(x->x.getStateId()==d.getDependabilty_id()).findFirst().get();
//            ////////
//            
//            if(!s.getEdge().getR().isEmpty()){
//            ///simple take the c of the current state and join it with join state
//          //  o_s_Hash_Join(currState.getRule().getC(),joinState.getEdge().getR(),currState.getEdge().getR(),joinState.getRule().getPredicate().getMappedValue(),id, limit,a);
//         
//            
//            
//           this.o_s_Hash_JoinOptimised(currState.getEdge().getRCopied(), s.getEdge().getR(), currState.getEdge().getR(), currState.getRule().getPredicate().getMappedValue(), s.getRule().getPredicate().getMappedValue());
//            
//            if(checker){
//                ////put it in the r of the join state as well
//                checker=false;
//                
//                /// joinState.getEdge().setR(currState.getEdge().getR());
//            }else{
//                stop=1;
//                //joinFinalResults(currState.getRule().getC(),a.getfR(),currState.getEdge().getRCopied(),currState.getRule().getPredicate().getMappedValue(),pred_j);
//            }
//        }
//            
//            
//            //////
//        }
//    }
//    
//    private void stateFullJoins(AutomataState currState, MultiBiMap<SP, OP> c){
//        
//        ///First check the type of the Query
//       //   for(int i=0;i<currState.getRule().getS_depends().size();i++){
//        if(currState.getRule().getS_depends().get(0).getD_On()==1 &&   currState.getRule().getS_depends().get(0).getD_part()==1) ///if its a star query
//        { ///Star Query join
//            
//            
//            
//            
//            
//            
//// this.stateFulStarJoin(currState.getEdge().getR(), c.get(currState.getRule().getS_depends().get(0).getIdNFA()) ,currState.getEdge().getRCopied(), currState., queryTimer);
//            currState.getEdge().getRCopied().clear();
//            ssStatefulJoin(c, currState.getEdge().getR(), currState.getEdge().getRCopied(),currState.getRule().getS_depends().get(0).getdPredicate() ,currState.getRule().getPredicate().getMappedValue());
//            
//        }else
//        {
//           currState.getEdge().getRCopied().clear();
//            osStatefulJoin(c, currState.getEdge().getR(), currState.getEdge().getRCopied(),currState.getRule().getS_depends().get(0).getdPredicate() ,currState.getRule().getPredicate().getMappedValue());
//            ///Chain Query Join
//        }
//        
//        
//        
//      
//            
//       // }
//        
//        
//        
//    }
//    
//    
//    public void ssStatefulJoin( MultiBiMap<SP, OP> c ,MultiBiMap<SP, OP> r, MultiBiMap<SP, OP> rIn, Long pred1, Long pred2){
//        
//        
//        
//        
//        
//        //if(c.keySize()<=r.keySize()){
//        
//        
//        for(SP sp: c.keySet()){
//            if(sp.getPred()==pred1){
//                
//                
//                
//                if(r.containsKey(new SP(sp.getSub(),pred2))){
//                    checker=true;
//                    
//                    //  rIn.putAll(sp, c.get(sp));
//                    rIn.putAll(new SP(sp.getSub(),pred2), r.get(new SP (sp.getSub(),pred2))); //set 2 r predicate
//                    
//                    
//                    
//                }
//            }
//        }
//        
//        if(!checker){
//            stop=1;
//        }else{
//            checker=false;
//        }
//    }
//    
//    
//    ////change the name
//    private void event_star_Join(AutomataState currState, Automata a){
//        
//        
//        ///If the dependabiltiy of the state is greater than its current state, then skip it.
//        ///
//        ///If its not equal to zero as well
//        AutomataState joinState=null;
//        if(currState.getStateId()!=0){
//           joinState= a.getStates().get(currState.getStateId()-1);
//        }
//        
//        
//     if(currState.getStateId()==0 ){
//            currState.getEdge().setR(currState.getRule().getC());
//            //  a.setfR(joinState.getEdge().getR());
//        }else if(currState.getRule().getDepends().isEmpty() ){
//            
//            if(currState.getRule().getS_depends().isEmpty()){
//                 a.setfR(joinState.getEdge().getR());
//                  a.setfR(currState.getRule().getC());
//            }else{
//                 a.setfR(joinState.getEdge().getR());
//                  currState.getEdge().setR(currState.getRule().getC());
//            }
//            
//        } else if(currState.getRule().getDepends().get(0).getDependabilty_id()>currState.getStateId()){
//              currState.getEdge().setR(currState.getRule().getC());
//            a.setfR(joinState.getEdge().getR());
//        }else{
//             if(!joinState.getEdge().getR().isEmpty()  ){
//                this.ssJoin(joinState.getEdge().getR(), currState.getRule().getC(), currState.getEdge().getR(),joinState.getRule().getPredicate().getMappedValue(),currState.getRule().getPredicate().getMappedValue());
//                
//                if(checker)
//                {
//                    currState.setJoined(1);
//                    joinState.setJoined(1);
//                    if (currState.getStateId()==0){
//                        joinState.getEdge().getR().putAll(currState.getEdge().getR());
//                        currState.getEdge().getR().clear();
//                    }else{
//                        joinState.getEdge().getR().clear();
//                    }
//                    
//                    currState.setChange(0);
//                    //  automata.getStates().get(id).getRule().getTableSOMapped().removeAll(  automata.getStates().get(id).getEdge().getTableSOMapped()); //change it
//                    //   removeFromC(currState.getRule().getC(),currState.getEdge().getR());
//                    checker=false;
//                    
//                }else  {
//                    stop=1;
//                }
//            }//// chec
//        }
//        
//   
//    }
//    
//    
//   
//    
//    
//    
//    
//    //  ssJoin(automata.getStates().get(id+1).getRule().getC(), automata.getStates().get(id).getRule().getC(), automata.getStates().get(id).getEdge().getR(),automata.getStates().get(id+1).getRule().getPredicate().getMappedValue(),automata.getStates().get(id).getRule().getPredicate().getMappedValue());
//    //Three main things as an input, the C set, R/C set, Output R set, predicates of both triple patterns
//    
//    
//    
//    
//    
//    
//    
//    public void ssJoin( MultiBiMap<SP, OP> c ,MultiBiMap<SP, OP> r, MultiBiMap<SP, OP> rIn, Long pred1, Long pred2){
//        
//        
//        
//        
//        
//        //if(c.keySize()<=r.keySize()){
//        
//        
//        for(SP sp: c.keySet()){
//            if(sp.getPred()==pred1){
//                
//                
//                
//                if(r.containsKey(new SP(sp.getSub(),pred2))){
//                    checker=true;
//                    
//                    rIn.putAll(sp, c.get(sp));
//                    rIn.putAll(new SP(sp.getSub(),pred2), r.get(new SP (sp.getSub(),pred2))); //set 2 r predicate
//                    
//                    
//                    
//                }
//            }else{
//                rIn.putAll(sp, c.get(sp));
//            }
//        }
//     
//        
//        
//        
//        
//        
//        //}
//    }
//    
//    
//    private void ssKBStatefulJoin(MultiBiMap<SP, OP> cKB,MultiBiMap<SP, OP> fR , MultiBiMap<SP, OP> rKB,  Long predKB,Long predfR){
//        
//        
//        for(SP s:fR.keySet()){
//            
//            if(s.getPred()==predfR){
//                SP newSP = new SP(s.getSub(),predKB);
//                 if(cKB.containsKey(newSP)){
//                     rKB.put(newSP, cKB.getValue(newSP));
//                 }
//                
//            }
//            
//        }
//    }
//    
//    
//    private void ssKBStatelessJoin(MultiBiMap<SP, OP> cKB, MultiBiMap<SP, OP> fR , MultiBiMap<SP, OP> rKB, Long predKB,Long predfR){
//        
//        
//        for(SP s:fR.keySet()){
//            
//            if(s.getPred()==predfR){
//                SP newSP = new SP(s.getSub(),predKB);
//                 if(cKB.containsKey(newSP)){
//                     rKB.put(newSP, cKB.getValue(newSP));
//                      rKB.put(s,fR.getValue(s));
//                 }
//                
//            }else{
//                rKB.put(s,fR.getValue(s));
//            }
//            
//        }
//    }
//    
//     private void osKBStatelessJoin(MultiBiMap<SP, OP> set_c, MultiBiMap<SP, OP> set_r,MultiBiMap<SP, OP> set_fR,long pred_c,long pred_r)
//    {
//        
//         for(OP op:set_r.values()){
//             
//             if(op.getPred()==pred_r){
//                 
//                 SP sp=new SP(op.getObj(),pred_c);
//             if(set_c.containsKey(sp)){
//                 set_fR.put(sp,set_c.getValue(sp));
//                 set_fR.put(set_r.getKey(op), op);
//             }
//             }else{
//                  set_fR.put(set_r.getKey(op), op);
//             }
//         }
//        
//    }
//     
//   private void osStatefulJoin(MultiBiMap<SP, OP> set_c, MultiBiMap<SP, OP> set_r,MultiBiMap<SP, OP> set_fR,long pred_c,long pred_r){
//       
//       ///c is coming from the top
//       ///while r is coming from the current state
//       //pred_c current state dependend predicate, that it the current state has to join wiht this one
//       ///pred_r //current states predicate
//       
//       for(OP op:set_c.values()){
//           if(op.getPred()==pred_c){
//               SP sp=new SP(op.getObj(),pred_r);
//               if(set_r.containsKey(sp)){
//                   set_fR.put(sp, set_r.getValue(sp));
//                   checker =true;
//               }
//           }
//       }
//        if(!checker){
//            stop=1;
//        }else{
//            checker=false;
//        }
//       
//      /* for(OP op:set_r.values()){
//             
//             if(op.getPred()==pred_r){
//                 
//                 SP sp=new SP(op.getObj(),pred_c);
//             if(set_c.containsKey(sp)){
//                 set_fR.put(sp,set_c.getValue(sp));
//                 
//             }
//             }
//         }*/
//   }  
//    
//    
//    
//    
//    
//    
//    private void complexFilterJoin(AutomataState currState,Automata automata,DictionaryOpImpl dic,HashMap<RunStateMap, MultiBiMap<SP, OP>> c,int r,int st){
//        //Get the state with the complex join
//     
//        //Check if the filter contains stateful join
//        //Get the ID of the stateful
//        ///New functions for the equi and non-equi joins
//        
//        
//        ///first check if the currstate has stateful filter or not
//        
//      
//        
//        if(currState.getRule().getFilter().getStateFulness()==0){
//            
//               AutomataState s =automata.getStates().stream().filter(x->x.getStateId()==currState.getRule().getFilterRuleID()).findFirst().orElse(null);
//            if(!s.getEdge().getR().isEmpty()){
//                switch (currState.getRule().getFilterType1Operator()) {
//                    case "=":{
//                        ooEqualJoin(s.getEdge().getR(), currState.getRule().getC(), currState.getEdge().getRCopied(),currState.getRule().getPredicate().getMappedValue());
//                        
//                    } break;
//                    case "!=":{
//                        ooNonEqualJoin(s.getEdge().getR(), currState.getRule().getC(), currState.getEdge().getRCopied(),s.getRule().getPredicate().getMappedValue());
//                        
//                        
//                    }break;
//                        
//                        
//                    case ">":
//                    case "<":
//                    case ">=":
//                    case "<=":
//                    {
//                        ooComplexJoin(s.getEdge().getR(), currState.getRule().getC(), currState.getEdge().getRCopied(),dic,currState.getRule().getFilterType1Operator(),currState.getStateDataType());
//                    }break;
//                        
//                        
//                }
//                if(!checker){
//                    stop=1;
//                }else{
//                    checker=false;
//                }
//                
//                
//                
//                
//                
//                
//                
//                
//                
//                
//            } else if(!s.getRule().getC().isEmpty()){
//                switch (currState.getRule().getFilterType1Operator()) {
//                    case "=":{
//                        ooEqualJoin(s.getRule().getC(), currState.getRule().getC(), currState.getEdge().getRCopied(),currState.getRule().getPredicate().getMappedValue());
//                        
//                    } break;
//                    case "!=":{
//                        ooNonEqualJoin(s.getRule().getC(), currState.getRule().getC(), currState.getEdge().getRCopied(),s.getRule().getPredicate().getMappedValue());
//                    }break;
//                        
//                        
//                    case ">":
//                    case "<":
//                    case ">=":
//                    case "<=":
//                    {
//                        ooComplexJoin(s.getRule().getC(), currState.getRule().getC(), currState.getEdge().getRCopied(),dic,currState.getRule().getFilterType1Operator(),currState.getStateDataType());
//                    }break;
//                        
//                        
//                        
//                        
//                }
//                
//                
//                if(!checker){
//                    stop=1;
//                }else{
//                    checker=false;
//                }
//            }
//            
//            
//            
//            
//            
//            
//        }else {  ///For stateful Filters
//            
//            
//            ///Get the filter automata ID and send it for comparison
//            
//            
//            switch (currState.getRule().getFilterType1Operator()) {
//                case "=":{
//                    /// ooEqualJoin(s.getEdge().getR(), currState.getRule().getC(), currState.getEdge().getRCopied(),currState.getRule().getPredicate().getMappedValue());
//                  
//                    this.ooStatefulEqualJoin( c.get( new RunStateMap(r, currState.getRule().getFilter().getD().getIdNFA())), currState.getRule().getC(), currState.getEdge().getRCopied(), currState.getRule().getPredicate().getMappedValue(), currState.getRule().getFilter().getD().getdPredicate());
//                } break;
//                    
//                case "!=":{
//                    this.ooStatefulNonEqualJoin( c.get( new RunStateMap(r, currState.getRule().getFilter().getD().getIdNFA())), currState.getRule().getC(), currState.getEdge().getRCopied(), currState.getRule().getPredicate().getMappedValue(), currState.getRule().getFilter().getD().getdPredicate());
//                }break;
//                case ">":
//                case "<":
//                case ">=":
//                case "<=":{
//                    
//                    this.ooComplexStatefulJoin(c.get( new RunStateMap(r,currState.getRule().getFilter().getD().getIdNFA())),currState.getRule().getC(), currState.getEdge().getRCopied(), dic,currState.getRule().getFilterType1Operator(),currState.getStateDataType(),currState.getRule().getFilter().getD().getdPredicate());
//                    
//                }break;
//                    
//                    
//                    
//                    
//            }
//            
//            
//            if(!checker){
//                stop=1;
//            }else{
//                checker=false;
//            }
//            
//            
//        }
//        
//        
//        
//        
//        
//    }
//    
//    
//    
//    
//    
//    
//   
//  
//    
//    
//    ////Complex Join
//    
//    //Equal join is the same except it will work on the values
//    ///send the copied R, and the C or R of join state and the final R of current state
//    private void ooEqualJoin(MultiBiMap<SP, OP> set_1,MultiBiMap<SP, OP> set_2, MultiBiMap<SP, OP> result_Set,long pred2){
//        
//        for(OP op: set_1.values()){
//            if(set_2.containsValue(new OP(op.getObj(),pred2))){
//                checker=true;
//                result_Set.put(set_2.getKey(new OP(op.getObj(),pred2)) ,new OP(op.getObj(),pred2));
//            }
//            
//            
//        }
//        
//    }
//    
//    
//    private void ooStatefulEqualJoin(MultiBiMap<SP, OP> set_1,MultiBiMap<SP, OP> set_2, MultiBiMap<SP, OP> result_Set,long pred2,long pred1){
//        
//        for(OP op: set_1.values()){
//            
//            if(op.getPred().equals(pred1)){
//                OP nop= new OP(op.getObj(),pred2);
//                if(set_2.containsValue(nop)){
//                    checker=true;
//                    result_Set.put(set_2.getKey(nop) ,nop);
//                }
//                
//            }
//        }
//        
//    }
//    
//    
//    private void ooStatefulNonEqualJoin(MultiBiMap<SP, OP> set_1,MultiBiMap<SP, OP> set_2, MultiBiMap<SP, OP> result_Set,long pred2,long pred1){
//        
//        for(OP op: set_1.values()){
//            
//            if(op.getPred().equals(pred1)){
//                 OP nop= new OP(op.getObj(),pred2);
//                if(!set_2.containsValue(nop)){
//                    checker=true;
//                    result_Set.put(set_2.getKey(nop) ,nop);
//                }
//                
//            }
//        }
//        
//    }
//    
//    
//    
//    private void ooNonEqualJoin(MultiBiMap<SP, OP> set_1,MultiBiMap<SP, OP> set_2, MultiBiMap<SP, OP> result_Set,long pred2){
//        
//        
//        
//        
//        for(OP op: set_2.values()){
//            if(!set_1.containsValue(new OP(op.getObj(),pred2))){
//                checker=true;
//                
//                result_Set.put(set_2.getKey(op) ,op);
//            }
//            
//            
//        }
//        
//        
//        
//        
//        
//    }
//    
//    
//    
//    
//    private  void ooComplexStatefulJoin(MultiBiMap<SP, OP> set_1, MultiBiMap<SP, OP> set_2,MultiBiMap<SP, OP> final_set,DictionaryOpImpl dic, String Oper, int dataType,long pred1){
//        
//        
//        for(OP op:set_1.values()){ ///Stateful one
//            if(op.getPred()==pred1){
//                
//                for(OP op2:set_2.values()) ///Rule One
//                {
//                    if(this.compLiteral.evaluateEventType(dic.getLiteralAdaptive(op.getObj()),dic.getLiteralAdaptive(op2.getObj()),Oper, dataType, 1)){
//                        checker=true;
//                        
//                        final_set.put(set_2.getKey(op2), op2);
//                    }
//                    
//                    
//                }
//            }
//            
//        }
//        
//        
//    }
//    
//    
//    
//    private  void ooComplexJoin(MultiBiMap<SP, OP> set_1, MultiBiMap<SP, OP> set_2,MultiBiMap<SP, OP> final_set,DictionaryOpImpl dic, String Oper, int dataType){
//        
//        
//        for(OP op:set_1.values()){
//            
//            
//            for(OP op2:set_2.values())
//            {
//                if(this.compLiteral.evaluateEventType(dic.getLiteralIncremental(op.getObj()),dic.getLiteralIncremental(op2.getObj()),Oper, dataType, 1)){
//                    checker=true;
//                    
//                    final_set.put(set_2.getKey(op2), op2);
//                }
//                
//                
//            }
//            
//        }
//        
//        
//    }
//    
//    
//    
//    
//    private void event_Chain_Join(AutomataState currState,Automata automata){
//        
//        
//        if(currState.getStateId()== 0 || currState.getRule().getDepends().isEmpty()){
//            currState.getEdge().setR(currState.getRule().getC());
//        }else if(  currState.getRule().getDepends().get(0).getDependabilty_id()>currState.getStateId()){
//            currState.getEdge().setR(currState.getRule().getC());
//            automata.setfR(automata.getStates().get(currState.getStateId()-1).getEdge().getR());
//            
//            newID=currState.getStateId();
//        }else{
//            Dependability d=currState.getRule().getDepends().get(0);
//            AutomataState s =  automata.getStates().stream().filter(x->x.getStateId()==d.getDependabilty_id()).findFirst().get();
//            event_o_s_Join(currState,s,currState.getStateId(),automata,s.getRule().getPredicate().getMappedValue(),newID);
//        }
//        
//        
//        
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    private void event_o_s_Join(AutomataState currState, AutomataState joinState, int id, Automata a,long pred_j,int limit){
//        if(!joinState.getEdge().getR().isEmpty()){
//            ///simple take the c of the current state and join it with join state
//          //  o_s_Hash_Join(currState.getRule().getC(),joinState.getEdge().getR(),currState.getEdge().getR(),joinState.getRule().getPredicate().getMappedValue(),id, limit,a);
//         
//            
//            
//           this.o_s_Hash_JoinOptimised(currState.getRule().getC(), joinState.getEdge().getR(), currState.getEdge().getR(), currState.getRule().getPredicate().getMappedValue(), joinState.getRule().getPredicate().getMappedValue());
//            
//            if(checker){
//                ////put it in the r of the join state as well
//                checker=false;
//               // currState.setJoined(1);///no need of it
//               // joinState.setJoined(1);///no need of it...
//                /// joinState.getEdge().setR(currState.getEdge().getR());
//            }else{
//                stop=1;
//                //joinFinalResults(currState.getRule().getC(),a.getfR(),currState.getEdge().getRCopied(),currState.getRule().getPredicate().getMappedValue(),pred_j);
//            }
//        }
//        
//    }
//  
//    private void s_o_HashJoin(MultiBiMap<SP, OP> set_c, MultiBiMap<SP, OP> set_j,MultiBiMap<SP, OP> set_r,long pred_c,long pred_j){
//        
//        
//        
//        for(OP op:set_c.values()){
//            
//            if(set_j.containsKey(new SP(op.getObj(),pred_j))){
//                checker=true;
//                set_r.put(set_c.getKey(op), op);
//                set_r.put(new SP(op.getObj(),pred_j), set_j.getValue(new SP(op.getObj(),pred_j)));
//            }
//            
//        }
//    }
//    
//    
//    private void o_s_Hash_JoinOptimised(MultiBiMap<SP, OP> set_c, MultiBiMap<SP, OP> set_r,MultiBiMap<SP, OP> set_fR,long pred_c,long pred_r)
//    {
//        
//         for(OP op:set_r.values()){
//             
//             if(op.getPred()==pred_r){
//                 
//                 SP sp=new SP(op.getObj(),pred_c);
//             if(set_c.containsKey(sp)){
//                 checker=true;
//                 set_fR.put(sp,set_c.getValue(sp));
//                 set_fR.put(set_r.getKey(op), op);
//             }
//             }else{
//                  set_fR.put(set_r.getKey(op), op);
//             }
//         }
//        
//    } 
//    
//    
//    
//    
//    
//    private void o_s_Hash_Join(MultiBiMap<SP, OP> set_c, MultiBiMap<SP, OP> set_j,MultiBiMap<SP, OP> set_r,long pred_j, int id, int limit,Automata automata){
//        
//        
//        
//        ///o_s hash join check with the property, as its not right 
//        
//        // if(set_c.keySize() < set_j.valueSize()){
//        
//        for(SP sp:set_c.keySet()){
//            if(set_j.containsValue(new OP(sp.getSub(),pred_j))){
//                checker=true;
//                set_r.put(sp, set_c.getValue(sp));
//                set_r.put(set_j.getKey(new OP(sp.getSub(),pred_j)), new OP(sp.getSub(),pred_j));
//                
//                long s=set_j.getKey(new OP(sp.getSub(),pred_j)).getSub();
//                //long o=
//                
//                
//                // long o= set_c.getValue(sp).getObj();
//                
//                //  System.out.println(set_j.getKey(new OP(sp.getSub(),pred_j)).getSub());
//                
//                //  set_j.getKey(new OP(set_j.getKey(new OP(sp.getSub(),pred_j)).getSub(),pred_pj);
//                
//                //set_j.getKey(null)
//                
//                
//                for(int i=id-2;i>=limit;i--){
//                    
//                    
//                    if(automata.getStates().get(i).getRule().getQueryType()==1 ){
//                        
//                        
//                        
//                        SP st=set_j.getKey(new OP(s,automata.getStates().get(i).getRule().getPredicate().getMappedValue()));
//                        OP si=new OP(s,automata.getStates().get(i).getRule().getPredicate().getMappedValue());
//                        set_r.put(st, si);
//                        //    s =  set_j.getValue(new SP(s,automata.getStates().get(i).getRule().getPredicate().getMappedValue()) ).getObj();
//                        s =  set_j.getKey(new OP(s,automata.getStates().get(i).getRule().getPredicate().getMappedValue()) ).getSub();
//                        //  System.out.println(s);
//                        
//                    } else if(automata.getStates().get(i).getRule().getQueryType()==1 &&  i%2!=0){
//                        
//                        
//                        
//                        
//                        
//                        //     System.out.println(s);
//                        
//                        
//                        
//                    }
//                    
//                    
//                }
//                
//                
//                
//                
//                
//                
//            }
//            
//        }
//        
//        
//        
//        
//        
//        
//        
//        /* }else{
//        
//        for(OP op:set_j.values()){
//        
//        if(set_c.containsKey(new SP(op.getObj(),pred_c))){
//        checker=true;
//        set_r.put(set_j.getKey(op), op);
//        set_r.put(new SP(op.getObj(),pred_c), set_c.getValue(new SP(op.getObj(),pred_c)));
//        }
//        
//        }
//        
//        
//        
//        }*/
//        
//        
//        
//        
//    }
//    
//    
//   
    
    
}
