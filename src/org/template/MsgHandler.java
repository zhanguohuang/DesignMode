/**
 * ��ν��ģ��ģʽ�������ȶ����һ�����������Ϊһ��ģ�壬Ȼ������ȥʵ����
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

//������ģ����
abstract class MsgHandler {
	public abstract void handle(SMOMessage msg);
}

//�����ʵ����
class MsgHandle1 extends MsgHandler{

	@Override
	public void handle(SMOMessage msg) {
		System.out.println("��������Ϣ"+msg.getSmoContent());
	}
	
}