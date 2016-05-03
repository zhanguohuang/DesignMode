package org.singleton;

public class HungerNew {
	private static HungerNew hungerNew = null;
	static{
		hungerNew = new HungerNew();
	}
	private HungerNew(){};
	public static HungerNew getInstance(){
		return hungerNew;
	}
}

/* 
 * 饿汉变种模式，基本跟饿汉模式差不多
 * 使用了静态代码块来实例化hungerNew
 * 
 * 缺点：
 */
