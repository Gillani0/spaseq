/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.graph.automata;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.OP;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.knowledgebase.KBRule;
import edu.telecomstet.cep.knowledgebase.KBbindings;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sydgillani
 */
public class Automata {

   
     private  ArrayList<AutomataState> states;
    
//         private MultiBiMap<SP, OP> _fR;
//         
//         private  MultiBiMap<SP, OP> _kbR;
//         
//         private MultiBiMap<SP, OP> _fRcopied;
//
//           private MultiBiMap<Long, Long> _fR2;
  

     private List<KBRule>         _kbRuleList2;
         private int joined;

         
         private int containsKB; ///0: no, 1:yes
   //make an object for the extrenal KB
 
     //    private final ArrayList<KBbindings> kbBinds;


     
     public Automata( List<KBRule>       kb){
          this.states = new ArrayList<>();
      
          this._kbRuleList2=kb;
          
          if(kb.isEmpty()){
        	 this.containsKB=0; 
          }else{
        	  this.containsKB=1;
        	 
          }
          
          joined=0;
     }
     
      public ArrayList<AutomataState> getStates() {
        return states;
    }
      
      
//    public MultiBiMap<SP, OP> getfR() {
//        return _fR;
//    }
//    
//    public MultiBiMap<SP, OP> getKbR() {
//        return _kbR;
//    }
//
//    public void setKbR(MultiBiMap<SP, OP> _kbR) {
//        this._kbR = _kbR;
//    }
//
//    public void setfR(MultiBiMap<SP, OP> _fR) {
//        this._fR.putAll(_fR);
//        
//        
//    }
    public void setStates(ArrayList<AutomataState> s){
        this.states=s;
    }
    
    
//    public ArrayList<KBbindings> getKbBinds() {
//        return kbBinds;
//    }

    
//       public MultiBiMap<SP, OP> getfRcopied() {
//        return _fRcopied;
//    }

    
    public int getJoined() {
        return joined;
    }

    public void setJoined(int joined) {
        this.joined = joined;
    }

	public List<KBRule> get_kbRuleList2() {
		return _kbRuleList2;
	}

	public int getContainsKB() {
		return containsKB;
	}

	
   
//      public void rCopiedClear()
//      {
//         _fRcopied=null;
//          _fRcopied=new MultiBiMap();
//      }      
//      
//      
//      
//         public void frClear()
//      {
//        _fR =null;
//     
//             _fR=new MultiBiMap();
//      }      
//
//         
//         
//           public MultiBiMap<Long, Long> getfR2() {
//        return _fR2;
//    }
}
