package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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

public class  SwingProject implements MouseListener{
	private static final LayoutManager FlowLayout = null;

	JTextField tf8 = new JTextField(12);
	JTextField tf11 = new JTextField (20);

	JTextField tf10 = new JTextField(50);
	JTextField tf12 = new JTextField(50);
	JTextField tf13 = new JTextField(50);
	ImageIcon icon;
	Font fon = new Font( "Times", Font.BOLD, 16 );
	JTable table;
	JTable table1;
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
	JTextArea ta2 = new JTextArea(6,30);
	DefaultTableModel model;
	JScrollPane scr;
	public SwingProject() {
		JPanel panel = new JPanel();
		JPanel inpanel = new JPanel();
		JPanel tabpanel = new JPanel();
		JPanel inpanel1 = new JPanel(); 
		JTabbedPane t = new JTabbedPane();
		t.setBackground(new Color(170,220,255));
		JTabbedPane t1 = new JTabbedPane();
		t1.setBackground(new Color(170,220,255));
		
		JFrame frame = new JFrame("gi");
		JLabel label = new JLabel("회원목록");
		label.setFont(new Font("Times",Font.BOLD,25));
		JLabel label1 = new JLabel("도서목록");
		label1.setFont(new Font("Times",Font.BOLD,25));
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		
		
		JButton btn = new JButton("회원 검색");
		String col[] = {"회원번호","회원 이름","회원 등급","전화번호","대여기간"};
		String row[][] = {{"1","홍길동","고급","010-8821-1129","4일"}};
		String col1[] = {"도서번호","도서이름","저자","출판사","도서상태"};
		String row1[][] = {{"1","101","홍길동","일반","일반","0"}};
		frame.setLayout(new BorderLayout());
		inpanel1.setLayout(new BorderLayout());
		p1.setLayout(new BorderLayout());
		p.setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		tabpanel.setLayout(new BorderLayout());
		JPanel panel13 = new JPanel();
		JPanel panel14 = new JPanel();
	JPanel panel15 = new JPanel();
	
	/*	icon = new ImageIcon("C:\\Java\\eclipse-workspace\\myJava\\ch18\\test1.jpg");
	JPanel panel13 = new JPanel() {
		public void paintComponent(Graphics g) {
	//  Approach 1: Dispaly image at at full size 
			Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
        //  Approach 2: Scale image to size of component
        // Dimension d = getSize();
        // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
        // Approach 3: Fix the image position in the scroll pane
        // Point p = scrollPane.getViewport().getViewPosition();
        // g.drawImage(icon.getImage(), p.x, p.y, null);
        setOpaque(false);
        super.paintComponent(g);

	}}; 패널에 이미지 삽입 */


	/*icon = new ImageIcon("C:\\Java\\eclipse-workspace\\myJava\\ch18\\test1.jpg");
	JPanel panel14 = new JPanel() {
		public void paintComponent(Graphics g) {
	//  Approach 1: Dispaly image at at full size 
			Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
        //  Approach 2: Scale image to size of component
        // Dimension d = getSize();
        // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
        // Approach 3: Fix the image position in the scroll pane
        // Point p = scrollPane.getViewport().getViewPosition();
        // g.drawImage(icon.getImage(), p.x, p.y, null);
        setOpaque(false);
        super.paintComponent(g);

	}}; 패널에 이미지 삽입*/


	
		panel13.setLayout(null);
		panel14.setLayout(null);
		JPanel panel12 = new JPanel();
		panel12.setLayout(new BorderLayout());
	panel15.setLayout(new GridLayout(2,1));
		frame.add(inpanel,BorderLayout.NORTH);
		
		
		SwingProject_1 sp_1 = new SwingProject_1();
		SwingProject_2 sp_2 = new SwingProject_2();
		SwingProject_state sp_s = new SwingProject_state();
		
		t.add("대출 / 반납",t1);
		t.add("도서관리",sp_1.t_1);
		t.add("회원관리",sp_2.t_2);
		t.add("이용통계",new JTextArea());
		t.setFont( new Font( "Times", Font.BOLD, 23 ) );
		t.setBackground(new  Color(170,220,255));
		t1.add("대여",panel);
		t1.add("반납",new JTextArea());
		t1.add("이용 현황",sp_s.mpanel);
		t1.setFont( new Font( "Times", Font.BOLD, 18 ) );
		tabpanel.add(t);
		JLabel lab = new JLabel("회원번호");
		JLabel lab1= new JLabel("회원명");
		JLabel lab2= new JLabel("전화번호");
		JLabel lab3= new JLabel("대여기간");
		JLabel lab4= new JLabel("회원등급");
		JLabel lab5= new JLabel("회원상태");
		JLabel lab6= new JLabel("주소");
		JLabel lab7= new JLabel("메모");
		
		JLabel lab8= new JLabel("도서 번호");
		JLabel lab9= new JLabel("도서 이름");
		JLabel lab10= new JLabel("저자");
		JLabel lab11= new JLabel("출판사");
		JLabel lab14= new JLabel("ISBN");
		JLabel lab13= new JLabel("소장위치");
		JLabel lab12= new JLabel("도서상태");
		JLabel lab15= new JLabel("메모");
		
		JButton btn3 = new JButton("도서검색");
		JButton btn4 = new JButton("대출");
		
		
		
		
	//	table.setFillsViewportHeight(true);
		p.add(label,BorderLayout.NORTH);
	
   // table.setFont(new Font( "Times", Font.BOLD, 20) );
  //  table.setRowHeight(25);
    
    model = new DefaultTableModel(row,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
	table = new JTable(model);
	scr = new JScrollPane(table);
	table.addMouseListener(this);
	table.setPreferredScrollableViewportSize(new Dimension(600,290));
	p.add(scr);
		
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
new TitledBorder(new LineBorder(Color.white),"회원정보");
    TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white),"대출자료정보");
    panel13.setBorder(jtx);
  //  panel13.setPreferredSize(new Dimension(580,490));
    lab.setBounds(20, 40, 80, 30);
    lab.setFont(fon);
    panel13.add(lab);
    tf1.setBounds(90, 40, 160, 30);
  panel13.add(tf1);
  lab1.setBounds(290, 40, 80, 30);
  lab1.setFont(fon);
  panel13.add(lab1);
  tf2.setBounds(360, 40, 160, 30);
 panel13.add(tf2);
 
