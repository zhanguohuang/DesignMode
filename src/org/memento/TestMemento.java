/**
 * ����ģʽ������һ����������һ����������Ա���������һ����Ҫ���������ñ�������
 * �ָ�֮ǰ��Ҫ�Ķ���
 */

package org.memento;

import java.util.Hashtable;

//���屨������
class ReportM{
	private String dep;//����
	private int cost;//�ɱ�
	private String month;//����
	
	public ReportM(String dep, String month, int cost){
		this.dep = dep;
		this.month = month;
		this.cost = cost;
	}
	public void business(){
		this.dep = "";
		this.month = "";
		this.cost = 0;
		System.out.println("����ҵ����");
	}
	public MementoReport1 getMementoReport1(){
		return new MementoReport1("report1", dep, month, cost);
	}
	public void setMementoReport1(MementoReport1 mr){
		dep = mr.getDep();
		month = mr.getMonth();
		cost = mr.getCost();
	}
	public String getState(){
		return new String("����״̬�� dep="+dep+",month="+month+",cost="+cost);
	}
}

class MementoReport1{
	private String key;
	private String dep;
	private int cost;
	private String month;
	public MementoReport1(String key, String dep, String month, int cost){
		this.key = key;
		this.dep = dep;
		this.month = month;
		this.cost = cost;
	}
	public String getDep(){
		return this.dep;
	}
	public String getMonth(){
		return this.month;
	}
	public int getCost(){
		return this.cost;
	}
	public String getKey(){
		return this.key;
	}
	public ReportM createReportM(){
		return new ReportM(dep, month, cost);
	}	
}

class MementoList{
	private Hashtable mementos = new Hashtable();
	public void addMemento(String key, Object mem){
		mementos.put(key, mem);
	}
	public Object getMemento(String key){
		return mementos.get(key);
	}
}

public class TestMemento {
	public static void main(String[] args) {
		ReportM rm = new ReportM("������", "2007/5", 100);
		System.out.println(rm.getState());
		MementoReport1 mr1 = rm.getMementoReport1();
		String mr1key = mr1.getKey();
		
		MementoList ml = new MementoList();
		ml.addMemento(mr1key, mr1);
		
		rm.business();
		System.out.println(rm.getState());
		rm = ((MementoReport1)ml.getMemento(mr1key)).createReportM();
		System.out.println(rm.getState());
	}
}