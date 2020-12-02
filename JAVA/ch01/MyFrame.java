package ch01;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//myJava/ch01/클래스명.java(MyFrame.java)
public class MyFrame extends Frame implements ActionListener {

	Button btn;
	boolean flag = false;

	public MyFrame() {
		setSize(300, 300);
		setVisible(true);
		btn = new Button("버튼");
		add(btn, "South");
		btn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// 오마 클릭 : source>format  코드 정렬
	@Override
	public void actionPerformed(ActionEvent e) {
		if (flag)
			setBackground(Color.blue);
		else
			setBackground(Color.RED);
		flag = !flag;
	}

	public static void main(String[] args) {

		new MyFrame();
	}

}
