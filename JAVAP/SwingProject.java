package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class  SwingProject {
	private static final LayoutManager FlowLayout = null;

	JTextField tf8 = new JTextField(12);
	JTextField tf11 = new JTextField (20);

	JTextField tf10 = new JTextField(50);
	JTextField tf12 = new JTextField(50);
	JTextField tf13 = new JTextField(50);
	
	public SwingProject() {
		JPanel panel = new JPanel();
		JPanel inpanel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel inpanel1 = new JPanel(); 
		JTabbedPane t = new JTabbedPane();
		t.setBackground(new Color(170,220,255));
		JTabbedPane t1 = new JTabbedPane();
		t1.setBackground(new Color(170,220,255));
		
		JFrame frame = new JFrame("gi");
		JLabel label = new JLabel("ȸ�����");
		label.setFont(new Font("Times",Font.BOLD,25));
		JLabel label1 = new JLabel("�������");
		label1.setFont(new Font("Times",Font.BOLD,25));
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		TextField tf = new TextField(10);
		JTextField tf1 = new JTextField(12);
		JTextField tf2 = new JTextField(12);
		JTextField tf3 = new JTextField(12);
		JTextField tf4 = new JTextField(12);
		JTextField tf5 = new JTextField(7);
		JTextField tf6 = new JTextField(13);
		JTextField tf7 = new JTextField(50);
		JTextField tf9 = new JTextField(12);
		JTextField tf14 = new JTextField(12);
		JTextArea ta1 = new JTextArea(6,30);
		String col[] = {"����","ȸ����ȣ","ȸ����","ȸ������","ȸ�����","��ȭ��ȣ"};
		String row[][] = {{"1","101","ȫ�浿","�Ϲ�","�Ϲ�","0"}};
		String col1[] = {"����","��������","��Ϲ�ȣ","����","����","������"};
		String row1[][] = {{"1","101","ȫ�浿","�Ϲ�","�Ϲ�","0"}};
		frame.setLayout(new BorderLayout());
		inpanel1.setLayout(new BorderLayout());
		p1.setLayout(new BorderLayout());
		p.setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		panel1.setLayout(new BorderLayout());
		JPanel panel13 = new JPanel();
		JPanel panel14 = new JPanel();
		JPanel panel15 = new JPanel();
	//	panel14.setLayout(new FlowLayout());
		panel13.setLayout(null);
		JPanel panel12 = new JPanel();
		panel12.setLayout(new BorderLayout());
		panel15.setLayout(new GridLayout(2,1));
		frame.add(inpanel,BorderLayout.NORTH);
		
		
		SwingProject_1 sp_1 = new SwingProject_1();
		SwingProject_2 sp_2 = new SwingProject_2();
		t.add("���� / �ݳ�",t1);
		t.add("��������",sp_1.t_1);
		t.add("ȸ������",sp_2.t_2);
		t.add("�̿����",new JTextArea());
		t.setFont( new Font( "Times", Font.BOLD, 23 ) );
		t.setBackground(new  Color(170,220,255));
		t1.add("�뿩",panel);
		t1.add("�ݳ�",new JTextArea());
		t1.add("�̿� ��Ȳ",new JTextArea());
		t1.setFont( new Font( "Times", Font.BOLD, 18 ) );
		panel1.add(t);
		JLabel lab = new JLabel("ȸ������");
		JLabel lab1= new JLabel("ȸ����");
		JLabel lab2= new JLabel("��ȭ��ȣ");
		JLabel lab3= new JLabel("����/���ɱǼ�");
		JLabel lab4= new JLabel("ȸ�����");
		JLabel lab5= new JLabel("ȸ������");
		JLabel lab6= new JLabel("�ּ�");
		JLabel lab7= new JLabel("�޸�");
		JLabel lab8= new JLabel("��Ϲ�ȣ");
		JLabel lab9= new JLabel("������");
		JLabel lab10= new JLabel("�ݳ�������");
		JLabel lab11= new JLabel("������");
		JLabel lab12= new JLabel("ISBN");
		JLabel lab13= new JLabel("���ǻ�");
		JLabel lab14= new JLabel("����");
		JButton btn1 = new JButton("ȸ���˻�");
		JButton btn2 = new JButton("Ư���뿩" );
		JButton btn3 = new JButton("�����˻�");
		JButton btn4 = new JButton("����");
		
		
		
		JTable table = new JTable(row,col);
		table.setPreferredScrollableViewportSize(new Dimension(600,290));
		table.setFillsViewportHeight(true);
		p.add(label,BorderLayout.NORTH);
	p.add(new JScrollPane(table),BorderLayout.CENTER);
    table.setFont(new Font( "Times", Font.BOLD, 20) );
    table.setRowHeight(25);
		
	JTable table1 = new JTable(row1,col1);
	table1.setPreferredScrollableViewportSize(new Dimension(600,290));
	table1.setFillsViewportHeight(true);
	p1.add(label1,BorderLayout.NORTH);
    p1.add(new JScrollPane(table1),BorderLayout.CENTER);
    table1.setFont(new Font( "Times", Font.BOLD, 20) );
    table1.setRowHeight(25);
	
    p.setBackground(new  Color(170,220,255));
    p1.setBackground(new  Color(170,220,255));
    inpanel1.add(p,BorderLayout.NORTH);
    inpanel1.add(p1,BorderLayout.CENTER);
    panel.add(inpanel1,BorderLayout.WEST);
    
    TitledBorder jtx = 
new TitledBorder(new LineBorder(Color.white),"ȸ������");
    TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white),"�����ڷ�����");
    panel13.setBorder(jtx);
    lab.setBounds(20, 40, 80, 30);
    panel13.add(lab);
    tf1.setBounds(90, 40, 160, 30);
  panel13.add(tf1);
  lab1.setBounds(300, 40, 80, 30);
  panel13.add(lab1);
  tf2.setBounds(360, 40, 160, 30);
 panel13.add(tf2);
 
 lab2.setBounds(20, 90, 80, 30);
 panel13.add(lab2);
 tf3.setBounds(90, 90, 160, 30);
  panel13.add(tf3);
  lab3.setBounds(270, 90, 80, 30);
  panel13.add(lab3);
  tf4.setBounds(360, 90, 160, 30);
  panel13.add(tf4);
  
  lab4.setBounds(20, 140, 80, 30);
 panel13.add(lab4);
 tf5.setBounds(90, 140, 160, 30);
  panel13.add(tf5);
  lab5.setBounds(290, 140, 80, 30);
  panel13.add(lab5);
  tf6.setBounds(360, 140,160, 30);
  panel13.add(tf6);
  
