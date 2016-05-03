package org.flyweight;

public class ConcreteFlyweight implements Flyweight {

	//�ڲ�״̬
	private Character intrinsicState = null;
	
	//���췽���洢�ڲ�״̬
	public ConcreteFlyweight(Character state){
		this.intrinsicState = state;
	}
	
	/**
     * �ⲿ״̬��Ϊ�������뷽���У��ı䷽������Ϊ
     * ���ǲ����ı������ڲ�״̬��
     */
	@Override
	public void operation(String state) {
		System.out.println("IntrinsicState = " + this.intrinsicState);
		System.out.println("Extrinsic = " + state);
		
	}

}