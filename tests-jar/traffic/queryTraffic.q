                      
                       
                        prefix ssn: <http://purl.oclc.org/NET/ssnx/ssn#> 
                          prefix sao:<http://purl.oclc.org/NET/sao/ssn#> 
                        prefix val: <http://www.smart.com/>
                        
                        prefix env: <http://www.smart.com/environmental#>
                       

                        SELECT  ?v1 ?v2 
                         WITHIN 1000 SECONDS 
                       
                 FROM STREAM S1 <http://www.smart.com/sensor1> 
                 FROM STREAM S2 <http://www.smart.com/sensor2> 
               
                        WHERE 
                         SEQ (A;B)
                           {
              DEFINE GPM A ON S1
          
                 { 
                        ?traffic ssn:observedProperty ?p1.
                          ?traffic ssn:observedBy ?sensor1. 
                          ?traffic sao:hasValue ?v1.
                           Filter (?v1 >= '3'^^<http://www.w3.org/2001/XMLSchema#integer>)
                         } 
                      
                             
                                DEFINE GPM B ON S2
          
                           {
                         
                          ?traffic2 ssn:observedProperty ?p2.
                          ?traffic2 ssn:observedBy ?sensor2. 
                          ?traffic2 sao:hasValue ?v2.
                             Filter (?v2 >= '3'^^<http://www.w3.org/2001/XMLSchema#integer>)
                         
                          
                             }
               


                            
                     
              }