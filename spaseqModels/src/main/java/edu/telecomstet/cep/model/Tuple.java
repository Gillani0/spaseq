
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package edu.telecomstet.cep.model;

//~--- non-JDK imports --------------------------------------------------------

import edu.telecomstet.cep.dictionary.junkYard.DictionaryImpl;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;




/**
 *
 * @author sydgillani
 */
public abstract class Tuple {
    public abstract boolean setValueTypePersistance(String edgeValue, DictionaryOpImpl dictImpl);

    public abstract void setValue(String value, DictionaryOpImpl dictImpl);
   public abstract void setSimpleValue(Object value);

    public abstract Object getValue();


    public abstract void setProjection(String projection);

    public abstract String getProjection();

    public abstract void setIsProjection(boolean projection);

    public abstract boolean isProjection();

    public abstract void setMappedValue(Long mappedValue);

    public abstract Long getMappedValue();

    @Override
    public String toString() {
        return "Value= " + this.getValue() + ", MappedValue= " + this.getMappedValue() + ", Projection= "
               + this.getProjection() + ", Porjection Status= " + this.isProjection();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