/*  lab6.setBounds(4, 40, 80, 30);
  panel13.add(lab6);
  panel13.add(tf7);
  panel13.add(lab7);
  panel13.add(ta1);
  panel13.add(btn1);*/
  panel14.setBorder(jtx1);
  panel14.add(lab8);
  panel14.add(tf8);
  panel14.add(lab9);
  panel14.add(tf9);
  panel14.add(lab10);
  panel14.add(tf10);
  panel14.add(lab12);
  panel14.add(tf12);
  panel14.add(lab13);
  panel14.add(tf13);
  panel14.add(lab14);
  panel14.add(tf14);
  panel14.add(lab11);
  panel14.add(tf11);
  panel14.add(btn2);
  panel14.add(btn3);
  panel14.add(btn4);
  panel15.add(panel13);
  panel15.add(panel14);
  
  
    jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    panel13.setBackground(new  Color(170,220,255));
    panel14.setBackground(new  Color(170,220,255));
    panel.add(panel15,BorderLayout.CENTER);
    panel.setBackground(new Color(170,220,255));

    
    
	
	frame.add(panel1,BorderLayout.NORTH);
	frame.setBackground(new  Color(170,220,255));
		 frame.setVisible(true);
		 frame.setSize(1200,825);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new SwingProject();
	}
}