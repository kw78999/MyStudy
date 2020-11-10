package ch17_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventEx1 extends MFrame 
implements ActionListener{
	/*이벤트 기능의 3대 요소
	 * 1.이벤트 소스
	 * 2.이벤트 클래스 : 이벤트를 발생하면 만들어지는 이벤트 객체
	 * ex) ActionEvent
	 * 3.이벤트 핸들러 : 이벤트 소스(버튼)랑 이벤트 클래스랑 둘이 연결을 하기 위해서 
	 * 인터페이스를 하나 구현을 해야 한다. XXXListener -> ActionListener 
	 * */
	
	Button btn;//버튼을 클릭하면 ActionEvent가 객체가 생성 : 미리 정해진 것.
	
	public EventEx1() {
		add(btn = new Button("버튼"),
				BorderLayout.SOUTH);
		//4.이벤트 소스랑 이벤트 핸들러를 연결 : addXXXListener
		//ch.addItemListener, tx.addKeyListener
		btn.addActionListener(this);
	}
	//이벤트 핸들러 : 인터페이스 또는 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx1();
	}
}




