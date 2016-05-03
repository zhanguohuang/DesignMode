package org.factory;

public class Test {
	public static void main(String args[]){
		Fruit fruit = (Fruit)FruitFactory.createFruit("apple");
		fruit.eat();
	}
}
