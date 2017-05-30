
package edu.telecomstet.cep.nfahelpers2;



import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.telecomstet.cep.rulesmodel.NFAData;
import edu.telecomstet.cep.rulesmodel.PatternData;




/**
 * This class represents an NFA.
 * @author sydgillani
 *
 */
public final class NFA {
	/**
	 * The states
	 */
     private final State[] states;
	/**
	 * The number of states
	 */
	private int size = 0; 
	
	
	private final long duration;
	
	/**
	 * The selection strategy
	 */
	private String selectionStrategy;
	
	/**
	 * The time window
	 */
private  long timeWindow;  //considering the same time window for all the incoming streams

private String unit;

   
	
    
   // int query; //For each subquery
    
  //  boolean witnessevent; ////to get the witness event in case of pattern comparison
    
	/**
	 * Flag denoting whether the query needs value vector
	 * It is needed when there are aggregates or parameterized predicates
	 */
	//boolean needValueVector;
	
	/**
	 * The value vectors for the computation state
	 */
	//ValueVectorTemplate[][] valueVectors;   
    
      //  ArrayList<String>  resultedObjects; // To save the result of one computation///
	
	/**
	 * Denoting whether the query has value vectors
	 */
	//boolean hasValueVector[];
	
	/**
	 * Specifies the partiton attribute, only for partiton-contiguity selection strategy.
	 */
	//String partitionAttribute;// this is used only when we use partition-contiguity selection strategy
	/**
	 * Flag denoting whether the query has a partition attribute
	 */
	//boolean hasPartitionAttribute;
	/**
	 * Store other partition attributes except for the first one, if any
	 */
	//ArrayList<String> morePartitionAttribute;
	/**
	 * Flag denoting whether the query has more than one partition attributes
	 */
	//boolean hasMorePartitionAttribute;
	/**
	 * Flag denoting whether the query has a negation component
	 */
	boolean hasNegation;
	/**
	 * The negation state
	 */
	


	
        /***
         * Constructor of NFA for NFAdatalist
     * @param nfaDataList
         */
	
	
	
        public NFA(List<NFAData> nfaDataList){
           /**
            * TODO: have to do something about AND and OR Operators.
            * May be divide the NFA lists into
            */
          
           this.unit=nfaDataList.get(0).getWindowData().getUnit();
           
            this.timeWindow=  this.windowSelector(nfaDataList.get(0).getWindowData().getTime(),nfaDataList.get(0).getWindowData().getUnit()); ///get the time window from the query
            
            this.duration = nfaDataList.get(0).getWindowData().getTime();
            
          
            this.size=nfaDataList.size();
            this.states = new State[nfaDataList.size()];
            int counter = 0;
            for(NFAData nfaData:nfaDataList){
                states[counter] = new State(nfaData, counter);
                counter++;
            }
            
            if(this.size > 0){
		states[0].setStart(true);
		states[this.size-1].setEnding(true);
		}
           // testNegation();
            
        }
        
//        public void NFAolder(List<PatternData> data,List<NFAData> nfaDataList){
//        	  this.unit=nfaDataList.get(0).getWindowData().getUnit();
//              
//              this.timeWindow=  this.windowSelector(nfaDataList.get(0).getWindowData().getTime(),nfaDataList.get(0).getWindowData().getUnit()); ///get the time window from the query
//              
//              this.duration = nfaDataList.get(0).getWindowData().getTime();
//        //  System.out.println(data.size());    
//        	 this.states = new State[data.size()];
//        	 
//        	 this.size=data.size();
//        	 
//        	 /**
//        	  * Start Assigning the NFA to each state
//        	  */
//        	 int i=0;
//        	   for(PatternData d:data){
//            	   
//            	   ///check if its single or double
//            	   if(d.getPattName2()==null){
//            		   NFAData first= nfaDataList.stream().filter(x->x.getStateType().equals(d.getPattName())).findFirst().get();
//            		   ////send it for the state
//            		   
//            		   first.setPatterndata(d);
//            		   states[i] = new State(first, first.getOrder());
//            		   i++;
//            		   ///based on this NFA data create the states
//            	   }else  if(d.getPattName2()!=null){
//            		   ///create a list of NFAData and send it with the proper ID
//            	       //For the manager State
//            		 //  NFAData first=null;
//            		 //  NFAData second=null;
//            		   final List<NFAData> collec = new ArrayList<>();
//            		   for(NFAData nf:nfaDataList){
//            			  
//            			   
//            			   if(nf.getStateType().equals(d.getPattName())){
//            				
//            				  nf.setPatterndata(d);
//            				  collec.add(nf);
//            				 // first.setPatterndata(d);
//            			   }else if(nf.getStateType().equals(d.getPattName2())){
//
//             				  nf.setPatterndata(d);
//             				  collec.add(nf);
//            			   }
//            		   }
//            		   
//            		   
//            		  // NFAData first= nfaDataList.stream().filter(x->x.getStateType().equals(d.getPattName())).findFirst().get();
//            		  
//            		  // NFAData second= nfaDataList.stream().filter(x->x.getStateType().equals(d.getPattName2())).findFirst().get();
//            	  
//            	   
//            	  
//            	  // collec.add(first);
//                 // collec.add(second);
//                  
//                  
//                  states[i] = new State(collec, d.getUinonOr());
//       		        i++;
//            	   }
//            	   
//            	   
//               
//               
//               
//               }
//        	   if(this.size > 0){
//        			states[0].setStart(true);
//        			states[this.size-1].setEnding(true);
//        			}
//    	}
    	
        
        /////////////////
        
