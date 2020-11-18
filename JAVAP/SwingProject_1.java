package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class SwingProject_1   implements MouseListener{
	String col[] = {"NO.","����","����","���ǻ�","ISBN","��������","������ġ","����","��������","����Ƚ��","��������"};
 //  String row[][] ;
	ImageIcon img;
	int cnt =0;
	ImageIcon normalIcon2 = new ImageIcon("C:\\Java\\eclipse-workspace\\image\\\\test2.jpg");
	
	JTabbedPane t_1 = new JTabbedPane();
	JPanel lpanel = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel lpanel2 = new JPanel();
	JPanel rpanel = new JPanel();
	JPanel rpanel2 = new JPanel();
	JPanel cpanel = new JPanel();
	JPanel rmpanel = new JPanel();
	JPanel mpanel = new JPanel();
	JButton btn;
	JButton btn3 = new JButton("����");
	JButton btn4 = new JButton("����");
	JLabel lab2 = new JLabel("��� ��ȣ");
	JLabel lab3 = new JLabel("����");
	JLabel lab4 = new JLabel("����");
	JLabel lab5 = new JLabel("���ǻ�");
	JLabel lab6 = new JLabel("ISBN");
	JLabel lab7 = new JLabel("��������");
	JLabel lab8 = new JLabel("����");
	JLabel lab9 = new JLabel("������ġ");
	JLabel lab10 = new JLabel("��������");
	
	//JTextArea ta = new JTextArea();
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JTextField tf3 = new JTextField(10);
	JTextField tf4 = new JTextField(10);
	JTextField tf5 = new JTextField(10);
	JTextField tf6 = new JTextField(10); 
	JTextField tf8 = new JTextField(10); 
	JTextField tf9 = new JTextField(10); 
	JTextField tf10 = new JTextField(10); 
	JTextField tf15 = new JTextField(10); 
	JTextField tf16 = new JTextField(10); 
	
	JTable table7;
	DefaultTableModel model7;
	JScrollPane scr;
	
	Font fon = new Font( "Times", Font.BOLD, 18 );
	Color bg = new Color(54,201,255);
	
	String row1[][];
	BooksMgr  mgr= new BooksMgr();
	Vector <BooksBean>  vlist ;
	
	public void viewList() {
		vlist = mgr.getListMember();
		row1 = new String[vlist.size()][12];
		for (int i = 0; i < row1.length; i++) {
			BooksBean bean = vlist.elementAt(i);
			row1[i][0] = bean.getBID()+"";
			row1[i][4] = bean.getISBN();
			row1[i][1] = bean.getTITLE();
			row1[i][2] = bean.getAUTHOR();
			row1[i][3] = bean.getPUBLISHER();
			row1[i][6] = bean.getLOCATION();
			row1[i][5] = bean.getBOOKSTATE();
			row1[i][7] = bean.getBCOPY();
			row1[i][8] = bean.getBDATE();
			row1[i][9] = bean.getBCOUNT();
			row1[i][10] = bean.getBCOUNTP();
		}
		model7 = new DefaultTableModel(row1,col);   //�߰� ���� ������ ������ DefaultTableModel ����
		table7 = new JTable(model7);
		scr = new JScrollPane(table7);
		table7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    lmpanel.setPreferredSize(new Dimension(600,700));
	    table7.getColumnModel().getColumn(0).setPreferredWidth(40);  //JTable �� �÷� ���� ����
	    table7.getColumnModel().getColumn(1).setPreferredWidth(400);
	    table7.getColumnModel().getColumn(2).setPreferredWidth(180);
	    table7.getColumnModel().getColumn(3).setPreferredWidth(130);
	    table7.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(5).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(6).setPreferredWidth(70);
	    table7.getColumnModel().getColumn(7).setPreferredWidth(70);
	    table7.getColumnModel().getColumn(8).setPreferredWidth(130);
	    table7.getColumnModel().getColumn(9).setPreferredWidth(80);
	    table7.getColumnModel().getColumn(10).setPreferredWidth(80);
	    table7.setFont(new Font( "Times", Font.BOLD, 20) );
	    JTableHeader header = table7.getTableHeader();            //���̺� ��� ���� 
	    header.setBackground(bg);
	    table7.setSelectionBackground(bg);             //�� ���ý� ������
	    table7.setSelectionForeground(Color.white);  //���ý� �� �� ����
	    table7.setRowHeight(25);
		table7.addMouseListener(this);
		lpanel.add(scr);
}
	
	
public SwingProject_1() {
	viewList();
	
	lpanel.setLayout(new BorderLayout());
	lmpanel.setLayout(new BorderLayout());
	rpanel.setLayout(null);
	rmpanel.setLayout(null);
	rpanel2.setLayout(null);
	mpanel.setLayout(new BorderLayout());
	mpanel.setBackground(new  Color(170,220,255));
	lpanel2.setBackground(new Color(170,220,255));
	lpanel.setBackground(new  Color(170,220,255));
	rpanel2.setBackground(new  Color(170,220,255));
	rpanel.setBackground(new  Color(170,220,255));
	rmpanel.setBackground(new  Color(170,220,255));
	cpanel.setBackground(new  Color(170,220,255));
	
	
	
	
	TitledBorder jtx= 
    		new TitledBorder(new LineBorder(Color.white),"���� ���� ����");
	 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
	 
	 lpanel.add(scr);
	table7.addMouseListener(this);
	lpanel.setBorder(jtx);

	lmpanel.add(lpanel,BorderLayout.CENTER);
	lmpanel.add(lpanel2,BorderLayout.SOUTH);
	
	//Ÿ��Ʋ ���� ����
	TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white,5),"���� ��������");
	 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		
	 TitledBorder jtx2= 
	    		new TitledBorder(new LineBorder(Color.white,5),"���� �߰�    ");
		 jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 
		 TitledBorder jtx3= 
		    		new TitledBorder(new LineBorder(Color.white,5),"ȸ������ ä��");
			 jtx3.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		//Ÿ��Ʋ ���� �гο� ����
   rpanel.setBorder(jtx1);
   rpanel2.setBorder(jtx2);
   cpanel.setBorder(jtx3);
   
   //å �̹��� ����
   ImageIcon icon = new ImageIcon("C:\\\\Java\\\\eclipse-workspace\\\\image\\\\booktest.jpg");
	Image img = icon.getImage();    //icon �̹��� img�� �ֱ�
	Image change = img.getScaledInstance(230, 320, Image.SCALE_SMOOTH); //img�̹��� ũ������
	ImageIcon changeicon = new ImageIcon(change);//img �̹��� �ٽ� imageicon�� �ֱ�
	
   JLabel imlabel = new JLabel(changeicon); //�󺧿� ����
   rpanel.add(imlabel);
   imlabel.setBounds(280, 20, 230, 320);   //�󺧰� �̹��� ������ ���߱� 280,320
   
   Image btnimg = normalIcon2.getImage();        //��ư�� �̹��� ����
   Image change1 = btnimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
   ImageIcon changeicon1 = new ImageIcon(change1);
   JButton btn = new JButton(changeicon1);
   
   btn.setBounds(99, 0, 30, 30);
   
    btn3.setBounds(280, 350, 90, 25);
    btn3.addActionListener(ac3);
    btn4.addActionListener(ac2);
    btn4.setBounds(405, 350, 90, 25);
    
    lab2.setBounds(20, 25, 170, 30);
    lab3.setBounds(20, 75, 170, 30);
    lab4.setBounds(20, 125, 170, 30);
    lab5.setBounds(20, 175, 170, 30);
    lab6.setBounds(20, 225, 170, 30);
    lab8.setBounds(20, 275, 170, 30);
    lab9.setBounds(160, 275, 170, 30);
    lab10.setBounds(20, 325, 170, 30);
    lab7.setBounds(160, 25, 170, 30);
    //ta.setBounds(20, 400 , 490, 240);
    
    tf1.setBounds(20, 50, 100, 25);
    tf2.setBounds(20, 100, 250, 25);
    tf3.setBounds(20, 150, 250, 25);
    tf4.setBounds(20, 200, 250, 25);
    tf5.setBounds(20, 250, 250, 25);
    tf6.setBounds(160, 50, 100, 25);
    tf8.setBounds(20, 300, 100, 25);
    tf9.setBounds(160, 300, 100, 25);
    tf10.setBounds(20, 350, 250, 25);
   // tf10.setEnabled(false);
    
    
    lab2.setFont(fon);
    tf1.setEnabled(false);      //�ؽ�Ʈ �ʵ� ���� �Ұ�
    lab3.setFont(fon);
    lab4.setFont(fon);
    lab5.setFont(fon);
    lab6.setFont(fon);
    lab7.setFont(fon);
    lab8.setFont(fon);
    lab9.setFont(fon);
    lab10.setFont(fon);
    //tf6.setEnabled(false);

	
    
    rpanel2.add(btn);
  // rpanel.add(ta);
    rpanel.add(btn3);
	rpanel.add(btn4);
	rpanel.add(lab2);
	rpanel.add(lab3);
	rpanel.add(lab4);
	rpanel.add(lab5);
	rpanel.add(lab6);
	rpanel.add(lab7);
	rpanel.add(lab8);
	rpanel.add(lab9);
	rpanel.add(lab10);
	rpanel.add(tf1);
	rpanel.add(tf2);
	rpanel.add(tf3);
	rpanel.add(tf4);
	rpanel.add(tf5);
	rpanel.add(tf6);
	rpanel.add(tf8);
	rpanel.add(tf9);
	rpanel.add(tf10);
    btn.addActionListener(ac1);
	
	rpanel.setBounds(0, 40, 570, 390);
	rpanel2.setBounds(0, 0, 570, 40);
	cpanel.setBounds(0, 430, 570, 260);
	rmpanel.add(rpanel2);
	rmpanel.add(rpanel);	
	rmpanel.add(cpanel);
	mpanel.add(lmpanel,BorderLayout.WEST);
	mpanel.add(rmpanel);
    
   
	t_1.add("���� ����",mpanel);                               //��� ��Ҹ� t_1�� ����
	t_1.setFont( new Font( "Times", Font.BOLD, 18 ) );
	}


