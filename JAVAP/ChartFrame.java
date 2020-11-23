package JAVAP;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChartFrame extends JPanel{
	JPanel southPanel = new JPanel();
	JPanel northPanel = new JPanel();
	ChartPanel01 p1 = new ChartPanel01();
	ChartPanel02 p2 = new ChartPanel02();
	ChartPanel03 p3 = new ChartPanel03();
	JPanel p4 = new JPanel();
	Color cor = new Color(170,220,255);

//	Container c;
	
	public ChartFrame(){
		northPanel.setBounds(0,0,1200, 50);
		northPanel.setLayout(null);
		northPanel.setBackground(cor);
		JButton btn1 = new JButton("��ǥ");
		btn1.setBounds(800, 20, 80, 20);
		northPanel.add(btn1);
		btn1.addActionListener(CallXl);
		
		southPanel.setBounds(0,50,1200, 700);
		southPanel.setLayout(null);
		southPanel.setBackground(cor);
		//setTitle("Grid");
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
	//	setLocationRelativeTo(null);
	//	GridLayout grid = new GridLayout(2, 2);
	//	Container c = getContentPane();
      setLayout(null);
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"������");
		tB1.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.PLAIN, 15));
		p1 = new ChartPanel01();
		p1.setLayout(null);
		
		p2 = new ChartPanel02();
		p2.setLayout(null);
		
		p3 = new ChartPanel03();
		p3.setLayout(null);
		
		p4 = new JPanel();
		p4.setLayout(null);
		p4.setBackground(new  Color(170,220,255));
		TitledBorder jtx1=          //�˻�â ����
 	    		new TitledBorder(new LineBorder(Color.white),"ȸ������ ä��");
 		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
 		 p4.setBorder(jtx1);
		 p1.setBackground(Color.WHITE);
	     p2.setBackground(Color.WHITE);
         p3.setBackground(Color.WHITE);
	   	p4.setBackground(cor);
		setBackground(cor);
		southPanel.add(p1);
		p1.setBounds(0, 0, 600, 350);
		p2.setBounds(600, 0, 600, 350);
		p3.setBounds(0, 350, 600, 350);
		southPanel.add(p2);
		southPanel.add(p3);
		southPanel.add(p4);
		p4.setBounds(602, 420, 570, 260);
		add(northPanel);
		add(southPanel);
		
		setVisible(true);
	}
	
	ActionListener CallXl = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ExcelFrame();
		}
	};
//	
//	public static void main(String[] args) {
//		new ChartFrame();
//	}
}
