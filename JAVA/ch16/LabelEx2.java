package ch16;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
public class LabelEx2 extends MFrame{
	//배열을 사용하는 목적
	
	Label label[] = new Label[4];
	
	public  LabelEx2(){
		super(230,200);
		setTitle("Label Example2");
		String str = "오늘은 한주가 시작되는 월요일";
		for (int i = 0; i < label.length; i++) {
			label[i] = new Label(str, Label.CENTER);
			Color c[] = MColor.rColor2();
			label[i].setBackground(c[0]);
			label[i].setForeground(c[1]);
			add(label[i]);
		}
		validate();
	}
	public static void main(String[] args) {
		new LabelEx2();
	}

}
