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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

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
import javax.swing.table.JTableHeader;


public class SwingProject_1{
	static String col[] = {"NO.","서명","저자","출판사","ISBN","도서상태","도서위치","복본","반입일자","대출횟수","IMAGE","카테고리"};
	static JTextField ctf = new JTextField("",50);
	static JTextArea cta = new JTextArea();
	static JButton cbtn = new JButton("보내기");
	JScrollPane chatScroll ;
	
	static ImageIcon img;
	static ImageIcon icon;
	static Image bimg;
	static Image change;
	static ImageIcon changeicon;
	static JLabel  imlabel = new JLabel(); 
	int cnt =0;
	static ImageIcon normalIcon2 = new ImageIcon("C:\\\\image\\test2.jpg");
	static  Image btnimg = normalIcon2.getImage();        //버튼에 이미지 부착
	  static  Image change1 = btnimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	   static  ImageIcon changeicon1 = new ImageIcon(change1);
	String imastr[];
	JTabbedPane t_1 = new JTabbedPane();
	static JPanel lpanel = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel lpanel2 = new JPanel();
	static JPanel rpanel = new JPanel();
	JPanel rpanel2 = new JPanel();
	JPanel cpanel; 
	JPanel rmpanel = new JPanel();
	JPanel mpanel = new JPanel();
	JButton btn;
	JButton btn3 = new JButton("수정");
	JButton btn4 = new JButton("삭제");
	static JTextField imaget = new JTextField(40);
	JLabel lab2 = new JLabel("등록 번호");
	JLabel lab3 = new JLabel("제목");
	JLabel lab4 = new JLabel("저자");
	JLabel lab5 = new JLabel("출판사");
	JLabel lab6 = new JLabel("ISBN");
	JLabel lab7 = new JLabel("도서상태");
	JLabel lab8 = new JLabel("복본");
	JLabel lab9 = new JLabel("소장위치");
	JLabel lab10 = new JLabel("반입일자");
	String image3;
	
	static  JTextField tf1 = new JTextField(10);
	static JTextField tf2 = new JTextField(10);
	static JTextField tf3 = new JTextField(10);
	static JTextField tf4 = new JTextField(10);
	static JTextField tf5 = new JTextField(10);
	static JTextField tf6 = new JTextField(10); 
	static JTextField tf8 = new JTextField(10); 
	static JTextField tf9 = new JTextField(10); 
	static JTextField tf10 = new JTextField(10); 
	static JTextField tf15 = new JTextField(10); 
	static JTextField tf16 = new JTextField(10); 
	
	static JTable table7;
	static DefaultTableModel model7;
	static JScrollPane scr;
	
	static Font fon = new Font( "Times", Font.BOLD, 18 );
	static Color bg = new Color(54,201,255);
	
	static JButton btns;
	static String row1[][];
	static BooksMgr  mgr= new BooksMgr();
	static Vector <BooksBean>  vlist ;
	
