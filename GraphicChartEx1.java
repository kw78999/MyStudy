package JAVAP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicChartEx1 {
	
	DrawPanel draw = new DrawPanel();
	JPanel panel1, panel2,mpanel;
	JLabel lb1, lb2, lb3;
	Font infoFont;
	int read;
	int AVGread;
	
	public GraphicChartEx1() {
		/*setTitle("�׷���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setContentPane(chartPanel);//�ֵ��гη� ��ü. �������� ��������?
		setSize(1200, 800);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);*/
		
		panel1 = new JPanel();
		panel1.setBounds(900, 0, 300, 520);
		panel1.setBackground(Color.CYAN);
		mpanel = new JPanel();
		mpanel.setLayout(null);
		
		String s = "õ���"; 	//������ �̸� DB���� ��������
		lb1 = new JLabel("�� ���� �������� "+s+"�� �Դϴ�.");
		lb1.setBounds(10, 10, 500, 20);
		
		read = 25; 			//������ ������ DB����
		lb2 = new JLabel(s+"���� ���� å�� "+read+"�� �Դϴ�.");
		lb2.setBounds(10, 30, 500, 20);
		
		AVGread = 12;		//������ ��� ������ DB����
		lb3 = new JLabel("��� �������� "+AVGread+"�� �Դϴ�.");
		lb3.setBounds(10, 50, 500, 20);
		
		infoFont = new Font("Times", Font.BOLD, 18);
		lb1.setFont(infoFont);
		lb2.setFont(infoFont);
		lb3.setFont(infoFont);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 520, 1200, 280);
		
		panel2.add(lb1);
		panel2.add(lb2);
		panel2.add(lb3);
		
		draw.setBounds(0, 0, 900, 520);
		draw.setBackground(Color.LIGHT_GRAY);
		
		
		mpanel.add(draw);
		mpanel.add(panel1);
		mpanel.add(panel2);
	}
	
	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);	//�׷��� ��
			g.drawLine(140, 20, 140, 400); //Y��
			g.drawLine(140, 400, 800, 400);//X��
			
			g.setColor(Color.WHITE); //������ 1
			g.drawLine(405, 500, 420, 500);
			g.fillRect(500, 500, 20, 10);
			
			g.fillRect(140+40, 400-read*5, 30, read*5);	//������ ������ �׷���
			g.drawRect(140+69, 399-AVGread*5, 25, AVGread*5);//������(���) �׷���
			
			g.setColor(Color.BLUE);
			
		
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicChartEx1();
		
	}

}
