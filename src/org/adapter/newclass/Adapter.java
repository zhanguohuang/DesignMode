package org.adapter.newclass;
//对象适配器(动态组合)推荐中对象适配器，高聚合，少继承
//private Adaptee adaptee;
public class Adapter implements Target {
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	public void sampleOperation1(){
		this.adaptee.sampleOperation1();
	}
	@Override
	public void sampleOperation2(){
		//写方法
	}
}
