

parser grammar StreamingSparql;

options{
tokenVocab=SparqlLexer;
}

@header {
    package edu.telecomstet.cep.query.sources;

}



query
    : prologue* (selectQuery | constructQuery | describeQuery | askQuery)? valuesClause;

prologue
    : (baseDecl | prefixDecl)
    ;


baseDecl
    : BASE IRIREF
    ; 

prefixDecl
    : PREFIX PNAME_NS IRIREF
    ;

selectQuery
    : (selectClause| constructClause) durantionClause partitionbyClause* streamsetCaluse* whereClause solutionModifier ///In case of DatasetClause use the StreamDataClause
    ;

subSelect
    : selectClause whereClause solutionModifier valuesClause
    ;
    	
selectClause
    : SELECT (DISTINCT | REDUCED)? (selectVariables+ | '*')
    ;

selectVariables
    : var
    | '(' expression AS var ')'
    ;

constructQuery
    : CONSTRUCT (constructTemplate datasetClause* whereClause solutionModifier | datasetClause* WHERE '{' triplesTemplate? '}' solutionModifier)
    ;

describeQuery
    : DESCRIBE (varOrIRI+ | '*') datasetClause* whereClause? solutionModifier
    ;

askQuery
    : ASK datasetClause* whereClause solutionModifier
    ;
constructClause
   : CONSTRUCT groupGraphPattern
   ;
datasetClause
    : FROM NAMED? iri
    ;
durantionClause
         : within
         ;  

partitionbyClause 
         : partition
         ;

partition
: PARTITION BY '(' var (',' var)*')'
;
streamsetCaluse
    : FROM STREAM var3 iri  
    ;    
within
    : WITHIN time unitTime
    ;



window
    : FROM NOW time unitTime
    ;

unitTime
    : (MINUTES|HOURS|SECONDS)
    ;  
whereClause
    : WHERE?  seqBlock '{' (pattBlock)+ '}' 
    ;
//////////////////////////////////New Parts//////////////////////////
seqBlock
    :  SEQUENCE seqConstraints
    ; 

seqConstraints
    : '(' eventPattList  ')' 
    ;

eventPattList
: eventPattern (eventSelection+ eventPattern)*
;

eventSelection
    : ESELECTION ;  

 eventPattern
     :    var3 patternOperation? | '('  var3 eventJoiner var3  (eventJoiner var3)* ')' patternOperation?
     ;
     
 eventUnionOrPattern
    :  eventJoiner var3
    ; 
 
 
 eventJoiner
     :   UNIONOR
     ;    

 pattBlock
     :   eventDefinition groupGraphPattern
     ;     
    
eventDefinition 
    :   DEFINE GPM var3 ON multipleVars 
    ;    
 
multipleVars
    :   var3 (',' var3)*
    ;    

 time
     :  TIME
     ;
/////////////////////////////////////////
solutionModifier
    : groupClause? havingClause? orderClause? limitOffsetClauses?
    ;

groupClause
    : GROUP BY groupCondition+
    ;
    		 
groupCondition
    : builtInCall | functionCall | '(' expression (AS var)? ')' | var
    ;
    
havingClause
    : HAVING havingCondition+
    ;
    
havingCondition
    : constraint
    ;
    
orderClause
    : ORDER BY orderCondition+
    ;

orderCondition
    : (ASC|DESC) '(' expression ')' 
    | constraint 
    | var
    ;
	    
limitOffsetClauses
    : limitClause offsetClause? | offsetClause limitClause?
    ;

limitClause
    : LIMIT INTEGER
    ;

offsetClause
    : OFFSET INTEGER
    ;

valuesClause
    : (VALUES dataBlock)?
    ;
    
updateCommand
    : prologue (update (';' prologue update)* (';' prologue)?)?
    ;

update
    : load | clear | drop | add | move | copy | create | insertData | deleteData | deleteWhere | modify
    ;   
    
load 	  
    : LOAD SILENT? iri (INTO graphRef)?
    ;
    
clear
    : CLEAR  SILENT? graphRefAll
    ;
    
