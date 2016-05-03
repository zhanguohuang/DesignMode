package org.adapter;
//缺省适配器模式，适用于当类只想实现接口的某一个方法时，利用中间的抽象类来缺省实现
//其他不会用到的方法，而覆写真正需要的方法
public class AbstractAdapter implements Pig{
	public void sleep(){};
	public void eat(){};
}
