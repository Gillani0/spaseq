/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.rulesmodel;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import org.semanticweb.yars.nx.Resource;


/**
 *
 * @author sydgillani
 */
public class StreamData {
    
    private String streamID;
    private Resource streamURI;
    private Long mappedStreamURI;

 
    private int time;
    private String timeUni;

      
     public StreamData(){
         
              
      }
    public String getStreamID() {
        return streamID;
    }

    public void setStreamID(String streamID) {
        this.streamID = streamID;
    }

    public Resource getStreamURI() {
        return streamURI;
    }

    public void setStreamURI(String streamURI,  DictionaryOpImpl  dictImpl) {
       //streamURI= streamURI.replace("<", "");
          // streamURI = streamURI.replace(">", "");
        
        this.streamURI = new Resource(streamURI,true) ;
        
        this.mappedStreamURI= dictImpl.addResourcePersistant(this.streamURI);
    }

    public int getTime() {
        return time;
    }

    public void setTime(String time) {
        
        this.time = Integer.valueOf(time);
    }

    public String getTimeUni() {
        return timeUni;
    }

    public void setTimeUni(String timeUni) {
        this.timeUni = timeUni;
    }
    
       public Long getMappedStreamURI() {
        return mappedStreamURI;
    }
}