	public static void viewList() {
		vlist = mgr.getListMember();
		row1 = new String[vlist.size()][13];
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
			row1[i][9] = bean.getBCOUNT()+"";
			row1[i][10] = bean.getBIMAGE();
			row1[i][11] = bean.getCATE();
		}
		model7 = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
		table7 = new JTable(model7);
		scr = new JScrollPane(table7);
		table7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    lpanel.setPreferredSize(new Dimension(600,700));
	    table7.getColumnModel().getColumn(0).setPreferredWidth(40);  //JTable 의 컬럼 길이 조절
	    table7.getColumnModel().getColumn(1).setPreferredWidth(400);
	    table7.getColumnModel().getColumn(2).setPreferredWidth(180);
	    table7.getColumnModel().getColumn(3).setPreferredWidth(130);
	    table7.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(5).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(6).setPreferredWidth(70);
	    table7.getColumnModel().getColumn(7).setPreferredWidth(70);
	    table7.getColumnModel().getColumn(8).setPreferredWidth(130);
	    table7.getColumnModel().getColumn(9).setPreferredWidth(80);
	    table7.getColumnModel().getColumn(10).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(11).setPreferredWidth(100);
	   table7.setFont(new Font( "Times", Font.BOLD, 20) );
	    JTableHeader header = table7.getTableHeader();            //테이블 헤더 색상 
	    header.setBackground(bg);
	    table7.setSelectionBackground(bg);             //셀 선택시 색변경
	    table7.setSelectionForeground(Color.white);  //선택시 글 색 변경
	    table7.setRowHeight(25);
		table7.addMouseListener(the);
		scr.setBounds(8, 30, 585, 670);
		lpanel.add(scr);
		 btns  = new JButton(changeicon1);
		 btns.setBounds(140, 0, 30, 30);
		   btns.addActionListener(scn);
		   lpanel.add(btns);
}
	
	
public SwingProject_1() {
	viewList();
	setbookimg("non.jpg");
	lpanel.setLayout(null);
	lmpanel.setLayout(new BorderLayout());
	rpanel.setLayout(null);
	//cpanel.setLayout(null);
	rmpanel.setLayout(null);
	rpanel2.setLayout(null);
	mpanel.setLayout(new BorderLayout());
	mpanel.setBackground(new  Color(170,220,255));
	lpanel2.setBackground(new Color(170,220,255));
	lpanel.setBackground(new  Color(170,220,255));
	rpanel2.setBackground(new  Color(170,220,255));
	rpanel.setBackground(new  Color(170,220,255));
	rmpanel.setBackground(new  Color(170,220,255));
	//cpanel.setBackground(new  Color(170,220,255));
	
	
	
	
	TitledBorder jtx= 
    		new TitledBorder(new LineBorder(Color.white),"매장 보유 도서    ");
	 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
	 
	 lpanel.add(scr);
	table7.addMouseListener(the);
	lpanel.setBorder(jtx);
	
	lmpanel.add(lpanel,BorderLayout.CENTER);
	lmpanel.add(lpanel2,BorderLayout.SOUTH);
	
	//타이틀 보더 셋팅
	TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white,5),"도서 세부정보");
	 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		
	 TitledBorder jtx2= 
	    		new TitledBorder(new LineBorder(Color.white,5),"도서 추가    ");
		 jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 
		 TitledBorder jtx3= 
		    		new TitledBorder(new LineBorder(Color.white,5),"회원과의 채팅");
			 jtx3.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		//타이틀 보더 패널에 부착
   rpanel.setBorder(jtx1);
   rpanel2.setBorder(jtx2);
   //cpanel.setBorder(jtx3);
   
   
   Image btnimg = normalIcon2.getImage();        //버튼에 이미지 부착
   Image change1 = btnimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
   ImageIcon changeicon1 = new ImageIcon(change1);
   JButton btn = new JButton(changeicon1);
   JButton btns  = new JButton(changeicon1);
   btn.setBounds(99, 0, 30, 30);
   lpanel.add(btns);
	 btns.setBounds(140, 0, 30, 30);
   btns.addActionListener(scn);
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
    tf1.setEnabled(false);      //텍스트 필드 선택 불가
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
	
	  cbtn.setBounds(470	, 220, 80,30);
	  ctf.setBounds(20, 220, 450, 30);
	// cpanel.validate();//갱신
	// chatScroll.setBounds(20, 30, 500, 200);
	 ctf.setBounds(20, 200, 450, 30);
	 cbtn.setBounds(450, 200, 50, 30);
	rmpanel.add(rpanel2);
	rmpanel.add(rpanel);	
	
		cpanel = new ChatClient();
		cpanel.setBounds(0, 450, 570, 260);
		rmpanel.add(cpanel);
		
	mpanel.add(lmpanel,BorderLayout.WEST);
	mpanel.add(rmpanel);
    
   
	t_1.add("도서 정보",mpanel);                               //모든 요소를 t_1에 부착
	t_1.setFont( new Font( "Times", Font.BOLD, 18 ) );
	}


