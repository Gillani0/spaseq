# SPAseq: A Language for the CEP over RDF graph streams

You find here all the necessary materials for SPAseq. The whole project is distributed into three packages including [`SPAseqEngine`](https://bitbucket.org/syd12/spaseq), [`GraphStreamController`](https://bitbucket.org/syd12/streamcontroller/overview), [`GraphQueryParser`](https://bitbucket.org/syd12/queryparser), [`GraphEngineModel`](https://bitbucket.org/syd12/graphenginemodel), [`GraphEngine`](https://bitbucket.org/syd12/graphenginecgpm/overview).
## Installation

First fork all the above mentioned packages into your own account: click on the Fork icon on this page.
Clone the forked project on your computer. Import the project in Eclipse via Import->Maven Project. Please make sure all the packages area added as a dependencies for the main project. 

### Running the system
Two main classes are at your disposal, the first one [`CEPEngine`](https://bitbucket.org/syd12/spaseq/src/154049900cd2ac7c6e35949ea9422a9f7725d368/src/main/java/edu/telecomstet/cep/UI/CEPEngine.java?at=default&fileviewer=file-view-default), is used for the single stream LsBench tests. The second one [`CEPEngineMultiStream`](https://bitbucket.org/syd12/spaseq/src/154049900cd2ac7c6e35949ea9422a9f7725d368/src/main/java/edu/telecomstet/cep/UI/CEPEngineMultipleStreams.java?at=default&fileviewer=file-view-default) is used for the multi stream case study test.

## Queries for the test 
###LsBench Queries

### Q4
                    prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>     
                    prefix xsd: <http://www.w3.org/2001/XMLSchema#>      
                    prefix sib: <http://www.ins.cwi.nl/sib/vocabulary/>     
                    prefix sioc: <http://rdfs.org/sioc/ns#>     
                    prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>   
                        
                       
                          SELECT ?tag,?person    
                           
                           WITHIN  180   SECONDS  
                           PATITION BY (?person)  
                           FROM STREAM S1 <http://example.org/main>   
               
                             WHERE    
                              {
                            
                             SEQ (A ; B; C; D)  
                             
                             DEFINE GPM A ON S1  
          
                              {  
                           
                           ?person sioc:creator_of ?post.  
                        
                          
                             }  
                           
                            DEFINE GPM B ON S1  
                            {  
                            ?post sib:hashtag ?tag.  
     
                            } 
                             
                           DEFINE GPM C ON S1  
          
                           {  
                           ?person sioc:creator_of ?post2.  

                           } 
                             
                           DEFINE GPM D ON S1  
                           
                           {   
                           ?post2 sib:hashtag ?tag2.  
                                  
                           Filter (?tag2 = ?tag). 
                          } 
                     
                    }
###Q4*


                     prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>     
                     prefix xsd: <http://www.w3.org/2001/XMLSchema#>      
                     prefix sib: <http://www.ins.cwi.nl/sib/vocabulary/>     
                     prefix sioc: <http://rdfs.org/sioc/ns#>     
                     prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>   
                        
                       
                           SELECT ?tag,?person    
                           WITHIN  180   SECONDS  
                           PATITION BY (?person)  
                           FROM STREAM S1 <http://example.org/main>   
               
                             WHERE    
                             {
                             
                              SEQ (A ; B)  
                             
                               


                            DEFINE GPM A ON S1  
          
                              {  
                           
                           ?person sioc:creator_of ?post.  
                           ?post sib:hashtag ?tag.  
                          
                             }  
                           
                            DEFINE GPM B ON S1  
                            {  
                           ?person sioc:creator_of ?post2.  
                             ?post2 sib:hashtag ?tag2.  
                                  
                           Filter (?tag2 = ?tag). 
                            } 
                             
                           
                     
                    }

###Queries for the SmartGrid UseCases
###Q1 (UC1)


                PREFIX : <http://www.purl.org/net/v2/prosg#>
 
      Construct {
      ?h hasCurrentPower ?power.
      ?h hasPowerSource ?source1.
      ?h hasUnitofPower ?unit.
      ?h hasCurrentPrice ?price.
      ?h hasLocation ?l.
      ?power hasStartTime ?t1.
      ?power hasEndTime ?t2.
         }

       WITHIN 24 hours
     FROM STREAM S1 <http://www.smartgrid/powerevets>
     FROM STREAM S2 <http://www.smartgrid/storageevents>
     FROM STREAM S3 <http://www.smartgrid/weatherevents>
      
      WHERE
      {
       SEQ (A, B, C*)

      GPM A on S1 
       {
       
       ?h :hasPowerSource ?source1.
       ?h :hasLocation ?l.
       ?h hasCurrentPrice ?price.
       ?h :hasCurrentPower ?power.
       ?h :hasUnitofPower ?unit.
       ?h hasCurrentTime ?t1.

        Graph <http://www.smartgrid/ForcastValues> 
           {
        
          ?h :hasForcastValue ?fPower.
          ?h :hasForcastTime ?t2.
            }

        Filter(?power < 10 && ?fPower < 10)
       }

       GPM B on S2 
        {

         ?h :hasStorageSource ?s.
         ?s :hasCurrentPower ?sPower.

         Filter(?sPower >fPower)
         }

          GPM C on S3 
         {
        
         ?source1 :hasWeatherDependability ?d1.
         ?d1 :hasCurrentWeatherConditions ?w1.

        Graph <http://www.smartgrid/ForcastValues>
          {
         ?d1 :hasForcastValue ?v1
          }
         Filter (?v1 >= ?w1)

            }


          }

###Q2 (UC2)
     
             PREFIX : <http://www.purl.org/net/v2/prosg#>
 
      Select ?house2,?price2

       WITHIN 24 hours
     FROM STREAM S1 <http://www.smartgrid/powerevets>
     FROM STREAM S2 <http://www.smartgrid/storageevents>
     FROM STREAM S3 <http://www.smartgrid/weatherevents>
      
      WHERE
     {
     SEQ (A, !B, C)

      GPM A on S1 
       {
       
       ?h :hasPowerSource ?source1.
       ?h :hasLocation ?l.
       ?h hasCurrentPrice ?price.
       ?h :hasCurrentPower ?power.
       ?h :hasUnitofPower ?unit.
       ?h hasCurrentTime ?t1.

        Graph <http://www.smartgrid/ForcastValues> 
           {
        
          ?h :hasForcastValue ?fPower.
          ?h :hasForcastTime ?t2.
            }

        Filter(?power >10 && ?fPower > 10)
       }

       GPM B on S2 
        {

         ?h :hasStorageSource ?s.
         ?s :hasCurrentPower ?sPower.

         Filter(?sPower > fPower)
         }

          GPM C on S3 
         {
        
         ?h2 hasCurrentPower ?power2.
 
      ?h2 hasUnitofPower ?unit2.
      ?h2 hasCurrentPrice ?price2.
      ?h2 hasLocation ?l2.
      ?power2 hasStartTime ?Ot1.
      ?power2 hasEndTime ?Ot2.

          Filter (?price2 <= ?price && ?Ot2 >= ?t1 && ?ot2 <= ?t2)

          }