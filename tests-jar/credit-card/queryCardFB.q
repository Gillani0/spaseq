 prefix c: <http://example/card#> 
                        
                        prefix pred: <http://example/>
                        
                       

                        SELECT ?card ?amount1 ?amount2
                         WITHIN 100 SECONDS 
                        
                 FROM STREAM S1 <http://example.org/main> 
               
                        WHERE 
                         SEQ (A; B)
                           {
       DEFINE GPM A ON S1
                 { 
                  ?card pred:id ?id.
                  ?card pred:amount ?amount1. 
                  } 
                      
                             
         DEFINE GPM B ON S1
                  {
 				  ?card pred:id ?id2.
                  ?card pred:amount ?amount2. 
					Filter (?id2 = ?id1 && ?amount2 < ?amount1 ).
                   }

           
     
                     
              }