package ch18;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageViewEx3 extends MFrame implements ActionListener {

	Image img;
	Button btn[] = new Button[6];
	String str[] = {"����׸�","�Ϻα׸�","��ұ׸�","�¿������"
			,"���ϵ�����","���ε�����"};
	int idx;
	
	static final int SHOW_NORM = 0;//����׸�
	static final int SHOW_PART = 1;//�Ϻα׸�
	static final int SHOW_SCALE = 2;//��ұ׸�
	static final int SHOW_HORIZONTAL = 3;//�¿������
	static final int SHOW_VERTICAL = 4;//���ϵ�����
	static final int SHOW_ALL = 5;//���ε�����
	String name;
	
	public ImageViewEx3(String name) {
		super(600,400);
		this.name = name;
		img = Toolkit.getDefaultToolkit().
				getImage("ch18/"+name);
		Panel p = new Panel();
		for (int i = 0; i < btn.length; i++) {
			p.add(btn[i]=new Button(str[i]));
			btn[i].addActionListener(this);
		}
		add(p,BorderLayout.SOUTH);
		idx = SHOW_NORM;
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource()	;
		for (int i = 0; i < btn.length; i++) {
			if(obj == btn[i]) {
				idx = i;
				break;
			}
		}
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		setTitle(name+" - "+str[idx]);
		//�̹����� ũ��
		int iw = img.getWidth(this);
		int ih = img.getHeight(this);
	switch(idx) {
	case SHOW_NORM:
		//���� 4�� Frame ��ǥ /�ڿ� 4���� �̹��� ��ǥ
		 g.drawImage(img, 0, 0, iw, ih,
				 0, 0, iw, ih, this);
		break;
	case SHOW_PART:
		g.drawImage(img, 100, 100, 300, 300,
				 220, 20, 420, 220, this);
		break;
	case SHOW_SCALE: 
		g.drawImage(img, 0, 0, iw/2, ih/2,
				 0, 0, iw, ih, this);
		break;
	case SHOW_HORIZONTAL: 
		g.drawImage(img, iw, 0, 0, ih,
				 0, 0, iw, ih, this);
		break;
	case SHOW_VERTICAL:
		g.drawImage(img, 0, ih, iw,0 ,
				 0, 0, iw, ih, this);
		break;
	case SHOW_ALL: 
		g.drawImage(img, iw,ih , 0, 0,
				 0, 0, iw, ih, this);
		break;
	}
}
	public static void main(String[] args) {
		new ImageViewEx3("aaa0.png");
	}
}

