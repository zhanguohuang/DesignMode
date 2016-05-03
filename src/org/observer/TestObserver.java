/**
 * �۲���ģʽ���൱�ڴ���������Ҫʵ��java.util.Observable�ӿ�
 * ��Ҫ֪ͨʱ����notifyObservers֪ͨ�۲���
 */

package org.observer;

import java.util.Observable;
import java.util.Observer;

//���嶩����
class Order1{
	private int iOrderID;
	public Order1(){
		iOrderID = Math.abs(new java.util.Random().nextInt());
		
	}
	public int getOrderID(){
		return this.iOrderID;
	}
}

//���嶩��������
class OrderHandle extends Observable{
	public void handleOrder(Order1 order){
		System.out.println("�����˶���" + order.getOrderID());
		//֪ͨ�۲���
		setChanged();
		notifyObservers(order);
	}
}

//����һ���۲��ߣ�֪ͨҵ����Ա��������
class OrderObserver1 implements Observer{
	public void update(Observable arg0, Object arg1){
		System.out.println("֪ͨҵ����Ա����������������Ϊ" + ((Order1)arg1).getOrderID());
	}
}

//��������һ���۲��ߣ�֪ͨ������ϵͳ�޸���Ʒ���
class OrderObserver2 implements Observer{
	public void update(Observable arg0, Object arg1){
		System.out.println("֪ͨ������ϵͳ�޸���Ʒ��棬������Ϊ" + ((Order1)arg1).getOrderID());
	}
}

public class TestObserver {
	public static void main(String[] args) {
		OrderHandle oh = new OrderHandle();
		Observer oo1 = new OrderObserver1();
		Observer oo2 = new OrderObserver2();
		oh.addObserver(oo1);
		oh.addObserver(oo2);
		oh.handleOrder(new Order1());
	}
}