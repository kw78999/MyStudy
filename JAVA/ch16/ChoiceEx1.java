package ch16;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx1 extends MFrame implements ItemListener{

	String sair[] = {"대한항공","아시아나","에어부산","진에어"};
	String scity[] = {"서 울","대 전","대 구","부 산","제주도"};
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
	
	@Override //객체를 생성하면 자동적으로 한번 호출됨
	public void paint(Graphics g/*붓*/) {
		g.setColor(Color.RED);
		String str = "항공사 선택 : "+air.getSelectedItem();
		g.drawString(str, 30, 120);
		g.setColor(Color.BLUE);
		String str1 = "도시 선택 : "+city.getSelectedItem();
		g.drawString(str1, 30, 150);
	}
	public static void main(String[] args) {
		new ChoiceEx1();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
