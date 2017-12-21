 prefix c: <http://example/company#> 
                        
                        prefix pred: <http://example/>
                        
                       

                        SELECT ?company ?p1
                         WITHIN 100 SECONDS 
                        
                 FROM STREAM S1 <http://example.org/main> 
               
                        WHERE 
                         SEQ (A; B)
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

         
     
                     
              }