drop
    : DROP SILENT? graphRefAll
    ; 

create
    : CREATE SILENT? graphRef
    ;
    
add
    : ADD SILENT? graphOrDefault TO graphOrDefault
    ;
    
move
    : MOVE SILENT? graphOrDefault TO graphOrDefault
    ;
    
copy
    : COPY SILENT? graphOrDefault TO graphOrDefault
    ;

insertData
    : INSERT DATA quadData
    ;

deleteData
    : DELETE DATA quadData
    ;

deleteWhere
    : DELETE WHERE quadPattern
    ;
    
modify
    : (WITH iri)? (deleteClause insertClause? | insertClause) usingClause* WHERE groupGraphPattern
    ;
  
deleteClause
    : DELETE quadPattern
    ;
      
insertClause
    : INSERT quadPattern
    ;

usingClause
    : USING NAMED? iri
    ;

graphOrDefault	  
    : DEFAULT | GRAPH? iri
    ;
    	    	
graphRef
    : GRAPH iri
    ;

graphRefAll
    : graphRef | DEFAULT | NAMED | ALL
    ;

quadPattern
    : '{' quads '}'
    ;
    
quadData
    : '{' quads '}'
    ;
    
quads
    : triplesTemplate? quadsDetails* 
    ;

quadsDetails
    : quadsNotTriples '.'? triplesTemplate?
    ;

quadsNotTriples
    : GRAPH varOrIRI '{' triplesTemplate? '}'
    ;
    
triplesTemplate
    : triplesSameSubject ('.' triplesSameSubject?)*
    ;
    	
groupGraphPattern
    : '{' (subSelect | groupGraphPatternSub) '}'
    ;
    
groupGraphPatternSub
    : triplesBlock?  groupGraphPatternSubList*
    ;
    
groupGraphPatternSubList
    : graphPatternNotTriples '.'? triplesBlock?
    ;
    
triplesBlock
    :  triplesSameSubjectPath ('.' triplesSameSubjectPath?)*
    ;

graphPatternNotTriples
    : groupOrUnionGraphPattern | optionalGraphPattern | minusGraphPattern | graphGraphPattern | serviceGraphPattern | filter | bind | inlineData
    ;

optionalGraphPattern
    : OPTIONAL groupGraphPattern
    ;

graphGraphPattern
    : GRAPH varOrIRI groupGraphPattern
    ;

serviceGraphPattern
    : SERVICE SILENT? varOrIRI groupGraphPattern
    ;
    
bind
    : BIND '(' expression AS var ')'
    ;
    	
inlineData
    : VALUES dataBlock
    ;

dataBlock
    : inlineDataOneVar | inlineDataFull
    ;

inlineDataOneVar
    : var '{' dataBlockValue* '}'
    ;

inlineDataFull
    : '(' var* ')' '{' dataBlockValues* '}'
    ;

dataBlockValues
    : '(' dataBlockValue* ')'
    ;

dataBlockValue
    : iri | rdfLiteral | numericLiteral | booleanLiteral | UNDEF
    ;

minusGraphPattern
    : MINUS groupGraphPattern
    ;

groupOrUnionGraphPattern
    : groupGraphPattern (UNION groupGraphPattern)*
    ;

filter
    : FILTER constraint
    ;

constraint
    : '(' expression ')' | builtInCall | functionCall
    ;

functionCall
    : iri argList
    ;

argList
    : '(' (DISTINCT? expressionList| /* argList is allowed to be empty */) ')'
    ;

expressionList
    : expression (',' expression)*
    ;

constructTemplate
    : '{' constructTriples? '}'
    ;

constructTriples
    : triplesSameSubject ('.' constructTriples?)*
    ;

triplesSameSubject
    : varOrTerm propertyListNotEmpty | triplesNode propertyList 
    ;
 
propertyList
    : propertyListNotEmpty?
    ;

propertyListNotEmpty
    : verb objectList (';' (verb objectList)?)* 
    ;

verb
    : varOrIRI | A
    ;    

