package JAVAP;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
import javax.swing.table.DefaultTableModel;


public class  SwingProject implements ActionListener{
	ImageIcon normalIcon = new ImageIcon("C:\\Users\\deers\\Desktop\\�� ����\\gitTest1\\gitTest1\\test3.jpg");
	static JTextField tf8 = new JTextField(12);
	JTextField tf11 = new JTextField (20);

	static JTextField tf10 = new JTextField(50);
	static JTextField tf12 = new JTextField(50);
	static JTextField tf13 = new JTextField(50);
	JButton btn ;
	JButton btn3 ;
	ImageIcon icon;
	Font fon = new Font( "Times", Font.BOLD, 16 );
	JTable table;
	JTable table1;
	TextField tf = new TextField(10);
	static JTextField tf1 = new JTextField(12);
	static JTextField tf2 = new JTextField(12);
	static JTextField tf3 = new JTextField(12);
	static JTextField tf4 = new JTextField(12);
	static JTextField tf5 = new JTextField(7);
	static JTextField tf6 = new JTextField(13);
	JTextField tf7 = new JTextField(50);
	static JTextField tf9 = new JTextField(12);
	static 	JTextField tf14 = new JTextField(12);
	JTextField tf15 = new JTextField(12);
	JTextField tf16 = new JTextField(12);
	JTextArea ta1 = new JTextArea("ä��â");
	DefaultTableModel model;
	DefaultTableModel model1;
	JScrollPane scr;
	JScrollPane scr1;
	JButton lentalbtn = new JButton("�����ϱ�");
	static JFrame frame;
	public SwingProject() {
		
		JPanel panel = new JPanel();
		JPanel tabpanel = new JPanel();
		JPanel inpanel1 = new JPanel(); 
		JPanel panel13 = new JPanel();
		JPanel panel14 = new JPanel();
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel panel15 = new JPanel();
		JTabbedPane t = new JTabbedPane();
		t.setBackground(new Color(170,220,255));
		JTabbedPane t1 = new JTabbedPane();
		t1.setBackground(new Color(170,220,255));
		
		JFrame frame = new JFrame("�������� ���α׷�");
		JLabel label = new JLabel("ȸ�����");
		label.setFont(new Font("Times",Font.BOLD,25));
		JLabel label1 = new JLabel("�������");
		label1.setFont(new Font("Times",Font.BOLD,25));
		
		
		String col[] = {"ȸ����ȣ","ȸ�� �̸�","ȸ�� ���","��ȭ��ȣ","�뿩�Ⱓ","ȸ������"};
		String row[][] = {{"1","ȫ�浿","���","010-8821-1129","4��","�Ϲ�"},
										{"3","���浿","���","010-1231-1129","4��","�޸�"}};
		String col1[] = {"������ȣ","�����̸�","����","���ǻ�","��������","������ġ"};
		String row1[][] = {{"1","�ڹ� ������","ȫ�浿","�ѱ�����","����","C-1"},
										{"1","�ڹ� ������","ȫ�浿","�ѱ�����","�Ұ���","A-2"}};
		
		frame.setLayout(new BorderLayout());
		inpanel1.setLayout(new BorderLayout());
		p1.setLayout(new BorderLayout());
		p.setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		tabpanel.setLayout(new BorderLayout());
		panel13.setLayout(null);
		panel14.setLayout(null);
		panel15.setLayout(null);
	
		
		
    panel13.setBackground(new  Color(170,220,255));
    panel14.setBackground(new  Color(170,220,255));
    panel.setBackground(new Color(170,220,255));
	
		SwingProject_1 sp_1 = new SwingProject_1();
		SwingProject_2 sp_2 = new SwingProject_2();
		SwingProject_state sp_s = new SwingProject_state();
		GraphicChartEx1 gc = new GraphicChartEx1();
		
		t.add("���� / �ݳ�",t1);
		t.add("��������",sp_1.t_1);
		t.add("ȸ������",sp_2.t_2);
		t.add("�̿����",gc.mpanel);
		t.setFont( new Font( "Times", Font.BOLD, 23 ) );
		t.setBackground(new  Color(170,220,255));
		
		t1.add("�뿩",panel);
		t1.add("�ݳ�",new JTextArea());
		t1.add("�̿� ��Ȳ",sp_s.mpanel);
		t1.setFont( new Font( "Times", Font.BOLD, 18 ) );
		tabpanel.add(t);
		
		JLabel lab = new JLabel("ȸ�� ��ȣ");
		JLabel lab1= new JLabel("ȸ�� �̸�");
		JLabel lab2= new JLabel("��ȭ ��ȣ");
		JLabel lab3= new JLabel("�뿩 �Ⱓ");
		JLabel lab4= new JLabel("ȸ�� ���");
		JLabel lab5= new JLabel("ȸ�� ����");
		
		JLabel lab8= new JLabel("���� ��ȣ");
		JLabel lab9= new JLabel("�� ��");
		JLabel lab10= new JLabel("�� ��");
		JLabel lab11= new JLabel("���ǻ�");
		JLabel lab14= new JLabel("ISBN");
		JLabel lab13= new JLabel("���� ��ġ");
		JLabel lab12= new JLabel("���� ����");
		JLabel lab15= new JLabel("������");
		JLabel lab16= new JLabel("�ݳ���");
		
		 btn3 = new JButton();
		JButton btn4 = new JButton("����");
		lentalbtn.addActionListener(this);
		
		
		
		p.add(label,BorderLayout.NORTH);
		p1.add(label1,BorderLayout.NORTH);
	
  
    model = new DefaultTableModel(row,col);   //�߰� ���� ������ ������ DefaultTableModel ����
	table = new JTable(model);
	scr = new JScrollPane(table);
	 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	table.addMouseListener(member);
	table.setPreferredScrollableViewportSize(new Dimension(600,275));
	
	 table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
	    table.getColumnModel().getColumn(1).setPreferredWidth(90);
	    table.getColumnModel().getColumn(2).setPreferredWidth(80);
	    table.getColumnModel().getColumn(3).setPreferredWidth(200);
	    table.getColumnModel().getColumn(4).setPreferredWidth(80);
	    table.getColumnModel().getColumn(5).setPreferredWidth(80);
	  table.setFont(new Font( "Times", Font.BOLD, 20) );
	   table.setRowHeight(25);
	    
	p.add(scr);
	
	model1 = new DefaultTableModel(row1,col1);   //�߰� ���� ������ ������ DefaultTableModel ����
	table1 = new JTable(model1);
	scr1 = new JScrollPane(table1);
	table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	table1.addMouseListener(book);
	
	table1.setPreferredScrollableViewportSize(new Dimension(600,200));
	table1.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
	table1.getColumnModel().getColumn(1).setPreferredWidth(250);
	table1.getColumnModel().getColumn(2).setPreferredWidth(80);
	table1.getColumnModel().getColumn(3).setPreferredWidth(150);
	table1.getColumnModel().getColumn(4).setPreferredWidth(80);
    table1.setFont(new Font( "Times", Font.BOLD, 20) );
    table1.setRowHeight(25);
    p1.add(scr1);
	
    p.setBackground(new  Color(170,220,255));
    panel15.setBackground(new  Color(170,220,255));
    p1.setBackground(new  Color(170,220,255));
    inpanel1.add(p,BorderLayout.NORTH);
    inpanel1.add(p1,BorderLayout.CENTER);
    panel.add(inpanel1,BorderLayout.WEST);
    
    TitledBorder jtx=                        //Ÿ��Ʋ �������� 
new TitledBorder(new LineBorder(Color.white),"ȸ������");
    TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white),"��������");
    panel13.setBorder(jtx);
    jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    
    lab.setBounds(20, 35, 80, 30);
    lab.setFont(fon);
    panel13.add(lab);
    tf1.setBounds(100, 35, 160, 25);
  panel13.add(tf1);
  lab1.setBounds(290, 35, 80, 30);
  lab1.setFont(fon);
  panel13.add(lab1);
  tf2.setBounds(370, 35, 160, 25);
 panel13.add(tf2);
 
 lab2.setBounds(20, 70, 80, 30);
 lab2.setFont(fon);
 panel13.add(lab2);
 tf3.setBounds(100, 70, 160, 25);
  panel13.add(tf3);
  lab3.setBounds(290, 70, 80, 30);
  lab3.setFont(fon);
  panel13.add(lab3);
  tf4.setBounds(370, 70, 160, 25);
  panel13.add(tf4);
  
  lab4.setBounds(20, 105, 80, 30);
  lab4.setFont(fon);
 panel13.add(lab4);
 tf5.setBounds(100, 105, 160, 25);
  panel13.add(tf5);
  lab5.setBounds(290, 105, 80, 30);
  lab5.setFont(fon);
  panel13.add(lab5);
  tf6.setBounds(370, 105,160, 25);
  panel13.add(tf6);
  

  Image btnimg = normalIcon.getImage();         //��ư�� �̹��� �߰�
  Image change = btnimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  ImageIcon changeicon = new ImageIcon(change);
  JButton btn = new JButton(changeicon);
  
  btn.setBounds(85, 0, 30, 30);
  btn.addActionListener(memberscan);
  panel13.add(btn);
  
  panel14.setBorder(jtx1);
  lab8.setBounds(20, 35, 80, 30);
  lab8.setFont(fon);
  panel14.add(lab8);
  tf8.setBounds(100, 35, 160, 25);
  panel14.add(tf8);
  
  lab9.setBounds(290, 35, 80, 30);
  lab9.setFont(fon);
  panel14.add(lab9);
  tf9.setBounds(370, 35, 160, 25);
  panel14.add(tf9);
  
  lab10.setBounds(20, 70, 80, 30);
  lab10.setFont(fon);
  panel14.add(lab10);
  tf10.setBounds(100, 70, 160, 25);
  panel14.add(tf10);
  
  lab12.setFont(fon);
  lab12.setBounds(290, 70, 80, 30);
  panel14.add(lab12);
  tf12.setBounds(370, 70, 160, 25);
  panel14.add(tf12);
  lab13.setFont(fon);
  
  lab13.setBounds(20, 105, 80, 30);
  panel14.add(lab13);
  tf13.setBounds(100, 105, 160, 25);
  panel14.add(tf13);
  lab11.setBounds(290, 105, 80, 30);
  lab11.setFont(fon);
  panel14.add(lab11);
  panel14.add(lab14);
  tf14.setBounds(370, 105, 160, 25);
  panel14.add(tf14);
  lab14.setBounds(120, 105, 80, 30);
  lab14.setFont(fon);
  panel14.add(lab15);
  lab15.setBounds(20, 140, 80, 30);
  lab15.setFont(fon);
  panel14.add(lab16);
  lab16.setBounds(290, 140, 80, 30);
  lab16.setFont(fon);
  panel14.add(tf15);
  tf15.setBounds(100, 140, 160, 25);
  panel14.add(tf16);
  tf16.setBounds(370, 140, 160, 25);
  
  
  
  btn3.setBounds(430, 200, 100, 80);
  
  Image btnimg2 = normalIcon.getImage();         //��ư�� �̹��� �߰�
  Image change2 = btnimg2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  ImageIcon changeicon2 = new ImageIcon(change2);
  JButton btn3 = new JButton(changeicon2);
  btn3.setBounds(85, 0, 30, 30);
  btn3.addActionListener(bookscan);
  
  
  panel14.add(btn3);
  panel14.add(btn4);
  panel15.add(panel13);
  panel15.add(panel14);
