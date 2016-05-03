package org.composite;

public class CompositeTest {

	public static void main(String[] args) {
		//创建一级节点
		Composite root = new Composite1("1");
		//创建二级节点
		Composite c21 = new Composite1("21");
		Composite c22 = new Composite1("22");
		Composite c23 = new Composite2("23");
		root.addCIF(c21);
		root.addCIF(c22);
		root.addCIF(c23);
		//创建三级子节点，并添加到二级节点
		Composite c31 = new Composite1("31");
		Composite c32 = new Composite2("32");
		Composite c33 = new Composite2("33");
		
		c21.addCIF(c32);
		c22.addCIF(c31);
		c22.addCIF(c33);
		//调用根节点的方法
		root.work("");
		System.out.println("\n");
		c21.work("");
		System.out.println("\n");
		c22.work("");
		System.out.println("\n");
		c23.work("");
		System.out.println("\n");
	}

}
