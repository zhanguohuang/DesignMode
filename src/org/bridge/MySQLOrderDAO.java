package org.bridge;

public class MySQLOrderDAO extends OrderDAO {

	@Override
	public boolean saveOrder(Order order) {
		if(order instanceof WholesaleOrder){
			System.out.println("��������" + order.getOrderID() + "����MySQL���ݿ�");
		}else if(order instanceof RetailOrder){
			System.out.println("���۶���" + order.getOrderID() + "����MySQL���ݿ�");
		}
		return true;
	}

}