        public NFA(List<PatternData> data,List<NFAData> nfaDataList){
      	  
        	this.unit = nfaDataList.get(0).getWindowData().getUnit();
            
            this.timeWindow =  this.windowSelector(nfaDataList.get(0).getWindowData().getTime(),nfaDataList.get(0).getWindowData().getUnit()); ///get the time window from the query
            
            this.duration = nfaDataList.get(0).getWindowData().getTime();
         
      	     this.states = new State[data.size()];
      	 
      	      this.size=data.size();
      	 
      	 /**
      	  * Start Assigning the NFA to each state
      	  */
        	 int i=0;
      	   for(PatternData d:data){
          	   
          	   ///check if its single or double
      		   
      		   ///over here check if the size of the patternNames is equal to null
      		   
      		   ////if so use the simple method
      		   
      		   
      		   if(d.getPattNameList().isEmpty()){
      			 NFAData first= nfaDataList.stream().filter(x->x.getStateType().equals(d.getPattName())).findFirst().get();
        		   ////send it for the state
        		   
        		   first.setPatterndata(d);
        		   states[i] = new State(first, first.getOrder());
        		   i++;
      		   }else  {
          		   ///create a list of NFAData and send it with the proper ID
          	      
          		   final List<NFAData> collec = new ArrayList<>();
          		 
          		   for(NFAData nf:nfaDataList){
          			  
	   
          			   
          			   for(String pattName:d.getPattNameList()){
          				 if(nf.getStateType().equals(pattName)){
               				
             				PatternData pp= new PatternData(d.getId());
             				            pp.setPattName(pattName);
             				            
             				            pp.setPattType("n");
             				            nf.setPatterndata(pp);
             				           collec.add(nf);
             				
          			   
             			   
          			        }
          			   
          			   
          		   }
          		   
              
          	           }
          	   
          	   
          		 states[i] = new State(collec, d.getUinonOr());
 		         i++;
             
             
             }
      		   
      		 
      	   }
      		   
      	   if(this.size > 0){
      			states[0].setStart(true);
      			states[this.size-1].setEnding(true);
      			}
      	   
  	}
  	
        
        
        
        
        ///////////////
        
        
        
        
        
        public LocalTime windowTimeConversion(int time, String unit){
            
            LocalTime windowTime=LocalTime.now();
           
        
            if(unit.equals("minutes") || unit.equals("MINUTES")){
               windowTime= windowTime.plusMinutes(time);
            }else if(unit.equals("hours") || unit.equals("HOURS")){
                windowTime= windowTime.plusHours(time);
            }else if(unit.equals("seconds") || unit.equals("SECONDS")){
                windowTime= windowTime.plusSeconds(time);
            }
            
            
            return windowTime;
        }
        
        
        
       private long windowSelector(long time, String unit){
           
           
           if(unit.equals("seconds") || unit.equals("SECONDS")){
               
               
            //   return System.nanoTime()+(time*1000000000);
        	   return time*1_000_000_000;
            }else  if(unit.equals("minutes") || unit.equals("MINUTES") || unit.equals("Minutes")){
                
                
                //   return System.nanoTime()+(time*1000000000);
            	   return time*1_000_000_000*60;
                } if(unit.equals("hours") || unit.equals("HOURS")){
                    
                    
                    //   return System.nanoTime()+(time*1000000000);
                	   return time*1_000_000_000*60*60;
                    }
           
           
           
           return 0;
       } 
       
       
//      public  void reloeadWindow(){
//if(unit.equals("seconds") || unit.equals("SECONDS")){
//               
//               
//               this.timeWindow= System.nanoTime()+(this.duration*1000000000);
//            }
//    	   
//    	   
//    	   
//       }
       