objectList
    : object (',' object)*
    ;

object
    : graphNode
    ;

triplesSameSubjectPath
    : varOrTerm propertyListPathNotEmpty | triplesNodePath propertyListPath
    ;
  
propertyListPath
    : propertyListPathNotEmpty?
    ;  

propertyListPathNotEmpty
    : (verbPath|verbSimple) objectListPath (';' propertyListPathNotEmptyList?)*
    ;

propertyListPathNotEmptyList
    : (verbPath|verbSimple) objectList
    ;

verbPath
    : path
    ;
    
verbSimple
    : var
    ;
    	
objectListPath
    : objectPath (',' objectPath)*
    ;

objectPath
    : graphNodePath
    ;

path
    : pathAlternative
    ; 

pathAlternative
    : pathSequence ('|' pathSequence)*
    ;
    
pathSequence
    : pathEltOrInverse ('/' pathEltOrInverse)*
    ;
       	  	
pathElt
    : pathPrimary pathMod?
    ;

pathEltOrInverse
    : INVERSE? pathElt
    ;

pathMod
    : op=('?'| '*' | '+') 
    ;

pathPrimary
    : iri | A | '!' pathNegatedPropertySet | '(' path ')'
    ;

pathNegatedPropertySet
    : pathOneInPropertySet | '(' (pathOneInPropertySet ('|' pathOneInPropertySet)*)? ')'
    ;  	

pathOneInPropertySet
    : INVERSE? (iri | A)
    ;
	
integer
    : INTEGER
    ;
    
triplesNode
    : collection | blankNodePropertyList
    ;

blankNodePropertyList
    : '[' propertyListNotEmpty ']'
    ;

triplesNodePath
    : collectionPath | blankNodePropertyListPath
    ;

blankNodePropertyListPath
    : '[' propertyListPathNotEmpty ']'
    ;

collection
    : '(' graphNode+ ')'
    ;

collectionPath
    : '(' graphNodePath+ ')'
    ;
    
graphNode
    : varOrTerm | triplesNode
    ;

graphNodePath
    : varOrTerm | triplesNodePath
    ;

varOrTerm
    : var | graphTerm
    ;

varOrIRI
    : var | iri
    ;

var
    : VAR1 | VAR2
    ;

var3
:   VAR3;

patternOperation
    : PATTYPE;
graphTerm
    : iri | rdfLiteral | numericLiteral | booleanLiteral | blankNode | nil
    ;
    
nil
    : '(' ')'
    ;

/* ANTLR V4 branded expressions */
expression
    : primaryExpression                                     # baseExpression
    | op=('*'|'/') expression                               # unaryMultiplicativeExpression
    | op=('+'|'-') expression                               # unaryAdditiveExpression
    | '!' expression                                        # unaryNegationExpression
    | expression op=('*'|'/') expression                    # multiplicativeExpression
    | expression op=('+'|'-') expression                    # additiveExpression
    | expression unaryLiteralExpression                     # unarySignedLiteralExpression   
    | expression NOT? IN '(' expressionList? ')'            # relationalSetExpression
    | expression op=('='|'!='|'<'|'>'|'<='|'>=') expression # relationalExpression
    | expression ('&&' expression)                          # conditionalAndExpression
    | expression ('||' expression)                          # conditionalOrExpression
    ;

unaryLiteralExpression
    : (numericLiteralPositive|numericLiteralNegative) (op=('*'|'/') unaryExpression)? 
    ;

unaryExpression
    : op=('!'|'+'|'-')? primaryExpression
    ;

primaryExpression
    : '(' expression ')' | builtInCall | iriRefOrFunction | rdfLiteral | numericLiteral | booleanLiteral | var
    ;

