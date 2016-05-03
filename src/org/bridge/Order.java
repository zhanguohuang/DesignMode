package org.bridge;

//只有在运行的时候才知道到底是存入了哪个数据库
public abstract class Order {
	//引用DAO
	OrderDAO dao;
	
	public Order(OrderDAO dao){
		this.dao = dao;
	}
	//保存订单
	public abstract boolean saveOrder();
	//获得订单ID
	public abstract int getOrderID();
}
