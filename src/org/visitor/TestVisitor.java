/**
 * ������ģʽ�����Ǳ�������һ���༯�����ݽṹ�е�����Ԫ��
 */

package org.visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

interface Visitable{
	public void accept(Visitor visitor);
}

interface Visitor{
	public void visitString(StringElement obj);
	public void visitInteger(IntegerElement obj);
	public void visitCollection(Collection collection);
}

class StringElement implements Visitable{
	private String value;
	public StringElement(String value){
		this.value = value;
	}
	public String getValue(){
		return value;
	}
	public void accept(Visitor visitor){
		visitor.visitString(this);
	}
}

class IntegerElement implements Visitable{
	private int value;
	public IntegerElement(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
	public void accept(Visitor visitor){
		visitor.visitInteger(this);
	}
}

class ConcreteVisitor implements Visitor{
	public void visitCollection(Collection collection){
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()){
			Object o = iterator.next();
			if(o instanceof Visitable){
				((Visitable) o).accept(this);
			}
		}
	}
	public void visitString(StringElement obj){
		System.out.println("������'"+obj.getValue()+"'");
	}
	public void visitInteger(IntegerElement obj){
		System.out.println("������'"+obj.getValue()+"'");
	}
	
}

public class TestVisitor {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new StringElement("�ַ�������"));
		list.add(new IntegerElement(1024));
		list.add(new String("xxx"));
		Visitor visitor = new ConcreteVisitor();
		visitor.visitCollection(list);
	}
}