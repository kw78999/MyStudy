package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

public class PanelEx1 extends MFrame {

	Label label[] = new Label[3];
	Button btn[] = new Button[3];
	String str1[] = {"첫번쨰","두번째","세번째"};
	String str2[] = {"Start","Stop","End"};
	Panel p1,p2;
	
	
	public PanelEx1() {
		setTitle("Panel Example");
		setLayout(new BorderLayout());
		//컨테이너는 기본적인 배치관리자 세팅: Panel은 기본 배치 관리자가 FlowLayout
		p1 = new Panel();
		p1.setBackground(MColor.rColor());
		for (int i = 0; i < label.length; i++) {
			label[i] = new Label(str1[i]);
			p1.add(label[i]);
		}
		p2 = new Panel();
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(str2[i]);
			p2.add(btn[i]);
		}
		p2.setBackground(MColor.rColor());
		
		
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		validate();
	
	}
	
	
	
	public static void main(String[] args) {

			new PanelEx1();
	}

}
