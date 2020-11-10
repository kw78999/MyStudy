package ch18;

import java.awt.Color;
import java.awt.Graphics;

public class NewFrame extends MFrame {

	int w,h,x,y;
	
	public NewFrame() {
		super(600,600,Color.WHITE);
	
	}
	public void run() {
	
			for (int i = 0; i < 100000; i++) {
				x = (int)(Math.random()*600)+1; //1���� 600����
			    y = (int)(Math.random()*600)+1; //1���� 600����
			    w = (int)(Math.random()*400)+1; //1���� 20����
			    h = (int)(Math.random()*400)+1; //1���� 20����
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//0.01 : �� ���� ��� sleep �Ѵ� 
				repaint();
		
			}
		
	}
	@Override
	public void update(Graphics g) {
		g.clipRect(x, y, w+1, h+1); //������ ��ġ�� ���� 
		paint(g);
	}
	
	//repaint -> update (��������) : �׷ȴ� �κ� ���� ����->paint
	@Override
	public void paint(Graphics g) {
		g.setColor(MColor.rColor());
	g.drawRect(x, y, w, h);
		//g.fillRect(x, y, w, h);
	}
	
	
	
	
	public static void main(String[] args) {
		NewFrame mf = new NewFrame();
				mf.run();
	}

}