public static void setbookimg(String imastr) {         //이미지를 변경하는 메소드
//책 이미지 삽입
	
    icon = new ImageIcon("C:\\image\\"+imastr);
	bimg = icon.getImage();    //icon 이미지 img에 넣기
	change = bimg.getScaledInstance(270, 320, Image.SCALE_SMOOTH); //img이미지 크기조절
	changeicon = new ImageIcon(change);//img 이미지 다시 imageicon에 넣기
	imlabel.removeAll();
	imlabel.setIcon(changeicon);
	rpanel.add(imlabel);
	
	imlabel.setBounds(280, 20, 270, 320);   //라벨과 이미지 사이즈 맞추기 280,320
	
	
	
	}
static MouseListener the = new MouseListener() {
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String str0 = (String) table7.getValueAt(table7.getSelectedRow(),0);            //Object 타입을 모두 문자형으로 변환
		String str1 = (String) table7.getValueAt(table7.getSelectedRow(),1);            //Object 타입을 모두 문자형으로 변환
		String str2 = (String) table7.getValueAt(table7.getSelectedRow(),2);
		String str3 = (String) table7.getValueAt(table7.getSelectedRow(),3);
		String str4 = (String) table7.getValueAt(table7.getSelectedRow(),4);
		String str5 = (String) table7.getValueAt(table7.getSelectedRow(),5);
		String str6 = (String) table7.getValueAt(table7.getSelectedRow(),6);
		String str8 = (String) table7.getValueAt(table7.getSelectedRow(),7);
		String str7 = (String) table7.getValueAt(table7.getSelectedRow(),8);
		String str9 = (String) table7.getValueAt(table7.getSelectedRow(),10);
		tf1.setText(str0);
		tf2.setText(str1);
		tf2.select(0, 0);
		tf3.setText(str2);
		tf3.select(0, 0);
		tf4.setText(str3);
		tf4.select(0, 0);
		tf5.setText(str4);
		tf6.setText(str5);
		tf8.setText(str8);
		tf9.setText(str6);
		tf10.setText(str7);
		if(str9 == null) {   //이미지값 없으면 나오는 사진
			setbookimg("non.jpg");
		}else {//이미지값 있으면 출력
		setbookimg((String)table7.getValueAt(table7.getSelectedRow(), 10)); //저장된 이미지명 메소드에 넣기
	}
		
	}
};


//검색창 버튼
ActionListener ac1 = new ActionListener() { 
	@Override
	public void actionPerformed(ActionEvent e) {
			new SwingProject1_newf();
	}
};

//보유도서 삭제
ActionListener ac2 =  new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(table7.getSelectedRow()==-1) {
		MDialog MD = new MDialog(SwingProject.frame, "오류", true, "삭제할 도서를 선택하세요");
		MD.setVisible(true);
		}else {
			System.out.println(table7.getSelectedRow());
		BooksBean bean = vlist.get(table7.getSelectedRow());
		System.out.println(bean.getBID());
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
			MDialog MD = new MDialog(SwingProject.frame, "오류", true, "수정할 도서를 선택하세요");
			MD.setVisible(true);
			}else {
				int to = Integer.parseInt(tf1.getText());     //문자형을 정수로 변환
			String date = tf10.getText();       //날짜 수정을위해 시분초 를 자른다
	
			BooksBean bean = new BooksBean();
			
			bean.setBID(to);
			bean.setISBN(tf5.getText());
			bean.setTITLE(tf2.getText());
			bean.setAUTHOR(tf3.getText());
			bean.setPUBLISHER(tf4.getText());
			bean.setBDATE(date.substring(0,10));  //날짜 자르기 
			bean.setBCOPY(tf8.getText());
			bean.setBOOKSTATE("대출가능");
			bean.setLOCATION(tf9.getText());
			
			MDialog md2 = new MDialog(SwingProject.frame, "오류", true, "수정이 완료되었습니다.");
			md2.setVisible(true);
		
			if(mgr.updateBooks(bean)) {
			lpanel.removeAll();
			lpanel.revalidate();
			vlist.removeAllElements();
			viewList();
			
			}
}}};