       /**
	 * Tests whether the query contains a negation component
	 */
	/*private void testNegation(){
		
		for(int i = 0; i < this.size; i ++){
                    
                 //   if(this)
                    
			if(this.getStates(i).stateType.equals("negation")){
				this.hasNegation = true;
				this.negationState = this.getStates(i);
			}
		}
		if(this.hasNegation){
		int negationOrder = this.negationState.getOrder()- 1;
		State newState[] = new State[this.size - 1];
		for(int i = 0; i < this.size - 1; i ++){
			if(i < negationOrder){
				newState[i] = this.getStates(i);
				if(i == negationOrder - 1){
					newState[i].setBeforeNegation(true);
				}
			}else {
				newState[i] = this.getStates(i + 1);
				if(i == negationOrder ){
					newState[i].setAfterNegation(true);
				}
			
			}
		}
		this.size = this.size - 1;
		//this.setStates(newState);
		}
		
	}*/
	
        
        
	/**
	 * Parses the nfa file
	 * @param nfaFile the nfa file
	 */
	/*public void parseNfaFile(String nfaFile) {
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(nfaFile));
			line = br.readLine();
			if(line.startsWith("SelectionStrategy") || line.startsWith("selectionStrategy")){
			// parse the descriptive format
			// next line, parse the configuration parameters
			parseNfaConfig(line);
			// count the size of nfa
                        
                      //  System.out.println("Parsing.....");
			while ((line = br.readLine())!=null){
				if (line.equalsIgnoreCase("end"))
					break;
				else
					size ++;
			}			
			states = new State[size];
			
			//parse each state			
			br = new BufferedReader(new FileReader(nfaFile));
			br.readLine();// pass the configuration line;
			
			int counter = 0;
			while((line = br.readLine())!=null){
				
				if (line.equalsIgnoreCase("end")) // reads the end of nfa file
					break;
				else 
				{
					states[counter] = new State(line.trim(), counter);// starts with 0
                                        
                                        //System.out.println("The graph Type is as "+states[counter].graphType);
					counter ++;
				}	
				
			}
			}
			else if(line.startsWith("PATTERN")){
				// parse the simpler format
				this.morePartitionAttribute = new ArrayList<String>();
				this.hasMorePartitionAttribute = false;
				do {
					this.parseFastQueryLine(line);
				}
				while((line = br.readLine()) != null);
				if(this.hasMorePartitionAttribute){
					this.addMorePartitionAttribute();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(this.size > 0){
		states[0].setStart(true);
		states[size-1].setEnding(true);
		}
	}
	/**
	 * Parses each line for the fast query format
	 * @param line
	 */
/*	public void parseFastQueryLine(String line){
		if(line.startsWith("PATTERN")){
			this.parseFastQueryLineStartWithPattern(line);
		}else if(line.startsWith("WHERE")){
			// parse the selection strategy
			StringTokenizer st = new StringTokenizer(line);
			st.nextToken();
			this.selectionStrategy = st.nextToken().trim();
		}else if(line.startsWith("AND")){
			this.parseFastQueryLineStartWithAND(line);
		}else if(line.startsWith("WITHIN")){
			// parse the time window
			StringTokenizer st = new StringTokenizer(line);
			st.nextToken();
			this.timeWindow = Integer.parseInt(st.nextToken().trim());
		}
	}
	/**
	 * Parses the query sequence
	 * @param line
	 */
/*	public void parseFastQueryLineStartWithPattern(String line){
		String seq = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
		StringTokenizer st = new StringTokenizer(seq, ",");
		this.size = st.countTokens();
		//System.out.println(size);
		this.states = new State[size];
		String state;
		for(int i = 0; i < size; i ++){
			boolean isKleeneClosure = false;
			boolean isNegation = false;
			state = st.nextToken();
			
			StringTokenizer stateSt = new StringTokenizer(state);
			String eventType = stateSt.nextToken().trim();
			String stateTag = stateSt.nextToken().trim();
			if(eventType.contains("+")){
				isKleeneClosure = true;
				eventType = eventType.substring(0, eventType.length() - 1);// the first letter
				stateTag = stateTag.substring(0, 1);
			}else if(eventType.contains("!")){
				isNegation = true;
				eventType = eventType.substring(1, eventType.length());
				
			}
			
			//System.out.println("The tag for state " + i + " is " + stateTag);
			if(isKleeneClosure){
				
				this.states[i] = new State(i + 1, stateTag, eventType, "kleeneClosure");
			}else if(isNegation){
				this.states[i] = new State(i + 1, stateTag, eventType, "negation");
			}else{
				this.states[i] = new State (i + 1, stateTag, eventType, "normal");
			}
		}
	}
	/**
	 * Parses the conditions starting with "AND", it might be the partition attribute, or predicates for states
	 * @param line
	 */
	/*public void parseFastQueryLineStartWithAND(String line){
		StringTokenizer st = new StringTokenizer(line);
		st.nextToken();
		String token = st.nextToken().trim();  
		if(token.startsWith("[")){
			//the partition attribute
			if(!this.hasPartitionAttribute){
			this.partitionAttribute = token.substring(1, token.length() - 1);
			this.hasPartitionAttribute = true;
			}else{
				this.hasMorePartitionAttribute = true;
				this.morePartitionAttribute.add(token.substring(1, token.length() - 1));
			}
		}else {
			char initial = token.charAt(0);
			int stateNum = initial - 'a';//determine which state this predicate works for according to the initial
			this.states[stateNum].addPredicate(line.substring(3).trim());
		}
		//todo for states
		
	}
	/**
	 * Adds other partition attributes except for the first to each state
	 */
/*	public void addMorePartitionAttribute(){
		String tempPredicate;
		for(int i = 0; i < this.morePartitionAttribute.size(); i ++){
			tempPredicate = this.morePartitionAttribute.get(i)+"=$1." + this.morePartitionAttribute.get(i);//?
			for(int j = 1; j < this.size; j ++){
				State tempState = this.getStates(j);
				for(int k = 0; k < tempState.getEdges().length; k ++){
					Edge tempEdge = tempState.getEdges(k);
					tempEdge.addPredicate(tempPredicate);
				}
			}
		}
	}
	/**
	 * Parses the configuration line in the nfa file
	 * @param line
	 */
	/*public void parseNfaConfig(String line){
		StringTokenizer st = new StringTokenizer(line, "|");
		while(st.hasMoreTokens()){
			parseConfig(st.nextToken().trim());
		}
		
	}*/
	
