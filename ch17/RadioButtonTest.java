package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class RadioButtonTest extends JFrame 
implements ActionListener {

	JRadioButton jb[] = new JRadioButton[3];
	String size[] = {"Small Size","Medium Size","Large Size"};
	JLabel text;
	JPanel topP, sizeP, resultP;
	
	public RadioButtonTest() {
		setTitle("RadioButtonTest");
		setSize(350, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		topP = new JPanel();
		JLabel label = new JLabel("� Ŀ�Ǹ� �ֹ��Ͻðڽ��ϱ�?");
		topP.add(label);
		add(topP,BorderLayout.PAGE_START);
		//add(topP,BorderLayout.NORTH);
		
		ButtonGroup gr = new ButtonGroup();
		sizeP = new JPanel();
		for (int i = 0; i < jb.length; i++) {
			gr.add(jb[i] = new JRadioButton(size[i]));
			jb[i].addActionListener(this);
			sizeP.add(jb[i]);
		}
		Border border = BorderFactory.createTitledBorder("SIZE");
		sizeP.setBorder(border);
		add(sizeP,BorderLayout.CENTER);
		resultP  =new JPanel();
		resultP.add(text=new JLabel("ũ�Ⱑ ���õ��� �ʾҽ��ϴ�."));
		text.setForeground(Color.RED);
		add(resultP,BorderLayout.PAGE_END);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb[0])
			text.setText("Small ũ�Ⱑ ���õǾ����ϴ�.");
		else if(e.getSource()==jb[1])
			text.setText("Medium ũ�Ⱑ ���õǾ����ϴ�.");
		else if(e.getSource()==jb[2])
			text.setText("Large ũ�Ⱑ ���õǾ����ϴ�.");
	}

	public static void main(String[] args) {
		new RadioButtonTest();
	}

}
