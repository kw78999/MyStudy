package JAVAP;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.net.ssl.SSLContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class SwingProject_MemberScanner{ 
	String col[] = {"회원번호","회원 이름","회원 등급","전화번호","대여기간","회원상태"};
	String row[][] = {{"1","홍길동","고급","010-8821-1129","4일","일반"},
									{"3","강길동","고급","010-1231-1129","4일","휴먼"}};
	
	JPanel panel = new JPanel();
	JPanel mpanel = new JPanel();
	JPanel tpanel = new JPanel();
	JTable table;
	DefaultTableModel model;
	JScrollPane scr;
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("검색");
	JButton btn1 = new JButton("선택하기");
	static JFrame memberf;
	public SwingProject_MemberScanner() {
		memberf = new JFrame();
		memberf.setBackground(new  Color(170,220,255));
		memberf.setVisible(true);
		memberf.setSize(700,600);
		memberf.setLocationRelativeTo(null);
		memberf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		memberf.add(mpanel);
		
		panel.setBackground(new Color(170,220,255));
		tpanel.setBackground(new Color(170,220,255));
		mpanel.setBackground(new Color(170,220,255));
		mpanel.setLayout(null);
		tpanel.setLayout(null);
		panel.setLayout(null);
		
		cho.add("회원번호");
		cho.add("회원이름");
		cho.setBounds(110	, 50, 150, 50);
		tf.setBounds(320, 50,150 , 27);
		btn.setBounds(470, 50, 100, 27);
		panel.add(cho);
		panel.add(tf);
		panel.add(btn);
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"회원 검색");
		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 panel.setBorder(jtx);
		 panel.setBounds(0, 0, 700, 100);
		 tpanel.setBounds(0, 100, 700, 380);
		 mpanel.add(panel);
		 
			model = new DefaultTableModel(row,col);
			table = new JTable(model);
			scr = new JScrollPane(table);
			table.setFont(new Font( "Times", Font.BOLD, 20) );
			 table.setRowHeight(25);
			 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			  table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
			    table.getColumnModel().getColumn(1).setPreferredWidth(90);
			    table.getColumnModel().getColumn(2).setPreferredWidth(90);
			    table.getColumnModel().getColumn(3).setPreferredWidth(237);
			    table.getColumnModel().getColumn(4).setPreferredWidth(90);
			    table.getColumnModel().getColumn(5).setPreferredWidth(90);
			    scr.setBounds(0, 0, 700, 380);
		tpanel.add(scr);
		btn1.setBounds(550, 500, 100, 40);
		btn1.addActionListener(ac);
		mpanel.add(btn1);
		
		mpanel.add(tpanel);
		
	}
	ActionListener ac = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow()==-1) {
			MDialog md = new MDialog(memberf, "오류", true, "회원을 선택해 주세요.");
				md.setVisible(true);
			}else {
			String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object 타입을 모두 정수형으로 변환
			String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object 타입을 모두 정수형으로 변환
			String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
			String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
			String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
			String str5 = (String) table.getValueAt(table.getSelectedRow(),5);
			SwingProject.tf1.setText(str0);
			SwingProject.tf2.setText(str1);
			SwingProject.tf3.setText(str3);
			SwingProject.tf4.setText(str4);
			SwingProject.tf5.setText(str2);
			SwingProject.tf6.setText(str5);
			memberf.dispose();
			}
			
		}
	};
}
