//适配器模式把一个类的接口变换成客户端所期待的另一种接口，
//从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作
//类的适配器模式 (静态定义的方法)
//Adapter extends Adapter implements Target
package org.adapter.extend;


public class Adapter extends Adaptee implements Target {

	@Override
	public void sampleOperation2() {
		//覆写这个方法
	}
}
