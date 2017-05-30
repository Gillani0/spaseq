/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.rulesmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.knowledgebase.KBRule;

/**
 *
 * @author sydgillani
 */
public class NFAData implements Cloneable {

	private ArrayList<Rule> _ruleList; // /could be simple automtata
	private int order;
	private Automata _queryAutomta;
	// private ArrayList<Automata> _listAutomata;
	private List<KBRule> _kbRuleList2;

	private int isDoubledate; // 1 for true and 0 for false; i.e. if the states
								// contains union/or (A<>B)

	private boolean union;

	// private ArrayList<Rule> _kbRuleList;

	private List<StreamData> _streamList;
	private PatternData patterndata;
	// private ArrayList<KBbindings> _kbBindingList;
	// private KnowledgeBaseBindingImpl _kbCompleteBindings;

	private HashMap<Long, String> patternByData;

	private DictionaryOpImpl dicionary;
	private String stateType;
	private int stateDependencyID;

	private WindowTemporalData _windowData;

	private ArrayList<Rule> _constructClaue;

	private String pattType;

	public NFAData() {
		this._streamList = new ArrayList<>();
		// this._kbRuleList=new ArrayList<>();
		this._ruleList = new ArrayList<>();
		// _listAutomata =new ArrayList<>();
		this.patternByData = new HashMap<>();

	}

	public NFAData(NFAData data) {
		// this._ruleList=data.getRuleList();
		// this._kbBindingList=data.getKbBindingList();
		// this._kbCompleteBindings=data.getKbCompleteBindings();
		this._streamList = data.getStreamList();
		this.dicionary = data.getDicionary();
		this.order = data.getOrder();
		this.pattType = data.getPattType();
		this.patterndata = data.getPatterndata();
		// this.stateType=0;
		this.stateDependencyID = 0;

	}

	/*
	 * public Object clone() throws CloneNotSupportedException {
	 * 
	 * NFAData clone=(NFAData)super.clone();
	 * 
	 * // make the shallow copy of the object of type Department
	 * clone._ruleList=(ArrayList<Rule>)_ruleList.clone(); //this
	 * 
	 * // clone.setRuleList((ArrayList<Rule>)this.getRuleList().clone);
	 * 
	 * 
	 * 
	 * 
	 * return clone;
	 * 
	 * }
	 */

	public List<StreamData> getStreamList() {
		return _streamList;
	}

	public void setStreamList(List<StreamData> _streamList) {
		this._streamList = _streamList;
	}

	public PatternData getPatterndata() {
		return patterndata;
	}

	public void setPatterndata(PatternData patterndata) {
		this.patterndata = patterndata;
	}

	public ArrayList<Rule> getRuleList() {
		return _ruleList;
	}

	public void setRuleList(ArrayList<Rule> _ruleList) {
		this._ruleList = _ruleList;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getPattType() {
		return pattType;
	}

	public void setPattType(String pattType) {
		this.pattType = pattType;
	}

	// public ArrayList<KBbindings> getKbBindingList() {
	// return _kbBindingList;
	// }
	//
	// public void setKbBindingList(ArrayList<KBbindings> _kbBindingList) {
	// this._kbBindingList = _kbBindingList;
	// }
	//

	public DictionaryOpImpl getDicionary() {
		return dicionary;
	}

	public void setDicionary(DictionaryOpImpl dicionary) {
		this.dicionary = dicionary;
	}

	public void setRuleList(List<Rule> _ruleList) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	/*
	 * public int getStateType() { return stateType; }
	 * 
	 * public void setStateType(int stateType) { this.stateType = stateType; }
	 */

	public int getStateDependencyID() {
		return stateDependencyID;
	}

	public void setStateDependencyID(int stateDependencyID) {
		this.stateDependencyID = stateDependencyID;
	}

	public WindowTemporalData getWindowData() {
		return _windowData;
	}

	public void setWindowData(WindowTemporalData _windowData) {
		this._windowData = _windowData;
	}

	public Automata getAutomta() {
		return _queryAutomta;
	}

	public void setAutomta(Automata automta) {
		this._queryAutomta = automta;
	}

	/*
	 * public void setKbCompleteBindings(KnowledgeBaseBindingImpl
	 * _kbCompleteBindings) { this._kbCompleteBindings = _kbCompleteBindings; }
	 */

	// public ArrayList<Automata> getListAutomata() {
	// return _listAutomata;
	// }
	//
	// public void setListAutomata(ArrayList<Automata> _listAutomata) {
	// this._listAutomata = _listAutomata;
	// }

	public HashMap<Long, String> getPatternByData() {
		return patternByData;
	}

	public void setPatternByData(HashMap<Long, String> patternByData) {
		this.patternByData = patternByData;
	}

	public List<KBRule> getKbRuleList2() {
		return _kbRuleList2;
	}

	public void setKbRuleList2(List<KBRule> _kbRuleList2) {
		this._kbRuleList2 = _kbRuleList2;
	}

	public ArrayList<Rule> get_constructClaue() {
		return _constructClaue;
	}

	public void set_constructClaue(ArrayList<Rule> _constructClaue) {
		this._constructClaue = _constructClaue;
	}

	public boolean isUnion() {
		return union;
	}

	public void setUnion(boolean union) {
		this.union = union;
	}

	public String getStateType() {
		return stateType;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public int getIsDoubledate() {
		return isDoubledate;
	}

	public void setIsDoubledate(int isDoubledate) {
		this.isDoubledate = isDoubledate;
	}
}
