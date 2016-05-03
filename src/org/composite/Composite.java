//�ϳ�ģʽ
//�������и��ṹ�е�һ���ڵ�ķ���ʱ�����������ڵ�������ӽڵ㣬�������Ƶĵݹ鷽ʽ
//������Щ�ӽڵ��ͬ���ķ��������ӽڵ��Ҷ�ӽڵ�
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