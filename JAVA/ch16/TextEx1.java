package ch16;

import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx1 extends MFrame implements ActionListener{
	
	TextField tf1, tf2;
	TextArea ta; //필드로 선언한 목적: 메소드 공유 
	
	public TextEx1() {
		super(250,300);
		setTitle("Text Exapmple");
		add(new Label("성명"));
		add(tf1 = new TextField("홍길동",20));
		add(new Label("암호"));
		add(tf2 = new TextField(20));
		tf2.setEchoChar('#');
		add(ta = new TextArea(10, 30));
		ta.setEditable(false);//편집불가
		tf2.addActionListener(this);//act이벤트랑 tf2랑 연결.
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//tf2에 입력후에 Enter를 하면 실행이 되는 것
		ta.append(tf1.getText()+"/"+tf2.getText()+"\n");
		tf1.setText("");
		tf2.setText("");
		//입력 포커스를 tf1으로 보낸다 
		tf1.requestFocus();
	}
	public static void main(String[] args) {
		new TextEx1();
	}
}


