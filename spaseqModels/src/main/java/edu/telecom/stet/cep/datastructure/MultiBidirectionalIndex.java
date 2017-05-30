/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecom.stet.cep.datastructure;

import com.jcwhatever.nucleus.collections.MultiBiMap;

/**
 *
 * @author sydgillani
 */
public class MultiBidirectionalIndex {
    
 private MultiBiMap<Long, Long> _r;

    
  private MultiBiMap<Long, SP> _rIndex;
 
 

public MultiBidirectionalIndex(){
    _r=new MultiBiMap<Long, Long>();
  
   _rIndex=new MultiBiMap<Long, SP>();
   
}

public MultiBiMap<Long, Long> getR() {
        return _r;
    }

    public MultiBiMap<Long, SP> getrIndex() {
        return _rIndex;
    }
    
    public void rClear(){
       _r=null;
         _r=new MultiBiMap<Long, Long>();
       
    }
    public void rIndexClear(){
        _rIndex=null;
         _rIndex=new MultiBiMap<Long, SP>();
        
        
    }


}
