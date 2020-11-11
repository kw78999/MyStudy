package JAVAP;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class SwingProject_2 implements ActionListener,ItemListener,MouseListener{
	JTabbedPane t_2 = new JTabbedPane();
	JPanel mpanel = new JPanel();
	JPanel lpanel = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel lpanel2 = new JPanel();
//	JPanel rpanel = new JPanel();
	
	ImageIcon icon;
	
	static int cnt;
	
	JButton btn1 = new JButton("회원생성");
	JButton btn2 = new JButton("수정");
	JButton btn3 = new JButton("삭제");
	JLabel lab1 = new JLabel("대여기간");
	JLabel lab2 = new JLabel("회원이름");
	JLabel lab3 = new JLabel("회원등급");
	JLabel lab4 = new JLabel("전화번호");
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JTextField tf3 = new JTextField(20);
	Choice cho = new Choice();
	String cho1 ;
	DefaultTableModel m2;
	Color bg = new Color(54,201,255);
	
	JTable table7;
	DefaultTableModel medel3;
	JScrollPane scr;
	String col[] = {"회원번호","이름","회원등급","전화번호","대여기간"};
	String row[][] ;
	
	
	public SwingProject_2() {
		mpanel.setBackground(new  Color(170,220,255));
		lpanel.setBackground(new  Color(170,220,255));
		lmpanel.setBackground(new  Color(170,220,255));
		lpanel2.setBackground(new  Color(170,220,255));
	//	rpanel.setBackground(new  Color(0,162,240));
		icon = new ImageIcon("C:\\Java\\eclipse-workspace\\myJava\\ch18\\test1.jpg");
	JPanel rpanel = new JPanel() {
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

	}};
		mpanel.setLayout(new BorderLayout());
		lmpanel.setLayout(new BorderLayout());
		lpanel.setLayout(new BorderLayout());
	rpanel.setLayout(null);
		 lpanel.setPreferredSize(new Dimension(750,600));
		 
		
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"전체 회원");
		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		DefaultTableModel model3 = new DefaultTableModel(row,col);
		
		table7 = new JTable(model3);
		scr = new JScrollPane(table7);
		lpanel.setBorder(jtx);
		lpanel.add(scr);
		
		lpanel2.add(btn2,BorderLayout.SOUTH);
		btn2.setPreferredSize(new Dimension(90,40));
		lpanel2.add(btn3,BorderLayout.SOUTH);
		btn3.setPreferredSize(new Dimension(90,40));
		btn3.addActionListener(this);
		
		
		
		m2 =(DefaultTableModel)table7.getModel();
		table7.getColumnModel().getColumn(0).setPreferredWidth(30);//JTable 의 컬럼 길이 조절
	    table7.getColumnModel().getColumn(1).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(3).setPreferredWidth(300);
	    table7.getColumnModel().getColumn(4).setPreferredWidth(90);
	    table7.setFont(new Font( "Times", Font.BOLD, 20) );
	    table7.setRowHeight(25);
		
		TitledBorder jtx1= 
	    		new TitledBorder(new LineBorder(Color.white),"회원 생성");
		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 rpanel.setBorder(jtx1);
		 
		 rpanel.add(lab1);
		 lab1.setBounds(30, 240, 120, 30);
		 lab1.setOpaque(true); 
		 lab1.setBackground(bg);
		 lab1.setForeground(Color.white);
		 lab1.setFont(new Font("Times",Font.BOLD,15));
		 
		 rpanel.add(tf1);
		 tf1.setBounds(150,240,180,30);
		 tf1.addActionListener(this);
		 rpanel.add(lab2);
		 lab2.setBounds(30, 110, 100, 50);
		 lab2.setOpaque(false); 
	//	 lab2.setBackground(bg);
		// lab2.setForeground(Color.CYAN);
		 lab2.setFont(new Font("Times",Font.BOLD,20));
		 rpanel.add(tf2);
		 tf2.setBounds(150,120,180,30);
		 tf2.addActionListener(this);
		 rpanel.add(lab3);
		 lab3.setBounds(30, 170, 100, 50);
		 lab3.setFont(new Font("Times",Font.BOLD,20));
		 cho.add("등급 선택");
		 cho.add("일반");
		 cho.add("고급");
		 cho.add("VIP");
		 rpanel.add(cho);
		 cho.setBounds(150, 185, 150, 90);
		 cho.addItemListener(this);
		 rpanel.add(lab4);
		 lab4.setBounds(30, 300, 100, 50);
		 lab4.setFont(new Font("Times",Font.BOLD,20));
		 rpanel.add(tf3);
		 tf3.setBounds(150,310,180,30);
		tf3.addActionListener(this);
		rpanel.add(btn1);
		btn1.setBounds(150, 420, 170, 40);
		btn1.addActionListener(this);
		btn1.addMouseListener(this);
		btn1.setBackground(bg);
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Times",Font.BOLD,14));
		
		
		
		lmpanel.add(lpanel,BorderLayout.CENTER);
		lmpanel.add(lpanel2,BorderLayout.SOUTH);
		
		mpanel.add(lmpanel,BorderLayout.WEST);
		mpanel.add(rpanel,BorderLayout.CENTER);
		
		
		
		t_2.add("회원 정보",mpanel); 
		t_2.setFont( new Font( "Times", Font.BOLD, 18 ) );
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		cho1 = cho.getSelectedItem();
		if(cho.getSelectedItem().equals("일반")) {
			tf1.setText("3일");
		}else if (cho.getSelectedItem().equals("고급")) {
			tf1.setText("4일");
		}else if (cho.getSelectedItem().equals("VIP")) {
			tf1.setText("7일");
		}else if (cho.getSelectedItem().equals("등급 선택")) {
			tf1.setText("error");
			tf3.setText("error");
			tf2.setText("error");
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cho.getSelectedItem().equals("일반")) {
			tf1.setText("3일");
		}else if (cho.getSelectedItem().equals("고급")) {
			tf1.setText("4일");
		}else if (cho.getSelectedItem().equals("VIP")) {
			tf1.setText("7일");
		}else if (cho.getSelectedItem().equals("등급 선택")) {
			tf1.setText("error");
			tf3.setText("error");
			tf2.setText("error");
		}
		if( cmd.equals(btn1.getText())) {
			m2.insertRow(0, new Object[] {cnt,tf2.getText(),
					 cho.getSelectedItem(),tf3.getText(),tf1.getText()});
				table7.updateUI();
					cnt++;
					
					
					
					
		}else if (cmd.equals(btn2.getText())) {
			
		}else if (cmd.equals(btn3.getText())) {
			m2.removeRow(table7.getSelectedRow());       //어느 열을 눌러도 행 전체 삭제
			
			
		}}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn1 = (JButton)e.getSource();
        btn1.setBackground(Color.gray);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn1 = (JButton)e.getSource();
        btn1.setBackground(Color.gray);


	}
	 @Override
	    public void mouseExited(MouseEvent e) {
			JButton btn1 = (JButton)e.getSource();
	        btn1.setBackground(bg);   
	 }

			
		
			
		}