@Override
public void mouseClicked(MouseEvent e) {
	
	String str0 = (String) table7.getValueAt(table7.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
	String str1 = (String) table7.getValueAt(table7.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
	String str2 = (String) table7.getValueAt(table7.getSelectedRow(),2);
	String str3 = (String) table7.getValueAt(table7.getSelectedRow(),3);
	String str4 = (String) table7.getValueAt(table7.getSelectedRow(),4);
	String str5 = (String) table7.getValueAt(table7.getSelectedRow(),5);
	String str6 = (String) table7.getValueAt(table7.getSelectedRow(),6);
	String str8 = (String) table7.getValueAt(table7.getSelectedRow(),7);
	String str7 = (String) table7.getValueAt(table7.getSelectedRow(),8);
	tf1.setText(str0);
	tf2.setText(str1);
	tf3.setText(str2);
	tf4.setText(str3);
	tf5.setText(str4);
	tf6.setText(str5);
	tf8.setText(str8);
	tf9.setText(str6);
	tf10.setText(str7);
}
@Override
public void mousePressed(MouseEvent e) {}
@Override
public void mouseReleased(MouseEvent e) {}
@Override
public void mouseEntered(MouseEvent e) {}
@Override
public void mouseExited(MouseEvent e) {}

//�˻�â ��ư
ActionListener ac1 = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
			new SwingProject1_newf();
	}
};

