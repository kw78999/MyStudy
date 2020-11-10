package ch16;

import java.awt.Choice;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListEx2 extends MFrame implements ItemListener{

	Choice cho;
	List list1, list2;
	String team1[] = {"롯데","삼성","한화","기아","SK"};
	String team2[]  = {"lg","두산","키움","nc","kt"};
	
	public ListEx2() {
		setTitle("야구팀 선택");
		cho = new Choice();; //단일선택
		cho.add("상위권");
		cho.add("하위권");
		list2 = new List(5,true);
		list1 = new List(5,false);
		inputItem2(list2, team1);
		add(cho);
		
		cho.addItemListener(this);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(cho.getSelectedItem().equals("상위권")) {
			inputItem2(list2, team1);
		}else {
			inputItem2(list2, team2);
		}
	}
	
	

public void inputItem2(List list,String[] str) {
	list.removeAll();
	add(list);
	for (int i = 0; i < str.length; i++) {
		list.add(str[i]);
	}
}

public static void main(String[] args) {
	new ListEx2();
}



}