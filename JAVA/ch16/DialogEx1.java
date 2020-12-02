package ch16;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEx1 extends MFrame implements ActionListener {

		Button btn;
		String title = "�޼��� ��ȭ����";		
		
		public DialogEx1() {
			setLayout(null);
			btn = new Button("Ŭ��");
			btn.setBounds(150, 100, 60, 30);  //x��ǥ ,y��ǥ  ,button ���� , button ����
			add(btn);
			btn.addActionListener(this);
			
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		MDialog md = new MDialog(this,title, true);
		int w = 100;
		int h = 100;
		int x = getX() +getWidth()/2-w/2;
		int y = getY()  + getHeight()/2-h/2;
		//MDialog�� �����ӿ� ���߾ӿ� ��ġ�ϵ��� �ϱ� 
		md.setBounds(x,y,w,h);
		md.setVisible(true);
		
	}

	
	
	//����Ŭ����
//	super();   //���� �Ǿ� �ִ�.  -> Dialog ���� ����Ʈ �����ڰ� ����.
	class MDialog extends Dialog implements ActionListener{
		
		Button b;
		
		public MDialog(Frame f,String title,boolean modal) {  //modal�� awt������ �����̴� 
			super (f,title,modal);
			setLayout(new FlowLayout());
			 b= new Button ("Ȯ��");
			 b.addActionListener(this);
			 add(b);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		dispose();  //�������.
		
		}
		
		
	}
	
	public static void main(String[] args) {
		new DialogEx1();
	}

}
