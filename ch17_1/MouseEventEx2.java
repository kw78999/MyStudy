package ch17_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventEx2 extends MFrame 
implements  MouseListener{

	
	Button btn;
	
	public MouseEventEx2() {
		add(btn = new Button("버튼"),BorderLayout.SOUTH);
		//Adapter는 이벤트리스너를 구현한 추상클래스이다 _> 필요한 메소드만 구현하면 된다.
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new MColor().rColor());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new MColor().rColor());
			}
		});
		validate();
	}
	
	public static void main(String[] args) {
		new MouseEventEx2();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
