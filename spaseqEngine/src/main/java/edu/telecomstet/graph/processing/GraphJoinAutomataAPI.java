/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecomstet.graph.processing;


import com.jcwhatever.nucleus.collections.MultiBiMap;
import edu.telecom.stet.cep.datastructure.OP;
import edu.telecom.stet.cep.datastructure.SP;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.graph.automata.AutomataState;

import java.util.HashMap;

/**
 *
 * @author sydgillani
 */
public interface  GraphJoinAutomataAPI {
    public boolean run(Automata automata, DictionaryOpImpl dic,HashMap<Integer, MultiBiMap<SP, OP>> c);
    public void tripleJoin(AutomataState prevState,AutomataState currState, Automata automata,DictionaryOpImpl dic,int id);
    public void complexJoin(AutomataState prevState,AutomataState currState,Automata automata,DictionaryOpImpl dic);
    public void ooComplexBinaryOperation(MultiBiMap<Long, Long> set_1, MultiBiMap<Long, Long> set_2,  MultiBiMap<Long, Long> mergeSet, DictionaryOpImpl dic, String op, int dataType);
    public void ooComplexJoin(MultiBiMap<Long, Long> smaller, MultiBiMap<Long, Long> larger,MultiBiMap<Long, Long> mergeSet,DictionaryOpImpl dic, String Oper,int order, int dataType);
    public void ooComplexInequalityJoin(MultiBiMap<Long, Long> larger, MultiBiMap<Long, Long> smaller,MultiBiMap<Long, Long> mergeSet);
    public void simpleJoin(AutomataState prevState,AutomataState currState,Automata automata, int id);
    public void ssJoin(MultiBiMap<Long, Long> prev, MultiBiMap<Long, Long> curr, MultiBiMap<Long, Long> result);
    
    public void optimisedchainJoin(AutomataState prevState, AutomataState currState, Automata automta);
    public void osJoinOptimised(MultiBiMap<Long, Long> prev, MultiBiMap<Long, Long> curr,MultiBiMap<Long, Long> mergeSet);
    public void soJoinOptimised(MultiBiMap<Long, Long> prev, MultiBiMap<Long, Long> curr, MultiBiMap<Long, Long> mergeSet);
    public void sJoin(MultiBiMap<Long, Long> smaller, MultiBiMap<Long, Long> larger, MultiBiMap<Long, Long> mergedSet,int pref);
    
    public void ooEqualJoin(MultiBiMap<Long, Long> set_1, MultiBiMap<Long, Long> set_2, MultiBiMap<Long, Long> mergeSet);
    public void kbJoin(AutomataState currState);
    public void ssKbJoin(MultiBiMap<Long, Long> set_1, MultiBiMap<Long, Long> kbset_2, MultiBiMap<Long, Long> mergeSet);
    public void osKbJoin(MultiBiMap<Long, Long> set_1, MultiBiMap<Long, Long> kbset_2, MultiBiMap<Long, Long> mergeSet);
    
    
}
