package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class SwingProject_1 implements ActionListener{
	String col[] = {"NO.","����","����","���ǻ�","ISBN"};
	String row[][] ;
	int cnt =0;
	JTabbedPane t_1 = new JTabbedPane();
	JPanel lpanel = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel lpanel2 = new JPanel();
	JPanel rpanel = new JPanel();
	JPanel rpanel2 = new JPanel();
	JPanel rmpanel = new JPanel();
	JPanel mpanel = new JPanel();
	JButton btn = new JButton("�˻�");
	JButton btn2 = new JButton("������� �߰�");
	JButton btn3 = new JButton("����");
	JButton btn4 = new JButton("����");
	JLabel lab1 = new JLabel("ISBN �˻�");
	JTextField tf1 = new JTextField(30);
	JTable table;
	JTable table2;
	DefaultTableModel model;
	DefaultTableModel model2;
	JScrollPane scr;
	JScrollPane scr2;
	DefaultTableModel m2;
	DefaultTableModel m;
	
public SwingProject_1() {
	lpanel.setLayout(new BorderLayout());
	lmpanel.setLayout(new BorderLayout());
	rpanel.setLayout(new BorderLayout());
	rmpanel.setLayout(new BorderLayout());
	rpanel2.setLayout(null);
	mpanel.setLayout(new BorderLayout());
	mpanel.setBackground(new  Color(170,220,255));
	lpanel2.setBackground(new Color(170,220,255));
	lpanel.setBackground(new  Color(170,220,255));
	rpanel2.setBackground(new  Color(170,220,255));
	rpanel.setBackground(new  Color(170,220,255));
	rmpanel.setBackground(new  Color(170,220,255));
	
	mpanel.add(lmpanel,BorderLayout.WEST);
	mpanel.add(rmpanel,BorderLayout.CENTER);
	
	/*JTable table = new JTable(row,col);
	table.setPreferredScrollableViewportSize(new Dimension(500,800));
	table.setFillsViewportHeight(true);
	lpanel.add(new JScrollPane(table),BorderLayout.WEST);
	*/
	TitledBorder jtx= 
    		new TitledBorder(new LineBorder(Color.white),"���� ���� ����");
	 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
	model = new DefaultTableModel(row,col);
	table = new JTable(model);
	scr = new JScrollPane(table);
	
	lpanel.setBorder(jtx);
	lpanel.add(scr);
	lpanel2.add(btn3);
	btn3.setPreferredSize(new Dimension(90,40));
	btn4.setPreferredSize(new Dimension(90,40));
	btn4.addActionListener(this);
	lpanel2.add(btn4);
	lmpanel.add(lpanel,BorderLayout.CENTER);
	lmpanel.add(lpanel2,BorderLayout.SOUTH);
	m =(DefaultTableModel)table.getModel()	;
     /*m.insertRow(1, new Object[] {"a","b","b","b","b","b"});
	table.updateUI();*/
	
	TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white),"ISBN �˻�����");
	 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
	 TitledBorder jtx2= 
	    		new TitledBorder(new LineBorder(Color.white),"ISBN �˻�");
		 jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
   rpanel.setBorder(jtx1);
   rpanel2.setBorder(jtx2);
   model2 = new DefaultTableModel(row,col);
	table2 = new JTable(model2);
	scr2 = new JScrollPane(table2);
	
	lab1.setBounds(30, 55, 80, 30);
    tf1.setBounds(110, 55, 200, 30);
    btn.setBounds(350, 55, 100, 30);
    lmpanel.setPreferredSize(new Dimension(650,700));
    table.getColumnModel().getColumn(0).setPreferredWidth(20);  //JTable �� �÷� ���� ����
    table.getColumnModel().getColumn(1).setPreferredWidth(200);
    table.getColumnModel().getColumn(2).setPreferredWidth(100);
    table.getColumnModel().getColumn(3).setPreferredWidth(50);
    table.getColumnModel().getColumn(4).setPreferredWidth(100);
    table.setFont(new Font( "Times", Font.BOLD, 20) );
    table.setRowHeight(25);
    
    rpanel2.add(lab1);
    rpanel2.add(btn);
    btn.addActionListener(this);
	rpanel2.add(tf1);
	tf1.addActionListener(this);
	rpanel.add(scr2);
	rpanel.add(btn2,BorderLayout.SOUTH);
	btn2.setPreferredSize(new Dimension(100,40));
	btn2.addActionListener(this);
	rmpanel.add(rpanel2,BorderLayout.CENTER);
	rmpanel.add(rpanel,BorderLayout.SOUTH);	
    m2 =(DefaultTableModel)table2.getModel()	;
    table2.getColumnModel().getColumn(0).setPreferredWidth(20);  //JTable �� �÷� ���� ����
    table2.getColumnModel().getColumn(1).setPreferredWidth(200);
    table2.getColumnModel().getColumn(2).setPreferredWidth(100);
    table2.getColumnModel().getColumn(3).setPreferredWidth(50);
    table2.getColumnModel().getColumn(4).setPreferredWidth(100);
    table2.setFont(new Font( "Times", Font.BOLD, 20) );
    table2.setRowHeight(25);
    
   
   
   
   
	t_1.add("���� ����",mpanel); 
	t_1.setFont( new Font( "Times", Font.BOLD, 18 ) );
	}

 
@Override
public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand()	;
	 if(cmd.equals(btn.getText())){
		 String item = tf1.getText();
	
	ParseEx3 ex3 = new ParseEx3(item);
	for (int i = 0; i < ex3.title1.size(); i++) {
		 m2.insertRow(i, new Object[] {i+1,ex3.title1.get(i),
				 ex3.author1.get(i),ex3.pub1.get(i),ex3.isbn1.get(i)});
			table.updateUI();
			}
	}else if(cmd.equals(btn2.getText())) {
	cnt++;
		m.insertRow(0, new Object[] {cnt,
				table2.getValueAt(table2.getSelectedRow(),1),
				table2.getValueAt(table2.getSelectedRow(),2),
				table2.getValueAt(table2.getSelectedRow(),3),
				table2.getValueAt(table2.getSelectedRow(),4)});
			table.updateUI();
	}else if (cmd.equals(btn4.getText())) {
		m.removeRow(table.getSelectedRow());
	}
	
}
}
