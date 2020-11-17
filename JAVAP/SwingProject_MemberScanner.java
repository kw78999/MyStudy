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

import JAVAP.BMEMBERSBean;


public class SwingProject_MemberScanner{ 
	String col[] = {"ȸ����ȣ","ȸ�� �̸�","ȸ�� ���","��ȭ��ȣ","�뿩�Ⱓ","�뿩Ƚ��","���Ⱑ�� �Ǽ�"};
	
	BMEMBERSMgr mgr;
	JPanel panel = new JPanel();
	JPanel mpanel = new JPanel();
	JPanel tpanel = new JPanel();
	JTable table;
	DefaultTableModel model;
	JScrollPane scr;
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("�˻�");
	JButton btn1 = new JButton("�����ϱ�");
	static JFrame memberf;
	Vector<BMEMBERSBean> vlist;
	public SwingProject_MemberScanner() {
		
		mgr = new BMEMBERSMgr();
		
	    vlist = mgr.getListMember();
		String row[][] = new String[vlist.size()][10];
		for (int i = 0; i < row.length; i++) {
			BMEMBERSBean bean = vlist.elementAt(i);
			row[i][0] = bean.getMID()+"";
			row[i][1] = bean.getMNAME();
			row[i][2] = bean.getMGRADE();
			row[i][3] = bean.getMPHONE();
			row[i][4] = bean.getMAXRENTAL();
			row[i][5] = bean.getECOUNT();
			row[i][6] = bean.getELIMIT();
		}
		
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
		
		cho.add("ȸ����ȣ");
		cho.add("ȸ���̸�");
		cho.setBounds(110	, 50, 150, 50);
		tf.setBounds(320, 50,150 , 27);
		btn.setBounds(470, 50, 100, 27);
		panel.add(cho);
		panel.add(tf);
		panel.add(btn);
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"ȸ�� �˻�");
		 jtx.setTitleFont(new Font( "��Ǯ���¿��� Medium", Font.PLAIN, 18 ) );
		 panel.setBorder(jtx);
		 panel.setBounds(0, 0, 700, 100);
		 tpanel.setBounds(0, 100, 700, 380);
		 mpanel.add(panel);
		 
			model = new DefaultTableModel(row,col);
			table = new JTable(model);
			 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scr = new JScrollPane(table);
			table.setFont(new Font( "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
			 table.setRowHeight(25);
			 
			  table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
			    table.getColumnModel().getColumn(1).setPreferredWidth(90);
			    table.getColumnModel().getColumn(2).setPreferredWidth(80);
			    table.getColumnModel().getColumn(3).setPreferredWidth(190);
			    table.getColumnModel().getColumn(4).setPreferredWidth(80);
			    table.getColumnModel().getColumn(5).setPreferredWidth(80);
			    table.getColumnModel().getColumn(6).setPreferredWidth(130);
			    scr.setBounds(0, 0, 670, 380);
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
			MDialog md = new MDialog(memberf, "����", true, "ȸ���� ������ �ּ���.");
				md.setVisible(true);
			}else {
			String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
			String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
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
