/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.cep.dictionary.optimised;

import com.google.common.collect.HashBiMap;

import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;

/**
 *
 * @author sydgillani
 */
public class DictionaryOpImpl implements DictionaryOpApi {
    
    private final static HashBiMap<Resource, Long> resourcesPersistant= HashBiMap.create();
    private final static  HashBiMap<Literal, Long>  literalsPersistant=  HashBiMap.create();
    private final static  HashBiMap<BNode, Long>  bNodePersistant=  HashBiMap.create();
    
    private final static HashBiMap<Resource, Long> resourcesAdaptive= HashBiMap.create(); ///first copy the statefull ones over here
    private final static  HashBiMap<Literal, Long>  literalsAdaptive=  HashBiMap.create();
    private final static  HashBiMap<BNode, Long>  bNodeAdaptive=  HashBiMap.create();
    
     
    
    private final static HashBiMap<Resource, Long> resourcesIncremental= HashBiMap.create(); ///first copy the statefull ones over here
    private final static  HashBiMap<Literal, Long>  literalsIncremental=  HashBiMap.create();
    private final static  HashBiMap<BNode, Long>  bNodeIncremental=  HashBiMap.create();
    
     
    
    private long              index;    // /Careful when using the Multitherading....
    
    
   
    
    
    
    public DictionaryOpImpl(){
        index =0;
    }
    
    
    

   
    @Override
    public long addResourcePersistant(Resource s) {
        if (resourcesPersistant.containsKey(s)) {
            return resourcesPersistant.get(s);
        } else {
            this.resourcesPersistant.put(s, ++index);
        }
        
        return this.index;
    }
    
    @Override
    public Resource getResourcePersistant(long indexR) {
        return this.resourcesPersistant.inverse().get(indexR);
    }
    
    @Override
    public long addLiteralPersistant(Literal o) {
        if (literalsPersistant.containsKey(o)) {
            return literalsPersistant.get(o);
        } else {
            this.literalsPersistant.put(o, ++index);
        }
        
        return this.index;
    }
    
    @Override
    public Literal getLiteralPersistant(long indexL) {
        return this.literalsPersistant.inverse().get(indexL);
    }
    
    @Override
    public synchronized long addResourceAdaptive(Resource s) {
        if (resourcesPersistant.containsKey(s)) {
            long j= resourcesPersistant.get(s);
            this.resourcesAdaptive.put(s, j);
            return j;
        }else if (resourcesAdaptive.containsKey(s)) {
            return resourcesAdaptive.get(s);
        }else {
            this.resourcesAdaptive.put(s,++index);
        }
        
        return index;
    }
    
    
    @Override
    public  synchronized Resource getResourceAdaptive(long indexR) {
        return this.resourcesAdaptive.inverse().get(indexR);
    }
    
    @Override
    public synchronized long addLiteralAdaptive(Literal o) {
        if (literalsPersistant.containsKey(o)) {
            
            long i=literalsPersistant.get(o);
            literalsAdaptive.put(o, i);
            return i;
        }else if(literalsAdaptive.containsKey(o)){
            return literalsAdaptive.get(o);
        }else{
            literalsAdaptive.put(o, ++index);
        }
        return index;
    }
    
    @Override
    public synchronized Literal getLiteralAdaptive(long indexL) {
        return this.literalsAdaptive.inverse().get(indexL);
    }
    
    @Override
    public void refresh() {
        
        resourcesAdaptive.clear();
        literalsAdaptive.clear();
         bNodeAdaptive.clear();
        
    }
    
    @Override
    public BNode getBnodePersistant(long indexR) {
        return this.bNodePersistant.inverse().get(indexR);
    }
    
    @Override
    public synchronized BNode getBnodeAdaptive(long indexR) {
        return this.bNodeAdaptive.inverse().get(indexR);
    }
    
    @Override
    public long addBnodePersistant(BNode o) {
        if (bNodePersistant.containsKey(o)) {
            return bNodePersistant.get(o);
        } else {
            this.bNodePersistant.put(o, ++index);
        }
        
        return this.index;
    }
    
    @Override
    public synchronized long  addBnodeAdaptive(BNode o) {
        if (bNodePersistant.containsKey(o)) {
            
            long i=bNodePersistant.get(o);
            bNodeAdaptive.put(o, i);
            return i;
        }else if(bNodeAdaptive.containsKey(o)){
            return bNodeAdaptive.get(o);
        }else{
            bNodeAdaptive.put(o, ++index);
        }
        return index;
    }
    
    
     public boolean checkStatefullSMap(Long l){
       /* if(resourcesPersistant.containsValue(l)){
            return true;
        }else if (bNodePersistant.containsValue(l)){
            return true;
        }*/
         if(resourcesPersistant.containsValue(l)){
            return true;
         }
        return false;
     }
     
