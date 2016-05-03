package org.singleton;

public class InnerClass {
	private InnerClass(){};
	private static class Inner{
		private static final InnerClass instance = new InnerClass();
	}
	public static final InnerClass getInstance(){
		return Inner.instance;
	}
}

/* 
 * ��̬�ڲ���
 * ������classload��������ֻ֤��һ���߳�
 * 
 * �ŵ㣺InnerClass�ڱ�װ��ʱҲ����ʵ����instance,���ӳټ��ص�Ч��
 * ���instance��������Դ�������и��ͷǳ��ĺ�
 * final�ؼ����Ǳ�֤��instanceֻ��һ��
 */ 