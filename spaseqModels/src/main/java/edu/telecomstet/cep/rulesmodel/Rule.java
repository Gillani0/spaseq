/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.cep.rulesmodel;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.OP;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.knowledgebase.KnowledgeBaseBindingImpl;
import edu.telecomstet.cep.model.Filter;
import edu.telecomstet.cep.model.ObjectS;
import edu.telecomstet.cep.model.Predicate;
import edu.telecomstet.cep.model.Subject;
import edu.telecomstet.cep.statefull.StateDependability;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;


/**
 *
 * @author sydgillani
 */
public final class Rule {
    
    private boolean breaker;
    private boolean objBreaker;
    
    
    
    private int cost;
    
    
    private  int id;
    //private  int dependability;
    
    private boolean iscomplete;
    
    
    private boolean dependabilty_flag;
    private boolean kb_flag;
    private int stateFull_flag; ///1 true, 0 false
    
    //private int stateFull_Id;
    
    private  int cacheStateFull; //1 true, 0false
    
    
    private int filterRuleID;
    
    
    private Subject subject;
    private ObjectS object;
    private Predicate predicate;
    
    private List<Filter> filter;
    
    private  boolean filterFlag;
    
    private String filterType1Operator;
    
    private int filterType; //1: for atomic filter, 2: for complex filter, 3: for KB based complex filter
    
    private boolean filterRightFlag; //
    
    private int eventDataType;
    
    private int queryType; ///1 for chain, 2 for star query ,3 for joiner  triple pattern
    
    private int gloabl_Id;
    
    private int stateFull_dType;
    
    //private MultiBiMap<Long, Long> _tableSOMapped;
    
    private boolean select;
    
    private boolean selectObj;
    
    private boolean selectSub;

    
    // private MultiBiMap<SP, OP> _C;

    private MultiBiMap<Long, Long> _c;

  

    
    
    private List<Dependability> depends;
    
    private List<KBDependability> _kbdepends; /// to get the depedability from the query ///useless
    
    private   KnowledgeBaseBindingImpl _kbCBindings; ///to strore the binding from KB file ///uesless
   
    private List<StateDependability> s_depends;
    
    
    
    public Rule() throws ParseException, DatatypeConfigurationException{
        
    	
    	this.filter= new ArrayList<>();
   
        this.iscomplete=false;
        this.stateFull_dType=3;
        this._kbdepends=new ArrayList<>();
        this.subject=new Subject();
        this.s_depends= new ArrayList<>();
        this.object=new ObjectS();
        this.predicate=new Predicate();
        this.filterType=0;
        this.cost=0;
        this.gloabl_Id=0;
       // this._tableSOMapped= new MultiBiMap();
      //  this._C=new MultiBiMap();
        this.filterRightFlag=false;
        this.breaker=false;
        this.objBreaker=false;
        this.stateFull_flag=0;
        this.filterRuleID=10000;
        this.queryType=0;
        this.cacheStateFull=0;
        _kbCBindings=new KnowledgeBaseBindingImpl();
        _c =new MultiBiMap();
        //this.filter=new Filter();
        //tableList=new ArrayList<>();
        // _tableMap = ArrayListMultimap.create();
        // dependabilityID=new ArrayList<>();
    }

    public int getStateFull_dType() {
        return stateFull_dType;
    }

    public void setStateFull_dType(int stateFull_dType) {
        this.stateFull_dType = stateFull_dType;
    }
    //String subProjection;
    // String predProjection;
    //String objPreojection;
    //String filterOn;
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isIscomplete() {
        return iscomplete;
    }
    
    public void setIscomplete(boolean iscomplete) {
        this.iscomplete = iscomplete;
    }
    
    public boolean isDependabilty_flag() {
        return dependabilty_flag;
    }
    
    public void setDependabilty_flag(boolean dependabilty_flag) {
        this.dependabilty_flag = dependabilty_flag;
    }
    
    public Subject getSubject() {
        return subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    public ObjectS getObject() {
        return object;
    }
    
    public void setObject(ObjectS object) {
        this.object = object;
    }
    
    public Predicate getPredicate() {
        return predicate;
    }
    
    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }
    
    public List<Filter> getFilter() {
        return filter;
    }
    
    public void setFilter(List<Filter> filter) {
        this.filter = filter;
    }
    
    
    
    
    public List<Dependability> getDepends() {
        return depends;
    }
    
