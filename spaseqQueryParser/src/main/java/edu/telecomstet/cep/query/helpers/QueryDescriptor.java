/*
 * @(#)QueryDescriptor.java   14/10/14
 * 
 * Copyright (c) 2014 Telecon Saint-Etienn & EMSE
 *
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF
 * THIS CREATIVE COMMONS PUBLIC LICENCE ("CCPL" OR "LICENCE"). 
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENCE OR COPYRIGHT LAW IS PROHIBITED.
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND AGREE TO BE BOUND BY THE TERMS OF THIS LICENCE.
 * THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 *
 *
 *
 */



/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package edu.telecomstet.cep.query.helpers;

//~--- non-JDK imports --------------------------------------------------------

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.graph.automata.AutomataState;
import edu.telecomstet.cep.knowledgebase.KBbindings;
import edu.telecomstet.cep.knowledgebase.KnowledgeBaseBindingImpl;
import edu.telecomstet.cep.model.Filter;
import edu.telecomstet.cep.model.ObjectS;
import edu.telecomstet.cep.model.Subject;
import edu.telecomstet.cep.rulesmodel.Dependability;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.PatternData;
import edu.telecomstet.cep.rulesmodel.Rule;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;



/**
 *
 * @author sydgillani
 */
public class QueryDescriptor
 {
 //   StateMachines               nfa;
   private ArrayList<Filter>            filterList;
   // ArrayList<StateMachineData> _stateMachineData;
    private ArrayList<KBbindings>       _kbBindingList;
  
  //  private Model                       _inputModel;
    private DictionaryOpImpl              dicImpl;
    private List<Rule>                        constRules;
   

	private List<Rule>                  _rulesList;
    private List<NFAData>              _nfaDataList;
  //  private Automata                    automta;
    private int                        totalCost=0;
    private KnowledgeBaseBindingImpl    _kbCompleteBindings;
   
    List<PatternData> pattData ;
   ;
    
//    private ArrayList<AutomataState> star;
//     private ArrayList<AutomataState> chain;
//       private ArrayList<AutomataState> simple;
    
   
 //   private KBBindingTables _kbTables;
    //////
    public QueryDescriptor( 
                           List<NFAData> nfaDataList, DictionaryOpImpl dictImpl,List<PatternData> pattdat,List<PatternData> upattData)
            throws ParseException, DatatypeConfigurationException {
    	
        this.dicImpl           = dictImpl;
        
      //  this.pattData=pattdat;
       // this.upattData=upattData;
 List<PatternData> result = new ArrayList<PatternData>();
        
        result.addAll(pattdat);
        result.addAll(upattData);

        
        this.pattData= result .stream().sorted((e1, e2) -> Integer.compare(e1.getId(),
                e2.getId())).collect(Collectors.toList());
       
//        this.star=new ArrayList<>();
//        this.chain=new ArrayList<>();
//        this.simple=new ArrayList<>();
     
        this._nfaDataList=nfaDataList;
        constRules=this._nfaDataList.get(0).get_constructClaue();
      //  this.implementStateMachines();
   //     this._inputModel = inputModel;
      //  this._pTableList = new ArrayList<KBPropertyTable>();
       // this.filterKBbindings();
     //   this.automataConstruction(); ///For Incremental one
        
        this.automataConstrutorForEvents(); //For Event ones
      //  assignPattern();
       
    }

    //////
    ////Over here Implement Single StateMachines
    // /Just send the StateMachine List to the StateMachines and LEt the StateMachines do its stuff
   
    
    
    /*private void assiningPredicates(){
          for(NFAData data:this._nfaDataList){
             
              for(AutomataState s:data.getAutomta().getStates()){
                  for(Dependability d:s.getRule().getDepends()){
                       AutomataState sJoin =  data.getAutomta().getStates().stream().filter(x->x.getStateId()==d.getDependabilty_id()).findFirst().get();
                       
                       d.setPred(sJoin.getRule().getPredicate().getMappedValue());
                       
                  
                  }
              }
          }
    }
    */
    
    
//    
//    private void assignPattern(){
//        for(NFAData data:this._nfaDataList){
//            
//           ArrayList<Automata> _listAutomata =new ArrayList<>();
//              for(AutomataState s:data.getAutomta().getStates()){
//                  
//                  if(s.getRule().getDepends().isEmpty()){
//                      
//                      ///first set of states
//                      simple.add(s);
//                  }else if(s.getRule().getDepends().get(0).getDependability_On()==1 && s.getRule().getDepends().get(0).getDependability_part()==1){
//                 star.add(s);
//                  ///star shaped set
//                  }else if(s.getRule().getDepends().get(0).getDependability_On()==1 && s.getRule().getDepends().get(0).getDependability_part()==0 ||s.getRule().getDepends().get(0).getDependability_On()==0 && s.getRule().getDepends().get(0).getDependability_part()==1|| s.getRule().getDepends().get(0).getDependability_On()==0 && s.getRule().getDepends().get(0).getDependability_part()==0){
//                      chain.add(s);
//                  ///chain shaped set
//                      
//                  }
//              }
//               Automata sAutomata= new Automata(data.getKbBindingList());
//                if(!simple.isEmpty()){
//                sAutomata.setStates(simple);
//                  _listAutomata.add(sAutomata);
//                }
//                 Automata cAutomata= new Automata(data.getKbBindingList());
//              if(!chain.isEmpty()){
//             cAutomata.setStates(chain);
//             _listAutomata.add(cAutomata);
//              }
//              
//              if(!star.isEmpty()){
//              ArrayList<ArrayList<AutomataState>> aList=new ArrayList<>();
//               ArrayList<AutomataState> s =new ArrayList<>();
//               s.add(star.get(0));
//               aList.add(s);
//              for(int i=1;i<star.size();i++){
//                  for(int j=0;j<aList.size();j++){
//                      String subject=star.get(i).getRule().getSubject().getProjection();
//                        if(aList.get(j).stream().filter(x->x.getRule().getSubject().getProjection().equals(subject)).count()>=1){
//                            aList.get(j).add(star.get(i));
//                            break;
//                        }else if(j==aList.size()-1){
//                             ArrayList<AutomataState> s2 =new ArrayList<>();
//                             s2.add(star.get(i));
//                             aList.add(s2);
//                             break;
//                        }
//                  }
//                
//                
//                  
//              }
//              
//               for(int i=0;i<aList.size();i++){
//                   Automata star= new Automata(data.getKbBindingList());
//                   star.setStates(aList.get(i));
//                   _listAutomata.add(star);
//              }
//              }
//              ///////////
//              
//              ////create new automatas
//             
//              
//               
//             
//              
//               
//               
//               /// Now to assign connections between different sets of query graphs
//               
//               /// go into each list and its states then find its connection 
//               
//             findBlockNumber(_listAutomata);
//              
//              
//              
//               for(int i=0; i<_listAutomata.size();i++){
//                   if(_listAutomata.get(i).getStates().size()==1){ //&& !_listAutomata.get(i).getStates().get(0).getRule().getDepends().isEmpty()){
//                           //&& _listAutomata.get(i).getStates().get(0).getRule().getDepends().get(0).getDependability_On()==1 &&
//                         // _listAutomata.get(i).getStates().get(0).getRule().getDepends().get(0).getDependability_part()==1 ){ //then put it in its dependent state
//                       
//                       
//                       for(int j=0;j<_listAutomata.size();j++){
//                           
//                           if(i!=j){
//                                AutomataState se =null;
//                               if(!_listAutomata.get(i).getStates().get(0).getRule().getDepends().isEmpty()){
//                               int id=_listAutomata.get(i).getStates().get(0).getRule().getDepends().get(0).getDependabilty_id();
//                            se =  _listAutomata.get(j).getStates().stream().filter(x->x.getRule().getId()==(id)).findFirst().orElse(null);
//                               }else{
//                                 
//                               int id   =    _listAutomata.get(i).getStates().get(0).getRule().getId();
//                               
//                                    se =  _listAutomata.get(j).getStates().stream().filter(x-> !x.getRule().getDepends().isEmpty() &&  x.getRule().getDepends().get(0).getDependabilty_id()==(id) ||
//                                          x.getRule().getDepends().size()>1 &&  x.getRule().getDepends().get(1).getDependabilty_id()==(id)).findFirst().orElse(null);
//                                   
//                               }
//                              
//                              if(se!=null){
//                                   _listAutomata.get(j).getStates().add(_listAutomata.get(i).getStates().get(0));
//                                   _listAutomata.get(i).getStates().clear();
//                                   break;
//                               }
//                           }
//                       }
//                       
//                   }
//               }
//              
//              
//              
//              boolean checker=false;
//               for(int i=0; i<_listAutomata.size();i++){
//                   if(_listAutomata.get(i).getStates().isEmpty()){
//                       _listAutomata.remove(i);
//                       checker=true;
//                   }
//               }
//               if (checker)
//               findBlockNumber(_listAutomata);
//              
//              checker=false;
//              data.setListAutomata(_listAutomata);
//             
//          }
//        System.out.println("sdf");
//    }
    
//    private void findBlockNumber(ArrayList<Automata> _listAutomata){
//          
//              for(int i=0; i<_listAutomata.size();i++){
//                  for(AutomataState s3:_listAutomata.get(i).getStates()){
//                      
//                      for(Dependability dep:s3.getRule().getDepends()){
//                          
//                      
//                      
//                      if(dep.getDependability_On()==1 && dep.getDependability_part()==0
//                              || dep.getDependability_On()==0 && dep.getDependability_part()==0 ||
//                              dep.getDependability_On()==0 && dep.getDependability_part()==1 ||  dep.getDependability_On()==1 && dep.getDependability_part()==1 ){
//                          
//                          ///find the join
//                          for(int j=0;j<_listAutomata.size();j++){
//                         
//                                 AutomataState se=null;
//                              if(i!=j){
//                              se=  _listAutomata.get(j).getStates().stream().filter(x->x.getRule().getId()==(dep.getDependabilty_id())).findFirst().orElse(null);
//                              }
//                             if(se!=null && i!=j){
//                                dep.setBlockID(j);
//                                dep.setPred(se.getRule().getPredicate().getMappedValue());
//                                break;
//                                }else{
//                                 dep.setBlockID(1000);
//                                 
//                             }
//                          
//                          }
//                          
//                      }
//                  }
//                  }
//              }
//    }
//    
//    private void automataConstruction() throws ParseException, DatatypeConfigurationException{
//        
//     List<Rule> starQuery;
//    List<Rule> chainQuery;
//        for(NFAData data:this._nfaDataList){
//            this.automta           = new Automata(data.getKbBindingList());
//            data.setDicionary(dicImpl);
//            starQuery=new ArrayList<>();
//            chainQuery=new ArrayList<>();
//            for(int i=0;i<data.getRuleList().size();i++){
//                //if(i==0){
//                  //  continue;
//                //}
//                
//                if (data.getRuleList().get(i).getQueryType()==2){
//                       //if(i==1){
//                         //   starQuery.add(data.getRuleList().get(i-1));
//                      // }
//                    starQuery.add(data.getRuleList().get(i));
//                }else { //if(!data.getRuleList().get(i).getDepends().isEmpty() &&  data.getRuleList().get(i).getDepends().get(0).getDependability_On()==1 && data.getRuleList().get(i).getDepends().get(0).getDependability_part()==0 || data.getRuleList().get(i).getDepends().get(0).getDependability_On()==0 ){
//                   
//                   // if(i==1){
//                     //       chainQuery.add(data.getRuleList().get(i-1));
//                      // }
//                    chainQuery.add(data.getRuleList().get(i));
//                }
//            }
//            
//           // costEstimation(starQuery);
//          
//            automataConstructor(costEstimation(chainQuery),costEstimation(starQuery));
//            //send//this.auotma and data.getrulelist///
//       //    ruleIDMaptoStates();
//           this.filterKBbindings(data);
//            data.setAutomta(this.automta);
//            data.setRuleList(null);
//            data.setKbBindingList(null);
//       //     System.out.println("This is");
//        }
//    }
//    
    
    private void automataConstrutorForEvents() throws ParseException, DatatypeConfigurationException{
          
         for(NFAData data:this._nfaDataList){
            Automata automta           = new Automata(data.getKbRuleList2());
              data.setDicionary(dicImpl);
              for(int i=0;i<data.getRuleList().size();i++){
                
                    AutomataState s = new AutomataState ();
                
              
                    
                       s.setRule(data.getRuleList().get(i));
                        s.setStateId(i);
                        automta.getStates().add(s);
                        
            
            }
          
          
            data.setAutomta(automta);
            data.setRuleList(null);
        
         }
        
    }
   
    
    
  /*  private void assiningPredicates(){
          for(NFAData data:this._nfaDataList){
             
              for(AutomataState s:data.getAutomta().getStates()){
                  for(Dependability d:s.getRule().getDepends()){
                       AutomataState sJoin =  data.getAutomta().getStates().stream().filter(x->x.getStateId()==d.getDependabilty_id()).findFirst().get();
                       
                       d.setPred(sJoin.getRule().getPredicate().getMappedValue());
                       
                  
                  }
              }
          }
    }
    
    
   private void clusteringQueryGraph(){
        for(NFAData data:this._nfaDataList){
             
              for(AutomataState s:data.getAutomta().getStates()){
                 if(s.getRule().getDepends().get(0).getDependability_On()==1 && s.getRule().getDepends().get(0).getDependability_part()==1){
                    
                     
                 }
              }
          }
   }
    
    
    
    */
    
    
    
//  private void automataConstructor( List<Rule> chainQuery,List<Rule> startQuery) throws ParseException, DatatypeConfigurationException{
//       
//        AutomataState s; 
//    
//    for(int i= 0; i < chainQuery.size();i++){
//       s = new AutomataState ();
//      // e =  new AutomataEdge();
//        s.setRule(chainQuery.get(i));
//      //  if(i == 0 || i == chainQuery.size()+startQuery.size()-1 )
//        s.setStateId(i);
//        
//        //s.setEdge(e);
//      this.automta.getStates().add(s);
//        
//    }
//        int j=0;
//       for(int i= this.automta.getStates().size(); i < startQuery.size()+chainQuery.size();i++){
//       s = new AutomataState ();
//      // e =  new AutomataEdge();
//       if(j==0 && startQuery.get(j).getDepends().get(0).getDependability_part()!=0){
//           
//           startQuery.get(j).setBreaker(true); ///not satisfied with this
//       }
//       
//        s.setRule(startQuery.get(j));
//       // if(i == 0 || i == chainQuery.size()+startQuery.size()-1 )
//        s.setStateId(i);
//        
//        //s.setEdge(e);
//      this.automta.getStates().add(s);
//       j++; 
//    }
//    
//    
//    
//    
//  }  
//  
//  private void ruleIDMaptoStates(){
//      ///we have automata and list of rules get the rule id from the dependent state and then 
//     
//   
//   for(AutomataState s:this.automta.getStates()){
//      // s.getRule().getDepends()
//               for(Dependability d:  s.getRule().getDepends()){
//                  List<AutomataState> state= this.automta.getStates().stream().filter(x->x.getRule().getId()==d.getDependabilty_id()).collect(Collectors.toList());
//              if(!state.isEmpty())
//                  d.setDependabilty_id(state.get(0).getStateId());
//               
//               }
//               
//               
//            if(s.getRule().getFilterType() == 2 && !s.getRule().isKb_flag()){
//                
//                
//                
//                 List<AutomataState> state= this.automta.getStates().stream().filter(x->x.getRule().getId()==s.getRule().getFilterRuleID()).collect(Collectors.toList());
//              //  if( s.getRule().getFilterRuleID()==this.automta.getStates().get(i).getRule().getId()){
//                  
//                 if(!state.isEmpty())
//                  s.getRule().setFilterRuleID(state.get(0).getStateId());
//                            //   break;
//                //          }
//            }
//            
//         
//       
//   }
//      
//      
//    
//      
//      
//      
//  }
//  
 
    
  private List<Rule> costEstimation(List<Rule> rList){
   //  this.totalCost=0;
      for(Rule r:rList){
          if(r.isFilterFlag() && r.getFilterType() == 1){ //Simple Atomic Filter
             r.setCost(1);
        //     totalCost++;
          }else if(r.isFilterFlag() && r.getFilterType() == 2 && !r.isKb_flag() ){ //Complex Filter Without KB
              r.setCost(6);
            //  totalCost=totalCost+6;
          }else if(r.isFilterFlag() && r.getFilterType() == 1 && r.isKb_flag() ){// KB with atomic Filter
              r.setCost(3);
             // totalCost=totalCost+3;
          }else if(r.isFilterFlag() && r.getFilterType() == 2 && r.isKb_flag() ){ //KB with COmplex Filter
              r.setCost(4);
            //  totalCost=totalCost+4;
          }else if(!r.isFilterFlag() && r.isKb_flag() ){ ///Simple KB Join
              r.setCost(5);
              //totalCost=totalCost+5;
          }else if(!r.isFilterFlag() &&  !r.isKb_flag() ){ //NO Filter and No KB join
              r.setCost(2);
              //totalCost=totalCost+2;
          }
      }
      
     //rList.stream().sorted().map(x->x.getCost()).collect(Collectors.toList());
     
     Comparator<Rule> byCostFuntion = (c1,c2)-> Integer.compare(c1.getCost(), c2.getCost());
   return rList=rList.stream().sorted(byCostFuntion).collect(Collectors.toList());
    
    /////Make states and edges
    
   
      
 // System.out.println("This is");
    
    
  }  
   private  void filterKBbindings(NFAData data) {    // /Vertical Partitioning of the Data ///Each property in the Query has its own table with two coulumns Subject and Objects

      //  ArrayList<KBPropertyTable>  _pTableList=null;
  /*     
       for(KBbindings k:data.getKbBindingList()){
           //for each state of the automta
           for(AutomataState s:this.automta.getStates()){
               if(s.getRule().isKb_flag() &&this.kbMatcher(s.getRule().getSubject(), s.getRule().getObject(), k.getSub(), k.getObj()) ){
                   
                   
                   // if(s.getRule().getObject().isProjection() && s.getRule().getObject().getProjection().equals(k.getObjectPtojection())||s.getRule().getSubject().isProjection() && k.getSub().getProjection().equals(s.getRule().getSubject().getProjection()))
                   //{
                   
                   //_pTableList=new ArrayList<>();
                   KBPropertyTable pTable =  new  KBPropertyTable();
                   
                   //if(k.getPred().getMappedValue().equals(s.getRule().getPredicate().getMappedValue())){
                   Model contextModel=this._inputModel.filter(null, k.getPred().getValue(), null, k.getGraphURI().getValue());
                   for (Statement kbS : contextModel) {
                       
                       if(kbS.getObject() instanceof Literal){
                           pTable.getSOMapped().put(this.dicImpl.addResource(kbS.getSubject()),
                                   this.dicImpl.addLiteral((Literal) kbS.getObject()));
                       }else {
                           pTable.getSOMapped().put(this.dicImpl.addResource(kbS.getSubject()),
                                   this.dicImpl.addResource((Resource) kbS.getObject()));
                       }
                       
                       //   pTable.getSOnative().put(this.dicImpl.addResource(kbS.getSubject()),
                       //                          this.dicImpl.addLiteral((Literal) kbS.getObject()));
                       
                       
                       
                       
                       //  }
                   }
                   s.getKbCBindings().getKbBindings().add(k);
                   s.getKbCBindings().getkBPropertyTable().add(pTable);
                   
                   //}
                   
                   
                   
               }else{
                   // s.setKbCBindings(null);
               }
           }
}

*/
    
   }
    
    
 private boolean kbMatcher(Subject s, ObjectS o, Subject s2, ObjectS o2){
     
     if(s.isProjection() && s.getProjection().equals(s2.getProjection())){ ///s-s kb join
         return true;
     }else if (s.isProjection() && s.getProjection().equals(o2.getProjection())){ //s-o join
     return true;
 }else if(o.isProjection() && o.getProjection().equals(o2.getProjection())){ //o-o join
     return true;
 }else if(o.isProjection() && o.getProjection().equals(s2.getProjection())){ ///o-s join
    return true; 
 }
     
     return false;
 }
    
  

    public ArrayList<KBbindings> getKbBindingList() {
        return _kbBindingList;
    }

   
    
    public List<Rule> getRulesList() {
        return _rulesList;
    }

    public List<NFAData> getNfaDataList() {
        return _nfaDataList;
    }
    public List<Rule> getConstRules() {
		return constRules;
	}

	public List<PatternData> getPattData() {
		return pattData;
	}

	
}



