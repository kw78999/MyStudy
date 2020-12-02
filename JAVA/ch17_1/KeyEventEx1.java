package ch17_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventEx1 extends MFrame 
implements ActionListener,KeyListener{
	
	TextField tf;
	TextArea ta;
	Button btn;
	
	public KeyEventEx1() {
		super(300,500);
		add(tf=new TextField(),BorderLayout.SOUTH);
		add(ta=new TextArea());
		ta.setEditable(false);
		//현재의 클래스(KeyEventEx1)에 KeyListener 기능을 구현했기때문에 this 사용
		tf.addKeyListener(this);
		btn = new Button("REMOVE");
		add(btn,BorderLayout.NORTH);
		btn.addActionListener(this);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		tf.setText("");
		tf.requestFocus();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		ta.append("##KeyTyped : " + tf.getText()+"\n");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ta.append("##KeyPressed : " + tf.getText()+"\n");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ta.append("## keyReleased : " + tf.getText()+"\n");
	}
	
	
	
	public static void main(String[] args) {
		new KeyEventEx1();
	}
}
