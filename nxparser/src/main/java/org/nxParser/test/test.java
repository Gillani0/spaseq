package org.nxParser.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.parser.NxParser;

public class test {
	  
	   public static void main(String[] args) throws FileNotFoundException,
				Exception {
	       
	       FileInputStream is = new FileInputStream("/Users/sydgillani/Documents/CEPProj/queries/stocks.nt");
	String n="120";
	
	 org.semanticweb.yars.nx.Literal objLit = new  org.semanticweb.yars.nx.Literal(n); 

			NxParser nxp = new NxParser(is);
	                Node[] nxx = null;
	                Node s=null;
	             int i=0;
	                
	        	 System.out.println("Runnung");
	        	 long t1=System.nanoTime();
	               	while (nxp.hasNext()) {
				nxx = nxp.next();
	                       ///nxx[0] subject
	                        //nxx[1] predicate
	                        //nxx[2] object ///
	                        Node j=nxx[2];
	                        //object can be literal or simple uri
	                        ///
	                        i++;
	                       if(i==6){
	                            
	                    	//double b= (double) ( (org.semanticweb.yars.nx.Literal)nxx[2]).getValue();
	                     if(objLit.equals((org.semanticweb.yars.nx.Literal)nxx[2])){
	                                System.out.println("Done");
	                            }
	                            
	                       }
	                     
	                        
	                                  }
	               	
	               	
	               	long t2= (System.nanoTime()-t1)/1000000;
	               	
	                System.out.println("Time "+t2+" Done");
	               	
	}
}
