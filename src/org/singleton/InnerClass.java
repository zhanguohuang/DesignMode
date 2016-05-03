package org.singleton;

public class InnerClass {
	private InnerClass(){};
	private static class Inner{
		private static final InnerClass instance = new InnerClass();
	}
	public static final InnerClass getInstance(){
		return Inner.instance;
	}
}

/* 
 * 静态内部类
 * 利用了classload机制来保证只有一个线程
 * 
 * 优点：InnerClass在被装载时也不会实例化instance,有延迟加载的效果
 * 如果instance很消耗资源，那用中个就非常的好
 * final关键字是保证此instance只有一个
 */ 
