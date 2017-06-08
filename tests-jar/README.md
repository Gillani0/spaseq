
## Running Tests using Jar File

If you would like to use the Jar file to run test, this directyory contains the required jar file and the associated data and query files for the SPAseq queries. 


### Prerequisites

You nust have `Java 8' installed on your machine. Then Run the following command in the tests-jar directory for the respective SPAseq operators. Note that the results of each test are stored in the [result/queryResults.txt](https://github.com/Gillani0/spaseq/blob/master/tests-jar/result/queryResults.txt) file.



#### Followed-by Operator

```
java -jar spaseq.jar -s followedby/streamFB.txt -q followedby/queryFB.q -st false -t true
```

#### Immediately Followed-by Operator

```
java -jar spaseq.jar -s immediatefb/streamIF.txt -q immediatefb/queryIF.q -st false -t true
```

#### Conjunction Operator

```
java -jar spaseq.jar -s conjunction/streamConjunction.txt -q conjunction/queryConjunction.q -st false -t false
```

#### Disjunction Operator

```
java -jar spaseq.jar -s disjunction/streamDisjunction.txt -q disjunction/queryDisjunction.q -st false -t true
```


#### Kleene+ Operator

```
java -jar spaseq.jar -s kleeneplus/streamKleene.txt -q kleeneplus/queryKleene.q -st false -t true
```


#### For Multiple Streams (streamset)

For Random generation

```
java -jar spaseq.jar -s multistreams/streamMulti.txt -q multistreams/queryMultiStream.q -st true -t true
```

For Sequence-based generation

```
java -jar spaseq.jar -s multistreams/streamMulti.txt -q multistreams/queryMultiStream.q -st false -t true
```

#### Optional Operator

```
java -jar spaseq.jar -s optional/streamOptional.txt -q optional/queryOptional.q -st false -t true
```


#### Negation Operator

```
java -jar spaseq.jar -s negation/streamNegation.txt -q negation/queryNegation.q -st false -t true
```

#### External Knowledge Base Test

```
java -jar spaseq.jar -s externalknowledgebase/streamKB.txt -q externalknowledgebase/queryKB.q -st false -t true -kb externalknowledgebase/externalKB.nt 
```



