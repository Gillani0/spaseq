/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.rulesmodel;

import edu.telecomstet.cep.model.Predicate;



/**
 *
 * @author sydgillani
 */
public class KBDependability {
       private int dependability_On; // 1 for subject and 0 for object 
      private  int dependability_part;/// the joined triple pattern
      private Predicate _dInfo;
    //  private  Long mapped_dep_property;
     // private  Predicate predicate;
       

 
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

    public Predicate getDInfo() {
        return _dInfo;
    }

    public void setDependability_property(Predicate dependability_property) {
        this._dInfo = dependability_property;
    }
}
