package org.flyweight;

public class ConcreteFlyweight implements Flyweight {

	//内部状态
	private Character intrinsicState = null;
	
	//构造方法存储内部状态
	public ConcreteFlyweight(Character state){
		this.intrinsicState = state;
	}
	
	/**
     * 外部状态作为参数传入方法中，改变方法的行为
     * 但是并不改变对象的内部状态。
     */
	@Override
	public void operation(String state) {
		System.out.println("IntrinsicState = " + this.intrinsicState);
		System.out.println("Extrinsic = " + state);
		
	}

}
