package org.responsible;

class Message {
	
	//消息内容
	private String content;
	//目标手机号
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

//定义过滤器抽象类
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

//定义关键词过滤器(模拟)
class WordFilter extends MsgFilter{
	public WordFilter(MsgFilter nextFilter){
		this.nextFilter = nextFilter;
	}
	
	public boolean execute(Message msg){
		if(msg.getContent().indexOf("盗版光盘") >= 0){
			System.out.println(msg.getContent() + ",没通过关键词过滤");
			return true;
		}
		System.out.println(msg.getContent() + ",通过了关键词过滤");
		return false;
	}
}

class LengthFilter extends MsgFilter{
	public LengthFilter(MsgFilter nextFilter){
		this.nextFilter = nextFilter;
	}
	
	public boolean execute(Message msg){
		if(msg.getContent().length() > 14){
			System.out.println(msg.getContent() + ",没通过短信长短过滤");
			return true;
		}
		System.out.println(msg.getContent() + ",通过了短信长短过滤");
		return false;
		
	}
}

class BlackFilter extends MsgFilter{
	public BlackFilter(MsgFilter nextFilter){
		this.nextFilter = nextFilter;
	}
	
	public boolean execute(Message msg){
		if(msg.getDestTerminalId().equals("13500000000")){
			System.out.println(msg.getContent() + ",没通过黑名单过滤");
			return true;
		}
		System.out.println(msg.getContent() + ",通过了黑名单过滤");
		return false;
	}
}


