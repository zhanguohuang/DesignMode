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
 * �������̰߳�ȫ
 * ����synchronized
 * 
 * ȱ����Ч�ʵ���
 */