package ch13;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//익명클래스를 사용하지 않고 종료버튼 만들기
class YFrame extends Frame implements ActionListener{
	Button btn;
	public YFrame() {
		setTitle("No익명클래스");
		setSize(300, 300);
		setVisible(true);
		add(btn = new Button("버튼"));
		//버튼을 클릭하면 actionPerformed 호출됨.
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//프로그램 종료
		System.exit(0);
	}
}

class YFrame1 extends Frame{
	Button btn;
	public YFrame1() {
		setTitle("익명클래스");
		setSize(300, 300);
		setVisible(true);
		add(btn = new Button("버튼"));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}

public class Ex3 {

	public static void main(String[] args) {
		//YFrame y = new YFrame();
		YFrame1 y1 = new YFrame1();
	}

}
