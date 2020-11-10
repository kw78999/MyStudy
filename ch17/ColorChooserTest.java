package ch17;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooserTest extends JFrame 
implements ChangeListener{
	
	JColorChooser color;
	JButton btn;

	public ColorChooserTest() {
		setTitle("ColorChooserTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		color = new JColorChooser();
		color.getSelectionModel().addChangeListener(this);
		color.setBorder(
				BorderFactory.createTitledBorder("색상 선택"));
		JPanel p = new JPanel();
		p.add(color);
		btn = new JButton("버튼");
		add(p);
		add(btn,BorderLayout.PAGE_START);
		pack();
		setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		Color c = color.getColor();
		btn.setBackground(c);
		//System.out.println(c.getRed()+","+c.getGreen()+","+c.getBlue());
	}
	
	public static void main(String[] args) {
		new ColorChooserTest();
	}
}
