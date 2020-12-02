package ch16;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx3 extends MFrame implements ItemListener{

	Choice name, star;
	String ms[] = {"현 빈","원 빈","이민호","김수현","김우빈","이종석"};
	String fs[] = {"고아라","이연희","이하늬","문채원","수 지","김연아"};
	
public ChoiceEx3() {
		setTitle("연예인 선택");
		name =new Choice();
		name.add("남자 연예인");
		name.add("여자 연예인");
		star = new Choice();
		//기본값으로 남자연예인이기때문에 ms가 먼저 add된다 .
		inputItem(star,ms);
		add(name);
		add(star);
		//name 초이스 이벤트 연결
		name.addItemListener(this);
}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(name.getSelectedItem().equals("남자연예인")) {
			inputItem(star,ms);
		}else {
			inputItem(star,fs);
		}
}
		//첫번쨰 매개변수 Choice에 두번째 매개변수 Item을 추가
	public void inputItem(Choice c,String item[]) {
		//기존에 item을 모두 제거한 후에 
		c.removeAll();
		for (int i = 0; i < item.length; i++) {
			c.add(item[i]);
		}
	}

	public static void main(String[] args) {

		new ChoiceEx3();
		
	}

}
