package org.adapter.newclass;
//����������(��̬���)�Ƽ��ж������������߾ۺϣ��ټ̳�
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
		//д����
	}
}