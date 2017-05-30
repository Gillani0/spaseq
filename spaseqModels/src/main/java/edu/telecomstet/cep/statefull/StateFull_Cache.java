/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.statefull;

import java.util.ArrayList;
import java.util.HashMap;
import org.semanticweb.yars.nx.Resource;

/**
 *
 * @author sydgillani
 */
public class StateFull_Cache {
    ////What to use for Caching.....
    
    
    ///HashMap of Object Object
 //   HashMap<Object, Object> s_cache;
   ArrayList<Object> sub;
   ArrayList<Object> obj;

  
 
    int ID;

 
   Resource pre;
    public StateFull_Cache(){
   //   s_cache = new HashMap<>();
        sub = new ArrayList<>();
        obj= new ArrayList<>();
        ID=0;
      
    }
    
    
 
    
       public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Resource getPre() {
        return pre;
    }

    public void setPre(Resource pre) {
        this.pre = pre;
    }

      public ArrayList<Object> getSub() {
        return sub;
    }

    public ArrayList<Object> getObj() {
        return obj;
    }
    
    public void clear(){
        this.obj.clear();
        this.sub.clear();
    }
    
}
