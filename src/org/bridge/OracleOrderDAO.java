package org.bridge;

public class OracleOrderDAO extends OrderDAO {

	@Override
	public boolean saveOrder(Order order) {
		if(order instanceof WholesaleOrder){
			System.out.println("��������" + order.getOrderID() + "����Oracle���ݿ�");
		}else if(order instanceof RetailOrder){
			System.out.println("���۶���" + order.getOrderID() + "����Oracle���ݿ�");
		}
		return true;
	}

}