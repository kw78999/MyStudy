package ch17_1;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventEx2 extends MFrame 
implements ItemListener/*XXXListener*/{
	
	Checkbox cb;

	public EventEx2() {
		add(cb = new Checkbox("체크"),
				BorderLayout.NORTH);
		//이벤트소스.addXXXListener
		//this : 내 자신을 가르키는 키워드 -> 내 자신의 객체 주소
		cb.addItemListener(this);
		//체크박스 체크 또는 해제 ->itemStateChanged 호출
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx2();
	}

}



