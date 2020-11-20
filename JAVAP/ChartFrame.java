package JAVAP;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChartFrame extends JPanel{
	ChartPanel01 p1 = new ChartPanel01();
	ChartPanel02 p2 = new ChartPanel02();
	ChartPanel03 p3 = new ChartPanel03();
	JPanel p4 = new JPanel();
	Color cor = new Color(170,220,255);

//	Container c;
	
	public ChartFrame(){
		//setTitle("Grid");
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
	//	setLocationRelativeTo(null);
	//	GridLayout grid = new GridLayout(2, 2);
	//	Container c = getContentPane();
      setLayout(null);
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"독서왕");
		tB1.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 15));
		p1 = new ChartPanel01();
		p1.setLayout(null);
		
		p2 = new ChartPanel02();
		p2.setLayout(null);
		
		p3 = new ChartPanel03();
		p3.setLayout(null);
		
		p4 = new JPanel();
		p4.setLayout(null);
		p4.setBackground(new  Color(170,220,255));
		TitledBorder jtx1=          //검색창 보더
 	    		new TitledBorder(new LineBorder(Color.white),"회원과의 채팅");
 		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
 		 p4.setBorder(jtx1);
		 p1.setBackground(cor);
	     p2.setBackground(cor);
         p3.setBackground(cor);
	   	p4.setBackground(cor);
		setBackground(cor);
		add(p1);
		p1.setBounds(0, 0, 600, 400);
		p2.setBounds(600, 0, 600, 400);
		p3.setBounds(0, 400, 600, 400);
		add(p2);
		add(p3);
		add(p4);
		p4.setBounds(602, 465, 570, 260);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ChartFrame();
	}
}
