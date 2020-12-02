package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class GridLayoutEx2 extends MFrame {

	String str2[] = {"add","remove","removeall","exit"};
	Button btn[] = new Button[4];
	Panel p = new Panel()	;
	
	public GridLayoutEx2() {
		setLayout(new BorderLayout());
		p.setLayout(new GridLayout(4,1)	);
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(str2[i]);
			p.add(btn[i]);
		}
		p.setBackground(Color.BLUE);
		
		add(p,BorderLayout.EAST);
		validate();
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new GridLayoutEx2();
	}

}
