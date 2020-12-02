package ch16;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxEx1 extends MFrame implements ItemListener {
	/*인터페이스 구현 -> 추상 메서드 오버라이딩 강제됨*/
	Checkbox cb1,cb2,cb3;
	Checkbox rb1,rb2,rb3;
	CheckboxGroup grp;  //라디오 버튼 그룹 그룹핑해야 라디오 버튼이 가능하다
	
	
	public CheckboxEx1() {
		super(220,250);
		setTitle("Checkbox Example");
		add(cb1 = new Checkbox("선택1",false));  //각각 하나의 단위가 Item 이라고 한다
		add(cb2 = new Checkbox("선택2",true));
		add(cb3 = new Checkbox("선택3",false));
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		grp = new CheckboxGroup();
		add(rb1 = new Checkbox("라디오1",grp,true));
		add(rb2 = new Checkbox("라디오2",grp,true));
		add(rb3 = new Checkbox("라디오3",grp,true));
		
		
		
		validate();
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox cb = (Checkbox)e.getSource();
		String str = cb.getLabel() + " : " + cb.getState();
		setTitle(str);
	}
	
	
	
	public static void main(String[] args) {
		new CheckboxEx1();
	}
}
