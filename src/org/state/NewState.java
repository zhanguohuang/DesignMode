/**
 * 状态模式，在状态模式中有两个关键的要素，状态和行为。
 * 状态可以触发行为，行为能够导致状态的改变
 * 用了四个类来保存4个状态
 */

package org.state;

import java.util.Random;

abstract class AgentState{
	//来话
	public abstract void comeCall(Agent1 agent);
	//摘机
	public abstract void offhook(Agent1 agent);
	//挂机
	public abstract void onhook(Agent1 agent);
	//对方摘机
	public abstract void lineOffhook(Agent1 agent);
}

class Agent1{
	private AgentState agentState;
	public Agent1(){
		this.agentState = new WaitingState();
	}
	public void setAgentState(AgentState agentState){
		this.agentState = agentState;
	}
	public void comeCall(){
		agentState.comeCall(this);
	}
	public void offhook(){
		agentState.offhook(this);
	}
	public void onhook(){
		agentState.onhook(this);
	}
	public void lineOffhook(){
		agentState.lineOffhook(this);
	}
}

class WaitingState extends AgentState{
	public void comeCall(Agent1 agent){
		agent.setAgentState(new RingingState());
		System.out.println("外线有电话，坐席振铃");
	}
	public void lineOffhook(Agent1 agent){
		
	}
	public void offhook(Agent1 agent){
		agent.setAgentState(new DialingState());
		System.out.println("摘机，拨号打电话");
	}
	public void onhook(Agent1 agent1){
		
	}
}

class TalkingState extends AgentState{
	public void comeCall(Agent1 agent){
		agent.setAgentState(new WaitingState());
		System.out.println("通知结束，挂机");
	}
	public void lineOffhook(Agent1 agent){
		
	}
	public void offhook(Agent1 agent){
		
	}
	public void onhook(Agent1 agent){
		
	}
}

class RingingState extends AgentState{
	public void comeCall(Agent1 agent){
		
	}
	public void lineOffhook(Agent1 agent){
		
	}
	public void offhook(Agent1 agent){
		agent.setAgentState(new TalkingState());
		System.out.println("摘机，接听电话");
	}
	public void onhook(Agent1 agent){
		agent.setAgentState(new WaitingState());
		System.out.println("来电，直接挂机");
	}
}

class DialingState extends AgentState{
	public void comeCall(Agent1 agent){
		
	}
	public void lineOffhook(Agent1 agent){
		agent.setAgentState(new TalkingState());
		System.out.println("对方摘机，通话");
	}
	public void offhook(Agent1 agent){
		
	}
	public void onhook(Agent1 agent){
		agent.setAgentState(new WaitingState());
		System.out.println("拨号，未接通，挂机");
	}
}

public class NewState {
	public static void main(String[] args) {
		Agent1 agent = new Agent1();
		for(int i=0;i<100;i++){
			switch(Math.abs(new Random().nextInt())%4){
			case 0:
				agent.comeCall();
				break;
			
			case 1:
				agent.lineOffhook();
				break;
			case 2:
				agent.offhook();
				break;
			case 3:
				agent.onhook();
				break;
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
