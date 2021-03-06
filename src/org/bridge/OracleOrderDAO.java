package org.bridge;

public class OracleOrderDAO extends OrderDAO {

	@Override
	public boolean saveOrder(Order order) {
		if(order instanceof WholesaleOrder){
			System.out.println("批发订单" + order.getOrderID() + "存入Oracle数据库");
		}else if(order instanceof RetailOrder){
			System.out.println("零售订单" + order.getOrderID() + "存入Oracle数据库");
		}
		return true;
	}

}
