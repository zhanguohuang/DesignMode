package org.responsible;

public class TestCoR{
	public static void main(String[] args) {
		Message msg0 = new Message("������Ϣ", "13900000000");
		Message msg1 = new Message("�������", "13900000000");
		Message msg2 = new Message("������Ϣ00000000000000000000", "13900000000");
		Message msg3 = new Message("������Ϣ1", "13500000000");
		//����������
		MsgFilter msgfilters = new WordFilter(new LengthFilter(new BlackFilter(null)));
		//������Ϣ
		msgfilters.handleMsg(msg0);
		System.out.print("\n");
		
		msgfilters.handleMsg(msg1);
		System.out.print("\n");
		
		msgfilters.handleMsg(msg2);
		System.out.print("\n");
		
		msgfilters.handleMsg(msg3);
		System.out.print("\n");
	}
}