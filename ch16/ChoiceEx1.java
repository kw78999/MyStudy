package ch16;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx1 extends MFrame implements ItemListener{

	String sair[] = {"�����װ�","�ƽþƳ�","����λ�","������"};
	String scity[] = {"�� ��","�� ��","�� ��","�� ��","���ֵ�"};
	Choice air,city;
	
	public ChoiceEx1() {
		
		
		super(300,300,new Color(100,200,100));
		setTitle("Choice Exaple");
		air = new Choice();
		city = new Choice();
		for (int i = 0; i < sair.length; i++) 
			air.add(sair[i]);
		for (int i = 0; i < scity.length; i++) 
			city.add(scity[i]);
		add(air);
		add(city);
		city.addItemListener(this);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();
	}
	
	@Override //��ü�� �����ϸ� �ڵ������� �ѹ� ȣ���
	public void paint(Graphics g/*��*/) {
		g.setColor(Color.RED);
		String str = "�װ��� ���� : "+air.getSelectedItem();
		g.drawString(str, 30, 120);
		g.setColor(Color.BLUE);
		String str1 = "���� ���� : "+city.getSelectedItem();
		g.drawString(str1, 30, 150);
	}
	public static void main(String[] args) {
		new ChoiceEx1();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
