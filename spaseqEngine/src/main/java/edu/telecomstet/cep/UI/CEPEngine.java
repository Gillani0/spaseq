/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.cep.UI;

import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecomst.graph.processing.GraphEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.engine.optimised.EngineController;
import edu.telecomstet.cep.engine.optimised.Profiling;
import edu.telecomstet.cep.query.helpers.QueryDescriptor;
import edu.telecomstet.cep.query.parser.QueryParser;

import java.io.FileInputStream;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

import javax.xml.datatype.DatatypeConfigurationException;

import net.openhft.koloboke.collect.map.hash.HashLongObjMaps;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

import org.antlr.runtime.RecognitionException;
import org.semanticweb.yars.nx.parser.NxParser;

/**
 *
 * @author sydgillani
 */
public class CEPEngine {
    
     //   private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CEPEngine .class.getName());
    public static void main(String args[]) throws RecognitionException, ParseException, DatatypeConfigurationException, Exception{
        
    	 
          /* The input has 6 parameter
        *******Param1: Input FilePath
        *******Param2: Query number
        *******Param3: Selection starategy, i.e ',' or ';'. This is used for test and can be directly used in the query as well.
        *******Param4: Number of triples in an Event in case of using Ntriple as input, this parameter can be ignored if using an NQuad file as an input
                 // Where the name of the graph defines the boundries of each event
        *******Param5: The window Size, used here for testing and can be directly used within a query
        *******Param6: The File Path for the external Static KB
        
        *************** For instance the parameters can be as following. /wwwTest/datasets/LsBench.nt 6 , 11 200000 "/wwwTest/dataSet/static.nt "
        */
        String q=""; 
         String f=args[0];
         String _strg=args[2];
         int t=Integer.parseInt(args[4]);
         int nT=Integer.parseInt(args[1]);
       
        switch (nT){
            case 1: //stateless Query
                 f="/Users/sydgillani/Documents/wwwTest/datasets/stateless/simpleStateless/data.nq";
                  q=" prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  " +
                        "prefix snvoc: <http://www.ldbc.eu/ldbc_socialnet/1.0/vocabulary/>  " +
                        "prefix sn: <http://www.ldbc.eu/ldbc_socialnet/1.0/data/> " +
                        
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                        
                        "prefix foaf: <http://xmlns.com/foaf/0.1/> " +
                        "prefix dbpedia: <http://dbpedia.org/resource/>  "
                               + " SELECT ?tag "+
                         " WITHIN 122 MINUTES "+
                "FROM STREAM S1 <http://example.org/main>  "
               
                         + "WHERE   "
                         + " SEQ (A, B) "
                           + "{"
                + " DEFINE GPM A ON S1 "
          
                  +" { "
                          + "?x snvoc:hasCreator ?p1. " 
                        +" ?p1 snvoc:likes ?l1. "
                          +"?l1 snvoc:hasPost ?ps1. "
                          +"?ps1 snvoc:hasTag  ?tag1. "
                          +"?ps1  snvoc:hasInfo ?info1. "
                          +"?ps1  snvoc:hasName  ?name1. "
                          
                          
                          
                          
                          
                        + " }"
                        +" DEFINE GPM B ON S1 "
                        +"{ "
                      + "?x2 snvoc:hasCreator2 ?p2. " 
                        +" ?p2 snvoc:likes2 ?l2. "
                          +"?l2 snvoc:hasPost2 ?ps2. "
                          +"?ps2 snvoc:hasTag2  ?tag2. "
                          +"?ps2  snvoc:hasInfo2 ?info2. "
                          +"?ps2  snvoc:hasName2  ?name2. "
                          
                             + " }"
                        // +" DEFINE GPM C ON S1 "
                        //+"{ ?x snvoc:livingFor ?l1."
                       // + "  ?x snvoc:goingFor ?go. }"
                + "}";
                break;
                
            case 2://Stateful Query
                 f="/Users/sydgillani/Documents/wwwTest/datasets/stateful/simpleStateFul/data.nq";
                 q=" prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  " +
                        "prefix snvoc: <http://www.ldbc.eu/ldbc_socialnet/1.0/vocabulary/>  " +
                        "prefix sn: <http://www.ldbc.eu/ldbc_socialnet/1.0/data/> " +
                        
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                        
                        "prefix foaf: <http://xmlns.com/foaf/0.1/> " +
                        "prefix dbpedia: <http://dbpedia.org/resource/>  "
                               + " SELECT ?tag "+
                         " WITHIN 122 MINUTES "+
                "FROM STREAM S1 <http://example.org/main>  "
               
                         + "WHERE   "
                         + " SEQ (A, B) "
                           + "{"
                + " DEFINE GPM A ON S1 "
          
                  +" { "
                          + "?x snvoc:hasCreator ?p1. " 
                        +" ?p1 snvoc:likes ?l1. "
                          +"?l1 snvoc:hasPost ?ps1. "
                          +"?ps1 snvoc:hasTag  ?tag1. "
                       //   +"?ps1  snvoc:hasInfo ?info1. "
                        //  +"?ps1  snvoc:hasName  ?name1. "
                          
                          
                          
                          
                          
                        + " }"
                        +" DEFINE GPM B ON S1 "
                        +"{ "
                      + "?x snvoc:hasCreator2 ?p2. " 
                        +" ?p2 snvoc:likes2 ?l2. "
                          +"?l2 snvoc:hasPost2 ?ps2. "
                          +"?ps2 snvoc:hasTag2  ?tag2. "
                         +"?ps1  snvoc:hasInfo2 ?info2. "
                        //  +"?ps2  snvoc:hasName2  ?name2. "
                          
                             + " }"
                        // +" DEFINE GPM C ON S1 "
                        //+"{ ?x snvoc:livingFor ?l1."
                       // + "  ?x snvoc:goingFor ?go. }"
                + "}";
                break;
                        
            case 3://Stateful Complex Filter Query
                 f="/Users/sydgillani/Documents/wwwTest/datasets/stateful/complexFilter/data.nq";
                 q=" prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  " +
                        "prefix snvoc: <http://www.ldbc.eu/ldbc_socialnet/1.0/vocabulary/>  " +
                        "prefix sn: <http://www.ldbc.eu/ldbc_socialnet/1.0/data/> " +
                        
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                        
                        "prefix foaf: <http://xmlns.com/foaf/0.1/> " +
                        "prefix dbpedia: <http://dbpedia.org/resource/>  "
                               + " SELECT ?tag "+
                         " WITHIN 122 MINUTES "+
                "FROM STREAM S1 <http://example.org/main>  "
               
                         + "WHERE   "
                         + " SEQ (A, B) "
                           + "{"
                + " DEFINE GPM A ON S1 "
          
                  +" { "
                        
                          +"?ps1 snvoc:hasTag  ?tag1. "
                         +"?ps1  snvoc:hasInfo ?info1. "
                         +"?ps1  snvoc:hasName  ?name1. "
                          
                          
                          
                          
                          
                        + " }"
                        +" DEFINE GPM B ON S1 "
                        +"{ "
                     
                          +"?ps2 snvoc:hasTag2  ?tag2. "
                         +"?ps1  snvoc:hasInfo2 ?info2. "
                         +"?ps2  snvoc:hasName2  ?name2. "
                          
                             + " Filter (?tag2 > ?tag1). }"
                        // +" DEFINE GPM C ON S1 "
                        //+"{ ?x snvoc:livingFor ?l1."
                       // + "  ?x snvoc:goingFor ?go. }"
                + "}";
                break;
                
                 case 4://Stateful Complex Filter Query with three states
                 f="/Users/sydgillani/Documents/wwwTest/datasets/rdfPostStream1000.nq";//stateful/complexFilter/data2.nq";
                // f="/Users/sydgillani/Desktop/Desktop-August-2015/dataSet/3KPU.nq";
                     q=" prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  " +
                        "prefix snvoc: <http://www.ldbc.eu/ldbc_socialnet/1.0/vocabulary/>  " +
                        "prefix sn: <http://www.ldbc.eu/ldbc_socialnet/1.0/data/> " +
                        
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                        
                        "prefix foaf: <http://xmlns.com/foaf/0.1/> " +
                        "prefix dbpedia: <http://dbpedia.org/resource/>  "
                               + " SELECT ?tag "+
                         " WITHIN 122 MINUTES "+
                "FROM STREAM S1 <http://example.org/main>  "
               
                         + "WHERE   "
                         + " SEQ (A, B, C) "
                           + "{"
                + " DEFINE GPM A ON S1 "
          
                  +" { "
                        
                          +"?ps1 snvoc:hasTag  ?tag1. "
                         +"?ps1  snvoc:hasInfo ?info1. "
                         +"?ps1  snvoc:hasName  ?name1. "
                          
                          +"GRAPH <http://www.backgroundKB.com> { ?ps1 snvoc:worksFor ?w. "
                             + " ?w snvoc:haslikes ?l1. "
                             + " ?w snvoc:livingIn ?living. }"
                          
                          
                          
                        + " }"
                        +" DEFINE GPM B ON S1 "
                        +"{ "
                     
                          +"?ps2 snvoc:hasTag2  ?tag2. "
                         +"?ps2  snvoc:hasInfo2 ?info2. "
                         +"?ps2  snvoc:hasName2  ?name2. "
                          
                             + " Filter (?tag2 > ?tag1). }"
                         
                         +" DEFINE GPM C ON S1 "
                       +"{ "
                     
                        +"?ps3 snvoc:hasTag3  ?tag3. "
                        +"?ps3  snvoc:hasInfo3 ?info3. "
                        +"?ps3  snvoc:hasName3  ?name3. "
                          
                             + " Filter (?tag3 > ?tag1 && ?info3 > ?info2). }"
                + "}";
                break;
                
                
                         case 5://Stateful Complex Filter Query with three states
                // f="/Users/sydgillani/Documents/wwwTest/datasets/newNT.nt";//stateful/complexFilter/data2.nq";
                // f="/Users/sydgillani/Desktop/Desktop-August-2015/dataSet/3KPU.nq";
                     q=" prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  " +
                        "prefix sib: <http://www.ins.cwi.nl/sib/vocabulary/> " +
                        "prefix sioc: <http://rdfs.org/sioc/ns#> " +
                        
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                        
                        "prefix foaf: <http://xmlns.com/foaf/0.1/> " +
                        "prefix dbpedia: <http://dbpedia.org/resource/>  "
                               + " SELECT ?tag "+
                         " WITHIN "+t+ " SECONDS "+
                "FROM STREAM S1 <http://example.org/main>  "
               
                         + "WHERE   "
                         + " SEQ (A"+_strg+" B; C; D) "
                           + "{"
                + " DEFINE GPM A ON S1 "
          
                  +" { "
                        +"?person sioc:creator_of ?post. "
                        
                          
                        + " } "
                        +" DEFINE GPM B ON S1 "
                        +"{   ?post sib:hashtag ?tag. "
                         
                         
                          
                             + "  }"
                             
                               + " DEFINE GPM C ON S1 "
          
                  +" { "
                        +"?person sioc:creator_of ?post2. "
                        
                          
                        + " }"
                             
                               +" DEFINE GPM D ON S1 "
                        +"{   ?post2 sib:hashtag ?tag2. "
                             + ""
                         +"   Filter (?tag2 = ?tag)."
                         
                          
                             + "  }"
                         
                      //   +" DEFINE GPM C ON S1 "
                       //+"{ "
                     
                      
                          
                         //    + " }"
                + "}";
                break;
                
                
                             
                               case 6://Stateful Complex Filter Query with three states
                // f="/Users/sydgillani/Documents/wwwTest/datasets/newNT.nt";//stateful/complexFilter/data2.nq";
                // f="/Users/sydgillani/Desktop/Desktop-August-2015/dataSet/3KPU.nq";
                     q=" prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  " +
                        "prefix sib: <http://www.ins.cwi.nl/sib/vocabulary/> " +
                        "prefix sioc: <http://rdfs.org/sioc/ns#> " +
                        
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                        
                        "prefix foaf: <http://xmlns.com/foaf/0.1/> " +
                        "prefix dbpedia: <http://dbpedia.org/resource/>  "
//                        + " CONSTRUCT {  ?person sioc:creator_of sib:newStuff."
//                        + "   ?post sib:hashtag ?tag2. } "+
                   +" SELECT ?person "+
                         " WITHIN "+t+" SECONDS "+
                          "  partition by (?person)  "+
                "   FROM STREAM S1 <http://example.org/main>  "
               
                         + "WHERE   "
                         + " SEQ (A"+_strg+" B) "
                           + "{"
                + " DEFINE GPM A ON S1 "
          
                  +" { "
                        +" ?person sioc:creator_of ?post. "
                          +" ?post sib:hashtag ?tag. "
                          
                        + " } "
                      
                             
                               + " DEFINE GPM B ON S1 "
          
                  +" { "
                        +" ?person sioc:creator_of ?post2. "
                         +"  ?post2 sib:hashtag ?tag2. "
                             + "  Filter (?tag2 = ?tag).  "
                             + " } "
                          
                   //  + " Filter (?tag2 = ?tag). }"
                             
                          
                         
                     
                + "}";
                break;
                
                
        }
        
        
        
        
        
        
     
        
    /*    String
               q=" prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  " +
                        "prefix snvoc: <http://www.ldbc.eu/ldbc_socialnet/1.0/vocabulary/>  " +
                        "prefix sn: <http://www.ldbc.eu/ldbc_socialnet/1.0/data/> " +
                        
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                        
                        "prefix foaf: <http://xmlns.com/foaf/0.1/> " +
                        "prefix dbpedia: <http://dbpedia.org/resource/>  "
                               + " SELECT ?tag "+
                         " WITHIN 122 MINUTES "+
                "FROM STREAM S1 <http://example.org/main>  "
               
                         + "WHERE   "
                         + " SEQ (A, B) "
                           + "{"
                + " DEFINE GPM A ON S1 "
          
                  +" { ?x snvoc:hasInfo ?p. " 
                        +" ?x snvoc:famousFor ?f. "
                        + " }"
                        +" DEFINE GPM B ON S1 "
                        +"{ ?x snvoc:hasInfo2 ?l1."
                        + "  ?x snvoc:famousFor2 ?go. "
                + "Filter (?l1>?f) }"
                        // +" DEFINE GPM C ON S1 "
                        //+"{ ?x snvoc:livingFor ?l1."
                       // + "  ?x snvoc:goingFor ?go. }"
                + "}";
                        
                        */
                        
               
        
       
        //TODO: Send this queue to the input reader and the 
        //LinkedBlockingQueue<GraphEvent> inputQueue = new   LinkedBlockingQueue<>();  
        BlockingQueue<GraphEvent> inputQueue = new ArrayBlockingQueue<GraphEvent>(100000);
        DictionaryOpImpl dictimpl = new DictionaryOpImpl();
      
        final QueryDescriptor descriptor = QueryParser.parse(q, dictimpl,"");//"/Users/sydgillani/Documents/wwwTest/datasets/stateless/simpleStateless/externalKB.nq");
        
        
        EngineController myEngineController = new EngineController();
        
        
        myEngineController.setDict(dictimpl);
       // myEngineController.setNFADataList( descriptor.getNfaDataList());
        myEngineController.setConstrcutClaue( descriptor.getConstRules());
       
        myEngineController.setInputQueue(inputQueue);
        
        final CountDownLatch latch = new CountDownLatch(2);
        
       // String f="/Users/sydgillani/Documents/wwwTest/datasets/stateful/complexFilter/data.nq";
        FileInputStream is = new FileInputStream(f);
        NxParser nxp = new NxParser(is);
        
        StreamHandler p = new StreamHandler(inputQueue,"Input Handler", 0,nxp,dictimpl,2);
        p.setLatch(latch);
        System.out.println("Starting the Stream .....");
        new Thread(p).start();
       // myEngineController.setInput(nxp);
       // myEngineController.setGraphSize(Integer.parseInt(args[3]));
        myEngineController.initializeEngine();
        //myEngineController.runEngine();
        myEngineController.getMyEngine().setLatch(latch);
        new Thread(   myEngineController.getMyEngine()).start();
		
      //  System.out.println("\nProfiling results for repeat No. are as follows:");
        
      // Profiling.printProfiling(nT,f);
        System.out.println("Process Ended");
     //  Profiling.printProfiling();
      //   log.trace( Profiling.printProfiling(nT,f));
        
    }
}
