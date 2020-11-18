package JAVAP;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class SwingProject_bookscanner {
	String col1[] = {"도서번호","도서이름","저자","출판사","도서상태","소장위치"};
	
	BooksMgr mgr1;
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
	Vector <BooksBean>  vlist1;
	
	void viewlist(){
		mgr1 = new BooksMgr();
	    vlist1 = mgr1.getListMember();
		
		String row1[][] = new String[vlist1.size()][12];
		for (int i = 0; i < row1.length; i++) {
			BooksBean bean = vlist1.elementAt(i);
			row1[i][0] = bean.getBID()+"";
			row1[i][1] = bean.getTITLE();
			row1[i][2] = bean.getAUTHOR();
			row1[i][3] = bean.getPUBLISHER();
			row1[i][5] = bean.getLOCATION();
			row1[i][4] = bean.getBOOKSTATE();
		}
			model = new DefaultTableModel(row1,col1);
			table = new JTable(model);
			 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scr = new JScrollPane(table);
			table.setFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 20) );
			 table.setRowHeight(25);
			  table.getColumnModel().getColumn(0).setPreferredWidth(60);  //JTable 의 컬럼 길이 조절
			    table.getColumnModel().getColumn(1).setPreferredWidth(300);
			    table.getColumnModel().getColumn(2).setPreferredWidth(200);
			    table.getColumnModel().getColumn(3).setPreferredWidth(100);
			    table.getColumnModel().getColumn(4).setPreferredWidth(90);
			    table.getColumnModel().getColumn(5).setPreferredWidth(80);
			    scr.setBounds(0, 0, 670, 380);
		tpanel.add(scr);
		
		}
	
	public SwingProject_bookscanner() {
		viewlist();
		
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
		
		
		cho.add("도서번호");
		cho.add("도서이름");
		cho.setBounds(110	, 50, 150, 50);
		tf.setBounds(320, 50,150 , 27);
		btn.setBounds(470, 50, 100, 27);
		btn.addActionListener(ac2);
		panel.add(cho);
		panel.add(tf);
		panel.add(btn);
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"도서 검색");
		 jtx.setTitleFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 18 ) );
		 panel.setBorder(jtx);
		 panel.setBounds(0, 0, 700, 100);
		 tpanel.setBounds(0, 100, 700, 380);
		 mpanel.add(panel);
		 
			
		btn1.setBounds(550, 500, 100, 40);
		btn1.addActionListener(ac);
		mpanel.add(btn1);
		
		mpanel.add(tpanel);
		
	}
	ActionListener ac2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/*int to = Integer.parseInt(tf.getText());
			System.out.println(mgr1.getett(to));
		
			
			String row1[][] = new String[1][12];
			for (int i = 0; i < row1.length; i++) {
				BooksBean bean = mgr1.getett(to);
				row1[i][0] = bean.getBID()+"";
				row1[i][1] = bean.getTITLE();
				row1[i][2] = bean.getAUTHOR();
				row1[i][3] = bean.getPUBLISHER();
				row1[i][5] = bean.getLOCATION();
				row1[i][4] = bean.getBOOKSTATE();
			}
				model = new DefaultTableModel(row1,col1);
				table = new JTable(model);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scr = new JScrollPane(table);
				table.setFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 20) );
				 table.setRowHeight(25);
				  table.getColumnModel().getColumn(0).setPreferredWidth(60);  //JTable 의 컬럼 길이 조절
				    table.getColumnModel().getColumn(1).setPreferredWidth(300);
				    table.getColumnModel().getColumn(2).setPreferredWidth(200);
				    table.getColumnModel().getColumn(3).setPreferredWidth(100);
				    table.getColumnModel().getColumn(4).setPreferredWidth(90);
				    table.getColumnModel().getColumn(5).setPreferredWidth(80);
				    scr.setBounds(0, 0, 670, 380);
			
			tpanel.removeAll();
			tpanel.revalidate();
			vlist1.removeAllElements();
			tpanel.add(scr);
			
			
		}*/
			String row1[][] = new String[10][12];
			for (int i = 0; i < row1.length; i++) {
				BooksBean bean = mgr1.getsearch(tf.getText());
				row1[i][0] = bean.getBID()+"";
				row1[i][1] = bean.getTITLE();
				row1[i][2] = bean.getAUTHOR();
				row1[i][3] = bean.getPUBLISHER();
				row1[i][5] = bean.getLOCATION();
				row1[i][4] = bean.getBOOKSTATE();
			}
				model = new DefaultTableModel(row1,col1);
				table = new JTable(model);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scr = new JScrollPane(table);
				table.setFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 20) );
				 table.setRowHeight(25);
				  table.getColumnModel().getColumn(0).setPreferredWidth(60);  //JTable 의 컬럼 길이 조절
				    table.getColumnModel().getColumn(1).setPreferredWidth(300);
				    table.getColumnModel().getColumn(2).setPreferredWidth(200);
				    table.getColumnModel().getColumn(3).setPreferredWidth(100);
				    table.getColumnModel().getColumn(4).setPreferredWidth(90);
				    table.getColumnModel().getColumn(5).setPreferredWidth(80);
				    scr.setBounds(0, 0, 670, 380);
			
			tpanel.removeAll();
			tpanel.revalidate();
			vlist1.removeAllElements();
			tpanel.add(scr);
			
			/*tpanel.removeAll();
			tpanel.revalidate();
			vlist1.removeAllElements();
			
				mgr1 = new BooksMgr();
			    vlist1 = mgr1.getsearch(tf.getText());
				
				String row1[][] = new String[vlist1.size()][12];
				for (int i = 0; i < row1.length; i++) {
					BooksBean bean = vlist1.elementAt(i);
					row1[i][0] = bean.getBID()+"";
					row1[i][1] = bean.getTITLE();
					row1[i][2] = bean.getAUTHOR();
					row1[i][3] = bean.getPUBLISHER();
					row1[i][5] = bean.getLOCATION();
					row1[i][4] = bean.getBOOKSTATE();
				}
					model = new DefaultTableModel(row1,col1);
					table = new JTable(model);
					 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					scr = new JScrollPane(table);
					table.setFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 20) );
					 table.setRowHeight(25);
					  table.getColumnModel().getColumn(0).setPreferredWidth(60);  //JTable 의 컬럼 길이 조절
					    table.getColumnModel().getColumn(1).setPreferredWidth(300);
					    table.getColumnModel().getColumn(2).setPreferredWidth(200);
					    table.getColumnModel().getColumn(3).setPreferredWidth(100);
					    table.getColumnModel().getColumn(4).setPreferredWidth(90);
					    table.getColumnModel().getColumn(5).setPreferredWidth(80);
					    scr.setBounds(0, 0, 670, 380);
				tpanel.add(scr);*/
				
				
		}
	};
	ActionListener ac = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow()==-1) {
			MDialog md = new MDialog(memberf, "오류", true, "도서를 선택해 주세요.");
				md.setVisible(true);
			}else {
			String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object 타입을 모두 정수형으로 변환
			String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object 타입을 모두 정수형으로 변환
			String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
			String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
			String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
			String str5 = (String) table.getValueAt(table.getSelectedRow(),5);
			SwingProject.tf8.setText(str0);
			SwingProject.tf9.setText(str1);
			SwingProject.tf10.setText(str2);
			SwingProject.tf12.setText(str4);
			SwingProject.tf13.setText(str5);
			SwingProject.tf14.setText(str3);
			memberf.dispose();
			}
			
		}
	};
}