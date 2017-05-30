
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package edu.telecomstet.cep.model;

//~--- non-JDK imports --------------------------------------------------------

import edu.telecomstet.cep.dictionary.junkYard.DictionaryImpl;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import java.text.ParseException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;

/**
 *
 * @author sydgillani
 */
public class Predicate extends Tuple {
  private  Resource      predicateValue;

 

   private Long         predicateMappedValue;
   private String       predicateProjection;
   // String       edgeType;
 //  private ValueFactory factory;
   private boolean      projection;

//  DictionaryImpl dictImpl;

    public Predicate() throws ParseException, DatatypeConfigurationException {
      //  this.factory             = ValueFactoryImpl.getInstance();
        this.predicateProjection = null;
        this.predicateValue      = null;
        this.projection          = false;

        // this.dictImpl=dict;
        // this.setPredicateValuType(value);
    }

    /*
     * public boolean setPredicateValuType(String edgePredicate,DictionaryImpl dictImpl) throws ParseException, DatatypeConfigurationException {
     *
     *
     *     ///string null test// ////language tag supoer in next version///
     *
     *    edgePredicate=  edgePredicate.replace("'", "");
     *
     *    // System.out.println(edgePredicate);
     *     if(edgePredicate.contains("<")&& edgePredicate.contains(">")){ //// A proper pattern May be?
     *         edgePredicate=edgePredicate.replace("<", "");
     *         edgePredicate=edgePredicate.replace(">", "");
     *
     *         ///remove < and >
     *         this.predicateValue=  factory.createURI(edgePredicate);
     *         this.predicateMappedValue=dictImpl.addURI((URI)this.predicateValue);
     *         return true;
     *
     *     }
     *
     *     return false;
     *    /// this.edgePredicate = edgePredicate;
     * }
     *
     *
     *
     *
     * public Object getPredicateValue() {
     *     return predicateValue;
     * }
     *
     * public void setPredicateValue(String value,DictionaryImpl dictImpl) throws ParseException, DatatypeConfigurationException {
     *    this.setPredicateValuType(value,dictImpl);
     * }
     *
     * public String getPredicateProjection() {
     *     return predicateProjection;
     * }
     *
     * public void setPredicateProjection(String predicateProjection) {
     *     this.predicateProjection = predicateProjection;
     * }
     *
     *
     *
     *
     * public void setProjection(boolean projection) {
     *     this.projection = projection;
     * }
     *   public Object getPredicateMappedValue() {
     *     return predicateMappedValue;
     * }
     *
     * public void setPredicateMappedValue(Object predicateMappedValue) {
     *     this.predicateMappedValue = predicateMappedValue;
     * }
     */

   
  /*  public boolean setValueType(String edgeValue, DictionaryImpl dictImpl) {
        edgeValue = edgeValue.replace("'", "");

        // System.out.println(edgePredicate);
        if (edgeValue.contains("<") && edgeValue.contains(">")) {    //// A proper pattern May be?
            edgeValue = edgeValue.replace("<", "");
            edgeValue = edgeValue.replace(">", "");

            // /remove < and >
            this.predicateValue       = factory.createURI(edgeValue);
            this.predicateMappedValue = dictImpl.addURI((URI) this.predicateValue);
           // this.predicateValue       = null;

            return true;
        }

        return false;
    }*/
    
    
      public boolean setValueTypePersistance(String s, DictionaryOpImpl dictImpl) {

          // /string null test// ////language tag supoer in next version////
          s= s.replace("'", "");
          org.semanticweb.yars.nx.Resource predRes = new org.semanticweb.yars.nx.Resource(s, true);
          this.predicateMappedValue= dictImpl.addResourcePersistant(predRes);
          this.predicateValue=predRes;
          
          
          
          return true;
      }
      
      
    

    @Override
    public void setValue(String value, DictionaryOpImpl dictImpl) {
        this.setValueTypePersistance(value, dictImpl);
    }

    @Override
    public Resource getValue() {
        return this.predicateValue;
    }

    @Override
    public void setProjection(String projection) {
        this.predicateProjection = predicateProjection;
    }

    @Override
    public String getProjection() {
        return predicateProjection;
    }

    @Override
    public void setIsProjection(boolean projection) {
        this.projection = projection;
    }

    @Override
    public void setMappedValue(Long mappedValue) {
        this.predicateMappedValue = mappedValue;
    }

    @Override
    public Long getMappedValue() {
        return predicateMappedValue;
    }

    @Override
    public boolean isProjection() {
        return projection;
    }

    @Override
    public void setSimpleValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
 

    public void setPredicateValue(Resource predicateValue) {
        this.predicateValue = predicateValue;
    }

  
   public Resource getPredicateValue() {
        return predicateValue;
    }
   

 
}


//~ Formatted by Jindent --- http://www.jindent.com
