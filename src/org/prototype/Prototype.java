//原型模式就是考虑如何克隆一个一样的类，但是地址还是不一样的
//相当于new了两个一样的对象
package org.prototype;

public class Prototype implements Cloneable {
	private String name;
	public Prototype(String name){
		this.name = name;
	}
	public Object clone(){
		Object object = null;
		try{
			object = super.clone();//调用了父类的clone来克隆自己本身
		}catch(Exception e){
			e.printStackTrace();
		}
		return object;
	}
	public String toString(){
		return "my name is "+name+".";
	}
	public static void main(String args[]){
		Prototype pt = new Prototype("Messi");
		Prototype pt1 = (Prototype)pt.clone();
		System.out.println(pt);
		System.out.println(pt1);
	}
}
