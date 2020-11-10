package ch20;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RunnableFrameEx1 extends MFrame implements Runnable {
	
	Color c;
	Random r;
	int x, y;
	
	public RunnableFrameEx1(Color c) {
		super(300,300);
		this.c = c;
		r = new Random();
	}

	@Override
	public void run() {
		 try {
			for (int i = 0; i < 100; i++) {
				x = r.nextInt(300);
				y = r.nextInt(300);
				Thread.sleep(0);
				repaint();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}
	
	@Override
	public void update(Graphics g) {
		g.clipRect(x, y, 10, 10);
		paint(g);
	}

	public static void main(String[] args) {
		RunnableFrameEx1 r1 = new RunnableFrameEx1(Color.blue);
		RunnableFrameEx1 r2 = new RunnableFrameEx1(Color.red);
		new Thread(r1).start();
		new Thread(r2).start();
		
	}
}




