/**
 * ����ģʽ�Ƕ�һ��ҵ����׼�����ִ�����ʽ��ѡ��ʹ��
 * ����ʹ�õ������ǿͻ�����ѡ���������xml���ǵ��ӱ����ļ�
 */

package org.strategy;

interface CustomerOut{
	void outFile(Object obj);
}

class XmlCustomerOut implements CustomerOut{
	public void outFile(Object obj){
		System.out.println("���xml��ʽ���û��б�");
	}
}

class ExcelCustomerOut implements CustomerOut{
	public void outFile(Object obj){
		System.out.println("���excel��ʽ���û��б�");
	}
}

class CustomerOutFile{
	private CustomerOut strategy;
	public CustomerOutFile(CustomerOut strategy){
		this.strategy = strategy;
	}
	
	public void outFile(Object obj){
		strategy.outFile(obj);
	}
}

public class TestStrategy {
	public static void main(String[] args) {
		CustomerOutFile xmlOut = new CustomerOutFile(new XmlCustomerOut());
		CustomerOutFile excelOut = new CustomerOutFile(new ExcelCustomerOut());
		xmlOut.outFile(null);
		excelOut.outFile(null);
	}
}