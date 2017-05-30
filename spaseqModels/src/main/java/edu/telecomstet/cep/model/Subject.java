
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


/**
 *
 * @author sydgillani
 */
public class Subject extends Tuple {
  private  Object       subjectValue;
   private String       subjectProjection;
   private Long         subjectMappedValue;
  //  String       edgeType;
  // private ValueFactory factory;
   private boolean      projection;
   private Long         subjProjectionMapped;


//  DictionaryImpl dictImpl;

    public Subject() throws ParseException, DatatypeConfigurationException {
       // this.factory           = ValueFactoryImpl.getInstance();
        this.subjectProjection = null;
        this.subjectValue      = null;
        this.subjectProjection = null;

        // this.dictImpl=dict;
    }

    /*
     * public boolean setSubjectValuType(String edgePredicate,DictionaryImpl dictImpl) throws ParseException, DatatypeConfigurationException {
     *
     *
     *    ///string null test// ////language tag supoer in next version///
     *
     *   edgePredicate=  edgePredicate.replace("'", "");
     *
     *   // System.out.println(edgePredicate);
     *    if(edgePredicate.contains("<")&& edgePredicate.contains(">")){ //// A proper pattern May be?
     *        edgePredicate=edgePredicate.replace("<", "");
     *        edgePredicate=edgePredicate.replace(">", "");
     *
     *        ///remove < and >
     *        this.subjectValue=  factory.createURI(edgePredicate);
     *        this.subjectMappedValue=dictImpl.addResource((Resource) this.subjectValue);
     *
     *        return true;
     *
     *    }//else if(isInteger(edgePredicate)){                     ///instead of this add the blank node suff   later dicionary as well
     *       // this.subjectValue=factory.createLiteral(Integer.parseInt(edgePredicate));
     *         //  return true;
     *    //}
     *
     *
     *
     *    return false;
     *   /// this.edgePredicate = edgePredicate;
     * }
     */

    /*
     *   public Object getSubjectValue() {
     *    return subjectValue;
     * }
     *
     * public void setSubjectValue(String value,DictionaryImpl dictImpl) throws ParseException, DatatypeConfigurationException {
     *     this.setSubjectValuType(value,dictImpl);
     *    //this.subjectValue = subjectValue;
     * }
     *
     * public String getSubjectProjection() {
     *    return subjectProjection;
     * }
     */

    // public void setSubjectProjection(String subjectProjection) {
    // this.subjectProjection = subjectProjection;
    // }
    @Override
    public boolean isProjection() {
        return projection;
    }

    /*
     *    public void setProjection(boolean projection) {
     *      this.projection = projection;
     *  }
     *
     *   public Object getSubjectMappedValue() {
     *      return subjectMappedValue;
     *  }
     *
     *  public void setSubjectMappedValue(Object subjectMappedValue) {
     *      this.subjectMappedValue = subjectMappedValue;
     *  }
     */
  //  @Override
   /* public boolean setValueType(String edgePredicate, DictionaryImpl dictImpl) {

        // /string null test// ////language tag supoer in next version////
        edgePredicate = edgePredicate.replace("'", "");

        // System.out.println(edgePredicate);
        if (edgePredicate.contains("<") && edgePredicate.contains(">")) {    //// A proper pattern May be?
            edgePredicate = edgePredicate.replace("<", "");
            edgePredicate = edgePredicate.replace(">", "");

            // /remove < and >
            this.subjectValue       = factory.createURI(edgePredicate);
            this.subjectMappedValue = dictImpl.addResource((Resource) this.subjectValue);

            // this.subjectValue=null;
            return true;
        }    // else if(isInteger(edgePredicate)){                     ///instead of this add the blank node suff   later dicionary as well

        // this.subjectValue=factory.createLiteral(Integer.parseInt(edgePredicate));
        // return true;
        // }

        
        
        
        
        return false;
    }*/
    
      public boolean setValueTypePersistance(String s, DictionaryOpImpl dictImpl) {

     
          
          org.semanticweb.yars.nx.Resource subjRes = new org.semanticweb.yars.nx.Resource(s, true);
          this.subjectMappedValue= dictImpl.addResourcePersistant(subjRes);
          this.subjectValue=subjRes;
          
          
          
          
          
          
          return true;
    }
      
      
    

    @Override
    public void setValue(String value, DictionaryOpImpl dictImpl) {
        this.setValueTypePersistance(value, dictImpl);
    }

    @Override
    public Object getValue() {
        return subjectValue;
    }

    @Override
    public void setProjection(String projection) {
        this.subjectProjection = projection;
    }

    @Override
    public String getProjection() {
        return subjectProjection;
    }

    @Override
    public void setIsProjection(boolean projection) {
        this.projection = projection;
    }

    @Override
    public void setMappedValue(Long mappedValue) {
        this.subjectMappedValue = mappedValue;
    }

    @Override
    public Long getMappedValue() {
        return subjectMappedValue;
    }
    
    public void setProjectionMapped(String proj,DictionaryOpImpl dictImpl ){
        
             // = factory.createURI(edgePredicate);
      //  this.subjProjectionMapped=  dictImpl.addLiteral(factory.createLiteral(proj));
    }
    
    
    public Long getSubjProjectionMapped() {
        return subjProjectionMapped;
    }

    @Override
    public void setSimpleValue(Object value) {
       this.subjectValue=value;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
