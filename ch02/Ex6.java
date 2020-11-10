package ch02;

import java.awt.Color;
import java.awt.Frame;

public class Ex6 {
	
    public static void main(String[] args) {
    	
	final int HD = 1;
	final int KIA =2;
	//HD = 3;   에러
	//반지름이 10인 원의 넓이를 구하시오 
	int r =10;
	double d= r*r*Math.PI;
	System.out.println(d);
	
	int i = Math.max(100, 200);
	System.out.println(i);
	long j = Math.round(3.14);
	System.out.println(j);
	
	Frame f = new Frame();
	f.setSize(300, 300);
	//f.setBackground(new Color(255,0,0));
	//f.setBackground(Color.red);
	f.setBackground(new Color(255,255,0));
	f.setBackground(Color.yellow);
	f.setVisible(true);
	
	
}
}
