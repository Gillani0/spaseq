/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package edu.telecom.stet.cep.events;

import java.util.List;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;

/**
 *
 * @author sydgillani
 */
public class GraphEvent {

	private long id;
	private long timeStamp;
	// private List<Node[]> knowGraph ;
	// private List<MappedEvent> mapE;

	private MappedEvent[] mapped;
	private Long MappedContext;

	// private Random rand = new Random();
	public GraphEvent(int id, long t, DictionaryOpImpl d, long c, MappedEvent[] mp) {
		this.id = id;

		this.mapped = mp;
		timeStamp = t;

		MappedContext = c;

	}

	public GraphEvent(int id, long t, DictionaryOpImpl d, long c, List<MappedEvent> mp) {
		this.id = id;

		// System.nanoTime()+100000000;
		// long tAdd = ( rand.nextInt((900 - 500) + 1) + 500)*100000000;

		this.mapped = mp.toArray(new MappedEvent[mp.size()]);
		timeStamp = t + 1000000000;
		// mapE=g;
		MappedContext = c;// d.addResourceAdaptive(new Resource(c,true));

		// mapE=new ArrayList<MappedEvent> ();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getMappedContext() {
		return MappedContext;
	}

	public MappedEvent[] getMapped() {
		return mapped;
	}

	public void setMapped(MappedEvent[] mapped) {
		this.mapped = mapped;
	}
}
