package org.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite1 extends Composite {
	private List childrenList;
	public boolean addCIF(Composite cif){
		return childrenList.add(cif);
	}
	public boolean removeCIF(Composite cif){
		return childrenList.remove(cif);
	}
	public Iterator iter(){
		return childrenList.iterator();
	}
	public Composite1(String name){
		super(name);
		childrenList = new ArrayList();
	}
	@Override
	public void work(String str) {
		System.out.println(str+"/"+getName());
		Iterator iter = iter();
		while(iter.hasNext()){
			((Composite)(iter.next())).work(str+"/"+getName());
		}
	}

}
