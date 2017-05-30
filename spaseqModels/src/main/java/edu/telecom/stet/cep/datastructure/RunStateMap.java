/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecom.stet.cep.datastructure;

/**
 *
 * @author sydgillani
 */
public class RunStateMap {
    @Override
	public String toString() {
		return "RunStateMap [nfaID=" + nfaID + ", runsID=" + runsID + "]";
	}



	private int nfaID;
    private int ruleID;
  
    
 
    
    
    
    private int runsID;
    
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nfaID;
		result = prime * result + ruleID;
		result = prime * result + runsID;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RunStateMap other = (RunStateMap) obj;
		if (nfaID != other.nfaID)
			return false;
		if (ruleID != other.ruleID)
			return false;
		if (runsID != other.runsID)
			return false;
		return true;
	}


	public RunStateMap(int nfa, int r, int rule){
        this.nfaID=nfa;
        this.runsID=r;
        this.ruleID=rule;
    }
    
    
    public int getRunID() {
        return nfaID;
    }
    
    public void setRunID(int runID) {
        this.nfaID = runID;
    }
    
    public int getRunsID() {
        return runsID;
    }
    
    public void setRunsID(int runsID) {
        this.runsID = runsID;
    }

	public int getRuleID() {
		return ruleID;
	}

	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}
    
    
    
}
