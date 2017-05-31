/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.query.parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.query.sources.SparqlLexer;
import edu.telecomstet.cep.query.sources.StreamingSparql;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.PatternData;

/**
 *
 * @author sydgillani
 */
public class AntlrSPARQLTest {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws ParseException,
			DatatypeConfigurationException {
		// TODO code application logic here

		String query = null;
		/*
		 * query="SELECT * where{ <http://www.example.com/f> ?p ?o." +
		 * "OPTIONAL {?s2 ?p2 ?o3.}}";
		 */

		query = " prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  "
				+ "prefix sib: <http://www.ins.cwi.nl/sib/vocabulary/> "
				+ "prefix sioc: <http://rdfs.org/sioc/ns#> "
				+

				" prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  "
				+ " prefix ub: <http://swat.cse.lehigh.edu/onto/univ-bench.owl#> "
				+ "prefix foaf: <http://xmlns.com/foaf/0.1/> "
				+ "prefix dbpedia: <http://dbpedia.org/resource/>  "
				+ " CONSTRUCT {?p } " + " WITHIN 1000000 SECONDS "
				+ "Pattern by ( ?z ) "
				+ "FROM STREAM S1 <http://example.org/main>  "

				+ "WHERE   " + " SEQ (A) " + "{" + " DEFINE GPM A ON S1 "

				+ " { "

				+

				"?z rdf:type ub:Department ." + "?y rdf:type ub:University . "
				+ " ?x rdf:type ub:GraduateStudent . " +

				" ?x ub:memberOf ?z . "
				+ " ?x ub:undergraduateDegreeFrom ?y . "
				+ " ?z ub:subOrganizationOf ?y . " +

				"}"

				+ "   }";

		query = " prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "prefix xsd: <http://www.w3.org/2001/XMLSchema#>  "
				+ "prefix sib: <http://www.ins.cwi.nl/sib/vocabulary/> "
				+ "prefix sioc: <http://rdfs.org/sioc/ns#> "
				+

				"prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+

				"prefix foaf: <http://xmlns.com/foaf/0.1/> "
				+ "prefix dbpedia: <http://dbpedia.org/resource/>  "
				// + " CONSTRUCT {  ?person sioc:creator_of sib:newStuff."
				// + "   ?post sib:hashtag ?tag2. } "+
				+ "SELECT ?person "
				+ " WITHIN 10 SECONDS "
				+
				// "  partition by (?person)  "+
				"   FROM STREAM S1 <http://example.org/main>  "

				+ "WHERE   " + " SEQ (A, B, (A<>B<>C), C) " + "{"
				+ " DEFINE GPM A ON S1 "

				+ " { " + " ?person sioc:creator_of ?post. "
				+ " ?post sib:hashtag ?tag. "

				+ "GRAPH <http://www.example.com> {"
				+ " ?person  sioc:creator_of ?y. " + "?y  sib:hashtag ?z. "
				+ "?y  sib:hash2 ?k." + "?y sib:goinfor ?k." + "}"

				+ " } "

				+ " DEFINE GPM B ON S1 "

				+ " { " + " ?person sioc:creator_of ?post2. "
				+ "  ?post2 sib:hashtag ?tag2.  "

				+ " Filter (?tag2 = ?tag && ?tag2 > ?post). }"

				+ "}";

		SparqlLexer lexer = new SparqlLexer(new ANTLRInputStream(query));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		StreamingSparql parser = new StreamingSparql(tokens);

		// parser.setBuildParseTree(true);

		ParseTree tree = parser.query();
		System.out.println(tree.toStringTree(parser));
		DictionaryOpImpl dict = new DictionaryOpImpl();
		ListenerQueryContextUpdated ListenerQuery = new ListenerQueryContextUpdated(
				dict);

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(ListenerQuery, tree);

		List<NFAData> test = ListenerQuery.getNfaDataList();
		List<PatternData> pattdat = ListenerQuery.get_pattData();
		List<PatternData> upattData = ListenerQuery.get_unionpattData();
		List<PatternData> result = new ArrayList<PatternData>();

		result.addAll(pattdat);
		result.addAll(upattData);
		// Comparator<PatternData> byID =
		// (PatternData o1,PatternData o2)->o1.getId() > o2.getId()?1:0;
		// result.stream().sorted((e1,e2)-> Integer.compare(e1., y));

		result = result.stream()
				.sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId()))
				.collect(Collectors.toList());

		// /We get the sorted list of elements, now we need to add pattern data
		// stuff in the NFA data with an additional automata
		// go through the whole list of pattern data and compare it with the NFA
		// and make a new list out of it.

		// NFA nf= new NFA(result, test);

		// for(PatternData d:result){
		//
		// ///check if its single or double
		// if(d.getPattName2()==null){
		// NFAData first=
		// test.stream().filter(x->x.getStateType().equals(d.getPattName())).findFirst().get();
		// ////send it for the state
		// ///based on this NFA data create the states
		// }else{
		// ///create a list of NFAData and send it with the proper ID
		// }
		//
		//
		//
		//
		//
		// }

		// System.out.println(ListenerQuery.getNfaDataList());

		// ParseTree tree=new ParseTree(parser)
		// /SparqlVisitor loader = new SparqlVisitor();
		// loader.visit(tree);
		// loader.visit(tree);
		// MyVisitor v=new MyVisitor();

		// StreamingSparql.PrefixDeclContext prefix=parser.prefixDecl();

		// StreamingSparql.SelectQueryContext selcontx= parser.selectQuery();

		// StreamingSparql.QueryContext querycontx=parser.;

		// ParseTreeWalker walker = new ParseTreeWalker();

		// ParseTreeWalker walker = new ParseTreeWalker();

		// ListerStreamSparql listener=new ListerStreamSparql();

	}

}
