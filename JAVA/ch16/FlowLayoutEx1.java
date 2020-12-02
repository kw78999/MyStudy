package ch16;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

public class FlowLayoutEx1 extends MFrame {
	String str[] = {"첫번째","두번째","세번째","네번째","다섯번째"};
	Button btn[] = new Button[5];
	
	public FlowLayoutEx1() {
		setTitle("FlowLayout Example");
		setLayout(new FlowLayout());
		setResizable(false); // 크기고정 
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(str[i]);
			Color c[] = MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setForeground(c[1]);
			add(btn[i]);
		}
		validate();
	}
	
	public static void main(String[] args) {
		new FlowLayoutEx1();
	}

}
