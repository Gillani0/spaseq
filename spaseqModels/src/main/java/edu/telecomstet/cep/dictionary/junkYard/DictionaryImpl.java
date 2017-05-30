
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package edu.telecomstet.cep.dictionary.junkYard;

//~--- non-JDK imports --------------------------------------------------------

import com.google.common.collect.HashBiMap;



/**
 *
 * @author sydgillani
 */
public class DictionaryImpl implements DictionaryApi {
 /*   private final static HashBiMap<Resource, Long> resources= HashBiMap.create();
    private final static  HashBiMap<Literal, Long>  literals=  HashBiMap.create();;
    private final static  HashBiMap<URI, Long>      uris =HashBiMap.create();
    private long              index;    // /Careful when using the Multitherading....

    public DictionaryImpl() {
      //  this.resources = HashBiMap.create();
       // this.literals  = HashBiMap.create();
        //this.uris      = HashBiMap.create();
        this.index     = 0;
    }

    @Override
    public long addResource(Resource s) {
        if (resources.containsKey(s)) {
            return resources.get(s);
        } else {
            this.resources.put(s, ++index);
        }

        return this.index;
    }

    @Override
    public Resource getResource(long indexR) {
        
        return this.resources.inverse().get(indexR);
       
    }

   @Override
    public long addLiteral(Literal o) {
        if (literals.containsKey(o)) {
            return literals.get(o);
        } else {
            this.literals.put(o, ++index);
        }

        return this.index;
    }

    @Override
    public Literal getLiteral(long indexL) {
        return this.literals.inverse().get(indexL);
    }

    @Override
    public Long addURI(URI p) {
        if (uris.containsKey(p)) {
            return uris.get(p);
        } else {
            this.uris.put(p, ++index);
        }

        return this.index;
    }

    @Override
    public URI getURI(int indexU) {
        return this.uris.inverse().get(indexU);
    }*/
}


//~ Formatted by Jindent --- http://www.jindent.com
