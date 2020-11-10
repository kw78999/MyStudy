package ch16;

import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx1 extends MFrame implements ActionListener{
	
	TextField tf1, tf2;
	TextArea ta; //�ʵ�� ������ ����: �޼ҵ� ���� 
	
	public TextEx1() {
		super(250,300);
		setTitle("Text Exapmple");
		add(new Label("����"));
		add(tf1 = new TextField("ȫ�浿",20));
		add(new Label("��ȣ"));
		add(tf2 = new TextField(20));
		tf2.setEchoChar('#');
		add(ta = new TextArea(10, 30));
		ta.setEditable(false);//�����Ұ�
		tf2.addActionListener(this);//act�̺�Ʈ�� tf2�� ����.
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//tf2�� �Է��Ŀ� Enter�� �ϸ� ������ �Ǵ� ��
		ta.append(tf1.getText()+"/"+tf2.getText()+"\n");
		tf1.setText("");
		tf2.setText("");
		//�Է� ��Ŀ���� tf1���� ������ 
		tf1.requestFocus();
	}
	public static void main(String[] args) {
		new TextEx1();
	}
}