 lab2.setBounds(20, 80, 80, 30);
 lab2.setFont(fon);
 panel13.add(lab2);
 tf3.setBounds(90, 80, 160, 30);
  panel13.add(tf3);
  lab3.setBounds(290, 80, 80, 30);
  lab3.setFont(fon);
  panel13.add(lab3);
  tf4.setBounds(360, 80, 160, 30);
  panel13.add(tf4);
  
  lab4.setBounds(20, 120, 80, 30);
  lab4.setFont(fon);
 panel13.add(lab4);
 tf5.setBounds(90, 120, 160, 30);
  panel13.add(tf5);
  lab5.setBounds(290, 120, 80, 30);
  lab5.setFont(fon);
  panel13.add(lab5);
  tf6.setBounds(360, 120,160, 30);
  panel13.add(tf6);
  
  lab6.setBounds(20, 160, 80, 30);
  lab6.setFont(fon);
  panel13.add(lab6);
  tf7.setBounds(90, 160, 430, 30);
  panel13.add(tf7);
  lab7.setBounds(20, 200, 80, 30);
  lab7.setFont(fon);
  panel13.add(lab7);
  ta1.setBounds(90, 210, 320, 80);
  panel13.add(ta1);
  btn.setBounds(420, 210, 100, 80);
  panel13.add(btn);
  
  panel14.setBorder(jtx1);
  lab8.setBounds(20, 30, 80, 30);
  lab8.setFont(fon);
  panel14.add(lab8);
  tf8.setBounds(100, 30, 160, 30);
  panel14.add(tf8);
  
  lab9.setBounds(290, 30, 80, 30);
  lab9.setFont(fon);
  panel14.add(lab9);
  tf9.setBounds(370, 30, 160, 30);
  panel14.add(tf9);
  
  lab10.setBounds(20, 70, 80, 30);
  lab10.setFont(fon);
  panel14.add(lab10);
  tf10.setBounds(100, 70, 160, 30);
  panel14.add(tf10);
  
  lab12.setFont(fon);
  lab12.setBounds(290, 70, 80, 30);
  panel14.add(lab12);
  tf12.setBounds(370, 70, 160, 30);
  panel14.add(tf12);
  lab13.setFont(fon);
  
  lab13.setBounds(20, 110, 80, 30);
  panel14.add(lab13);
  tf13.setBounds(100, 110, 160, 30);
  panel14.add(tf13);
  lab11.setBounds(290, 110, 80, 30);
  lab11.setFont(fon);
  panel14.add(lab11);
  panel14.add(lab14);
  tf14.setBounds(370, 110, 160, 30);
  panel14.add(tf14);
  lab14.setBounds(20, 150, 80, 30);
  lab14.setFont(fon);
  tf11.setBounds(100, 150, 430, 30);
  panel14.add(tf11);
  lab15.setBounds(20, 190, 80, 30);
  lab15.setFont(fon);
  panel14.add(lab15);
  ta2.setBounds(100, 200, 320, 80);
  panel14.add(ta2);
  btn3.setBounds(430, 200, 100, 80);
  panel14.add(btn3);
  panel14.add(btn4);
  panel15.add(panel13);
  panel15.add(panel14);
  
  
    jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    panel13.setBackground(new  Color(170,220,255));
    panel14.setBackground(new  Color(170,220,255));
    panel.add(panel15);
    panel.setBackground(new Color(170,220,255));

    
    
	
	frame.add(tabpanel,BorderLayout.NORTH);
	frame.setBackground(new  Color(170,220,255));
		 frame.setVisible(true);
		 frame.setSize(1200,825);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object 타입을 모두 정수형으로 변환
		String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object 타입을 모두 정수형으로 변환
		String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
		String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
		String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
		
		tf1.setText(str0);
		tf2.setText(str1);
		tf3.setText(str3);
		tf4.setText(str4);
		tf5.setText(str2);
		tf6.setText("일반");
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
	
	
	public static void main(String[] args) {
		new SwingProject();
	}

}