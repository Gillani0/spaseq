package edu.telecom.stet.cep.datastructure;

public class KBindex {
	private final int runID;
    private final int stateID;
    
    
    public KBindex(int rid,int stid){
    	this.runID=rid;
    	this.stateID=stid;
    }


	public int getRunID() {
		return runID;
	}


	public int getStateID() {
		return stateID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + runID;
		result = prime * result + stateID;
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
		KBindex other = (KBindex) obj;
		if (runID != other.runID)
			return false;
		if (stateID != other.stateID)
			return false;
		return true;
	}
}
