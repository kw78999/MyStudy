package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.table.TableCellRenderer;

public class SwingProject_1  implements MouseListener{
	String col[] = {"NO.","제목","저자","출판사","ISBN","도서상태"};
	String row[][] ;
	ImageIcon img;
	int cnt =0;
	ImageIcon normalIcon = new ImageIcon("C:\\\\Users\\\\deers\\\\Desktop\\\\새 폴더\\\\gitTest1\\\\gitTest1\\\\test3.jpg");
	JTabbedPane t_1 = new JTabbedPane();
	JPanel lpanel = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel lpanel2 = new JPanel();
	JPanel rpanel = new JPanel();
	JPanel rpanel2 = new JPanel();
	JPanel rmpanel = new JPanel();
	JPanel mpanel = new JPanel();
	JButton btn;
	JButton btn3 = new JButton("수정");
	JButton btn4 = new JButton("삭제");
	JLabel lab2 = new JLabel("등록 번호");
	JLabel lab3 = new JLabel("제목");
	JLabel lab4 = new JLabel("저자");
	JLabel lab5 = new JLabel("출판사");
	JLabel lab6 = new JLabel("ISBN");
	JLabel lab7 = new JLabel("도서상태");
	
	JTextArea ta = new JTextArea();
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JTextField tf3 = new JTextField(10);
	JTextField tf4 = new JTextField(10);
	JTextField tf5 = new JTextField(10);
	JTextField tf6 = new JTextField(10);
	
	JTable table7;
	DefaultTableModel model;
	JScrollPane scr;
	DefaultTableModel m3;
	
	Font fon = new Font( "Times", Font.BOLD, 18 );
	Color bg = new Color(54,201,255);
	
public SwingProject_1() {
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
	
	
	
	TitledBorder jtx= 
    		new TitledBorder(new LineBorder(Color.white),"매장 보유 도서");
	 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
	 
	model = new DefaultTableModel(row,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
	table7 = new JTable(model);
	scr = new JScrollPane(table7);
	table7.addMouseListener(this);
	
	lpanel.setBorder(jtx);
	lpanel.add(scr);


	
	//btn3.addActionListener();
	//btn4.addActionListener();
	lmpanel.add(lpanel,BorderLayout.CENTER);
	lmpanel.add(lpanel2,BorderLayout.SOUTH);
	m3 =(DefaultTableModel)table7.getModel()	;
	
	//타이틀 보더 셋팅
	TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white),"도서 세부정보");
	 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		
	 TitledBorder jtx2= 
	    		new TitledBorder(new LineBorder(Color.white),"ISBN 검색    ");
		 jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		//타이틀 보더 패널에 부착
   rpanel.setBorder(jtx1);
   rpanel2.setBorder(jtx2);
   
   //책 이미지 삽입
   ImageIcon icon = new ImageIcon("C:\\\\Java\\\\eclipse-workspace\\\\image\\\\booktest.jpg");
	Image img = icon.getImage();    //icon 이미지 img에 넣기
	Image change = img.getScaledInstance(230, 320, Image.SCALE_SMOOTH); //img이미지 크기조절
	ImageIcon changeicon = new ImageIcon(change);//img 이미지 다시 imageicon에 넣기
	
   JLabel imlabel = new JLabel(changeicon); //라벨에 부착
   rpanel.add(imlabel);
   imlabel.setBounds(280, 20, 230, 320);   //라벨과 이미지 사이즈 맞추기 280,320
   
   Image btnimg = normalIcon.getImage();        //버튼에 이미지 부착
   Image change1 = btnimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
   ImageIcon changeicon1 = new ImageIcon(change1);
   JButton btn = new JButton(changeicon1);
   
   btn.setBackground(Color.white);
   btn.setBounds(99, 0, 30, 30);
   
    btn3.setBounds(80, 540, 170, 50);
    btn4.setBounds(280, 540, 170, 50);
    
    lab2.setBounds(20, 20, 170, 30);
    lab3.setBounds(20, 70, 170, 30);
    lab4.setBounds(20, 120, 170, 30);
    lab5.setBounds(20, 200, 170, 30);
    lab6.setBounds(20, 2600, 170, 30);
    lab7.setBounds(160, 20, 170, 30);
    ta.setBounds(20, 390, 450, 120);
    
    tf1.setBounds(20, 50, 100, 25);
    tf2.setBounds(20, 100, 250, 25);
    tf3.setBounds(20, 150, 250, 25);
    tf4.setBounds(20, 190, 250, 25);
    tf5.setBounds(20, 230, 250, 25);
    tf6.setBounds(160, 50, 100, 25);
    
    
    lab2.setFont(fon);
    tf1.setEnabled(false);      //텍스트 필드 선택 불가
    lab3.setFont(fon);
    lab4.setFont(fon);
    lab5.setFont(fon);
    lab6.setFont(fon);
    lab7.setFont(fon);
    tf6.setEnabled(false);

