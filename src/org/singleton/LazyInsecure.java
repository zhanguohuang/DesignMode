package org.singleton;

public class LazyInsecure {
	private LazyInsecure(){};
	private static LazyInsecure instance;
	public static LazyInsecure getInstance(){
		if(instance == null){
			instance = new LazyInsecure();
		}
		return instance;
	}
	
}
/*
 * 懒汉模式
 * 线程不安全
 * 静态方法只能调用静态属性
 * 
 * 缺点：多线程下不能正常工作
 */
