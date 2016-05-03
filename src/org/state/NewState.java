/**
 * ״̬ģʽ����״̬ģʽ���������ؼ���Ҫ�أ�״̬����Ϊ��
 * ״̬���Դ�����Ϊ����Ϊ�ܹ�����״̬�ĸı�
 * �����ĸ���������4��״̬
 */

package org.state;

import java.util.Random;

abstract class AgentState{
	//����
	public abstract void comeCall(Agent1 agent);
	//ժ��
	public abstract void offhook(Agent1 agent);
	//�һ�
	public abstract void onhook(Agent1 agent);
	//�Է�ժ��
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
		System.out.println("�����е绰����ϯ����");
	}
	public void lineOffhook(Agent1 agent){
		
	}
	public void offhook(Agent1 agent){
		agent.setAgentState(new DialingState());
		System.out.println("ժ�������Ŵ�绰");
	}
	public void onhook(Agent1 agent1){
		
	}
}

class TalkingState extends AgentState{
	public void comeCall(Agent1 agent){
		agent.setAgentState(new WaitingState());
		System.out.println("֪ͨ�������һ�");
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
		System.out.println("ժ���������绰");
	}
	public void onhook(Agent1 agent){
		agent.setAgentState(new WaitingState());
		System.out.println("���磬ֱ�ӹһ�");
	}
}

class DialingState extends AgentState{
	public void comeCall(Agent1 agent){
		
	}
	public void lineOffhook(Agent1 agent){
		agent.setAgentState(new TalkingState());
		System.out.println("�Է�ժ����ͨ��");
	}
	public void offhook(Agent1 agent){
		
	}
	public void onhook(Agent1 agent){
		agent.setAgentState(new WaitingState());
		System.out.println("���ţ�δ��ͨ���һ�");
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