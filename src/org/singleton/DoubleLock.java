package org.singleton;

public class DoubleLock {
	private DoubleLock(){};
	private volatile static DoubleLock instance;
	public static DoubleLock getInstance(){
		if(instance == null){
			synchronized(DoubleLock.class){
				if(instance == null){
					instance = new DoubleLock();
				}
			}
		}
		return instance;
	}
}
/* 
 * ˫����ģʽ
 * jdk1.5�����Ч��
 */