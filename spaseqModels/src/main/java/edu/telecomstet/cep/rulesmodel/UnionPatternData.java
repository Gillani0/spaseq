package edu.telecomstet.cep.rulesmodel;

public class UnionPatternData {
	 private String pattName1;
	  private  String pattType;
	     private  String pattSelection;
	     private String pattName2;
	     private String uinonOr;

	    public String getPattSelection() {
	        return pattSelection;
	    }

	    public void setPattSelection(String pattSelection) {
	        this.pattSelection = pattSelection;
	    }
	    
	    public UnionPatternData (){
	        pattType=null; ////can put another temp text into it for comparison
	        pattSelection=",";
	    }
	   
	    public String getPattType() {
	        return pattType;
	    }

	    public void setPattType(String pattType) {
	        this.pattType = pattType;
	    }

		public String getPattName1() {
			return pattName1;
		}

		public void setPattName1(String pattName1) {
			this.pattName1 = pattName1;
		}

		public String getPattName2() {
			return pattName2;
		}

		public void setPattName2(String pattName2) {
			this.pattName2 = pattName2;
		}

		public String getUinonOr() {
			return uinonOr;
		}

		public void setUinonOr(String uinonOr) {
			this.uinonOr = uinonOr;
		}
	 
}
