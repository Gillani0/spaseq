/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.utils;

import java.util.Date;

import org.semanticweb.yars.nx.Literal;





/**
 *
 * @author sydgillani
 */
public class LiteralComparisonImpl implements LiteralComparison {
    
    
 
    
    @Override
    public boolean evaluateInteger(Literal objLiteral,Literal obj2Literal,String filterOprd){
        
      ////over here check if the filter flag is true and the and its of second type
        ////then sort the Multimap accroding to Literal.intVal and then compare according to the filteoperand
        
        
        
    	final int oInteger2;
    	final int oInteger1;
    	///convert it to Integer
       try{
    	 oInteger2=Integer.parseInt(obj2Literal.getValue().toString());
    	 oInteger1=Integer.parseInt(objLiteral.getValue().toString());
       }catch(Exception ex){
    	   return false;
       }
       
               
             //  System.out.println(f.floatValue());
               //System.out.println(objLiteral.floatValue());
                if(filterOprd.equals(">") &&oInteger2 >  oInteger1 ){
                    return true;
                }else if(filterOprd.equals("<") && oInteger2 <  oInteger1){
                    return true;
                }else if(filterOprd.equals("<=") && oInteger2 <=  oInteger1){
                      return true;
                }else if(filterOprd.equals(">=") && oInteger2 >= oInteger1){
                      return true;
                }
               
                    
         
       
   
    
     
        
        
        return false;
        
    }
    
    
    
    
    @Override
    public boolean evaluateDateTime(Literal objLiteral,Literal obj2Literal,String filterOprd){
        
        
        ///if the size of the incoming table is greater than 10 only then sort it, otherwise dont do it.
        
  
               
             //  System.out.println(f.floatValue());
               //System.out.println(objLiteral.floatValue());
    	
    	try{
                if(filterOprd.equals(">") && ((Date)objLiteral.getValue()).compareTo((Date)obj2Literal.getValue()) < 0 ){
                    return true;
                }else if(filterOprd.equals("<") && ((Date)objLiteral.getValue()).compareTo((Date)obj2Literal.getValue()) > 0){
                    return true;
                }else if(filterOprd.equals("<=") &&  ((Date)objLiteral.getValue()).compareTo((Date)obj2Literal.getValue()) > 0 ||  ((Date)objLiteral.getValue()).compareTo((Date)obj2Literal.getValue()) == 0){
                      return true;
                }else if(filterOprd.equals(">=") &&  ((Date)objLiteral.getValue()).compareTo((Date)obj2Literal.getValue()) < 0 ||  ((Date)objLiteral.getValue()).compareTo((Date)obj2Literal.getValue()) == 0){
                      return true;
                }
               
    	}catch (Exception ex){
    		System.out.println("Data Comparison is not suppoerted in this version of SPAseq");
    	}
         
       
   
        
    
        
        return false;
    }
    
    
    
 /*    @Override
    public boolean evaluateDecimal(Literal objLiteral,Literal obj2Literal,String filterOprd){
        
               
             //  System.out.println(f.floatValue());
               //System.out.println(objLiteral.floatValue());
                if(filterOprd.equals(">") && objLiteral.decimalValue().compareTo(obj2Literal.decimalValue()) == 1 ){
                    return true;
                }else if(filterOprd.equals("<") && objLiteral.decimalValue().compareTo(obj2Literal.decimalValue()) == -1){
                    return true;
                }else if(filterOprd.equals("<=") &&  objLiteral.decimalValue().compareTo(obj2Literal.decimalValue()) == 1 ||  objLiteral.decimalValue().compareTo(obj2Literal.decimalValue()) == 0){
                      return true;
                }else if(filterOprd.equals(">=") &&  objLiteral.decimalValue().compareTo(obj2Literal.decimalValue())== -1 ||   objLiteral.decimalValue().compareTo(obj2Literal.decimalValue()) == 0){
                      return true;
                }
               
                    
         
         return false;
    }*/
  
