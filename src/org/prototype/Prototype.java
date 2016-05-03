//ԭ��ģʽ���ǿ�����ο�¡һ��һ�����࣬���ǵ�ַ���ǲ�һ����
//�൱��new������һ���Ķ���
package org.prototype;

public class Prototype implements Cloneable {
	private String name;
	public Prototype(String name){
		this.name = name;
	}
	public Object clone(){
		Object object = null;
		try{
			object = super.clone();//�����˸����clone����¡�Լ�����
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