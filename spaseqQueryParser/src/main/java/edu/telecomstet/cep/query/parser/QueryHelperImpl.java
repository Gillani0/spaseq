/*
* @(#)QueryHelperImpl.java   14/10/14
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
package edu.telecomstet.cep.query.parser;

//~--- non-JDK imports --------------------------------------------------------

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.knowledgebase.KBRule;
import edu.telecomstet.cep.query.helpers.KBJoiner;
import edu.telecomstet.cep.query.helpers.QueryDescriptor;
import edu.telecomstet.cep.query.helpers.QueryHelper;
import edu.telecomstet.cep.query.sources.StreamingSparql;
import edu.telecomstet.cep.rulesmodel.NFAData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.xml.datatype.DatatypeConfigurationException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.parser.NxParser;


/**
 *
 * @author sydgillani
 */
public class QueryHelperImpl implements QueryHelper
{
    
	KBJoiner kbjoin;
    ListenerQueryContextUpdated ListenerQuery;
    
   // DictionaryOpImpl dic;
    
    public QueryHelperImpl(StreamingSparql parser, DictionaryOpImpl dict, String kbFile) throws ParseException, DatatypeConfigurationException, FileNotFoundException {
        ParseTree       tree   = parser.query();
        ParseTreeWalker walker = new ParseTreeWalker();
      //  this.dic = dict;
        this.ListenerQuery = new ListenerQueryContextUpdated(dict);
        walker.walk(ListenerQuery, tree);
        // this.loadKBdata("");
      //  filterKBbindingsUpdated(kbFile);
          kbDataManipulation(kbFile);
          
          kbjoin= new KBJoiner();
          
          
          
          for(NFAData data:this.ListenerQuery.getNfaDataList()){
             
              if(!data.getKbRuleList2().isEmpty())
              kbjoin.initiateKBJoins(data.getKbRuleList2());
              
              
          }
              
          
        
        // this._stateMachinesData=ListenerQuery.getLLNFA_();
        // this.filterList=ListenerQuery.getFilterList();
    }
    
    @Override
    public void Patterns() {
        throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
    }
    
    public final QueryDescriptor queryDescriptor() throws ParseException, DatatypeConfigurationException {
        
        return new QueryDescriptor(this.ListenerQuery.getNfaDataList(),  this.ListenerQuery.getDictImpl(),this.ListenerQuery.get_pattData(),this.ListenerQuery.get_unionpattData());    ////also add the values of the graph ones A table to store all the values
    }
    
    
    
    
    
 private void kbDataManipulation(String kbF) throws FileNotFoundException{
       if(!kbF.equals("")){
            FileInputStream is = new FileInputStream(kbF);
            NxParser nxp = new NxParser(is);
            Node[] nxx = null;
            while (nxp.hasNext()) {
                nxx = nxp.next();
                
               
                for(NFAData data:this.ListenerQuery.getNfaDataList()){
                
                    for(KBRule kbrule:data.getKbRuleList2()){
                        if(!( kbrule.getPredicate().isProjection()) && !(  kbrule.getPredicate().getValue().equals(nxx[1]))){
                            continue;
                            
                        }else if(!( kbrule.getSubject().isProjection()) && !(kbrule.getSubject().getValue().equals(nxx[0]))){
                             continue;
                        }else if(!( kbrule.getObject().isProjection()) && !(kbrule.getObject().getValue().equals(nxx[2]))){
                             continue;
                        }
                        
                        
                        long subject=0;
                        long object=0;
                        
                        if(nxx[2] instanceof Literal){
                            object=this.ListenerQuery.getDictImpl().addLiteralPersistant((Literal)nxx[2]);
                        }else if(nxx[2] instanceof Resource){
                            object = this.ListenerQuery.getDictImpl().addResourcePersistant((Resource) nxx[2]);
                        }else if(nxx[2] instanceof BNode){
                            object = this.ListenerQuery.getDictImpl().addBnodePersistant((BNode)nxx[2]);
                        }
                        
                        
                        if(nxx[0] instanceof Resource){
                            subject = this.ListenerQuery.getDictImpl().addResourcePersistant((Resource) nxx[0]);
                        }else if(nxx[0] instanceof BNode){
                            subject = this.ListenerQuery.getDictImpl().addBnodePersistant((BNode)nxx[0]);
                        }
                        
                        
                         kbrule.getC2().put(subject,object);
                        
                        
                        
                        
                        
                        
                        
                        
                    }
                }
                
                
            }
       }
 }
    
    
   /* private void kbMappingBuilder(String kbF) throws FileNotFoundException{
        if(!kbF.equals("")){
            
            
            FileInputStream is = new FileInputStream(kbF);
            NxParser nxp = new NxParser(is);
            Node[] nxx = null;
            while (nxp.hasNext()) {
                nxx = nxp.next();
                for(NFAData data:this.ListenerQuery.getNfaDataList()){
                    
                    for(KBbindings k:data.getKbBindingList()){
                        
                        ///check the predicate firs
                        
                        if(!( k.getPred().isProjection()) && !( k.getPred().getValue().equals(nxx[1]))){
                            continue;
                            
                        }else if(!( k.getSub().isProjection()) && !(k.getSub().getValue().equals(nxx[0]))){
                             continue;
                        }else if(!( k.getObj().isProjection()) && !(k.getObj().getValue().equals(nxx[2]))){
                             continue;
                        }
                        
                        ////Add to the C table
                        
                       //  s.getRule().getC().put(new SP(e.getSubject(),s.getRule().getPredicate().getMappedValue()), new OP(e.getObject(),s.getRule().getPredicate().getMappedValue()));
                        
                         
                          if(nxx[2] instanceof Literal){
                              k.getC().put(new SP(this.ListenerQuery.getDictImpl().addResourcePersistant((Resource) nxx[0]),k.getPred().getMappedValue()), new OP(this.ListenerQuery.getDictImpl().addLiteralPersistant((Literal)nxx[2]),k.getPred().getMappedValue()));
                          }else if(nxx[2] instanceof BNode){
                                 k.getC().put(new SP(this.ListenerQuery.getDictImpl().addResourcePersistant((Resource) nxx[0]),k.getPred().getMappedValue()), new OP(this.ListenerQuery.getDictImpl().addBnodePersistant((BNode)nxx[2]),k.getPred().getMappedValue()));
                          }
                          
                          else{
                                k.getC().put(new SP(this.ListenerQuery.getDictImpl().addResourcePersistant((Resource) nxx[0]),k.getPred().getMappedValue()), new OP(this.ListenerQuery.getDictImpl().addResourcePersistant((Resource)nxx[2]),k.getPred().getMappedValue()));
                          }
                        
                        
                    }
                }
            }
            
       //     System.out.println("Done");
        }
    }
    */
    
    
    

    
    
    
    
   /* private boolean kbMatcher(Subject s, ObjectS o, Subject s2, ObjectS o2){
        
        if(s.isProjection() && s.getProjection().equals(s2.getProjection())){ ///s-s kb join
            return true;
        }else if (s.isProjection() && s.getProjection().equals(o2.getProjection())){ //s-o join
            return true;
        }else if(o.isProjection() && o.getProjection().equals(o2.getProjection())){ //o-o join
            return true;
        }else if(o.isProjection() && o.getProjection().equals(s2.getProjection())){ ///o-s join
            return true;
        }
        
        return false;
    }*/
    
}


//~ Formatted by Jindent --- http://www.jindent.com
