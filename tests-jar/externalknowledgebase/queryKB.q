                      
                       
                        prefix c: <http://example/company#> 
                        
                        prefix pred: <http://example/>
                        
                       

                        SELECT ?company ?p1 ?p2 ?p3 ?name ?loc
                         WITHIN 10 SECONDS 
                      Partition by (?company)  
                 FROM STREAM S1 <http://example.org/main> 
               
                        WHERE 
                         SEQ (A, B, C)
                           {
              DEFINE GPM A ON S1
          
                 { 
                        ?company pred:price ?p1.
                          ?company pred:volume ?vol1. 
                          
                         } 
                      
                             
                                DEFINE GPM B ON S1
          
                  {
                       
                          ?company pred:price ?p2.
                          ?company pred:volume ?vol2. 
                          
                            Filter (?p2 < ?p1 ).
                            
                             }
               


                                DEFINE GPM C ON S1
          
                  {
                       
                          ?company pred:price ?p3.
                          ?company pred:volume ?vol3. 

                          GRAPH <http://www.example.com/kb>
                          {
                          ?company pred:name ?name.
                          ?company pred:location ?loc.

                          }
                          
                            Filter (?p3 < ?p2).  
                             }
              
                     
              }