	table7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    lmpanel.setPreferredSize(new Dimension(650,700));
    table7.getColumnModel().getColumn(0).setPreferredWidth(40);  //JTable 의 컬럼 길이 조절
    table7.getColumnModel().getColumn(1).setPreferredWidth(400);
    table7.getColumnModel().getColumn(2).setPreferredWidth(180);
    table7.getColumnModel().getColumn(3).setPreferredWidth(130);
    table7.getColumnModel().getColumn(4).setPreferredWidth(100);
    table7.getColumnModel().getColumn(5).setPreferredWidth(100);
    table7.setFont(new Font( "Times", Font.BOLD, 20) );
    
table7.setSelectionBackground(bg);             //셀 선택시 색변경
//table7.setSelectionForeground(Color.white);
	
    table7.setRowHeight(25);
    
    rpanel2.add(btn);
    rpanel.add(ta);
    rpanel.add(btn3);
	rpanel.add(btn4);
	rpanel.add(lab2);
	rpanel.add(lab3);
	rpanel.add(lab4);
	rpanel.add(lab5);
	rpanel.add(lab6);
	rpanel.add(lab7);
	rpanel.add(tf1);
	rpanel.add(tf2);
	rpanel.add(tf3);
	rpanel.add(tf4);
	rpanel.add(tf5);
	rpanel.add(tf6);
    btn.addActionListener(ac);
	
	rpanel.setBounds(0, 40, 530, 600);
	rpanel2.setBounds(0, 0, 550, 40);
	rmpanel.add(rpanel2);
	rmpanel.add(rpanel);	
	mpanel.add(lmpanel,BorderLayout.WEST);
	mpanel.add(rmpanel);
    
   
	t_1.add("도서 정보",mpanel);                               //모든 요소를 t_1에 부착
	t_1.setFont( new Font( "Times", Font.BOLD, 18 ) );
	}
/*
//테이블 셀에 색 넣기..
public Color getTableCellBackground(JTable table, int row, int col) {
    TableCellRenderer renderer = table.getCellRenderer(row, col);
    Component component = table.prepareRenderer(renderer, row, col);    
    return component.getBackground();
}
class MyRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(
 		   JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        JTextField editor = new JTextField();
        if (value != null) {
            editor.setText(value.toString());
        }
        editor.setBackground((row % 2 == 0) ? Color.white : Color.BLUE);
        return editor;
    }
}*/



ActionListener ac = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
			new SwingProject1_newf();
		/*}else if (cmd.equals(btn4.getText())) {                    //삭제버튼으로 선택한 행 삭제
			m3.removeRow(table7.getSelectedRow());
		}else if (cmd.equals(btn3.getText())) {
			
		}
		
	}*/
}};

@Override
public void mouseClicked(MouseEvent e) {
	int i = (Integer)table7.getValueAt(table7.getSelectedRow(),0);          //Object 타입을 정수형로 변환
	String str0 = i + "";                                                                                      //정수형을 다시 문자형으로 변환

	String str1 = (String) table7.getValueAt(table7.getSelectedRow(),1);            //Object 타입을 모두 문자형으로 변환
	String str2 = (String) table7.getValueAt(table7.getSelectedRow(),2);
	String str3 = (String) table7.getValueAt(table7.getSelectedRow(),3);
	String str4 = (String) table7.getValueAt(table7.getSelectedRow(),4);
	String str5 = (String) table7.getValueAt(table7.getSelectedRow(),5);
	tf1.setText(str0);
	tf2.setText(str1);
	tf3.setText(str2);
	tf4.setText(str3);
	tf5.setText(str4);
	tf6.setText(str5);
}
@Override
public void mousePressed(MouseEvent e) {}
@Override
public void mouseReleased(MouseEvent e) {}
@Override
public void mouseEntered(MouseEvent e) {}
@Override
public void mouseExited(MouseEvent e) {}





//도서관리 창에서만 사용하는 검색창을 위해 새로운 프레임을 내부클래스로 선언
public class SwingProject1_newf implements ActionListener,MouseListener{
	String col1[] = {"NO.","제목","저자","출판사","ISBN"};
	String row1[][] ;
	int cnt =0;
	JTabbedPane t_1 = new JTabbedPane();
	JPanel lpanel = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel lpanel2 = new JPanel();
	JPanel rpanel = new JPanel();
	JPanel rpanel2 = new JPanel();
	JPanel rmpanel = new JPanel();
	JPanel mpanel = new JPanel();
	JButton btn = new JButton("검색");
	JButton btn2 = new JButton("보유목록 추가");
	JButton btn3 = new JButton("이미지 추가");
	JLabel lab1 = new JLabel("ISBN 검색");
	JLabel lab3 = new JLabel("제목");
	JLabel lab4 = new JLabel("저자");
	JLabel lab5 = new JLabel("출판사");
	JLabel lab6 = new JLabel("ISBN");
	JTextField tf22 = new JTextField(40);
	JTextField tf33 = new JTextField(40);
	JTextField tf44 = new JTextField(40);
	JTextField tf55 = new JTextField(40);
	JTextField tf11 = new JTextField(40);
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
		
