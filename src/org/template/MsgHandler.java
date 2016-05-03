/**
 * 所谓的模板模式，就是先定义好一个抽象的类作为一个模板，然后子类去实现它
 */

package org.template;

class SMOMessage{
	private String smoCode;
	private String smoContent;
	public SMOMessage(String smoCode, String smoContent){
		this.smoCode = smoCode;
		this.smoContent = smoContent;
	}
	public String getSmoCode() {
		return smoCode;
	}
	public void setSmoCode(String smoCode) {
		this.smoCode = smoCode;
	}
	public String getSmoContent() {
		return smoContent;
	}
	public void setSmoContent(String smoContent) {
		this.smoContent = smoContent;
	}
	
}

//处理的模板类
abstract class MsgHandler {
	public abstract void handle(SMOMessage msg);
}

//具体的实现类
class MsgHandle1 extends MsgHandler{

	@Override
	public void handle(SMOMessage msg) {
		System.out.println("处理了消息"+msg.getSmoContent());
	}
	
}
