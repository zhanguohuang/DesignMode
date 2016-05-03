package org.singleton;

public class LazySecure {
	private LazySecure(){};
	private static LazySecure instance;
	public static synchronized LazySecure getInstance(){
		if(instance == null){
			instance = new LazySecure();
		}
		return instance;
	}
}
/*
 * 懒汉，线程安全
 * 加入synchronized
 * 
 * 缺点是效率低下
 */
