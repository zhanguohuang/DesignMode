package org.factory;

public class FruitFactory {
	public static Fruit createFruit(String fruitName){
		if(fruitName == "apple"){
			return new Apple();
		}
		if(fruitName == "orange"){
			return new Orange();
		}else{
			System.out.println("parameter is error");
			return null;
		}
	}

}
