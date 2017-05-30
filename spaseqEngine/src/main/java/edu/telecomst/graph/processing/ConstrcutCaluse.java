package edu.telecomst.graph.processing;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Resource;

import com.google.common.collect.Sets;

import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.engine.optimised.RunOptimised;
import edu.telecomstet.cep.rulesmodel.Dependability;
import edu.telecomstet.cep.rulesmodel.Rule;

public class ConstrcutCaluse {
private List<Rule> constPattern;
private Set<Long> tempset1;
private Set<Long> tempset2;
private BlockingQueue<String> resultqueue;
public  ConstrcutCaluse(List<Rule> cp,BlockingQueue<String> qu){
	this.constPattern=cp;
	this.resultqueue=qu;
	tempset1=new HashSet<Long>();
	tempset2= new HashSet<Long>();
}

public void constrcutGraph(Map<RunStateMap, MultiBidirectionalIndex> _cache, RunOptimised r,DictionaryOpImpl _dictImpl){
	//Take the construct rules and check the predicates from the results to output the matches
	//TODO:Put the result in the queue for the output
	for(Rule rule:constPattern){
		//get the dependability list 
		
//		for(Dependability dd: rule.getDepends()){
//			///get the  block id first
//			//According to the block id get the result list
//			
//			 //check in this result the predicate that belongs to rules predicate and if its equal
//			 ///check the dependability, like join on S or O and construct the triples using the Cartesian product
//			 //Case 1: if only subject or object is a variable
//			 //Case 2: if both subject and object are vaiables
//			 
//		}
		if(rule.getDepends().size()==1){
			 MultiBidirectionalIndex result=_cache.get(new RunStateMap(rule.getDepends().get(0).getBlockID(),r.getId(), rule.getId()));
			 //TODO: if the result is null, then what to do
			 
			 
			 this.case1TripleGeneration(result, rule.getDepends().get(0).getdPredicate(),rule.getPredicate().getValue().toString(), rule.getObject().getValue().toString(), rule.getDepends().get(0).getDependability_On(), _dictImpl);
		}else if(rule.getDepends().size()==2){
			long pred1=rule.getDepends().get(0).getdPredicate();
		this.tempset1.clear();
		this.tempset2.clear();
			long pred2 =rule.getDepends().get(1).getdPredicate();
			
			///check the block ids over here, if they are same then its the simple function, otherwise you've to get the indivisual 
			//results from each of these. 
			if(rule.getDepends().get(0).getBlockID()!=rule.getDepends().get(1).getBlockID()){
				MultiBidirectionalIndex result1=_cache.get(new RunStateMap(rule.getDepends().get(0).getBlockID(),r.getId(),rule.getId()));
				MultiBidirectionalIndex result2=_cache.get(new RunStateMap(rule.getDepends().get(1).getBlockID(),r.getId(),rule.getId()));
				case2TripleGenerationPerBlock(result1,result2,pred1,pred2, rule.getDepends(),rule.getPredicate().getPredicateValue().toString(),_dictImpl);
			}else{
			
			MultiBidirectionalIndex result=_cache.get(new RunStateMap(rule.getDepends().get(1).getBlockID(),r.getId(),rule.getId()));
			case2TripleGeneration(result,pred1,pred2, rule.getDepends(),rule.getPredicate().getPredicateValue().toString(),_dictImpl);
			}
//			if(pred1==pred2){
//				MultiBidirectionalIndex result=_cache.get(new RunStateMap(rule.getDepends().get(1).getBlockID(),r.getId()));
//				case2TripleGeneration(result,pred1,pred2);
//			}else{
//				
//				
//				MultiBidirectionalIndex result=_cache.get(new RunStateMap(rule.getDepends().get(1).getBlockID(),r.getId()));
//				case2TripleGeneration(result,pred1,pred2);
//			}
		}
		
	}
	
	
	
//     for(int i=0;i<states;i++){
//         
//          System.out.println("############ State "+i+"############################");
//         
//             MultiBidirectionalIndex result=_cache.get(new RunStateMap(i,r.getId()));
//         
//             
//             for(long key:result.getrIndex().keySet()){
//                 
//                 Set<SP> sp=result.getrIndex().get(key);
//                 
//             
//                 for(SP out:sp){
//                System.out.print(_dictImpl.getResourceIncremenal( out.getSub()) + "    "
//                     + "" + _dictImpl.getResourcePersistant(key) + "  "
//                     + " "+ _dictImpl.getResourceIncremenal(out.getPred())+ _dictImpl.getBnodeIncremental(out.getPred()) +"   "
//             );
//             
//            
//             Literal lg= _dictImpl.getLiteralIncremental(out.getPred());
//             if(lg != null)
//               System.out.print(lg.getValue().toString());
//              System.out.println();
//      
//             
//                 }
//                 
//                 
//                   
//                 
//             }
//     }
}
public void case1TripleGeneration( MultiBidirectionalIndex result, long pred, String opred, String val, int type,DictionaryOpImpl _dictImpl){
	
	///get all the so pairs for this predicate
	String output="";
	if(type==1){ ///get only the subjects
		for(SP so:result.getrIndex().get(pred)){
		//	System.out.println(so.getSub() +pred +val);
			
			// System.out.println(_dictImpl.getResourceIncremenal(so.getSub()) + "    "+ opred + "   "+val);
			 
			 //first resource then bnode
	        Resource rc= _dictImpl.getResourceIncremenal(so.getSub());
				
				if(output ==null){
					output=_dictImpl.getBnodeAdaptive(so.getSub()).toString();
				}else{
					output =rc.toString();
				}
				output ="<"+output+">"+ "  "+"<" +opred+">"+" "+"<"+val+"> .";
				
				this.resultqueue.add(output);
			 //System.out.println(output);
		}
	}else if(type ==0){ //
		for(SP so:result.getrIndex().get(pred)){
		//	System.out.println(val +pred + so.getPred());
			// System.out.println( val+ "    "+ opred + "   "+_dictImpl.getResourceIncremenal(so.getPred()));
				Literal lg= _dictImpl.getLiteralAdaptive(so.getPred());
	             if(lg != null){
	            	 
	            	
	             output="<"+val+">"+  "  "+"<" +opred+">"+" ";
	        
	            this.literalGeneration(output, lg);
	             
	                 }else{
	                	 
	                	 
	                	 Resource rc= _dictImpl.getResourceIncremenal(so.getPred());
	                	 
	                	 if(rc==null){
	                		 output= "<"+val+">"+  "  "+"<" +opred+">"+" "+"<"+_dictImpl.getBnodeAdaptive(so.getPred()).toString()+">";
	                	 }else{
	                		 output ="<"+val+">"+  "  "+"<" +opred+">"+" "+"<"+rc.toString()+">"; 
	                	 }
	                	 
	                	 
	                 }
	             this.resultqueue.add(output);
	           //  System.out.println(output);
			 ///first literal, then resource and then bnode
		}
	}
	
}

@SuppressWarnings("unchecked")
public void case2TripleGenerationPerBlock( MultiBidirectionalIndex result1, MultiBidirectionalIndex result2,long pred1, long pred2, List<Dependability> depends, String orgpred,DictionaryOpImpl _dictImpl){
//	if(pred1==pred2){
//		for(SP so:result.getrIndex().get(pred1)){
//			System.out.println(so.getSub() +pred1 +so.getPred());
//		}
//	}else{
		
		
		
		///get the subject/object from the first one and subject/object from the second predicate and then use a cartesian product on top of it
		if(depends.get(0).getDependability_part()==1){
			
			 insertIn1(1,result1,pred1);
			
		
		}else{
			insertIn1(0,result1,pred1);
			
		}
		
		
		if(depends.get(1).getDependability_part()==1){
			
			 insertIn2(1,result2,pred2);
			
		
		}else{
			insertIn2(0,result2,pred2);
			
		}
		
		//get the cartesian product
		
		Set<List<Long>> cp = Sets.cartesianProduct(this.tempset1, this.tempset2);
		///send it for the output
		this.cartesianOutput(cp, orgpred,_dictImpl);
	//}
	
}


@SuppressWarnings("unchecked")
public void case2TripleGeneration( MultiBidirectionalIndex result, long pred1, long pred2, List<Dependability> depends, String orgpred,DictionaryOpImpl _dictImpl){
//	if(pred1==pred2){
//		for(SP so:result.getrIndex().get(pred1)){
//			System.out.println(so.getSub() +pred1 +so.getPred());
//		}
//	}else{
		
		
		
		///get the subject/object from the first one and subject/object from the second predicate and then use a cartesian product on top of it
		if(depends.get(0).getDependability_part()==1){
			
			 insertIn1(1,result,pred1);
			
		
		}else{
			insertIn1(0,result,pred1);
			
		}
		
		
		if(depends.get(1).getDependability_part()==1){
			
			 insertIn2(1,result,pred2);
			
		
		}else{
			insertIn2(0,result,pred2);
			
		}
		
		//get the cartesian product
		
		Set<List<Long>> cp = Sets.cartesianProduct(this.tempset1, this.tempset2);
		///send it for the output
		this.cartesianOutput(cp, orgpred,_dictImpl);
	//}
	
}

@SuppressWarnings("unused")
private void cartesianOutput(Set<List<Long>> sets, String pred,DictionaryOpImpl _dictImpl){
	String output="";
	for(List<Long> s:sets){
		for(Long so:s){
			if(this.tempset1.contains(so)){
				///its a subject
				//first check the resource if its empty then check the blanknode
				Resource rc= _dictImpl.getResourceAdaptive(so);
				
				if(output ==null){
					output=_dictImpl.getBnodeAdaptive(so).toString();
				}else{
					output =rc.toString();
				}
				output ="<"+output+">"+ "    "+"<" +pred+">";
				 
			}else{
				//its an object
				
				//first check the literal, if empty check resource, if empty get the blank node
				Literal lg= _dictImpl.getLiteralAdaptive(so);
	             if(lg != null){
	             //output= " "+"<"+lg.getValue().toString()+">";
	        
	          output= this.literalGeneration(output, lg);
	             
	                 }else{
	                	 
	                	 
	                	 Resource rc= _dictImpl.getResourceIncremenal(so);
	                	 
	                	 if(rc==null){
	                		 output= " "+"<"+_dictImpl.getBnodeAdaptive(so).toString()+"> .";
	                	 }else{
	                		 output =" "+"<"+rc.toString()+"> ."; 
	                	 }
	                	 
	                	 
	                 }
			}
			this.resultqueue.add(output);
			
		//	System.out.print(output);
		}
	}
}

private void insertIn1(int type, MultiBidirectionalIndex result, long pred){
	for(SP so:result.getrIndex().get(pred)){
		if(type==1){
		this.tempset1.add(so.getSub());
	}else{
		this.tempset1.add(so.getPred());
	}
		
	}
}

private void insertIn2(int type, MultiBidirectionalIndex result, long pred){
	for(SP so:result.getrIndex().get(pred)){
		if(type==1){
		this.tempset2.add(so.getSub());
	}else{
		this.tempset2.add(so.getPred());
	}
		
	}
}


private String literalGeneration(String output, Literal lg){
	
	if(lg.getType()==5){ //its a String
		output= " "+"\""+lg.getValue()+"\""+"^^<http://www.w3.org/2001/XMLSchema#string> .";
	}else if(lg.getType()==0){ ///its an int
		output= " "+"\""+lg.getValue()+"\""+"^^<http://www.w3.org/2001/XMLSchema#integer> .";
	}else if(lg.getType()==4){ //its a double
		output= " "+"\""+lg.getValue()+"\""+"^^<http://www.w3.org/2001/XMLSchema#double> .";
	}
	
	return output;
	
}



public void outPut(){
	
}








public List<Rule> getConstPattern() {
	return constPattern;
}


public void setConstPattern(List<Rule> constPattern) {
	this.constPattern = constPattern;
}
}
