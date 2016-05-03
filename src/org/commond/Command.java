/** 
 * 命令模式就是将客户端的请求封装到命令对象数组中，然后调用执行
 * 可用于解耦
 */

package org.commond;

import java.util.ArrayList;
import java.util.List;

//定义命令接口
interface Command{
	void execute(Object obj);
}
//日志命令
class LogCommand implements Command{
	public void execute(Object obj){
		System.out.println("执行了日志命令");
	}
}
//订单记录命令
class OrderCommand implements Command{
	public void execute(Object obj){
		System.out.println("执行了订单记录命令");
	}
}
//订单处理命令
class HandleCommand implements Command{
	public void execute(Object obj){
		System.out.println("执行了订单处理命令");
	}
}
//订单业务处理类
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