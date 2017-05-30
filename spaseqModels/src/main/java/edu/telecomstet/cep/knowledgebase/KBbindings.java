/*
* @(#)KBbindings.java   14/10/14
*
* Copyright (c) 2014 Telecon Saint-Etienn & EMSE
*
* THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF
* THIS CREATIVE COMMONS PUBLIC LICENCE ("CCPL" OR "LICENCE").
* THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.
* ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENCE OR COPYRIGHT LAW IS PROHIBITED.
* BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND AGREE TO BE BOUND BY THE TERMS OF THIS LICENCE.
* THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
*
*
*
*/



/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package edu.telecomstet.cep.knowledgebase;

//~--- non-JDK imports --------------------------------------------------------

import com.jcwhatever.nucleus.collections.MultiBiMap;
import edu.telecom.stet.cep.datastructure.OP;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.model.ObjectS;
import edu.telecomstet.cep.model.Predicate;
import edu.telecomstet.cep.model.Subject;
import edu.telecomstet.cep.rulesmodel.Dependability;
import edu.telecomstet.cep.statefull.StateDependability;
import java.text.ParseException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.semanticweb.yars.nx.Resource;



/**
 *
 * @author sydgillani
 */
public class KBbindings
{
    
    // private Object       subject;  ///change it to proper subject and objects
    //private Object       predicate;
    //private Object       object;
    
    
    
    private Subject     sub;
    private  ObjectS     obj;
    private int stateID;
    private Predicate    pred;
    // private ValueFactory factory;
    private String       sP; //projections
    private String       oP; ///projections
    private int stateFull_flag; ///0 for false, 1 for true;
    private MultiBiMap<SP, OP> _c;
    
    
    private MultiBiMap<SP, OP> _r;
    
    Dependability depends;
    private Predicate   graphURI;
    // private final   MultiBiMap<Long, Long> _tableKBSOMapped;
    StateDependability   stateDepends;
    
    
    public KBbindings() throws ParseException, DatatypeConfigurationException {
        _c = new MultiBiMap();
        _r = new MultiBiMap();
        this.stateID=0;
        this.stateFull_flag=0;
        this.stateDepends=new StateDependability();
        this.depends=new Dependability();
        
    }
    
    
    
    
    
    public Resource predicateManipulation(String predicate) {
        predicate = predicate.replace("'", "");
        // predicate = predicate.replace("<", "");
        // predicate = predicate.replace(">", "");
        
        // /remove < and >
        return new Resource(predicate,true);//  factory.createURI(predicate);
    }
    
  
    
    public String getSubjectProjection() {
        return sP;
    }
    
    public void setSubjectProjection(String subjectProjection) {
        this.sP = subjectProjection;
    }
    
    public String getObjectPtojection() {
        return oP;
    }
    
    public void setObjectPtojection(String objectPtojection) {
        this.oP = objectPtojection;
    }
    
    
    public Subject getSub() {
        return sub;
    }
    
    public void setSub(Subject sub) {
        this.sub = sub;
    }
    
    public ObjectS getObj() {
        return obj;
    }
    
    public void setObj(ObjectS obj) {
        this.obj = obj;
    }
    
    public Predicate getPred() {
        return pred;
    }
    
    public void setPred(Predicate pred) {
        
        
        this.pred = pred;
    }
    public Predicate getGraphURI() {
        return graphURI;
    }
    
    public void setGraphURI(Predicate graphURI) {
        this.graphURI = graphURI;
    }
    
    
    
    
    public String getsP() {
        return sP;
    }
    
    public void setsP(String sP) {
        this.sP = sP;
    }
    
    public String getoP() {
        return oP;
    }
    
    public void setoP(String oP) {
        this.oP = oP;
    }
    
    
    public int getStateID() {
        return stateID;
    }
    
    public void setStateID(int stateID) {
        this.stateID = stateID;
    }
    
    public int getStateFull_flag() {
        return stateFull_flag;
    }
    
    public void setStateFull_flag(int stateFull_flag) {
        this.stateFull_flag = stateFull_flag;
    }
    
    public Dependability getDepends() {
        return depends;
    }
    
    public void setDepends(Dependability depends) {
        this.depends = depends;
    }
    
    public StateDependability getStateDepends() {
        return stateDepends;
    }
    
    public void setStateDepends(StateDependability stateDepends) {
        this.stateDepends = stateDepends;
    }
    public MultiBiMap<SP, OP> getC() {
        return _c;
    }
    
    public MultiBiMap<SP, OP> getR() {
        return _r;
    }
}