//도서관리 창에서만 사용하는 검색창을 위해 새로운 프레임을 내부클래스로 선언
public static  class SwingProject1_newf implements ActionListener,MouseListener{
	String col1[] = {"NO.","제목","저자","출판사","ISBN"};
	String row1[][] ;
	int cnt =0;
	JTabbedPane t_1 = new JTabbedPane();
	JPanel lpanel2 = new JPanel();
	JPanel lmpanel = new JPanel();
	static JPanel rpanel5 = new JPanel();
	JPanel rpanel2 = new JPanel();
	JPanel rmpanel = new JPanel();
	JPanel mpanel = new JPanel();
	JButton nbtn = new JButton("검색");
	JButton nbtn2 = new JButton("보유목록 추가");
	JButton nbtn3 = new JButton("이미지 추가");
	JLabel lab1 = new JLabel("서명");
	JLabel lab15 = new JLabel("저자");
	JLabel lab16 = new JLabel("ISBN");
	JLabel lab3 = new JLabel("서명");
	JLabel lab4 = new JLabel("저자");
	JLabel lab5 = new JLabel("출판사");
	JLabel lab6 = new JLabel("ISBN");
	JLabel lab7 = new JLabel("반입일자");
	JLabel lab8 = new JLabel("복본");
	JLabel lab9 = new JLabel("도서위치");
	JLabel lab10 = new JLabel("파일명");
	JLabel lab11 = new JLabel("카테고리");
	JTextField tf22 = new JTextField(40);
	JTextField tf33 = new JTextField(40);
	JTextField tf44 = new JTextField(40);
	JTextField tf55 = new JTextField(40);
	JTextField tf66 = new JTextField(40);
	JTextField tf77 = new JTextField(40);
	JTextField tf11 = new JTextField(40);
	JTextField tf88 = new JTextField(40);
	JTextField tf999 = new JTextField(40);
	static ImageIcon img2;
	static ImageIcon icon2;
	static Image bimg2;
	static Image change2;
	static ImageIcon changeicon2;
	static JLabel imlabel2 = new JLabel();
	
	JTable table;
	DefaultTableModel model;
	JScrollPane scr;
	DefaultTableModel m;
	static JFrame newf;
	public SwingProject1_newf() {
		newf = new JFrame();
		newf.setBackground(new  Color(170,220,255));
		newf.setVisible(true);
		newf.setSize(1110,725);
		newf.setLocationRelativeTo(null);
		
		lpanel2.setLayout(new BorderLayout());
		lmpanel.setLayout(new BorderLayout());
		rpanel5.setLayout(null);
		rmpanel.setLayout(new BorderLayout());
		rpanel2.setLayout(null);
		mpanel.setLayout(new BorderLayout());
		mpanel.setBackground(new  Color(170,220,255));
		lpanel2.setBackground(new  Color(170,220,255));
		rpanel2.setBackground(new  Color(170,220,255));
		rpanel5.setBackground(new  Color(170,220,255));
		rmpanel.setBackground(new  Color(170,220,255));
		
		mpanel.add(lmpanel,BorderLayout.WEST);
		mpanel.add(rmpanel,BorderLayout.CENTER);
		
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"검색 내용");
		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 lpanel2.setBorder(jtx);
		 
		 
		 
		model = new DefaultTableModel(row1,col1);
		table = new JTable(model);
		scr = new JScrollPane(table);
		
		lpanel2.add(scr);
	
		m =(DefaultTableModel)table.getModel()	;
		
		
		lmpanel.add(lpanel2,BorderLayout.CENTER);
		
		TitledBorder jtx1= 
	    		new TitledBorder(new LineBorder(Color.white),"세부 정보");
		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 
		 TitledBorder jtx2= 
		    		new TitledBorder(new LineBorder(Color.white),"도서 검색");
			 jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
			 
