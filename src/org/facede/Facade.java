//����ģʽ���䵱�Ӵ�Ա�Ľ�ɫ������MVC���Controller
//����ģʽ��Ҫ���Ƿ�װһЩ�࣬�Ѳ��뱻֪���ķ�����װ����
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