package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

public class BorderLayoutEx1 extends MFrame {
	String str[] = {"첫번째","두번째","세번째","네번째","다섯번째"};
	String pos[] = {BorderLayout.NORTH,BorderLayout.EAST,
								BorderLayout.SOUTH,BorderLayout.WEST,
								BorderLayout.CENTER};
	Button btn[] = new Button[5];
	
	
	public BorderLayoutEx1() {
		setTitle("FlowLayout Example");
		setLayout(new BorderLayout());
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(str[i]);
			
			Color c[] = MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setForeground(c[1]);
			
			add(btn[i],pos[i]);
			
			
			
			
		}
		validate();
	}
	
	
	
	
	
	public static void main(String[] args) {
		new BorderLayoutEx1();
	}

}
