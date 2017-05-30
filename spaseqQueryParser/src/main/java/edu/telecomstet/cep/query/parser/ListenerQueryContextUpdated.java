/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.query.parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;

import org.antlr.v4.runtime.misc.NotNull;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.knowledgebase.KBRule;
import edu.telecomstet.cep.knowledgebase.KBbindings;
import edu.telecomstet.cep.model.Filter;
import edu.telecomstet.cep.model.ObjectS;
import edu.telecomstet.cep.model.Predicate;
import edu.telecomstet.cep.model.Subject;
import edu.telecomstet.cep.query.sources.StreamingSparql;
import edu.telecomstet.cep.query.sources.StreamingSparql.Var3Context;
import edu.telecomstet.cep.query.sources.StreamingSparqlBaseListener;
import edu.telecomstet.cep.rulesmodel.Dependability;
import edu.telecomstet.cep.rulesmodel.KBDependability;
import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.PatternData;
import edu.telecomstet.cep.rulesmodel.Rule;
import edu.telecomstet.cep.rulesmodel.StreamData;
import edu.telecomstet.cep.rulesmodel.WindowTemporalData;
import edu.telecomstet.cep.statefull.StateDependability;

/**
 *
 * @author sydgillani
 */
public class ListenerQueryContextUpdated extends StreamingSparqlBaseListener {

	private List<StreamData> _streamData;
	private List<PatternData> _pattData;
	private List<PatternData> _unionpattData;
	private KBbindings bind;
	private int stateCounter;
	private ArrayList<Filter> filterList;
	private Multimap<String, String> prefixes;
	private List<NFAData> _nfaDataList;
	private int order;
	private int tp_global_order;
	private int kbStateCount = 0;
	private int onlyOnce = 0;
	private int constructBlockID = 0;
	private int stateid = 0;
	// ArrayList<ArrayList<NFAdata>> LLNFA_=new ArrayList<ArrayList<NFAdata>>();
	private int nfaorder = 0;
	private ArrayList<KBbindings> _bindList;

	private List<String> selectvars;
	private DictionaryOpImpl dictImplOp;

	// StateMachineData state;
	private boolean optional;
	private boolean graph;
	private ArrayList<Rule> _ruleList;
	private ArrayList<Rule> _constRules;
	private ArrayList<KBRule> _kbRuleList;

	public ArrayList<KBRule> getKbRuleList() {
		return _kbRuleList;
	}

	private Rule rule;
	private KBRule kbRule;
	/**************************************/
	// Lists to check the Dependabilty Rules

	private List<String> _sublist;
	private List<String> _objList;
	private List<String> _predList;
	private List<String> _kbSubList;
	private List<String> _kbObjList;
	private List<Dependability> _dependList;
	private NFAData nfaData;
	private String graphName;
	private int stateType = 0;
	private int stateDependentID = 0;
	private WindowTemporalData _windData;
	private String patternBy;

	private boolean construct = false;

	public ListenerQueryContextUpdated(DictionaryOpImpl dict)
			throws ParseException, DatatypeConfigurationException {
		_streamData = new ArrayList<>();
		_pattData = new ArrayList<>();
		_unionpattData = new ArrayList<>();

		prefixes = ArrayListMultimap.create();
		// _states = new ArrayList<>();

		this._nfaDataList = new ArrayList<>();
		stateCounter = 0;
		kbStateCount = 0;
		order = 0;
		this.tp_global_order = 0;

		// /Add the new object over here
		dictImplOp = dict;

	}

	@Override
	public void enterSelectClause(
			@NotNull StreamingSparql.SelectClauseContext ctx) {

		// System.out.println(ctx.getText());
		String select = ctx.getText();
		selectvars = Arrays.asList(select.split("\\?"));

		// get the whole text and then remove the select from the string, then
		// put it in an array by, start from 1
	}

	@Override
	public void enterConstructClause(
			@NotNull StreamingSparql.ConstructClauseContext ctx) {

		_constRules = new ArrayList<>();
		construct = true;

	}

	@Override
	public void exitConstructClause(
			@NotNull StreamingSparql.ConstructClauseContext ctx) {

		// TODO: add the construct rules to the NFA of rules, but which?? NFA,
		// this.
		construct = false;
	}

	@Override
	public void enterWithin(@NotNull StreamingSparql.WithinContext ctx) {
		_windData = new WindowTemporalData(Integer.parseInt(ctx.time()
				.getText()), ctx.unitTime().getText());
		// System.out.println(ctx.time().getText());
		// System.out.println(ctx.unitTime().getText());
	}

	@Override
	public void enterPartitionbyClause(
			@NotNull StreamingSparql.PartitionbyClauseContext ctx) {
		// System.out.println(ctx.pattern().var(0).getText());
		patternBy = ctx.partition().var(0).getText().replace("?", "");
		// /remove the the question mark
		// /then put it in the pattern element and in the end get all the
		// predicates for such

	}

	@Override
	public void enterStreamsetCaluse(
			@NotNull StreamingSparql.StreamsetCaluseContext ctx) { // /TO get
																	// the
																	// Streams
																	// ID,
																	// URIS's ,
																	// Time and
																	// Time
																	// Units
		StreamData streamdata = new StreamData();
		streamdata.setStreamID(ctx.var3().getText());
		streamdata.setStreamURI(ctx.iri().getText(), this.dictImplOp);

		// streamdata.setTime(ctx.window().time().getText());
		// streamdata.setTimeUni(ctx.window().unitTime().getText());

		// System.out.println(ctx.window().unitTime().getText());
		this._streamData.add(streamdata);

	}

	// TODO: check the pattern name properly

	@Override
	public void enterEventPattern(
			@NotNull StreamingSparql.EventPatternContext ctx) { // /to get the
																// Seqnece of
																// patterns and
																// operations on
																// them
																// SEQ(A,B!,C)

		PatternData pattdata = new PatternData(stateid);
		PatternData unionpattdata;

		if (ctx.var3().size() == 1) {
			pattdata.setPattName(ctx.var3().get(0).getText());
			if (ctx.patternOperation() != null) {

				pattdata.setPattType(ctx.patternOperation().getText());

			}
			this.stateid++;
			this._pattData.add(pattdata);

		} else {
			unionpattdata = new PatternData(stateid);

			// unionpattdata.setPattName(ctx.var3().get(0).getText());
			// unionpattdata.setPattName2(ctx.var3().get(1).getText());

			for (Var3Context names : ctx.var3()) {

				unionpattdata.getPattNameList().add(names.getText());
			}

			// TODO: change over here to enable both Union and OR in a same
			// block, for GRAMMAR.

			if (ctx.eventJoiner().get(0).getText().equals("|")) {
				unionpattdata.setUinonOr(2); // /For OR
			} else if (ctx.eventJoiner().get(0).getText().equals("&")) {
				unionpattdata.setUinonOr(1); // / AND
			}
			if (ctx.patternOperation() != null) {
				unionpattdata.setPattType(ctx.patternOperation().getText());
			}
			this.stateid++;
			this._unionpattData.add(unionpattdata);

		}

		// / System.out.println(ctx.var3().getText());

		// System.out.println(ctx.patternOperation());

	}

	@Override
	public void enterEventSelection(
			@NotNull StreamingSparql.EventSelectionContext ctx) {

		this._pattData.get(_pattData.size() - 1)
				.setPattSelection(ctx.getText());

	}

	// //////////////////////////////////////////////////////////////////////////////