    public void setDepends(List<Dependability> depends) {
        this.depends = depends;
    }
    public boolean isFilterFlag() {
        return filterFlag;
    }
    
    public void setFilterFlag(boolean filterFlag) {
        this.filterFlag = filterFlag;
    }
    
    public String getFilterType1Operator() {
        return filterType1Operator;
    }
    
    public void setFilterType1Operator(String filterType1Operator) {
        this.filterType1Operator = filterType1Operator;
    }
    
    
    public int getFilterType() {
        return filterType;
    }
    
    public void setFilterType(int filterType) {
        this.filterType = filterType;
    }
    
    public List<KBDependability> getKbdepends() {
        return _kbdepends;
    }
    
    public void setKbdepends(List<KBDependability> _kbdepends) {
        this._kbdepends = _kbdepends;
    }
    
    public boolean isKb_flag() {
        return kb_flag;
    }
    
    public void setKb_flag(boolean kb_flag) {
        this.kb_flag = kb_flag;
    }
    
    
    
    
    
    
    
    public boolean isBreaker() {
        return breaker;
    }
    
    public void setBreaker(boolean breaker) {
        this.breaker = breaker;
    }
    public boolean isObjBreaker() {
        return objBreaker;
    }
    
    public void setObjBreaker(boolean objBreaker) {
        this.objBreaker = objBreaker;
    }
    
    
    
    public boolean isFilterRightFlage() {
        return filterRightFlag;
    }
    
    public void setFilterRightFlage(boolean filterRightFlage) {
        this.filterRightFlag = filterRightFlage;
    }
    
    public void initialiseResult(){
        // this._tableSubjectsMapped.clear();
        //this._tableObjectsMapped.clear();
        //this._tableObjects.clear();
     //   this._tableSOMapped.clear();
        // this._tableObjects.
        //  this._tableSubjectsMapped = ArrayListMultimap.create();
        //this._tableObjectsMapped= ArrayListMultimap.create();
        // this._tableObjects=ArrayListMultimap.create();
    }
    
    
    public int isSt_Less_Dep_Flag() {
        return stateFull_flag;
    }
    
    public void setStateFull_flag(int stateFull_flag) {
        this.stateFull_flag = stateFull_flag;
    }
  
    
    public int getEventDataType() {
        return eventDataType;
    }
    
    public void setEventDataType(int eventDataType) {
        this.eventDataType = eventDataType;
    }
    
    
    public int getCost() {
        return cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    /*public MultiBiMap<Long, Long> getTableSOMapped() {
        return _tableSOMapped;
    }
    
    public void setTableSOMapped(MultiBiMap<Long, Long> _tableSOMapped) {
        this._tableSOMapped = _tableSOMapped;
    }*/
    
    public int getFilterRuleID() {
        return filterRuleID;
    }
    
    public void setFilterRuleID(int filterRuleID) {
        this.filterRuleID = filterRuleID;
    }
    
    
    public int getQueryType() {
        return queryType;
    }
    
    public void setQueryType(int queryType) {
        this.queryType = queryType;
    }
    
    
    public KnowledgeBaseBindingImpl getKbCBindings() {
        return _kbCBindings;
    }
    
    public int getGloabl_Id() {
        return gloabl_Id;
    }
    
    public void setGloabl_Id(int gloabl_Id) {
        this.gloabl_Id = gloabl_Id;
    }
    
    
    public int getCacheStateFull() {
        return cacheStateFull;
    }
    
    public void setCacheStateFull(int cacheStateFull) {
        this.cacheStateFull = cacheStateFull;
    }
    public List<StateDependability> getS_depends() {
        return s_depends;
    }
    
    public void setS_depends(List<StateDependability> s_depends) {
        this.s_depends = s_depends;
    }
    
  
        
//         public MultiBiMap<SP, OP> getC() {
//        return _C;
//    }
//
//    
//    
//             public void setC() {
//      this._C=null;
//      this._C= new MultiBiMap();
//    }
//             
             
   public MultiBiMap<Long, Long> getC2() {
        return _c;
    }

public boolean isSelect() {
	return select;
}

public void setSelect(boolean select) {
	this.select = select;
}

public boolean isSelectObj() {
	return selectObj;
}

public void setSelectObj(boolean selectObj) {
	this.selectObj = selectObj;
}

public boolean isSelectSub() {
	return selectSub;
}

public void setSelectSub(boolean selectSub) {
	this.selectSub = selectSub;
}
    
}
