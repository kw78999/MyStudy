package libSearchProgram;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class SFrame extends JFrame{
	SearchPanel01 p1 = new SearchPanel01();	//���̺�
	SearchPanel02 p2 = new SearchPanel02();	//�˻� �� Ŭ���� �� ���
	SearchPanel03 p3 = new SearchPanel03();	//ä��
	SearchPanel04 p4 = new SearchPanel04();	//���� ����
	SearchPanel05 p5 = new SearchPanel05();	//���� ����
	public SFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1155, 700);
		setResizable(false);
		setLayout(null);
		setTitle("ȸ���� �����˻� ���α׷�");
		setLocationRelativeTo(null);
		Container c = getContentPane();
		p1.setBounds(0, 0, 690, 450);
		p1.setBackground(Color.WHITE);
		p2.setBounds(690, 0, 450, 230);
		p2.setBackground(Color.WHITE);
		p3.setBounds(0, 450, 690, 210);
		p3.setBackground(Color.WHITE);
		p4.setBounds(690, 230, 450, 220);
		p4.setBackground(Color.WHITE);
		p5.setBounds(690, 450, 450, 210);
		p5.setBackground(Color.WHITE);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		
		setVisible(true);
		validate();
	}
	
	public static void main(String[] args) {
		new SFrame();
	}

}
