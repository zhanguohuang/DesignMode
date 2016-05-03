package org.singleton;

public class HungerNew {
	private static HungerNew hungerNew = null;
	static{
		hungerNew = new HungerNew();
	}
	private HungerNew(){};
	public static HungerNew getInstance(){
		return hungerNew;
	}
}

/* 
 * ��������ģʽ������������ģʽ���
 * ʹ���˾�̬�������ʵ����hungerNew
 * 
 * ȱ�㣺
 */