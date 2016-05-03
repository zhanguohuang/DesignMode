/**
 * 观察者模式，相当于触发器，需要实现java.util.Observable接口
 * 需要通知时调用notifyObservers通知观察者
 */

package org.observer;

import java.util.Observable;
import java.util.Observer;

//定义订单类
class Order1{
	private int iOrderID;
	public Order1(){
		iOrderID = Math.abs(new java.util.Random().nextInt());
		
	}
	public int getOrderID(){
		return this.iOrderID;
	}
}

//定义订单处理类
class OrderHandle extends Observable{
	public void handleOrder(Order1 order){
		System.out.println("处理了订单" + order.getOrderID());
		//通知观察者
		setChanged();
		notifyObservers(order);
	}
}

//定义一个观察者，通知业务人员处理订单
class OrderObserver1 implements Observer{
	public void update(Observable arg0, Object arg1){
		System.out.println("通知业务人员处理订单，订单号为" + ((Order1)arg1).getOrderID());
	}
}

//定义另外一个观察者，通知库存管理系统修改商品库存
class OrderObserver2 implements Observer{
	public void update(Observable arg0, Object arg1){
		System.out.println("通知库存管理系统修改商品库存，订单号为" + ((Order1)arg1).getOrderID());
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
