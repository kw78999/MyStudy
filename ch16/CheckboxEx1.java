package ch16;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxEx1 extends MFrame implements ItemListener {
	/*�������̽� ���� -> �߻� �޼��� �������̵� ������*/
	Checkbox cb1,cb2,cb3;
	Checkbox rb1,rb2,rb3;
	CheckboxGroup grp;  //���� ��ư �׷� �׷����ؾ� ���� ��ư�� �����ϴ�
	
	
	public CheckboxEx1() {
		super(220,250);
		setTitle("Checkbox Example");
		add(cb1 = new Checkbox("����1",false));  //���� �ϳ��� ������ Item �̶�� �Ѵ�
		add(cb2 = new Checkbox("����2",true));
		add(cb3 = new Checkbox("����3",false));
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		grp = new CheckboxGroup();
		add(rb1 = new Checkbox("����1",grp,true));
		add(rb2 = new Checkbox("����2",grp,true));
		add(rb3 = new Checkbox("����3",grp,true));
		
		
		
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
