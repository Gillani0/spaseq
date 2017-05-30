/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.cep.rulesmodel;

/**
 *
 * @author sydgillani
 */
public class Dependability {
    
    
    
    private  int dependability_On; //1 for subject, 0 for object //means the triple pattern has subject or object as variable.
    private int dependability_part; //1 for subject, 0 for object ///means that triple pattern is join on either subject or object. of other triple patter
    private int dependabilty_id; //the id of the rule it joined on
    private  boolean stateDependability;
    private long pred;

    private long  _dPredicate;
   
    private int blockID;
    private int joined;

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
    public long getPred() {
        return pred;
    }

    public void setPred(long pred) {
        this.pred = pred;
    }

    public Dependability (){
        this.stateDependability=false;
        this.dependability_On=5;
        this.dependability_part=5;
        this.joined=0;
    }
    
    public int getDependability_On() {
        return dependability_On;
    }
    
    public void setDependability_On(int dependability_direction) {
        this.dependability_On = dependability_direction;
    }
    
    public int getDependability_part() {
        return dependability_part;
    }
    
    public void setDependability_part(int dependability_part) {
        this.dependability_part = dependability_part;
    }
    
    public int getDependabilty_id() {
        return dependabilty_id;
    }
    
    public void setDependabilty_id(int dependabilty_id) {
        this.dependabilty_id = dependabilty_id;
    }
    
    public boolean isStateDependability() {
        return stateDependability;
    }
    
    public void setStateDependability(boolean stateDependability) {
        this.stateDependability = stateDependability;
    }
    
    public long getdPredicate() {
        return _dPredicate;
    }

    public void setdPredicate(long  _dPredicate) {
        this._dPredicate = _dPredicate;
    }
}