panel13.setBounds(0, 0, 580, 150);
panel14.setBounds(0, 160, 580, 180);
  panel15.add(lentalbtn);
  lentalbtn.setBounds(370, 350, 160, 40);
    jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    panel.add(panel15);
    panel15.add(ta1);
    ta1.setBounds(30, 420, 500, 250);

    
    
	
	frame.add(tabpanel,BorderLayout.NORTH);
	frame.setBackground(new  Color(170,220,255));
		 frame.setVisible(true);
		 frame.setSize(1200,825);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	ActionListener memberscan = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new SwingProject_MemberScanner();
		}
	};
	ActionListener bookscan = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new SwingProject_bookscanner();
		}
	};
	@Override
	public void actionPerformed(ActionEvent e) {   //�����ư ���� �̺�Ʈ
		String cmd = e.getActionCommand();
		if(cmd.equals(lentalbtn.getText())) {
			if(tf1.getText().equals("")) {
			MDialog md = new MDialog(frame,"����", true,"ȸ�������� �����ϴ�.");
			md.setVisible(true);
			}else if (tf8.getText().equals("")) {
				MDialog md1 = new MDialog(frame,"����", true,"���������� �����ϴ�.");
				md1.setVisible(true);
		}else if(tf1.getText().equals("1")&&tf12.getText().equals("����")) {
			MDialog md2 = new MDialog(frame,"���ȸ�� �Դϴ�", true,"���� �޾ư�����.");
			md2.setVisible(true);
		}else if(tf12.getText().equals("�Ұ���")) {
			MDialog md2 = new MDialog(frame,"����", true,"������ ����Ұ��� �մϴ�.");
			md2.setVisible(true);
		}else {
			MDialog md2 = new MDialog(frame,"����", true,"���� �Ǿ����ϴ�.");
			md2.setVisible(true);
		}
	}
}
	MouseListener member = new MouseListener() {       //ȸ������� ����� �����ʿ� ������
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
		String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
		String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
		String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
		String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
		String str5 = (String) table.getValueAt(table.getSelectedRow(),5);
		
		tf1.setText(str0);
		tf2.setText(str1);
		tf3.setText(str3);
		tf4.setText(str4);
		tf5.setText(str2); 
		tf6.setText(str5);
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	};
	
MouseListener book = new MouseListener() {            //��������� ������ �����ʿ� ������
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			String str00 = (String) table1.getValueAt(table1.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
			String str11 = (String) table1.getValueAt(table1.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
			String str22 = (String) table1.getValueAt(table1.getSelectedRow(),2);
			String str33 = (String) table1.getValueAt(table1.getSelectedRow(),3);
			String str44 = (String) table1.getValueAt(table1.getSelectedRow(),4);
			String str55 = (String) table1.getValueAt(table1.getSelectedRow(),5);
			tf8.setText(str00); 
			tf9.setText(str11);
			tf10.setText(str22);
			tf12.setText(str44);
			tf14.setText(str33); 
			tf13.setText(str55);
		}	
};
	public static void main(String[] args) {
		new SwingProject();
	}
	

}
