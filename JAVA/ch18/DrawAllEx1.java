package ch18;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrawAllEx1 extends MFrame implements ActionListener {

	Panel p1, p2;
	int mode=1/*0-선,1-사각형,2-원*/,color;
	Label l[];
	Checkbox fillcb;
	
	Checkbox rcb, gcb, bcb;
	CheckboxGroup cbg;
	TextField tf[];
	Button b1, b2, b3;
	Button btn;
	MCanvas canvas;
	String ll[] = {"X1","Y1","X2","Y2 "};
	String rl[] = {"X","Y","W","H "};
	String ol[] = {"X","Y","너비","높이"};
	
	public DrawAllEx1() {
		super(600,300);
		setTitle("선그리기");
		makeAWT();
		p1 = new Panel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		add(p1,BorderLayout.EAST);
		p2.setBackground(Color.yellow);
		for (int i = 0; i < l.length; i++) {
			p2.add(l[i]);
			p2.add(tf[i]);
		}
		p2.add(rcb);
		p2.add(gcb);
		p2.add(bcb);
		p2.add(btn);
		selectPanel(mode);
		add(p2,BorderLayout.SOUTH);
		add(canvas = new MCanvas());
		validate();
	}
	
	public void makeAWT(){
		p1 = new Panel();
		p2 = new Panel();
		l = new Label[4];
		for (int i = 0; i < l.length; i++) {
			l[i] = new Label();
		}
		b1 = new Button("선");
		b2 = new Button("사각형");
		b3 = new Button("원");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tf = new TextField[4];
		for (int i = 0; i < tf.length; i++) {
			tf[i] = new TextField("30",3);
		}
		fillcb = new Checkbox("채우기");
		cbg = new CheckboxGroup();
		rcb = new Checkbox("R",cbg,true);
		gcb = new Checkbox("G",cbg,false);
		bcb = new Checkbox("B",cbg,false);
		btn = new  Button("그리기");
		btn.addActionListener(this);
	}
	
	public void selectPanel(int mode) {
		switch (mode) {
		case 0:
			setTitle("선그리기");
			p2.setBackground(Color.YELLOW);
			for (int i = 0; i < l.length; i++) {
				l[i].setText(ll[i]);
				l[i].setBackground(Color.YELLOW);
			}
			rcb.setBackground(Color.YELLOW);
			gcb.setBackground(Color.YELLOW);
			bcb.setBackground(Color.YELLOW);
			bcb.setBackground(Color.YELLOW);
			p2.remove(fillcb);
			break;
		case 1:
			p2.remove(fillcb);
			setTitle("사각형그리기");
			p2.setBackground(Color.PINK);
			for (int i = 0; i < l.length; i++) {
				l[i].setText(rl[i]);
				l[i].setBackground(Color.PINK);
			}
			rcb.setBackground(Color.PINK);
			gcb.setBackground(Color.PINK);
			bcb.setBackground(Color.PINK);
			p2.add(fillcb,8);
			break;
		case 2:
			p2.remove(fillcb);
			setTitle("원그리기");
			p2.setBackground(Color.CYAN);
			for (int i = 0; i < l.length; i++) {
				l[i].setText(ol[i]);
				l[i].setBackground(Color.CYAN);
			}
			rcb.setBackground(Color.CYAN);
			gcb.setBackground(Color.CYAN);
			bcb.setBackground(Color.CYAN);
			p2.add(fillcb,8);
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1) {  //선그리기
			mode = 0;
			selectPanel(mode);
		}else if (obj==b2) {   //사각형 버튼
			mode = 1;
			selectPanel(mode);
		}else if (obj==b3) {//원버튼
			mode = 2;
			selectPanel(mode);
		}else if (obj==btn) {//그리기
			Checkbox cb = cbg.getSelectedCheckbox();
			if(cb == rcb) color =0;
			if(cb == gcb) color =1;
			if(cb == bcb) color =2;
			canvas.repaint();
		}
	}
	
	class MCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			int i[] = new int [4];
			for (int j = 0; j < i.length; j++) {
				i[j] = Integer.parseInt(tf[j].getText().trim());
			}
			switch(color) {
			case 0: g.setColor(Color.RED);break;
			case 1: g.setColor(Color.green);break;
			case 2: g.setColor(Color.blue);break;
			}
			switch(mode) {
			case 0:
				g.drawLine(i[0],i[1],i[2], i[3]);
				break;
			case 1:
			if(fillcb.getState()	) {
				g.fillRect(i[0],i[1],i[2], i[3]);
			}else {
				g.drawRect(i[0],i[1],i[2], i[3]);
			}
				break;
			case 2:
				if(fillcb.getState()	) {
					g.fillOval(i[0],i[1],i[2], i[3]);
				}else {
					g.drawOval(i[0],i[1],i[2], i[3]);
				}
				break;
				
				
				
			}
		}//---------paint
	}//-----MCanvas

	public static void main(String[] args) {
		new DrawAllEx1();
	}
}