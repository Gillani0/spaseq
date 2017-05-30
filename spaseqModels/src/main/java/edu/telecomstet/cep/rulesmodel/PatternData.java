/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.rulesmodel;

import java.util.ArrayList;

/**
 *
 * @author sydgillani
 */
public class PatternData {
   private String pattName;
   
  private  String pattType;
  
     private  String pattSelection;
     private String pattName2;
     private final ArrayList<String> pattNameList;
     private int uinonOr;

     private final int id;
    public String getPattSelection() {
        return pattSelection;
    }

    public void setPattSelection(String pattSelection) {
        this.pattSelection = pattSelection;
    }
    
    public PatternData (int id){
        pattType=null; ////can put another temp text into it for comparison
        pattSelection=",";
        this.id=id;
        
        pattNameList = new ArrayList<String>();
    }
    public String getPattName() {
        return pattName;
    }

    public void setPattName(String pattName) {
        this.pattName = pattName;
    }

    public String getPattType() {
        return pattType;
    }

    public void setPattType(String pattType) {
        this.pattType = pattType;
    }

	public String getPattName2() {
		return pattName2;
	}

	public void setPattName2(String pattName2) {
		this.pattName2 = pattName2;
	}

	public int getUinonOr() {
		return uinonOr;
	}

	public void setUinonOr(int uinonOr) {
		this.uinonOr = uinonOr;
	}

	public int getId() {
		return id;
	}

	public ArrayList<String> getPattNameList() {
		return pattNameList;
	}
 
}