    @Override
    public boolean evaluateFloat(Literal objLiteral,Literal obj2Literal,String filterOprd){
        
    	final float oFloat2;
    	final float oFloat1;
   	 try{
   	   oFloat2 = Float.valueOf(obj2Literal.getValue().toString().trim()).floatValue();
  	   oFloat1 = Float.valueOf(objLiteral.getValue().toString().trim()).floatValue();
   	 }catch(Exception ex){
       	 return false;
        }
    
               
             //  System.out.println(f.floatValue());
               //System.out.println(objLiteral.floatValue());
                if(filterOprd.equals(">") &&  oFloat2 > oFloat1  ){
                    return true;
                }else if(filterOprd.equals("<") &&  oFloat2 <  oFloat1  ){
                    return true;
                }else if(filterOprd.equals("<=")  &&  oFloat2 <=  oFloat1  ){
                      return true;
                }else if(filterOprd.equals(">=") &&  oFloat2 >= oFloat1 ){
                      return true;
                }
               
                    
         
       
   
        
        return false;
    }
    
    @Override
    public boolean evaluateLong(Literal objLiteral,Literal obj2Literal,String filterOprd){
        
        
        
    	final long olong2;
    	final long olong1;
    	try{
    	olong2=  Long.parseLong(obj2Literal.getValue() .toString());
    	olong1=  Long.parseLong(objLiteral.getValue() .toString());
    	}catch(Exception ex){
    		return false;
    	}
             //  System.out.println(f.floatValue());
               //System.out.println(objLiteral.floatValue());
                if(filterOprd.equals(">") &&  olong2 > olong1 ){
                    return true;
                }else if(filterOprd.equals("<") && olong2 < olong1   ){
                    return true;
                }else if(filterOprd.equals("<=") &&olong2 <= olong1){
                      return true;
                }else if(filterOprd.equals(">=") && olong2 >= olong1){
                      return true;
                }
               
    
      return false;   
       
    }
    
    
    
    
    
        
        
        
     

       //0 int, 8 boolean, string 6, double 4, float 1,datatime 3
    @Override
    public boolean evaluateEventType(Literal objLiteral, Literal obj2Literal, String filterOprd, int type, int order) {
        /// objLiteral is statefull
  //    if(order ==1){
          
          return this.orderSelection(objLiteral, obj2Literal, filterOprd, type);
          
      
//      }else if(order ==0) {
//          
//           return this.orderSelection(obj2Literal,objLiteral,  filterOprd, type);
//          
//          
//          
//       
//      }
        
        
        
        
       // return false;
        
    }

    
    private boolean orderSelection(Literal objLiteral, Literal obj2Literal, String filterOprd, int type){
       
      //  if(objLiteral.getType()==obj2Literal.getType()){
        
        type=obj2Literal.getType();
        
        
        if(type == 10 || type==0){
            return this.evaluateInteger(objLiteral, obj2Literal, filterOprd);
            
        }else if(type == 1){
            return this.evaluateFloat(objLiteral, obj2Literal, filterOprd);
        }else if (type ==3){
           return this.evaluateDateTime(objLiteral, obj2Literal, filterOprd); 
        } else if (type == 6){
            return this.evaluateLong(objLiteral, obj2Literal, filterOprd);
            
        } else if(type ==4){
            return this.evaluateDouble(objLiteral, obj2Literal, filterOprd);
        }
        //}
        return false;
    }

    @Override
    public boolean evaluateDouble(Literal objLiteral, Literal obj2Literal, String filterOprd) {
    	
    	final double oDouble2;
    	final double oDouble1;
    	try{
    	 oDouble2 = Double.parseDouble(obj2Literal.getValue().toString() );
    	 oDouble1 = Double.parseDouble(objLiteral.getValue().toString() );
    	//   System.out.println(aDouble);
    	}catch(Exception ex){
    		return false;
    	}
    	
       if(filterOprd.equals(">") &&  oDouble2 > oDouble1  ){
                    return true;
                }else if(filterOprd.equals("<") &&  oDouble2 < oDouble1 ){
                    return true;
                }else if(filterOprd.equals("<=") &&  oDouble2 <=oDouble1 ){
                      return true;
                }else if(filterOprd.equals(">=") &&  oDouble2 >= oDouble1 ){
                      return true;
                }
      
        return false;
    }
    
}
