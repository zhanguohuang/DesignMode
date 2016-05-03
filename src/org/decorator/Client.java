package org.decorator;

public class Client {

	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();
		
		TheGreatestSage bird = new Bird(sage);
		TheGreatestSage fish = new Fish(sage);
		fish.move();
		bird.move();
		//第二中写法
		//TheGreatestSage fish = new Fish(new Bird(sage));
	}

}
