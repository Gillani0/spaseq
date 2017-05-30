/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.cep.graph.automata;

import edu.telecomstet.cep.knowledgebase.KnowledgeBaseBindingImpl;
import edu.telecomstet.cep.rulesmodel.Rule;
import java.text.ParseException;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author sydgillani
 */
public class AutomataState {
    
    
    
    private  Rule rule;
    private final   AutomataEdge edge;
    private  int stateDataType =0;
    private int joined=0; //0 if its not joined yet, and 1 if its already been joined.
    
    
    private int stateProcessed=0; ///0 its not, 1 it is processed
    
    private int change =0; //0 if there is no change in C and 1 if there and requires the join processing
    
    
    private int StateId=0; //1 for start state and 2 for last state
    
    // private  KnowledgeBaseBindingImpl    _kbCompleteBindings;
// private List<KBbindings> _kbBindings;
    
    
    private int blockID;
    
    ///you just need the output table over here

   
    
    
    public AutomataState() throws ParseException, DatatypeConfigurationException {
        
        edge= new AutomataEdge();
        
        //this.rule=new Rule();
        //_kbCompleteBindings=this.getKbCompleteBindings();
        //    this._kbBindings=new ArrayList<>();
        // this.StateId=0;
        
    }
    
    public Rule getRule() {
        return rule;
    }
    
    public void setRule(Rule rule) {
        this.rule = rule;
    }
    
    public AutomataEdge getEdge() {
        return edge;
    }
    
    /*public void setEdge(AutomataEdge edge) {
    this.edge = edge;
    }*/
    
    
    public int getStateId() {
        return StateId;
    }
    
    public void setStateId(int StateId) {
        this.StateId = StateId;
    }
    
    
    public int getStateDataType() {
        return stateDataType;
    }
    
    public void setStateDataType(int stateDataType) {
        this.stateDataType = stateDataType;
    }
    
    
    public int getStateProcessed() {
        return stateProcessed;
    }
    
    public void setStateProcessed(int stateProcessed) {
        this.stateProcessed = stateProcessed;
    }
    
    /* public void setKbCBindings(KnowledgeBaseBindingImpl _kbCBindings) {
    this._kbCBindings = _kbCBindings;
    }*/
    
    public int getChange() {
        return change;
    }
    
    public void setChange(int change) {
        this.change = change;
    }
    
    public int getJoined() {
        return joined;
    }
    
    public void setJoined(int joined) {
        this.joined = joined;
    }
     public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }
    
    
}
