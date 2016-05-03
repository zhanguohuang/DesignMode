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
 * 双重锁模式
 * jdk1.5后才有效果
 */
