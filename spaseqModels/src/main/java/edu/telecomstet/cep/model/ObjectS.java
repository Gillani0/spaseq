
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package edu.telecomstet.cep.model;

//~--- non-JDK imports --------------------------------------------------------

import java.text.ParseException;

import javax.xml.datatype.DatatypeConfigurationException;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;

/**
 *
 * @author sydgillani
 */
public class ObjectS extends Tuple {
   private Object       ObjectValue;
   private Long         objectMappedValue;
   private String       ObjectProjection;
   private int          ObjectDataType; // 0: int, 1: float, 2: decimal, 3: DataTime, 4: Double, 5: string, 6: Long

  
    //String       edgeType;
 //  private ValueFactory factory;
  private  boolean      projection;

    // DictionaryImpl dictImpl;

    public ObjectS() throws ParseException, DatatypeConfigurationException {
    //    this.factory          = ValueFactoryImpl.getInstance();
        this.ObjectProjection = null;
        this.ObjectValue      = null;
        this.projection       = false;
         ObjectDataType=15;

        // this.dictImpl=dict;
        // this.setObjectValuType(value);
    }

   
 
   
    
    
    
    
   @Override
    public boolean setValueTypePersistance(String s, DictionaryOpImpl dictImpl) {

        // /string null test// ////language tag supoer in next version////
     
if(s.contains("\""))
{
	 s= s.replace("\"", "");
	 
}else if(s.contains("'")){
	 s= s.replace("'", "");
}
       

        // System.out.println(edgePredicate);
        if (s.contains("<") && s.contains(">")) {    //// A proper pattern May be?
         
            
              org.semanticweb.yars.nx.Resource objRes = new org.semanticweb.yars.nx.Resource(s, true);
     this.objectMappedValue= dictImpl.addResourcePersistant(objRes);
     this.ObjectValue=objRes;
     return true;
        }else {
              org.semanticweb.yars.nx.Literal nL=new    org.semanticweb.yars.nx.Literal(s);
               
               this.ObjectDataType= nL.getType();
                 this.objectMappedValue=dictImpl.addLiteralPersistant(nL);
                 this.ObjectValue=nL;
        
        return true;
        }
        
        
       
        
       
        
   /*    if (isInteger(s)) {
          //  this.ObjectValue       = factory.createLiteral(Integer.parseInt(edgePredicate));
            
            
          //  org.semanticweb.yars.nx.Literal objLit = new  org.semanticweb.yars.nx.Literal; 
            
            this.objectMappedValue = dictImpl.addLiteralPersistant(( org.semanticweb.yars.nx.Literal) c) ;// addLiteral((Literal) this.ObjectValue);
           // this.ObjectValue       = null;
            this.ObjectDataType    = 0;

            return true;
        } else if (isDateTime(c.toString())) {
            Date datetime = null;

            try {
                datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(c.toString());
            } catch (ParseException ex) {
                Logger.getLogger(ObjectS.class.getName()).log(Level.SEVERE, null, ex);
            }

          
             this.objectMappedValue = dictImpl.addLiteralPersistant(( org.semanticweb.yars.nx.Literal) c) ;  //addLiteral((Literal) this.ObjectValue);
            //this.ObjectValue       = null;
            this.ObjectDataType    = 3;

            return true;
        } else if (isFloat(c.toString())) {
            
             this.objectMappedValue = dictImpl.addLiteralPersistant(( org.semanticweb.yars.nx.Literal) c) ; 
           // this.ObjectValue       = null;
            this.ObjectDataType= 1;
            return true;
        }

        if (isDouble(c.toString())) {
         this.objectMappedValue = dictImpl.addLiteralPersistant(( org.semanticweb.yars.nx.Literal) c) ; 
           // this.ObjectValue       = null;
            this.ObjectDataType= 4;
            return true;
        } else if (isLong(c.toString())) {
            this.objectMappedValue = dictImpl.addLiteralPersistant(( org.semanticweb.yars.nx.Literal) c) ; 
           /// this.ObjectValue       = null;
            this.ObjectDataType= 6;
            return true;
        } else if (isXMLGregorianCalender(c.toString())) {
            try {
                this.ObjectValue =
                    factory.createLiteral(DatatypeFactory.newInstance().newXMLGregorianCalendar(c.toString()));
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(ObjectS.class.getName()).log(Level.SEVERE, null, ex);
            }

              this.objectMappedValue = dictImpl.addLiteralPersistant(( org.semanticweb.yars.nx.Literal) c) ; 
           // this.ObjectValue       = null;
            this.ObjectDataType= 6;

            return true;
        } else if (c.toString() instanceof String) {
    this.objectMappedValue = dictImpl.addLiteralPersistant(( org.semanticweb.yars.nx.Literal) c) ; 
            //this.ObjectValue       = null;
             this.ObjectDataType= 5;
            return true;
        } 
        
        */
        
        /*else if (isBoolean(edgePredicate)) {
            this.ObjectValue       = factory.createLiteral(Boolean.parseBoolean(edgePredicate));
            this.objectMappedValue = dictImpl.addLiteral((Literal) this.ObjectValue);
            ///this.ObjectValue       = null;
            this.ObjectDataType= 8;
            return true;
        }*/

    
    }
    
    
    
    
    


    
    public void setSimpleValue(Object value){
        this.ObjectValue=value;
    }
    
    
    @Override
    public Object getValue() {
        return ObjectValue;
    }

    @Override
    public void setProjection(String projection) {
        this.ObjectProjection = projection;
    }

    @Override
    public String getProjection() {
        return ObjectProjection;
    }

    @Override
    public void setIsProjection(boolean projection) {
        this.projection = projection;
    }

    @Override
    public void setMappedValue(Long mappedValue) {
        this.objectMappedValue = mappedValue;
    }

    @Override
    public Long getMappedValue() {
        return objectMappedValue;
    }

    @Override
    public boolean isProjection() {
        return projection;
    }

 /*   private static boolean isBoolean(String b) {
        try {
            boolean cv = Boolean.parseBoolean(b);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static boolean isLong(String l) {
        try {
            Long.parseLong(l);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

     private static boolean isDouble(String d) {
        try {
            Double.parseDouble(d);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static boolean isFloat(String f) {
        try {
            Float.parseFloat(f);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        // only got here if we didn't return false
        return true;
    }

     private static boolean isDateTime(String d) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
        } catch (Exception e) {
            return false;
        }

        return true;
    }*/

    private static boolean isXMLGregorianCalender(String b) {

        /*
         *   try {
         *    DatatypeFactory.newInstance().newXMLGregorianCalendar(b);
         *
         *
         *  //  System.out.println(DatatypeFactory.newInstance().newXMLGregorianCalendar(b).toString());
         * } catch (DatatypeConfigurationException ex) {
         *      Logger.getLogger(NFAdata.class.getName()).log(Level.SEVERE, null, ex);
         *    return false;
         * }
         */

        // return false;
        // }
        return false;
    }
    
    
      public int getObjectType() {
        return ObjectDataType;
    }

    public void setObjectType(int ObjectType) {
        this.ObjectDataType = ObjectType;
    }


    @Override
    public void setValue(String value, DictionaryOpImpl dictImpl) {
      this.setValueTypePersistance(value, dictImpl);
    }

    
    

   
}


//~ Formatted by Jindent --- http://www.jindent.com
