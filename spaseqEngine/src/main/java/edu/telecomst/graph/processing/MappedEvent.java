
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package edu.telecomst.graph.processing;

import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;

/**
 *
 * @author sydgillani
 */
public class MappedEvent {
   private Long Subject;
    private Long properties;
   private  Long object;
    private int  objectDataType;
    
  public  MappedEvent(){
       this. objectDataType=10; 
    }
  
  public MappedEvent(Node[] triple, DictionaryOpImpl dic){
	  this.dictionayMapping(triple, dic);
  }

    public int getObjectDataType() {
        return objectDataType;
    }

    public void setObjectDataType(int objectDataType) {
        this.objectDataType = objectDataType;
    }

    public Long getSubject() {
        return Subject;
    }

    public void setSubject(Long Subject) {
        this.Subject = Subject;
    }

    public long getProperties() {
        return properties;
    }

    public void setProperties(Long properties) {
        this.properties = properties;
    }

    public long getObject() {
        return object;
    }

    public void setObject(Long object) {
        this.object = object;
    }
    
    
    private void dictionayMapping(Node[] triple, DictionaryOpImpl dic){
        
        
        if(triple[0] instanceof BNode){
           this.setSubject(dic.addBnodeAdaptive((BNode) triple[0]));
        }else{
      this.setSubject(dic.addResourceAdaptive((Resource)triple[0]));
        }
       // System.out.println(mappedEvent.getSubject());
       this.setProperties(dic.addResourceAdaptive((Resource)triple[1]));
        if(triple[2] instanceof Resource ){
          this.setObject(dic.addResourceAdaptive((Resource)triple[2]));
        }else if(triple[2] instanceof BNode){
            this.setObject(dic.addBnodeAdaptive((BNode) triple[2]));
        }else{
            this.setObject(dic.addLiteralAdaptive((Literal) triple[2]));
           this.setObjectDataType(((Literal) triple[2]).getType());
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