	/**
	 * Parses a configuration, now we have selection strategy, time window and partiton attribute
	 * @param attribute a configuration
	 */
/*	public void parseConfig(String attribute){
		StringTokenizer st = new StringTokenizer(attribute, "=");
		String left = st.nextToken().trim();
		String right = st.nextToken().trim();
		if(left.equalsIgnoreCase("selectionStrategy")){
			this.selectionStrategy = right;
		}else if(left.equalsIgnoreCase("timeWindow")){
			this.timeWindow = Integer.parseInt(right);
		}else if(left.equalsIgnoreCase("partitionAttribute")){
			this.partitionAttribute = right;
			ConfigFlags.partitionAttribute = right;
			this.hasPartitionAttribute = true;
		}
	}*/
	
        
        
        
        
        /**
         * Assign State And Edge Relations Based on NFA
         * 
         */
        
    /*    public void stateEdgeRelation(){
           for(int i=0;i<=this.getStates().length-1;i++) {
              State tempState = this.getStates(i);
              
             
                  Edge tempEdge=tempState.getEdges()[0];
                  
             
              
              
              if(i<this.getStates().length-1){
               State nextState = this.getStates(i+1);
              nextState.incoming_Edge=tempState.edges[0];
              nextState.incoming_Edge_Status=true;
              }
           }
            
           for(int i=0;i<=this.getStates().length-1;i++) {
              State tempState = this.getStates(i);
              
           
                //  Edge tempEdge=tempState.getEdges()[0];
         if(tempState.incoming_Edge_Status){
              Sets.SetView<String> intersection = Sets.intersection(tempState.incoming_Edge.bindingSet, tempState.getEdges()[0].getBindingSet());     
             State inState=this.getStates(i-1);
             for(int k=0;k<=inState.edges.length-1;k++){
               //  inState.edges[k].setBindingSet(intersection.copyInto(k));
                 
                 
                 intersection.copyInto( inState.edges[k].bindingSet);
             }
           }
              
             
           }
           
           
        }
        
        
        
	/**
	 * Compiles the value vector based on the nfa
	 */
	
/*	public void compileValueVectorOptimized(){
		this.valueVectors = new ValueVectorTemplate[this.size][];
		ArrayList<ValueVectorTemplate> valueV = new ArrayList<ValueVectorTemplate>();
		int counter[] = new int[this.size];
		for(int i = 0; i < this.size; i ++){
			counter[i] = 0;
		}
		for(int i = 0; i < this.getSize(); i ++){
			State tempState = this.getStates(i);
			
			for(int j = 0; j < tempState.getEdges().length; j ++){
				Edge tempEdge = tempState.getEdges(j);
				for(int k = 0; k < tempEdge.getPredicates().length; k ++){
					PredicateOptimized tempPredicate = tempEdge.getPredicates()[k];
					if(!tempPredicate.isSingleState()){
						String operationName = tempPredicate.getOperation();
						String attributeName = tempPredicate.getAttributeName();
						int stateNumber;
						if(tempPredicate.getRelatedState().equals("previous")){
							stateNumber = i - 1;
						}else{
							stateNumber = Integer.parseInt(tempPredicate.getRelatedState()) - 1;
						}
						valueV.add(new ValueVectorTemplate(stateNumber,attributeName, operationName,i));
						counter[stateNumber]++;
				
				}
			}
		}
						
		}
		
		//set the needValueVector flag as true
		if(valueV.size() > 0){
			this.needValueVector = true;
		}
		//put the value vector tempate to each state
		for(int i = 0; i < this.size ; i ++){
			this.valueVectors[i] = new ValueVectorTemplate[counter[i]];
			ValueVectorTemplate temp;
			int count = 0;
			for(int j = 0; j < valueV.size(); j ++){
				temp = valueV.get(j);
				if(temp.getState() == i){
					this.valueVectors[i][count] = temp;
					count ++;
				}
			}
		}
		this.hasValueVector = new boolean[this.size];
		for(int i = 0; i < this.size; i ++){
			if(counter[i]>0){
				this.hasValueVector[i] = true;
			}else{
				this.hasValueVector[i] = false;
			}
		}
		
		
		
	}
	

	/**
	 * Self description
	 */
	public String toString(){
		String temp = "";
		//temp += "I am an NFA";
		temp += "The selection strategy is: " + this.selectionStrategy;
		temp += "\nThe time window is : " + this.timeWindow;
		if(this.size > 0){
		temp += "\nThere are " + this.getStates().length + " states\n";
		for(int i = 0; i < this.getStates().length; i ++){
			temp += ("NO." + i + " state:" + this.getStates(i));
		}
		}
		//if(this.hasPartitionAttribute == true){
		//	System.out.println("The partition attribute is: " + this.partitionAttribute);
		//}
		return temp;
	}

	
	/**
	 * @return the states
	 */
	public State[] getStates() {
		return states;
	}
	public State getStates(int order) {
		// for debug
		/*
		if(order == 3){
			System.out.println();
		}
		*/
		return states[order];
	}
	/**
	 * @param states the states to set
	 */
	//public void setStates(State[] states) {
	//	this.states = states;
//	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the selectionStrategy
	 */
	public String getSelectionStrategy() {
		return selectionStrategy;
	}
	/**
	 * @param selectionStrategy the selectionStrategy to set
	 */
	public void setSelectionStrategy(String selectionStrategy) {
		this.selectionStrategy = selectionStrategy;
	}

