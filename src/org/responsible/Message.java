package org.responsible;

class Message {
	
	//��Ϣ����
	private String content;
	//Ŀ���ֻ���
	private String destTerminalId;
	
	public Message(String content, String destTerminalId){
		this.content = content;
		this.destTerminalId = destTerminalId;
	}
	public String getContent(){
		return this.content;
	}
	public String getDestTerminalId(){
		return this.destTerminalId;
	}
}

//���������������
abstract class MsgFilter{
	protected MsgFilter nextFilter;
	protected abstract boolean execute(Message msg);
	
	public void handleMsg(Message msg){
		boolean over = execute(msg);
		if(!over){
			if(nextFilter != null){
				nextFilter.handleMsg(msg);
			}
		}
	}
}

//����ؼ��ʹ�����(ģ��)
class WordFilter extends MsgFilter{
	public WordFilter(MsgFilter nextFilter){
		this.nextFilter = nextFilter;
	}
	
	public boolean execute(Message msg){
		if(msg.getContent().indexOf("�������") >= 0){
			System.out.println(msg.getContent() + ",ûͨ���ؼ��ʹ���");
			return true;
		}
		System.out.println(msg.getContent() + ",ͨ���˹ؼ��ʹ���");
		return false;
	}
}

class LengthFilter extends MsgFilter{
	public LengthFilter(MsgFilter nextFilter){
		this.nextFilter = nextFilter;
	}
	
	public boolean execute(Message msg){
		if(msg.getContent().length() > 14){
			System.out.println(msg.getContent() + ",ûͨ�����ų��̹���");
			return true;
		}
		System.out.println(msg.getContent() + ",ͨ���˶��ų��̹���");
		return false;
		
	}
}

class BlackFilter extends MsgFilter{
	public BlackFilter(MsgFilter nextFilter){
		this.nextFilter = nextFilter;
	}
	
	public boolean execute(Message msg){
		if(msg.getDestTerminalId().equals("13500000000")){
			System.out.println(msg.getContent() + ",ûͨ������������");
			return true;
		}
		System.out.println(msg.getContent() + ",ͨ���˺���������");
		return false;
	}
}

