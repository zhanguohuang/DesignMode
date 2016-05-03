/** 
 * ����ģʽ���ǽ��ͻ��˵������װ��������������У�Ȼ�����ִ��
 * �����ڽ���
 */

package org.commond;

import java.util.ArrayList;
import java.util.List;

//��������ӿ�
interface Command{
	void execute(Object obj);
}
//��־����
class LogCommand implements Command{
	public void execute(Object obj){
		System.out.println("ִ������־����");
	}
}
//������¼����
class OrderCommand implements Command{
	public void execute(Object obj){
		System.out.println("ִ���˶�����¼����");
	}
}
//������������
class HandleCommand implements Command{
	public void execute(Object obj){
		System.out.println("ִ���˶�����������");
	}
}
//����ҵ������
class OrderBusiness implements Command{
	private List commandList = new ArrayList();
	public OrderBusiness(){
		commandList.add(new LogCommand());
		commandList.add(new OrderCommand());
		commandList.add(new HandleCommand());
	}
	public void execute(Object obj){
		for(int i=0;i<commandList.size();i++){
			((Command)commandList.get(i)).execute(obj);
		}
	}
}