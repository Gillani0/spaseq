/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.dictionary.optimised;

/**
 *
 * @author sydgillani
 */
public class Info {
    
    int runID; ///from 1---infi
    int sID; //1 if its static , 2 if its just adaptive
    long val;
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.runID;
        hash = 23 * hash + this.sID;
        hash = 23 * hash + (int) (this.val ^ (this.val >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Info other = (Info) obj;
        if (this.runID != other.runID) {
            return false;
        }
        if (this.sID != other.sID) {
            return false;
        }
        if (this.val != other.val) {
            return false;
        }
        return true;
    }
     
    
    public Info(){
        this.runID=0;
    
        this.sID=0;
    }
    public int getRunID() {
        return runID;
    }

    public void setRunID(int runID) {
        this.runID = runID;
    }



    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }
    
    
     public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }
  
}
