package ch17_1;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionEventEx1 extends MFrame
implements ActionListener{
	
	TextField tf;
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cbg;
	Button btn1, btn2;
	String str[] = {"���� ��ħ�Դϴ�.",
			             "�Ļ� ���ְ� �ϼ���.",
			             "�߰���.���� ���ô�."};
	
	public ActionEventEx1() {
		super(250,150);
		//////////////////////////////////////////////////////////
		tf = new TextField("�λ��ϱ� ��ư�� �����ּ���.");
		tf.setBackground(Color.GREEN);
		//////////////////////////////////////////////////////////
		cbg = new CheckboxGroup();
		Panel p1 = new Panel();
		p1.add(cb1=new Checkbox("��ħ",cbg,false));
		p1.add(cb2=new Checkbox("����",cbg,true));
		p1.add(cb3=new Checkbox("����",cbg,false));
		//////////////////////////////////////////////////////////
		Panel p2 = new Panel();
		p2.add(btn1=new Button("�λ��ϱ�"));
		p2.add(btn2=new Button("�����ϱ�"));
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		//////////////////////////////////////////////////////////
		add("North",tf);
		add(p1);
		add(p2,"South");
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("�λ��ϱ�")) {
			Checkbox cb = cbg.getSelectedCheckbox();
			if(cb==cb1) 
				tf.setText(str[0]);
			else if(cb==cb2) 
				tf.setText(str[1]);
			else if(cb==cb3) 
				tf.setText(str[2]);
		}else if(s.equals("�����ϱ�")) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ActionEventEx1();
	}
}






