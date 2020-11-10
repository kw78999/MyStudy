package ch13;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MyFrame extends Frame{

	public MyFrame(int x, int y , Color c) {
		setBounds(x, y, 150, 150);
		setBackground(c);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			Random r = new Random();
			int x = r.nextInt(1500);
			int y = r.nextInt(1300);
			MyFrame m = new MyFrame(x, y, rColor());
		}
	}
	
	public static Color rColor() {
		Random rd = new Random();
		int r = rd.nextInt(256); 
		int g = rd.nextInt(256); 
		int b = rd.nextInt(256); 
		return new Color(r,g,b);
	}
}






