/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.knowledgebase;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecomstet.cep.model.Filter;
import edu.telecomstet.cep.model.ObjectS;
import edu.telecomstet.cep.model.Predicate;
import edu.telecomstet.cep.model.Subject;
import edu.telecomstet.cep.rulesmodel.Dependability;
import edu.telecomstet.cep.statefull.StateDependability;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author sydgillani
 */
public class KBRule {
  
    
    
   
	 private boolean select;
	    
	    private boolean selectObj;
	    
	    private boolean selectSub;
    
    private  int id;
    //private  int dependability;
    
    private boolean iscomplete;
    
    
    private boolean dependabilty_flag;
    private boolean kb_flag;
    private int stateFull_flag; ///1 true, 0 false
    
    //private int stateFull_Id;
    
   
    
    
    private int filterRuleID;
    
    
    private Subject subject;
    private ObjectS object;
    private Predicate predicate;
    
    private Filter filter;
    
    private  boolean filterFlag;
    
    private String filterType1Operator;
    
    private int filterType; //1: for atomic filter, 2: for complex filter, 3: for KB based complex filter
    
    private boolean filterRightFlag; //
    
    private int eventDataType;
    
  
    
    private int gloabl_Id;
    
    private int stateFull_dType;
    
    //private MultiBiMap<Long, Long> _tableSOMapped;
    
    

    
   

     private MultiBiMap<Long, Long> _c;

  
   
     private MultiBidirectionalIndex _r;

    
     private MultiBidirectionalIndex _rCopied;
    
    
     private MultiBidirectionalIndex _r2;

     

    
     
     
     
    private List<Dependability> depends;
    
   
    private List<StateDependability> s_depends;
    
    
    
    public KBRule() throws ParseException, DatatypeConfigurationException{
        
   
        this.iscomplete=false;
        this.stateFull_dType=3;
       
        this.subject=new Subject();
        this.s_depends= new ArrayList<>();
        this.object=new ObjectS();
        this.predicate=new Predicate();
        this.filterType=0;
 
        this.gloabl_Id=0;
      
        this.filterRightFlag=false;
       
        this.stateFull_flag=0;
        this.filterRuleID=10000;
     
     this.select=false;
     this.selectSub=false;
     this.selectObj=false;
       
        _c =new MultiBiMap<Long, Long>();
        _r = new MultiBidirectionalIndex();
        _rCopied =new MultiBidirectionalIndex();
        _r2=new MultiBidirectionalIndex();
       
    }

  

    public void setC(MultiBiMap<Long, Long> _c) {
        this._c = _c;
    }

    public MultiBidirectionalIndex getRreal() {
        return _r;
    }

    public void setR(MultiBidirectionalIndex _r) {
        this._r = _r;
    }

    public MultiBidirectionalIndex getrCopied() {
        return _rCopied;
    }

    public void setrCopied(MultiBidirectionalIndex _rCopied) {
        this._rCopied = _rCopied;
    }

    public int getStateFull_dType() {
        return stateFull_dType;
    }

    public void setStateFull_dType(int stateFull_dType) {
        this.stateFull_dType = stateFull_dType;
    }
 
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
    
    public Filter getFilter() {
        return filter;
    }
    
    public void setFilter(Filter filter) {
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
  
    public boolean isKb_flag() {
        return kb_flag;
    }
    
    public void setKb_flag(boolean kb_flag) {
        this.kb_flag = kb_flag;
    }
    
    
    
    
    

    
    
    public boolean isFilterRightFlage() {
        return filterRightFlag;
    }
    
    public void setFilterRightFlage(boolean filterRightFlage) {
        this.filterRightFlag = filterRightFlage;
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
    
    

    public int getFilterRuleID() {
        return filterRuleID;
    }
    
    public void setFilterRuleID(int filterRuleID) {
        this.filterRuleID = filterRuleID;
    }
    
    
  
  
    
    public int getGloabl_Id() {
        return gloabl_Id;
    }
    
    public void setGloabl_Id(int gloabl_Id) {
        this.gloabl_Id = gloabl_Id;
    }
    
    
   
    public List<StateDependability> getS_depends() {
        return s_depends;
    }
    
    public void setS_depends(List<StateDependability> s_depends) {
        this.s_depends = s_depends;
    }
    
  
        
             
             
   public MultiBiMap<Long, Long> getC2() {
        return _c;
    }



public MultiBidirectionalIndex getRreal2() {
	return _r2;
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
