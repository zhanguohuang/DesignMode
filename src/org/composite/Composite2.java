package org.composite;

public class Composite2 extends Composite {
	public Composite2(String name){
		super(name);
	}
	@Override
	public void work(String str) {
		System.out.println(str+"/"+getName()+"\n");
	}
}
