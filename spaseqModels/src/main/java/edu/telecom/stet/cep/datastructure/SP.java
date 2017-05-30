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
public class SP {
    Long sub;
    Long pred;
    
    
    public SP(Long subject,Long predicate){
        this.sub=subject;
        this.pred=predicate;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.sub);
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
        final SP other = (SP) obj;
        if (!Objects.equals(this.sub, other.sub)) {
            return false;
        }
        if (!Objects.equals(this.pred, other.pred)) {
            return false;
        }
        return true;
    }
    public Long getSub() {
        return sub;
    }
    
    public void setSub(Long sub) {
        this.sub = sub;
    }
    
    public Long getPred() {
        return pred;
    }
    
    public void setPred(Long pred) {
        this.pred = pred;
    }
    
}
