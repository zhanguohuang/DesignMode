package org.singleton;

public class Hunger {
	private static Hunger instance = new Hunger();
	private Hunger(){};
	public static Hunger getInstance(){
		return instance;
	}
}

/*
 * 饿汉模式
 * 达到了线程安全，效率也OK的效果
 * 
 * 缺点：Instance在一开始就已经装载，没有达到饿汉的效果
 */
