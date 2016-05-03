//合成模式
//当调用中个结构中的一个节点的方法时，会遍历这个节点的所有子节点，按照类似的递归方式
//调用这些子节点的同样的方法，分子节点和叶子节点
package org.composite;

import java.util.Iterator;

public abstract class Composite {
	private String strName;
	public boolean addCIF(Composite cif){
		return false;
	}
	public boolean removeCIF(Composite cif){
		return false;
	}
	public Iterator iter(){
		return null;
	}
	public String getName(){
		return strName;
	}
	public Composite(String name){
		this.strName = name;
	}
	
	public abstract void work(String str);
}
