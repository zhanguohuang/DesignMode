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
 * ����ģʽ
 * �̲߳���ȫ
 * ��̬����ֻ�ܵ��þ�̬����
 * 
 * ȱ�㣺���߳��²�����������
 */