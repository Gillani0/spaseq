/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.rulesmodel;

/**
 *
 * @author sydgillani
 */
public class WindowTemporalData {
  private final long time;

   
    private final String unit;
    
    public WindowTemporalData(int itime, String iunit){
        time=itime;
        unit=iunit;
    }
    
     public long getTime() {
        return time;
    }

    public String getUnit() {
        return unit;
    }
    
}
