package ch17_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventEx3 extends MFrame {

Button btn;
	
	public EventEx3() {
		add(btn = new Button("버튼"),
				BorderLayout.SOUTH);
		//이벤트 소스랑 이벤트 핸들러(MyACtion 연결)
		MyAction ma = new MyAction();
		btn.addActionListener(ma);
	}
	
	//내부클래스 
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