	/**
	 * @return the timeWindow
	 */
	public long getTimeWindow() {
		return timeWindow;
	}

	/**
	 * @param timeWindow the timeWindow to set
	 */
	

	


	/**
	 * @return the partitionAttribute
	 */
	/*public String getPartitionAttribute() {
		return partitionAttribute;
	}

	/**
	 * @param partitionAttribute the partitionAttribute to set
	 */
	/*public void setPartitionAttribute(String partitionAttribute) {
		this.partitionAttribute = partitionAttribute;
	}*/




	/**
	 * @return the hasPartitionAttribute
	 */
	/*public boolean isHasPartitionAttribute() {
		return hasPartitionAttribute;
	}

	/**
	 * @param hasPartitionAttribute the hasPartitionAttribute to set
	 */
	/*public void setHasPartitionAttribute(boolean hasPartitionAttribute) {
		this.hasPartitionAttribute = hasPartitionAttribute;
	}*/

	/**
	 * @return the hasNegation
	 */
	public boolean isHasNegation() {
		return hasNegation;
	}

	/**
	 * @param hasNegation the hasNegation to set
	 */
	public void setHasNegation(boolean hasNegation) {
		this.hasNegation = hasNegation;
	}

        
         public String getUnit() {
        return unit;
    }
	/**
	 * @return the negationState
	 */
/*	public State getNegationState() {
		return negationState;
	}*/

	/**
	 * @param negationState the negationState to set
	 */
	/*public void setNegationState(State negationState) {
		this.negationState = negationState;
	}*/
	
	
	
	
}
