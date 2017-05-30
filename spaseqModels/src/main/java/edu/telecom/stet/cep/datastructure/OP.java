/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecom.stet.cep.datastructure;

import java.util.Objects;

/**
 *
 * @author sydgillani
 */
public class OP {
   Long obj;
    Long pred;
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.obj);
        hash = 47 * hash + Objects.hashCode(this.pred);
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
        final OP other = (OP) obj;
        if (!Objects.equals(this.obj, other.obj)) {
            return false;
        }
        if (!Objects.equals(this.pred, other.pred)) {
            return false;
        }
        return true;
    }

    
    public OP(Long object, Long predicate){
        this.obj=object;
        this.pred=predicate;
    }
    public Long getObj() {
        return obj;
    }

    public void setObj(Long obj) {
        this.obj = obj;
    }

    public Long getPred() {
        return pred;
    }

    public void setPred(Long pred) {
        this.pred = pred;
    }
 
}
