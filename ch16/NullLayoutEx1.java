package ch16;

import java.awt.Button;

public class NullLayoutEx1 extends MFrame {

	Button btn1,btn2;
	
	public NullLayoutEx1() {

		setLayout(null);
	btn1 = new Button("버튼1");
	btn1.setBounds(10, 50, 50, 50);

	btn2 = new Button("버튼2");
	btn2.setBounds(100, 50, 50, 50);
	add(btn1);
	add(btn2);
	
	}
	public static void main(String[] args) {
		new NullLayoutEx1();
	}

}
