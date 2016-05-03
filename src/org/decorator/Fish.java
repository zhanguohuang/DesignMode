package org.decorator;

public class Fish extends Change {
	public Fish(TheGreatestSage sage){
		super(sage);
	}
	public void move(){
		System.out.println("Fish move");
	}
}
