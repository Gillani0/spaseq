/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecom.stet.cep.events;

import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;

/**
 *
 * @author sydgillani
 */
public class GraphTriple {

	private MappedEvent mappedEvent;

	public GraphTriple(Node[] itriple, DictionaryOpImpl dicimpl) {

		this.dictionayMapping(itriple, dicimpl);

	}

	private void dictionayMapping(Node[] triple, DictionaryOpImpl dic) {
		mappedEvent = new MappedEvent();

		if (triple[0] instanceof BNode) {
			mappedEvent.setSubject(dic.addBnodeAdaptive((BNode) triple[0]));
		} else {
			mappedEvent.setSubject(dic.addResourceAdaptive((Resource) triple[0]));
		}
		// System.out.println(mappedEvent.getSubject());
		mappedEvent.setProperties(dic.addResourceAdaptive((Resource) triple[1]));
		if (triple[2] instanceof Resource) {
			mappedEvent.setObject(dic.addResourceAdaptive((Resource) triple[2]));
		} else if (triple[2] instanceof BNode) {
			mappedEvent.setObject(dic.addBnodeAdaptive((BNode) triple[2]));
		} else {
			mappedEvent.setObject(dic.addLiteralAdaptive((Literal) triple[2]));
			mappedEvent.setObjectDataType(((Literal) triple[2]).getType());
		}
	}

	public MappedEvent getMappedEvent() {
		return mappedEvent;
	}

	public void setMappedEvent(MappedEvent mappedEvent) {
		this.mappedEvent = mappedEvent;
	}
}
