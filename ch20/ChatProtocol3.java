package ch20;

public class ChatProtocol3 {
	
	//(C->S) ID:aaa 
	//(S->C) CHATLIST:aaa;bbb;ccc;ȫ�浿;
	public final static String ID = "ID";
	
	//(C->S) CHAT:�޴¾��̵�;ä�ó���
	//(S->C) CHAT:�������̵�;ä�ó���
	public final static String CHAT = "CHAT";
	
	//(C->S) CHATALL:ä�ó���
	//(S->C) CHATALL:[�������̵�] ä�ó���
	public final static String CHATALL = "CHATALL";
	
	//(C->S) MESSAGE:�޴¾��̵�;��������
	//(S->C) MESSAGE:�������̵�;��������
	public final static String MESSAGE = "MESSAGE";
	
	//(S->C) CHATLIST:aaa;bbb;ccc;ȫ�浿;
	public final static String CHATLIST = "CHATLIST";
	
}






