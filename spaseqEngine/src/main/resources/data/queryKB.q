                      
                       
                        prefix c: <http://example/company#> 
                        
                        prefix pred: <http://example/>
                        
                       

                        SELECT ?company ?name ?phone ?url
                         WITHIN 100 SECONDS 
                    
                 FROM STREAM S1 <http://example.org/main> 
               
                        WHERE 
                         SEQ (A; B; C)
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
                          
                            Filter (?p2 > ?p1 ).
                            
                             }
               


                                DEFINE GPM C ON S1
          
                  {
                       
                          ?company pred:price ?p3.
                          ?company pred:volume ?vol3. 

                          GRAPH <http://www.example.com/kb>
                          {
                          ?company pred:name ?name.
                          ?company pred:phone ?phone.
                          ?company pred:url ?url.
                            ?company pred:lang ?lang.

                          }
                          
                            Filter (?p3 < ?p2).  
                             }
              
                     
              }