//�������� ����
ActionListener ac2 =  new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(table7.getSelectedRow()==-1) {
		MDialog MD = new MDialog(SwingProject.frame, "����", true, "������ ������ �����ϼ���");
		MD.setVisible(true);
		}else {
		BooksBean bean = vlist.get(table7.getSelectedRow());
		if(mgr.deleteBooks(bean.getBID())) {
			
			lpanel.removeAll();
			lpanel.revalidate();
			
			vlist.removeAllElements();
			viewList();
			
			SwingProject.p1.removeAll();
			SwingProject.p1.revalidate();
			
			SwingProject.vlist1.removeAllElements();
			SwingProject.viewList();
			
			
	}}
}};

ActionListener ac3 = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(table7.getSelectedRow()==-1) {
			MDialog MD = new MDialog(SwingProject.frame, "����", true, "������ ������ �����ϼ���");
			MD.setVisible(true);
			}else {
				int to = Integer.parseInt(tf1.getText());
			String date = tf10.getText();       //��¥ ���������� �ú��� �� �ڸ���
	
			BooksBean bean = new BooksBean();
			
			bean.setBID(to);
			bean.setISBN(tf5.getText());
			bean.setTITLE(tf2.getText());
			bean.setAUTHOR(tf3.getText());
			bean.setPUBLISHER(tf4.getText());
			bean.setBDATE(date.substring(0,10));
			bean.setBCOPY(tf8.getText());
			bean.setBOOKSTATE("���Ⱑ��");
			bean.setLOCATION(tf9.getText());
			bean.setBCOUNT("0ȸ");
			bean.setBCOUNTP("0ȸ");
			
		
			if(mgr.updateBooks(bean)) {
			lpanel.removeAll();
			lpanel.revalidate();
			vlist.removeAllElements();
			viewList();
			
			}
}}};



