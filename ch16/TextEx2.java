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
	TextArea ta; //�ʵ�� ������ ����: �޼ҵ� ���� 
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
		tf.addActionListener(this);//������Ʈ�� �̺�Ʈ �ڵ鷯 ����
		btn.addActionListener(this);
		btn2.addMouseListener(this);
		
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = tf.getText()	;
		if(s.length()==0)
			s = "�Է� �ϼ���. ";
		ta.append(s+"\n");
		tf.setText("");
		tf.requestFocus();
	}
	
	//���콺 ���� �̺�Ʈ�� ���� �߻�޼��带 �����ؾ��Ѵ� 
	@Override
	public void mousePressed(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {
	 ta.setText("");
	 ta.append("�����Ǿ����ϴ�"+"\n");
     }
    @Override
	public void mouseEntered(MouseEvent e) {}@Override
	public void mouseExited(MouseEvent e) {}@Override
	public void mouseReleased(MouseEvent e) {}
	
	
	
	public static void main(String[] args) {
		new TextEx2();
	}
}

