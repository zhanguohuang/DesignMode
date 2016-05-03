/**
 * 用一个中介者对象封装一系列对象交互，中介者使对象不需要显示的相互作用
 * 从而使耦合松散，而且可以独立的改变他们的交互
 */

package org.mediator;

abstract class AbstractColleague{
	protected int number;
	public int getNumber(){
		return number;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public abstract void setNumber(int number, AbstractMediator am);
}

class ColleagueA extends AbstractColleague{
	public void setNumber(int number, AbstractMediator am){
		this.number = number;
		am.AaffectB();
	}
}

class ColleagueB extends AbstractColleague{
	public void setNumber(int number, AbstractMediator am){
		this.number = number;
		am.BaffectA();
	}
}

abstract class AbstractMediator{
	protected AbstractColleague A;
	protected AbstractColleague B;
	
	public AbstractMediator(AbstractColleague a, AbstractColleague b){
		A = a;
		B = b;
	}
	public abstract void AaffectB();
	public abstract void BaffectA();
}

class Mediator extends AbstractMediator{
	public Mediator(AbstractColleague a, AbstractColleague b){
		super(a, b);
	}
	
	public void AaffectB(){
		int number = A.getNumber();
		B.setNumber(number*100);
	}
	public void BaffectA(){
		int number = B.getNumber();
		A.setNumber(number/100);
	}
}

public class Client {

	public static void main(String[] args) {
	
		AbstractColleague collA = new ColleagueA();  
        AbstractColleague collB = new ColleagueB();  
          
        AbstractMediator am = new Mediator(collA, collB);  
          
        System.out.println("==========通过设置A影响B==========");  
        collA.setNumber(1000, am);  
        System.out.println("collA的number值为："+collA.getNumber());  
        System.out.println("collB的number值为A的10倍："+collB.getNumber());  
  
        System.out.println("==========通过设置B影响A==========");  
        collB.setNumber(1000, am);  
        System.out.println("collB的number值为："+collB.getNumber());  
        System.out.println("collA的number值为B的0.1倍："+collA.getNumber());  
	}

}
