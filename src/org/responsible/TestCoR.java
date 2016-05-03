package org.responsible;

public class TestCoR{
	public static void main(String[] args) {
		Message msg0 = new Message("测试消息", "13900000000");
		Message msg1 = new Message("盗版光盘", "13900000000");
		Message msg2 = new Message("测试消息00000000000000000000", "13900000000");
		Message msg3 = new Message("测试消息1", "13500000000");
		//构造责任链
		MsgFilter msgfilters = new WordFilter(new LengthFilter(new BlackFilter(null)));
		//过滤消息
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