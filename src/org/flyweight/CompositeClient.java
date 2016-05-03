package org.flyweight;

import java.util.ArrayList;
import java.util.List;

public class CompositeClient {

	public static void main(String[] args) {
		List<Character> compositeState = new ArrayList<Character>();
		compositeState.add('a');
		compositeState.add('b');
		compositeState.add('c');
		compositeState.add('a');
		compositeState.add('b');
		
		CompositeFlyweightFactory compositeFactory = new CompositeFlyweightFactory();
		Flyweight compositeFly1 = compositeFactory.factory(compositeState);
		Flyweight compositeFly2 = compositeFactory.factory(compositeState);
		compositeFly1.operation("Composite Call");
		
		System.out.println("-------------------");
		System.out.println("复合享元模式是否可以共享：" + (compositeFly1 == compositeFly2));
		
		Character state = 'a';
		Flyweight fly1 = compositeFactory.factory(state);
		Flyweight fly2 = compositeFactory.factory(state);
		System.out.println("单纯享元模式是否可以共享对象："+(fly1==fly2));
	}

}
