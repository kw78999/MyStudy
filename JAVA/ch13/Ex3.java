package ch13;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�͸�Ŭ������ ������� �ʰ� �����ư �����
class YFrame extends Frame implements ActionListener{
	Button btn;
	public YFrame() {
		setTitle("No�͸�Ŭ����");
		setSize(300, 300);
		setVisible(true);
		add(btn = new Button("��ư"));
		//��ư�� Ŭ���ϸ� actionPerformed ȣ���.
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//���α׷� ����
		System.exit(0);
	}
}

class YFrame1 extends Frame{
	Button btn;
	public YFrame1() {
		setTitle("�͸�Ŭ����");
		setSize(300, 300);
		setVisible(true);
		add(btn = new Button("��ư"));
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