	   rpanel5.setBorder(jtx1);
	   rpanel2.setBorder(jtx2);
	   rpanel5.setPreferredSize(new Dimension(540,490));   //1110,725
	   
	   
		lab1.setBounds(30, 30, 80, 30);
		lab15.setBounds(30, 70, 80, 30);
		lab16.setBounds(30, 110, 80, 30);
	    tf11.setBounds(110, 30, 350, 25);
	    tf15.setBounds(110, 70, 350, 25);
	    tf16.setBounds(110, 110, 350, 25);
	    nbtn.setBounds(400, 150, 100, 30);
	    
	    
	    lmpanel.setPreferredSize(new Dimension(570,500));  //1110,725
	    table.getColumnModel().getColumn(0).setPreferredWidth(30);  //JTable 의 컬럼 길이 조절
	    table.getColumnModel().getColumn(1).setPreferredWidth(200);
	    table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(50);
	    table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table.setFont(new Font( "Times", Font.BOLD, 20) );	
	    table.setRowHeight(25);
	    table.addMouseListener(this);
	    
	    nbtn2.setBounds(360, 430, 150, 40);
	    lab3.setBounds(20, 30, 170, 30);
	    lab4.setBounds(20, 90, 170, 30);
	    lab5.setBounds(20, 150, 170, 30);
	    lab6.setBounds(20, 210, 170, 30);
	    lab7.setBounds(20, 270, 170, 30);
	    lab8.setBounds(20, 330, 170, 30);
	    lab9.setBounds(140, 330, 170, 30);
	    lab10.setBounds(20, 390, 170, 30);
	    lab11.setBounds(140, 390, 170, 30);
	    
	    tf22.setBounds(20, 60, 220, 25);
	    tf22.setEditable(false);
	    tf33.setEditable(false);
	    tf44.setEditable(false);
	    tf55.setEditable(false);
	    tf66.setEnabled(false);
	    tf33.setBounds(20, 120, 220, 25);
	    
	    tf44.setBounds(20, 180, 220, 25);
	    tf55.setBounds(20, 240, 220, 25);
	    tf66.setBounds(20, 300, 220, 25);
	    tf77.setBounds(20,360, 100, 25);
	    tf88.setBounds(140,360, 100, 25);
	    tf999.setBounds(140,420, 100, 25);
	    nbtn3.setBounds(410, 20, 100, 30);
	    
	    imaget.setBounds(20, 420, 100, 25);
	    //2제목/3저자/4출판/5isbn/6반입일자/7복본/8도서위치
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
	    lab10.setFont(fon);
	    lab11.setFont(fon);
	    
