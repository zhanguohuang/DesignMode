//门面模式，充当接待员的角色，就像MVC里的Controller
//面门模式重要的是封装一些类，把不想被知道的方法封装起来
package org.facede;

public class Facade {
	public void test(){
		ModuleA a = new ModuleA();
		a.testA();
		ModuleB b = new ModuleB();
		b.testB();
		ModuleC c = new ModuleC();
		c.testC();
	}
}