//�������� â������ ����ϴ� �˻�â�� ���� ���ο� �������� ����Ŭ������ ����
public class SwingProject1_newf implements ActionListener,MouseListener{
	String col1[] = {"NO.","����","����","���ǻ�","ISBN"};
	String row1[][] ;
	int cnt =0;
	JTabbedPane t_1 = new JTabbedPane();
	JPanel lpanel2 = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel rpanel = new JPanel();
	JPanel rpanel2 = new JPanel();
	JPanel rmpanel = new JPanel();
	JPanel mpanel = new JPanel();
	JButton nbtn = new JButton("�˻�");
	JButton nbtn2 = new JButton("������� �߰�");
	JButton nbtn3 = new JButton("�̹��� �߰�");
	JLabel lab1 = new JLabel("����");
	JLabel lab15 = new JLabel("����");
	JLabel lab16 = new JLabel("ISBN");
	JLabel lab3 = new JLabel("����");
	JLabel lab4 = new JLabel("����");
	JLabel lab5 = new JLabel("���ǻ�");
	JLabel lab6 = new JLabel("ISBN");
	JLabel lab7 = new JLabel("��������");
	JLabel lab8 = new JLabel("����");
	JLabel lab9 = new JLabel("������ġ");
	JTextField tf22 = new JTextField(40);
	JTextField tf33 = new JTextField(40);
	JTextField tf44 = new JTextField(40);
	JTextField tf55 = new JTextField(40);
	JTextField tf66 = new JTextField(40);
	JTextField tf77 = new JTextField(40);
	JTextField tf11 = new JTextField(40);
	JTextField tf88 = new JTextField(40);
	JTable table;
	DefaultTableModel model;
	JScrollPane scr;
	DefaultTableModel m;
	
