package ch17_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventEx5 extends MFrame 
implements ItemListener{
	
	Checkbox pink, green, yellow;
	CheckboxGroup g;
	
	public EventEx5() {
		g= new CheckboxGroup();
		Panel p = new Panel();
		p.add(pink = new Checkbox("pink",g,true));
		p.add(green = new Checkbox("green",g,false));
		p.add(yellow = new Checkbox("yellow",g,false));
		add(p,BorderLayout.SOUTH);
		pink.addItemListener(this);
		green.addItemListener(this);
		yellow.addItemListener(this);
		setBackground(Color.PINK);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Checkbox cb = (Checkbox)e.getSource();
		if(cb.getLabel().equals("pink")) {
			setBackground(Color.PINK);
		}else if(cb.getLabel().equals("green")) {
			setBackground(Color.GREEN);
		}else if(cb.getLabel().equals("yellow")) {
			setBackground(Color.YELLOW);
		}
	}
	
	public static void main(String[] args) {
		new EventEx5();
	}
}




