// Generated from StreamingSparql.g4 by ANTLR 4.3

    package edu.telecomstet.cep.query.sources;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StreamingSparql extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MONTH=86, RAND=69, SHA1=97, CREATE=47, IRIREF=127, EOFRULE=2, DECIMAL_NEGATIVE=142, 
		MINUS=65, STR=27, FLOOR=72, YEAR=85, ISLITERAL=36, GREATER_EQUAL=151, 
		OPEN_BRACE=156, SEMICOLON=162, CEIL=71, PARTITION=119, LESS_EQUAL=150, 
		TIMEZONE=91, SAMETERM=32, IF=102, CLOSE_SQUARE_BRACKET=161, GRAPH=23, 
		BINDINGS=62, BIND=64, VAR1=131, VAR2=132, VAR3=133, IN=118, DISTINCT=6, 
		DOT=163, STRENDS=81, SUM=107, WHERE=14, STRLEN=75, AS=58, LCASE=77, MIN=108, 
		STRING_LITERAL2=145, STRING_LITERAL1=144, ENCODE_FOR_URI=78, COUNT=106, 
		OPEN_SQUARE_BRACKET=160, A=26, IRI=66, INTO=56, CONSTRUCT=8, ISBLANK=35, 
		MAX=109, DOUBLE_NEGATIVE=143, URI=67, DEFINE=112, COMMENT=148, DIVIDE=170, 
		ORDER=15, ASC=17, GROUP=59, DELETE=48, ABS=70, CLOSE_BRACE=157, BY=16, 
		ASK=10, OFFSET=20, VALUES=21, DOUBLE=137, ESELECTION=124, COMMA=168, STRAFTER=83, 
		PNAME_NS=128, SECONDS=90, UNIONOR=120, GREATER=173, ASTERISK=166, COPY=46, 
		INTEGER_POSITIVE=138, SELECT=5, NAMED=12, DECIMAL_POSITIVE=139, NOT_EQUAL=152, 
		TO=57, UNION=24, DAY=87, GROUP_CONCAT=116, LANGTAG=134, UNDEF=61, MD5=96, 
		ADD=44, ALL=53, BNODE=68, REGEX=37, GPM=111, TZ=92, DECIMAL=136, FROM=11, 
		PIPE=174, INVERSE=155, DESC=18, STRBEFORE=82, OPTIONAL=22, STRSTARTS=80, 
		COALESCE=101, QUESTION_MARK=167, CLOSE_CURLY_BRACE=159, ISNUMERIC=105, 
		BOUND=31, PATTYPE=125, SERVICE=63, REPLACE=84, UUID=94, DESCRIBE=9, SUBSTR=38, 
		SILENT=51, INTEGER=135, SEPARATOR=122, LANGMATCHES=29, TRUE=39, OPEN_CURLY_BRACE=158, 
		PNAME_LN=129, USING=50, AVG=110, NOT=117, DATATYPE=30, STRING_LITERAL_LONG2=147, 
		PREFIX=4, DATA=54, NOW=93, AND=153, INSERT=49, LESS=172, HAVING=60, STRING_LITERAL_LONG1=146, 
		SHA512=100, LOAD=41, ROUND=73, CONCAT=74, UCASE=76, ISURI=34, LIMIT=19, 
		WITHIN=114, CONTAINS=79, ANY=175, LANG=28, BASE=3, DROP=43, SHA384=99, 
		SEQUENCE=123, STRDT=104, REFERENCE=149, WS=1, STRLANG=103, INTEGER_NEGATIVE=141, 
		ON=113, FILTER=25, OR=154, EXISTS=121, EQUAL=171, MINUS_SIGN=165, STREAM=13, 
		BLANK_NODE_LABEL=130, NEGATION=169, TIME=126, STRUUID=95, WITH=55, SHA256=98, 
		SAMPLE=115, DOUBLE_POSITIVE=140, PLUS_SIGN=164, HOURS=88, MOVE=45, FALSE=40, 
		MINUTES=89, REDUCED=7, ISIRI=33, CLEAR=42, DEFAULT=52;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "EOFRULE", "BASE", "PREFIX", "SELECT", "DISTINCT", 
		"REDUCED", "CONSTRUCT", "DESCRIBE", "ASK", "FROM", "NAMED", "STREAM", 
		"WHERE", "ORDER", "BY", "ASC", "DESC", "LIMIT", "OFFSET", "VALUES", "OPTIONAL", 
		"GRAPH", "UNION", "FILTER", "'a'", "STR", "LANG", "LANGMATCHES", "DATATYPE", 
		"BOUND", "SAMETERM", "ISIRI", "ISURI", "ISBLANK", "ISLITERAL", "REGEX", 
		"SUBSTR", "TRUE", "FALSE", "LOAD", "CLEAR", "DROP", "ADD", "MOVE", "COPY", 
		"CREATE", "DELETE", "INSERT", "USING", "SILENT", "DEFAULT", "ALL", "DATA", 
		"WITH", "INTO", "TO", "AS", "GROUP", "HAVING", "UNDEF", "BINDINGS", "SERVICE", 
		"BIND", "MINUS", "IRI", "URI", "BNODE", "RAND", "ABS", "CEIL", "FLOOR", 
		"ROUND", "CONCAT", "STRLEN", "UCASE", "LCASE", "ENCODE_FOR_URI", "CONTAINS", 
		"STRSTARTS", "STRENDS", "STRBEFORE", "STRAFTER", "REPLACE", "YEAR", "MONTH", 
		"DAY", "HOURS", "MINUTES", "SECONDS", "TIMEZONE", "TZ", "NOW", "UUID", 
		"STRUUID", "MD5", "SHA1", "SHA256", "SHA384", "SHA512", "COALESCE", "IF", 
		"STRLANG", "STRDT", "ISNUMERIC", "COUNT", "SUM", "MIN", "MAX", "AVG", 
		"GPM", "DEFINE", "ON", "WITHIN", "SAMPLE", "GROUP_CONCAT", "NOT", "IN", 
		"PARTITION", "UNIONOR", "EXISTS", "SEPARATOR", "SEQUENCE", "ESELECTION", 
		"PATTYPE", "TIME", "IRIREF", "PNAME_NS", "PNAME_LN", "BLANK_NODE_LABEL", 
		"VAR1", "VAR2", "VAR3", "LANGTAG", "INTEGER", "DECIMAL", "DOUBLE", "INTEGER_POSITIVE", 
		"DECIMAL_POSITIVE", "DOUBLE_POSITIVE", "INTEGER_NEGATIVE", "DECIMAL_NEGATIVE", 
		"DOUBLE_NEGATIVE", "STRING_LITERAL1", "STRING_LITERAL2", "STRING_LITERAL_LONG1", 
		"STRING_LITERAL_LONG2", "COMMENT", "'^^'", "'<='", "'>='", "'!='", "'&&'", 
		"'||'", "'^'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", 
		"'+'", "'-'", "'*'", "'?'", "','", "'!'", "'/'", "'='", "'<'", "'>'", 
		"'|'", "ANY"
	};
	public static final int
		RULE_query = 0, RULE_prologue = 1, RULE_baseDecl = 2, RULE_prefixDecl = 3, 
		RULE_selectQuery = 4, RULE_subSelect = 5, RULE_selectClause = 6, RULE_selectVariables = 7, 
		RULE_constructQuery = 8, RULE_describeQuery = 9, RULE_askQuery = 10, RULE_constructClause = 11, 
		RULE_datasetClause = 12, RULE_durantionClause = 13, RULE_partitionbyClause = 14, 
		RULE_partition = 15, RULE_streamsetCaluse = 16, RULE_within = 17, RULE_window = 18, 
		RULE_unitTime = 19, RULE_whereClause = 20, RULE_seqBlock = 21, RULE_seqConstraints = 22, 
		RULE_eventPattList = 23, RULE_eventSelection = 24, RULE_eventPattern = 25, 
		RULE_eventUnionOrPattern = 26, RULE_eventJoiner = 27, RULE_pattBlock = 28, 
		RULE_eventDefinition = 29, RULE_multipleVars = 30, RULE_time = 31, RULE_solutionModifier = 32, 
		RULE_groupClause = 33, RULE_groupCondition = 34, RULE_havingClause = 35, 
		RULE_havingCondition = 36, RULE_orderClause = 37, RULE_orderCondition = 38, 
		RULE_limitOffsetClauses = 39, RULE_limitClause = 40, RULE_offsetClause = 41, 
		RULE_valuesClause = 42, RULE_updateCommand = 43, RULE_update = 44, RULE_load = 45, 
		RULE_clear = 46, RULE_drop = 47, RULE_create = 48, RULE_add = 49, RULE_move = 50, 
		RULE_copy = 51, RULE_insertData = 52, RULE_deleteData = 53, RULE_deleteWhere = 54, 
		RULE_modify = 55, RULE_deleteClause = 56, RULE_insertClause = 57, RULE_usingClause = 58, 
		RULE_graphOrDefault = 59, RULE_graphRef = 60, RULE_graphRefAll = 61, RULE_quadPattern = 62, 
		RULE_quadData = 63, RULE_quads = 64, RULE_quadsDetails = 65, RULE_quadsNotTriples = 66, 
		RULE_triplesTemplate = 67, RULE_groupGraphPattern = 68, RULE_groupGraphPatternSub = 69, 
		RULE_groupGraphPatternSubList = 70, RULE_triplesBlock = 71, RULE_graphPatternNotTriples = 72, 
		RULE_optionalGraphPattern = 73, RULE_graphGraphPattern = 74, RULE_serviceGraphPattern = 75, 
		RULE_bind = 76, RULE_inlineData = 77, RULE_dataBlock = 78, RULE_inlineDataOneVar = 79, 
		RULE_inlineDataFull = 80, RULE_dataBlockValues = 81, RULE_dataBlockValue = 82, 
		RULE_minusGraphPattern = 83, RULE_groupOrUnionGraphPattern = 84, RULE_filter = 85, 
		RULE_constraint = 86, RULE_functionCall = 87, RULE_argList = 88, RULE_expressionList = 89, 
		RULE_constructTemplate = 90, RULE_constructTriples = 91, RULE_triplesSameSubject = 92, 
		RULE_propertyList = 93, RULE_propertyListNotEmpty = 94, RULE_verb = 95, 
		RULE_objectList = 96, RULE_object = 97, RULE_triplesSameSubjectPath = 98, 
		RULE_propertyListPath = 99, RULE_propertyListPathNotEmpty = 100, RULE_propertyListPathNotEmptyList = 101, 
		RULE_verbPath = 102, RULE_verbSimple = 103, RULE_objectListPath = 104, 
		RULE_objectPath = 105, RULE_path = 106, RULE_pathAlternative = 107, RULE_pathSequence = 108, 
		RULE_pathElt = 109, RULE_pathEltOrInverse = 110, RULE_pathMod = 111, RULE_pathPrimary = 112, 
		RULE_pathNegatedPropertySet = 113, RULE_pathOneInPropertySet = 114, RULE_integer = 115, 
		RULE_triplesNode = 116, RULE_blankNodePropertyList = 117, RULE_triplesNodePath = 118, 
		RULE_blankNodePropertyListPath = 119, RULE_collection = 120, RULE_collectionPath = 121, 
		RULE_graphNode = 122, RULE_graphNodePath = 123, RULE_varOrTerm = 124, 
		RULE_varOrIRI = 125, RULE_var = 126, RULE_var3 = 127, RULE_patternOperation = 128, 
		RULE_graphTerm = 129, RULE_nil = 130, RULE_expression = 131, RULE_unaryLiteralExpression = 132, 
		RULE_unaryExpression = 133, RULE_primaryExpression = 134, RULE_builtInCall = 135, 
		RULE_regexExpression = 136, RULE_subStringExpression = 137, RULE_strReplaceExpression = 138, 
		RULE_existsFunction = 139, RULE_notExistsFunction = 140, RULE_aggregate = 141, 
		RULE_iriRefOrFunction = 142, RULE_rdfLiteral = 143, RULE_numericLiteral = 144, 
		RULE_numericLiteralUnsigned = 145, RULE_numericLiteralPositive = 146, 
		RULE_numericLiteralNegative = 147, RULE_booleanLiteral = 148, RULE_string = 149, 
		RULE_iri = 150, RULE_prefixedName = 151, RULE_blankNode = 152, RULE_anon = 153, 
		RULE_eofRule = 154;
	public static final String[] ruleNames = {
		"query", "prologue", "baseDecl", "prefixDecl", "selectQuery", "subSelect", 
		"selectClause", "selectVariables", "constructQuery", "describeQuery", 
		"askQuery", "constructClause", "datasetClause", "durantionClause", "partitionbyClause", 
		"partition", "streamsetCaluse", "within", "window", "unitTime", "whereClause", 
		"seqBlock", "seqConstraints", "eventPattList", "eventSelection", "eventPattern", 
		"eventUnionOrPattern", "eventJoiner", "pattBlock", "eventDefinition", 
		"multipleVars", "time", "solutionModifier", "groupClause", "groupCondition", 
		"havingClause", "havingCondition", "orderClause", "orderCondition", "limitOffsetClauses", 
		"limitClause", "offsetClause", "valuesClause", "updateCommand", "update", 
		"load", "clear", "drop", "create", "add", "move", "copy", "insertData", 
		"deleteData", "deleteWhere", "modify", "deleteClause", "insertClause", 
		"usingClause", "graphOrDefault", "graphRef", "graphRefAll", "quadPattern", 
		"quadData", "quads", "quadsDetails", "quadsNotTriples", "triplesTemplate", 
		"groupGraphPattern", "groupGraphPatternSub", "groupGraphPatternSubList", 
		"triplesBlock", "graphPatternNotTriples", "optionalGraphPattern", "graphGraphPattern", 
		"serviceGraphPattern", "bind", "inlineData", "dataBlock", "inlineDataOneVar", 
		"inlineDataFull", "dataBlockValues", "dataBlockValue", "minusGraphPattern", 
		"groupOrUnionGraphPattern", "filter", "constraint", "functionCall", "argList", 
		"expressionList", "constructTemplate", "constructTriples", "triplesSameSubject", 
		"propertyList", "propertyListNotEmpty", "verb", "objectList", "object", 
		"triplesSameSubjectPath", "propertyListPath", "propertyListPathNotEmpty", 
		"propertyListPathNotEmptyList", "verbPath", "verbSimple", "objectListPath", 
		"objectPath", "path", "pathAlternative", "pathSequence", "pathElt", "pathEltOrInverse", 
		"pathMod", "pathPrimary", "pathNegatedPropertySet", "pathOneInPropertySet", 
		"integer", "triplesNode", "blankNodePropertyList", "triplesNodePath", 
		"blankNodePropertyListPath", "collection", "collectionPath", "graphNode", 
		"graphNodePath", "varOrTerm", "varOrIRI", "var", "var3", "patternOperation", 
		"graphTerm", "nil", "expression", "unaryLiteralExpression", "unaryExpression", 
		"primaryExpression", "builtInCall", "regexExpression", "subStringExpression", 
		"strReplaceExpression", "existsFunction", "notExistsFunction", "aggregate", 
		"iriRefOrFunction", "rdfLiteral", "numericLiteral", "numericLiteralUnsigned", 
		"numericLiteralPositive", "numericLiteralNegative", "booleanLiteral", 
		"string", "iri", "prefixedName", "blankNode", "anon", "eofRule"
	};

	@Override
	public String getGrammarFileName() { return "StreamingSparql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StreamingSparql(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public PrologueContext prologue(int i) {
			return getRuleContext(PrologueContext.class,i);
		}
		public List<PrologueContext> prologue() {
			return getRuleContexts(PrologueContext.class);
		}
		public DescribeQueryContext describeQuery() {
			return getRuleContext(DescribeQueryContext.class,0);
		}
		public ValuesClauseContext valuesClause() {
			return getRuleContext(ValuesClauseContext.class,0);
		}
		public SelectQueryContext selectQuery() {
			return getRuleContext(SelectQueryContext.class,0);
		}
		public ConstructQueryContext constructQuery() {
			return getRuleContext(ConstructQueryContext.class,0);
		}
		public AskQueryContext askQuery() {
			return getRuleContext(AskQueryContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BASE || _la==PREFIX) {
				{
				{
				setState(310); prologue();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(320);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(316); selectQuery();
				}
				break;

			case 2:
				{
				setState(317); constructQuery();
				}
				break;

			case 3:
				{
				setState(318); describeQuery();
				}
				break;

			case 4:
				{
				setState(319); askQuery();
				}
				break;
			}
			setState(322); valuesClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrologueContext extends ParserRuleContext {
		public BaseDeclContext baseDecl() {
			return getRuleContext(BaseDeclContext.class,0);
		}
		public PrefixDeclContext prefixDecl() {
			return getRuleContext(PrefixDeclContext.class,0);
		}
		public PrologueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prologue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPrologue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPrologue(this);
		}
	}

	public final PrologueContext prologue() throws RecognitionException {
		PrologueContext _localctx = new PrologueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prologue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			switch (_input.LA(1)) {
			case BASE:
				{
				setState(324); baseDecl();
				}
				break;
			case PREFIX:
				{
				setState(325); prefixDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseDeclContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(StreamingSparql.IRIREF, 0); }
		public TerminalNode BASE() { return getToken(StreamingSparql.BASE, 0); }
		public BaseDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBaseDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBaseDecl(this);
		}
	}

	public final BaseDeclContext baseDecl() throws RecognitionException {
		BaseDeclContext _localctx = new BaseDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_baseDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328); match(BASE);
			setState(329); match(IRIREF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixDeclContext extends ParserRuleContext {
		public TerminalNode PREFIX() { return getToken(StreamingSparql.PREFIX, 0); }
		public TerminalNode IRIREF() { return getToken(StreamingSparql.IRIREF, 0); }
		public TerminalNode PNAME_NS() { return getToken(StreamingSparql.PNAME_NS, 0); }
		public PrefixDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPrefixDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPrefixDecl(this);
		}
	}

	public final PrefixDeclContext prefixDecl() throws RecognitionException {
		PrefixDeclContext _localctx = new PrefixDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prefixDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331); match(PREFIX);
			setState(332); match(PNAME_NS);
			setState(333); match(IRIREF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectQueryContext extends ParserRuleContext {
		public DurantionClauseContext durantionClause() {
			return getRuleContext(DurantionClauseContext.class,0);
		}
		public PartitionbyClauseContext partitionbyClause(int i) {
			return getRuleContext(PartitionbyClauseContext.class,i);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public ConstructClauseContext constructClause() {
			return getRuleContext(ConstructClauseContext.class,0);
		}
		public List<StreamsetCaluseContext> streamsetCaluse() {
			return getRuleContexts(StreamsetCaluseContext.class);
		}
		public List<PartitionbyClauseContext> partitionbyClause() {
			return getRuleContexts(PartitionbyClauseContext.class);
		}
		public StreamsetCaluseContext streamsetCaluse(int i) {
			return getRuleContext(StreamsetCaluseContext.class,i);
		}
		public SelectQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSelectQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSelectQuery(this);
		}
	}

	public final SelectQueryContext selectQuery() throws RecognitionException {
		SelectQueryContext _localctx = new SelectQueryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_selectQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			switch (_input.LA(1)) {
			case SELECT:
				{
				setState(335); selectClause();
				}
				break;
			case CONSTRUCT:
				{
				setState(336); constructClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(339); durantionClause();
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARTITION) {
				{
				{
				setState(340); partitionbyClause();
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(346); streamsetCaluse();
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352); whereClause();
			setState(353); solutionModifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubSelectContext extends ParserRuleContext {
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public ValuesClauseContext valuesClause() {
			return getRuleContext(ValuesClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public SubSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subSelect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSubSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSubSelect(this);
		}
	}

	public final SubSelectContext subSelect() throws RecognitionException {
		SubSelectContext _localctx = new SubSelectContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355); selectClause();
			setState(356); whereClause();
			setState(357); solutionModifier();
			setState(358); valuesClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectClauseContext extends ParserRuleContext {
		public TerminalNode REDUCED() { return getToken(StreamingSparql.REDUCED, 0); }
		public SelectVariablesContext selectVariables(int i) {
			return getRuleContext(SelectVariablesContext.class,i);
		}
		public TerminalNode SELECT() { return getToken(StreamingSparql.SELECT, 0); }
		public TerminalNode DISTINCT() { return getToken(StreamingSparql.DISTINCT, 0); }
		public List<SelectVariablesContext> selectVariables() {
			return getRuleContexts(SelectVariablesContext.class);
		}
		public SelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSelectClause(this);
		}
	}

	public final SelectClauseContext selectClause() throws RecognitionException {
		SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360); match(SELECT);
			setState(362);
			_la = _input.LA(1);
			if (_la==DISTINCT || _la==REDUCED) {
				{
				setState(361);
				_la = _input.LA(1);
				if ( !(_la==DISTINCT || _la==REDUCED) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(370);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
			case OPEN_BRACE:
				{
				setState(365); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(364); selectVariables();
					}
					}
					setState(367); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (VAR1 - 131)) | (1L << (VAR2 - 131)) | (1L << (OPEN_BRACE - 131)))) != 0) );
				}
				break;
			case ASTERISK:
				{
				setState(369); match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectVariablesContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(StreamingSparql.AS, 0); }
		public SelectVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSelectVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSelectVariables(this);
		}
	}

	public final SelectVariablesContext selectVariables() throws RecognitionException {
		SelectVariablesContext _localctx = new SelectVariablesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selectVariables);
		try {
			setState(379);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(372); var();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(373); match(OPEN_BRACE);
				setState(374); expression(0);
				setState(375); match(AS);
				setState(376); var();
				setState(377); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructQueryContext extends ParserRuleContext {
		public TerminalNode CONSTRUCT() { return getToken(StreamingSparql.CONSTRUCT, 0); }
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public ConstructTemplateContext constructTemplate() {
			return getRuleContext(ConstructTemplateContext.class,0);
		}
		public DatasetClauseContext datasetClause(int i) {
			return getRuleContext(DatasetClauseContext.class,i);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(StreamingSparql.WHERE, 0); }
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public List<DatasetClauseContext> datasetClause() {
			return getRuleContexts(DatasetClauseContext.class);
		}
		public ConstructQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterConstructQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitConstructQuery(this);
		}
	}

	public final ConstructQueryContext constructQuery() throws RecognitionException {
		ConstructQueryContext _localctx = new ConstructQueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constructQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381); match(CONSTRUCT);
			setState(405);
			switch (_input.LA(1)) {
			case OPEN_CURLY_BRACE:
				{
				setState(382); constructTemplate();
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FROM) {
					{
					{
					setState(383); datasetClause();
					}
					}
					setState(388);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(389); whereClause();
				setState(390); solutionModifier();
				}
				break;
			case FROM:
			case WHERE:
				{
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FROM) {
					{
					{
					setState(392); datasetClause();
					}
					}
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(398); match(WHERE);
				setState(399); match(OPEN_CURLY_BRACE);
				setState(401);
				_la = _input.LA(1);
				if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
					{
					setState(400); triplesTemplate();
					}
				}

				setState(403); match(CLOSE_CURLY_BRACE);
				setState(404); solutionModifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeQueryContext extends ParserRuleContext {
		public List<VarOrIRIContext> varOrIRI() {
			return getRuleContexts(VarOrIRIContext.class);
		}
		public TerminalNode DESCRIBE() { return getToken(StreamingSparql.DESCRIBE, 0); }
		public DatasetClauseContext datasetClause(int i) {
			return getRuleContext(DatasetClauseContext.class,i);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public List<DatasetClauseContext> datasetClause() {
			return getRuleContexts(DatasetClauseContext.class);
		}
		public VarOrIRIContext varOrIRI(int i) {
			return getRuleContext(VarOrIRIContext.class,i);
		}
		public DescribeQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDescribeQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDescribeQuery(this);
		}
	}

	public final DescribeQueryContext describeQuery() throws RecognitionException {
		DescribeQueryContext _localctx = new DescribeQueryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_describeQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407); match(DESCRIBE);
			setState(414);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
				{
				setState(409); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(408); varOrIRI();
					}
					}
					setState(411); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)))) != 0) );
				}
				break;
			case ASTERISK:
				{
				setState(413); match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(416); datasetClause();
				}
				}
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(423);
			_la = _input.LA(1);
			if (_la==WHERE || _la==SEQUENCE) {
				{
				setState(422); whereClause();
				}
			}

			setState(425); solutionModifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AskQueryContext extends ParserRuleContext {
		public DatasetClauseContext datasetClause(int i) {
			return getRuleContext(DatasetClauseContext.class,i);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public List<DatasetClauseContext> datasetClause() {
			return getRuleContexts(DatasetClauseContext.class);
		}
		public TerminalNode ASK() { return getToken(StreamingSparql.ASK, 0); }
		public AskQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_askQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterAskQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitAskQuery(this);
		}
	}

	public final AskQueryContext askQuery() throws RecognitionException {
		AskQueryContext _localctx = new AskQueryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_askQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427); match(ASK);
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(428); datasetClause();
				}
				}
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(434); whereClause();
			setState(435); solutionModifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructClauseContext extends ParserRuleContext {
		public TerminalNode CONSTRUCT() { return getToken(StreamingSparql.CONSTRUCT, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public ConstructClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterConstructClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitConstructClause(this);
		}
	}

	public final ConstructClauseContext constructClause() throws RecognitionException {
		ConstructClauseContext _localctx = new ConstructClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constructClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); match(CONSTRUCT);
			setState(438); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatasetClauseContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode FROM() { return getToken(StreamingSparql.FROM, 0); }
		public TerminalNode NAMED() { return getToken(StreamingSparql.NAMED, 0); }
		public DatasetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datasetClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDatasetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDatasetClause(this);
		}
	}

	public final DatasetClauseContext datasetClause() throws RecognitionException {
		DatasetClauseContext _localctx = new DatasetClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_datasetClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440); match(FROM);
			setState(442);
			_la = _input.LA(1);
			if (_la==NAMED) {
				{
				setState(441); match(NAMED);
				}
			}

			setState(444); iri();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DurantionClauseContext extends ParserRuleContext {
		public WithinContext within() {
			return getRuleContext(WithinContext.class,0);
		}
		public DurantionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_durantionClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDurantionClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDurantionClause(this);
		}
	}

	public final DurantionClauseContext durantionClause() throws RecognitionException {
		DurantionClauseContext _localctx = new DurantionClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_durantionClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446); within();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionbyClauseContext extends ParserRuleContext {
		public PartitionContext partition() {
			return getRuleContext(PartitionContext.class,0);
		}
		public PartitionbyClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionbyClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPartitionbyClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPartitionbyClause(this);
		}
	}

	public final PartitionbyClauseContext partitionbyClause() throws RecognitionException {
		PartitionbyClauseContext _localctx = new PartitionbyClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_partitionbyClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448); partition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public TerminalNode PARTITION() { return getToken(StreamingSparql.PARTITION, 0); }
		public TerminalNode BY() { return getToken(StreamingSparql.BY, 0); }
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public PartitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPartition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPartition(this);
		}
	}

	public final PartitionContext partition() throws RecognitionException {
		PartitionContext _localctx = new PartitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450); match(PARTITION);
			setState(451); match(BY);
			setState(452); match(OPEN_BRACE);
			setState(453); var();
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(454); match(COMMA);
				setState(455); var();
				}
				}
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(461); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StreamsetCaluseContext extends ParserRuleContext {
		public Var3Context var3() {
			return getRuleContext(Var3Context.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode FROM() { return getToken(StreamingSparql.FROM, 0); }
		public TerminalNode STREAM() { return getToken(StreamingSparql.STREAM, 0); }
		public StreamsetCaluseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_streamsetCaluse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterStreamsetCaluse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitStreamsetCaluse(this);
		}
	}

	public final StreamsetCaluseContext streamsetCaluse() throws RecognitionException {
		StreamsetCaluseContext _localctx = new StreamsetCaluseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_streamsetCaluse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463); match(FROM);
			setState(464); match(STREAM);
			setState(465); var3();
			setState(466); iri();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithinContext extends ParserRuleContext {
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public UnitTimeContext unitTime() {
			return getRuleContext(UnitTimeContext.class,0);
		}
		public TerminalNode WITHIN() { return getToken(StreamingSparql.WITHIN, 0); }
		public WithinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_within; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterWithin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitWithin(this);
		}
	}

	public final WithinContext within() throws RecognitionException {
		WithinContext _localctx = new WithinContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_within);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468); match(WITHIN);
			setState(469); time();
			setState(470); unitTime();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowContext extends ParserRuleContext {
		public TerminalNode NOW() { return getToken(StreamingSparql.NOW, 0); }
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public TerminalNode FROM() { return getToken(StreamingSparql.FROM, 0); }
		public UnitTimeContext unitTime() {
			return getRuleContext(UnitTimeContext.class,0);
		}
		public WindowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterWindow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitWindow(this);
		}
	}

	public final WindowContext window() throws RecognitionException {
		WindowContext _localctx = new WindowContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_window);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); match(FROM);
			setState(473); match(NOW);
			setState(474); time();
			setState(475); unitTime();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitTimeContext extends ParserRuleContext {
		public TerminalNode HOURS() { return getToken(StreamingSparql.HOURS, 0); }
		public TerminalNode SECONDS() { return getToken(StreamingSparql.SECONDS, 0); }
		public TerminalNode MINUTES() { return getToken(StreamingSparql.MINUTES, 0); }
		public UnitTimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitTime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUnitTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUnitTime(this);
		}
	}

	public final UnitTimeContext unitTime() throws RecognitionException {
		UnitTimeContext _localctx = new UnitTimeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unitTime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			_la = _input.LA(1);
			if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (HOURS - 88)) | (1L << (MINUTES - 88)) | (1L << (SECONDS - 88)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public SeqBlockContext seqBlock() {
			return getRuleContext(SeqBlockContext.class,0);
		}
		public List<PattBlockContext> pattBlock() {
			return getRuleContexts(PattBlockContext.class);
		}
		public TerminalNode WHERE() { return getToken(StreamingSparql.WHERE, 0); }
		public PattBlockContext pattBlock(int i) {
			return getRuleContext(PattBlockContext.class,i);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_whereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(479); match(WHERE);
				}
			}

			setState(482); seqBlock();
			setState(483); match(OPEN_CURLY_BRACE);
			setState(485); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(484); pattBlock();
				}
				}
				setState(487); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DEFINE );
			setState(489); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeqBlockContext extends ParserRuleContext {
		public TerminalNode SEQUENCE() { return getToken(StreamingSparql.SEQUENCE, 0); }
		public SeqConstraintsContext seqConstraints() {
			return getRuleContext(SeqConstraintsContext.class,0);
		}
		public SeqBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSeqBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSeqBlock(this);
		}
	}

	public final SeqBlockContext seqBlock() throws RecognitionException {
		SeqBlockContext _localctx = new SeqBlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_seqBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491); match(SEQUENCE);
			setState(492); seqConstraints();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeqConstraintsContext extends ParserRuleContext {
		public EventPattListContext eventPattList() {
			return getRuleContext(EventPattListContext.class,0);
		}
		public SeqConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqConstraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSeqConstraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSeqConstraints(this);
		}
	}

	public final SeqConstraintsContext seqConstraints() throws RecognitionException {
		SeqConstraintsContext _localctx = new SeqConstraintsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_seqConstraints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494); match(OPEN_BRACE);
			setState(495); eventPattList();
			setState(496); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPattListContext extends ParserRuleContext {
		public List<EventSelectionContext> eventSelection() {
			return getRuleContexts(EventSelectionContext.class);
		}
		public EventSelectionContext eventSelection(int i) {
			return getRuleContext(EventSelectionContext.class,i);
		}
		public List<EventPatternContext> eventPattern() {
			return getRuleContexts(EventPatternContext.class);
		}
		public EventPatternContext eventPattern(int i) {
			return getRuleContext(EventPatternContext.class,i);
		}
		public EventPattListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventPattList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterEventPattList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitEventPattList(this);
		}
	}

	public final EventPattListContext eventPattList() throws RecognitionException {
		EventPattListContext _localctx = new EventPattListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_eventPattList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498); eventPattern();
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESELECTION) {
				{
				{
				setState(500); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(499); eventSelection();
					}
					}
					setState(502); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ESELECTION );
				setState(504); eventPattern();
				}
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventSelectionContext extends ParserRuleContext {
		public TerminalNode ESELECTION() { return getToken(StreamingSparql.ESELECTION, 0); }
		public EventSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventSelection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterEventSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitEventSelection(this);
		}
	}

	public final EventSelectionContext eventSelection() throws RecognitionException {
		EventSelectionContext _localctx = new EventSelectionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_eventSelection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511); match(ESELECTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPatternContext extends ParserRuleContext {
		public Var3Context var3(int i) {
			return getRuleContext(Var3Context.class,i);
		}
		public List<Var3Context> var3() {
			return getRuleContexts(Var3Context.class);
		}
		public EventJoinerContext eventJoiner(int i) {
			return getRuleContext(EventJoinerContext.class,i);
		}
		public PatternOperationContext patternOperation() {
			return getRuleContext(PatternOperationContext.class,0);
		}
		public List<EventJoinerContext> eventJoiner() {
			return getRuleContexts(EventJoinerContext.class);
		}
		public EventPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterEventPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitEventPattern(this);
		}
	}

	public final EventPatternContext eventPattern() throws RecognitionException {
		EventPatternContext _localctx = new EventPatternContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_eventPattern);
		int _la;
		try {
			setState(533);
			switch (_input.LA(1)) {
			case VAR3:
				enterOuterAlt(_localctx, 1);
				{
				setState(513); var3();
				setState(515);
				_la = _input.LA(1);
				if (_la==PATTYPE) {
					{
					setState(514); patternOperation();
					}
				}

				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(517); match(OPEN_BRACE);
				setState(518); var3();
				setState(519); eventJoiner();
				setState(520); var3();
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==UNIONOR) {
					{
					{
					setState(521); eventJoiner();
					setState(522); var3();
					}
					}
					setState(528);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(529); match(CLOSE_BRACE);
				setState(531);
				_la = _input.LA(1);
				if (_la==PATTYPE) {
					{
					setState(530); patternOperation();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventUnionOrPatternContext extends ParserRuleContext {
		public Var3Context var3() {
			return getRuleContext(Var3Context.class,0);
		}
		public EventJoinerContext eventJoiner() {
			return getRuleContext(EventJoinerContext.class,0);
		}
		public EventUnionOrPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventUnionOrPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterEventUnionOrPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitEventUnionOrPattern(this);
		}
	}

	public final EventUnionOrPatternContext eventUnionOrPattern() throws RecognitionException {
		EventUnionOrPatternContext _localctx = new EventUnionOrPatternContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_eventUnionOrPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535); eventJoiner();
			setState(536); var3();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventJoinerContext extends ParserRuleContext {
		public TerminalNode UNIONOR() { return getToken(StreamingSparql.UNIONOR, 0); }
		public EventJoinerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventJoiner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterEventJoiner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitEventJoiner(this);
		}
	}

	public final EventJoinerContext eventJoiner() throws RecognitionException {
		EventJoinerContext _localctx = new EventJoinerContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_eventJoiner);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538); match(UNIONOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PattBlockContext extends ParserRuleContext {
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public EventDefinitionContext eventDefinition() {
			return getRuleContext(EventDefinitionContext.class,0);
		}
		public PattBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPattBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPattBlock(this);
		}
	}

	public final PattBlockContext pattBlock() throws RecognitionException {
		PattBlockContext _localctx = new PattBlockContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_pattBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540); eventDefinition();
			setState(541); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventDefinitionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(StreamingSparql.ON, 0); }
		public TerminalNode DEFINE() { return getToken(StreamingSparql.DEFINE, 0); }
		public TerminalNode GPM() { return getToken(StreamingSparql.GPM, 0); }
		public Var3Context var3() {
			return getRuleContext(Var3Context.class,0);
		}
		public MultipleVarsContext multipleVars() {
			return getRuleContext(MultipleVarsContext.class,0);
		}
		public EventDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterEventDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitEventDefinition(this);
		}
	}

	public final EventDefinitionContext eventDefinition() throws RecognitionException {
		EventDefinitionContext _localctx = new EventDefinitionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_eventDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543); match(DEFINE);
			setState(544); match(GPM);
			setState(545); var3();
			setState(546); match(ON);
			setState(547); multipleVars();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleVarsContext extends ParserRuleContext {
		public Var3Context var3(int i) {
			return getRuleContext(Var3Context.class,i);
		}
		public List<Var3Context> var3() {
			return getRuleContexts(Var3Context.class);
		}
		public MultipleVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterMultipleVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitMultipleVars(this);
		}
	}

	public final MultipleVarsContext multipleVars() throws RecognitionException {
		MultipleVarsContext _localctx = new MultipleVarsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_multipleVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549); var3();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(550); match(COMMA);
				setState(551); var3();
				}
				}
				setState(556);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(StreamingSparql.TIME, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitTime(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557); match(TIME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolutionModifierContext extends ParserRuleContext {
		public GroupClauseContext groupClause() {
			return getRuleContext(GroupClauseContext.class,0);
		}
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public LimitOffsetClausesContext limitOffsetClauses() {
			return getRuleContext(LimitOffsetClausesContext.class,0);
		}
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public SolutionModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solutionModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSolutionModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSolutionModifier(this);
		}
	}

	public final SolutionModifierContext solutionModifier() throws RecognitionException {
		SolutionModifierContext _localctx = new SolutionModifierContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_solutionModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(559); groupClause();
				}
			}

			setState(563);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(562); havingClause();
				}
			}

			setState(566);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(565); orderClause();
				}
			}

			setState(569);
			_la = _input.LA(1);
			if (_la==LIMIT || _la==OFFSET) {
				{
				setState(568); limitOffsetClauses();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupClauseContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(StreamingSparql.GROUP, 0); }
		public GroupConditionContext groupCondition(int i) {
			return getRuleContext(GroupConditionContext.class,i);
		}
		public TerminalNode BY() { return getToken(StreamingSparql.BY, 0); }
		public List<GroupConditionContext> groupCondition() {
			return getRuleContexts(GroupConditionContext.class);
		}
		public GroupClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGroupClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGroupClause(this);
		}
	}

	public final GroupClauseContext groupClause() throws RecognitionException {
		GroupClauseContext _localctx = new GroupClauseContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_groupClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571); match(GROUP);
			setState(572); match(BY);
			setState(574); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(573); groupCondition();
				}
				}
				setState(576); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (IRI - 66)) | (1L << (URI - 66)) | (1L << (BNODE - 66)) | (1L << (RAND - 66)) | (1L << (ABS - 66)) | (1L << (CEIL - 66)) | (1L << (FLOOR - 66)) | (1L << (ROUND - 66)) | (1L << (CONCAT - 66)) | (1L << (STRLEN - 66)) | (1L << (UCASE - 66)) | (1L << (LCASE - 66)) | (1L << (ENCODE_FOR_URI - 66)) | (1L << (CONTAINS - 66)) | (1L << (STRSTARTS - 66)) | (1L << (STRENDS - 66)) | (1L << (STRBEFORE - 66)) | (1L << (STRAFTER - 66)) | (1L << (REPLACE - 66)) | (1L << (YEAR - 66)) | (1L << (MONTH - 66)) | (1L << (DAY - 66)) | (1L << (HOURS - 66)) | (1L << (MINUTES - 66)) | (1L << (SECONDS - 66)) | (1L << (TIMEZONE - 66)) | (1L << (TZ - 66)) | (1L << (NOW - 66)) | (1L << (UUID - 66)) | (1L << (STRUUID - 66)) | (1L << (MD5 - 66)) | (1L << (SHA1 - 66)) | (1L << (SHA256 - 66)) | (1L << (SHA384 - 66)) | (1L << (SHA512 - 66)) | (1L << (COALESCE - 66)) | (1L << (IF - 66)) | (1L << (STRLANG - 66)) | (1L << (STRDT - 66)) | (1L << (ISNUMERIC - 66)) | (1L << (COUNT - 66)) | (1L << (SUM - 66)) | (1L << (MIN - 66)) | (1L << (MAX - 66)) | (1L << (AVG - 66)) | (1L << (SAMPLE - 66)) | (1L << (GROUP_CONCAT - 66)) | (1L << (NOT - 66)) | (1L << (EXISTS - 66)) | (1L << (IRIREF - 66)) | (1L << (PNAME_NS - 66)) | (1L << (PNAME_LN - 66)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (VAR1 - 131)) | (1L << (VAR2 - 131)) | (1L << (OPEN_BRACE - 131)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupConditionContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BuiltInCallContext builtInCall() {
			return getRuleContext(BuiltInCallContext.class,0);
		}
		public TerminalNode AS() { return getToken(StreamingSparql.AS, 0); }
		public GroupConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGroupCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGroupCondition(this);
		}
	}

	public final GroupConditionContext groupCondition() throws RecognitionException {
		GroupConditionContext _localctx = new GroupConditionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_groupCondition);
		int _la;
		try {
			setState(589);
			switch (_input.LA(1)) {
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
				enterOuterAlt(_localctx, 1);
				{
				setState(578); builtInCall();
				}
				break;
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(579); functionCall();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(580); match(OPEN_BRACE);
				setState(581); expression(0);
				setState(584);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(582); match(AS);
					setState(583); var();
					}
				}

				setState(586); match(CLOSE_BRACE);
				}
				break;
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 4);
				{
				setState(588); var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HavingClauseContext extends ParserRuleContext {
		public List<HavingConditionContext> havingCondition() {
			return getRuleContexts(HavingConditionContext.class);
		}
		public HavingConditionContext havingCondition(int i) {
			return getRuleContext(HavingConditionContext.class,i);
		}
		public TerminalNode HAVING() { return getToken(StreamingSparql.HAVING, 0); }
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_havingClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591); match(HAVING);
			setState(593); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(592); havingCondition();
				}
				}
				setState(595); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (IRI - 66)) | (1L << (URI - 66)) | (1L << (BNODE - 66)) | (1L << (RAND - 66)) | (1L << (ABS - 66)) | (1L << (CEIL - 66)) | (1L << (FLOOR - 66)) | (1L << (ROUND - 66)) | (1L << (CONCAT - 66)) | (1L << (STRLEN - 66)) | (1L << (UCASE - 66)) | (1L << (LCASE - 66)) | (1L << (ENCODE_FOR_URI - 66)) | (1L << (CONTAINS - 66)) | (1L << (STRSTARTS - 66)) | (1L << (STRENDS - 66)) | (1L << (STRBEFORE - 66)) | (1L << (STRAFTER - 66)) | (1L << (REPLACE - 66)) | (1L << (YEAR - 66)) | (1L << (MONTH - 66)) | (1L << (DAY - 66)) | (1L << (HOURS - 66)) | (1L << (MINUTES - 66)) | (1L << (SECONDS - 66)) | (1L << (TIMEZONE - 66)) | (1L << (TZ - 66)) | (1L << (NOW - 66)) | (1L << (UUID - 66)) | (1L << (STRUUID - 66)) | (1L << (MD5 - 66)) | (1L << (SHA1 - 66)) | (1L << (SHA256 - 66)) | (1L << (SHA384 - 66)) | (1L << (SHA512 - 66)) | (1L << (COALESCE - 66)) | (1L << (IF - 66)) | (1L << (STRLANG - 66)) | (1L << (STRDT - 66)) | (1L << (ISNUMERIC - 66)) | (1L << (COUNT - 66)) | (1L << (SUM - 66)) | (1L << (MIN - 66)) | (1L << (MAX - 66)) | (1L << (AVG - 66)) | (1L << (SAMPLE - 66)) | (1L << (GROUP_CONCAT - 66)) | (1L << (NOT - 66)) | (1L << (EXISTS - 66)) | (1L << (IRIREF - 66)) | (1L << (PNAME_NS - 66)) | (1L << (PNAME_LN - 66)))) != 0) || _la==OPEN_BRACE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HavingConditionContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public HavingConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterHavingCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitHavingCondition(this);
		}
	}

	public final HavingConditionContext havingCondition() throws RecognitionException {
		HavingConditionContext _localctx = new HavingConditionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_havingCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); constraint();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderClauseContext extends ParserRuleContext {
		public List<OrderConditionContext> orderCondition() {
			return getRuleContexts(OrderConditionContext.class);
		}
		public TerminalNode ORDER() { return getToken(StreamingSparql.ORDER, 0); }
		public OrderConditionContext orderCondition(int i) {
			return getRuleContext(OrderConditionContext.class,i);
		}
		public TerminalNode BY() { return getToken(StreamingSparql.BY, 0); }
		public OrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterOrderClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitOrderClause(this);
		}
	}

	public final OrderClauseContext orderClause() throws RecognitionException {
		OrderClauseContext _localctx = new OrderClauseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_orderClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599); match(ORDER);
			setState(600); match(BY);
			setState(602); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(601); orderCondition();
				}
				}
				setState(604); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASC) | (1L << DESC) | (1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (IRI - 66)) | (1L << (URI - 66)) | (1L << (BNODE - 66)) | (1L << (RAND - 66)) | (1L << (ABS - 66)) | (1L << (CEIL - 66)) | (1L << (FLOOR - 66)) | (1L << (ROUND - 66)) | (1L << (CONCAT - 66)) | (1L << (STRLEN - 66)) | (1L << (UCASE - 66)) | (1L << (LCASE - 66)) | (1L << (ENCODE_FOR_URI - 66)) | (1L << (CONTAINS - 66)) | (1L << (STRSTARTS - 66)) | (1L << (STRENDS - 66)) | (1L << (STRBEFORE - 66)) | (1L << (STRAFTER - 66)) | (1L << (REPLACE - 66)) | (1L << (YEAR - 66)) | (1L << (MONTH - 66)) | (1L << (DAY - 66)) | (1L << (HOURS - 66)) | (1L << (MINUTES - 66)) | (1L << (SECONDS - 66)) | (1L << (TIMEZONE - 66)) | (1L << (TZ - 66)) | (1L << (NOW - 66)) | (1L << (UUID - 66)) | (1L << (STRUUID - 66)) | (1L << (MD5 - 66)) | (1L << (SHA1 - 66)) | (1L << (SHA256 - 66)) | (1L << (SHA384 - 66)) | (1L << (SHA512 - 66)) | (1L << (COALESCE - 66)) | (1L << (IF - 66)) | (1L << (STRLANG - 66)) | (1L << (STRDT - 66)) | (1L << (ISNUMERIC - 66)) | (1L << (COUNT - 66)) | (1L << (SUM - 66)) | (1L << (MIN - 66)) | (1L << (MAX - 66)) | (1L << (AVG - 66)) | (1L << (SAMPLE - 66)) | (1L << (GROUP_CONCAT - 66)) | (1L << (NOT - 66)) | (1L << (EXISTS - 66)) | (1L << (IRIREF - 66)) | (1L << (PNAME_NS - 66)) | (1L << (PNAME_LN - 66)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (VAR1 - 131)) | (1L << (VAR2 - 131)) | (1L << (OPEN_BRACE - 131)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderConditionContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(StreamingSparql.ASC, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode DESC() { return getToken(StreamingSparql.DESC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OrderConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterOrderCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitOrderCondition(this);
		}
	}

	public final OrderConditionContext orderCondition() throws RecognitionException {
		OrderConditionContext _localctx = new OrderConditionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_orderCondition);
		int _la;
		try {
			setState(613);
			switch (_input.LA(1)) {
			case ASC:
			case DESC:
				enterOuterAlt(_localctx, 1);
				{
				setState(606);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(607); match(OPEN_BRACE);
				setState(608); expression(0);
				setState(609); match(CLOSE_BRACE);
				}
				break;
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(611); constraint();
				}
				break;
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 3);
				{
				setState(612); var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitOffsetClausesContext extends ParserRuleContext {
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public OffsetClauseContext offsetClause() {
			return getRuleContext(OffsetClauseContext.class,0);
		}
		public LimitOffsetClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOffsetClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterLimitOffsetClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitLimitOffsetClauses(this);
		}
	}

	public final LimitOffsetClausesContext limitOffsetClauses() throws RecognitionException {
		LimitOffsetClausesContext _localctx = new LimitOffsetClausesContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_limitOffsetClauses);
		int _la;
		try {
			setState(623);
			switch (_input.LA(1)) {
			case LIMIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(615); limitClause();
				setState(617);
				_la = _input.LA(1);
				if (_la==OFFSET) {
					{
					setState(616); offsetClause();
					}
				}

				}
				break;
			case OFFSET:
				enterOuterAlt(_localctx, 2);
				{
				setState(619); offsetClause();
				setState(621);
				_la = _input.LA(1);
				if (_la==LIMIT) {
					{
					setState(620); limitClause();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitClauseContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(StreamingSparql.INTEGER, 0); }
		public TerminalNode LIMIT() { return getToken(StreamingSparql.LIMIT, 0); }
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625); match(LIMIT);
			setState(626); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OffsetClauseContext extends ParserRuleContext {
		public TerminalNode OFFSET() { return getToken(StreamingSparql.OFFSET, 0); }
		public TerminalNode INTEGER() { return getToken(StreamingSparql.INTEGER, 0); }
		public OffsetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offsetClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterOffsetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitOffsetClause(this);
		}
	}

	public final OffsetClauseContext offsetClause() throws RecognitionException {
		OffsetClauseContext _localctx = new OffsetClauseContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_offsetClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628); match(OFFSET);
			setState(629); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesClauseContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(StreamingSparql.VALUES, 0); }
		public DataBlockContext dataBlock() {
			return getRuleContext(DataBlockContext.class,0);
		}
		public ValuesClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuesClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterValuesClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitValuesClause(this);
		}
	}

	public final ValuesClauseContext valuesClause() throws RecognitionException {
		ValuesClauseContext _localctx = new ValuesClauseContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_valuesClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_la = _input.LA(1);
			if (_la==VALUES) {
				{
				setState(631); match(VALUES);
				setState(632); dataBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateCommandContext extends ParserRuleContext {
		public PrologueContext prologue(int i) {
			return getRuleContext(PrologueContext.class,i);
		}
		public List<PrologueContext> prologue() {
			return getRuleContexts(PrologueContext.class);
		}
		public UpdateContext update(int i) {
			return getRuleContext(UpdateContext.class,i);
		}
		public List<UpdateContext> update() {
			return getRuleContexts(UpdateContext.class);
		}
		public UpdateCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUpdateCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUpdateCommand(this);
		}
	}

	public final UpdateCommandContext updateCommand() throws RecognitionException {
		UpdateCommandContext _localctx = new UpdateCommandContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_updateCommand);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(635); prologue();
			setState(650);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << CLEAR) | (1L << DROP) | (1L << ADD) | (1L << MOVE) | (1L << COPY) | (1L << CREATE) | (1L << DELETE) | (1L << INSERT) | (1L << WITH))) != 0)) {
				{
				setState(636); update();
				setState(643);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(637); match(SEMICOLON);
						setState(638); prologue();
						setState(639); update();
						}
						} 
					}
					setState(645);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				setState(648);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(646); match(SEMICOLON);
					setState(647); prologue();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateContext extends ParserRuleContext {
		public CopyContext copy() {
			return getRuleContext(CopyContext.class,0);
		}
		public DeleteDataContext deleteData() {
			return getRuleContext(DeleteDataContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public ModifyContext modify() {
			return getRuleContext(ModifyContext.class,0);
		}
		public DeleteWhereContext deleteWhere() {
			return getRuleContext(DeleteWhereContext.class,0);
		}
		public ClearContext clear() {
			return getRuleContext(ClearContext.class,0);
		}
		public InsertDataContext insertData() {
			return getRuleContext(InsertDataContext.class,0);
		}
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public DropContext drop() {
			return getRuleContext(DropContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUpdate(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_update);
		try {
			setState(663);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(652); load();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(653); clear();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(654); drop();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(655); add();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(656); move();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(657); copy();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(658); create();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(659); insertData();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(660); deleteData();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(661); deleteWhere();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(662); modify();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public TerminalNode LOAD() { return getToken(StreamingSparql.LOAD, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public GraphRefContext graphRef() {
			return getRuleContext(GraphRefContext.class,0);
		}
		public TerminalNode INTO() { return getToken(StreamingSparql.INTO, 0); }
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitLoad(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_load);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665); match(LOAD);
			setState(667);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(666); match(SILENT);
				}
			}

			setState(669); iri();
			setState(672);
			_la = _input.LA(1);
			if (_la==INTO) {
				{
				setState(670); match(INTO);
				setState(671); graphRef();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClearContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public GraphRefAllContext graphRefAll() {
			return getRuleContext(GraphRefAllContext.class,0);
		}
		public TerminalNode CLEAR() { return getToken(StreamingSparql.CLEAR, 0); }
		public ClearContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clear; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterClear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitClear(this);
		}
	}

	public final ClearContext clear() throws RecognitionException {
		ClearContext _localctx = new ClearContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_clear);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674); match(CLEAR);
			setState(676);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(675); match(SILENT);
				}
			}

			setState(678); graphRefAll();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public GraphRefAllContext graphRefAll() {
			return getRuleContext(GraphRefAllContext.class,0);
		}
		public TerminalNode DROP() { return getToken(StreamingSparql.DROP, 0); }
		public DropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDrop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDrop(this);
		}
	}

	public final DropContext drop() throws RecognitionException {
		DropContext _localctx = new DropContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_drop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680); match(DROP);
			setState(682);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(681); match(SILENT);
				}
			}

			setState(684); graphRefAll();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public GraphRefContext graphRef() {
			return getRuleContext(GraphRefContext.class,0);
		}
		public TerminalNode CREATE() { return getToken(StreamingSparql.CREATE, 0); }
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitCreate(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_create);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686); match(CREATE);
			setState(688);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(687); match(SILENT);
				}
			}

			setState(690); graphRef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public List<GraphOrDefaultContext> graphOrDefault() {
			return getRuleContexts(GraphOrDefaultContext.class);
		}
		public GraphOrDefaultContext graphOrDefault(int i) {
			return getRuleContext(GraphOrDefaultContext.class,i);
		}
		public TerminalNode ADD() { return getToken(StreamingSparql.ADD, 0); }
		public TerminalNode TO() { return getToken(StreamingSparql.TO, 0); }
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitAdd(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692); match(ADD);
			setState(694);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(693); match(SILENT);
				}
			}

			setState(696); graphOrDefault();
			setState(697); match(TO);
			setState(698); graphOrDefault();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MoveContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public List<GraphOrDefaultContext> graphOrDefault() {
			return getRuleContexts(GraphOrDefaultContext.class);
		}
		public GraphOrDefaultContext graphOrDefault(int i) {
			return getRuleContext(GraphOrDefaultContext.class,i);
		}
		public TerminalNode TO() { return getToken(StreamingSparql.TO, 0); }
		public TerminalNode MOVE() { return getToken(StreamingSparql.MOVE, 0); }
		public MoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitMove(this);
		}
	}

	public final MoveContext move() throws RecognitionException {
		MoveContext _localctx = new MoveContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_move);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700); match(MOVE);
			setState(702);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(701); match(SILENT);
				}
			}

			setState(704); graphOrDefault();
			setState(705); match(TO);
			setState(706); graphOrDefault();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CopyContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public List<GraphOrDefaultContext> graphOrDefault() {
			return getRuleContexts(GraphOrDefaultContext.class);
		}
		public GraphOrDefaultContext graphOrDefault(int i) {
			return getRuleContext(GraphOrDefaultContext.class,i);
		}
		public TerminalNode COPY() { return getToken(StreamingSparql.COPY, 0); }
		public TerminalNode TO() { return getToken(StreamingSparql.TO, 0); }
		public CopyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterCopy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitCopy(this);
		}
	}

	public final CopyContext copy() throws RecognitionException {
		CopyContext _localctx = new CopyContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_copy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708); match(COPY);
			setState(710);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(709); match(SILENT);
				}
			}

			setState(712); graphOrDefault();
			setState(713); match(TO);
			setState(714); graphOrDefault();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertDataContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(StreamingSparql.DATA, 0); }
		public TerminalNode INSERT() { return getToken(StreamingSparql.INSERT, 0); }
		public QuadDataContext quadData() {
			return getRuleContext(QuadDataContext.class,0);
		}
		public InsertDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterInsertData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitInsertData(this);
		}
	}

	public final InsertDataContext insertData() throws RecognitionException {
		InsertDataContext _localctx = new InsertDataContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_insertData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716); match(INSERT);
			setState(717); match(DATA);
			setState(718); quadData();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteDataContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(StreamingSparql.DELETE, 0); }
		public TerminalNode DATA() { return getToken(StreamingSparql.DATA, 0); }
		public QuadDataContext quadData() {
			return getRuleContext(QuadDataContext.class,0);
		}
		public DeleteDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDeleteData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDeleteData(this);
		}
	}

	public final DeleteDataContext deleteData() throws RecognitionException {
		DeleteDataContext _localctx = new DeleteDataContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_deleteData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720); match(DELETE);
			setState(721); match(DATA);
			setState(722); quadData();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteWhereContext extends ParserRuleContext {
		public QuadPatternContext quadPattern() {
			return getRuleContext(QuadPatternContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(StreamingSparql.DELETE, 0); }
		public TerminalNode WHERE() { return getToken(StreamingSparql.WHERE, 0); }
		public DeleteWhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteWhere; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDeleteWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDeleteWhere(this);
		}
	}

	public final DeleteWhereContext deleteWhere() throws RecognitionException {
		DeleteWhereContext _localctx = new DeleteWhereContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_deleteWhere);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724); match(DELETE);
			setState(725); match(WHERE);
			setState(726); quadPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifyContext extends ParserRuleContext {
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public TerminalNode WITH() { return getToken(StreamingSparql.WITH, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(StreamingSparql.WHERE, 0); }
		public List<UsingClauseContext> usingClause() {
			return getRuleContexts(UsingClauseContext.class);
		}
		public DeleteClauseContext deleteClause() {
			return getRuleContext(DeleteClauseContext.class,0);
		}
		public UsingClauseContext usingClause(int i) {
			return getRuleContext(UsingClauseContext.class,i);
		}
		public InsertClauseContext insertClause() {
			return getRuleContext(InsertClauseContext.class,0);
		}
		public ModifyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modify; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterModify(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitModify(this);
		}
	}

	public final ModifyContext modify() throws RecognitionException {
		ModifyContext _localctx = new ModifyContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_modify);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(728); match(WITH);
				setState(729); iri();
				}
			}

			setState(737);
			switch (_input.LA(1)) {
			case DELETE:
				{
				setState(732); deleteClause();
				setState(734);
				_la = _input.LA(1);
				if (_la==INSERT) {
					{
					setState(733); insertClause();
					}
				}

				}
				break;
			case INSERT:
				{
				setState(736); insertClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(739); usingClause();
				}
				}
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(745); match(WHERE);
			setState(746); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteClauseContext extends ParserRuleContext {
		public QuadPatternContext quadPattern() {
			return getRuleContext(QuadPatternContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(StreamingSparql.DELETE, 0); }
		public DeleteClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDeleteClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDeleteClause(this);
		}
	}

	public final DeleteClauseContext deleteClause() throws RecognitionException {
		DeleteClauseContext _localctx = new DeleteClauseContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_deleteClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748); match(DELETE);
			setState(749); quadPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertClauseContext extends ParserRuleContext {
		public QuadPatternContext quadPattern() {
			return getRuleContext(QuadPatternContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(StreamingSparql.INSERT, 0); }
		public InsertClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterInsertClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitInsertClause(this);
		}
	}

	public final InsertClauseContext insertClause() throws RecognitionException {
		InsertClauseContext _localctx = new InsertClauseContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_insertClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751); match(INSERT);
			setState(752); quadPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingClauseContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode USING() { return getToken(StreamingSparql.USING, 0); }
		public TerminalNode NAMED() { return getToken(StreamingSparql.NAMED, 0); }
		public UsingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUsingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUsingClause(this);
		}
	}

	public final UsingClauseContext usingClause() throws RecognitionException {
		UsingClauseContext _localctx = new UsingClauseContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_usingClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(754); match(USING);
			setState(756);
			_la = _input.LA(1);
			if (_la==NAMED) {
				{
				setState(755); match(NAMED);
				}
			}

			setState(758); iri();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphOrDefaultContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode GRAPH() { return getToken(StreamingSparql.GRAPH, 0); }
		public TerminalNode DEFAULT() { return getToken(StreamingSparql.DEFAULT, 0); }
		public GraphOrDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphOrDefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphOrDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphOrDefault(this);
		}
	}

	public final GraphOrDefaultContext graphOrDefault() throws RecognitionException {
		GraphOrDefaultContext _localctx = new GraphOrDefaultContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_graphOrDefault);
		int _la;
		try {
			setState(765);
			switch (_input.LA(1)) {
			case DEFAULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(760); match(DEFAULT);
				}
				break;
			case GRAPH:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
				_la = _input.LA(1);
				if (_la==GRAPH) {
					{
					setState(761); match(GRAPH);
					}
				}

				setState(764); iri();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphRefContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode GRAPH() { return getToken(StreamingSparql.GRAPH, 0); }
		public GraphRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphRef(this);
		}
	}

	public final GraphRefContext graphRef() throws RecognitionException {
		GraphRefContext _localctx = new GraphRefContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_graphRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767); match(GRAPH);
			setState(768); iri();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphRefAllContext extends ParserRuleContext {
		public GraphRefContext graphRef() {
			return getRuleContext(GraphRefContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(StreamingSparql.DEFAULT, 0); }
		public TerminalNode NAMED() { return getToken(StreamingSparql.NAMED, 0); }
		public TerminalNode ALL() { return getToken(StreamingSparql.ALL, 0); }
		public GraphRefAllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphRefAll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphRefAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphRefAll(this);
		}
	}

	public final GraphRefAllContext graphRefAll() throws RecognitionException {
		GraphRefAllContext _localctx = new GraphRefAllContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_graphRefAll);
		try {
			setState(774);
			switch (_input.LA(1)) {
			case GRAPH:
				enterOuterAlt(_localctx, 1);
				{
				setState(770); graphRef();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(771); match(DEFAULT);
				}
				break;
			case NAMED:
				enterOuterAlt(_localctx, 3);
				{
				setState(772); match(NAMED);
				}
				break;
			case ALL:
				enterOuterAlt(_localctx, 4);
				{
				setState(773); match(ALL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadPatternContext extends ParserRuleContext {
		public QuadsContext quads() {
			return getRuleContext(QuadsContext.class,0);
		}
		public QuadPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterQuadPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitQuadPattern(this);
		}
	}

	public final QuadPatternContext quadPattern() throws RecognitionException {
		QuadPatternContext _localctx = new QuadPatternContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_quadPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776); match(OPEN_CURLY_BRACE);
			setState(777); quads();
			setState(778); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadDataContext extends ParserRuleContext {
		public QuadsContext quads() {
			return getRuleContext(QuadsContext.class,0);
		}
		public QuadDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterQuadData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitQuadData(this);
		}
	}

	public final QuadDataContext quadData() throws RecognitionException {
		QuadDataContext _localctx = new QuadDataContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_quadData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780); match(OPEN_CURLY_BRACE);
			setState(781); quads();
			setState(782); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadsContext extends ParserRuleContext {
		public QuadsDetailsContext quadsDetails(int i) {
			return getRuleContext(QuadsDetailsContext.class,i);
		}
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public List<QuadsDetailsContext> quadsDetails() {
			return getRuleContexts(QuadsDetailsContext.class);
		}
		public QuadsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quads; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterQuads(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitQuads(this);
		}
	}

	public final QuadsContext quads() throws RecognitionException {
		QuadsContext _localctx = new QuadsContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_quads);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
				{
				setState(784); triplesTemplate();
				}
			}

			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GRAPH) {
				{
				{
				setState(787); quadsDetails();
				}
				}
				setState(792);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadsDetailsContext extends ParserRuleContext {
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public QuadsNotTriplesContext quadsNotTriples() {
			return getRuleContext(QuadsNotTriplesContext.class,0);
		}
		public QuadsDetailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadsDetails; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterQuadsDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitQuadsDetails(this);
		}
	}

	public final QuadsDetailsContext quadsDetails() throws RecognitionException {
		QuadsDetailsContext _localctx = new QuadsDetailsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_quadsDetails);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793); quadsNotTriples();
			setState(795);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(794); match(DOT);
				}
			}

			setState(798);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
				{
				setState(797); triplesTemplate();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadsNotTriplesContext extends ParserRuleContext {
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public TerminalNode GRAPH() { return getToken(StreamingSparql.GRAPH, 0); }
		public QuadsNotTriplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadsNotTriples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterQuadsNotTriples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitQuadsNotTriples(this);
		}
	}

	public final QuadsNotTriplesContext quadsNotTriples() throws RecognitionException {
		QuadsNotTriplesContext _localctx = new QuadsNotTriplesContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_quadsNotTriples);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800); match(GRAPH);
			setState(801); varOrIRI();
			setState(802); match(OPEN_CURLY_BRACE);
			setState(804);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
				{
				setState(803); triplesTemplate();
				}
			}

			setState(806); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesTemplateContext extends ParserRuleContext {
		public List<TriplesSameSubjectContext> triplesSameSubject() {
			return getRuleContexts(TriplesSameSubjectContext.class);
		}
		public TriplesSameSubjectContext triplesSameSubject(int i) {
			return getRuleContext(TriplesSameSubjectContext.class,i);
		}
		public TriplesTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterTriplesTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitTriplesTemplate(this);
		}
	}

	public final TriplesTemplateContext triplesTemplate() throws RecognitionException {
		TriplesTemplateContext _localctx = new TriplesTemplateContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_triplesTemplate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808); triplesSameSubject();
			setState(815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(809); match(DOT);
				setState(811);
				_la = _input.LA(1);
				if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
					{
					setState(810); triplesSameSubject();
					}
				}

				}
				}
				setState(817);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternContext extends ParserRuleContext {
		public SubSelectContext subSelect() {
			return getRuleContext(SubSelectContext.class,0);
		}
		public GroupGraphPatternSubContext groupGraphPatternSub() {
			return getRuleContext(GroupGraphPatternSubContext.class,0);
		}
		public GroupGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGroupGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGroupGraphPattern(this);
		}
	}

	public final GroupGraphPatternContext groupGraphPattern() throws RecognitionException {
		GroupGraphPatternContext _localctx = new GroupGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_groupGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818); match(OPEN_CURLY_BRACE);
			setState(821);
			switch (_input.LA(1)) {
			case SELECT:
				{
				setState(819); subSelect();
				}
				break;
			case VALUES:
			case OPTIONAL:
			case GRAPH:
			case FILTER:
			case TRUE:
			case FALSE:
			case SERVICE:
			case BIND:
			case MINUS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case BLANK_NODE_LABEL:
			case VAR1:
			case VAR2:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
			case OPEN_CURLY_BRACE:
			case CLOSE_CURLY_BRACE:
			case OPEN_SQUARE_BRACKET:
				{
				setState(820); groupGraphPatternSub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(823); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternSubContext extends ParserRuleContext {
		public TriplesBlockContext triplesBlock() {
			return getRuleContext(TriplesBlockContext.class,0);
		}
		public GroupGraphPatternSubListContext groupGraphPatternSubList(int i) {
			return getRuleContext(GroupGraphPatternSubListContext.class,i);
		}
		public List<GroupGraphPatternSubListContext> groupGraphPatternSubList() {
			return getRuleContexts(GroupGraphPatternSubListContext.class);
		}
		public GroupGraphPatternSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPatternSub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGroupGraphPatternSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGroupGraphPatternSub(this);
		}
	}

	public final GroupGraphPatternSubContext groupGraphPatternSub() throws RecognitionException {
		GroupGraphPatternSubContext _localctx = new GroupGraphPatternSubContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_groupGraphPatternSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
				{
				setState(825); triplesBlock();
				}
			}

			setState(831);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (VALUES - 21)) | (1L << (OPTIONAL - 21)) | (1L << (GRAPH - 21)) | (1L << (FILTER - 21)) | (1L << (SERVICE - 21)) | (1L << (BIND - 21)) | (1L << (MINUS - 21)))) != 0) || _la==OPEN_CURLY_BRACE) {
				{
				{
				setState(828); groupGraphPatternSubList();
				}
				}
				setState(833);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternSubListContext extends ParserRuleContext {
		public GraphPatternNotTriplesContext graphPatternNotTriples() {
			return getRuleContext(GraphPatternNotTriplesContext.class,0);
		}
		public TriplesBlockContext triplesBlock() {
			return getRuleContext(TriplesBlockContext.class,0);
		}
		public GroupGraphPatternSubListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPatternSubList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGroupGraphPatternSubList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGroupGraphPatternSubList(this);
		}
	}

	public final GroupGraphPatternSubListContext groupGraphPatternSubList() throws RecognitionException {
		GroupGraphPatternSubListContext _localctx = new GroupGraphPatternSubListContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_groupGraphPatternSubList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834); graphPatternNotTriples();
			setState(836);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(835); match(DOT);
				}
			}

			setState(839);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
				{
				setState(838); triplesBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesBlockContext extends ParserRuleContext {
		public List<TriplesSameSubjectPathContext> triplesSameSubjectPath() {
			return getRuleContexts(TriplesSameSubjectPathContext.class);
		}
		public TriplesSameSubjectPathContext triplesSameSubjectPath(int i) {
			return getRuleContext(TriplesSameSubjectPathContext.class,i);
		}
		public TriplesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterTriplesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitTriplesBlock(this);
		}
	}

	public final TriplesBlockContext triplesBlock() throws RecognitionException {
		TriplesBlockContext _localctx = new TriplesBlockContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_triplesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841); triplesSameSubjectPath();
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(842); match(DOT);
				setState(844);
				_la = _input.LA(1);
				if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
					{
					setState(843); triplesSameSubjectPath();
					}
				}

				}
				}
				setState(850);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphPatternNotTriplesContext extends ParserRuleContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public MinusGraphPatternContext minusGraphPattern() {
			return getRuleContext(MinusGraphPatternContext.class,0);
		}
		public BindContext bind() {
			return getRuleContext(BindContext.class,0);
		}
		public OptionalGraphPatternContext optionalGraphPattern() {
			return getRuleContext(OptionalGraphPatternContext.class,0);
		}
		public GroupOrUnionGraphPatternContext groupOrUnionGraphPattern() {
			return getRuleContext(GroupOrUnionGraphPatternContext.class,0);
		}
		public ServiceGraphPatternContext serviceGraphPattern() {
			return getRuleContext(ServiceGraphPatternContext.class,0);
		}
		public InlineDataContext inlineData() {
			return getRuleContext(InlineDataContext.class,0);
		}
		public GraphGraphPatternContext graphGraphPattern() {
			return getRuleContext(GraphGraphPatternContext.class,0);
		}
		public GraphPatternNotTriplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphPatternNotTriples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphPatternNotTriples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphPatternNotTriples(this);
		}
	}

	public final GraphPatternNotTriplesContext graphPatternNotTriples() throws RecognitionException {
		GraphPatternNotTriplesContext _localctx = new GraphPatternNotTriplesContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_graphPatternNotTriples);
		try {
			setState(859);
			switch (_input.LA(1)) {
			case OPEN_CURLY_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(851); groupOrUnionGraphPattern();
				}
				break;
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(852); optionalGraphPattern();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(853); minusGraphPattern();
				}
				break;
			case GRAPH:
				enterOuterAlt(_localctx, 4);
				{
				setState(854); graphGraphPattern();
				}
				break;
			case SERVICE:
				enterOuterAlt(_localctx, 5);
				{
				setState(855); serviceGraphPattern();
				}
				break;
			case FILTER:
				enterOuterAlt(_localctx, 6);
				{
				setState(856); filter();
				}
				break;
			case BIND:
				enterOuterAlt(_localctx, 7);
				{
				setState(857); bind();
				}
				break;
			case VALUES:
				enterOuterAlt(_localctx, 8);
				{
				setState(858); inlineData();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionalGraphPatternContext extends ParserRuleContext {
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public TerminalNode OPTIONAL() { return getToken(StreamingSparql.OPTIONAL, 0); }
		public OptionalGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterOptionalGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitOptionalGraphPattern(this);
		}
	}

	public final OptionalGraphPatternContext optionalGraphPattern() throws RecognitionException {
		OptionalGraphPatternContext _localctx = new OptionalGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_optionalGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861); match(OPTIONAL);
			setState(862); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphGraphPatternContext extends ParserRuleContext {
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public TerminalNode GRAPH() { return getToken(StreamingSparql.GRAPH, 0); }
		public GraphGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphGraphPattern(this);
		}
	}

	public final GraphGraphPatternContext graphGraphPattern() throws RecognitionException {
		GraphGraphPatternContext _localctx = new GraphGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_graphGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864); match(GRAPH);
			setState(865); varOrIRI();
			setState(866); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ServiceGraphPatternContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(StreamingSparql.SILENT, 0); }
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public TerminalNode SERVICE() { return getToken(StreamingSparql.SERVICE, 0); }
		public ServiceGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterServiceGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitServiceGraphPattern(this);
		}
	}

	public final ServiceGraphPatternContext serviceGraphPattern() throws RecognitionException {
		ServiceGraphPatternContext _localctx = new ServiceGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_serviceGraphPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868); match(SERVICE);
			setState(870);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(869); match(SILENT);
				}
			}

			setState(872); varOrIRI();
			setState(873); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode BIND() { return getToken(StreamingSparql.BIND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(StreamingSparql.AS, 0); }
		public BindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBind(this);
		}
	}

	public final BindContext bind() throws RecognitionException {
		BindContext _localctx = new BindContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_bind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875); match(BIND);
			setState(876); match(OPEN_BRACE);
			setState(877); expression(0);
			setState(878); match(AS);
			setState(879); var();
			setState(880); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineDataContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(StreamingSparql.VALUES, 0); }
		public DataBlockContext dataBlock() {
			return getRuleContext(DataBlockContext.class,0);
		}
		public InlineDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterInlineData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitInlineData(this);
		}
	}

	public final InlineDataContext inlineData() throws RecognitionException {
		InlineDataContext _localctx = new InlineDataContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_inlineData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(882); match(VALUES);
			setState(883); dataBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataBlockContext extends ParserRuleContext {
		public InlineDataFullContext inlineDataFull() {
			return getRuleContext(InlineDataFullContext.class,0);
		}
		public InlineDataOneVarContext inlineDataOneVar() {
			return getRuleContext(InlineDataOneVarContext.class,0);
		}
		public DataBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDataBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDataBlock(this);
		}
	}

	public final DataBlockContext dataBlock() throws RecognitionException {
		DataBlockContext _localctx = new DataBlockContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_dataBlock);
		try {
			setState(887);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(885); inlineDataOneVar();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(886); inlineDataFull();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineDataOneVarContext extends ParserRuleContext {
		public DataBlockValueContext dataBlockValue(int i) {
			return getRuleContext(DataBlockValueContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<DataBlockValueContext> dataBlockValue() {
			return getRuleContexts(DataBlockValueContext.class);
		}
		public InlineDataOneVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineDataOneVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterInlineDataOneVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitInlineDataOneVar(this);
		}
	}

	public final InlineDataOneVarContext inlineDataOneVar() throws RecognitionException {
		InlineDataOneVarContext _localctx = new InlineDataOneVarContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_inlineDataOneVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(889); var();
			setState(890); match(OPEN_CURLY_BRACE);
			setState(894);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << UNDEF))) != 0) || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)))) != 0)) {
				{
				{
				setState(891); dataBlockValue();
				}
				}
				setState(896);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(897); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineDataFullContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public List<DataBlockValuesContext> dataBlockValues() {
			return getRuleContexts(DataBlockValuesContext.class);
		}
		public DataBlockValuesContext dataBlockValues(int i) {
			return getRuleContext(DataBlockValuesContext.class,i);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public InlineDataFullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineDataFull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterInlineDataFull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitInlineDataFull(this);
		}
	}

	public final InlineDataFullContext inlineDataFull() throws RecognitionException {
		InlineDataFullContext _localctx = new InlineDataFullContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_inlineDataFull);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899); match(OPEN_BRACE);
			setState(903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR1 || _la==VAR2) {
				{
				{
				setState(900); var();
				}
				}
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(906); match(CLOSE_BRACE);
			setState(907); match(OPEN_CURLY_BRACE);
			setState(911);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_BRACE) {
				{
				{
				setState(908); dataBlockValues();
				}
				}
				setState(913);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(914); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataBlockValuesContext extends ParserRuleContext {
		public DataBlockValueContext dataBlockValue(int i) {
			return getRuleContext(DataBlockValueContext.class,i);
		}
		public List<DataBlockValueContext> dataBlockValue() {
			return getRuleContexts(DataBlockValueContext.class);
		}
		public DataBlockValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBlockValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDataBlockValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDataBlockValues(this);
		}
	}

	public final DataBlockValuesContext dataBlockValues() throws RecognitionException {
		DataBlockValuesContext _localctx = new DataBlockValuesContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_dataBlockValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916); match(OPEN_BRACE);
			setState(920);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << UNDEF))) != 0) || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)))) != 0)) {
				{
				{
				setState(917); dataBlockValue();
				}
				}
				setState(922);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(923); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataBlockValueContext extends ParserRuleContext {
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public TerminalNode UNDEF() { return getToken(StreamingSparql.UNDEF, 0); }
		public RdfLiteralContext rdfLiteral() {
			return getRuleContext(RdfLiteralContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public DataBlockValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBlockValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterDataBlockValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitDataBlockValue(this);
		}
	}

	public final DataBlockValueContext dataBlockValue() throws RecognitionException {
		DataBlockValueContext _localctx = new DataBlockValueContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_dataBlockValue);
		try {
			setState(930);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(925); iri();
				}
				break;
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
				enterOuterAlt(_localctx, 2);
				{
				setState(926); rdfLiteral();
				}
				break;
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(927); numericLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(928); booleanLiteral();
				}
				break;
			case UNDEF:
				enterOuterAlt(_localctx, 5);
				{
				setState(929); match(UNDEF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinusGraphPatternContext extends ParserRuleContext {
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(StreamingSparql.MINUS, 0); }
		public MinusGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minusGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterMinusGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitMinusGraphPattern(this);
		}
	}

	public final MinusGraphPatternContext minusGraphPattern() throws RecognitionException {
		MinusGraphPatternContext _localctx = new MinusGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_minusGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(932); match(MINUS);
			setState(933); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupOrUnionGraphPatternContext extends ParserRuleContext {
		public List<TerminalNode> UNION() { return getTokens(StreamingSparql.UNION); }
		public List<GroupGraphPatternContext> groupGraphPattern() {
			return getRuleContexts(GroupGraphPatternContext.class);
		}
		public GroupGraphPatternContext groupGraphPattern(int i) {
			return getRuleContext(GroupGraphPatternContext.class,i);
		}
		public TerminalNode UNION(int i) {
			return getToken(StreamingSparql.UNION, i);
		}
		public GroupOrUnionGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupOrUnionGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGroupOrUnionGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGroupOrUnionGraphPattern(this);
		}
	}

	public final GroupOrUnionGraphPatternContext groupOrUnionGraphPattern() throws RecognitionException {
		GroupOrUnionGraphPatternContext _localctx = new GroupOrUnionGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_groupOrUnionGraphPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(935); groupGraphPattern();
			setState(940);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNION) {
				{
				{
				setState(936); match(UNION);
				setState(937); groupGraphPattern();
				}
				}
				setState(942);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode FILTER() { return getToken(StreamingSparql.FILTER, 0); }
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitFilter(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_filter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943); match(FILTER);
			setState(944); constraint();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BuiltInCallContext builtInCall() {
			return getRuleContext(BuiltInCallContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitConstraint(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_constraint);
		try {
			setState(952);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(946); match(OPEN_BRACE);
				setState(947); expression(0);
				setState(948); match(CLOSE_BRACE);
				}
				break;
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(950); builtInCall();
				}
				break;
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 3);
				{
				setState(951); functionCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954); iri();
			setState(955); argList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode DISTINCT() { return getToken(StreamingSparql.DISTINCT, 0); }
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957); match(OPEN_BRACE);
			setState(963);
			switch (_input.LA(1)) {
			case DISTINCT:
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case TRUE:
			case FALSE:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case ASTERISK:
			case NEGATION:
			case DIVIDE:
				{
				setState(959);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(958); match(DISTINCT);
					}
				}

				setState(961); expressionList();
				}
				break;
			case CLOSE_BRACE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(965); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(967); expression(0);
			setState(972);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(968); match(COMMA);
				setState(969); expression(0);
				}
				}
				setState(974);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructTemplateContext extends ParserRuleContext {
		public ConstructTriplesContext constructTriples() {
			return getRuleContext(ConstructTriplesContext.class,0);
		}
		public ConstructTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterConstructTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitConstructTemplate(this);
		}
	}

	public final ConstructTemplateContext constructTemplate() throws RecognitionException {
		ConstructTemplateContext _localctx = new ConstructTemplateContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_constructTemplate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(975); match(OPEN_CURLY_BRACE);
			setState(977);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
				{
				setState(976); constructTriples();
				}
			}

			setState(979); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructTriplesContext extends ParserRuleContext {
		public TriplesSameSubjectContext triplesSameSubject() {
			return getRuleContext(TriplesSameSubjectContext.class,0);
		}
		public ConstructTriplesContext constructTriples(int i) {
			return getRuleContext(ConstructTriplesContext.class,i);
		}
		public List<ConstructTriplesContext> constructTriples() {
			return getRuleContexts(ConstructTriplesContext.class);
		}
		public ConstructTriplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructTriples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterConstructTriples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitConstructTriples(this);
		}
	}

	public final ConstructTriplesContext constructTriples() throws RecognitionException {
		ConstructTriplesContext _localctx = new ConstructTriplesContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_constructTriples);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(981); triplesSameSubject();
			setState(988);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(982); match(DOT);
					setState(984);
					_la = _input.LA(1);
					if (_la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0)) {
						{
						setState(983); constructTriples();
						}
					}

					}
					} 
				}
				setState(990);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesSameSubjectContext extends ParserRuleContext {
		public PropertyListNotEmptyContext propertyListNotEmpty() {
			return getRuleContext(PropertyListNotEmptyContext.class,0);
		}
		public TriplesNodeContext triplesNode() {
			return getRuleContext(TriplesNodeContext.class,0);
		}
		public PropertyListContext propertyList() {
			return getRuleContext(PropertyListContext.class,0);
		}
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public TriplesSameSubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesSameSubject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterTriplesSameSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitTriplesSameSubject(this);
		}
	}

	public final TriplesSameSubjectContext triplesSameSubject() throws RecognitionException {
		TriplesSameSubjectContext _localctx = new TriplesSameSubjectContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_triplesSameSubject);
		try {
			setState(997);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(991); varOrTerm();
				setState(992); propertyListNotEmpty();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(994); triplesNode();
				setState(995); propertyList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListContext extends ParserRuleContext {
		public PropertyListNotEmptyContext propertyListNotEmpty() {
			return getRuleContext(PropertyListNotEmptyContext.class,0);
		}
		public PropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPropertyList(this);
		}
	}

	public final PropertyListContext propertyList() throws RecognitionException {
		PropertyListContext _localctx = new PropertyListContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_propertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1000);
			_la = _input.LA(1);
			if (_la==A || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)))) != 0)) {
				{
				setState(999); propertyListNotEmpty();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListNotEmptyContext extends ParserRuleContext {
		public List<ObjectListContext> objectList() {
			return getRuleContexts(ObjectListContext.class);
		}
		public VerbContext verb(int i) {
			return getRuleContext(VerbContext.class,i);
		}
		public ObjectListContext objectList(int i) {
			return getRuleContext(ObjectListContext.class,i);
		}
		public List<VerbContext> verb() {
			return getRuleContexts(VerbContext.class);
		}
		public PropertyListNotEmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListNotEmpty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPropertyListNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPropertyListNotEmpty(this);
		}
	}

	public final PropertyListNotEmptyContext propertyListNotEmpty() throws RecognitionException {
		PropertyListNotEmptyContext _localctx = new PropertyListNotEmptyContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_propertyListNotEmpty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1002); verb();
			setState(1003); objectList();
			setState(1012);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(1004); match(SEMICOLON);
				setState(1008);
				_la = _input.LA(1);
				if (_la==A || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)))) != 0)) {
					{
					setState(1005); verb();
					setState(1006); objectList();
					}
				}

				}
				}
				setState(1014);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerbContext extends ParserRuleContext {
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public TerminalNode A() { return getToken(StreamingSparql.A, 0); }
		public VerbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterVerb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitVerb(this);
		}
	}

	public final VerbContext verb() throws RecognitionException {
		VerbContext _localctx = new VerbContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_verb);
		try {
			setState(1017);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(1015); varOrIRI();
				}
				break;
			case A:
				enterOuterAlt(_localctx, 2);
				{
				setState(1016); match(A);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectListContext extends ParserRuleContext {
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterObjectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitObjectList(this);
		}
	}

	public final ObjectListContext objectList() throws RecognitionException {
		ObjectListContext _localctx = new ObjectListContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_objectList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019); object();
			setState(1024);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1020); match(COMMA);
				setState(1021); object();
				}
				}
				setState(1026);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectContext extends ParserRuleContext {
		public GraphNodeContext graphNode() {
			return getRuleContext(GraphNodeContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1027); graphNode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesSameSubjectPathContext extends ParserRuleContext {
		public PropertyListPathNotEmptyContext propertyListPathNotEmpty() {
			return getRuleContext(PropertyListPathNotEmptyContext.class,0);
		}
		public TriplesNodePathContext triplesNodePath() {
			return getRuleContext(TriplesNodePathContext.class,0);
		}
		public PropertyListPathContext propertyListPath() {
			return getRuleContext(PropertyListPathContext.class,0);
		}
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public TriplesSameSubjectPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesSameSubjectPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterTriplesSameSubjectPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitTriplesSameSubjectPath(this);
		}
	}

	public final TriplesSameSubjectPathContext triplesSameSubjectPath() throws RecognitionException {
		TriplesSameSubjectPathContext _localctx = new TriplesSameSubjectPathContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_triplesSameSubjectPath);
		try {
			setState(1035);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1029); varOrTerm();
				setState(1030); propertyListPathNotEmpty();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1032); triplesNodePath();
				setState(1033); propertyListPath();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListPathContext extends ParserRuleContext {
		public PropertyListPathNotEmptyContext propertyListPathNotEmpty() {
			return getRuleContext(PropertyListPathNotEmptyContext.class,0);
		}
		public PropertyListPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPropertyListPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPropertyListPath(this);
		}
	}

	public final PropertyListPathContext propertyListPath() throws RecognitionException {
		PropertyListPathContext _localctx = new PropertyListPathContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_propertyListPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1038);
			_la = _input.LA(1);
			if (_la==A || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INVERSE - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (NEGATION - 127)))) != 0)) {
				{
				setState(1037); propertyListPathNotEmpty();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListPathNotEmptyContext extends ParserRuleContext {
		public ObjectListPathContext objectListPath() {
			return getRuleContext(ObjectListPathContext.class,0);
		}
		public List<PropertyListPathNotEmptyListContext> propertyListPathNotEmptyList() {
			return getRuleContexts(PropertyListPathNotEmptyListContext.class);
		}
		public PropertyListPathNotEmptyListContext propertyListPathNotEmptyList(int i) {
			return getRuleContext(PropertyListPathNotEmptyListContext.class,i);
		}
		public VerbSimpleContext verbSimple() {
			return getRuleContext(VerbSimpleContext.class,0);
		}
		public VerbPathContext verbPath() {
			return getRuleContext(VerbPathContext.class,0);
		}
		public PropertyListPathNotEmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListPathNotEmpty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPropertyListPathNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPropertyListPathNotEmpty(this);
		}
	}

	public final PropertyListPathNotEmptyContext propertyListPathNotEmpty() throws RecognitionException {
		PropertyListPathNotEmptyContext _localctx = new PropertyListPathNotEmptyContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_propertyListPathNotEmpty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			switch (_input.LA(1)) {
			case A:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case INVERSE:
			case OPEN_BRACE:
			case NEGATION:
				{
				setState(1040); verbPath();
				}
				break;
			case VAR1:
			case VAR2:
				{
				setState(1041); verbSimple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1044); objectListPath();
			setState(1051);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(1045); match(SEMICOLON);
				setState(1047);
				_la = _input.LA(1);
				if (_la==A || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INVERSE - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (NEGATION - 127)))) != 0)) {
					{
					setState(1046); propertyListPathNotEmptyList();
					}
				}

				}
				}
				setState(1053);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListPathNotEmptyListContext extends ParserRuleContext {
		public ObjectListContext objectList() {
			return getRuleContext(ObjectListContext.class,0);
		}
		public VerbSimpleContext verbSimple() {
			return getRuleContext(VerbSimpleContext.class,0);
		}
		public VerbPathContext verbPath() {
			return getRuleContext(VerbPathContext.class,0);
		}
		public PropertyListPathNotEmptyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListPathNotEmptyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPropertyListPathNotEmptyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPropertyListPathNotEmptyList(this);
		}
	}

	public final PropertyListPathNotEmptyListContext propertyListPathNotEmptyList() throws RecognitionException {
		PropertyListPathNotEmptyListContext _localctx = new PropertyListPathNotEmptyListContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_propertyListPathNotEmptyList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
			switch (_input.LA(1)) {
			case A:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case INVERSE:
			case OPEN_BRACE:
			case NEGATION:
				{
				setState(1054); verbPath();
				}
				break;
			case VAR1:
			case VAR2:
				{
				setState(1055); verbSimple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1058); objectList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerbPathContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public VerbPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterVerbPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitVerbPath(this);
		}
	}

	public final VerbPathContext verbPath() throws RecognitionException {
		VerbPathContext _localctx = new VerbPathContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_verbPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060); path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerbSimpleContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VerbSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterVerbSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitVerbSimple(this);
		}
	}

	public final VerbSimpleContext verbSimple() throws RecognitionException {
		VerbSimpleContext _localctx = new VerbSimpleContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_verbSimple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062); var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectListPathContext extends ParserRuleContext {
		public ObjectPathContext objectPath(int i) {
			return getRuleContext(ObjectPathContext.class,i);
		}
		public List<ObjectPathContext> objectPath() {
			return getRuleContexts(ObjectPathContext.class);
		}
		public ObjectListPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectListPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterObjectListPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitObjectListPath(this);
		}
	}

	public final ObjectListPathContext objectListPath() throws RecognitionException {
		ObjectListPathContext _localctx = new ObjectListPathContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_objectListPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064); objectPath();
			setState(1069);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1065); match(COMMA);
				setState(1066); objectPath();
				}
				}
				setState(1071);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectPathContext extends ParserRuleContext {
		public GraphNodePathContext graphNodePath() {
			return getRuleContext(GraphNodePathContext.class,0);
		}
		public ObjectPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterObjectPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitObjectPath(this);
		}
	}

	public final ObjectPathContext objectPath() throws RecognitionException {
		ObjectPathContext _localctx = new ObjectPathContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_objectPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072); graphNodePath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public PathAlternativeContext pathAlternative() {
			return getRuleContext(PathAlternativeContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1074); pathAlternative();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathAlternativeContext extends ParserRuleContext {
		public PathSequenceContext pathSequence(int i) {
			return getRuleContext(PathSequenceContext.class,i);
		}
		public List<PathSequenceContext> pathSequence() {
			return getRuleContexts(PathSequenceContext.class);
		}
		public PathAlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathAlternative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathAlternative(this);
		}
	}

	public final PathAlternativeContext pathAlternative() throws RecognitionException {
		PathAlternativeContext _localctx = new PathAlternativeContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_pathAlternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1076); pathSequence();
			setState(1081);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(1077); match(PIPE);
				setState(1078); pathSequence();
				}
				}
				setState(1083);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathSequenceContext extends ParserRuleContext {
		public PathEltOrInverseContext pathEltOrInverse(int i) {
			return getRuleContext(PathEltOrInverseContext.class,i);
		}
		public List<PathEltOrInverseContext> pathEltOrInverse() {
			return getRuleContexts(PathEltOrInverseContext.class);
		}
		public PathSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathSequence(this);
		}
	}

	public final PathSequenceContext pathSequence() throws RecognitionException {
		PathSequenceContext _localctx = new PathSequenceContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_pathSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084); pathEltOrInverse();
			setState(1089);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIVIDE) {
				{
				{
				setState(1085); match(DIVIDE);
				setState(1086); pathEltOrInverse();
				}
				}
				setState(1091);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathEltContext extends ParserRuleContext {
		public PathPrimaryContext pathPrimary() {
			return getRuleContext(PathPrimaryContext.class,0);
		}
		public PathModContext pathMod() {
			return getRuleContext(PathModContext.class,0);
		}
		public PathEltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathElt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathElt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathElt(this);
		}
	}

	public final PathEltContext pathElt() throws RecognitionException {
		PathEltContext _localctx = new PathEltContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_pathElt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1092); pathPrimary();
			setState(1094);
			_la = _input.LA(1);
			if (((((_la - 164)) & ~0x3f) == 0 && ((1L << (_la - 164)) & ((1L << (PLUS_SIGN - 164)) | (1L << (ASTERISK - 164)) | (1L << (QUESTION_MARK - 164)))) != 0)) {
				{
				setState(1093); pathMod();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathEltOrInverseContext extends ParserRuleContext {
		public PathEltContext pathElt() {
			return getRuleContext(PathEltContext.class,0);
		}
		public TerminalNode INVERSE() { return getToken(StreamingSparql.INVERSE, 0); }
		public PathEltOrInverseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathEltOrInverse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathEltOrInverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathEltOrInverse(this);
		}
	}

	public final PathEltOrInverseContext pathEltOrInverse() throws RecognitionException {
		PathEltOrInverseContext _localctx = new PathEltOrInverseContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_pathEltOrInverse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1097);
			_la = _input.LA(1);
			if (_la==INVERSE) {
				{
				setState(1096); match(INVERSE);
				}
			}

			setState(1099); pathElt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathModContext extends ParserRuleContext {
		public Token op;
		public PathModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathMod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathMod(this);
		}
	}

	public final PathModContext pathMod() throws RecognitionException {
		PathModContext _localctx = new PathModContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_pathMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1101);
			((PathModContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 164)) & ~0x3f) == 0 && ((1L << (_la - 164)) & ((1L << (PLUS_SIGN - 164)) | (1L << (ASTERISK - 164)) | (1L << (QUESTION_MARK - 164)))) != 0)) ) {
				((PathModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathPrimaryContext extends ParserRuleContext {
		public PathNegatedPropertySetContext pathNegatedPropertySet() {
			return getRuleContext(PathNegatedPropertySetContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode A() { return getToken(StreamingSparql.A, 0); }
		public PathPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathPrimary(this);
		}
	}

	public final PathPrimaryContext pathPrimary() throws RecognitionException {
		PathPrimaryContext _localctx = new PathPrimaryContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_pathPrimary);
		try {
			setState(1111);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1103); iri();
				}
				break;
			case A:
				enterOuterAlt(_localctx, 2);
				{
				setState(1104); match(A);
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(1105); match(NEGATION);
				setState(1106); pathNegatedPropertySet();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1107); match(OPEN_BRACE);
				setState(1108); path();
				setState(1109); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathNegatedPropertySetContext extends ParserRuleContext {
		public PathOneInPropertySetContext pathOneInPropertySet(int i) {
			return getRuleContext(PathOneInPropertySetContext.class,i);
		}
		public List<PathOneInPropertySetContext> pathOneInPropertySet() {
			return getRuleContexts(PathOneInPropertySetContext.class);
		}
		public PathNegatedPropertySetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathNegatedPropertySet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathNegatedPropertySet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathNegatedPropertySet(this);
		}
	}

	public final PathNegatedPropertySetContext pathNegatedPropertySet() throws RecognitionException {
		PathNegatedPropertySetContext _localctx = new PathNegatedPropertySetContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_pathNegatedPropertySet);
		int _la;
		try {
			setState(1126);
			switch (_input.LA(1)) {
			case A:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case INVERSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1113); pathOneInPropertySet();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1114); match(OPEN_BRACE);
				setState(1123);
				_la = _input.LA(1);
				if (_la==A || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (INVERSE - 127)))) != 0)) {
					{
					setState(1115); pathOneInPropertySet();
					setState(1120);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PIPE) {
						{
						{
						setState(1116); match(PIPE);
						setState(1117); pathOneInPropertySet();
						}
						}
						setState(1122);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1125); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathOneInPropertySetContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode INVERSE() { return getToken(StreamingSparql.INVERSE, 0); }
		public TerminalNode A() { return getToken(StreamingSparql.A, 0); }
		public PathOneInPropertySetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathOneInPropertySet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPathOneInPropertySet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPathOneInPropertySet(this);
		}
	}

	public final PathOneInPropertySetContext pathOneInPropertySet() throws RecognitionException {
		PathOneInPropertySetContext _localctx = new PathOneInPropertySetContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_pathOneInPropertySet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1129);
			_la = _input.LA(1);
			if (_la==INVERSE) {
				{
				setState(1128); match(INVERSE);
				}
			}

			setState(1133);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				{
				setState(1131); iri();
				}
				break;
			case A:
				{
				setState(1132); match(A);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(StreamingSparql.INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesNodeContext extends ParserRuleContext {
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public BlankNodePropertyListContext blankNodePropertyList() {
			return getRuleContext(BlankNodePropertyListContext.class,0);
		}
		public TriplesNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterTriplesNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitTriplesNode(this);
		}
	}

	public final TriplesNodeContext triplesNode() throws RecognitionException {
		TriplesNodeContext _localctx = new TriplesNodeContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_triplesNode);
		try {
			setState(1139);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1137); collection();
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1138); blankNodePropertyList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlankNodePropertyListContext extends ParserRuleContext {
		public PropertyListNotEmptyContext propertyListNotEmpty() {
			return getRuleContext(PropertyListNotEmptyContext.class,0);
		}
		public BlankNodePropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blankNodePropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBlankNodePropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBlankNodePropertyList(this);
		}
	}

	public final BlankNodePropertyListContext blankNodePropertyList() throws RecognitionException {
		BlankNodePropertyListContext _localctx = new BlankNodePropertyListContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_blankNodePropertyList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141); match(OPEN_SQUARE_BRACKET);
			setState(1142); propertyListNotEmpty();
			setState(1143); match(CLOSE_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesNodePathContext extends ParserRuleContext {
		public BlankNodePropertyListPathContext blankNodePropertyListPath() {
			return getRuleContext(BlankNodePropertyListPathContext.class,0);
		}
		public CollectionPathContext collectionPath() {
			return getRuleContext(CollectionPathContext.class,0);
		}
		public TriplesNodePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesNodePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterTriplesNodePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitTriplesNodePath(this);
		}
	}

	public final TriplesNodePathContext triplesNodePath() throws RecognitionException {
		TriplesNodePathContext _localctx = new TriplesNodePathContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_triplesNodePath);
		try {
			setState(1147);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1145); collectionPath();
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1146); blankNodePropertyListPath();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlankNodePropertyListPathContext extends ParserRuleContext {
		public PropertyListPathNotEmptyContext propertyListPathNotEmpty() {
			return getRuleContext(PropertyListPathNotEmptyContext.class,0);
		}
		public BlankNodePropertyListPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blankNodePropertyListPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBlankNodePropertyListPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBlankNodePropertyListPath(this);
		}
	}

	public final BlankNodePropertyListPathContext blankNodePropertyListPath() throws RecognitionException {
		BlankNodePropertyListPathContext _localctx = new BlankNodePropertyListPathContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_blankNodePropertyListPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1149); match(OPEN_SQUARE_BRACKET);
			setState(1150); propertyListPathNotEmpty();
			setState(1151); match(CLOSE_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionContext extends ParserRuleContext {
		public List<GraphNodeContext> graphNode() {
			return getRuleContexts(GraphNodeContext.class);
		}
		public GraphNodeContext graphNode(int i) {
			return getRuleContext(GraphNodeContext.class,i);
		}
		public CollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitCollection(this);
		}
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_collection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153); match(OPEN_BRACE);
			setState(1155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1154); graphNode();
				}
				}
				setState(1157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0) );
			setState(1159); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionPathContext extends ParserRuleContext {
		public List<GraphNodePathContext> graphNodePath() {
			return getRuleContexts(GraphNodePathContext.class);
		}
		public GraphNodePathContext graphNodePath(int i) {
			return getRuleContext(GraphNodePathContext.class,i);
		}
		public CollectionPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterCollectionPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitCollectionPath(this);
		}
	}

	public final CollectionPathContext collectionPath() throws RecognitionException {
		CollectionPathContext _localctx = new CollectionPathContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_collectionPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1161); match(OPEN_BRACE);
			setState(1163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1162); graphNodePath();
				}
				}
				setState(1165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TRUE || _la==FALSE || ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (IRIREF - 127)) | (1L << (PNAME_NS - 127)) | (1L << (PNAME_LN - 127)) | (1L << (BLANK_NODE_LABEL - 127)) | (1L << (VAR1 - 127)) | (1L << (VAR2 - 127)) | (1L << (INTEGER - 127)) | (1L << (DECIMAL - 127)) | (1L << (DOUBLE - 127)) | (1L << (INTEGER_POSITIVE - 127)) | (1L << (DECIMAL_POSITIVE - 127)) | (1L << (DOUBLE_POSITIVE - 127)) | (1L << (INTEGER_NEGATIVE - 127)) | (1L << (DECIMAL_NEGATIVE - 127)) | (1L << (DOUBLE_NEGATIVE - 127)) | (1L << (STRING_LITERAL1 - 127)) | (1L << (STRING_LITERAL2 - 127)) | (1L << (STRING_LITERAL_LONG1 - 127)) | (1L << (STRING_LITERAL_LONG2 - 127)) | (1L << (OPEN_BRACE - 127)) | (1L << (OPEN_SQUARE_BRACKET - 127)))) != 0) );
			setState(1167); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphNodeContext extends ParserRuleContext {
		public TriplesNodeContext triplesNode() {
			return getRuleContext(TriplesNodeContext.class,0);
		}
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public GraphNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphNode(this);
		}
	}

	public final GraphNodeContext graphNode() throws RecognitionException {
		GraphNodeContext _localctx = new GraphNodeContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_graphNode);
		try {
			setState(1171);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1169); varOrTerm();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1170); triplesNode();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphNodePathContext extends ParserRuleContext {
		public TriplesNodePathContext triplesNodePath() {
			return getRuleContext(TriplesNodePathContext.class,0);
		}
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public GraphNodePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphNodePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphNodePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphNodePath(this);
		}
	}

	public final GraphNodePathContext graphNodePath() throws RecognitionException {
		GraphNodePathContext _localctx = new GraphNodePathContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_graphNodePath);
		try {
			setState(1175);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1173); varOrTerm();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1174); triplesNodePath();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarOrTermContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public GraphTermContext graphTerm() {
			return getRuleContext(GraphTermContext.class,0);
		}
		public VarOrTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterVarOrTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitVarOrTerm(this);
		}
	}

	public final VarOrTermContext varOrTerm() throws RecognitionException {
		VarOrTermContext _localctx = new VarOrTermContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_varOrTerm);
		try {
			setState(1179);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(1177); var();
				}
				break;
			case TRUE:
			case FALSE:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case BLANK_NODE_LABEL:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1178); graphTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarOrIRIContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public VarOrIRIContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrIRI; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterVarOrIRI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitVarOrIRI(this);
		}
	}

	public final VarOrIRIContext varOrIRI() throws RecognitionException {
		VarOrIRIContext _localctx = new VarOrIRIContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_varOrIRI);
		try {
			setState(1183);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(1181); var();
				}
				break;
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1182); iri();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR1() { return getToken(StreamingSparql.VAR1, 0); }
		public TerminalNode VAR2() { return getToken(StreamingSparql.VAR2, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1185);
			_la = _input.LA(1);
			if ( !(_la==VAR1 || _la==VAR2) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var3Context extends ParserRuleContext {
		public TerminalNode VAR3() { return getToken(StreamingSparql.VAR3, 0); }
		public Var3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterVar3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitVar3(this);
		}
	}

	public final Var3Context var3() throws RecognitionException {
		Var3Context _localctx = new Var3Context(_ctx, getState());
		enterRule(_localctx, 254, RULE_var3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1187); match(VAR3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternOperationContext extends ParserRuleContext {
		public TerminalNode PATTYPE() { return getToken(StreamingSparql.PATTYPE, 0); }
		public PatternOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPatternOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPatternOperation(this);
		}
	}

	public final PatternOperationContext patternOperation() throws RecognitionException {
		PatternOperationContext _localctx = new PatternOperationContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_patternOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1189); match(PATTYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphTermContext extends ParserRuleContext {
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public BlankNodeContext blankNode() {
			return getRuleContext(BlankNodeContext.class,0);
		}
		public RdfLiteralContext rdfLiteral() {
			return getRuleContext(RdfLiteralContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public NilContext nil() {
			return getRuleContext(NilContext.class,0);
		}
		public GraphTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterGraphTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitGraphTerm(this);
		}
	}

	public final GraphTermContext graphTerm() throws RecognitionException {
		GraphTermContext _localctx = new GraphTermContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_graphTerm);
		try {
			setState(1197);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1191); iri();
				}
				break;
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1192); rdfLiteral();
				}
				break;
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1193); numericLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1194); booleanLiteral();
				}
				break;
			case BLANK_NODE_LABEL:
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 5);
				{
				setState(1195); blankNode();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1196); nil();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NilContext extends ParserRuleContext {
		public NilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nil; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterNil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitNil(this);
		}
	}

	public final NilContext nil() throws RecognitionException {
		NilContext _localctx = new NilContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_nil);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1199); match(OPEN_BRACE);
			setState(1200); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnarySignedLiteralExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryLiteralExpressionContext unaryLiteralExpression() {
			return getRuleContext(UnaryLiteralExpressionContext.class,0);
		}
		public UnarySignedLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUnarySignedLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUnarySignedLiteralExpression(this);
		}
	}
	public static class ConditionalOrExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConditionalOrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterConditionalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitConditionalOrExpression(this);
		}
	}
	public static class AdditiveExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitAdditiveExpression(this);
		}
	}
	public static class UnaryAdditiveExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryAdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUnaryAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUnaryAdditiveExpression(this);
		}
	}
	public static class RelationalExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public RelationalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitRelationalExpression(this);
		}
	}
	public static class RelationalSetExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(StreamingSparql.NOT, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IN() { return getToken(StreamingSparql.IN, 0); }
		public RelationalSetExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterRelationalSetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitRelationalSetExpression(this);
		}
	}
	public static class UnaryMultiplicativeExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryMultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUnaryMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUnaryMultiplicativeExpression(this);
		}
	}
	public static class BaseExpressionContext extends ExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public BaseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBaseExpression(this);
		}
	}
	public static class MultiplicativeExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitMultiplicativeExpression(this);
		}
	}
	public static class ConditionalAndExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConditionalAndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterConditionalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitConditionalAndExpression(this);
		}
	}
	public static class UnaryNegationExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryNegationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUnaryNegationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUnaryNegationExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 262;
		enterRecursionRule(_localctx, 262, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1210);
			switch (_input.LA(1)) {
			case ASTERISK:
			case DIVIDE:
				{
				_localctx = new UnaryMultiplicativeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1203);
				((UnaryMultiplicativeExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASTERISK || _la==DIVIDE) ) {
					((UnaryMultiplicativeExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(1204); expression(10);
				}
				break;
			case PLUS_SIGN:
			case MINUS_SIGN:
				{
				_localctx = new UnaryAdditiveExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1205);
				((UnaryAdditiveExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS_SIGN || _la==MINUS_SIGN) ) {
					((UnaryAdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(1206); expression(9);
				}
				break;
			case NEGATION:
				{
				_localctx = new UnaryNegationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1207); match(NEGATION);
				setState(1208); expression(8);
				}
				break;
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case TRUE:
			case FALSE:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
				{
				_localctx = new BaseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1209); primaryExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1239);
					switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1212);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1213);
						((MultiplicativeExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==DIVIDE) ) {
							((MultiplicativeExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(1214); expression(8);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1215);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1216);
						((AdditiveExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS_SIGN || _la==MINUS_SIGN) ) {
							((AdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(1217); expression(7);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1218);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1219);
						((RelationalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (LESS_EQUAL - 150)) | (1L << (GREATER_EQUAL - 150)) | (1L << (NOT_EQUAL - 150)) | (1L << (EQUAL - 150)) | (1L << (LESS - 150)) | (1L << (GREATER - 150)))) != 0)) ) {
							((RelationalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(1220); expression(4);
						}
						break;

					case 4:
						{
						_localctx = new UnarySignedLiteralExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1221);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1222); unaryLiteralExpression();
						}
						break;

					case 5:
						{
						_localctx = new RelationalSetExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1223);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1225);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(1224); match(NOT);
							}
						}

						setState(1227); match(IN);
						setState(1228); match(OPEN_BRACE);
						setState(1230);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (IRI - 66)) | (1L << (URI - 66)) | (1L << (BNODE - 66)) | (1L << (RAND - 66)) | (1L << (ABS - 66)) | (1L << (CEIL - 66)) | (1L << (FLOOR - 66)) | (1L << (ROUND - 66)) | (1L << (CONCAT - 66)) | (1L << (STRLEN - 66)) | (1L << (UCASE - 66)) | (1L << (LCASE - 66)) | (1L << (ENCODE_FOR_URI - 66)) | (1L << (CONTAINS - 66)) | (1L << (STRSTARTS - 66)) | (1L << (STRENDS - 66)) | (1L << (STRBEFORE - 66)) | (1L << (STRAFTER - 66)) | (1L << (REPLACE - 66)) | (1L << (YEAR - 66)) | (1L << (MONTH - 66)) | (1L << (DAY - 66)) | (1L << (HOURS - 66)) | (1L << (MINUTES - 66)) | (1L << (SECONDS - 66)) | (1L << (TIMEZONE - 66)) | (1L << (TZ - 66)) | (1L << (NOW - 66)) | (1L << (UUID - 66)) | (1L << (STRUUID - 66)) | (1L << (MD5 - 66)) | (1L << (SHA1 - 66)) | (1L << (SHA256 - 66)) | (1L << (SHA384 - 66)) | (1L << (SHA512 - 66)) | (1L << (COALESCE - 66)) | (1L << (IF - 66)) | (1L << (STRLANG - 66)) | (1L << (STRDT - 66)) | (1L << (ISNUMERIC - 66)) | (1L << (COUNT - 66)) | (1L << (SUM - 66)) | (1L << (MIN - 66)) | (1L << (MAX - 66)) | (1L << (AVG - 66)) | (1L << (SAMPLE - 66)) | (1L << (GROUP_CONCAT - 66)) | (1L << (NOT - 66)) | (1L << (EXISTS - 66)) | (1L << (IRIREF - 66)) | (1L << (PNAME_NS - 66)) | (1L << (PNAME_LN - 66)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (VAR1 - 131)) | (1L << (VAR2 - 131)) | (1L << (INTEGER - 131)) | (1L << (DECIMAL - 131)) | (1L << (DOUBLE - 131)) | (1L << (INTEGER_POSITIVE - 131)) | (1L << (DECIMAL_POSITIVE - 131)) | (1L << (DOUBLE_POSITIVE - 131)) | (1L << (INTEGER_NEGATIVE - 131)) | (1L << (DECIMAL_NEGATIVE - 131)) | (1L << (DOUBLE_NEGATIVE - 131)) | (1L << (STRING_LITERAL1 - 131)) | (1L << (STRING_LITERAL2 - 131)) | (1L << (STRING_LITERAL_LONG1 - 131)) | (1L << (STRING_LITERAL_LONG2 - 131)) | (1L << (OPEN_BRACE - 131)) | (1L << (PLUS_SIGN - 131)) | (1L << (MINUS_SIGN - 131)) | (1L << (ASTERISK - 131)) | (1L << (NEGATION - 131)) | (1L << (DIVIDE - 131)))) != 0)) {
							{
							setState(1229); expressionList();
							}
						}

						setState(1232); match(CLOSE_BRACE);
						}
						break;

					case 6:
						{
						_localctx = new ConditionalAndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1233);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(1234); match(AND);
						setState(1235); expression(0);
						}
						}
						break;

					case 7:
						{
						_localctx = new ConditionalOrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1236);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(1237); match(OR);
						setState(1238); expression(0);
						}
						}
						break;
					}
					} 
				}
				setState(1243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryLiteralExpressionContext extends ParserRuleContext {
		public Token op;
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public NumericLiteralNegativeContext numericLiteralNegative() {
			return getRuleContext(NumericLiteralNegativeContext.class,0);
		}
		public NumericLiteralPositiveContext numericLiteralPositive() {
			return getRuleContext(NumericLiteralPositiveContext.class,0);
		}
		public UnaryLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUnaryLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUnaryLiteralExpression(this);
		}
	}

	public final UnaryLiteralExpressionContext unaryLiteralExpression() throws RecognitionException {
		UnaryLiteralExpressionContext _localctx = new UnaryLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_unaryLiteralExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
			switch (_input.LA(1)) {
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
				{
				setState(1244); numericLiteralPositive();
				}
				break;
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				{
				setState(1245); numericLiteralNegative();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1250);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				{
				setState(1248);
				((UnaryLiteralExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASTERISK || _la==DIVIDE) ) {
					((UnaryLiteralExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(1249); unaryExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public Token op;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_unaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1253);
			_la = _input.LA(1);
			if (((((_la - 164)) & ~0x3f) == 0 && ((1L << (_la - 164)) & ((1L << (PLUS_SIGN - 164)) | (1L << (MINUS_SIGN - 164)) | (1L << (NEGATION - 164)))) != 0)) {
				{
				setState(1252);
				((UnaryExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 164)) & ~0x3f) == 0 && ((1L << (_la - 164)) & ((1L << (PLUS_SIGN - 164)) | (1L << (MINUS_SIGN - 164)) | (1L << (NEGATION - 164)))) != 0)) ) {
					((UnaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1255); primaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public RdfLiteralContext rdfLiteral() {
			return getRuleContext(RdfLiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public IriRefOrFunctionContext iriRefOrFunction() {
			return getRuleContext(IriRefOrFunctionContext.class,0);
		}
		public BuiltInCallContext builtInCall() {
			return getRuleContext(BuiltInCallContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_primaryExpression);
		try {
			setState(1267);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1257); match(OPEN_BRACE);
				setState(1258); expression(0);
				setState(1259); match(CLOSE_BRACE);
				}
				break;
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1261); builtInCall();
				}
				break;
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1262); iriRefOrFunction();
				}
				break;
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
				enterOuterAlt(_localctx, 4);
				{
				setState(1263); rdfLiteral();
				}
				break;
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1264); numericLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1265); booleanLiteral();
				}
				break;
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 7);
				{
				setState(1266); var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltInCallContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(StreamingSparql.IF, 0); }
		public TerminalNode STRUUID() { return getToken(StreamingSparql.STRUUID, 0); }
		public TerminalNode ISBLANK() { return getToken(StreamingSparql.ISBLANK, 0); }
		public TerminalNode TZ() { return getToken(StreamingSparql.TZ, 0); }
		public TerminalNode SHA384() { return getToken(StreamingSparql.SHA384, 0); }
		public TerminalNode URI() { return getToken(StreamingSparql.URI, 0); }
		public TerminalNode BNODE() { return getToken(StreamingSparql.BNODE, 0); }
		public TerminalNode SHA256() { return getToken(StreamingSparql.SHA256, 0); }
		public SubStringExpressionContext subStringExpression() {
			return getRuleContext(SubStringExpressionContext.class,0);
		}
		public TerminalNode SECONDS() { return getToken(StreamingSparql.SECONDS, 0); }
		public TerminalNode STRAFTER() { return getToken(StreamingSparql.STRAFTER, 0); }
		public TerminalNode ROUND() { return getToken(StreamingSparql.ROUND, 0); }
		public StrReplaceExpressionContext strReplaceExpression() {
			return getRuleContext(StrReplaceExpressionContext.class,0);
		}
		public TerminalNode STRBEFORE() { return getToken(StreamingSparql.STRBEFORE, 0); }
		public TerminalNode CEIL() { return getToken(StreamingSparql.CEIL, 0); }
		public TerminalNode SHA1() { return getToken(StreamingSparql.SHA1, 0); }
		public TerminalNode CONCAT() { return getToken(StreamingSparql.CONCAT, 0); }
		public TerminalNode SAMETERM() { return getToken(StreamingSparql.SAMETERM, 0); }
		public TerminalNode COALESCE() { return getToken(StreamingSparql.COALESCE, 0); }
		public TerminalNode ISLITERAL() { return getToken(StreamingSparql.ISLITERAL, 0); }
		public TerminalNode ENCODE_FOR_URI() { return getToken(StreamingSparql.ENCODE_FOR_URI, 0); }
		public TerminalNode BOUND() { return getToken(StreamingSparql.BOUND, 0); }
		public TerminalNode STRSTARTS() { return getToken(StreamingSparql.STRSTARTS, 0); }
		public TerminalNode LCASE() { return getToken(StreamingSparql.LCASE, 0); }
		public TerminalNode ISURI() { return getToken(StreamingSparql.ISURI, 0); }
		public TerminalNode ISIRI() { return getToken(StreamingSparql.ISIRI, 0); }
		public RegexExpressionContext regexExpression() {
			return getRuleContext(RegexExpressionContext.class,0);
		}
		public TerminalNode UCASE() { return getToken(StreamingSparql.UCASE, 0); }
		public TerminalNode NOW() { return getToken(StreamingSparql.NOW, 0); }
		public TerminalNode STR() { return getToken(StreamingSparql.STR, 0); }
		public TerminalNode CONTAINS() { return getToken(StreamingSparql.CONTAINS, 0); }
		public NotExistsFunctionContext notExistsFunction() {
			return getRuleContext(NotExistsFunctionContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode ABS() { return getToken(StreamingSparql.ABS, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public TerminalNode STRLEN() { return getToken(StreamingSparql.STRLEN, 0); }
		public TerminalNode LANG() { return getToken(StreamingSparql.LANG, 0); }
		public TerminalNode STRLANG() { return getToken(StreamingSparql.STRLANG, 0); }
		public TerminalNode STRDT() { return getToken(StreamingSparql.STRDT, 0); }
		public TerminalNode DATATYPE() { return getToken(StreamingSparql.DATATYPE, 0); }
		public TerminalNode MONTH() { return getToken(StreamingSparql.MONTH, 0); }
		public TerminalNode DAY() { return getToken(StreamingSparql.DAY, 0); }
		public TerminalNode STRENDS() { return getToken(StreamingSparql.STRENDS, 0); }
		public TerminalNode YEAR() { return getToken(StreamingSparql.YEAR, 0); }
		public TerminalNode MINUTES() { return getToken(StreamingSparql.MINUTES, 0); }
		public TerminalNode UUID() { return getToken(StreamingSparql.UUID, 0); }
		public TerminalNode TIMEZONE() { return getToken(StreamingSparql.TIMEZONE, 0); }
		public TerminalNode LANGMATCHES() { return getToken(StreamingSparql.LANGMATCHES, 0); }
		public TerminalNode IRI() { return getToken(StreamingSparql.IRI, 0); }
		public TerminalNode HOURS() { return getToken(StreamingSparql.HOURS, 0); }
		public ExistsFunctionContext existsFunction() {
			return getRuleContext(ExistsFunctionContext.class,0);
		}
		public TerminalNode ISNUMERIC() { return getToken(StreamingSparql.ISNUMERIC, 0); }
		public TerminalNode SHA512() { return getToken(StreamingSparql.SHA512, 0); }
		public TerminalNode FLOOR() { return getToken(StreamingSparql.FLOOR, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode MD5() { return getToken(StreamingSparql.MD5, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode RAND() { return getToken(StreamingSparql.RAND, 0); }
		public BuiltInCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBuiltInCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBuiltInCall(this);
		}
	}

	public final BuiltInCallContext builtInCall() throws RecognitionException {
		BuiltInCallContext _localctx = new BuiltInCallContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_builtInCall);
		int _la;
		try {
			setState(1537);
			switch (_input.LA(1)) {
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1269); aggregate();
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1270); match(STR);
				setState(1271); match(OPEN_BRACE);
				setState(1272); expression(0);
				setState(1273); match(CLOSE_BRACE);
				}
				break;
			case LANG:
				enterOuterAlt(_localctx, 3);
				{
				setState(1275); match(LANG);
				setState(1276); match(OPEN_BRACE);
				setState(1277); expression(0);
				setState(1278); match(CLOSE_BRACE);
				}
				break;
			case LANGMATCHES:
				enterOuterAlt(_localctx, 4);
				{
				setState(1280); match(LANGMATCHES);
				setState(1281); match(OPEN_BRACE);
				setState(1282); expression(0);
				setState(1283); match(COMMA);
				setState(1284); expression(0);
				setState(1285); match(CLOSE_BRACE);
				}
				break;
			case DATATYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1287); match(DATATYPE);
				setState(1288); match(OPEN_BRACE);
				setState(1289); expression(0);
				setState(1290); match(CLOSE_BRACE);
				}
				break;
			case BOUND:
				enterOuterAlt(_localctx, 6);
				{
				setState(1292); match(BOUND);
				setState(1293); match(OPEN_BRACE);
				setState(1294); var();
				setState(1295); match(CLOSE_BRACE);
				}
				break;
			case IRI:
				enterOuterAlt(_localctx, 7);
				{
				setState(1297); match(IRI);
				setState(1298); match(OPEN_BRACE);
				setState(1299); expression(0);
				setState(1300); match(CLOSE_BRACE);
				}
				break;
			case URI:
				enterOuterAlt(_localctx, 8);
				{
				setState(1302); match(URI);
				setState(1303); match(OPEN_BRACE);
				setState(1304); expression(0);
				setState(1305); match(CLOSE_BRACE);
				}
				break;
			case BNODE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1307); match(BNODE);
				setState(1308); match(OPEN_BRACE);
				setState(1310);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (IRI - 66)) | (1L << (URI - 66)) | (1L << (BNODE - 66)) | (1L << (RAND - 66)) | (1L << (ABS - 66)) | (1L << (CEIL - 66)) | (1L << (FLOOR - 66)) | (1L << (ROUND - 66)) | (1L << (CONCAT - 66)) | (1L << (STRLEN - 66)) | (1L << (UCASE - 66)) | (1L << (LCASE - 66)) | (1L << (ENCODE_FOR_URI - 66)) | (1L << (CONTAINS - 66)) | (1L << (STRSTARTS - 66)) | (1L << (STRENDS - 66)) | (1L << (STRBEFORE - 66)) | (1L << (STRAFTER - 66)) | (1L << (REPLACE - 66)) | (1L << (YEAR - 66)) | (1L << (MONTH - 66)) | (1L << (DAY - 66)) | (1L << (HOURS - 66)) | (1L << (MINUTES - 66)) | (1L << (SECONDS - 66)) | (1L << (TIMEZONE - 66)) | (1L << (TZ - 66)) | (1L << (NOW - 66)) | (1L << (UUID - 66)) | (1L << (STRUUID - 66)) | (1L << (MD5 - 66)) | (1L << (SHA1 - 66)) | (1L << (SHA256 - 66)) | (1L << (SHA384 - 66)) | (1L << (SHA512 - 66)) | (1L << (COALESCE - 66)) | (1L << (IF - 66)) | (1L << (STRLANG - 66)) | (1L << (STRDT - 66)) | (1L << (ISNUMERIC - 66)) | (1L << (COUNT - 66)) | (1L << (SUM - 66)) | (1L << (MIN - 66)) | (1L << (MAX - 66)) | (1L << (AVG - 66)) | (1L << (SAMPLE - 66)) | (1L << (GROUP_CONCAT - 66)) | (1L << (NOT - 66)) | (1L << (EXISTS - 66)) | (1L << (IRIREF - 66)) | (1L << (PNAME_NS - 66)) | (1L << (PNAME_LN - 66)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (VAR1 - 131)) | (1L << (VAR2 - 131)) | (1L << (INTEGER - 131)) | (1L << (DECIMAL - 131)) | (1L << (DOUBLE - 131)) | (1L << (INTEGER_POSITIVE - 131)) | (1L << (DECIMAL_POSITIVE - 131)) | (1L << (DOUBLE_POSITIVE - 131)) | (1L << (INTEGER_NEGATIVE - 131)) | (1L << (DECIMAL_NEGATIVE - 131)) | (1L << (DOUBLE_NEGATIVE - 131)) | (1L << (STRING_LITERAL1 - 131)) | (1L << (STRING_LITERAL2 - 131)) | (1L << (STRING_LITERAL_LONG1 - 131)) | (1L << (STRING_LITERAL_LONG2 - 131)) | (1L << (OPEN_BRACE - 131)) | (1L << (PLUS_SIGN - 131)) | (1L << (MINUS_SIGN - 131)) | (1L << (ASTERISK - 131)) | (1L << (NEGATION - 131)) | (1L << (DIVIDE - 131)))) != 0)) {
					{
					setState(1309); expression(0);
					}
				}

				setState(1312); match(CLOSE_BRACE);
				}
				break;
			case RAND:
				enterOuterAlt(_localctx, 10);
				{
				setState(1313); match(RAND);
				setState(1314); match(OPEN_BRACE);
				setState(1315); match(CLOSE_BRACE);
				}
				break;
			case ABS:
				enterOuterAlt(_localctx, 11);
				{
				setState(1316); match(ABS);
				setState(1317); match(OPEN_BRACE);
				setState(1318); expression(0);
				setState(1319); match(CLOSE_BRACE);
				}
				break;
			case CEIL:
				enterOuterAlt(_localctx, 12);
				{
				setState(1321); match(CEIL);
				setState(1322); match(OPEN_BRACE);
				setState(1323); expression(0);
				setState(1324); match(CLOSE_BRACE);
				}
				break;
			case FLOOR:
				enterOuterAlt(_localctx, 13);
				{
				setState(1326); match(FLOOR);
				setState(1327); match(OPEN_BRACE);
				setState(1328); expression(0);
				setState(1329); match(CLOSE_BRACE);
				}
				break;
			case ROUND:
				enterOuterAlt(_localctx, 14);
				{
				setState(1331); match(ROUND);
				setState(1332); match(OPEN_BRACE);
				setState(1333); expression(0);
				setState(1334); match(CLOSE_BRACE);
				}
				break;
			case CONCAT:
				enterOuterAlt(_localctx, 15);
				{
				setState(1336); match(CONCAT);
				setState(1337); match(OPEN_BRACE);
				setState(1339);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (IRI - 66)) | (1L << (URI - 66)) | (1L << (BNODE - 66)) | (1L << (RAND - 66)) | (1L << (ABS - 66)) | (1L << (CEIL - 66)) | (1L << (FLOOR - 66)) | (1L << (ROUND - 66)) | (1L << (CONCAT - 66)) | (1L << (STRLEN - 66)) | (1L << (UCASE - 66)) | (1L << (LCASE - 66)) | (1L << (ENCODE_FOR_URI - 66)) | (1L << (CONTAINS - 66)) | (1L << (STRSTARTS - 66)) | (1L << (STRENDS - 66)) | (1L << (STRBEFORE - 66)) | (1L << (STRAFTER - 66)) | (1L << (REPLACE - 66)) | (1L << (YEAR - 66)) | (1L << (MONTH - 66)) | (1L << (DAY - 66)) | (1L << (HOURS - 66)) | (1L << (MINUTES - 66)) | (1L << (SECONDS - 66)) | (1L << (TIMEZONE - 66)) | (1L << (TZ - 66)) | (1L << (NOW - 66)) | (1L << (UUID - 66)) | (1L << (STRUUID - 66)) | (1L << (MD5 - 66)) | (1L << (SHA1 - 66)) | (1L << (SHA256 - 66)) | (1L << (SHA384 - 66)) | (1L << (SHA512 - 66)) | (1L << (COALESCE - 66)) | (1L << (IF - 66)) | (1L << (STRLANG - 66)) | (1L << (STRDT - 66)) | (1L << (ISNUMERIC - 66)) | (1L << (COUNT - 66)) | (1L << (SUM - 66)) | (1L << (MIN - 66)) | (1L << (MAX - 66)) | (1L << (AVG - 66)) | (1L << (SAMPLE - 66)) | (1L << (GROUP_CONCAT - 66)) | (1L << (NOT - 66)) | (1L << (EXISTS - 66)) | (1L << (IRIREF - 66)) | (1L << (PNAME_NS - 66)) | (1L << (PNAME_LN - 66)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (VAR1 - 131)) | (1L << (VAR2 - 131)) | (1L << (INTEGER - 131)) | (1L << (DECIMAL - 131)) | (1L << (DOUBLE - 131)) | (1L << (INTEGER_POSITIVE - 131)) | (1L << (DECIMAL_POSITIVE - 131)) | (1L << (DOUBLE_POSITIVE - 131)) | (1L << (INTEGER_NEGATIVE - 131)) | (1L << (DECIMAL_NEGATIVE - 131)) | (1L << (DOUBLE_NEGATIVE - 131)) | (1L << (STRING_LITERAL1 - 131)) | (1L << (STRING_LITERAL2 - 131)) | (1L << (STRING_LITERAL_LONG1 - 131)) | (1L << (STRING_LITERAL_LONG2 - 131)) | (1L << (OPEN_BRACE - 131)) | (1L << (PLUS_SIGN - 131)) | (1L << (MINUS_SIGN - 131)) | (1L << (ASTERISK - 131)) | (1L << (NEGATION - 131)) | (1L << (DIVIDE - 131)))) != 0)) {
					{
					setState(1338); expressionList();
					}
				}

				setState(1341); match(CLOSE_BRACE);
				}
				break;
			case SUBSTR:
				enterOuterAlt(_localctx, 16);
				{
				setState(1342); subStringExpression();
				}
				break;
			case STRLEN:
				enterOuterAlt(_localctx, 17);
				{
				setState(1343); match(STRLEN);
				setState(1344); match(OPEN_BRACE);
				setState(1345); expression(0);
				setState(1346); match(CLOSE_BRACE);
				}
				break;
			case REPLACE:
				enterOuterAlt(_localctx, 18);
				{
				setState(1348); strReplaceExpression();
				}
				break;
			case UCASE:
				enterOuterAlt(_localctx, 19);
				{
				setState(1349); match(UCASE);
				setState(1350); match(OPEN_BRACE);
				setState(1351); expression(0);
				setState(1352); match(CLOSE_BRACE);
				}
				break;
			case LCASE:
				enterOuterAlt(_localctx, 20);
				{
				setState(1354); match(LCASE);
				setState(1355); match(OPEN_BRACE);
				setState(1356); expression(0);
				setState(1357); match(CLOSE_BRACE);
				}
				break;
			case ENCODE_FOR_URI:
				enterOuterAlt(_localctx, 21);
				{
				setState(1359); match(ENCODE_FOR_URI);
				setState(1360); match(OPEN_BRACE);
				setState(1361); expression(0);
				setState(1362); match(CLOSE_BRACE);
				}
				break;
			case CONTAINS:
				enterOuterAlt(_localctx, 22);
				{
				setState(1364); match(CONTAINS);
				setState(1365); match(OPEN_BRACE);
				setState(1366); expression(0);
				setState(1367); match(COMMA);
				setState(1368); expression(0);
				setState(1369); match(CLOSE_BRACE);
				}
				break;
			case STRSTARTS:
				enterOuterAlt(_localctx, 23);
				{
				setState(1371); match(STRSTARTS);
				setState(1372); match(OPEN_BRACE);
				setState(1373); expression(0);
				setState(1374); match(COMMA);
				setState(1375); expression(0);
				setState(1376); match(CLOSE_BRACE);
				}
				break;
			case STRENDS:
				enterOuterAlt(_localctx, 24);
				{
				setState(1378); match(STRENDS);
				setState(1379); match(OPEN_BRACE);
				setState(1380); expression(0);
				setState(1381); match(COMMA);
				setState(1382); expression(0);
				setState(1383); match(CLOSE_BRACE);
				}
				break;
			case STRBEFORE:
				enterOuterAlt(_localctx, 25);
				{
				setState(1385); match(STRBEFORE);
				setState(1386); match(OPEN_BRACE);
				setState(1387); expression(0);
				setState(1388); match(COMMA);
				setState(1389); expression(0);
				setState(1390); match(CLOSE_BRACE);
				}
				break;
			case STRAFTER:
				enterOuterAlt(_localctx, 26);
				{
				setState(1392); match(STRAFTER);
				setState(1393); match(OPEN_BRACE);
				setState(1394); expression(0);
				setState(1395); match(COMMA);
				setState(1396); expression(0);
				setState(1397); match(CLOSE_BRACE);
				}
				break;
			case YEAR:
				enterOuterAlt(_localctx, 27);
				{
				setState(1399); match(YEAR);
				setState(1400); match(OPEN_BRACE);
				setState(1401); expression(0);
				setState(1402); match(CLOSE_BRACE);
				}
				break;
			case MONTH:
				enterOuterAlt(_localctx, 28);
				{
				setState(1404); match(MONTH);
				setState(1405); match(OPEN_BRACE);
				setState(1406); expression(0);
				setState(1407); match(CLOSE_BRACE);
				}
				break;
			case DAY:
				enterOuterAlt(_localctx, 29);
				{
				setState(1409); match(DAY);
				setState(1410); match(OPEN_BRACE);
				setState(1411); expression(0);
				setState(1412); match(CLOSE_BRACE);
				}
				break;
			case HOURS:
				enterOuterAlt(_localctx, 30);
				{
				setState(1414); match(HOURS);
				setState(1415); match(OPEN_BRACE);
				setState(1416); expression(0);
				setState(1417); match(CLOSE_BRACE);
				}
				break;
			case MINUTES:
				enterOuterAlt(_localctx, 31);
				{
				setState(1419); match(MINUTES);
				setState(1420); match(OPEN_BRACE);
				setState(1421); expression(0);
				setState(1422); match(CLOSE_BRACE);
				}
				break;
			case SECONDS:
				enterOuterAlt(_localctx, 32);
				{
				setState(1424); match(SECONDS);
				setState(1425); match(OPEN_BRACE);
				setState(1426); expression(0);
				setState(1427); match(CLOSE_BRACE);
				}
				break;
			case TIMEZONE:
				enterOuterAlt(_localctx, 33);
				{
				setState(1429); match(TIMEZONE);
				setState(1430); match(OPEN_BRACE);
				setState(1431); expression(0);
				setState(1432); match(CLOSE_BRACE);
				}
				break;
			case TZ:
				enterOuterAlt(_localctx, 34);
				{
				setState(1434); match(TZ);
				setState(1435); match(OPEN_BRACE);
				setState(1436); expression(0);
				setState(1437); match(CLOSE_BRACE);
				}
				break;
			case NOW:
				enterOuterAlt(_localctx, 35);
				{
				setState(1439); match(NOW);
				setState(1440); match(OPEN_BRACE);
				setState(1441); match(CLOSE_BRACE);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 36);
				{
				setState(1442); match(UUID);
				setState(1443); match(OPEN_BRACE);
				setState(1444); match(CLOSE_BRACE);
				}
				break;
			case STRUUID:
				enterOuterAlt(_localctx, 37);
				{
				setState(1445); match(STRUUID);
				setState(1446); match(OPEN_BRACE);
				setState(1447); match(CLOSE_BRACE);
				}
				break;
			case MD5:
				enterOuterAlt(_localctx, 38);
				{
				setState(1448); match(MD5);
				setState(1449); match(OPEN_BRACE);
				setState(1450); expression(0);
				setState(1451); match(CLOSE_BRACE);
				}
				break;
			case SHA1:
				enterOuterAlt(_localctx, 39);
				{
				setState(1453); match(SHA1);
				setState(1454); match(OPEN_BRACE);
				setState(1455); expression(0);
				setState(1456); match(CLOSE_BRACE);
				}
				break;
			case SHA256:
				enterOuterAlt(_localctx, 40);
				{
				setState(1458); match(SHA256);
				setState(1459); match(OPEN_BRACE);
				setState(1460); expression(0);
				setState(1461); match(CLOSE_BRACE);
				}
				break;
			case SHA384:
				enterOuterAlt(_localctx, 41);
				{
				setState(1463); match(SHA384);
				setState(1464); match(OPEN_BRACE);
				setState(1465); expression(0);
				setState(1466); match(CLOSE_BRACE);
				}
				break;
			case SHA512:
				enterOuterAlt(_localctx, 42);
				{
				setState(1468); match(SHA512);
				setState(1469); match(OPEN_BRACE);
				setState(1470); expression(0);
				setState(1471); match(CLOSE_BRACE);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 43);
				{
				setState(1473); match(COALESCE);
				setState(1474); match(OPEN_BRACE);
				setState(1476);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (IRI - 66)) | (1L << (URI - 66)) | (1L << (BNODE - 66)) | (1L << (RAND - 66)) | (1L << (ABS - 66)) | (1L << (CEIL - 66)) | (1L << (FLOOR - 66)) | (1L << (ROUND - 66)) | (1L << (CONCAT - 66)) | (1L << (STRLEN - 66)) | (1L << (UCASE - 66)) | (1L << (LCASE - 66)) | (1L << (ENCODE_FOR_URI - 66)) | (1L << (CONTAINS - 66)) | (1L << (STRSTARTS - 66)) | (1L << (STRENDS - 66)) | (1L << (STRBEFORE - 66)) | (1L << (STRAFTER - 66)) | (1L << (REPLACE - 66)) | (1L << (YEAR - 66)) | (1L << (MONTH - 66)) | (1L << (DAY - 66)) | (1L << (HOURS - 66)) | (1L << (MINUTES - 66)) | (1L << (SECONDS - 66)) | (1L << (TIMEZONE - 66)) | (1L << (TZ - 66)) | (1L << (NOW - 66)) | (1L << (UUID - 66)) | (1L << (STRUUID - 66)) | (1L << (MD5 - 66)) | (1L << (SHA1 - 66)) | (1L << (SHA256 - 66)) | (1L << (SHA384 - 66)) | (1L << (SHA512 - 66)) | (1L << (COALESCE - 66)) | (1L << (IF - 66)) | (1L << (STRLANG - 66)) | (1L << (STRDT - 66)) | (1L << (ISNUMERIC - 66)) | (1L << (COUNT - 66)) | (1L << (SUM - 66)) | (1L << (MIN - 66)) | (1L << (MAX - 66)) | (1L << (AVG - 66)) | (1L << (SAMPLE - 66)) | (1L << (GROUP_CONCAT - 66)) | (1L << (NOT - 66)) | (1L << (EXISTS - 66)) | (1L << (IRIREF - 66)) | (1L << (PNAME_NS - 66)) | (1L << (PNAME_LN - 66)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (VAR1 - 131)) | (1L << (VAR2 - 131)) | (1L << (INTEGER - 131)) | (1L << (DECIMAL - 131)) | (1L << (DOUBLE - 131)) | (1L << (INTEGER_POSITIVE - 131)) | (1L << (DECIMAL_POSITIVE - 131)) | (1L << (DOUBLE_POSITIVE - 131)) | (1L << (INTEGER_NEGATIVE - 131)) | (1L << (DECIMAL_NEGATIVE - 131)) | (1L << (DOUBLE_NEGATIVE - 131)) | (1L << (STRING_LITERAL1 - 131)) | (1L << (STRING_LITERAL2 - 131)) | (1L << (STRING_LITERAL_LONG1 - 131)) | (1L << (STRING_LITERAL_LONG2 - 131)) | (1L << (OPEN_BRACE - 131)) | (1L << (PLUS_SIGN - 131)) | (1L << (MINUS_SIGN - 131)) | (1L << (ASTERISK - 131)) | (1L << (NEGATION - 131)) | (1L << (DIVIDE - 131)))) != 0)) {
					{
					setState(1475); expressionList();
					}
				}

				setState(1478); match(CLOSE_BRACE);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 44);
				{
				setState(1479); match(IF);
				setState(1480); match(OPEN_BRACE);
				setState(1481); expression(0);
				setState(1482); match(COMMA);
				setState(1483); expression(0);
				setState(1484); match(COMMA);
				setState(1485); expression(0);
				setState(1486); match(CLOSE_BRACE);
				}
				break;
			case STRLANG:
				enterOuterAlt(_localctx, 45);
				{
				setState(1488); match(STRLANG);
				setState(1489); match(OPEN_BRACE);
				setState(1490); expression(0);
				setState(1491); match(COMMA);
				setState(1492); expression(0);
				setState(1493); match(CLOSE_BRACE);
				}
				break;
			case STRDT:
				enterOuterAlt(_localctx, 46);
				{
				setState(1495); match(STRDT);
				setState(1496); match(OPEN_BRACE);
				setState(1497); expression(0);
				setState(1498); match(COMMA);
				setState(1499); expression(0);
				setState(1500); match(CLOSE_BRACE);
				}
				break;
			case SAMETERM:
				enterOuterAlt(_localctx, 47);
				{
				setState(1502); match(SAMETERM);
				setState(1503); match(OPEN_BRACE);
				setState(1504); expression(0);
				setState(1505); match(COMMA);
				setState(1506); expression(0);
				setState(1507); match(CLOSE_BRACE);
				}
				break;
			case ISIRI:
				enterOuterAlt(_localctx, 48);
				{
				setState(1509); match(ISIRI);
				setState(1510); match(OPEN_BRACE);
				setState(1511); expression(0);
				setState(1512); match(CLOSE_BRACE);
				}
				break;
			case ISURI:
				enterOuterAlt(_localctx, 49);
				{
				setState(1514); match(ISURI);
				setState(1515); match(OPEN_BRACE);
				setState(1516); expression(0);
				setState(1517); match(CLOSE_BRACE);
				}
				break;
			case ISBLANK:
				enterOuterAlt(_localctx, 50);
				{
				setState(1519); match(ISBLANK);
				setState(1520); match(OPEN_BRACE);
				setState(1521); expression(0);
				setState(1522); match(CLOSE_BRACE);
				}
				break;
			case ISLITERAL:
				enterOuterAlt(_localctx, 51);
				{
				setState(1524); match(ISLITERAL);
				setState(1525); match(OPEN_BRACE);
				setState(1526); expression(0);
				setState(1527); match(CLOSE_BRACE);
				}
				break;
			case ISNUMERIC:
				enterOuterAlt(_localctx, 52);
				{
				setState(1529); match(ISNUMERIC);
				setState(1530); match(OPEN_BRACE);
				setState(1531); expression(0);
				setState(1532); match(CLOSE_BRACE);
				}
				break;
			case REGEX:
				enterOuterAlt(_localctx, 53);
				{
				setState(1534); regexExpression();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 54);
				{
				setState(1535); existsFunction();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 55);
				{
				setState(1536); notExistsFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegexExpressionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode REGEX() { return getToken(StreamingSparql.REGEX, 0); }
		public RegexExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterRegexExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitRegexExpression(this);
		}
	}

	public final RegexExpressionContext regexExpression() throws RecognitionException {
		RegexExpressionContext _localctx = new RegexExpressionContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_regexExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1539); match(REGEX);
			setState(1540); match(OPEN_BRACE);
			setState(1541); expression(0);
			setState(1542); match(COMMA);
			setState(1543); expression(0);
			setState(1546);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1544); match(COMMA);
				setState(1545); expression(0);
				}
			}

			setState(1548); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubStringExpressionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SUBSTR() { return getToken(StreamingSparql.SUBSTR, 0); }
		public SubStringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subStringExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterSubStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitSubStringExpression(this);
		}
	}

	public final SubStringExpressionContext subStringExpression() throws RecognitionException {
		SubStringExpressionContext _localctx = new SubStringExpressionContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_subStringExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1550); match(SUBSTR);
			setState(1551); match(OPEN_BRACE);
			setState(1552); expression(0);
			setState(1553); match(COMMA);
			setState(1554); expression(0);
			setState(1557);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1555); match(COMMA);
				setState(1556); expression(0);
				}
			}

			setState(1559); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrReplaceExpressionContext extends ParserRuleContext {
		public TerminalNode REPLACE() { return getToken(StreamingSparql.REPLACE, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public StrReplaceExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strReplaceExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterStrReplaceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitStrReplaceExpression(this);
		}
	}

	public final StrReplaceExpressionContext strReplaceExpression() throws RecognitionException {
		StrReplaceExpressionContext _localctx = new StrReplaceExpressionContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_strReplaceExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1561); match(REPLACE);
			setState(1562); match(OPEN_BRACE);
			setState(1563); expression(0);
			setState(1564); match(COMMA);
			setState(1565); expression(0);
			setState(1566); match(COMMA);
			setState(1567); expression(0);
			setState(1570);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1568); match(COMMA);
				setState(1569); expression(0);
				}
			}

			setState(1572); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExistsFunctionContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(StreamingSparql.EXISTS, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public ExistsFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existsFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterExistsFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitExistsFunction(this);
		}
	}

	public final ExistsFunctionContext existsFunction() throws RecognitionException {
		ExistsFunctionContext _localctx = new ExistsFunctionContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_existsFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1574); match(EXISTS);
			setState(1575); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotExistsFunctionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(StreamingSparql.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(StreamingSparql.EXISTS, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public NotExistsFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExistsFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterNotExistsFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitNotExistsFunction(this);
		}
	}

	public final NotExistsFunctionContext notExistsFunction() throws RecognitionException {
		NotExistsFunctionContext _localctx = new NotExistsFunctionContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_notExistsFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1577); match(NOT);
			setState(1578); match(EXISTS);
			setState(1579); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(StreamingSparql.COUNT, 0); }
		public TerminalNode MIN() { return getToken(StreamingSparql.MIN, 0); }
		public TerminalNode SAMPLE() { return getToken(StreamingSparql.SAMPLE, 0); }
		public TerminalNode MAX() { return getToken(StreamingSparql.MAX, 0); }
		public TerminalNode SEPARATOR() { return getToken(StreamingSparql.SEPARATOR, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode GROUP_CONCAT() { return getToken(StreamingSparql.GROUP_CONCAT, 0); }
		public TerminalNode DISTINCT() { return getToken(StreamingSparql.DISTINCT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AVG() { return getToken(StreamingSparql.AVG, 0); }
		public TerminalNode SUM() { return getToken(StreamingSparql.SUM, 0); }
		public TerminalNode ASTERISK() { return getToken(StreamingSparql.ASTERISK, 0); }
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterAggregate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitAggregate(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_aggregate);
		int _la;
		try {
			setState(1645);
			switch (_input.LA(1)) {
			case COUNT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1581); match(COUNT);
				setState(1582); match(OPEN_BRACE);
				setState(1584);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1583); match(DISTINCT);
					}
				}

				setState(1588);
				switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
				case 1:
					{
					setState(1586); match(ASTERISK);
					}
					break;

				case 2:
					{
					setState(1587); expression(0);
					}
					break;
				}
				setState(1590); match(CLOSE_BRACE);
				}
				break;
			case SUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(1591); match(SUM);
				setState(1592); match(OPEN_BRACE);
				setState(1594);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1593); match(DISTINCT);
					}
				}

				setState(1596); expression(0);
				setState(1597); match(CLOSE_BRACE);
				}
				break;
			case MIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1599); match(MIN);
				setState(1600); match(OPEN_BRACE);
				setState(1602);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1601); match(DISTINCT);
					}
				}

				setState(1604); expression(0);
				setState(1605); match(CLOSE_BRACE);
				}
				break;
			case MAX:
				enterOuterAlt(_localctx, 4);
				{
				setState(1607); match(MAX);
				setState(1608); match(OPEN_BRACE);
				setState(1610);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1609); match(DISTINCT);
					}
				}

				setState(1612); expression(0);
				setState(1613); match(CLOSE_BRACE);
				}
				break;
			case AVG:
				enterOuterAlt(_localctx, 5);
				{
				setState(1615); match(AVG);
				setState(1616); match(OPEN_BRACE);
				setState(1618);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1617); match(DISTINCT);
					}
				}

				setState(1620); expression(0);
				setState(1621); match(CLOSE_BRACE);
				}
				break;
			case SAMPLE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1623); match(SAMPLE);
				setState(1624); match(OPEN_BRACE);
				setState(1626);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1625); match(DISTINCT);
					}
				}

				setState(1628); expression(0);
				setState(1629); match(CLOSE_BRACE);
				}
				break;
			case GROUP_CONCAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1631); match(GROUP_CONCAT);
				setState(1632); match(OPEN_BRACE);
				setState(1634);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1633); match(DISTINCT);
					}
				}

				setState(1636); expression(0);
				setState(1641);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(1637); match(SEMICOLON);
					setState(1638); match(SEPARATOR);
					setState(1639); match(EQUAL);
					setState(1640); string();
					}
				}

				setState(1643); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IriRefOrFunctionContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public IriRefOrFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iriRefOrFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterIriRefOrFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitIriRefOrFunction(this);
		}
	}

	public final IriRefOrFunctionContext iriRefOrFunction() throws RecognitionException {
		IriRefOrFunctionContext _localctx = new IriRefOrFunctionContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_iriRefOrFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1647); iri();
			setState(1649);
			switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
			case 1:
				{
				setState(1648); argList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RdfLiteralContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode LANGTAG() { return getToken(StreamingSparql.LANGTAG, 0); }
		public RdfLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rdfLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterRdfLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitRdfLiteral(this);
		}
	}

	public final RdfLiteralContext rdfLiteral() throws RecognitionException {
		RdfLiteralContext _localctx = new RdfLiteralContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_rdfLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651); string();
			setState(1655);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				{
				setState(1652); match(LANGTAG);
				}
				break;

			case 2:
				{
				{
				setState(1653); match(REFERENCE);
				setState(1654); iri();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralContext extends ParserRuleContext {
		public NumericLiteralNegativeContext numericLiteralNegative() {
			return getRuleContext(NumericLiteralNegativeContext.class,0);
		}
		public NumericLiteralUnsignedContext numericLiteralUnsigned() {
			return getRuleContext(NumericLiteralUnsignedContext.class,0);
		}
		public NumericLiteralPositiveContext numericLiteralPositive() {
			return getRuleContext(NumericLiteralPositiveContext.class,0);
		}
		public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitNumericLiteral(this);
		}
	}

	public final NumericLiteralContext numericLiteral() throws RecognitionException {
		NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_numericLiteral);
		try {
			setState(1660);
			switch (_input.LA(1)) {
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1657); numericLiteralUnsigned();
				}
				break;
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1658); numericLiteralPositive();
				}
				break;
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1659); numericLiteralNegative();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralUnsignedContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(StreamingSparql.DECIMAL, 0); }
		public TerminalNode INTEGER() { return getToken(StreamingSparql.INTEGER, 0); }
		public TerminalNode DOUBLE() { return getToken(StreamingSparql.DOUBLE, 0); }
		public NumericLiteralUnsignedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteralUnsigned; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterNumericLiteralUnsigned(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitNumericLiteralUnsigned(this);
		}
	}

	public final NumericLiteralUnsignedContext numericLiteralUnsigned() throws RecognitionException {
		NumericLiteralUnsignedContext _localctx = new NumericLiteralUnsignedContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_numericLiteralUnsigned);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662);
			_la = _input.LA(1);
			if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (INTEGER - 135)) | (1L << (DECIMAL - 135)) | (1L << (DOUBLE - 135)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralPositiveContext extends ParserRuleContext {
		public TerminalNode DECIMAL_POSITIVE() { return getToken(StreamingSparql.DECIMAL_POSITIVE, 0); }
		public TerminalNode DOUBLE_POSITIVE() { return getToken(StreamingSparql.DOUBLE_POSITIVE, 0); }
		public TerminalNode INTEGER_POSITIVE() { return getToken(StreamingSparql.INTEGER_POSITIVE, 0); }
		public NumericLiteralPositiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteralPositive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterNumericLiteralPositive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitNumericLiteralPositive(this);
		}
	}

	public final NumericLiteralPositiveContext numericLiteralPositive() throws RecognitionException {
		NumericLiteralPositiveContext _localctx = new NumericLiteralPositiveContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_numericLiteralPositive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1664);
			_la = _input.LA(1);
			if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (INTEGER_POSITIVE - 138)) | (1L << (DECIMAL_POSITIVE - 138)) | (1L << (DOUBLE_POSITIVE - 138)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralNegativeContext extends ParserRuleContext {
		public TerminalNode INTEGER_NEGATIVE() { return getToken(StreamingSparql.INTEGER_NEGATIVE, 0); }
		public TerminalNode DECIMAL_NEGATIVE() { return getToken(StreamingSparql.DECIMAL_NEGATIVE, 0); }
		public TerminalNode DOUBLE_NEGATIVE() { return getToken(StreamingSparql.DOUBLE_NEGATIVE, 0); }
		public NumericLiteralNegativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteralNegative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterNumericLiteralNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitNumericLiteralNegative(this);
		}
	}

	public final NumericLiteralNegativeContext numericLiteralNegative() throws RecognitionException {
		NumericLiteralNegativeContext _localctx = new NumericLiteralNegativeContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_numericLiteralNegative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1666);
			_la = _input.LA(1);
			if ( !(((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (INTEGER_NEGATIVE - 141)) | (1L << (DECIMAL_NEGATIVE - 141)) | (1L << (DOUBLE_NEGATIVE - 141)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(StreamingSparql.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(StreamingSparql.TRUE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1668);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL_LONG1() { return getToken(StreamingSparql.STRING_LITERAL_LONG1, 0); }
		public TerminalNode STRING_LITERAL2() { return getToken(StreamingSparql.STRING_LITERAL2, 0); }
		public TerminalNode STRING_LITERAL1() { return getToken(StreamingSparql.STRING_LITERAL1, 0); }
		public TerminalNode STRING_LITERAL_LONG2() { return getToken(StreamingSparql.STRING_LITERAL_LONG2, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1670);
			_la = _input.LA(1);
			if ( !(((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (STRING_LITERAL1 - 144)) | (1L << (STRING_LITERAL2 - 144)) | (1L << (STRING_LITERAL_LONG1 - 144)) | (1L << (STRING_LITERAL_LONG2 - 144)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IriContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(StreamingSparql.IRIREF, 0); }
		public PrefixedNameContext prefixedName() {
			return getRuleContext(PrefixedNameContext.class,0);
		}
		public IriContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iri; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterIri(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitIri(this);
		}
	}

	public final IriContext iri() throws RecognitionException {
		IriContext _localctx = new IriContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_iri);
		try {
			setState(1674);
			switch (_input.LA(1)) {
			case IRIREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1672); match(IRIREF);
				}
				break;
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1673); prefixedName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixedNameContext extends ParserRuleContext {
		public TerminalNode PNAME_LN() { return getToken(StreamingSparql.PNAME_LN, 0); }
		public TerminalNode PNAME_NS() { return getToken(StreamingSparql.PNAME_NS, 0); }
		public PrefixedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterPrefixedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitPrefixedName(this);
		}
	}

	public final PrefixedNameContext prefixedName() throws RecognitionException {
		PrefixedNameContext _localctx = new PrefixedNameContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_prefixedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1676);
			_la = _input.LA(1);
			if ( !(_la==PNAME_NS || _la==PNAME_LN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlankNodeContext extends ParserRuleContext {
		public AnonContext anon() {
			return getRuleContext(AnonContext.class,0);
		}
		public TerminalNode BLANK_NODE_LABEL() { return getToken(StreamingSparql.BLANK_NODE_LABEL, 0); }
		public BlankNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blankNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterBlankNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitBlankNode(this);
		}
	}

	public final BlankNodeContext blankNode() throws RecognitionException {
		BlankNodeContext _localctx = new BlankNodeContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_blankNode);
		try {
			setState(1680);
			switch (_input.LA(1)) {
			case BLANK_NODE_LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1678); match(BLANK_NODE_LABEL);
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1679); anon();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnonContext extends ParserRuleContext {
		public AnonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterAnon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitAnon(this);
		}
	}

	public final AnonContext anon() throws RecognitionException {
		AnonContext _localctx = new AnonContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_anon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1682); match(OPEN_SQUARE_BRACKET);
			setState(1683); match(CLOSE_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EofRuleContext extends ParserRuleContext {
		public TerminalNode EOFRULE() { return getToken(StreamingSparql.EOFRULE, 0); }
		public EofRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eofRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).enterEofRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StreamingSparqlListener ) ((StreamingSparqlListener)listener).exitEofRule(this);
		}
	}

	public final EofRuleContext eofRule() throws RecognitionException {
		EofRuleContext _localctx = new EofRuleContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_eofRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1685); match(EOFRULE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 131: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);

		case 1: return precpred(_ctx, 6);

		case 2: return precpred(_ctx, 3);

		case 3: return precpred(_ctx, 5);

		case 4: return precpred(_ctx, 4);

		case 5: return precpred(_ctx, 2);

		case 6: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00b1\u069a\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\3\2\7\2\u013a\n\2\f\2\16\2\u013d\13\2\3\2\3\2\3\2\3\2"+
		"\5\2\u0143\n\2\3\2\3\2\3\3\3\3\5\3\u0149\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\5\6\u0154\n\6\3\6\3\6\7\6\u0158\n\6\f\6\16\6\u015b\13\6\3\6"+
		"\7\6\u015e\n\6\f\6\16\6\u0161\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\5\b\u016d\n\b\3\b\6\b\u0170\n\b\r\b\16\b\u0171\3\b\5\b\u0175\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u017e\n\t\3\n\3\n\3\n\7\n\u0183\n\n\f"+
		"\n\16\n\u0186\13\n\3\n\3\n\3\n\3\n\7\n\u018c\n\n\f\n\16\n\u018f\13\n\3"+
		"\n\3\n\3\n\5\n\u0194\n\n\3\n\3\n\5\n\u0198\n\n\3\13\3\13\6\13\u019c\n"+
		"\13\r\13\16\13\u019d\3\13\5\13\u01a1\n\13\3\13\7\13\u01a4\n\13\f\13\16"+
		"\13\u01a7\13\13\3\13\5\13\u01aa\n\13\3\13\3\13\3\f\3\f\7\f\u01b0\n\f\f"+
		"\f\16\f\u01b3\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\5\16\u01bd\n\16\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u01cb"+
		"\n\21\f\21\16\21\u01ce\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\5\26\u01e3\n\26"+
		"\3\26\3\26\3\26\6\26\u01e8\n\26\r\26\16\26\u01e9\3\26\3\26\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\31\3\31\6\31\u01f7\n\31\r\31\16\31\u01f8\3\31"+
		"\3\31\7\31\u01fd\n\31\f\31\16\31\u0200\13\31\3\32\3\32\3\33\3\33\5\33"+
		"\u0206\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u020f\n\33\f\33\16"+
		"\33\u0212\13\33\3\33\3\33\5\33\u0216\n\33\5\33\u0218\n\33\3\34\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \7"+
		" \u022b\n \f \16 \u022e\13 \3!\3!\3\"\5\"\u0233\n\"\3\"\5\"\u0236\n\""+
		"\3\"\5\"\u0239\n\"\3\"\5\"\u023c\n\"\3#\3#\3#\6#\u0241\n#\r#\16#\u0242"+
		"\3$\3$\3$\3$\3$\3$\5$\u024b\n$\3$\3$\3$\5$\u0250\n$\3%\3%\6%\u0254\n%"+
		"\r%\16%\u0255\3&\3&\3\'\3\'\3\'\6\'\u025d\n\'\r\'\16\'\u025e\3(\3(\3("+
		"\3(\3(\3(\3(\5(\u0268\n(\3)\3)\5)\u026c\n)\3)\3)\5)\u0270\n)\5)\u0272"+
		"\n)\3*\3*\3*\3+\3+\3+\3,\3,\5,\u027c\n,\3-\3-\3-\3-\3-\3-\7-\u0284\n-"+
		"\f-\16-\u0287\13-\3-\3-\5-\u028b\n-\5-\u028d\n-\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\5.\u029a\n.\3/\3/\5/\u029e\n/\3/\3/\3/\5/\u02a3\n/\3\60\3\60"+
		"\5\60\u02a7\n\60\3\60\3\60\3\61\3\61\5\61\u02ad\n\61\3\61\3\61\3\62\3"+
		"\62\5\62\u02b3\n\62\3\62\3\62\3\63\3\63\5\63\u02b9\n\63\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\5\64\u02c1\n\64\3\64\3\64\3\64\3\64\3\65\3\65\5\65\u02c9"+
		"\n\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\3"+
		"8\38\38\39\39\59\u02dd\n9\39\39\59\u02e1\n9\39\59\u02e4\n9\39\79\u02e7"+
		"\n9\f9\169\u02ea\139\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\5<\u02f7\n<\3<\3"+
		"<\3=\3=\5=\u02fd\n=\3=\5=\u0300\n=\3>\3>\3>\3?\3?\3?\3?\5?\u0309\n?\3"+
		"@\3@\3@\3@\3A\3A\3A\3A\3B\5B\u0314\nB\3B\7B\u0317\nB\fB\16B\u031a\13B"+
		"\3C\3C\5C\u031e\nC\3C\5C\u0321\nC\3D\3D\3D\3D\5D\u0327\nD\3D\3D\3E\3E"+
		"\3E\5E\u032e\nE\7E\u0330\nE\fE\16E\u0333\13E\3F\3F\3F\5F\u0338\nF\3F\3"+
		"F\3G\5G\u033d\nG\3G\7G\u0340\nG\fG\16G\u0343\13G\3H\3H\5H\u0347\nH\3H"+
		"\5H\u034a\nH\3I\3I\3I\5I\u034f\nI\7I\u0351\nI\fI\16I\u0354\13I\3J\3J\3"+
		"J\3J\3J\3J\3J\3J\5J\u035e\nJ\3K\3K\3K\3L\3L\3L\3L\3M\3M\5M\u0369\nM\3"+
		"M\3M\3M\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3P\3P\5P\u037a\nP\3Q\3Q\3Q\7Q\u037f"+
		"\nQ\fQ\16Q\u0382\13Q\3Q\3Q\3R\3R\7R\u0388\nR\fR\16R\u038b\13R\3R\3R\3"+
		"R\7R\u0390\nR\fR\16R\u0393\13R\3R\3R\3S\3S\7S\u0399\nS\fS\16S\u039c\13"+
		"S\3S\3S\3T\3T\3T\3T\3T\5T\u03a5\nT\3U\3U\3U\3V\3V\3V\7V\u03ad\nV\fV\16"+
		"V\u03b0\13V\3W\3W\3W\3X\3X\3X\3X\3X\3X\5X\u03bb\nX\3Y\3Y\3Y\3Z\3Z\5Z\u03c2"+
		"\nZ\3Z\3Z\5Z\u03c6\nZ\3Z\3Z\3[\3[\3[\7[\u03cd\n[\f[\16[\u03d0\13[\3\\"+
		"\3\\\5\\\u03d4\n\\\3\\\3\\\3]\3]\3]\5]\u03db\n]\7]\u03dd\n]\f]\16]\u03e0"+
		"\13]\3^\3^\3^\3^\3^\3^\5^\u03e8\n^\3_\5_\u03eb\n_\3`\3`\3`\3`\3`\3`\5"+
		"`\u03f3\n`\7`\u03f5\n`\f`\16`\u03f8\13`\3a\3a\5a\u03fc\na\3b\3b\3b\7b"+
		"\u0401\nb\fb\16b\u0404\13b\3c\3c\3d\3d\3d\3d\3d\3d\5d\u040e\nd\3e\5e\u0411"+
		"\ne\3f\3f\5f\u0415\nf\3f\3f\3f\5f\u041a\nf\7f\u041c\nf\ff\16f\u041f\13"+
		"f\3g\3g\5g\u0423\ng\3g\3g\3h\3h\3i\3i\3j\3j\3j\7j\u042e\nj\fj\16j\u0431"+
		"\13j\3k\3k\3l\3l\3m\3m\3m\7m\u043a\nm\fm\16m\u043d\13m\3n\3n\3n\7n\u0442"+
		"\nn\fn\16n\u0445\13n\3o\3o\5o\u0449\no\3p\5p\u044c\np\3p\3p\3q\3q\3r\3"+
		"r\3r\3r\3r\3r\3r\3r\5r\u045a\nr\3s\3s\3s\3s\3s\7s\u0461\ns\fs\16s\u0464"+
		"\13s\5s\u0466\ns\3s\5s\u0469\ns\3t\5t\u046c\nt\3t\3t\5t\u0470\nt\3u\3"+
		"u\3v\3v\5v\u0476\nv\3w\3w\3w\3w\3x\3x\5x\u047e\nx\3y\3y\3y\3y\3z\3z\6"+
		"z\u0486\nz\rz\16z\u0487\3z\3z\3{\3{\6{\u048e\n{\r{\16{\u048f\3{\3{\3|"+
		"\3|\5|\u0496\n|\3}\3}\5}\u049a\n}\3~\3~\5~\u049e\n~\3\177\3\177\5\177"+
		"\u04a2\n\177\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3\u0083\3"+
		"\u0083\3\u0083\3\u0083\3\u0083\3\u0083\5\u0083\u04b0\n\u0083\3\u0084\3"+
		"\u0084\3\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085"+
		"\3\u0085\5\u0085\u04bd\n\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085"+
		"\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\5\u0085"+
		"\u04cc\n\u0085\3\u0085\3\u0085\3\u0085\5\u0085\u04d1\n\u0085\3\u0085\3"+
		"\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\7\u0085\u04da\n\u0085\f"+
		"\u0085\16\u0085\u04dd\13\u0085\3\u0086\3\u0086\5\u0086\u04e1\n\u0086\3"+
		"\u0086\3\u0086\5\u0086\u04e5\n\u0086\3\u0087\5\u0087\u04e8\n\u0087\3\u0087"+
		"\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\5\u0088\u04f6\n\u0088\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\5\u0089\u0521\n\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\5\u0089\u053e\n\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\5\u0089\u05c7"+
		"\n\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\5\u0089\u0604\n\u0089"+
		"\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\5\u008a\u060d"+
		"\n\u008a\3\u008a\3\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\5\u008b\u0618\n\u008b\3\u008b\3\u008b\3\u008c\3\u008c\3\u008c"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u0625\n\u008c"+
		"\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e"+
		"\3\u008f\3\u008f\3\u008f\5\u008f\u0633\n\u008f\3\u008f\3\u008f\5\u008f"+
		"\u0637\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u063d\n\u008f\3"+
		"\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u0645\n\u008f\3"+
		"\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u064d\n\u008f\3"+
		"\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u0655\n\u008f\3"+
		"\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u065d\n\u008f\3"+
		"\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u0665\n\u008f\3"+
		"\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u066c\n\u008f\3\u008f\3"+
		"\u008f\5\u008f\u0670\n\u008f\3\u0090\3\u0090\5\u0090\u0674\n\u0090\3\u0091"+
		"\3\u0091\3\u0091\3\u0091\5\u0091\u067a\n\u0091\3\u0092\3\u0092\3\u0092"+
		"\5\u0092\u067f\n\u0092\3\u0093\3\u0093\3\u0094\3\u0094\3\u0095\3\u0095"+
		"\3\u0096\3\u0096\3\u0097\3\u0097\3\u0098\3\u0098\5\u0098\u068d\n\u0098"+
		"\3\u0099\3\u0099\3\u009a\3\u009a\5\u009a\u0693\n\u009a\3\u009b\3\u009b"+
		"\3\u009b\3\u009c\3\u009c\3\u009c\2\3\u0108\u009d\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp"+
		"rtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4"+
		"\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c"+
		"\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124"+
		"\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\2\21\3\2\b\t\3"+
		"\2Z\\\3\2\23\24\4\2\u00a6\u00a6\u00a8\u00a9\3\2\u0085\u0086\4\2\u00a8"+
		"\u00a8\u00ac\u00ac\3\2\u00a6\u00a7\4\2\u0098\u009a\u00ad\u00af\4\2\u00a6"+
		"\u00a7\u00ab\u00ab\3\2\u0089\u008b\3\2\u008c\u008e\3\2\u008f\u0091\3\2"+
		")*\3\2\u0092\u0095\3\2\u0082\u0083\u0704\2\u013b\3\2\2\2\4\u0148\3\2\2"+
		"\2\6\u014a\3\2\2\2\b\u014d\3\2\2\2\n\u0153\3\2\2\2\f\u0165\3\2\2\2\16"+
		"\u016a\3\2\2\2\20\u017d\3\2\2\2\22\u017f\3\2\2\2\24\u0199\3\2\2\2\26\u01ad"+
		"\3\2\2\2\30\u01b7\3\2\2\2\32\u01ba\3\2\2\2\34\u01c0\3\2\2\2\36\u01c2\3"+
		"\2\2\2 \u01c4\3\2\2\2\"\u01d1\3\2\2\2$\u01d6\3\2\2\2&\u01da\3\2\2\2(\u01df"+
		"\3\2\2\2*\u01e2\3\2\2\2,\u01ed\3\2\2\2.\u01f0\3\2\2\2\60\u01f4\3\2\2\2"+
		"\62\u0201\3\2\2\2\64\u0217\3\2\2\2\66\u0219\3\2\2\28\u021c\3\2\2\2:\u021e"+
		"\3\2\2\2<\u0221\3\2\2\2>\u0227\3\2\2\2@\u022f\3\2\2\2B\u0232\3\2\2\2D"+
		"\u023d\3\2\2\2F\u024f\3\2\2\2H\u0251\3\2\2\2J\u0257\3\2\2\2L\u0259\3\2"+
		"\2\2N\u0267\3\2\2\2P\u0271\3\2\2\2R\u0273\3\2\2\2T\u0276\3\2\2\2V\u027b"+
		"\3\2\2\2X\u027d\3\2\2\2Z\u0299\3\2\2\2\\\u029b\3\2\2\2^\u02a4\3\2\2\2"+
		"`\u02aa\3\2\2\2b\u02b0\3\2\2\2d\u02b6\3\2\2\2f\u02be\3\2\2\2h\u02c6\3"+
		"\2\2\2j\u02ce\3\2\2\2l\u02d2\3\2\2\2n\u02d6\3\2\2\2p\u02dc\3\2\2\2r\u02ee"+
		"\3\2\2\2t\u02f1\3\2\2\2v\u02f4\3\2\2\2x\u02ff\3\2\2\2z\u0301\3\2\2\2|"+
		"\u0308\3\2\2\2~\u030a\3\2\2\2\u0080\u030e\3\2\2\2\u0082\u0313\3\2\2\2"+
		"\u0084\u031b\3\2\2\2\u0086\u0322\3\2\2\2\u0088\u032a\3\2\2\2\u008a\u0334"+
		"\3\2\2\2\u008c\u033c\3\2\2\2\u008e\u0344\3\2\2\2\u0090\u034b\3\2\2\2\u0092"+
		"\u035d\3\2\2\2\u0094\u035f\3\2\2\2\u0096\u0362\3\2\2\2\u0098\u0366\3\2"+
		"\2\2\u009a\u036d\3\2\2\2\u009c\u0374\3\2\2\2\u009e\u0379\3\2\2\2\u00a0"+
		"\u037b\3\2\2\2\u00a2\u0385\3\2\2\2\u00a4\u0396\3\2\2\2\u00a6\u03a4\3\2"+
		"\2\2\u00a8\u03a6\3\2\2\2\u00aa\u03a9\3\2\2\2\u00ac\u03b1\3\2\2\2\u00ae"+
		"\u03ba\3\2\2\2\u00b0\u03bc\3\2\2\2\u00b2\u03bf\3\2\2\2\u00b4\u03c9\3\2"+
		"\2\2\u00b6\u03d1\3\2\2\2\u00b8\u03d7\3\2\2\2\u00ba\u03e7\3\2\2\2\u00bc"+
		"\u03ea\3\2\2\2\u00be\u03ec\3\2\2\2\u00c0\u03fb\3\2\2\2\u00c2\u03fd\3\2"+
		"\2\2\u00c4\u0405\3\2\2\2\u00c6\u040d\3\2\2\2\u00c8\u0410\3\2\2\2\u00ca"+
		"\u0414\3\2\2\2\u00cc\u0422\3\2\2\2\u00ce\u0426\3\2\2\2\u00d0\u0428\3\2"+
		"\2\2\u00d2\u042a\3\2\2\2\u00d4\u0432\3\2\2\2\u00d6\u0434\3\2\2\2\u00d8"+
		"\u0436\3\2\2\2\u00da\u043e\3\2\2\2\u00dc\u0446\3\2\2\2\u00de\u044b\3\2"+
		"\2\2\u00e0\u044f\3\2\2\2\u00e2\u0459\3\2\2\2\u00e4\u0468\3\2\2\2\u00e6"+
		"\u046b\3\2\2\2\u00e8\u0471\3\2\2\2\u00ea\u0475\3\2\2\2\u00ec\u0477\3\2"+
		"\2\2\u00ee\u047d\3\2\2\2\u00f0\u047f\3\2\2\2\u00f2\u0483\3\2\2\2\u00f4"+
		"\u048b\3\2\2\2\u00f6\u0495\3\2\2\2\u00f8\u0499\3\2\2\2\u00fa\u049d\3\2"+
		"\2\2\u00fc\u04a1\3\2\2\2\u00fe\u04a3\3\2\2\2\u0100\u04a5\3\2\2\2\u0102"+
		"\u04a7\3\2\2\2\u0104\u04af\3\2\2\2\u0106\u04b1\3\2\2\2\u0108\u04bc\3\2"+
		"\2\2\u010a\u04e0\3\2\2\2\u010c\u04e7\3\2\2\2\u010e\u04f5\3\2\2\2\u0110"+
		"\u0603\3\2\2\2\u0112\u0605\3\2\2\2\u0114\u0610\3\2\2\2\u0116\u061b\3\2"+
		"\2\2\u0118\u0628\3\2\2\2\u011a\u062b\3\2\2\2\u011c\u066f\3\2\2\2\u011e"+
		"\u0671\3\2\2\2\u0120\u0675\3\2\2\2\u0122\u067e\3\2\2\2\u0124\u0680\3\2"+
		"\2\2\u0126\u0682\3\2\2\2\u0128\u0684\3\2\2\2\u012a\u0686\3\2\2\2\u012c"+
		"\u0688\3\2\2\2\u012e\u068c\3\2\2\2\u0130\u068e\3\2\2\2\u0132\u0692\3\2"+
		"\2\2\u0134\u0694\3\2\2\2\u0136\u0697\3\2\2\2\u0138\u013a\5\4\3\2\u0139"+
		"\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u0142\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0143\5\n\6\2\u013f"+
		"\u0143\5\22\n\2\u0140\u0143\5\24\13\2\u0141\u0143\5\26\f\2\u0142\u013e"+
		"\3\2\2\2\u0142\u013f\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0141\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\5V,\2\u0145\3\3\2\2\2\u0146"+
		"\u0149\5\6\4\2\u0147\u0149\5\b\5\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2"+
		"\2\2\u0149\5\3\2\2\2\u014a\u014b\7\5\2\2\u014b\u014c\7\u0081\2\2\u014c"+
		"\7\3\2\2\2\u014d\u014e\7\6\2\2\u014e\u014f\7\u0082\2\2\u014f\u0150\7\u0081"+
		"\2\2\u0150\t\3\2\2\2\u0151\u0154\5\16\b\2\u0152\u0154\5\30\r\2\u0153\u0151"+
		"\3\2\2\2\u0153\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0159\5\34\17\2"+
		"\u0156\u0158\5\36\20\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157"+
		"\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015f\3\2\2\2\u015b\u0159\3\2\2\2\u015c"+
		"\u015e\5\"\22\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3"+
		"\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162"+
		"\u0163\5*\26\2\u0163\u0164\5B\"\2\u0164\13\3\2\2\2\u0165\u0166\5\16\b"+
		"\2\u0166\u0167\5*\26\2\u0167\u0168\5B\"\2\u0168\u0169\5V,\2\u0169\r\3"+
		"\2\2\2\u016a\u016c\7\7\2\2\u016b\u016d\t\2\2\2\u016c\u016b\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u0174\3\2\2\2\u016e\u0170\5\20\t\2\u016f\u016e\3"+
		"\2\2\2\u0170\u0171\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0175\3\2\2\2\u0173\u0175\7\u00a8\2\2\u0174\u016f\3\2\2\2\u0174\u0173"+
		"\3\2\2\2\u0175\17\3\2\2\2\u0176\u017e\5\u00fe\u0080\2\u0177\u0178\7\u009e"+
		"\2\2\u0178\u0179\5\u0108\u0085\2\u0179\u017a\7<\2\2\u017a\u017b\5\u00fe"+
		"\u0080\2\u017b\u017c\7\u009f\2\2\u017c\u017e\3\2\2\2\u017d\u0176\3\2\2"+
		"\2\u017d\u0177\3\2\2\2\u017e\21\3\2\2\2\u017f\u0197\7\n\2\2\u0180\u0184"+
		"\5\u00b6\\\2\u0181\u0183\5\32\16\2\u0182\u0181\3\2\2\2\u0183\u0186\3\2"+
		"\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2\2\2\u0186"+
		"\u0184\3\2\2\2\u0187\u0188\5*\26\2\u0188\u0189\5B\"\2\u0189\u0198\3\2"+
		"\2\2\u018a\u018c\5\32\16\2\u018b\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d"+
		"\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2"+
		"\2\2\u0190\u0191\7\20\2\2\u0191\u0193\7\u00a0\2\2\u0192\u0194\5\u0088"+
		"E\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0196\7\u00a1\2\2\u0196\u0198\5B\"\2\u0197\u0180\3\2\2\2\u0197\u018d"+
		"\3\2\2\2\u0198\23\3\2\2\2\u0199\u01a0\7\13\2\2\u019a\u019c\5\u00fc\177"+
		"\2\u019b\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u01a1\7\u00a8\2\2\u01a0\u019b\3\2\2"+
		"\2\u01a0\u019f\3\2\2\2\u01a1\u01a5\3\2\2\2\u01a2\u01a4\5\32\16\2\u01a3"+
		"\u01a2\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01aa\5*\26\2\u01a9"+
		"\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\5B"+
		"\"\2\u01ac\25\3\2\2\2\u01ad\u01b1\7\f\2\2\u01ae\u01b0\5\32\16\2\u01af"+
		"\u01ae\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2"+
		"\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\5*\26\2\u01b5"+
		"\u01b6\5B\"\2\u01b6\27\3\2\2\2\u01b7\u01b8\7\n\2\2\u01b8\u01b9\5\u008a"+
		"F\2\u01b9\31\3\2\2\2\u01ba\u01bc\7\r\2\2\u01bb\u01bd\7\16\2\2\u01bc\u01bb"+
		"\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\5\u012e\u0098"+
		"\2\u01bf\33\3\2\2\2\u01c0\u01c1\5$\23\2\u01c1\35\3\2\2\2\u01c2\u01c3\5"+
		" \21\2\u01c3\37\3\2\2\2\u01c4\u01c5\7y\2\2\u01c5\u01c6\7\22\2\2\u01c6"+
		"\u01c7\7\u009e\2\2\u01c7\u01cc\5\u00fe\u0080\2\u01c8\u01c9\7\u00aa\2\2"+
		"\u01c9\u01cb\5\u00fe\u0080\2\u01ca\u01c8\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc"+
		"\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2"+
		"\2\2\u01cf\u01d0\7\u009f\2\2\u01d0!\3\2\2\2\u01d1\u01d2\7\r\2\2\u01d2"+
		"\u01d3\7\17\2\2\u01d3\u01d4\5\u0100\u0081\2\u01d4\u01d5\5\u012e\u0098"+
		"\2\u01d5#\3\2\2\2\u01d6\u01d7\7t\2\2\u01d7\u01d8\5@!\2\u01d8\u01d9\5("+
		"\25\2\u01d9%\3\2\2\2\u01da\u01db\7\r\2\2\u01db\u01dc\7_\2\2\u01dc\u01dd"+
		"\5@!\2\u01dd\u01de\5(\25\2\u01de\'\3\2\2\2\u01df\u01e0\t\3\2\2\u01e0)"+
		"\3\2\2\2\u01e1\u01e3\7\20\2\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2"+
		"\u01e3\u01e4\3\2\2\2\u01e4\u01e5\5,\27\2\u01e5\u01e7\7\u00a0\2\2\u01e6"+
		"\u01e8\5:\36\2\u01e7\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01e7\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\7\u00a1\2\2\u01ec"+
		"+\3\2\2\2\u01ed\u01ee\7}\2\2\u01ee\u01ef\5.\30\2\u01ef-\3\2\2\2\u01f0"+
		"\u01f1\7\u009e\2\2\u01f1\u01f2\5\60\31\2\u01f2\u01f3\7\u009f\2\2\u01f3"+
		"/\3\2\2\2\u01f4\u01fe\5\64\33\2\u01f5\u01f7\5\62\32\2\u01f6\u01f5\3\2"+
		"\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"\u01fa\3\2\2\2\u01fa\u01fb\5\64\33\2\u01fb\u01fd\3\2\2\2\u01fc\u01f6\3"+
		"\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\61\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0202\7~\2\2\u0202\63\3\2\2\2\u0203"+
		"\u0205\5\u0100\u0081\2\u0204\u0206\5\u0102\u0082\2\u0205\u0204\3\2\2\2"+
		"\u0205\u0206\3\2\2\2\u0206\u0218\3\2\2\2\u0207\u0208\7\u009e\2\2\u0208"+
		"\u0209\5\u0100\u0081\2\u0209\u020a\58\35\2\u020a\u0210\5\u0100\u0081\2"+
		"\u020b\u020c\58\35\2\u020c\u020d\5\u0100\u0081\2\u020d\u020f\3\2\2\2\u020e"+
		"\u020b\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2"+
		"\2\2\u0211\u0213\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0215\7\u009f\2\2\u0214"+
		"\u0216\5\u0102\u0082\2\u0215\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218"+
		"\3\2\2\2\u0217\u0203\3\2\2\2\u0217\u0207\3\2\2\2\u0218\65\3\2\2\2\u0219"+
		"\u021a\58\35\2\u021a\u021b\5\u0100\u0081\2\u021b\67\3\2\2\2\u021c\u021d"+
		"\7z\2\2\u021d9\3\2\2\2\u021e\u021f\5<\37\2\u021f\u0220\5\u008aF\2\u0220"+
		";\3\2\2\2\u0221\u0222\7r\2\2\u0222\u0223\7q\2\2\u0223\u0224\5\u0100\u0081"+
		"\2\u0224\u0225\7s\2\2\u0225\u0226\5> \2\u0226=\3\2\2\2\u0227\u022c\5\u0100"+
		"\u0081\2\u0228\u0229\7\u00aa\2\2\u0229\u022b\5\u0100\u0081\2\u022a\u0228"+
		"\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"?\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0230\7\u0080\2\2\u0230A\3\2\2\2\u0231"+
		"\u0233\5D#\2\u0232\u0231\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0235\3\2\2"+
		"\2\u0234\u0236\5H%\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238"+
		"\3\2\2\2\u0237\u0239\5L\'\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239"+
		"\u023b\3\2\2\2\u023a\u023c\5P)\2\u023b\u023a\3\2\2\2\u023b\u023c\3\2\2"+
		"\2\u023cC\3\2\2\2\u023d\u023e\7=\2\2\u023e\u0240\7\22\2\2\u023f\u0241"+
		"\5F$\2\u0240\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0240\3\2\2\2\u0242"+
		"\u0243\3\2\2\2\u0243E\3\2\2\2\u0244\u0250\5\u0110\u0089\2\u0245\u0250"+
		"\5\u00b0Y\2\u0246\u0247\7\u009e\2\2\u0247\u024a\5\u0108\u0085\2\u0248"+
		"\u0249\7<\2\2\u0249\u024b\5\u00fe\u0080\2\u024a\u0248\3\2\2\2\u024a\u024b"+
		"\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\7\u009f\2\2\u024d\u0250\3\2\2"+
		"\2\u024e\u0250\5\u00fe\u0080\2\u024f\u0244\3\2\2\2\u024f\u0245\3\2\2\2"+
		"\u024f\u0246\3\2\2\2\u024f\u024e\3\2\2\2\u0250G\3\2\2\2\u0251\u0253\7"+
		">\2\2\u0252\u0254\5J&\2\u0253\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256I\3\2\2\2\u0257\u0258\5\u00ae"+
		"X\2\u0258K\3\2\2\2\u0259\u025a\7\21\2\2\u025a\u025c\7\22\2\2\u025b\u025d"+
		"\5N(\2\u025c\u025b\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u025c\3\2\2\2\u025e"+
		"\u025f\3\2\2\2\u025fM\3\2\2\2\u0260\u0261\t\4\2\2\u0261\u0262\7\u009e"+
		"\2\2\u0262\u0263\5\u0108\u0085\2\u0263\u0264\7\u009f\2\2\u0264\u0268\3"+
		"\2\2\2\u0265\u0268\5\u00aeX\2\u0266\u0268\5\u00fe\u0080\2\u0267\u0260"+
		"\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0266\3\2\2\2\u0268O\3\2\2\2\u0269"+
		"\u026b\5R*\2\u026a\u026c\5T+\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2\2"+
		"\u026c\u0272\3\2\2\2\u026d\u026f\5T+\2\u026e\u0270\5R*\2\u026f\u026e\3"+
		"\2\2\2\u026f\u0270\3\2\2\2\u0270\u0272\3\2\2\2\u0271\u0269\3\2\2\2\u0271"+
		"\u026d\3\2\2\2\u0272Q\3\2\2\2\u0273\u0274\7\25\2\2\u0274\u0275\7\u0089"+
		"\2\2\u0275S\3\2\2\2\u0276\u0277\7\26\2\2\u0277\u0278\7\u0089\2\2\u0278"+
		"U\3\2\2\2\u0279\u027a\7\27\2\2\u027a\u027c\5\u009eP\2\u027b\u0279\3\2"+
		"\2\2\u027b\u027c\3\2\2\2\u027cW\3\2\2\2\u027d\u028c\5\4\3\2\u027e\u0285"+
		"\5Z.\2\u027f\u0280\7\u00a4\2\2\u0280\u0281\5\4\3\2\u0281\u0282\5Z.\2\u0282"+
		"\u0284\3\2\2\2\u0283\u027f\3\2\2\2\u0284\u0287\3\2\2\2\u0285\u0283\3\2"+
		"\2\2\u0285\u0286\3\2\2\2\u0286\u028a\3\2\2\2\u0287\u0285\3\2\2\2\u0288"+
		"\u0289\7\u00a4\2\2\u0289\u028b\5\4\3\2\u028a\u0288\3\2\2\2\u028a\u028b"+
		"\3\2\2\2\u028b\u028d\3\2\2\2\u028c\u027e\3\2\2\2\u028c\u028d\3\2\2\2\u028d"+
		"Y\3\2\2\2\u028e\u029a\5\\/\2\u028f\u029a\5^\60\2\u0290\u029a\5`\61\2\u0291"+
		"\u029a\5d\63\2\u0292\u029a\5f\64\2\u0293\u029a\5h\65\2\u0294\u029a\5b"+
		"\62\2\u0295\u029a\5j\66\2\u0296\u029a\5l\67\2\u0297\u029a\5n8\2\u0298"+
		"\u029a\5p9\2\u0299\u028e\3\2\2\2\u0299\u028f\3\2\2\2\u0299\u0290\3\2\2"+
		"\2\u0299\u0291\3\2\2\2\u0299\u0292\3\2\2\2\u0299\u0293\3\2\2\2\u0299\u0294"+
		"\3\2\2\2\u0299\u0295\3\2\2\2\u0299\u0296\3\2\2\2\u0299\u0297\3\2\2\2\u0299"+
		"\u0298\3\2\2\2\u029a[\3\2\2\2\u029b\u029d\7+\2\2\u029c\u029e\7\65\2\2"+
		"\u029d\u029c\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a2"+
		"\5\u012e\u0098\2\u02a0\u02a1\7:\2\2\u02a1\u02a3\5z>\2\u02a2\u02a0\3\2"+
		"\2\2\u02a2\u02a3\3\2\2\2\u02a3]\3\2\2\2\u02a4\u02a6\7,\2\2\u02a5\u02a7"+
		"\7\65\2\2\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a8\3\2\2\2"+
		"\u02a8\u02a9\5|?\2\u02a9_\3\2\2\2\u02aa\u02ac\7-\2\2\u02ab\u02ad\7\65"+
		"\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae"+
		"\u02af\5|?\2\u02afa\3\2\2\2\u02b0\u02b2\7\61\2\2\u02b1\u02b3\7\65\2\2"+
		"\u02b2\u02b1\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5"+
		"\5z>\2\u02b5c\3\2\2\2\u02b6\u02b8\7.\2\2\u02b7\u02b9\7\65\2\2\u02b8\u02b7"+
		"\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bb\5x=\2\u02bb"+
		"\u02bc\7;\2\2\u02bc\u02bd\5x=\2\u02bde\3\2\2\2\u02be\u02c0\7/\2\2\u02bf"+
		"\u02c1\7\65\2\2\u02c0\u02bf\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\3"+
		"\2\2\2\u02c2\u02c3\5x=\2\u02c3\u02c4\7;\2\2\u02c4\u02c5\5x=\2\u02c5g\3"+
		"\2\2\2\u02c6\u02c8\7\60\2\2\u02c7\u02c9\7\65\2\2\u02c8\u02c7\3\2\2\2\u02c8"+
		"\u02c9\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\5x=\2\u02cb\u02cc\7;\2"+
		"\2\u02cc\u02cd\5x=\2\u02cdi\3\2\2\2\u02ce\u02cf\7\63\2\2\u02cf\u02d0\7"+
		"8\2\2\u02d0\u02d1\5\u0080A\2\u02d1k\3\2\2\2\u02d2\u02d3\7\62\2\2\u02d3"+
		"\u02d4\78\2\2\u02d4\u02d5\5\u0080A\2\u02d5m\3\2\2\2\u02d6\u02d7\7\62\2"+
		"\2\u02d7\u02d8\7\20\2\2\u02d8\u02d9\5~@\2\u02d9o\3\2\2\2\u02da\u02db\7"+
		"9\2\2\u02db\u02dd\5\u012e\u0098\2\u02dc\u02da\3\2\2\2\u02dc\u02dd\3\2"+
		"\2\2\u02dd\u02e3\3\2\2\2\u02de\u02e0\5r:\2\u02df\u02e1\5t;\2\u02e0\u02df"+
		"\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e4\3\2\2\2\u02e2\u02e4\5t;\2\u02e3"+
		"\u02de\3\2\2\2\u02e3\u02e2\3\2\2\2\u02e4\u02e8\3\2\2\2\u02e5\u02e7\5v"+
		"<\2\u02e6\u02e5\3\2\2\2\u02e7\u02ea\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8"+
		"\u02e9\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02e8\3\2\2\2\u02eb\u02ec\7\20"+
		"\2\2\u02ec\u02ed\5\u008aF\2\u02edq\3\2\2\2\u02ee\u02ef\7\62\2\2\u02ef"+
		"\u02f0\5~@\2\u02f0s\3\2\2\2\u02f1\u02f2\7\63\2\2\u02f2\u02f3\5~@\2\u02f3"+
		"u\3\2\2\2\u02f4\u02f6\7\64\2\2\u02f5\u02f7\7\16\2\2\u02f6\u02f5\3\2\2"+
		"\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f9\5\u012e\u0098\2"+
		"\u02f9w\3\2\2\2\u02fa\u0300\7\66\2\2\u02fb\u02fd\7\31\2\2\u02fc\u02fb"+
		"\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0300\5\u012e\u0098"+
		"\2\u02ff\u02fa\3\2\2\2\u02ff\u02fc\3\2\2\2\u0300y\3\2\2\2\u0301\u0302"+
		"\7\31\2\2\u0302\u0303\5\u012e\u0098\2\u0303{\3\2\2\2\u0304\u0309\5z>\2"+
		"\u0305\u0309\7\66\2\2\u0306\u0309\7\16\2\2\u0307\u0309\7\67\2\2\u0308"+
		"\u0304\3\2\2\2\u0308\u0305\3\2\2\2\u0308\u0306\3\2\2\2\u0308\u0307\3\2"+
		"\2\2\u0309}\3\2\2\2\u030a\u030b\7\u00a0\2\2\u030b\u030c\5\u0082B\2\u030c"+
		"\u030d\7\u00a1\2\2\u030d\177\3\2\2\2\u030e\u030f\7\u00a0\2\2\u030f\u0310"+
		"\5\u0082B\2\u0310\u0311\7\u00a1\2\2\u0311\u0081\3\2\2\2\u0312\u0314\5"+
		"\u0088E\2\u0313\u0312\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0318\3\2\2\2"+
		"\u0315\u0317\5\u0084C\2\u0316\u0315\3\2\2\2\u0317\u031a\3\2\2\2\u0318"+
		"\u0316\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u0083\3\2\2\2\u031a\u0318\3\2"+
		"\2\2\u031b\u031d\5\u0086D\2\u031c\u031e\7\u00a5\2\2\u031d\u031c\3\2\2"+
		"\2\u031d\u031e\3\2\2\2\u031e\u0320\3\2\2\2\u031f\u0321\5\u0088E\2\u0320"+
		"\u031f\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0085\3\2\2\2\u0322\u0323\7\31"+
		"\2\2\u0323\u0324\5\u00fc\177\2\u0324\u0326\7\u00a0\2\2\u0325\u0327\5\u0088"+
		"E\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0328\3\2\2\2\u0328"+
		"\u0329\7\u00a1\2\2\u0329\u0087\3\2\2\2\u032a\u0331\5\u00ba^\2\u032b\u032d"+
		"\7\u00a5\2\2\u032c\u032e\5\u00ba^\2\u032d\u032c\3\2\2\2\u032d\u032e\3"+
		"\2\2\2\u032e\u0330\3\2\2\2\u032f\u032b\3\2\2\2\u0330\u0333\3\2\2\2\u0331"+
		"\u032f\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0089\3\2\2\2\u0333\u0331\3\2"+
		"\2\2\u0334\u0337\7\u00a0\2\2\u0335\u0338\5\f\7\2\u0336\u0338\5\u008cG"+
		"\2\u0337\u0335\3\2\2\2\u0337\u0336\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u033a"+
		"\7\u00a1\2\2\u033a\u008b\3\2\2\2\u033b\u033d\5\u0090I\2\u033c\u033b\3"+
		"\2\2\2\u033c\u033d\3\2\2\2\u033d\u0341\3\2\2\2\u033e\u0340\5\u008eH\2"+
		"\u033f\u033e\3\2\2\2\u0340\u0343\3\2\2\2\u0341\u033f\3\2\2\2\u0341\u0342"+
		"\3\2\2\2\u0342\u008d\3\2\2\2\u0343\u0341\3\2\2\2\u0344\u0346\5\u0092J"+
		"\2\u0345\u0347\7\u00a5\2\2\u0346\u0345\3\2\2\2\u0346\u0347\3\2\2\2\u0347"+
		"\u0349\3\2\2\2\u0348\u034a\5\u0090I\2\u0349\u0348\3\2\2\2\u0349\u034a"+
		"\3\2\2\2\u034a\u008f\3\2\2\2\u034b\u0352\5\u00c6d\2\u034c\u034e\7\u00a5"+
		"\2\2\u034d\u034f\5\u00c6d\2\u034e\u034d\3\2\2\2\u034e\u034f\3\2\2\2\u034f"+
		"\u0351\3\2\2\2\u0350\u034c\3\2\2\2\u0351\u0354\3\2\2\2\u0352\u0350\3\2"+
		"\2\2\u0352\u0353\3\2\2\2\u0353\u0091\3\2\2\2\u0354\u0352\3\2\2\2\u0355"+
		"\u035e\5\u00aaV\2\u0356\u035e\5\u0094K\2\u0357\u035e\5\u00a8U\2\u0358"+
		"\u035e\5\u0096L\2\u0359\u035e\5\u0098M\2\u035a\u035e\5\u00acW\2\u035b"+
		"\u035e\5\u009aN\2\u035c\u035e\5\u009cO\2\u035d\u0355\3\2\2\2\u035d\u0356"+
		"\3\2\2\2\u035d\u0357\3\2\2\2\u035d\u0358\3\2\2\2\u035d\u0359\3\2\2\2\u035d"+
		"\u035a\3\2\2\2\u035d\u035b\3\2\2\2\u035d\u035c\3\2\2\2\u035e\u0093\3\2"+
		"\2\2\u035f\u0360\7\30\2\2\u0360\u0361\5\u008aF\2\u0361\u0095\3\2\2\2\u0362"+
		"\u0363\7\31\2\2\u0363\u0364\5\u00fc\177\2\u0364\u0365\5\u008aF\2\u0365"+
		"\u0097\3\2\2\2\u0366\u0368\7A\2\2\u0367\u0369\7\65\2\2\u0368\u0367\3\2"+
		"\2\2\u0368\u0369\3\2\2\2\u0369\u036a\3\2\2\2\u036a\u036b\5\u00fc\177\2"+
		"\u036b\u036c\5\u008aF\2\u036c\u0099\3\2\2\2\u036d\u036e\7B\2\2\u036e\u036f"+
		"\7\u009e\2\2\u036f\u0370\5\u0108\u0085\2\u0370\u0371\7<\2\2\u0371\u0372"+
		"\5\u00fe\u0080\2\u0372\u0373\7\u009f\2\2\u0373\u009b\3\2\2\2\u0374\u0375"+
		"\7\27\2\2\u0375\u0376\5\u009eP\2\u0376\u009d\3\2\2\2\u0377\u037a\5\u00a0"+
		"Q\2\u0378\u037a\5\u00a2R\2\u0379\u0377\3\2\2\2\u0379\u0378\3\2\2\2\u037a"+
		"\u009f\3\2\2\2\u037b\u037c\5\u00fe\u0080\2\u037c\u0380\7\u00a0\2\2\u037d"+
		"\u037f\5\u00a6T\2\u037e\u037d\3\2\2\2\u037f\u0382\3\2\2\2\u0380\u037e"+
		"\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0383\3\2\2\2\u0382\u0380\3\2\2\2\u0383"+
		"\u0384\7\u00a1\2\2\u0384\u00a1\3\2\2\2\u0385\u0389\7\u009e\2\2\u0386\u0388"+
		"\5\u00fe\u0080\2\u0387\u0386\3\2\2\2\u0388\u038b\3\2\2\2\u0389\u0387\3"+
		"\2\2\2\u0389\u038a\3\2\2\2\u038a\u038c\3\2\2\2\u038b\u0389\3\2\2\2\u038c"+
		"\u038d\7\u009f\2\2\u038d\u0391\7\u00a0\2\2\u038e\u0390\5\u00a4S\2\u038f"+
		"\u038e\3\2\2\2\u0390\u0393\3\2\2\2\u0391\u038f\3\2\2\2\u0391\u0392\3\2"+
		"\2\2\u0392\u0394\3\2\2\2\u0393\u0391\3\2\2\2\u0394\u0395\7\u00a1\2\2\u0395"+
		"\u00a3\3\2\2\2\u0396\u039a\7\u009e\2\2\u0397\u0399\5\u00a6T\2\u0398\u0397"+
		"\3\2\2\2\u0399\u039c\3\2\2\2\u039a\u0398\3\2\2\2\u039a\u039b\3\2\2\2\u039b"+
		"\u039d\3\2\2\2\u039c\u039a\3\2\2\2\u039d\u039e\7\u009f\2\2\u039e\u00a5"+
		"\3\2\2\2\u039f\u03a5\5\u012e\u0098\2\u03a0\u03a5\5\u0120\u0091\2\u03a1"+
		"\u03a5\5\u0122\u0092\2\u03a2\u03a5\5\u012a\u0096\2\u03a3\u03a5\7?\2\2"+
		"\u03a4\u039f\3\2\2\2\u03a4\u03a0\3\2\2\2\u03a4\u03a1\3\2\2\2\u03a4\u03a2"+
		"\3\2\2\2\u03a4\u03a3\3\2\2\2\u03a5\u00a7\3\2\2\2\u03a6\u03a7\7C\2\2\u03a7"+
		"\u03a8\5\u008aF\2\u03a8\u00a9\3\2\2\2\u03a9\u03ae\5\u008aF\2\u03aa\u03ab"+
		"\7\32\2\2\u03ab\u03ad\5\u008aF\2\u03ac\u03aa\3\2\2\2\u03ad\u03b0\3\2\2"+
		"\2\u03ae\u03ac\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u00ab\3\2\2\2\u03b0\u03ae"+
		"\3\2\2\2\u03b1\u03b2\7\33\2\2\u03b2\u03b3\5\u00aeX\2\u03b3\u00ad\3\2\2"+
		"\2\u03b4\u03b5\7\u009e\2\2\u03b5\u03b6\5\u0108\u0085\2\u03b6\u03b7\7\u009f"+
		"\2\2\u03b7\u03bb\3\2\2\2\u03b8\u03bb\5\u0110\u0089\2\u03b9\u03bb\5\u00b0"+
		"Y\2\u03ba\u03b4\3\2\2\2\u03ba\u03b8\3\2\2\2\u03ba\u03b9\3\2\2\2\u03bb"+
		"\u00af\3\2\2\2\u03bc\u03bd\5\u012e\u0098\2\u03bd\u03be\5\u00b2Z\2\u03be"+
		"\u00b1\3\2\2\2\u03bf\u03c5\7\u009e\2\2\u03c0\u03c2\7\b\2\2\u03c1\u03c0"+
		"\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c6\5\u00b4["+
		"\2\u03c4\u03c6\3\2\2\2\u03c5\u03c1\3\2\2\2\u03c5\u03c4\3\2\2\2\u03c6\u03c7"+
		"\3\2\2\2\u03c7\u03c8\7\u009f\2\2\u03c8\u00b3\3\2\2\2\u03c9\u03ce\5\u0108"+
		"\u0085\2\u03ca\u03cb\7\u00aa\2\2\u03cb\u03cd\5\u0108\u0085\2\u03cc\u03ca"+
		"\3\2\2\2\u03cd\u03d0\3\2\2\2\u03ce\u03cc\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf"+
		"\u00b5\3\2\2\2\u03d0\u03ce\3\2\2\2\u03d1\u03d3\7\u00a0\2\2\u03d2\u03d4"+
		"\5\u00b8]\2\u03d3\u03d2\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03d5\3\2\2"+
		"\2\u03d5\u03d6\7\u00a1\2\2\u03d6\u00b7\3\2\2\2\u03d7\u03de\5\u00ba^\2"+
		"\u03d8\u03da\7\u00a5\2\2\u03d9\u03db\5\u00b8]\2\u03da\u03d9\3\2\2\2\u03da"+
		"\u03db\3\2\2\2\u03db\u03dd\3\2\2\2\u03dc\u03d8\3\2\2\2\u03dd\u03e0\3\2"+
		"\2\2\u03de\u03dc\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u00b9\3\2\2\2\u03e0"+
		"\u03de\3\2\2\2\u03e1\u03e2\5\u00fa~\2\u03e2\u03e3\5\u00be`\2\u03e3\u03e8"+
		"\3\2\2\2\u03e4\u03e5\5\u00eav\2\u03e5\u03e6\5\u00bc_\2\u03e6\u03e8\3\2"+
		"\2\2\u03e7\u03e1\3\2\2\2\u03e7\u03e4\3\2\2\2\u03e8\u00bb\3\2\2\2\u03e9"+
		"\u03eb\5\u00be`\2\u03ea\u03e9\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb\u00bd"+
		"\3\2\2\2\u03ec\u03ed\5\u00c0a\2\u03ed\u03f6\5\u00c2b\2\u03ee\u03f2\7\u00a4"+
		"\2\2\u03ef\u03f0\5\u00c0a\2\u03f0\u03f1\5\u00c2b\2\u03f1\u03f3\3\2\2\2"+
		"\u03f2\u03ef\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f5\3\2\2\2\u03f4\u03ee"+
		"\3\2\2\2\u03f5\u03f8\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7"+
		"\u00bf\3\2\2\2\u03f8\u03f6\3\2\2\2\u03f9\u03fc\5\u00fc\177\2\u03fa\u03fc"+
		"\7\34\2\2\u03fb\u03f9\3\2\2\2\u03fb\u03fa\3\2\2\2\u03fc\u00c1\3\2\2\2"+
		"\u03fd\u0402\5\u00c4c\2\u03fe\u03ff\7\u00aa\2\2\u03ff\u0401\5\u00c4c\2"+
		"\u0400\u03fe\3\2\2\2\u0401\u0404\3\2\2\2\u0402\u0400\3\2\2\2\u0402\u0403"+
		"\3\2\2\2\u0403\u00c3\3\2\2\2\u0404\u0402\3\2\2\2\u0405\u0406\5\u00f6|"+
		"\2\u0406\u00c5\3\2\2\2\u0407\u0408\5\u00fa~\2\u0408\u0409\5\u00caf\2\u0409"+
		"\u040e\3\2\2\2\u040a\u040b\5\u00eex\2\u040b\u040c\5\u00c8e\2\u040c\u040e"+
		"\3\2\2\2\u040d\u0407\3\2\2\2\u040d\u040a\3\2\2\2\u040e\u00c7\3\2\2\2\u040f"+
		"\u0411\5\u00caf\2\u0410\u040f\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u00c9"+
		"\3\2\2\2\u0412\u0415\5\u00ceh\2\u0413\u0415\5\u00d0i\2\u0414\u0412\3\2"+
		"\2\2\u0414\u0413\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u041d\5\u00d2j\2\u0417"+
		"\u0419\7\u00a4\2\2\u0418\u041a\5\u00ccg\2\u0419\u0418\3\2\2\2\u0419\u041a"+
		"\3\2\2\2\u041a\u041c\3\2\2\2\u041b\u0417\3\2\2\2\u041c\u041f\3\2\2\2\u041d"+
		"\u041b\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u00cb\3\2\2\2\u041f\u041d\3\2"+
		"\2\2\u0420\u0423\5\u00ceh\2\u0421\u0423\5\u00d0i\2\u0422\u0420\3\2\2\2"+
		"\u0422\u0421\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u0425\5\u00c2b\2\u0425"+
		"\u00cd\3\2\2\2\u0426\u0427\5\u00d6l\2\u0427\u00cf\3\2\2\2\u0428\u0429"+
		"\5\u00fe\u0080\2\u0429\u00d1\3\2\2\2\u042a\u042f\5\u00d4k\2\u042b\u042c"+
		"\7\u00aa\2\2\u042c\u042e\5\u00d4k\2\u042d\u042b\3\2\2\2\u042e\u0431\3"+
		"\2\2\2\u042f\u042d\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u00d3\3\2\2\2\u0431"+
		"\u042f\3\2\2\2\u0432\u0433\5\u00f8}\2\u0433\u00d5\3\2\2\2\u0434\u0435"+
		"\5\u00d8m\2\u0435\u00d7\3\2\2\2\u0436\u043b\5\u00dan\2\u0437\u0438\7\u00b0"+
		"\2\2\u0438\u043a\5\u00dan\2\u0439\u0437\3\2\2\2\u043a\u043d\3\2\2\2\u043b"+
		"\u0439\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u00d9\3\2\2\2\u043d\u043b\3\2"+
		"\2\2\u043e\u0443\5\u00dep\2\u043f\u0440\7\u00ac\2\2\u0440\u0442\5\u00de"+
		"p\2\u0441\u043f\3\2\2\2\u0442\u0445\3\2\2\2\u0443\u0441\3\2\2\2\u0443"+
		"\u0444\3\2\2\2\u0444\u00db\3\2\2\2\u0445\u0443\3\2\2\2\u0446\u0448\5\u00e2"+
		"r\2\u0447\u0449\5\u00e0q\2\u0448\u0447\3\2\2\2\u0448\u0449\3\2\2\2\u0449"+
		"\u00dd\3\2\2\2\u044a\u044c\7\u009d\2\2\u044b\u044a\3\2\2\2\u044b\u044c"+
		"\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u044e\5\u00dco\2\u044e\u00df\3\2\2"+
		"\2\u044f\u0450\t\5\2\2\u0450\u00e1\3\2\2\2\u0451\u045a\5\u012e\u0098\2"+
		"\u0452\u045a\7\34\2\2\u0453\u0454\7\u00ab\2\2\u0454\u045a\5\u00e4s\2\u0455"+
		"\u0456\7\u009e\2\2\u0456\u0457\5\u00d6l\2\u0457\u0458\7\u009f\2\2\u0458"+
		"\u045a\3\2\2\2\u0459\u0451\3\2\2\2\u0459\u0452\3\2\2\2\u0459\u0453\3\2"+
		"\2\2\u0459\u0455\3\2\2\2\u045a\u00e3\3\2\2\2\u045b\u0469\5\u00e6t\2\u045c"+
		"\u0465\7\u009e\2\2\u045d\u0462\5\u00e6t\2\u045e\u045f\7\u00b0\2\2\u045f"+
		"\u0461\5\u00e6t\2\u0460\u045e\3\2\2\2\u0461\u0464\3\2\2\2\u0462\u0460"+
		"\3\2\2\2\u0462\u0463\3\2\2\2\u0463\u0466\3\2\2\2\u0464\u0462\3\2\2\2\u0465"+
		"\u045d\3\2\2\2\u0465\u0466\3\2\2\2\u0466\u0467\3\2\2\2\u0467\u0469\7\u009f"+
		"\2\2\u0468\u045b\3\2\2\2\u0468\u045c\3\2\2\2\u0469\u00e5\3\2\2\2\u046a"+
		"\u046c\7\u009d\2\2\u046b\u046a\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046f"+
		"\3\2\2\2\u046d\u0470\5\u012e\u0098\2\u046e\u0470\7\34\2\2\u046f\u046d"+
		"\3\2\2\2\u046f\u046e\3\2\2\2\u0470\u00e7\3\2\2\2\u0471\u0472\7\u0089\2"+
		"\2\u0472\u00e9\3\2\2\2\u0473\u0476\5\u00f2z\2\u0474\u0476\5\u00ecw\2\u0475"+
		"\u0473\3\2\2\2\u0475\u0474\3\2\2\2\u0476\u00eb\3\2\2\2\u0477\u0478\7\u00a2"+
		"\2\2\u0478\u0479\5\u00be`\2\u0479\u047a\7\u00a3\2\2\u047a\u00ed\3\2\2"+
		"\2\u047b\u047e\5\u00f4{\2\u047c\u047e\5\u00f0y\2\u047d\u047b\3\2\2\2\u047d"+
		"\u047c\3\2\2\2\u047e\u00ef\3\2\2\2\u047f\u0480\7\u00a2\2\2\u0480\u0481"+
		"\5\u00caf\2\u0481\u0482\7\u00a3\2\2\u0482\u00f1\3\2\2\2\u0483\u0485\7"+
		"\u009e\2\2\u0484\u0486\5\u00f6|\2\u0485\u0484\3\2\2\2\u0486\u0487\3\2"+
		"\2\2\u0487\u0485\3\2\2\2\u0487\u0488\3\2\2\2\u0488\u0489\3\2\2\2\u0489"+
		"\u048a\7\u009f\2\2\u048a\u00f3\3\2\2\2\u048b\u048d\7\u009e\2\2\u048c\u048e"+
		"\5\u00f8}\2\u048d\u048c\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u048d\3\2\2"+
		"\2\u048f\u0490\3\2\2\2\u0490\u0491\3\2\2\2\u0491\u0492\7\u009f\2\2\u0492"+
		"\u00f5\3\2\2\2\u0493\u0496\5\u00fa~\2\u0494\u0496\5\u00eav\2\u0495\u0493"+
		"\3\2\2\2\u0495\u0494\3\2\2\2\u0496\u00f7\3\2\2\2\u0497\u049a\5\u00fa~"+
		"\2\u0498\u049a\5\u00eex\2\u0499\u0497\3\2\2\2\u0499\u0498\3\2\2\2\u049a"+
		"\u00f9\3\2\2\2\u049b\u049e\5\u00fe\u0080\2\u049c\u049e\5\u0104\u0083\2"+
		"\u049d\u049b\3\2\2\2\u049d\u049c\3\2\2\2\u049e\u00fb\3\2\2\2\u049f\u04a2"+
		"\5\u00fe\u0080\2\u04a0\u04a2\5\u012e\u0098\2\u04a1\u049f\3\2\2\2\u04a1"+
		"\u04a0\3\2\2\2\u04a2\u00fd\3\2\2\2\u04a3\u04a4\t\6\2\2\u04a4\u00ff\3\2"+
		"\2\2\u04a5\u04a6\7\u0087\2\2\u04a6\u0101\3\2\2\2\u04a7\u04a8\7\177\2\2"+
		"\u04a8\u0103\3\2\2\2\u04a9\u04b0\5\u012e\u0098\2\u04aa\u04b0\5\u0120\u0091"+
		"\2\u04ab\u04b0\5\u0122\u0092\2\u04ac\u04b0\5\u012a\u0096\2\u04ad\u04b0"+
		"\5\u0132\u009a\2\u04ae\u04b0\5\u0106\u0084\2\u04af\u04a9\3\2\2\2\u04af"+
		"\u04aa\3\2\2\2\u04af\u04ab\3\2\2\2\u04af\u04ac\3\2\2\2\u04af\u04ad\3\2"+
		"\2\2\u04af\u04ae\3\2\2\2\u04b0\u0105\3\2\2\2\u04b1\u04b2\7\u009e\2\2\u04b2"+
		"\u04b3\7\u009f\2\2\u04b3\u0107\3\2\2\2\u04b4\u04b5\b\u0085\1\2\u04b5\u04b6"+
		"\t\7\2\2\u04b6\u04bd\5\u0108\u0085\f\u04b7\u04b8\t\b\2\2\u04b8\u04bd\5"+
		"\u0108\u0085\13\u04b9\u04ba\7\u00ab\2\2\u04ba\u04bd\5\u0108\u0085\n\u04bb"+
		"\u04bd\5\u010e\u0088\2\u04bc\u04b4\3\2\2\2\u04bc\u04b7\3\2\2\2\u04bc\u04b9"+
		"\3\2\2\2\u04bc\u04bb\3\2\2\2\u04bd\u04db\3\2\2\2\u04be\u04bf\f\t\2\2\u04bf"+
		"\u04c0\t\7\2\2\u04c0\u04da\5\u0108\u0085\n\u04c1\u04c2\f\b\2\2\u04c2\u04c3"+
		"\t\b\2\2\u04c3\u04da\5\u0108\u0085\t\u04c4\u04c5\f\5\2\2\u04c5\u04c6\t"+
		"\t\2\2\u04c6\u04da\5\u0108\u0085\6\u04c7\u04c8\f\7\2\2\u04c8\u04da\5\u010a"+
		"\u0086\2\u04c9\u04cb\f\6\2\2\u04ca\u04cc\7w\2\2\u04cb\u04ca\3\2\2\2\u04cb"+
		"\u04cc\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04ce\7x\2\2\u04ce\u04d0\7\u009e"+
		"\2\2\u04cf\u04d1\5\u00b4[\2\u04d0\u04cf\3\2\2\2\u04d0\u04d1\3\2\2\2\u04d1"+
		"\u04d2\3\2\2\2\u04d2\u04da\7\u009f\2\2\u04d3\u04d4\f\4\2\2\u04d4\u04d5"+
		"\7\u009b\2\2\u04d5\u04da\5\u0108\u0085\2\u04d6\u04d7\f\3\2\2\u04d7\u04d8"+
		"\7\u009c\2\2\u04d8\u04da\5\u0108\u0085\2\u04d9\u04be\3\2\2\2\u04d9\u04c1"+
		"\3\2\2\2\u04d9\u04c4\3\2\2\2\u04d9\u04c7\3\2\2\2\u04d9\u04c9\3\2\2\2\u04d9"+
		"\u04d3\3\2\2\2\u04d9\u04d6\3\2\2\2\u04da\u04dd\3\2\2\2\u04db\u04d9\3\2"+
		"\2\2\u04db\u04dc\3\2\2\2\u04dc\u0109\3\2\2\2\u04dd\u04db\3\2\2\2\u04de"+
		"\u04e1\5\u0126\u0094\2\u04df\u04e1\5\u0128\u0095\2\u04e0\u04de\3\2\2\2"+
		"\u04e0\u04df\3\2\2\2\u04e1\u04e4\3\2\2\2\u04e2\u04e3\t\7\2\2\u04e3\u04e5"+
		"\5\u010c\u0087\2\u04e4\u04e2\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u010b\3"+
		"\2\2\2\u04e6\u04e8\t\n\2\2\u04e7\u04e6\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8"+
		"\u04e9\3\2\2\2\u04e9\u04ea\5\u010e\u0088\2\u04ea\u010d\3\2\2\2\u04eb\u04ec"+
		"\7\u009e\2\2\u04ec\u04ed\5\u0108\u0085\2\u04ed\u04ee\7\u009f\2\2\u04ee"+
		"\u04f6\3\2\2\2\u04ef\u04f6\5\u0110\u0089\2\u04f0\u04f6\5\u011e\u0090\2"+
		"\u04f1\u04f6\5\u0120\u0091\2\u04f2\u04f6\5\u0122\u0092\2\u04f3\u04f6\5"+
		"\u012a\u0096\2\u04f4\u04f6\5\u00fe\u0080\2\u04f5\u04eb\3\2\2\2\u04f5\u04ef"+
		"\3\2\2\2\u04f5\u04f0\3\2\2\2\u04f5\u04f1\3\2\2\2\u04f5\u04f2\3\2\2\2\u04f5"+
		"\u04f3\3\2\2\2\u04f5\u04f4\3\2\2\2\u04f6\u010f\3\2\2\2\u04f7\u0604\5\u011c"+
		"\u008f\2\u04f8\u04f9\7\35\2\2\u04f9\u04fa\7\u009e\2\2\u04fa\u04fb\5\u0108"+
		"\u0085\2\u04fb\u04fc\7\u009f\2\2\u04fc\u0604\3\2\2\2\u04fd\u04fe\7\36"+
		"\2\2\u04fe\u04ff\7\u009e\2\2\u04ff\u0500\5\u0108\u0085\2\u0500\u0501\7"+
		"\u009f\2\2\u0501\u0604\3\2\2\2\u0502\u0503\7\37\2\2\u0503\u0504\7\u009e"+
		"\2\2\u0504\u0505\5\u0108\u0085\2\u0505\u0506\7\u00aa\2\2\u0506\u0507\5"+
		"\u0108\u0085\2\u0507\u0508\7\u009f\2\2\u0508\u0604\3\2\2\2\u0509\u050a"+
		"\7 \2\2\u050a\u050b\7\u009e\2\2\u050b\u050c\5\u0108\u0085\2\u050c\u050d"+
		"\7\u009f\2\2\u050d\u0604\3\2\2\2\u050e\u050f\7!\2\2\u050f\u0510\7\u009e"+
		"\2\2\u0510\u0511\5\u00fe\u0080\2\u0511\u0512\7\u009f\2\2\u0512\u0604\3"+
		"\2\2\2\u0513\u0514\7D\2\2\u0514\u0515\7\u009e\2\2\u0515\u0516\5\u0108"+
		"\u0085\2\u0516\u0517\7\u009f\2\2\u0517\u0604\3\2\2\2\u0518\u0519\7E\2"+
		"\2\u0519\u051a\7\u009e\2\2\u051a\u051b\5\u0108\u0085\2\u051b\u051c\7\u009f"+
		"\2\2\u051c\u0604\3\2\2\2\u051d\u051e\7F\2\2\u051e\u0520\7\u009e\2\2\u051f"+
		"\u0521\5\u0108\u0085\2\u0520\u051f\3\2\2\2\u0520\u0521\3\2\2\2\u0521\u0522"+
		"\3\2\2\2\u0522\u0604\7\u009f\2\2\u0523\u0524\7G\2\2\u0524\u0525\7\u009e"+
		"\2\2\u0525\u0604\7\u009f\2\2\u0526\u0527\7H\2\2\u0527\u0528\7\u009e\2"+
		"\2\u0528\u0529\5\u0108\u0085\2\u0529\u052a\7\u009f\2\2\u052a\u0604\3\2"+
		"\2\2\u052b\u052c\7I\2\2\u052c\u052d\7\u009e\2\2\u052d\u052e\5\u0108\u0085"+
		"\2\u052e\u052f\7\u009f\2\2\u052f\u0604\3\2\2\2\u0530\u0531\7J\2\2\u0531"+
		"\u0532\7\u009e\2\2\u0532\u0533\5\u0108\u0085\2\u0533\u0534\7\u009f\2\2"+
		"\u0534\u0604\3\2\2\2\u0535\u0536\7K\2\2\u0536\u0537\7\u009e\2\2\u0537"+
		"\u0538\5\u0108\u0085\2\u0538\u0539\7\u009f\2\2\u0539\u0604\3\2\2\2\u053a"+
		"\u053b\7L\2\2\u053b\u053d\7\u009e\2\2\u053c\u053e\5\u00b4[\2\u053d\u053c"+
		"\3\2\2\2\u053d\u053e\3\2\2\2\u053e\u053f\3\2\2\2\u053f\u0604\7\u009f\2"+
		"\2\u0540\u0604\5\u0114\u008b\2\u0541\u0542\7M\2\2\u0542\u0543\7\u009e"+
		"\2\2\u0543\u0544\5\u0108\u0085\2\u0544\u0545\7\u009f\2\2\u0545\u0604\3"+
		"\2\2\2\u0546\u0604\5\u0116\u008c\2\u0547\u0548\7N\2\2\u0548\u0549\7\u009e"+
		"\2\2\u0549\u054a\5\u0108\u0085\2\u054a\u054b\7\u009f\2\2\u054b\u0604\3"+
		"\2\2\2\u054c\u054d\7O\2\2\u054d\u054e\7\u009e\2\2\u054e\u054f\5\u0108"+
		"\u0085\2\u054f\u0550\7\u009f\2\2\u0550\u0604\3\2\2\2\u0551\u0552\7P\2"+
		"\2\u0552\u0553\7\u009e\2\2\u0553\u0554\5\u0108\u0085\2\u0554\u0555\7\u009f"+
		"\2\2\u0555\u0604\3\2\2\2\u0556\u0557\7Q\2\2\u0557\u0558\7\u009e\2\2\u0558"+
		"\u0559\5\u0108\u0085\2\u0559\u055a\7\u00aa\2\2\u055a\u055b\5\u0108\u0085"+
		"\2\u055b\u055c\7\u009f\2\2\u055c\u0604\3\2\2\2\u055d\u055e\7R\2\2\u055e"+
		"\u055f\7\u009e\2\2\u055f\u0560\5\u0108\u0085\2\u0560\u0561\7\u00aa\2\2"+
		"\u0561\u0562\5\u0108\u0085\2\u0562\u0563\7\u009f\2\2\u0563\u0604\3\2\2"+
		"\2\u0564\u0565\7S\2\2\u0565\u0566\7\u009e\2\2\u0566\u0567\5\u0108\u0085"+
		"\2\u0567\u0568\7\u00aa\2\2\u0568\u0569\5\u0108\u0085\2\u0569\u056a\7\u009f"+
		"\2\2\u056a\u0604\3\2\2\2\u056b\u056c\7T\2\2\u056c\u056d\7\u009e\2\2\u056d"+
		"\u056e\5\u0108\u0085\2\u056e\u056f\7\u00aa\2\2\u056f\u0570\5\u0108\u0085"+
		"\2\u0570\u0571\7\u009f\2\2\u0571\u0604\3\2\2\2\u0572\u0573\7U\2\2\u0573"+
		"\u0574\7\u009e\2\2\u0574\u0575\5\u0108\u0085\2\u0575\u0576\7\u00aa\2\2"+
		"\u0576\u0577\5\u0108\u0085\2\u0577\u0578\7\u009f\2\2\u0578\u0604\3\2\2"+
		"\2\u0579\u057a\7W\2\2\u057a\u057b\7\u009e\2\2\u057b\u057c\5\u0108\u0085"+
		"\2\u057c\u057d\7\u009f\2\2\u057d\u0604\3\2\2\2\u057e\u057f\7X\2\2\u057f"+
		"\u0580\7\u009e\2\2\u0580\u0581\5\u0108\u0085\2\u0581\u0582\7\u009f\2\2"+
		"\u0582\u0604\3\2\2\2\u0583\u0584\7Y\2\2\u0584\u0585\7\u009e\2\2\u0585"+
		"\u0586\5\u0108\u0085\2\u0586\u0587\7\u009f\2\2\u0587\u0604\3\2\2\2\u0588"+
		"\u0589\7Z\2\2\u0589\u058a\7\u009e\2\2\u058a\u058b\5\u0108\u0085\2\u058b"+
		"\u058c\7\u009f\2\2\u058c\u0604\3\2\2\2\u058d\u058e\7[\2\2\u058e\u058f"+
		"\7\u009e\2\2\u058f\u0590\5\u0108\u0085\2\u0590\u0591\7\u009f\2\2\u0591"+
		"\u0604\3\2\2\2\u0592\u0593\7\\\2\2\u0593\u0594\7\u009e\2\2\u0594\u0595"+
		"\5\u0108\u0085\2\u0595\u0596\7\u009f\2\2\u0596\u0604\3\2\2\2\u0597\u0598"+
		"\7]\2\2\u0598\u0599\7\u009e\2\2\u0599\u059a\5\u0108\u0085\2\u059a\u059b"+
		"\7\u009f\2\2\u059b\u0604\3\2\2\2\u059c\u059d\7^\2\2\u059d\u059e\7\u009e"+
		"\2\2\u059e\u059f\5\u0108\u0085\2\u059f\u05a0\7\u009f\2\2\u05a0\u0604\3"+
		"\2\2\2\u05a1\u05a2\7_\2\2\u05a2\u05a3\7\u009e\2\2\u05a3\u0604\7\u009f"+
		"\2\2\u05a4\u05a5\7`\2\2\u05a5\u05a6\7\u009e\2\2\u05a6\u0604\7\u009f\2"+
		"\2\u05a7\u05a8\7a\2\2\u05a8\u05a9\7\u009e\2\2\u05a9\u0604\7\u009f\2\2"+
		"\u05aa\u05ab\7b\2\2\u05ab\u05ac\7\u009e\2\2\u05ac\u05ad\5\u0108\u0085"+
		"\2\u05ad\u05ae\7\u009f\2\2\u05ae\u0604\3\2\2\2\u05af\u05b0\7c\2\2\u05b0"+
		"\u05b1\7\u009e\2\2\u05b1\u05b2\5\u0108\u0085\2\u05b2\u05b3\7\u009f\2\2"+
		"\u05b3\u0604\3\2\2\2\u05b4\u05b5\7d\2\2\u05b5\u05b6\7\u009e\2\2\u05b6"+
		"\u05b7\5\u0108\u0085\2\u05b7\u05b8\7\u009f\2\2\u05b8\u0604\3\2\2\2\u05b9"+
		"\u05ba\7e\2\2\u05ba\u05bb\7\u009e\2\2\u05bb\u05bc\5\u0108\u0085\2\u05bc"+
		"\u05bd\7\u009f\2\2\u05bd\u0604\3\2\2\2\u05be\u05bf\7f\2\2\u05bf\u05c0"+
		"\7\u009e\2\2\u05c0\u05c1\5\u0108\u0085\2\u05c1\u05c2\7\u009f\2\2\u05c2"+
		"\u0604\3\2\2\2\u05c3\u05c4\7g\2\2\u05c4\u05c6\7\u009e\2\2\u05c5\u05c7"+
		"\5\u00b4[\2\u05c6\u05c5\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c8\3\2\2"+
		"\2\u05c8\u0604\7\u009f\2\2\u05c9\u05ca\7h\2\2\u05ca\u05cb\7\u009e\2\2"+
		"\u05cb\u05cc\5\u0108\u0085\2\u05cc\u05cd\7\u00aa\2\2\u05cd\u05ce\5\u0108"+
		"\u0085\2\u05ce\u05cf\7\u00aa\2\2\u05cf\u05d0\5\u0108\u0085\2\u05d0\u05d1"+
		"\7\u009f\2\2\u05d1\u0604\3\2\2\2\u05d2\u05d3\7i\2\2\u05d3\u05d4\7\u009e"+
		"\2\2\u05d4\u05d5\5\u0108\u0085\2\u05d5\u05d6\7\u00aa\2\2\u05d6\u05d7\5"+
		"\u0108\u0085\2\u05d7\u05d8\7\u009f\2\2\u05d8\u0604\3\2\2\2\u05d9\u05da"+
		"\7j\2\2\u05da\u05db\7\u009e\2\2\u05db\u05dc\5\u0108\u0085\2\u05dc\u05dd"+
		"\7\u00aa\2\2\u05dd\u05de\5\u0108\u0085\2\u05de\u05df\7\u009f\2\2\u05df"+
		"\u0604\3\2\2\2\u05e0\u05e1\7\"\2\2\u05e1\u05e2\7\u009e\2\2\u05e2\u05e3"+
		"\5\u0108\u0085\2\u05e3\u05e4\7\u00aa\2\2\u05e4\u05e5\5\u0108\u0085\2\u05e5"+
		"\u05e6\7\u009f\2\2\u05e6\u0604\3\2\2\2\u05e7\u05e8\7#\2\2\u05e8\u05e9"+
		"\7\u009e\2\2\u05e9\u05ea\5\u0108\u0085\2\u05ea\u05eb\7\u009f\2\2\u05eb"+
		"\u0604\3\2\2\2\u05ec\u05ed\7$\2\2\u05ed\u05ee\7\u009e\2\2\u05ee\u05ef"+
		"\5\u0108\u0085\2\u05ef\u05f0\7\u009f\2\2\u05f0\u0604\3\2\2\2\u05f1\u05f2"+
		"\7%\2\2\u05f2\u05f3\7\u009e\2\2\u05f3\u05f4\5\u0108\u0085\2\u05f4\u05f5"+
		"\7\u009f\2\2\u05f5\u0604\3\2\2\2\u05f6\u05f7\7&\2\2\u05f7\u05f8\7\u009e"+
		"\2\2\u05f8\u05f9\5\u0108\u0085\2\u05f9\u05fa\7\u009f\2\2\u05fa\u0604\3"+
		"\2\2\2\u05fb\u05fc\7k\2\2\u05fc\u05fd\7\u009e\2\2\u05fd\u05fe\5\u0108"+
		"\u0085\2\u05fe\u05ff\7\u009f\2\2\u05ff\u0604\3\2\2\2\u0600\u0604\5\u0112"+
		"\u008a\2\u0601\u0604\5\u0118\u008d\2\u0602\u0604\5\u011a\u008e\2\u0603"+
		"\u04f7\3\2\2\2\u0603\u04f8\3\2\2\2\u0603\u04fd\3\2\2\2\u0603\u0502\3\2"+
		"\2\2\u0603\u0509\3\2\2\2\u0603\u050e\3\2\2\2\u0603\u0513\3\2\2\2\u0603"+
		"\u0518\3\2\2\2\u0603\u051d\3\2\2\2\u0603\u0523\3\2\2\2\u0603\u0526\3\2"+
		"\2\2\u0603\u052b\3\2\2\2\u0603\u0530\3\2\2\2\u0603\u0535\3\2\2\2\u0603"+
		"\u053a\3\2\2\2\u0603\u0540\3\2\2\2\u0603\u0541\3\2\2\2\u0603\u0546\3\2"+
		"\2\2\u0603\u0547\3\2\2\2\u0603\u054c\3\2\2\2\u0603\u0551\3\2\2\2\u0603"+
		"\u0556\3\2\2\2\u0603\u055d\3\2\2\2\u0603\u0564\3\2\2\2\u0603\u056b\3\2"+
		"\2\2\u0603\u0572\3\2\2\2\u0603\u0579\3\2\2\2\u0603\u057e\3\2\2\2\u0603"+
		"\u0583\3\2\2\2\u0603\u0588\3\2\2\2\u0603\u058d\3\2\2\2\u0603\u0592\3\2"+
		"\2\2\u0603\u0597\3\2\2\2\u0603\u059c\3\2\2\2\u0603\u05a1\3\2\2\2\u0603"+
		"\u05a4\3\2\2\2\u0603\u05a7\3\2\2\2\u0603\u05aa\3\2\2\2\u0603\u05af\3\2"+
		"\2\2\u0603\u05b4\3\2\2\2\u0603\u05b9\3\2\2\2\u0603\u05be\3\2\2\2\u0603"+
		"\u05c3\3\2\2\2\u0603\u05c9\3\2\2\2\u0603\u05d2\3\2\2\2\u0603\u05d9\3\2"+
		"\2\2\u0603\u05e0\3\2\2\2\u0603\u05e7\3\2\2\2\u0603\u05ec\3\2\2\2\u0603"+
		"\u05f1\3\2\2\2\u0603\u05f6\3\2\2\2\u0603\u05fb\3\2\2\2\u0603\u0600\3\2"+
		"\2\2\u0603\u0601\3\2\2\2\u0603\u0602\3\2\2\2\u0604\u0111\3\2\2\2\u0605"+
		"\u0606\7\'\2\2\u0606\u0607\7\u009e\2\2\u0607\u0608\5\u0108\u0085\2\u0608"+
		"\u0609\7\u00aa\2\2\u0609\u060c\5\u0108\u0085\2\u060a\u060b\7\u00aa\2\2"+
		"\u060b\u060d\5\u0108\u0085\2\u060c\u060a\3\2\2\2\u060c\u060d\3\2\2\2\u060d"+
		"\u060e\3\2\2\2\u060e\u060f\7\u009f\2\2\u060f\u0113\3\2\2\2\u0610\u0611"+
		"\7(\2\2\u0611\u0612\7\u009e\2\2\u0612\u0613\5\u0108\u0085\2\u0613\u0614"+
		"\7\u00aa\2\2\u0614\u0617\5\u0108\u0085\2\u0615\u0616\7\u00aa\2\2\u0616"+
		"\u0618\5\u0108\u0085\2\u0617\u0615\3\2\2\2\u0617\u0618\3\2\2\2\u0618\u0619"+
		"\3\2\2\2\u0619\u061a\7\u009f\2\2\u061a\u0115\3\2\2\2\u061b\u061c\7V\2"+
		"\2\u061c\u061d\7\u009e\2\2\u061d\u061e\5\u0108\u0085\2\u061e\u061f\7\u00aa"+
		"\2\2\u061f\u0620\5\u0108\u0085\2\u0620\u0621\7\u00aa\2\2\u0621\u0624\5"+
		"\u0108\u0085\2\u0622\u0623\7\u00aa\2\2\u0623\u0625\5\u0108\u0085\2\u0624"+
		"\u0622\3\2\2\2\u0624\u0625\3\2\2\2\u0625\u0626\3\2\2\2\u0626\u0627\7\u009f"+
		"\2\2\u0627\u0117\3\2\2\2\u0628\u0629\7{\2\2\u0629\u062a\5\u008aF\2\u062a"+
		"\u0119\3\2\2\2\u062b\u062c\7w\2\2\u062c\u062d\7{\2\2\u062d\u062e\5\u008a"+
		"F\2\u062e\u011b\3\2\2\2\u062f\u0630\7l\2\2\u0630\u0632\7\u009e\2\2\u0631"+
		"\u0633\7\b\2\2\u0632\u0631\3\2\2\2\u0632\u0633\3\2\2\2\u0633\u0636\3\2"+
		"\2\2\u0634\u0637\7\u00a8\2\2\u0635\u0637\5\u0108\u0085\2\u0636\u0634\3"+
		"\2\2\2\u0636\u0635\3\2\2\2\u0637\u0638\3\2\2\2\u0638\u0670\7\u009f\2\2"+
		"\u0639\u063a\7m\2\2\u063a\u063c\7\u009e\2\2\u063b\u063d\7\b\2\2\u063c"+
		"\u063b\3\2\2\2\u063c\u063d\3\2\2\2\u063d\u063e\3\2\2\2\u063e\u063f\5\u0108"+
		"\u0085\2\u063f\u0640\7\u009f\2\2\u0640\u0670\3\2\2\2\u0641\u0642\7n\2"+
		"\2\u0642\u0644\7\u009e\2\2\u0643\u0645\7\b\2\2\u0644\u0643\3\2\2\2\u0644"+
		"\u0645\3\2\2\2\u0645\u0646\3\2\2\2\u0646\u0647\5\u0108\u0085\2\u0647\u0648"+
		"\7\u009f\2\2\u0648\u0670\3\2\2\2\u0649\u064a\7o\2\2\u064a\u064c\7\u009e"+
		"\2\2\u064b\u064d\7\b\2\2\u064c\u064b\3\2\2\2\u064c\u064d\3\2\2\2\u064d"+
		"\u064e\3\2\2\2\u064e\u064f\5\u0108\u0085\2\u064f\u0650\7\u009f\2\2\u0650"+
		"\u0670\3\2\2\2\u0651\u0652\7p\2\2\u0652\u0654\7\u009e\2\2\u0653\u0655"+
		"\7\b\2\2\u0654\u0653\3\2\2\2\u0654\u0655\3\2\2\2\u0655\u0656\3\2\2\2\u0656"+
		"\u0657\5\u0108\u0085\2\u0657\u0658\7\u009f\2\2\u0658\u0670\3\2\2\2\u0659"+
		"\u065a\7u\2\2\u065a\u065c\7\u009e\2\2\u065b\u065d\7\b\2\2\u065c\u065b"+
		"\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u065f\5\u0108\u0085"+
		"\2\u065f\u0660\7\u009f\2\2\u0660\u0670\3\2\2\2\u0661\u0662\7v\2\2\u0662"+
		"\u0664\7\u009e\2\2\u0663\u0665\7\b\2\2\u0664\u0663\3\2\2\2\u0664\u0665"+
		"\3\2\2\2\u0665\u0666\3\2\2\2\u0666\u066b\5\u0108\u0085\2\u0667\u0668\7"+
		"\u00a4\2\2\u0668\u0669\7|\2\2\u0669\u066a\7\u00ad\2\2\u066a\u066c\5\u012c"+
		"\u0097\2\u066b\u0667\3\2\2\2\u066b\u066c\3\2\2\2\u066c\u066d\3\2\2\2\u066d"+
		"\u066e\7\u009f\2\2\u066e\u0670\3\2\2\2\u066f\u062f\3\2\2\2\u066f\u0639"+
		"\3\2\2\2\u066f\u0641\3\2\2\2\u066f\u0649\3\2\2\2\u066f\u0651\3\2\2\2\u066f"+
		"\u0659\3\2\2\2\u066f\u0661\3\2\2\2\u0670\u011d\3\2\2\2\u0671\u0673\5\u012e"+
		"\u0098\2\u0672\u0674\5\u00b2Z\2\u0673\u0672\3\2\2\2\u0673\u0674\3\2\2"+
		"\2\u0674\u011f\3\2\2\2\u0675\u0679\5\u012c\u0097\2\u0676\u067a\7\u0088"+
		"\2\2\u0677\u0678\7\u0097\2\2\u0678\u067a\5\u012e\u0098\2\u0679\u0676\3"+
		"\2\2\2\u0679\u0677\3\2\2\2\u0679\u067a\3\2\2\2\u067a\u0121\3\2\2\2\u067b"+
		"\u067f\5\u0124\u0093\2\u067c\u067f\5\u0126\u0094\2\u067d\u067f\5\u0128"+
		"\u0095\2\u067e\u067b\3\2\2\2\u067e\u067c\3\2\2\2\u067e\u067d\3\2\2\2\u067f"+
		"\u0123\3\2\2\2\u0680\u0681\t\13\2\2\u0681\u0125\3\2\2\2\u0682\u0683\t"+
		"\f\2\2\u0683\u0127\3\2\2\2\u0684\u0685\t\r\2\2\u0685\u0129\3\2\2\2\u0686"+
		"\u0687\t\16\2\2\u0687\u012b\3\2\2\2\u0688\u0689\t\17\2\2\u0689\u012d\3"+
		"\2\2\2\u068a\u068d\7\u0081\2\2\u068b\u068d\5\u0130\u0099\2\u068c\u068a"+
		"\3\2\2\2\u068c\u068b\3\2\2\2\u068d\u012f\3\2\2\2\u068e\u068f\t\20\2\2"+
		"\u068f\u0131\3\2\2\2\u0690\u0693\7\u0084\2\2\u0691\u0693\5\u0134\u009b"+
		"\2\u0692\u0690\3\2\2\2\u0692\u0691\3\2\2\2\u0693\u0133\3\2\2\2\u0694\u0695"+
		"\7\u00a2\2\2\u0695\u0696\7\u00a3\2\2\u0696\u0135\3\2\2\2\u0697\u0698\7"+
		"\4\2\2\u0698\u0137\3\2\2\2\u009f\u013b\u0142\u0148\u0153\u0159\u015f\u016c"+
		"\u0171\u0174\u017d\u0184\u018d\u0193\u0197\u019d\u01a0\u01a5\u01a9\u01b1"+
		"\u01bc\u01cc\u01e2\u01e9\u01f8\u01fe\u0205\u0210\u0215\u0217\u022c\u0232"+
		"\u0235\u0238\u023b\u0242\u024a\u024f\u0255\u025e\u0267\u026b\u026f\u0271"+
		"\u027b\u0285\u028a\u028c\u0299\u029d\u02a2\u02a6\u02ac\u02b2\u02b8\u02c0"+
		"\u02c8\u02dc\u02e0\u02e3\u02e8\u02f6\u02fc\u02ff\u0308\u0313\u0318\u031d"+
		"\u0320\u0326\u032d\u0331\u0337\u033c\u0341\u0346\u0349\u034e\u0352\u035d"+
		"\u0368\u0379\u0380\u0389\u0391\u039a\u03a4\u03ae\u03ba\u03c1\u03c5\u03ce"+
		"\u03d3\u03da\u03de\u03e7\u03ea\u03f2\u03f6\u03fb\u0402\u040d\u0410\u0414"+
		"\u0419\u041d\u0422\u042f\u043b\u0443\u0448\u044b\u0459\u0462\u0465\u0468"+
		"\u046b\u046f\u0475\u047d\u0487\u048f\u0495\u0499\u049d\u04a1\u04af\u04bc"+
		"\u04cb\u04d0\u04d9\u04db\u04e0\u04e4\u04e7\u04f5\u0520\u053d\u05c6\u0603"+
		"\u060c\u0617\u0624\u0632\u0636\u063c\u0644\u064c\u0654\u065c\u0664\u066b"+
		"\u066f\u0673\u0679\u067e\u068c\u0692";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}