     public void checkStatefullSValue(Object o, Long l){
         
         /*if(o instanceof Resource){
            resourcesPersistant.put((Resource)o,l);
         }else if(o instanceof BNode){
             bNodePersistant.put((BNode)o, l);
         }*/
           resourcesPersistant.put((Resource)o,l);
     }
     
     
      public boolean checkStatefullOMap(Long l){
       /* if(literalsPersistant.containsValue(l)){
            return true;
        }else if (bNodePersistant.containsValue(l)){
            return true;
        }*/
        
         if(literalsPersistant.containsValue(l)){
            return true;
         }
        return false;
     }
     
     public void checkStatefullOValue(Object o, Long l){
         
       /*  if(o instanceof Literal){
            literalsPersistant.put((Literal)o,l);
         }else if(o instanceof BNode){
             bNodePersistant.put((BNode)o, l);
         }*/
         
          literalsPersistant.put((Literal)o,l);
     }

    @Override
    public long addResourceIncremental(Resource s) {
      if (resourcesPersistant.containsKey(s)) {
            long j= resourcesPersistant.get(s);
            this.resourcesIncremental.put(s, j);
            return j;
        }else if (resourcesIncremental.containsKey(s)) {
            return resourcesIncremental.get(s);
        }else {
            this.resourcesIncremental.put(s,++index);
        }
        
        return index;
    }

    @Override
    public Resource getResourceIncremenal(long indexR) {
    return this.resourcesIncremental.inverse().get(indexR);
    }

    @Override
    public long addLiteralIncremental(Literal o) {
if (literalsPersistant.containsKey(o)) {
            
            long i=literalsPersistant.get(o);
           literalsIncremental.put(o, i);
            return i;
        }else if( literalsIncremental.containsKey(o)){
            return  literalsIncremental.get(o);
        }else{
             literalsIncremental.put(o, ++index);
        }
        return index;
    }

    @Override
    public Literal getLiteralIncremental(long indexL) {
       if(literalsIncremental.containsValue(indexL)){
          return this. literalsIncremental.inverse().get(indexL);
       }else{
           return null;
       }
    }

    @Override
    public long addBnodeIncremental(BNode o) {
      if (bNodePersistant.containsKey(o)) {
            
            long i=bNodePersistant.get(o);
            bNodeIncremental.put(o, i);
            return i;
        }else if(bNodeIncremental.containsKey(o)){
            return bNodeIncremental.get(o);
        }else{
            bNodeIncremental.put(o, ++index);
        }
        return index;
    }

    @Override
    public BNode getBnodeIncremental(long indexR) {
        
              return this.bNodeIncremental.inverse().get(indexR);
    }
    
    public long addSubject(Node s){
        if(s instanceof Resource ){
            return this.addResourceIncremental((Resource)s);
        }else if(s instanceof BNode){
            return this.addBnodeIncremental((BNode)s);
        }
        
        return 0;
    }
    public long addObject(Node o){
        if(o instanceof Resource ){
            return this.addResourceIncremental((Resource)o);
        }else if(o instanceof Literal){
            return this.addLiteralIncremental((Literal) o);
        }
        
        else if(o instanceof BNode){
            return this.addBnodeIncremental((BNode)o);
        }
        
        return 0;
    }
    
    public long predicateTest(Resource s) {
        if (resourcesPersistant.containsKey(s)) {
            return resourcesPersistant.get(s);
        } else {
            return 0;
        }
        
    //   return this.index;
    }
    
    
    
    public long subjectTest(Resource s) {
        if (resourcesPersistant.containsKey(s)) {
            return resourcesPersistant.get(s);
        } else {
            return 0;
        }
        
    //   return this.index;
    }
    
    
    
    public long objectTest(Node obj){
        
        if(obj instanceof Literal &&  literalsPersistant.containsKey((Literal)obj)){
            return literalsPersistant.get(obj);
        }else if(obj instanceof Resource && resourcesPersistant.containsKey((Resource)obj)){
            return resourcesPersistant.get((Resource)obj);
        }else if (obj instanceof BNode && bNodePersistant.containsKey((Resource)obj)){
            return bNodePersistant.get((BNode)obj);
        }
        
       return 0;
    }
    
}
