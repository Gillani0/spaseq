                      
                       
                        prefix power: <http://www.smart.com/power#> 
                        
                        prefix val: <http://www.smart.com/>
                        
                        prefix env: <http://www.smart.com/environmental#>
                       

                        SELECT ?house1 ?p1 ?p2 ?v
                         WITHIN 1 SECONDS 
                       
                 FROM STREAM S1 <http://www.smart.com/power> 
                 FROM STREAM S2 <http://www.smart.com/environmental> 
                 FROM STREAM S3 <http://www.smart.com/generation>  
               
                        WHERE 
                         SEQ (A;B;C)
                           {
              DEFINE GPM A ON S1
          
                 { 
                        ?house1 power:haspower ?pw1.
                          ?pw1 val:watt ?watt1. 
                          ?pw1 val:price ?p1.
                          
                         } 
                      
                             
                                DEFINE GPM B ON S2
          
                           {
                         
                           ?wthr env:hasvalue ?v.
                           ?v val:windspeed ?wsped. 
                            ?v val:heatindex ?heat. 
                           Filter (?wsped >= '1'^^<http://www.w3.org/2001/XMLSchema#integer> && ?heat >= '7.0'^^<http://www.w3.org/2001/XMLSchema#double>)
                         
                          
                             }
               


                                DEFINE GPM C ON S3
          
                  {
                       ?house1 power:haspower ?pw2.
                           ?pw2 val:watt ?watt2. 
                          
                         ?pw2 val:price ?p2.

                                Filter (?p2 <= ?p1)
                         
                          
                           
                             }
              
                     
              }