	public SwingProject1_newf() {
		JFrame newf = new JFrame();
		newf.setBackground(new  Color(170,220,255));
		newf.setVisible(true);
		newf.setSize(1110,725);
		newf.setLocationRelativeTo(null);
		
		lpanel2.setLayout(new BorderLayout());
		lmpanel.setLayout(new BorderLayout());
		rpanel.setLayout(null);
		rmpanel.setLayout(new BorderLayout());
		rpanel2.setLayout(null);
		mpanel.setLayout(new BorderLayout());
		mpanel.setBackground(new  Color(170,220,255));
		lpanel2.setBackground(new  Color(170,220,255));
		rpanel2.setBackground(new  Color(170,220,255));
		rpanel.setBackground(new  Color(170,220,255));
		rmpanel.setBackground(new  Color(170,220,255));
		
		mpanel.add(lmpanel,BorderLayout.WEST);
		mpanel.add(rmpanel,BorderLayout.CENTER);
		
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"�˻� ����");
		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 lpanel2.setBorder(jtx);
		 
		 
		 
		model = new DefaultTableModel(row1,col1);
		table = new JTable(model);
		scr = new JScrollPane(table);
		
		lpanel2.add(scr);
	
		m =(DefaultTableModel)table.getModel()	;
		
		
		lmpanel.add(lpanel2,BorderLayout.CENTER);
		
		TitledBorder jtx1= 
	    		new TitledBorder(new LineBorder(Color.white),"���� ����");
		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 
		 TitledBorder jtx2= 
		    		new TitledBorder(new LineBorder(Color.white),"���� �˻�");
			 jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
			 
	   rpanel.setBorder(jtx1);
	   rpanel2.setBorder(jtx2);
	   rpanel.setPreferredSize(new Dimension(540,490));   //1110,725
	   
	   ImageIcon inicon = new ImageIcon("C:\\\\Java\\\\eclipse-workspace\\\\image\\\\booktest1.jpg");
		Image inimg = inicon.getImage();    //icon �̹��� img�� �ֱ�
		Image change = inimg.getScaledInstance(230, 320, Image.SCALE_SMOOTH); //img�̹��� ũ������
		ImageIcon changeicon = new ImageIcon(change);//img �̹��� �ٽ� imageicon�� �ֱ�
		
	   JLabel imlabel = new JLabel(changeicon); //�󺧿� ����
	   rpanel.add(imlabel);
	   imlabel.setBounds(270, 30, 230, 320);   //�󺧰� �̹��� ������ ���߱� 280,320
		
		lab1.setBounds(30, 30, 80, 30);
		lab15.setBounds(30, 70, 80, 30);
		lab16.setBounds(30, 110, 80, 30);
	    tf11.setBounds(110, 30, 350, 25);
	    tf15.setBounds(110, 70, 350, 25);
	    tf16.setBounds(110, 110, 350, 25);
	    nbtn.setBounds(400, 150, 100, 30);
	    
	    
	    lmpanel.setPreferredSize(new Dimension(570,500));  //1110,725
	    table.getColumnModel().getColumn(0).setPreferredWidth(30);  //JTable �� �÷� ���� ����
	    table.getColumnModel().getColumn(1).setPreferredWidth(200);
	    table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(50);
	    table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table.setFont(new Font( "Times", Font.BOLD, 20) );	
	    table.setRowHeight(25);
	    table.addMouseListener(this);
	    
	    nbtn2.setBounds(130, 400, 250, 50);
	    lab3.setBounds(20, 30, 170, 30);
	    lab4.setBounds(20, 90, 170, 30);
	    lab5.setBounds(20, 150, 170, 30);
	    lab6.setBounds(20, 210, 170, 30);
	    lab7.setBounds(20, 270, 170, 30);
	    lab8.setBounds(20, 330, 170, 30);
	    lab9.setBounds(140, 330, 170, 30);
	    
