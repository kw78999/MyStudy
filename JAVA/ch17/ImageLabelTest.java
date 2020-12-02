package ch17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabelTest extends JFrame 
implements ActionListener{
	
	JPanel p;
	JLabel label;
	JButton btn;
	
	public ImageLabelTest() {
		setTitle("�̹��� ���̺�");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new JPanel();
		label = new JLabel("�̹����� ������ �Ʒ� ��ư�� ��������.");
		btn = new JButton("�̹��� ���̺�");
		ImageIcon icon = new ImageIcon("ch17/icon.gif");
		btn.setIcon(icon);
		btn.addActionListener(this);
		p.add(label);
		p.add(btn);
		add(p);
		setVisible(true);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon dog = new ImageIcon("ch17/dog.gif");
		label.setIcon(dog);
		label.setText(null);
	}

	public static void main(String[] args) {
		new ImageLabelTest();
	}
}
