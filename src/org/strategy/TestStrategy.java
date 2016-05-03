/**
 * 策略模式是对一项业务功能准备多种处理方式供选择使用
 * 这里使用的例子是客户可以选择输出的是xml还是电子表格文件
 */

package org.strategy;

interface CustomerOut{
	void outFile(Object obj);
}

class XmlCustomerOut implements CustomerOut{
	public void outFile(Object obj){
		System.out.println("输出xml格式的用户列表");
	}
}

class ExcelCustomerOut implements CustomerOut{
	public void outFile(Object obj){
		System.out.println("输出excel格式的用户列表");
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
