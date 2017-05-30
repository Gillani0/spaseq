/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.dictionary.optimised;

import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Resource;


/**
 *
 * @author sydgillani
 */
public interface DictionaryOpApi {
     public long addResourcePersistant(Resource s);

     public void refresh();
     
     
    public Resource getResourcePersistant(long indexR);
    
        public BNode getBnodePersistant(long indexR);
         public BNode getBnodeAdaptive(long indexR);

             public long addBnodePersistant(BNode o);
             public long addBnodeAdaptive(BNode o);
             
    public long addLiteralPersistant(Literal o);

    public Literal getLiteralPersistant(long indexL);
    
    public long addResourceAdaptive(Resource s);

    public Resource getResourceAdaptive(long indexR);

    public long addLiteralAdaptive(Literal o);

    public Literal getLiteralAdaptive(long indexL);
    
        
    public long addResourceIncremental(Resource s);

    public Resource getResourceIncremenal(long indexR);

    public long addLiteralIncremental(Literal o);

    public Literal getLiteralIncremental(long indexL);
    
      public long addBnodeIncremental(BNode o);
          public BNode getBnodeIncremental(long indexR);
             
    
}
