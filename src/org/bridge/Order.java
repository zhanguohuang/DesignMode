package org.bridge;

//ֻ�������е�ʱ���֪�������Ǵ������ĸ����ݿ�
public abstract class Order {
	//����DAO
	OrderDAO dao;
	
	public Order(OrderDAO dao){
		this.dao = dao;
	}
	//���涩��
	public abstract boolean saveOrder();
	//��ö���ID
	public abstract int getOrderID();
}