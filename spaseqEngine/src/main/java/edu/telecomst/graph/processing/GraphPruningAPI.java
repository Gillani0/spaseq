/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomst.graph.processing;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.rulesmodel.Rule;

import java.util.HashMap;
import java.util.Map;

import com.jcwhatever.nucleus.collections.MultiBiMap;

/**
 *
 * @author sydgillani
 */
public interface GraphPruningAPI {
    public boolean run(Automata automata,GraphEvent inputGraph,DictionaryOpImpl dic,Map<RunStateMap,MultiBidirectionalIndex> c,Map<KBindex, MultiBiMap<Long,SP>> kb,int r,int s);
    public boolean pushAtomicFilter(Rule r,MappedEvent e,DictionaryOpImpl dic);
    public boolean atomicFilterCompariosn(Rule r, MappedEvent e,DictionaryOpImpl dic);
    
}