	@Override
	public void enterPattBlock(@NotNull StreamingSparql.PattBlockContext ctx) {
		try {
			// /when enter the BGP pattern
			_sublist = new ArrayList<>();
			_objList = new ArrayList<>();
			_predList = new ArrayList<>();
			_kbObjList = new ArrayList<>();
			_kbSubList = new ArrayList<>();
			_ruleList = new ArrayList<>();

			_kbRuleList = new ArrayList<>();

			bind = new KBbindings();
		} catch (ParseException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (DatatypeConfigurationException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		_bindList = new ArrayList<>();
		filterList = new ArrayList<>();
		optional = false;
		graph = false;
		stateCounter = 0;
		kbStateCount = 0;
		this.nfaData = new NFAData();

		this.onlyOnce++;

		// /TODO: how to optimise it
		// if(onlyOnce ==1){
		this.nfaData.setWindowData(_windData);
		if (onlyOnce == 1 && this._constRules != null) {
			this.nfaData.set_constructClaue(this._constRules);
		}

		for (int i = 0; i < this._streamData.size(); i++) {

			if (this._streamData.get(i).getStreamID()
					.equals(ctx.eventDefinition().multipleVars().getText())) {
				// this.nfaData.setEventType(this._streamData.get(i).getStreamURI());

				this.nfaData.getStreamList().add(this._streamData.get(i));

			}
		}

		// //////
		this.nfaData.setOrder(this.nfaorder);
		this.nfaData.setStateType(ctx.eventDefinition().var3().getText());
		this.nfaorder++;

		// /////

		// for(int i=0;i<this._pattData.size();i++){ ///Remove this for loop
		//
		// // String tt= ctx.eventDefinition().var3().getText();
		//
		// if(this._pattData.get(i).getPattName().equals(
		// ctx.eventDefinition().var3().getText())){
		// //this.nfaData.
		//
		// this.nfaData.setOrder(this.nfaorder);
		// this.nfaData.setStateType( ctx.eventDefinition().var3().getText());
		// this.nfaData.setPatterndata(this._pattData.get(i));
		// this.nfaorder++;
		// }
		// }

		/**
		 * Over here check the And OR typed patterns and add it to the NFAdata
		 * as well
		 * 
		 */

	}

	@Override
	public void enterGraphGraphPattern(
			@NotNull StreamingSparql.GraphGraphPatternContext ctx) {

		// System.out.println(ctx.getText());
		this.graph = true;

		this.graphName = ctx.varOrIRI().getText();

	}

	@Override
	public void exitGraphGraphPattern(
			@NotNull StreamingSparql.GraphGraphPatternContext ctx) {

		// System.out.println(ctx.getText());
		this.graph = false;
		this.kbStateCount = 0;

		// kbManipulation();
	}

	private void kbManipulation(KBbindings kb) {
		// for(KBbindings kb:this._bindList){
		// /For s-s join
		KBbindings dsKb = this._bindList
				.stream()
				.filter(x -> x.getSub().getProjection()
						.equals(kb.getSub().getProjection())
						&& x.getStateID() != kb.getStateID())
				.reduce((p, c) -> c).orElse(null);

		if (dsKb != null) {
			kb.getDepends().setDependability_On(1);
			kb.getDepends().setDependability_part(1);
			kb.getDepends().setDependabilty_id(dsKb.getStateID());
		} else {

			// /for s-o join
			KBbindings doKb = this._bindList
					.stream()
					.filter(x -> x.getObj().getProjection()
							.equals(kb.getSub().getProjection())
							&& x.getStateID() != kb.getStateID())
					.reduce((p, c) -> c).orElse(null);

			if (doKb != null) {
				kb.getDepends().setDependability_On(0);
				kb.getDepends().setDependability_part(1);
				kb.getDepends().setDependabilty_id(doKb.getStateID());
			} else {

				Rule r = this._ruleList
						.stream()
						.filter(x -> x.getSubject().getProjection()
								.equals(kb.getSub().getProjection()))
						.reduce((p, c) -> c).orElse(null);

				if (r != null) {
					kb.setStateFull_flag(1);
					kb.getStateDepends().setD_On(1);
					kb.getStateDepends().setD_part(1);
					kb.getStateDepends().setD_id(r.getId());
				} else {
					Rule r2 = this._ruleList
							.stream()
							.filter(x -> x.getObject().getProjection()
									.equals(kb.getSub().getProjection()))
							.reduce((p, c) -> c).orElse(null);

					if (r2 != null) {
						kb.setStateFull_flag(1);
						kb.getStateDepends().setD_On(1);
						kb.getStateDepends().setD_part(1);
						kb.getStateDepends().setD_id(r2.getId());
					}
				}
			}
			// }

		}

	}

	@Override
	public void enterOptionalGraphPattern(
			@NotNull StreamingSparql.OptionalGraphPatternContext ctx) {
		this.optional = true;
	}

	@Override
	public void exitObjectListPath(
			@NotNull StreamingSparql.ObjectListPathContext ctx) {

		// this.LLNFA_.add(this.LNFA_);
		if (!this.graph && !construct) {
			// this.state.setStateId(stateCounter);
			// this._states.add(this.state);
			this.rule.setDepends(_dependList);
			// this.rule.setId(stateCounter);

			this.checkSelectionVariables();
			this._ruleList.add(this.rule);

			/*
			 * System.out.println("###########");
			 * System.out.println("Rule ID:"+this.rule.getId());
			 * for(Dependability dd:this.rule.getDepends()){
			 * 
			 * System.out.println(dd.getDependability_On()+" "+
			 * dd.getDependability_part()+" "+ dd.getDependabilty_id()); }
			 * System.out.println("###########");
			 */
			this.stateCounter++;
		} else if (graph && !construct) {

			/*
			 * Predicate graphURI; try { graphURI = new Predicate();
			 * graphURI.setValue(graphName, dictImplOp);
			 * this.bind.setGraphURI(graphURI); } catch (ParseException ex) {
			 * Logger
			 * .getLogger(ListenerQueryContext.class.getName()).log(Level.SEVERE
			 * , null, ex); } catch (DatatypeConfigurationException ex) {
			 * Logger.
			 * getLogger(ListenerQueryContext.class.getName()).log(Level.SEVERE,
			 * null, ex); } kbManipulation(this.bind); _bindList.add(this.bind);
			 */
			kbStateCount++;
			this.kbRule.setDepends(_dependList);
			this._kbRuleList.add(kbRule);
			checkSelectionVarsforKB();

		} else if (!graph && construct) {

			this._constRules.add(this.rule);

		}
	}

	/**
	 * Record the list of Prefixes in the Query
	 * 
	 * @param ctx
	 */
	@Override
	public void enterPrefixDecl(@NotNull StreamingSparql.PrefixDeclContext ctx) {
		this.prefixes.put(ctx.PNAME_NS().getText().replace(":", ""), ctx
				.IRIREF().getText().replace(">", ""));
	}

	/**
	 * Record the object Values...Literals..URI and Projection Variables
	 * 
	 * @param ctx
	 */
	@Override
	public void enterObjectListPath(
			@NotNull StreamingSparql.ObjectListPathContext ctx) {

		// this.nfaData=new NFAdata();
		ObjectS object = null;
		// boolean projection=false;
		try {
			object = new ObjectS();
		} catch (ParseException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (DatatypeConfigurationException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		String prefixCombinedValue = "";

		if (ctx.objectPath(0).graphNodePath().varOrTerm().getChild(0)
				.getChild(0).getChildCount() > 0) // /there is a graph term
		{

			if (ctx.getText().contains(":")) {
				String str[] = ctx.getText().split(":");

				prefixCombinedValue = this.prefixes.get(str[0]).iterator()
						.next().toString()
						+ str[1] + ">";
			} else {
				prefixCombinedValue = ctx.getText();
			}

			/*
			 * if
			 * (ctx.objectPath(0).graphNodePath().varOrTerm().graphTerm().getStart
			 * ().getType() != 118) { prefixCombinedValue = ctx.getText(); }
			 * else if
			 * (ctx.objectPath(0).graphNodePath().varOrTerm().graphTerm()
			 * .iri().IRIREF() == null) { String str[] =
			 * ctx.getText().split(":");
			 * 
			 * prefixCombinedValue =
			 * this.prefixes.get(str[0]).iterator().next().toString() + str[1] +
			 * ">"; }
			 */

			if (!graph) {

				// this.nfaData.setEdgePredicate(prefixCombinedValue); ///data
				object.setValue(prefixCombinedValue, dictImplOp);

				object.setIsProjection(false);

			} else {
				object.setValue(prefixCombinedValue, dictImplOp);
				object.setIsProjection(false);
				// this.bind.setObject(prefixCombinedValue);
				this.bind.setObj(object);
			}

			// this.nfaData.setEdgeType("begin");
			// this.nfaData.setIsFirst(false);
			// this.nfaData.setIslast(true);
			// this.nfaData.setStateId(1);
			// this.nfaData.setStateName("Object");
		} else {
			if (!graph) {
				object.setProjection(ctx.getText().replace("?", ""));
				object.setIsProjection(true);
				// projection =true;
			} else {
				object.setProjection(ctx.getText().replace("?", ""));
				object.setIsProjection(true);
				// this.bind.setObjectPtojection(ctx.getText().replace("?",
				// ""));
				// this.bind.setObj(object);
			}

			// this.nfaData.setProjections(ctx.getText().replace("?", ""));
			// this.nfaData.setEdgeType("begin");
			// this.nfaData.setIsFirst(false);
			// this.nfaData.setIslast(true);
			// this.nfaData.setStateId(1);
			// this.nfaData.setStateName("Object");
		}

		if (!this.graph && !construct) {
			// state.setObject(object);

			if (!object.isProjection()) { // simple add the subject to the rule
				this.rule.setObject(object);
				// this._objList.add(object.getProjection());

			} else if (object.isProjection()
					&& this._sublist.contains(object.getProjection())
					&& this._objList.contains(object.getProjection())) {

				Dependability depend = new Dependability();
				String sd = object.getProjection();
				int id1 = this._ruleList.stream()
						.filter(x -> x.getSubject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId();
				int id2 = this._ruleList
						.stream()
						.filter(x -> x.getObject().getProjection() != null
								&& x.getObject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId();

				if (id2 > id1) {
					depend.setDependability_On(0);
					depend.setDependability_part(0);
					depend.setDependabilty_id(id2);

				} else {
					depend.setDependability_On(0);
					depend.setDependability_part(1);
					depend.setDependabilty_id(id1);

					Rule r = this._ruleList
							.stream()
							.filter(x -> x.getSubject().getProjection()
									.equals(sd)).reduce((p, c) -> c)
							.orElse(null);
					if (r != null && r.getDepends().isEmpty()) {
						Dependability dependR2 = new Dependability();
						dependR2.setDependability_On(1);
						dependR2.setDependability_part(1);
						dependR2.setDependabilty_id(r.getId());
						r.getDepends().add(dependR2);
					}

				}
				this._dependList.add(depend);
				this.rule.setObject(object);
				this.rule.setDependabilty_flag(true);
				this.rule.setQueryType(2);
				this._objList.add(object.getProjection());
			} else if (object.isProjection()
					&& this._sublist.contains(object.getProjection())) { // /if
																			// depdndabilty
																			// is
																			// on
																			// Subject
				Dependability depend = new Dependability();

				depend.setDependability_On(0);
				depend.setDependability_part(1);
				String sd = object.getProjection();

				depend.setDependabilty_id(this._ruleList.stream()
						.filter(x -> x.getSubject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId());

				this._dependList.add(depend);
				this.rule.setObject(object);
				this.rule.setQueryType(1);
				this.rule.setDependabilty_flag(true);
				this._objList.add(object.getProjection());

				// ///////add to the other rule as well

				// ////////////////////////

			}

			else if (object.isProjection()
					&& this._objList.contains(object.getProjection())) { // /if
																			// depdndabilty
																			// is
																			// on
																			// Subject
				Dependability depend = new Dependability();

				depend.setDependability_On(0);
				depend.setDependability_part(0);
				String sd = object.getProjection();
				// int id=
				// this._ruleList.stream().filter(x->x.getSubject().getProjection().equals(sd)).reduce((p,c)->c).orElse(null).getId();

				depend.setDependabilty_id(this._ruleList
						.stream()
						.filter(x -> x.getObject().getProjection() != null
								&& x.getObject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId());
				// depend.setDependabilty_id(this._sublist.indexOf(object.getProjection()));
				this._dependList.add(depend);
				this.rule.setObject(object);
				this.rule.setQueryType(3); // /o-o join
				this.rule.setDependabilty_flag(true);
				this._objList.add(object.getProjection());

				// ///////add to the other rule as well

				// ////////////////////////

			}

			else if (object.isProjection()
					&& (!this._objList.contains(object.getProjection()))) { // /may
																			// be
																			// useless
																			// I
																			// think...
				this.rule.setObject(object);
				this._objList.add(object.getProjection());
			}

			if (this._constRules != null) {
				this.constSubCheck();
				this.constObjCheck();
			}
		} else if (graph && !construct) {
			// //use the KB binding stuff over here
			this.addKBGraphObject(object);
		} else if (!graph && construct) {
			// TODO: add the object for the construct clause
			this.rule.setObject(object);
		}
		stateFulObjectAssignments(this.rule);
		// this.LNFA_.add(this.nfaData);
	}

	private void addKBGraphObject(ObjectS object) {

		if (!object.isProjection()) { // simple add the subject to the rule
			this.kbRule.setObject(object);
			// this._objList.add(object.getProjection());

		} else if (object.isProjection()
				&& this._kbSubList.contains(object.getProjection())
				&& this._kbObjList.contains(object.getProjection())) {

			Dependability depend = new Dependability();
			String sd = object.getProjection();

			int id1 = _kbRuleList.stream()
					.filter(x -> x.getSubject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId();
			int id2 = _kbRuleList
					.stream()
					.filter(x -> x.getObject().getProjection() != null
							&& x.getObject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId();

			if (id2 > id1) {
				depend.setDependability_On(0);
				depend.setDependability_part(0);
				depend.setDependabilty_id(id2);
				depend.setBlockID(4000);

			} else {
				depend.setDependability_On(0);
				depend.setDependability_part(1);
				depend.setDependabilty_id(id1);
				depend.setBlockID(4000);

				KBRule r = this._kbRuleList.stream()
						.filter(x -> x.getSubject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null);
				if (r != null && r.getDepends().isEmpty()) {
					Dependability dependR2 = new Dependability();
					dependR2.setDependability_On(1);
					dependR2.setDependability_part(1);
					dependR2.setBlockID(4000);
					dependR2.setDependabilty_id(this.kbRule.getId());
					r.getDepends().add(dependR2);
				}

			}
			this._dependList.add(depend);
			this.kbRule.setObject(object);
			this.kbRule.setDependabilty_flag(true);
			// this.kbRule.setQueryType(2);
			this._kbObjList.add(object.getProjection());
		} else if (object.isProjection()
				&& this._kbSubList.contains(object.getProjection())) { // /if
																		// depdndabilty
																		// is on
																		// Subject
			Dependability depend = new Dependability();

			depend.setDependability_On(0);
			depend.setDependability_part(1);
			depend.setBlockID(4000);
			String sd = object.getProjection();
			// int id=
			// this._ruleList.stream().filter(x->x.getSubject().getProjection().equals(sd)).reduce((p,c)->c).orElse(null).getId();

			depend.setDependabilty_id(this._kbRuleList.stream()
					.filter(x -> x.getSubject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId());
			// depend.setDependabilty_id(this._sublist.indexOf(object.getProjection()));
			this._dependList.add(depend);
			this.kbRule.setObject(object);
			// this.kbRule.setQueryType(1);
			this.kbRule.setDependabilty_flag(true);
			this._kbObjList.add(object.getProjection());

			// ///////add to the other rule as well

			// ////////////////////////

		}

		else if (object.isProjection()
				&& this._kbObjList.contains(object.getProjection())) { // /if
																		// depdndabilty
																		// is on
																		// Subject
			Dependability depend = new Dependability();

			depend.setDependability_On(0);
			depend.setDependability_part(0);
			depend.setBlockID(4000);
			String sd = object.getProjection();
			// int id=
			// this._ruleList.stream().filter(x->x.getSubject().getProjection().equals(sd)).reduce((p,c)->c).orElse(null).getId();

			depend.setDependabilty_id(this._kbRuleList
					.stream()
					.filter(x -> x.getObject().getProjection() != null
							&& x.getObject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId());
			// depend.setDependabilty_id(this._sublist.indexOf(object.getProjection()));
			this._dependList.add(depend);
			this.kbRule.setObject(object);
			// this.kbRule.setQueryType(3); ///o-o join
			this.kbRule.setDependabilty_flag(true);
			this._kbObjList.add(object.getProjection());

			// ///////add to the other rule as well

			// ////////////////////////

		}

		else if (object.isProjection()
				&& (!this._kbObjList.contains(object.getProjection()))) { // /may
																			// be
																			// useless
																			// I
																			// think...
			this.kbRule.setObject(object);
			this._kbObjList.add(object.getProjection());
		}

		kbfirstLevelStatefulObject(object);

	}

	// TODO: Change the dependability stuff in the KBjoin predicate stuff

	private void addKBGraphSubject(Subject subject) {
		if (!subject.isProjection()) { // simple add the subject to the rule
			this.kbRule.setSubject(subject);
			// this._sublist.add(subject.getProjection());

		} else if (subject.isProjection()
				&& this._kbSubList.contains(subject.getProjection())
				&& this._kbObjList.contains(subject.getProjection())) {

			Dependability depend = new Dependability();
			String sd = subject.getProjection();

			int id1 = this._kbRuleList.stream()
					.filter(x -> x.getSubject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId();
			int id2 = this._kbRuleList
					.stream()
					.filter(x -> x.getObject().getProjection() != null
							&& x.getObject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId();

			if (id1 > id2) {
				depend.setDependability_On(1);
				depend.setDependability_part(1);
				depend.setDependabilty_id(id1);
				depend.setBlockID(4000);

				// /////////////

				KBRule r = this._kbRuleList.stream()
						.filter(x -> x.getSubject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null);
				if (r != null && r.getDepends().isEmpty()) {
					Dependability dependR2 = new Dependability();
					dependR2.setDependability_On(1);
					dependR2.setDependability_part(1);
					dependR2.setDependabilty_id(r.getId());
					depend.setBlockID(4000);
					r.getDepends().add(dependR2);
				}
				// ///////////

			} else {
				depend.setDependability_On(1);
				depend.setDependability_part(0);
				depend.setDependabilty_id(id2);
				depend.setBlockID(4000);

			}
			this._dependList.add(depend); // /what is happening over here
			this.kbRule.setSubject(subject);
			this.kbRule.setDependabilty_flag(true);
			// this.kbRule.setQueryType(2);
			this._kbSubList.add(subject.getProjection());

		} else if (subject.isProjection()
				&& this._kbSubList.contains(subject.getProjection())) {
			Dependability depend = new Dependability();

			depend.setDependability_On(1);
			depend.setDependability_part(1);
			// depend.setDependabilty_id(this._sublist.indexOf(subject.getProjection()));
			// ///change over here
			depend.setBlockID(4000);
			String sd = subject.getProjection();
			// int id=
			// this._ruleList.stream().filter(x->x.getSubject().getProjection().equals(sd)).reduce((p,c)->c).orElse(null).getId();

			depend.setDependabilty_id(this._kbRuleList.stream()
					.filter(x -> x.getSubject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId());
			this._dependList.add(depend);
			this.kbRule.setSubject(subject);
			this.kbRule.setDependabilty_flag(true);
			// / this.kbRule.setQueryType(2); //1 for chain, 2 for star and 3
			// for joiner

			KBRule r = this._kbRuleList.stream()
					.filter(x -> x.getSubject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null);
			if (r != null && r.getDepends().isEmpty()) {
				Dependability dependR2 = new Dependability();
				dependR2.setDependability_On(1);
				dependR2.setDependability_part(1);
				dependR2.setBlockID(4000);
				dependR2.setDependabilty_id(r.getId());
				r.getDepends().add(dependR2);
			}

			this._kbSubList.add(subject.getProjection());
		} else if (subject.isProjection()
				&& this._kbObjList.contains(subject.getProjection())) {
			Dependability depend = new Dependability();
			depend.setDependability_On(1);
			depend.setDependability_part(0);
			depend.setBlockID(4000);

			String sd = subject.getProjection();
			// int id=
			// this._ruleList.stream().filter(x->x.getSubject().getProjection().equals(sd)).reduce((p,c)->c).orElse(null).getId();

			depend.setDependabilty_id(this._kbRuleList
					.stream()
					.filter(x -> x.getObject().getProjection() != null
							&& x.getObject().getProjection().equals(sd))
					.reduce((p, c) -> c).orElse(null).getId());

			// depend.setDependabilty_id(this._objList.indexOf(subject.getProjection()));
			this._dependList.add(depend);
			this.kbRule.setSubject(subject);
			this.kbRule.setDependabilty_flag(true);
			// this.kbRule.setQueryType(1); //1 for chain, 2 for start and 3 for
			// joiner
			this._kbSubList.add(subject.getProjection());
			// ///

		} else if (subject.isProjection() || this._kbSubList.isEmpty()
				&& (!this._kbSubList.contains(subject.getProjection()))) {
			this.kbRule.setSubject(subject);
			this._kbSubList.add(subject.getProjection());
		}

		this.kbfirstLevelStatefulSubject(subject);

	}

	/**
	 * Record the Subjects ...URI and Projection Variables
	 * 
	 * @param ctx
	 */
	@Override
	public void enterTriplesSameSubjectPath(
			@NotNull StreamingSparql.TriplesSameSubjectPathContext ctx) {

		// System.out.println(ctx.getText());
		String prefixCombinedValue = "";
		// / boolean projection=false;
		// state = new StateMachineData();

		_dependList = new ArrayList<>();
		try {
			this.rule = new Rule();

			this.tp_global_order++;
			this.rule.setId(stateCounter); // /localID of the triple patter////
			this.rule.setGloabl_Id(this.tp_global_order); // /global ID of the
															// triple pattern
															// for stateful
															// queries///

		} catch (ParseException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (DatatypeConfigurationException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		// this.nfaData=new NFAdata();
		// this.LNFA_=new ArrayList<NFAdata>();

		if (graph) {
			try {
				this.kbRule = new KBRule();
			} catch (ParseException ex) {
				Logger.getLogger(ListenerQueryContextUpdated.class.getName())
						.log(Level.SEVERE, null, ex);
			} catch (DatatypeConfigurationException ex) {
				Logger.getLogger(ListenerQueryContextUpdated.class.getName())
						.log(Level.SEVERE, null, ex);
			}
			this.kbRule.setId(this.kbStateCount);

		}
		Subject subject = null;

		try {
			subject = new Subject();
		} catch (ParseException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (DatatypeConfigurationException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		// System.out.println(ctx.varOrTerm().getChild(0).getChild(0).getChildCount());
		if (ctx.varOrTerm().getChild(0).getChild(0).getChildCount() > 0) // /there
																			// is
																			// a
																			// graph
																			// term
		{
			if (ctx.varOrTerm().graphTerm().iri().IRIREF() == null) {
				String str[] = ctx.varOrTerm().getText().split(":");

				prefixCombinedValue = this.prefixes.get(str[0]).iterator()
						.next().toString()
						+ str[1] + ">";
			} else {
				prefixCombinedValue = ctx.varOrTerm().graphTerm().getText();
			}

			// ///if graph is true then put it in the binding
			if (!this.graph) {

				// this.nfaData.setEdgePredicate(prefixCombinedValue); ///data
				// over here
				// subject=new Subject(prefixCombinedValue);
				subject.setValue(prefixCombinedValue, dictImplOp);
				subject.setIsProjection(false);
				// projection=false;

			} else {
				try {
					subject.setValue(prefixCombinedValue, dictImplOp);
					subject.setIsProjection(false);
					this.bind = new KBbindings();
					// this.bind.setSubject(prefixCombinedValue); ///may be add
					// the dictionary over here as well, when there are tow
					// different dictionaries
					this.bind.setSub(subject);
					this.kbStateCount++;
					this.bind.setStateID(this.kbStateCount);
					Predicate graphURI = new Predicate();
					graphURI.setValue(graphName, dictImplOp);
					this.bind.setGraphURI(graphURI);
				}
				// this.nfaData.setEdgeType("begin");
				// this.nfaData.setIsFirst(true);
				// this.nfaData.setIslast(false);
				// this.nfaData.setStateId(1);
				// this.nfaData.setStateName("Subject");
				catch (ParseException ex) {
					Logger.getLogger(ListenerQueryContext.class.getName()).log(
							Level.SEVERE, null, ex);
				} catch (DatatypeConfigurationException ex) {
					Logger.getLogger(ListenerQueryContext.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		} else {
			if (!this.graph) {
				subject.setProjection(ctx.varOrTerm().getText()
						.replace("?", ""));
				subject.setIsProjection(true);
				subject.setProjectionMapped(
						ctx.varOrTerm().getText().replace("?", ""), dictImplOp); // /no
																					// pint
																					// of
																					// mapping
																					// projection
				// projection =true;
				// ////////////Add the Subject and check the list if its there
				// or not, if its there then add the dependability stuff/////

			} else {
				subject.setProjection(ctx.varOrTerm().getText()
						.replace("?", ""));
				subject.setIsProjection(true);
				subject.setProjectionMapped(
						ctx.varOrTerm().getText().replace("?", ""), dictImplOp);
				/*
				 * try { this.bind = new KBbindings(); } catch (ParseException
				 * ex) {
				 * Logger.getLogger(ListenerQueryContext.class.getName()).log
				 * (Level.SEVERE, null, ex); } catch
				 * (DatatypeConfigurationException ex) {
				 * Logger.getLogger(ListenerQueryContext
				 * .class.getName()).log(Level.SEVERE, null, ex); }
				 * this.bind.setSubjectProjection
				 * (ctx.varOrTerm().getText().replace("?", ""));
				 * this.kbStateCount++; this.bind.setStateID(
				 * this.kbStateCount); this.bind.setSub(subject); } }
				 */
			}
		}

		if (!this.graph && !construct) { // /dependability check for subject
			// state.setSubject(subject);

			if (!subject.isProjection()) { // simple add the subject to the rule
				this.rule.setSubject(subject);
				// this._sublist.add(subject.getProjection());

			} else if (subject.isProjection()
					&& this._sublist.contains(subject.getProjection())
					&& this._objList.contains(subject.getProjection())) {

				Dependability depend = new Dependability();
				String sd = subject.getProjection();

				int id1 = this._ruleList.stream()
						.filter(x -> x.getSubject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId();
				int id2 = this._ruleList
						.stream()
						.filter(x -> x.getObject().getProjection() != null
								&& x.getObject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId();

				if (id1 > id2) {
					depend.setDependability_On(1);
					depend.setDependability_part(1);
					depend.setDependabilty_id(id1);

					// /////////////

					Rule r = this._ruleList
							.stream()
							.filter(x -> x.getSubject().getProjection()
									.equals(sd)).reduce((p, c) -> c)
							.orElse(null);
					if (r != null && r.getDepends().isEmpty()) {
						Dependability dependR2 = new Dependability();
						dependR2.setDependability_On(1);
						dependR2.setDependability_part(1);
						dependR2.setDependabilty_id(this.rule.getId());
						r.getDepends().add(dependR2);
					}
					// ///////////

				} else {
					depend.setDependability_On(1);
					depend.setDependability_part(0);
					depend.setDependabilty_id(id2);

					// /////////////

					/*
					 * Rule r=
					 * this._ruleList.stream().filter(x->x.getObject().getProjection
					 * ().equals(sd)).reduce((p,c)->c).orElse(null); if(r!=null
					 * && r.getDepends().isEmpty()){ Dependability dependR2=new
					 * Dependability(); dependR2.setDependability_On(0);
					 * dependR2.setDependability_part(1);
					 * dependR2.setDependabilty_id(this.rule.getId());
					 * r.getDepends().add(dependR2); }
					 */
					// ///////////

				}
				this._dependList.add(depend);
				this.rule.setSubject(subject);
				this.rule.setDependabilty_flag(true);
				this.rule.setQueryType(2);
				this._sublist.add(subject.getProjection());

			} else if (subject.isProjection()
					&& this._sublist.contains(subject.getProjection())) {
				Dependability depend = new Dependability();

				depend.setDependability_On(1);
				depend.setDependability_part(1);

				String sd = subject.getProjection();

				depend.setDependabilty_id(this._ruleList.stream()
						.filter(x -> x.getSubject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId());
				this._dependList.add(depend);
				this.rule.setSubject(subject);
				this.rule.setDependabilty_flag(true);
				this.rule.setQueryType(2); // 1 for chain, 2 for star and 3 for
											// joiner

				Rule r = this._ruleList.stream()
						.filter(x -> x.getSubject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null);
				if (r != null && r.getDepends().isEmpty()) {
					Dependability dependR2 = new Dependability();
					dependR2.setDependability_On(1);
					dependR2.setDependability_part(1);
					dependR2.setDependabilty_id(this.rule.getId());
					r.getDepends().add(dependR2);
				}

				this._sublist.add(subject.getProjection());

			} else if (subject.isProjection()
					&& this._objList.contains(subject.getProjection())) {
				Dependability depend = new Dependability();
				depend.setDependability_On(1);
				depend.setDependability_part(0);

				String sd = subject.getProjection();

				depend.setDependabilty_id(this._ruleList
						.stream()
						.filter(x -> x.getObject().getProjection() != null
								&& x.getObject().getProjection().equals(sd))
						.reduce((p, c) -> c).orElse(null).getId());

				this._dependList.add(depend);
				this.rule.setSubject(subject);
				this.rule.setDependabilty_flag(true);
				this.rule.setQueryType(1); // 1 for chain, 2 for start and 3 for
											// joiner
				this._sublist.add(subject.getProjection());
				// ///

			}

			else if (subject.isProjection() || this._sublist.isEmpty()
					&& (!this._sublist.contains(subject.getProjection()))) {
				this.rule.setSubject(subject);
				this._sublist.add(subject.getProjection());
			}
			if (this._constRules != null) {
				// constSubCheck();
			}
		} else if (graph) {
			this.addKBGraphSubject(subject);
		} else if (!graph && construct) {
			// TODO: add the constructs subjects in the rule.
			this.rule.setSubject(subject);

		}

		this.stateFulSubjecAssignments(rule);

		// is.LNFA_.add(this.nfaData);
	}

	// Function to match the construct variables and the new subject/object
	// variables to determine the connection between
	// them
	// TODO: for predicates as well
	private void constObjCheck() {
		if (this.rule.getObject().getProjection() != null) {

			List<Rule> constRules = this._constRules
					.stream()
					.filter(x -> x.getObject().getProjection() != null
							&& x.getObject()
									.getProjection()
									.equals(this.rule.getObject()
											.getProjection()))
					.collect(Collectors.toList());

			for (Rule r : constRules) {
				if (r.getDepends() == null) {
					r.setDepends(new ArrayList<>());
				}
				if (r.getDepends().stream()
						.filter(x -> x.getDependability_On() == 0).count() < 1)

				{
					Dependability dd = new Dependability();
					dd.setDependability_On(0);
					dd.setDependability_part(0);
					dd.setdPredicate(this.rule.getPredicate().getMappedValue());
					dd.setDependabilty_id(this.rule.getId());
					dd.setBlockID(this.constructBlockID);
					r.getDepends().add(dd);
				}
			}
			constRules = this._constRules
					.stream()
					.filter(x -> x.getSubject().getProjection() != null
							&& x.getSubject()
									.getProjection()
									.equals(this.rule.getObject()
											.getProjection()))
					.collect(Collectors.toList());

			for (Rule r : constRules) {
				if (r.getDepends() == null) {
					r.setDepends(new ArrayList<>());
				}
				if (r.getDepends().stream()
						.filter(x -> x.getDependability_On() == 0).count() < 1)

				{
					Dependability dd = new Dependability();
					dd.setDependability_On(1);
					dd.setDependability_part(0);
					dd.setDependabilty_id(this.rule.getId());
					dd.setdPredicate(this.rule.getPredicate().getMappedValue());
					dd.setBlockID(this.constructBlockID);
					r.getDepends().add(dd);
				}
			}

		}
	}

	private void constSubCheck() {
		if (this.rule.getSubject().getProjection() != null) {
			List<Rule> constRules = this._constRules
					.stream()
					.filter(x -> x.getObject().getProjection() != null
							&& x.getObject()
									.getProjection()
									.equals(this.rule.getSubject()
											.getProjection()))
					.collect(Collectors.toList());

			for (Rule r : constRules) {
				if (r.getDepends() == null) {
					r.setDepends(new ArrayList<>());
				}
				if (r.getDepends().stream()
						.filter(x -> x.getDependability_On() == 0).count() < 1)

				{
					Dependability dd = new Dependability();
					dd.setDependability_On(0);
					dd.setDependability_part(1);
					dd.setDependabilty_id(this.rule.getId());
					dd.setdPredicate(this.rule.getPredicate().getMappedValue());
					dd.setBlockID(this.constructBlockID);
					r.getDepends().add(dd);
				}
			}

			constRules = this._constRules
					.stream()
					.filter(x -> x.getSubject().getProjection() != null
							&& x.getSubject()
									.getProjection()
									.equals(this.rule.getSubject()
											.getProjection()))
					.collect(Collectors.toList());

			for (Rule r : constRules) {
				if (r.getDepends() == null) {
					r.setDepends(new ArrayList<>());

				}
				if (r.getDepends().stream()
						.filter(x -> x.getDependability_On() == 1).count() < 1)

				{
					Dependability dd = new Dependability();
					dd.setDependability_On(1);
					dd.setDependability_part(1);
					dd.setDependabilty_id(this.rule.getId());
					dd.setdPredicate(this.rule.getPredicate().getMappedValue());
					dd.setBlockID(this.constructBlockID);
					r.getDepends().add(dd);
				}
			}

		}
	}

	/**
	 * Record Predicates...Only Projection Variables
	 * 
	 * @param ctx
	 */
	@Override
	public void enterVerbSimple(@NotNull StreamingSparql.VerbSimpleContext ctx) {
		Predicate predicate = null;
		try {
			predicate = new Predicate();
		} catch (ParseException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (DatatypeConfigurationException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		System.out.println(ctx.getText());
		// this.nfaData=new NFAdata();
		if (!this.graph) {

			predicate.setProjection(ctx.getText().replace("?", ""));
			predicate.setIsProjection(true);
			// this.state.setPredicate(predicate);

			if (this._predList.isEmpty()
					&& (!this._predList.contains(predicate.getProjection()))) {
				this.rule.setPredicate(predicate);

				this._predList.add(predicate.getProjection());
			} else if (this._predList.contains(predicate.getProjection())) {
				Dependability depend = new Dependability();

				depend.setDependability_On(2);
				depend.setDependability_part(2);
				depend.setDependabilty_id(this._predList.indexOf(predicate
						.getProjection()));
				this._dependList.add(depend);
				this.rule.setDependabilty_flag(true);
				this.rule.setPredicate(predicate);
				this._predList.add(predicate.getProjection());

			} else {

				predicate.setProjection(ctx.getText().replace("?", ""));
				predicate.setIsProjection(true);
				// this.bind.setPredicateProjection(ctx.getText().replace("?",
				// ""));
				this.bind.setPred(predicate);
			}

		} else {
			// TODO: Change the predicte for the graph and construct clause

			this.rule.setPredicate(predicate);
		}
	}

	/**
	 * Record Predicates...Only URIs
	 * 
	 * @param ctx
	 */
	@Override
	public void enterVerbPath(@NotNull StreamingSparql.VerbPathContext ctx) {

		// this.nfaData=new NFAdata();
		String prefixCombinedValue = "";
		Predicate predicate = null;

		try {
			predicate = new Predicate();
		} catch (ParseException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (DatatypeConfigurationException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		if (ctx.path().pathAlternative().pathSequence(0).pathEltOrInverse(0)
				.pathElt().pathPrimary().iri().IRIREF() == null) {

			// /search for the prefixes in the miltumap and then assign the
			// variable
			String str[] = ctx.getText().split(":");

			prefixCombinedValue = this.prefixes.get(str[0]).iterator().next()
					.toString()
					+ str[1] + ">";
		} else {
			prefixCombinedValue = ctx.getText();
		}

		if (!this.graph && !construct) {
			predicate.setValue(prefixCombinedValue, dictImplOp);
			predicate.setIsProjection(false);
			// this.state.setPredicate(predicate);
			this.rule.setPredicate(predicate);

			// this.nfaData.setEdgePredicate( prefixCombinedValue);
		} else if (graph && !construct) {
			predicate.setValue(prefixCombinedValue, dictImplOp);
			predicate.setIsProjection(false);
			// this.bind.setPredicate(prefixCombinedValue);
			this.kbRule.setPredicate(predicate);
			// this.bind.setPred(predicate);
		} else if (!graph && construct) {
			// TODO: Add the predicate for the construct clause
			predicate.setValue(prefixCombinedValue, dictImplOp);
			predicate.setIsProjection(false);
			this.rule.setPredicate(predicate);
		}

	}

	// Means it enters the Filter expression
	@Override
	public void enterRelationalExpression(
			@NotNull StreamingSparql.RelationalExpressionContext ctx) {

		// System.out.println(ctx.getText());
		Filter filterVars = new Filter(this.dictImplOp);

		// System.out.println(ctx.expression(1).getText());
		// System.out.println( ctx.op.getText());
		filterVars.setIsFilter(true);
		filterVars.setFilterProjection(ctx.expression(0).getText()
				.replace("?", "")); // /ther could be URI at this palce

		// ///check for the rule list and put the filter over here/////

		// /////////////////////////////////////////////////////////

		try {

			if (ctx.expression(1).getText().startsWith("?")) {
				filterVars.setFilterRightProjection(ctx.expression(1).getText()
						.replace("?", ""));
				filterVars.setFilterType(2);
				// filterVars.setIsfilterKB(true); ///could not be a KB filter,
				// this shoudl get true only if variable matches the KB,
				// otherwise it should not be
			} else {
				filterVars.setFilterValue(ctx.expression(1).getText());
				filterVars.setIsfilterKB(false);
				filterVars.setFilterType(1);
			}

		} catch (ParseException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (DatatypeConfigurationException ex) {
			Logger.getLogger(ListenerQueryContext.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		filterVars.setFilterOperand(ctx.op.getText());

		// //////
		filterList.add(filterVars);

		// ///////////////////////////
		for (Rule rule : this._ruleList) {
			// /if single filter of type 1 with constant at the right
			// operand....Push the filter contanst as an object to the rule

			if (rule.getObject().getProjection() != null) {
				if (rule.getObject().getProjection()
						.equals(filterVars.getFilterProjection())
						&& 1 == filterVars.getFilterType()) { // in case of
																// object
																// projection in
																// the filter

					ObjectS obj = rule.getObject();

					obj.setMappedValue((long) filterVars.getFilterMappedValue());
					obj.setSimpleValue(filterVars.getFilterValue());
					obj.setIsProjection(false); // /should not use it
					obj.setObjectType(filterVars.getFilterDataType());
					rule.setObject(obj);
					rule.setFilterType1Operator(filterVars.getFilterOperand());
					rule.setFilterType(1); // /do you really need it?
					rule.getFilter().add(filterVars); // /may be remove
														// projection

					rule.setFilterFlag(true);
					// rule.setFilterType1Operator(null);
				} else if (rule.getSubject().getProjection()
						.equals(filterVars.getFilterProjection())
						&& 1 == filterVars.getFilterType()) { // /in case of
																// subject
																// projection in
																// the constant
																// filter
					Subject sub = rule.getSubject();
					sub.setMappedValue((long) filterVars.getFilterMappedValue());
					sub.setSimpleValue(filterVars.getFilterValue()); // /dont
																		// really
																		// need
																		// this
					sub.setIsProjection(false);

					rule.setFilterType1Operator(filterVars.getFilterOperand());
					rule.setFilterType(1);
					rule.getFilter().add(filterVars);

					// /if double filter of type 2
				} else if (2 == filterVars.getFilterType()
						&& rule.getObject().getProjection()
								.equals(filterVars.getFilterProjection())) { // If
																				// there
																				// are
																				// two
																				// variables
																				// on
																				// the
																				// both
																				// sides
																				// of
																				// the
																				// filter
																				// operand

					// if(!this.filterObject(filterVars,rule)){///if the result
					// is false then go for statefull object

					filterObject(filterVars, rule);
					filterStatefullObject(filterVars, rule);

					// }

				} else if (2 == filterVars.getFilterType()
						&& rule.getSubject().getProjection()
								.equals(filterVars.getFilterProjection())) {
					filterSubject(filterVars, rule); // /if the result is false
														// then go for statefull
														// subject
					filterStatefullSubject(filterVars, rule);

				}
			}

		}

		// ////////////////////////

	}

	private boolean filterObject(Filter filterVars, Rule rule) {

		boolean checker = false; // /To check if the filter contains any
									// stateless objects or any stateful objects
		// /if checker is true then it means the filter contains some variable
		// either from any above rule or from any KB rule
		// otherwise its a statefull object and it needs to be checked for the
		// upper query variables///

		List<Rule> r = this._ruleList
				.stream()
				.filter(x -> x.getObject().getProjection() != null
						&& x.getObject().getProjection()
								.equals(filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		// //to check the list of subjects/////

		List<Rule> r2 = this._ruleList
				.stream()
				.filter(x -> x.getSubject().getProjection() != null
						&& x.getSubject().getProjection()
								.equals(filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		List<KBbindings> kr = this._bindList
				.stream()
				.filter(x -> x.getObjectPtojection() != null
						&& x.getObjectPtojection().equals(
								filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		List<KBbindings> kr2 = this._bindList
				.stream()
				.filter(x -> x.getSubjectProjection() != null
						&& x.getSubjectProjection().equals(
								filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		if (!r.isEmpty()) {

			checker = true;
			// Dependability depend = new Dependability();

			// depend.setDependability_On(0);
			// depend.setDependability_part(0);
			// depend.setDependabilty_id(r.get(r.size()-1).getId()); ///get the
			// id of dependent one

			// /get the id of the Rule and find it in the list and attach it to
			// it
			// if filter operator is >,<,>=,<= then tell the rule
			/*
			 * if(filterVars.getFilterOperand()==">" ||
			 * filterVars.getFilterOperand()=="<"
			 * ||filterVars.getFilterOperand()==">="
			 * ||filterVars.getFilterOperand()=="<=" ){
			 * 
			 * for(Rule cRule: this._ruleList){ if(cRule.getId() ==
			 * r.get(r.size()-1).getId()){ cRule.setBreaker(true); } }
			 * 
			 * 
			 * }
			 */
			// //For Object right filter List Creation/////

			r.get(r.size() - 1).setBreaker(true);
			// r.get(r.size()-1).setFilterRightFlage(true);
			// r.get(r.size()-1).setFilter(filterVars);
			// r.get(r.size()-1).setFilterType1Operator(filterVars.getFilterOperand());
			// r.get(r.size()-1).setFilterType(2);
			// /////////////////////////

			rule.setDependabilty_flag(true);
			// rule.getDepends().add(depend);
			rule.setFilterType1Operator(filterVars.getFilterOperand());
			rule.setFilterType(2);
			// rule.setFilter(filterVars);
			rule.getFilter().add(filterVars);
			rule.setFilterFlag(true);

			rule.setFilterRuleID(r.get(r.size() - 1).getId());

		} else if (!r2.isEmpty()) {
			// System.out.println(r2.size()-1);
			checker = true;
			Dependability depend = new Dependability();

			depend.setDependability_On(0);
			depend.setDependability_part(1);
			depend.setDependabilty_id(r2.get(r2.size() - 1).getId());
			// List<Dependability> _dependlist= rule.getDepends();
			// _dependlist.add(depend);
			// rule.setDepends(_dependlist);
			rule.setDependabilty_flag(true);
			rule.getDepends().add(depend);

			rule.setFilterType1Operator(filterVars.getFilterOperand());
			rule.setFilterType(2);
			// rule.setFilter(filterVars);
			rule.getFilter().add(filterVars);
			rule.setFilterFlag(true);
		} else if (!kr.isEmpty()) {
			checker = true;
			KBDependability kb = new KBDependability();
			kb.setDependability_On(0);
			kb.setDependability_part(0);
			kb.setDependability_property(kr.get(0).getPred());
			// kb.setMapped_dep_property(kr.get(0).getPred().getMappedValue());
			rule.getKbdepends().add(kb);
			rule.setFilterType1Operator(filterVars.getFilterOperand());
			rule.setFilterType(3);
			// rule.setFilter(filterVars);
			rule.getFilter().add(filterVars);
			rule.setFilterFlag(true);
			// rule.setDependabilty_flag(true);
			rule.setKb_flag(true);
		} else if (!kr2.isEmpty()) {
			checker = true;
			KBDependability kb = new KBDependability();
			kb.setDependability_On(0);
			kb.setDependability_part(1);
			kb.setDependability_property(kr2.get(0).getPred());
			// kb.setMapped_dep_property(kr2.get(0).getPred().getMappedValue());
			rule.getKbdepends().add(kb);
			// rule.setDependabilty_flag(true);
			rule.setKb_flag(true);
			rule.setFilterType1Operator(filterVars.getFilterOperand());
			rule.setFilterType(3);
			// rule.setFilter(filterVars);
			rule.getFilter().add(filterVars);
			rule.setFilterFlag(true);
		}

		// /returns true false over here

		return checker;

	}

	private boolean filterSubject(Filter filterVars, Rule rule) {
		boolean checker = false; // /To check if the filter contains any
									// stateless objects or any stateful objects
		// /if checker is true then it means the filter contains some variable
		// either from any above rule or from any KB rule
		// otherwise its a statefull object and it needs to be checked for the
		// upper query variables///

		List<Rule> r = this._ruleList
				.stream()
				.filter(x -> x.getObject().getProjection()
						.equals(filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		// //to check the list of subjects/////

		List<Rule> r2 = this._ruleList
				.stream()
				.filter(x -> x.getSubject().getProjection()
						.equals(filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		List<KBbindings> kr = this._bindList
				.stream()
				.filter(x -> x.getObjectPtojection().equals(
						filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		List<KBbindings> kr2 = this._bindList
				.stream()
				.filter(x -> x.getSubjectProjection().equals(
						filterVars.getFilterRightProjection()))
				.collect(Collectors.toList());

		if (!r.isEmpty()) {

			checker = true;
			Dependability depend = new Dependability();

			depend.setDependability_On(1);
			depend.setDependability_part(0);
			depend.setDependabilty_id(r.get(r.size() - 1).getId());
			// List<Dependability> _dependlist= rule.getDepends();
			// _dependlist.add(depend);
			// rule.setDepends(_dependlist);
			rule.setDependabilty_flag(true);
			rule.getDepends().add(depend);
		} else if (!r2.isEmpty()) {
			checker = true;

			Dependability depend = new Dependability();

			depend.setDependability_On(1);
			depend.setDependability_part(1);
			depend.setDependabilty_id(r2.get(r2.size() - 1).getId());
			// List<Dependability> _dependlist= rule.getDepends();
			// _dependlist.add(depend);
			// rule.setDepends(_dependlist);
			rule.setDependabilty_flag(true);
			rule.getDepends().add(depend);
		} else if (!kr.isEmpty()) {
			checker = true;
			KBDependability kb = new KBDependability();
			kb.setDependability_On(1);
			kb.setDependability_part(0);
			kb.setDependability_property(kr.get(0).getPred());
			// kb.setMapped_dep_property(kr.get(0).getPred().getMappedValue());
			rule.getKbdepends().add(kb);
			// rule.setDependabilty_flag(true);
			rule.setKb_flag(true);
		} else if (!kr2.isEmpty()) {
			checker = true;
			KBDependability kb = new KBDependability();
			kb.setDependability_On(1);
			kb.setDependability_part(1);
			kb.setDependability_property(kr2.get(0).getPred());
			// kb.setMapped_dep_property(kr2.get(0).getPred().getMappedValue());
			rule.getKbdepends().add(kb);
			// rule.setDependabilty_flag(true);
			rule.setKb_flag(true);
		}
		return checker;
	}

	// /TODO: change the stateful of kb flag false over here

	private void kbfirstLevelStatefulSubject(Subject subject) {
		// /check all the rule in the NFA rule list

		Rule r = this._ruleList
				.stream()
				.filter(x -> x.getSubject().getProjection()
						.equals(subject.getProjection())).findFirst()
				.orElse(null);
		// /add the dependency in the list

		if (r != null) {
			Dependability depend = new Dependability();

			depend.setDependability_On(1);
			depend.setDependability_part(1);
			depend.setBlockID(1000);
			depend.setDependabilty_id(r.getId());
			depend.setStateDependability(true);
			this._dependList.add(depend);
		}

		r = this._ruleList
				.stream()
				.filter(x -> x.getObject().getProjection()
						.equals(subject.getProjection())).findFirst()
				.orElse(null);

		if (r != null) {
			Dependability depend = new Dependability();

			depend.setDependability_On(1);
			depend.setDependability_part(0);
			depend.setBlockID(1000);
			depend.setStateDependability(true);
			depend.setDependabilty_id(r.getId());
			this._dependList.add(depend);
		}

	}

	private void kbfirstLevelStatefulObject(ObjectS object) {
		// /check all the rule in the NFA rule list

		Rule r = this._ruleList
				.stream()
				.filter(x -> x.getSubject().getProjection()
						.equals(object.getProjection())).findFirst()
				.orElse(null);
		// /add the dependency in the list

		if (r != null) {
			Dependability depend = new Dependability();

			depend.setDependability_On(0);
			depend.setDependability_part(1);
			depend.setBlockID(1000);
			depend.setDependabilty_id(r.getId());
			this._dependList.add(depend);
		}

		r = this._ruleList
				.stream()
				.filter(x -> x.getObject().getProjection()
						.equals(object.getProjection())).findFirst()
				.orElse(null);

		if (r != null) {
			Dependability depend = new Dependability();

			depend.setDependability_On(0);
			depend.setDependability_part(0);
			depend.setBlockID(1000);
			depend.setDependabilty_id(r.getId());
			this._dependList.add(depend);
		}

	}

	private void stateFulSubjecAssignments(Rule r) {

		if (r.getSubject().isProjection()) {

			for (int i = 0; i < this._nfaDataList.size(); i++) {

				Rule rule = this._nfaDataList
						.get(i)
						.getRuleList()
						.stream()
						.filter(x -> x.getSubject().isProjection()
								&& x.getSubject().getProjection()
										.equals(r.getSubject().getProjection()))
						.findFirst().orElse(null);
				if (rule != null) {
					StateDependability d = new StateDependability();
					d.setD_On(1);
					d.setD_part(1);
					d.setD_id(rule.getId());
					d.setIdNFA(this._nfaDataList.get(i).getOrder()); // TODO:
																		// change
																		// it
																		// with
																		// correct
																		// ID
					d.setdPredicate(rule.getPredicate().getMappedValue());
					r.setStateFull_flag(1);
					r.getS_depends().add(d);
					break;

				} else {
					Rule rule2 = this._nfaDataList
							.get(i)
							.getRuleList()
							.stream()
							.filter(x -> x.getObject().isProjection()
									&& x.getObject()
											.getProjection()
											.equals(r.getSubject()
													.getProjection()))
							.findFirst().orElse(null);

					if (rule2 != null) {
						StateDependability d = new StateDependability();
						d.setD_On(1);
						d.setD_part(0);
						d.setD_id(rule2.getId());
						d.setIdNFA(this._nfaDataList.get(i).getOrder()); // TODO:
																			// change
																			// it
																			// with
																			// correct
																			// ID
						d.setdPredicate(rule2.getPredicate().getMappedValue());
						r.setStateFull_flag(1);
						r.getS_depends().add(d);
						break;
					}

				}

				// /add the dependability
				// add the ID of the NFA
				// /add the predicate of the dependable rule

			}
		}

	}

	private void stateFulObjectAssignments(Rule r) {

		if (r.getObject().isProjection()) {
			for (int i = 0; i < this._nfaDataList.size(); i++) {

				Rule rule = this._nfaDataList
						.get(i)
						.getRuleList()
						.stream()
						.filter(x -> x.getObject().isProjection()
								&& x.getObject().getProjection()
										.equals(r.getObject().getProjection()))
						.reduce((p, c) -> c).orElse(null);
				if (rule != null) {
					StateDependability d = new StateDependability();
					d.setD_On(0);
					d.setD_part(0);
					d.setD_id(rule.getId());
					d.setIdNFA(this._nfaDataList.get(i).getOrder());// TODO:
																	// change it
																	// with
																	// correct
																	// ID
					d.setdPredicate(rule.getPredicate().getMappedValue());
					r.setStateFull_flag(1);
					r.getS_depends().add(d);
					break;

				} else {
					Rule rule2 = this._nfaDataList
							.get(i)
							.getRuleList()
							.stream()
							.filter(x -> x.getSubject().isProjection()
									&& x.getSubject()
											.getProjection()
											.equals(r.getObject()
													.getProjection()))
							.reduce((p, c) -> c).orElse(null);

					if (rule2 != null) {
						StateDependability d = new StateDependability();
						d.setD_On(0);
						d.setD_part(1);
						d.setD_id(rule2.getId());
						d.setIdNFA(this._nfaDataList.get(i).getOrder());// TODO:
																		// change
																		// it
																		// with
																		// correct
																		// ID
						d.setdPredicate(rule2.getPredicate().getMappedValue());
						r.setStateFull_flag(1);
						r.getS_depends().add(d);
						break;
					}

				}

			}

		}

	}

	private void filterStatefullObject(Filter filterVars, Rule rule) {

		for (int i = 0; i < this._nfaDataList.size(); i++) { // -1

			// /for objects
			Rule r = this._nfaDataList
					.get(i)
					.getRuleList()
					.stream()
					.filter(x -> x.getObject().getProjection()
							.equals(filterVars.getFilterRightProjection()))
					.findFirst().orElse(null); // /if there is no projection
												// then will have some issues

			// this._nfaDataList.get(0).s
			if (r != null) {

				StateDependability d = new StateDependability();
				d.setD_On(0);
				d.setD_part(0);
				d.setD_id(r.getId()); // /????
				d.setIdNFA(this._nfaDataList.get(i).getOrder());
				d.setdPredicate(r.getPredicate().getMappedValue());
				// rule.setStateFull_flag(1);
				// rule.setStateFull_Id(r.get(r.size()-1).getGloabl_Id());
				// ///statefull dependability // useless
				// r.get(r.size()-1).setCacheStateFull(1); //true for top triple
				// pattern , so it can cahce the result
				// r.get(r.size()-1).setStateFull_dType(0);

				filterVars.setD(d);
				filterVars.setStateFulness(1);

				// rule.getS_depends().add(d);
				rule.setFilterType1Operator(filterVars.getFilterOperand());
				rule.setFilterType(2);
				// rule.setFilter(filterVars);
				// rule.getFilter().add(filterVars);
				rule.setFilterFlag(true);
				rule.getFilter().add(filterVars);

			} else {
				List<Rule> r2 = this._nfaDataList
						.get(i)
						.getRuleList()
						.stream()
						.filter(x -> x.getSubject().getProjection()
								.equals(filterVars.getFilterRightProjection()))
						.collect(Collectors.toList());
				// //for subjects

				if (!r2.isEmpty()) {

					if ((rule.getId() > 0 && !rule.getDepends().stream()
							.filter(x -> x.getDependability_On() == 0)
							.collect(Collectors.toList()).isEmpty())) {
						continue;
					}

					StateDependability d = new StateDependability();
					d.setD_On(0);
					d.setD_part(1);
					d.setD_id(r2.get(r2.size() - 1).getGloabl_Id());
					d.setIdNFA(this._nfaDataList.get(i).getOrder());

					rule.setStateFull_flag(1);
					// /
					// rule.setStateFull_Id(r2.get(r2.size()-1).getGloabl_Id());
					// ///statefull dependability // useless
					r2.get(r2.size() - 1).setCacheStateFull(1); // true for top
																// triple
																// pattern , so
																// it can cahce
																// the result
					r2.get(r2.size() - 1).setStateFull_dType(1);

					// Dependability depend=new Dependability();
					// this.stateType=1;
					// depend.setDependability_On(0); ///what about the
					// dependability?, should there be a stateful dependabilty,
					// or not
					// depend.setDependability_part(1);
					// depend.setDependabilty_id(r2.get(r2.size()-1).getId());
					// depend.setStateDependability(true);

					rule.getS_depends().add(d);
					rule.setFilterType1Operator(filterVars.getFilterOperand());
					rule.setFilterType(2);
					// rule.setFilter(filterVars);
					rule.getFilter().add(filterVars);
					rule.setFilterFlag(true);

					// / this._nfaDataList.get(i).setStateType(2); ///do you
					// really need it

				}

			}
			// //to check the list of subjects/////

		}

	}

	private void filterStatefullSubject(Filter filterVars, Rule rule) {

		for (int i = 0; i <= this._nfaDataList.size() - 1; i++) {

			// /for objects
			List<Rule> r = this._nfaDataList
					.get(i)
					.getRuleList()
					.stream()
					.filter(x -> x.getObject().getProjection()
							.equals(filterVars.getFilterRightProjection()))
					.collect(Collectors.toList()); // /if there is no projection
													// then will have some
													// issues

			// this._nfaDataList.get(0).s
			if (!r.isEmpty()) {

				StateDependability d = new StateDependability();
				d.setD_On(1);
				d.setD_part(0);
				d.setD_id(r.get(r.size() - 1).getGloabl_Id());
				d.setIdNFA(this._nfaDataList.get(i).getOrder());
				rule.setStateFull_flag(1);
				// rule.setStateFull_Id(r.get(r.size()-1).getGloabl_Id());
				// ///statefull dependability // useless
				r.get(r.size() - 1).setCacheStateFull(1); // true for top triple
															// pattern , so it
															// can cahce the
															// result

				r.get(r.size() - 1).setStateFull_dType(0);
				rule.getS_depends().add(d);
				rule.setFilterType1Operator(filterVars.getFilterOperand());
				rule.setFilterType(2);
				// rule.setFilter(filterVars);
				rule.getFilter().add(filterVars);
				rule.setFilterFlag(true);

			} else {
				List<Rule> r2 = this._nfaDataList
						.get(i)
						.getRuleList()
						.stream()
						.filter(x -> x.getSubject().getProjection()
								.equals(filterVars.getFilterRightProjection()))
						.collect(Collectors.toList());
				// //for subjects

				if (!r2.isEmpty()) {

					if ((rule.getId() > 0 && !rule.getDepends().stream()
							.filter(x -> x.getDependability_On() == 1)
							.collect(Collectors.toList()).isEmpty())) {
						continue;
					}

					StateDependability d = new StateDependability();
					d.setD_On(1);
					d.setD_part(1);
					d.setD_id(r2.get(r2.size() - 1).getGloabl_Id());
					d.setIdNFA(this._nfaDataList.get(i).getOrder());

					rule.setStateFull_flag(1);
					// /
					// rule.setStateFull_Id(r2.get(r2.size()-1).getGloabl_Id());
					// ///statefull dependability // useless
					r2.get(r2.size() - 1).setCacheStateFull(1); // true for top
																// triple
																// pattern , so
																// it can cahce
																// the result
					r2.get(r2.size() - 1).setStateFull_dType(1);

					rule.getS_depends().add(d);
					rule.setFilterType1Operator(filterVars.getFilterOperand());
					rule.setFilterType(2);
					// rule.setFilter(filterVars);
					rule.getFilter().add(filterVars);
					rule.setFilterFlag(true);
					// / this._nfaDataList.get(i).setStateType(2); ///do you
					// really need it

				}
			}

			// //to check the list of subjects/////

		}

	}

	@Override
	public void exitPattBlock(@NotNull StreamingSparql.PattBlockContext ctx) {
		ruleAndKBbindings();

		this.order++;
		this.nfaData.setRuleList(_ruleList);

		this.nfaData.setKbRuleList2(_kbRuleList);
		// /add the state stype over here as well
		// /then change it to zero again
		// / this.nfaData.setStateType(stateType); //statefull or not/// 1:
		// statefull, 0: stateless
		this.nfaData.setStateDependencyID(stateDependentID);
		// this.nfaData.setOrder(order);
		// this.nfaData.setKbBindingList(_bindList);
		this._nfaDataList.add(this.nfaData);
		this.constructBlockID++;
		this.stateType = 0;
		this.stateDependentID = 0;

		// //Get all the predicates of the subject variables matched to the
		// patternData string
		for (Rule r : this.nfaData.getRuleList()) {
			if (r.getSubject().getProjection().equals(this.patternBy)) {
				this.nfaData.getPatternByData().put(
						r.getPredicate().getMappedValue(), this.patternBy);
			}
		}
		// nfa.se

	}

	private void ruleAndKBbindings() {

		for (KBbindings k : this._bindList) {

			if (k.getSub().isProjection()) {

				for (Rule r : this._ruleList) {
					KBDependability kDependSub = new KBDependability();
					KBDependability kDependObj = new KBDependability();
					if (r.getSubject().isProjection()
							&& r.getSubject().getProjection()
									.equals(k.getSub().getProjection())) {
						// //addd the kb bindings in the rule and set the flag
						// to true

						kDependSub.setDependability_On(1);
						kDependSub.setDependability_part(1);
						kDependSub.setDependability_property(k.getPred());

						r.getKbdepends().add(kDependSub);
						r.setKb_flag(true);

					} else if (r.getObject().isProjection()
							&& r.getObject().getProjection()
									.equals(k.getSub().getProjection())) {
						kDependSub.setDependability_On(0);
						kDependSub.setDependability_part(1);
						kDependSub.setDependability_property(k.getPred());

						r.getKbdepends().add(kDependSub);
						r.setKb_flag(true);
					}

				}

			}

			if (k.getObj().isProjection()) {
				for (Rule r : this._ruleList) {
					KBDependability kDependSub = new KBDependability();
					KBDependability kDependObj = new KBDependability();
					if (r.getSubject().isProjection()
							&& r.getSubject().getProjection()
									.equals(k.getObj().getProjection())) {
						// //addd the kb bindings in the rule and set the flag
						// to true

						kDependSub.setDependability_On(1);
						kDependSub.setDependability_part(0);
						kDependSub.setDependability_property(k.getPred());

						r.getKbdepends().add(kDependSub);
						r.setKb_flag(true);

					} else if (r.getObject().isProjection()
							&& r.getObject().getProjection()
									.equals(k.getObj().getProjection())) {
						kDependSub.setDependability_On(0);
						kDependSub.setDependability_part(0);
						kDependSub.setDependability_property(k.getPred());

						r.getKbdepends().add(kDependSub);
						r.setKb_flag(true);
					}

				}
			}

		}
	}

	public ArrayList<Filter> getFilterList() {
		return filterList;
	}

	public void setFilterList(ArrayList<Filter> filterList) {
		this.filterList = filterList;
	}

	private void checkSelectionVariables() {
		if (this.selectvars != null) {
			for (int i = 1; i < this.selectvars.size(); i++) {
				if (this.rule.getObject().isProjection()
						&& this.rule.getObject().getProjection()
								.equals(selectvars.get(i))) {
					this.rule.setSelect(true);
					this.rule.setSelectObj(true);
				}

				if (this.rule.getSubject().isProjection()
						&& this.rule.getSubject().getProjection()
								.equals(selectvars.get(i))) {
					this.rule.setSelect(true);
					this.rule.setSelectSub(true);
				}

			}
		}

	}

	private void checkSelectionVarsforKB() {
		if (this.selectvars != null) {

			for (int i = 1; i < this.selectvars.size(); i++) {
				if (this.kbRule.getObject().isProjection()
						&& this.kbRule.getObject().getProjection()
								.equals(selectvars.get(i))) {
					this.kbRule.setSelect(true);
					this.kbRule.setSelectObj(true);
				}

				if (this.kbRule.getSubject().isProjection()
						&& this.kbRule.getSubject().getProjection()
								.equals(selectvars.get(i))) {
					this.kbRule.setSelect(true);
					this.kbRule.setSelectSub(true);
				}

			}
		}
	}

	public ArrayList<KBbindings> getBindList() {
		return _bindList;
	}

	public List<NFAData> getNfaDataList() {
		return _nfaDataList;
	}

	public DictionaryOpImpl getDictImpl() {
		return dictImplOp;
	}

	public ArrayList<Rule> get_constRules() {
		return _constRules;
	}

	public List<PatternData> get_unionpattData() {
		return _unionpattData;
	}

	public List<PatternData> get_pattData() {
		return _pattData;
	}
}
