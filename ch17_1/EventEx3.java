package ch17_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventEx3 extends MFrame {

Button btn;
	
	public EventEx3() {
		add(btn = new Button("��ư"),
				BorderLayout.SOUTH);
		//�̺�Ʈ �ҽ��� �̺�Ʈ �ڵ鷯(MyACtion ����)
		MyAction ma = new MyAction();
		btn.addActionListener(ma);
	}
	
	//����Ŭ���� 
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			setBackground(MColor.rColor());
		}
	}

	
	public static void main(String[] args) {
		new EventEx3();
	}
}


