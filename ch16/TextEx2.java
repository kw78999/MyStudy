package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextEx2 extends MFrame implements ActionListener,MouseListener{
	//Flow Layout
	//Border Layout
	TextField tf;
	TextArea ta; //필드로 선언한 목적: 메소드 공유 
	Button btn,btn2;
	
	public TextEx2() {
		super(320,300);
		setTitle("MyChat v1.1");
		setLayout(new BorderLayout());
		add(ta = new TextArea(),BorderLayout.CENTER);
		Color c[] = MColor.rColor2();
		ta.setBackground(Color.green);
		ta.setEditable(false);
		//Panel : middle container
		Panel p = new Panel();
		p.add(tf = new TextField(22));
		p.add(btn = new Button("SEND"));
		p.add(btn2 = new Button("DELETE"));
		add(p,BorderLayout.SOUTH);
		tf.addActionListener(this);//컴포넌트랑 이벤트 핸들러 연결
		btn.addActionListener(this);
		btn2.addMouseListener(this);
		
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = tf.getText()	;
		if(s.length()==0)
			s = "입력 하세요. ";
		ta.append(s+"\n");
		tf.setText("");
		tf.requestFocus();
	}
	
	//마우스 관련 이벤트는 많은 추상메서드를 구현해야한다 
	@Override
	public void mousePressed(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {
	 ta.setText("");
	 ta.append("삭제되었습니다"+"\n");
     }
    @Override
	public void mouseEntered(MouseEvent e) {}@Override
	public void mouseExited(MouseEvent e) {}@Override
	public void mouseReleased(MouseEvent e) {}
	
	
	
	public static void main(String[] args) {
		new TextEx2();
	}
}

