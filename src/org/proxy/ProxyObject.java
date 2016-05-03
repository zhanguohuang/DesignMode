package org.proxy;

public class ProxyObject extends AbstractObject {
	RealObject realObject = new RealObject();
	@Override
	public void operation() {
		System.out.println("before");
		realObject.operation();
		System.out.println("after");
	}
	public static void main(String[] args){
		AbstractObject abstractObject = new ProxyObject();
		abstractObject.operation();
	}
}
