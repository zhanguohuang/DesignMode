package org.bridge;

public class TestOrder {

	public static void main(String[] args) {
		OrderDAO oracle = new OracleOrderDAO();
		OrderDAO mysql = new MySQLOrderDAO();
		
		Order wo1 = new WholesaleOrder(oracle);
		wo1.saveOrder();
		Order wo2 = new WholesaleOrder(mysql);
		wo2.saveOrder();
		Order ro1 = new RetailOrder(oracle);
		ro1.saveOrder();
		Order ro2 = new RetailOrder(mysql);
		ro2.saveOrder();
	}

}
