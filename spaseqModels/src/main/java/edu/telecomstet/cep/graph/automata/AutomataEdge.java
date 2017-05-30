/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.graph.automata;

import com.jcwhatever.nucleus.collections.MultiBiMap;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.OP;
import edu.telecom.stet.cep.datastructure.SP;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;


/**
 *
 * @author sydgillani
 */
public class AutomataEdge {

  
   private static final Logger LOG = Logger.getLogger(AutomataEdge.class.getName());

      
  //     private final   MultiBiMap<Long, Long> _tableSOMapped;  //=  new MultiBiMap();
      //  private final   MultiBiMap<Long, Long> _tableKBSOMapped;
   
    //    private final   MultiBiMap<Long, Long> _tableSOMappedCopied; //incase of complex filter make a copy of it
        
      //    private final   MultiBiMap<Long, Long> _tableSOMappedJunked;

  //   private C _table;

  //    private MultiBiMap<SP, OP> _R;

    
   //     private MultiBiMap<SP, OP> _RCopied;  //remove theses

  

   private MultiBidirectionalIndex _r;

    
     private MultiBidirectionalIndex _rCopied;
    
     private final Set<Long> junkSet = new HashSet<Long>();
       


       
       public AutomataEdge(){
    
          //_R=new MultiBiMap();
         // _RCopied=new MultiBiMap();
          _r= new MultiBidirectionalIndex();
          _rCopied = new MultiBidirectionalIndex();
      
       
      }
      

    public Set<Long> getJunkSet() {
        return junkSet;
    }
  
        
       

 
    
    public MultiBidirectionalIndex getRreal() {
        return _r;
    }

    public MultiBidirectionalIndex getrCopied() {
        return _rCopied;
    }
    
    public void rRealClear(){
        _r.rClear();
    }
    
    public void rCopiedClear(){
        _rCopied.rIndexClear();
    }
}
