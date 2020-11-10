package ch17;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MFrame1 extends JFrame {

	MFrame1() {
		setTitle("My Frame");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 10));
		JButton[] buttons = new JButton[10];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText("" + i);
			panel.add(buttons[i]);
		}
		this.add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		MFrame1 m = new MFrame1();
	}

}