builtInCall
    : aggregate
    | STR '(' expression ')'
    | LANG '(' expression ')'
    | LANGMATCHES '(' expression ',' expression ')'
    | DATATYPE '(' expression ')'
    | BOUND '(' var ')'
    | IRI '(' expression ')'
    | URI '(' expression ')'
    | BNODE '(' expression? ')'
    | RAND '(' ')'
    | ABS '(' expression ')'
    | CEIL '(' expression ')'
    | FLOOR '(' expression ')'
    | ROUND '(' expression ')'
    | CONCAT '(' expressionList? ')'
    | subStringExpression
    | STRLEN '(' expression ')'
    | strReplaceExpression
    | UCASE '(' expression ')'
    | LCASE '(' expression ')'
    | ENCODE_FOR_URI '(' expression ')'
    | CONTAINS '(' expression ',' expression ')'
    | STRSTARTS '(' expression ',' expression ')'
    | STRENDS '(' expression ',' expression ')'
    | STRBEFORE '(' expression ',' expression ')'
    | STRAFTER '(' expression ',' expression ')'
    | YEAR '(' expression ')'
    | MONTH '(' expression ')'
    | DAY '(' expression ')'
    | HOURS '(' expression ')'
    | MINUTES '(' expression ')'
    | SECONDS '(' expression ')'
    | TIMEZONE '(' expression ')'
    | TZ '(' expression ')'
    | NOW '(' ')'
    | UUID '(' ')'
    | STRUUID '(' ')'
    | MD5 '(' expression ')'
    | SHA1 '(' expression ')'
    | SHA256 '(' expression ')'
    | SHA384 '(' expression ')'
    | SHA512 '(' expression ')'
    | COALESCE '(' expressionList? ')'
    | IF '(' expression ',' expression ',' expression ')'
    | STRLANG '(' expression ',' expression ')'
    | STRDT '(' expression ',' expression ')'
    | SAMETERM '(' expression ',' expression ')'
    | ISIRI '(' expression ')'
    | ISURI '(' expression ')'
    | ISBLANK '(' expression ')'
    | ISLITERAL '(' expression ')'
    | ISNUMERIC '(' expression ')'
    | regexExpression
    | existsFunction
    | notExistsFunction
    ;

regexExpression
    : REGEX '(' expression ',' expression (',' expression)? ')'
    ;
    
subStringExpression
    : SUBSTR '(' expression ',' expression (',' expression)? ')'
    ;
    
strReplaceExpression
    : REPLACE '(' expression ',' expression ',' expression (',' expression)? ')'
    ;
    
existsFunction
    : EXISTS groupGraphPattern
    ;

notExistsFunction
    : NOT EXISTS groupGraphPattern
    ;

aggregate
    : COUNT '(' DISTINCT? (ASTERISK | expression) ')'
    | SUM '(' DISTINCT? expression ')'
    | MIN '(' DISTINCT? expression ')'
    | MAX '(' DISTINCT? expression ')'
    | AVG '(' DISTINCT? expression ')'
    | SAMPLE '(' DISTINCT? expression ')'
    | GROUP_CONCAT '(' DISTINCT? expression (';' SEPARATOR '=' string)? ')'
    ;
    
iriRefOrFunction
    : iri argList?
    ;

rdfLiteral
    : string (LANGTAG | ('^^' iri))?
    ;

numericLiteral
    : numericLiteralUnsigned | numericLiteralPositive | numericLiteralNegative
    ;

numericLiteralUnsigned
    : INTEGER | DECIMAL | DOUBLE
    ;

numericLiteralPositive
    : INTEGER_POSITIVE | DECIMAL_POSITIVE | DOUBLE_POSITIVE
    ;

numericLiteralNegative
    : INTEGER_NEGATIVE | DECIMAL_NEGATIVE | DOUBLE_NEGATIVE
    ;

booleanLiteral
    : TRUE | FALSE
    ;

string
    : STRING_LITERAL1 | STRING_LITERAL2 | STRING_LITERAL_LONG1 | STRING_LITERAL_LONG2
    ;

iri
    : IRIREF | prefixedName
    ;

prefixedName
    : PNAME_LN | PNAME_NS
    ;

blankNode
    : BLANK_NODE_LABEL | anon
    ;

anon
    : '[' ']'
    ;

eofRule
    : EOFRULE ;
// $>

