package ch16;

import java.awt.Button;
import java.awt.Color;

public class ButtonEx2 extends MFrame{

		Button  btn[] = new Button[4];
		String str[] = {"추가","삭제","전체삭제","종료"};
		
	public ButtonEx2() {
		super(400,250);
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(str[i]));
			btn[i].setBackground(MColor.rColor());
			btn[i].setForeground(MColor.rColor());
			validate();
		}
	}
	
	
	public static void main(String[] args) {
		new ButtonEx2();
	}

}