		lpanel.setLayout(new BorderLayout());
		lmpanel.setLayout(new BorderLayout());
		rpanel.setLayout(null);
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
		
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"ISBN 검색 내용");
		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		model = new DefaultTableModel(row1,col1);
		table = new JTable(model);
		scr = new JScrollPane(table);
		
		lpanel.setBorder(jtx);
		lpanel.add(scr);
		lmpanel.add(lpanel,BorderLayout.CENTER);
		lmpanel.add(lpanel2,BorderLayout.SOUTH);
		m =(DefaultTableModel)table.getModel()	;
		
		TitledBorder jtx1= 
	    		new TitledBorder(new LineBorder(Color.white),"ISBN ");
		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
		 
		 TitledBorder jtx2= 
		    		new TitledBorder(new LineBorder(Color.white),"ISBN 검색");
			 jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
			 
	   rpanel.setBorder(jtx1);
	   rpanel2.setBorder(jtx2);
	   rpanel.setPreferredSize(new Dimension(540,500));   //1110,725
	   
	   ImageIcon inicon = new ImageIcon("C:\\\\Java\\\\eclipse-workspace\\\\image\\\\booktest1.jpg");
		Image inimg = inicon.getImage();    //icon 이미지 img에 넣기
		Image change = inimg.getScaledInstance(230, 320, Image.SCALE_SMOOTH); //img이미지 크기조절
		ImageIcon changeicon = new ImageIcon(change);//img 이미지 다시 imageicon에 넣기
		
	   JLabel imlabel = new JLabel(changeicon); //라벨에 부착
	   rpanel.add(imlabel);
	   imlabel.setBounds(270, 30, 230, 320);   //라벨과 이미지 사이즈 맞추기 280,320
		
		lab1.setBounds(30, 55, 80, 30);
	    tf11.setBounds(110, 55, 200, 30);
	    btn.setBounds(350, 55, 100, 30);
	    lmpanel.setPreferredSize(new Dimension(570,500));  //1110,725
	    table.getColumnModel().getColumn(0).setPreferredWidth(30);  //JTable 의 컬럼 길이 조절
	    table.getColumnModel().getColumn(1).setPreferredWidth(200);
	    table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(50);
	    table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table.setFont(new Font( "Times", Font.BOLD, 20) );	
	    table.setRowHeight(25);
	    table.addMouseListener(this);
	    
	    btn2.setBounds(130, 420, 250, 50);
	    lab3.setBounds(20, 30, 170, 30);
	    lab4.setBounds(20, 100, 170, 30);
	    lab5.setBounds(20, 170, 170, 30);
	    lab6.setBounds(20, 240, 170, 30);
	    tf22.setBounds(20, 60, 220, 30);
	    tf33.setBounds(20, 130, 220, 30);
	    tf44.setBounds(20, 200, 220, 30);
	    tf55.setBounds(20, 270, 220, 30);
	    btn3.setBounds(400, 350, 100, 30);
	    lab3.setFont(fon);
	    lab4.setFont(fon);
	    lab5.setFont(fon);
	    lab6.setFont(fon);
	    
		rpanel.add(lab3);
		rpanel.add(lab4);
		rpanel.add(lab5);
		rpanel.add(lab6);
		rpanel.add(tf22);
		rpanel.add(tf33);
		rpanel.add(tf44);
		rpanel.add(tf55);
		rpanel.add(btn3);
	    
	    rpanel2.add(lab1);
	    rpanel2.add(btn);
	    btn.addActionListener(this);
		rpanel2.add(tf11);
		tf11.addActionListener(this);
		rpanel.add(btn2);
		btn2.setPreferredSize(new Dimension(100,40));
		btn2.addActionListener(this);
		rmpanel.add(rpanel2,BorderLayout.CENTER);
		rmpanel.add(rpanel,BorderLayout.SOUTH);	
	    
		newf.add(mpanel); 
		t_1.setFont( new Font( "Times", Font.BOLD, 18 ) );
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand()	;
		 if(cmd.equals(btn.getText())){                  
			 String item = tf11.getText();                //ISBN값을 ParseEx3에 넣고 값 가져오기
		ParseEx3 ex3 = new ParseEx3(item);
		for (int i = 0; i < ex3.title1.size(); i++) {
			 m.insertRow(i, new Object[] {i+1,ex3.title1.get(i),             
					 ex3.author1.get(i),ex3.pub1.get(i),ex3.isbn1.get(i)});
				table.updateUI();
				}
		}else if(cmd.equals(btn2.getText())) {                   //검색한 목록을 도서목록에 추가하기
			cnt++;
		     m3.insertRow(0, new Object[] {cnt,
			  table.getValueAt(table.getSelectedRow(),1),
				table.getValueAt(table.getSelectedRow(),2),
				table.getValueAt(table.getSelectedRow(),3),
				table.getValueAt(table.getSelectedRow(),4),
				"대출 가능"});
			table.updateUI();
		}
		 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object 타입을 모두 정수형으로 변환
		String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
		String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
		String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
		
		tf22.setText(str1);
		tf33.setText(str2);
		tf44.setText(str3);
		tf55.setText(str4);
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