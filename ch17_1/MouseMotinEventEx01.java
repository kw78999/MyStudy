package ch17_1;

import java.awt.Color;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

public class MouseMotinEventEx01 extends MFrame 
implements MouseMotionListener{
	
	Label lDrag, lMove;
	
	public MouseMotinEventEx01() {
		super(500, 300, new Color(100,200,100));
		setLayout(null);
		lDrag = new Label("Drag",Label.CENTER);
		lMove = new Label("Move",Label.CENTER);
		lDrag.setBounds(100, 100, 50, 30);
		lMove.setBounds(100, 150, 50, 30);
		lDrag.setBackground(Color.CYAN);
		lMove.setBackground(Color.PINK);
		add(lDrag);
		add(lMove);
		addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		lDrag.setLocation(p);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		lMove.setLocation(p);
	}

	public static void main(String[] args) {
		new MouseMotinEventEx01();
	}
}