	    tf22.setBounds(20, 60, 220, 25);
	    tf33.setBounds(20, 120, 220, 25);
	    tf44.setBounds(20, 180, 220, 25);
	    tf55.setBounds(20, 240, 220, 25);
	    tf66.setBounds(20, 300, 220, 25);
	    tf77.setBounds(20,360, 100, 25);
	    tf88.setBounds(140,360, 100, 25);
	    nbtn3.setBounds(400, 350, 100, 30);
	    //2����/3����/4����/5isbn/6��������/7����/8������ġ
	    lab3.setFont(fon);
	    lab1.setFont(fon);
	    lab15.setFont(fon);
	    lab16.setFont(fon);
	    lab4.setFont(fon);
	    lab5.setFont(fon);
	    lab6.setFont(fon);
	    lab7.setFont(fon);
	    lab8.setFont(fon);
	    lab9.setFont(fon);
	    
		rpanel.add(lab3);
		rpanel.add(lab4);
		rpanel.add(lab5);
		rpanel.add(lab6);
		rpanel.add(lab7);
		rpanel.add(lab8);
		rpanel.add(lab9);
		rpanel.add(tf22);
		rpanel.add(tf33);
		rpanel.add(tf44);
		rpanel.add(tf55);
		rpanel.add(tf66);
		rpanel.add(tf77);
		rpanel.add(tf88);
		rpanel.add(nbtn3);
	    
	    rpanel2.add(lab1);
	    rpanel2.add(lab15);
	    rpanel2.add(lab16);
	    rpanel2.add(nbtn);
	    nbtn.addActionListener(this);
		rpanel2.add(tf11);
		rpanel2.add(tf15);
		rpanel2.add(tf16);
		tf11.addActionListener(this);
		rpanel.add(nbtn2);
		nbtn2.setPreferredSize(new Dimension(100,40));
		nbtn2.addActionListener(this);
		rmpanel.add(rpanel2,BorderLayout.CENTER);
		rmpanel.add(rpanel,BorderLayout.SOUTH);	
	    
		newf.add(mpanel); 
		t_1.setFont( new Font( "Times", Font.BOLD, 18 ) );
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand()	;
		 if(cmd.equals(nbtn.getText())){            //�˻�
			 m.setNumRows(0);
			 String title = tf11.getText();                //ISBN���� ParseEx3�� �ְ� �� ��������
			 String author = tf15.getText();                //ISBN���� ParseEx3�� �ְ� �� ��������
			 String isbn = tf16.getText();                //ISBN���� ParseEx3�� �ְ� �� ��������
			 ParseEx3 ex3 = new ParseEx3(title,author,isbn);
			 
		for (int i = 0; i < ex3.title1.size(); i++) {
			 m.insertRow(i, new Object[] {i+1,ex3.title1.get(i),             
					 ex3.author1.get(i),ex3.pub1.get(i),ex3.isbn1.get(i)});
				}
		}else if(cmd.equals(nbtn2.getText())) {                   //������Ͽ� �߰��ϱ�
			
			BooksBean bean = new BooksBean();
			//bean.setBID();
			bean.setISBN(tf55.getText());
			bean.setTITLE(tf22.getText());
			bean.setAUTHOR(tf33.getText());
			bean.setPUBLISHER(tf44.getText());
			bean.setBDATE(tf66.getText());
			System.out.println(bean.getBDATE());
			bean.setBCOPY(tf77.getText());
			bean.setBOOKSTATE("���Ⱑ��");
			bean.setLOCATION(tf88.getText());
			bean.setBCOUNT("0ȸ");
			bean.setBCOUNTP("0ȸ");
			if(mgr.insertBooks(bean) ) {
				//������ ���� 
				lpanel.removeAll();
				vlist.removeAllElements();
				lpanel.revalidate();
				viewList();
				table7.addRowSelectionInterval(0, 0);
			}
	}}
	//2����/3����/4����/5isbn/6��������/7����/8������ġ
	@Override
	public void mouseClicked(MouseEvent e) {
		String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
		String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
		String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
		String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
		
		tf22.setText(str1);
		tf33.setText(str2);
		tf44.setText(str3);
		tf55.setText(str4);
		tf66.setText("2020-11-16");
		tf66.setEnabled(false);
	} 
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	}


}