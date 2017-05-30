package org.semanticweb.yars.nx;

import java.util.HashMap;

public class Mappings {

	HashMap<String,Integer> map;
	
	
	public Mappings(){
		
		
		map = new HashMap<>(); // 0: int, 1: float, 2: decimal, 3: DataTime, 4: Double, 5: string, 6: Long
		map.put("<http://www.w3.org/2001/XMLSchema#dateTime>", 3);
		map.put("<http://www.w3.org/2001/XMLSchema#integer>", 0);
		map.put("<http://www.w3.org/2001/XMLSchema#double>", 4);
		map.put("<http://www.w3.org/2001/XMLSchema#float>", 1);
		map.put("<http://www.w3.org/2001/XMLSchema#string>", 5);
		map.put("<http://www.w3.org/2001/XMLSchema#long>", 6);
		map.put("<http://www.w3.org/2001/XMLSchema#decimal>", 2);		
	}


	public HashMap<String, Integer> getMap() {
		return map;
	}


	public void setMap(HashMap<String, Integer> map) {
		this.map = map;
	}
	
	
}
