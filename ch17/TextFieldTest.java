package ch17;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldTest extends JFrame implements ActionListener {

	JButton btn;
	JTextField text, result;
	
	public TextFieldTest() {
		setTitle("제곱근 계산하기");
		setSize(300, 130);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.add(new JLabel("숫자 입력: "));
		p.add(text = new JTextField(15));
		p.add(new JLabel("제곱근 값: "));
		p.add(result = new JTextField(15));
		result.setEditable(false);
		p.add(btn = new JButton("OK"));
		text.addActionListener(this);
		btn.addActionListener(this);
		add(p);
		setVisible(true);
		//////////////////////////
		//p.setBackground(Color.RED);
		text.setOpaque(false);
		text.putClientProperty("hightlightRed", true);
		text.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn||e.getSource()==text){
			String s = text.getText().trim();
			int value = Integer.parseInt(s);
			result.setText(" "+(value*value));
			text.requestFocus();
		}
	}

	public static void main(String[] args) {
		new TextFieldTest();
	}
}