		rpanel5.add(lab3);
		rpanel5.add(lab4);
		rpanel5.add(lab5);
		rpanel5.add(lab6);
		rpanel5.add(lab7);
		rpanel5.add(lab8);
		rpanel5.add(lab9);
		rpanel5.add(lab10);
		rpanel5.add(lab11);
		rpanel5.add(tf22);
		rpanel5.add(tf33);
		rpanel5.add(tf44);
		rpanel5.add(tf55);
		rpanel5.add(tf66);
		rpanel5.add(tf77);
		rpanel5.add(tf88);
		rpanel5.add(tf999);
		rpanel5.add(imaget);
		imaget.setEnabled(false);
		rpanel5.add(nbtn3);
	    nbtn3.addActionListener(image);
	    rpanel2.add(lab1);
	    rpanel2.add(lab15);
	    rpanel2.add(lab16);
	    rpanel2.add(nbtn);
	    nbtn.addActionListener(this);
		rpanel2.add(tf11);
		rpanel2.add(tf15);
		rpanel2.add(tf16);
		tf11.addActionListener(this);
		rpanel5.add(nbtn2);
		nbtn2.setPreferredSize(new Dimension(100,40));
		nbtn2.addActionListener(this);
		rmpanel.add(rpanel2,BorderLayout.CENTER);
		rmpanel.add(rpanel5,BorderLayout.SOUTH);	
	    setbookimg1("non.jpg");  //기본이미지 설정
		newf.add(mpanel); 
		t_1.setFont( new Font( "Times", Font.BOLD, 18 ) );
		
	}
	public static void setbookimg1(String imastr) {         //이미지를 변경하는 메소드
		//책 이미지 삽입
			
		    icon2 = new ImageIcon("C:\\image\\"+imastr);
			bimg2 = icon2.getImage();    //icon 이미지 img에 넣기
			change2 = bimg2.getScaledInstance(260, 330, Image.SCALE_SMOOTH); //img이미지 크기조절
			changeicon2 = new ImageIcon(change2);//img 이미지 다시 imageicon에 넣기
			imlabel2.removeAll();
			imlabel2.setIcon(changeicon2);
			rpanel5.add(imlabel2);
			
			imlabel2.setBounds(250, 60, 260, 330);   //라벨과 이미지 사이즈 맞추기 280,320
			
			}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand()	;
		 if(cmd.equals(nbtn.getText())){            //검색
			 m.setNumRows(0);
			 String title = tf11.getText();                //ISBN값을 ParseEx3에 넣고 값 가져오기
			 String author = tf15.getText();                //ISBN값을 ParseEx3에 넣고 값 가져오기
			 String isbn = tf16.getText();                //ISBN값을 ParseEx3에 넣고 값 가져오기
			 ParseEx3 ex3 = new ParseEx3(title,author,isbn);
			 
		for (int i = 0; i < ex3.title1.size(); i++) {
			 m.insertRow(i, new Object[] {i+1,ex3.title1.get(i),             
					 ex3.author1.get(i),ex3.pub1.get(i),ex3.isbn1.get(i)});
				}
		}else if(cmd.equals(nbtn2.getText())) {                   //도서목록에 추가하기
			
			BooksBean bean = new BooksBean();
			
			bean.setISBN(tf55.getText());
			bean.setTITLE(tf22.getText());
			bean.setAUTHOR(tf33.getText());
			bean.setPUBLISHER(tf44.getText());
			bean.setBDATE(tf66.getText());
			bean.setBCOPY(tf77.getText());
			bean.setBOOKSTATE("대출가능");
			bean.setLOCATION(tf88.getText());
			bean.setBCOUNT(0);
			bean.setBIMAGE(imaget.getText());
			bean.setCATE(tf999.getText());
			if(mgr.insertBooks(bean) ) {
				//저장을 성공 
				lpanel.removeAll();
				vlist.removeAllElements();
				lpanel.revalidate();
				viewList();
				
				SwingProject.p1.removeAll();   //대여창 새로고침 시키기
				SwingProject.p1.revalidate();
				SwingProject.vlist1.removeAllElements();
				SwingProject.viewList();
				
	             }
			table7.changeSelection(table7.getRowCount(),0, false, false); 
		}}
	@Override
	public void mouseClicked(MouseEvent e) {
		String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object 타입을 모두 정수형으로 변환
		String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
		String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
		String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
		
		tf22.setText(str1);
		tf22.select(0, 0);   //text 를 맨앞부터 보이게하기
		tf33.setText(str2);
		tf33.select(0, 0);
		tf44.setText(str3);
		tf44.select(0, 0);
		tf55.setText(str4);
		//오늘의 날짜를 반환하는 함수 적용하여 추가도서 클릭시 자동으로 오늘날짜 반환 
		SimpleDateFormat sysdate = new SimpleDateFormat();
		Calendar date = Calendar.getInstance();
		String date2 = sysdate.format(date.getTime());
		tf66.setText(date2.substring(0,10));   //시분초 자르기 
		
	} 
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	ActionListener image = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new TTTTFileUpload();
			
		}
	};

	
	}

static ActionListener chat = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
};



static ActionListener  scn = new ActionListener() {

	
	@Override
	public void actionPerformed(ActionEvent e) {
		new SwingProject_bookscanner2();
		
	}
};


}