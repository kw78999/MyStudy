package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class DesignEx2_2 extends MFrame{

	TextField tf;
	TextArea ta;
	Button btn1, btn2;
	Panel p1, p2,p3;
	
	public DesignEx2_2() {
		super(500,400);
		setTitle("������ ����2");
		setResizable(false);
		setLayout(new BorderLayout());
		p1 = new Panel();
		p1.add(tf = new TextField("Hello",35));
	
		
		add(ta = new TextArea());
		
		p2 = new Panel();
		add(btn1 = new Button("���콺 �����"));  
		add(btn2 = new Button("���� "));   
		p2.add(btn1);
		p2.add(btn2);
		
		
		add(p1,BorderLayout.NORTH);
		add(ta);
		add(p2,BorderLayout.SOUTH);
		validate();
	}
	
	
	public static void main(String[] args) {
		new DesignEx2_2();
	}
}

