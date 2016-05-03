package org.bridge;

public class WholesaleOrder extends Order {

	private int iOrderID;
	
	public WholesaleOrder(OrderDAO dao){
		super(dao);
		iOrderID = Math.abs(new java.util.Random().nextInt());
	}
	@Override
	public boolean saveOrder() {
		
		return dao.saveOrder(this);
	}

	@Override
	public int getOrderID() {
		
		return iOrderID;
	}

}
