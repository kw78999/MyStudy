package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.Panel;

public class DesignEx1_1 extends MFrame {
	
	Label label;
	Checkbox cb1, cb2, cb3;
	Component cbg;
	Button btn1, btn2;
	Panel p1,p2,p3;
	CheckboxGroup grp;
	
	public DesignEx1_1() {
		super(250,150);
		setTitle("������ ����1");
		setLayout(new BorderLayout());
		label =new Label("�׽�Ʈ",Label.CENTER);
		label.setBackground(Color.green);
		
		p2 = new Panel();
		grp = new CheckboxGroup();
		p2.add(cb1 = new Checkbox("����1",grp,false));  
		p2.add(cb2 = new Checkbox("����2",grp,true));
		p2.add(cb3 = new Checkbox("����3",grp,true));
		
		p3 = new Panel();
		p3.add(btn1 = new Button("�߰�"));  
		p3.add(btn2 = new Button("����")); 
		
		
		
		
		add(p3,BorderLayout.SOUTH);
		add(p2);
		add(label,BorderLayout.NORTH);
		validate();
	}	


	public static void main(String[] args) {
		new DesignEx1_1();
	}

}

