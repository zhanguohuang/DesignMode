package org.singleton;

public class Hunger {
	private static Hunger instance = new Hunger();
	private Hunger(){};
	public static Hunger getInstance(){
		return instance;
	}
}

/*
 * ����ģʽ
 * �ﵽ���̰߳�ȫ��Ч��ҲOK��Ч��
 * 
 * ȱ�㣺Instance��һ��ʼ���Ѿ�װ�أ�û�дﵽ������Ч��
 */