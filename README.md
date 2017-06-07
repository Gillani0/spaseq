# SPAseq: Sematic Complex Event Processing

SPAseq is a query langauge that extends SPARQL to enable Complex Event Processing over RDF Graph Streams. It supports expressive operators such as sequencing, Kleene+, Conjunction, Disjunction. The complete list of operators and their functionality is described in corresponding publication.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 


### Prerequisites

What things you need to install the software and how to install them

```
Java 8
Maven
Eclipse or Netbeans
```

### Installing (As a Java Project)

Clone the porject on your local computer and open the maven project in your editor:
```
git clone https://github.com/Gillani0/spaseq.git
cd spaseq-master
mvn install
```
After importing, you will have follwing five main project modules (Don't forget to run: mvn install):
```
spaseqEngine, spaseqModels, spaseqQueyParser, streamparser
```

Note that in Eclipse, after importing the project, you might have cyclic dependencies error. In order to solve it follow the following steps:

In Eclipse go to:


```
Windows -> Preferences -> Java-> Compiler -> Building -> Circular Dependencies: change the circular dependency error to warning.
```


The main module in the spaseq project to look for is `spaseqEngine`, where in UI package `SpaseqMainEngine.java` is the entry point of all the operations. It requires a set of arguments to start the engine. These arguments are defined as follows:

```
Usage: java -jar spaseq.jar [-s <STRING>] [-t <STRING>] [-q <STRING>] [-st <STRING>]
-s,--streamfile <arg> Paths and prefixes of input stream files located in .stream file
-t, --timestamps <arg> Take the timestamps from the input files (in form of a triple): false, use the system timestamps: true
-q,--query <arg> Input query file
-st,--streamtype <arg> Stream type for multiple streams, true: for random generation of events, false: for sequential-based generation
-kb,--knbase <arg> optional external KB file in N-Triples format 
-h,--help show help
```
#### Stream File 
The stream file (`-s` option) binds the location of the streams with the stream names used in the SPAseq queries. For example the following stream file is used for the multistream.

```
<http://www.smart.com/power> <../data/power.nt> 5
<http://www.smart.com/environmental> <../data/environmental.nt> 5
<http://www.smart.com/generation> <../data/generation.nt> 5
```
Each line of the stream file is a triple, where the subject is the stream name used in the query, the predicate is the location of the stream file (on your computer) and object is the number of triples to be used from the input file within one single graph event. For instance, in the above stream file the power stream with name `<http://www.smart.com/power>` is located as `<../data/power.nt>` (N-Triples format) and for each event `5` triples will be used.
#### Timestamps
The timestamps option (`-t`) sets if the source or system timestamps have to be used. That is for `-t false`, if the input file is an N-Triple format and there are two triple for an event, then the third triple will be the timestamp of that event contains the timestamps of the triples, then it uses them for the events. For instance, the following N-Triples has two triples for an event and the thrid one for the timestamp. This configuration is usually used for the cojunction operator.

```
<http://example/company#Google> <http://example/volume> "29.83"^^<http://www.w3.org/2001/XMLSchema#double> .
<http://example/company#Google> <http://example/price> "14.0"^^<http://www.w3.org/2001/XMLSchema#double> .
<http://example/company#Google> <http://example/occursat> "10"^^<http://www.w3.org/2001/XMLSchema#date> .
```
The `-t true` option shows that the events are timestamps with the system time when they enter the SPAseq engine.


#### Stream Type
This stream type option (`-st`) is for testing multiple streams, where `true` means the events from the multiple stream files are selected randomly and sent to the engine, while the `false` means the events are sent in a sequential order where the ording is according to the defined ordering in the stream file. For instance, for the afromentioned stream file, if the options is `false`, then first a power stream event is parsed, then the environemnt stream event and then generation event: each one by one in a sequential order.

#### Query File
The query file option (`-q`) is self explanatory and contains the well structured SPAseq queries. For example the following queries is used to match sequences over events from the three streams namely: `power`, `environmental` and `generation`
```
prefix power: <http://www.smart.com/power#> 
prefix val: <http://www.smart.com/>
prefix env: <http://www.smart.com/environmental#>
SELECT ?house1 ?p1  
WITHIN 1000 SECONDS 
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
Filter (?wsped >= '1'^^xsd:integer && ?heat >= '7.0'^^xsd:double)
    }
 DEFINE GPM C ON S3
 {
?house1 power:haspower ?pw2.
?pw2 val:watt ?watt2. 
 ?pw2 val:price ?p2.
 Filter (?p2 <= ?p1)
   }
 }
```



#### Knowledge Base
This knowledge base option (`-kb`) takes an external knowledge base file (an N-Triples format file) as an input to be used with the events. Note that you have to provide the `GRAPH` clause in the SPAseq query for it to be used.


## Running the tests

A set of test data, queries and stream files are provided in the [Test folder](http://www.dropwizard.io/1.0.2/docs/) with a compressed [Jar file](http://www.dropwizard.io/1.0.2/docs/): if you do not want to download the whole code and would like to use a Jar file instead, use this folder. Its usage is as follows:


```
Usage: java -jar spaseq.jar [-s <STRING>] [-q <STRING>] [-st <String>] [-kb <String>]
```
For instance, the following command can used to test the multiquery processing: 

```
java -jar spaseq.jar -s ./streamMulti -q queryMultiStream.q -st false 
```
The following command can be used to test the `followed-by` operator

```
java -jar spaseq.jar -s ./streamFB -q queryFB.q -st false 
```

Note that the results of the queries are stored in the `result` folder in file `queryResults.txt`.



## Contributing

Please read [CONTRIBUTING.md]() for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Syed Gillani** - *main contributor* -
* **Antoine Zimmerman** - *co-author* - 
* **Guthier Picard** - *co-author* - 
* **Frédéric Laforest** - *co-author* - 

## License

This project is licensed under the MIT License.

## Acknowledgments

* Special thanks to Abderrahmen Kammoun for the rigorous testing


