package ch20;

public class ChatProtocol2 {
	
	
	//(C -> S )  ID : aaa
	//(S -> C) CHATLIST : aaa ; bbb;ccc;홍길동;
	public final static String ID = "ID"; 
 
	//(C-> S) CHAT : 받는 아이디 ;채팅내용
	//(S ->C) CHAT : 보낸 아이디 ;채팅내용 
	public final static String CHAT = "CHAT"; 

	//(C ->S) CHATALL: 채팅내용
	//(S ->C) CHATALL: [보낸아이디] 채팅내용	
	public final static String CHATALL = "CHATALL";

	
	
	//(C->S) MESSAGE :받는아이디;쪽지내용
	//(S->C) MESSAGE :보낸아이디;쪽지내용
	public final static String MESSAGE = "MESSAGE";

	//(S->C) CHATLIST: aaa;bbb;ccc;홍길동;
	public final static String CHATLIST = "CHATLIST";









}
