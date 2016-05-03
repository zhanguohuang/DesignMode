package org.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeFlyweightFactory {

	private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
	
	public Flyweight factory(List<Character> compositeState){
		ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
		
		for(Character state : compositeState){
			compositeFly.add(state, this.factory(state));
		}
		return compositeFly;
	}
	
	public Flyweight factory(Character state){
		Flyweight fly = files.get(state);
		if(fly == null){
			fly = new ConcreteFlyweight(state);
			files.put(state, fly);
		}
		return fly;
	}
}
