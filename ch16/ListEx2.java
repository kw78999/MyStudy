package ch16;

import java.awt.Choice;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListEx2 extends MFrame implements ItemListener{

	Choice cho;
	List list1, list2;
	String team1[] = {"�Ե�","�Ｚ","��ȭ","���","SK"};
	String team2[]  = {"lg","�λ�","Ű��","nc","kt"};
	
	public ListEx2() {
		setTitle("�߱��� ����");
		cho = new Choice();; //���ϼ���
		cho.add("������");
		cho.add("������");
		list2 = new List(5,true);
		list1 = new List(5,false);
		inputItem2(list2, team1);
		add(cho);
		
		cho.addItemListener(this);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(cho.getSelectedItem().equals("������")) {
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