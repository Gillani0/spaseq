/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.cep.statefull;

/**
 *
 * @author sydgillani
 */
public class StateDependability {
    
    
    private  int d_On; //1 for subject, 0 for object //means the triple pattern has subject or object as variable.
    private int d_part; //1 for subject, 0 for object ///means that triple pattern is join on either subject or object. of other triple patter
    private int d_id; //the id of the rule it joined on
    // private  boolean stateDependability;
    private long _dPredicate;
    private int _idNFA;

    public int getIdNFA() {
        return _idNFA;
    }

    public void setIdNFA(int _idNFA) {
        this._idNFA = _idNFA;
    }
    
    
    public long getdPredicate() {
        return _dPredicate;
    }
    
    public void setdPredicate(long _dPredicate) {
        this._dPredicate = _dPredicate;
    }
    
    
    public int getD_On() {
        return d_On;
    }
    
    public void setD_On(int d_On) {
        this.d_On = d_On;
    }
    
    public int getD_part() {
        return d_part;
    }
    
    public void setD_part(int d_part) {
        this.d_part = d_part;
    }
    
    public int getD_id() {
        return d_id;
    }
    
    public void setD_id(int d_id) {
        this.d_id = d_id;
    }
    
}
