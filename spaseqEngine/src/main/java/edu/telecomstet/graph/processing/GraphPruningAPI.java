/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.graph.processing;

import java.util.Map;

import com.jcwhatever.nucleus.collections.MultiBiMap;

import edu.telecom.stet.cep.datastructure.KBindex;
import edu.telecom.stet.cep.datastructure.MultiBidirectionalIndex;
import edu.telecom.stet.cep.datastructure.RunStateMap;
import edu.telecom.stet.cep.datastructure.SP;
import edu.telecom.stet.cep.events.GraphEvent;
import edu.telecom.stet.cep.events.MappedEvent;
import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.graph.automata.Automata;
import edu.telecomstet.cep.rulesmodel.Rule;

/**
 *
 * @author sydgillani
 */
public interface GraphPruningAPI {
	public boolean run(Automata automata, GraphEvent inputGraph, DictionaryOpImpl dic,
			Map<RunStateMap, MultiBidirectionalIndex> c, Map<KBindex, MultiBiMap<Long, SP>> kb, int r, int s);

	public boolean pushAtomicFilter(Rule r, MappedEvent e, DictionaryOpImpl dic);

	public boolean atomicFilterCompariosn(Rule r, MappedEvent e, DictionaryOpImpl dic);

}
