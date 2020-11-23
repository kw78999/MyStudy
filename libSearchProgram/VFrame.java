package libSearchProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import libSearchProgram.ParseEx3;

public class VFrame extends JFrame implements MouseListener, ActionListener{
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	       Image img = icon.getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}//이미지를 받아서 버튼 사이즈에 맞게 조절해주는 메소드. 아래 int offset과 같이 사용
	ImageIcon iconHeart = new ImageIcon("libFrame/like.png");

	
	JTextField tf;//마우스리스너때문에 클래스의 필드로 선언
						//생성자에 선언하면??? 스태틱은???
	
	JButton btn1, btn2;
	
	DefaultTableModel model;
	JTable table;
	JTextField tf1, tf2, tf3;

	
	public VFrame() {
		
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true),"미보유 도서 검색");
		tB1.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 12) );
		
		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true),"검색 결과");
		tB2.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 18) );
		
		TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true),"도서 신청");
		tB3.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 18) );
		
		Font lbfont = new Font("잘풀리는오늘 Medium", Font.PLAIN,14);
		Font lbfont2 = new Font("잘풀리는오늘 Medium", Font.PLAIN,16);
		
		
		
		setTitle("도서 요청");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 560);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		

		
		JPanel p1, p2, p3;
		////////////////////////////////////////////////
		//검색테이블패널
		ImageIcon iconSearch = new ImageIcon("libFrame/searchIcon.png");

		
		p1 = new JPanel();
	//	p1.setBorder(tB1);
		p1.setLayout(null);
		p1.setBounds(0, 0, 780, 80);
		p1.setBackground(Color.WHITE);
		SearchPanel05 p5 = new SearchPanel05();
		
		String s = p5.name;
		String s1 = p5.testInputName;
		JTextArea ta = new JTextArea(s1+"님 반갑습니다.\n"
				+ "찾으시는 도서명을 검색해서 투표해주세요.");
		ta.setEditable(false);
		ta.setBounds(130, 20, 300, 32);
		ta.setFont(lbfont);
		
		tf = new JTextField("도서명을 입력하세요.");
		tf.setBounds(450, 30, 200, 26);
		tf.addMouseListener(this);
		
		btn1 = new JButton(iconSearch);
		btn1.setBounds(650, 30, 27, 25);
		btn1.setContentAreaFilled(false);
		btn1.addActionListener(this);
		p1.add(btn1);
		p1.add(ta);
		p1.add(tf);
		
		////////////////////////////////////////////////
		//목록테이블패널
		p2 = new JPanel();
		p2.setBorder(tB2);
		p2.setLayout(null);
		p2.setBounds(0, 80, 780, 280);
		p2.setBackground(Color.WHITE);
		JScrollPane scroll;
		String[] col = {"도서명", "저자", "출판사", "좋아요"};
		/*Object[][] data = {
				{"죄와 벌 (하)", "도스토예프스키", "민음사", "97표"},
				{"예언자", "칼릴 지브란", "책과 세상", "67표"},
				{"일찍 일어나는 새는 단명한다", "천행운", "행운", "17표"}
				};*/
		Object[][] row = {};
		model = new DefaultTableModel(row, col);
		
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);//가로 선 제거
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일행 선택
		table.setDefaultEditor(Object.class, null);//테이블 수정 불가능 (null)//JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setRowHeight(25);
		table.addMouseListener(this);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(Object.class, centerRenderer); 		//table.set
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 30, 740, 240);
		p2.add(scroll);
		////////////////////////////////////////////////
		//투표패널
		p3 = new JPanel();
		p3.setBorder(tB3);
		p3.setLayout(null);
		p3.setBounds(0, 360, 780, 160);
		p3.setBackground(Color.WHITE);
		
		
		int lbX = 50;
		
		JLabel lb1, lb2, lb3;
		lb1 = new JLabel("도서명");
		lb1.setBounds(lbX, 40, 100, 24);
		lb1.setFont(lbfont2);
		tf1 = new JTextField();
		tf1.setBounds(lbX+50, 40, 300, 24);
		tf1.setBackground(new Color(235,235,235));
		tf1.setFont(lbfont2);
		
		lb2 = new JLabel("저자");
		lb2.setBounds(lbX, 70, 100, 24);
		lb2.setFont(lbfont2);
		tf2 = new JTextField();
		tf2.setBounds(lbX+50, 70, 300, 24);
		tf2.setBackground(new Color(235,235,235));
		tf2.setFont(lbfont2);
		
		lb3 = new JLabel("출판사");
		lb3.setBounds(lbX, 100, 100, 24);
		lb3.setFont(lbfont2);
		tf3 = new JTextField();
		tf3.setBounds(lbX+50, 100, 250, 24);
		tf3.setBackground(new Color(235,235,235));
		tf3.setFont(lbfont2);
		
		JPanel p4 = new JPanel();
		p4.setLayout(null);
		p4.setBounds(400, 16, 370, 135);
		p4.setBackground(null);
		JTextArea ta2;
		ta2 = new JTextArea("      찾으시는 도서가 맞다면?\n\n원하는 도서가 출력되지 않는 경우\n아래 프린트 아이콘을 눌러\n양식을 출력해주세요.");
		ta2.setBounds(100, 30, 200, 110);
		ta2.setFont(lbfont);
		ta2.setEditable(false);
		
		btn2 = new JButton(iconHeart);
		btn2.setBounds(300, 20, 40, 34);
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		btn2.setFocusPainted(false);
		btn2.addMouseListener(this);
		
		int offset = btn2.getInsets().left; //버튼 크기 재기
		btn2.setIcon(resizeIcon(iconHeart, btn2.getWidth() - offset, btn2.getHeight() - offset)); //버튼 크기에 맞춰 이미지 삽입
		
		p4.add(btn2);
		
		p4.add(ta2);
		p3.add(p4);
		p3.add(lb1);
		p3.add(lb2);
		p3.add(lb3);
		p3.add(tf1);
		p3.add(tf2);
		p3.add(tf3);
		add(p1);
		add(p2);
		add(p3);
		
		setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		for (int i = 0; i < table.getColumnCount(); i++) {
			String s1 = (String) table.getValueAt(row, 0);
			String s2 = (String) table.getValueAt(row, 1);
			String s3 = (String) table.getValueAt(row, 2);
			tf1.setText(s1);
			tf2.setText(s2);
			tf3.setText(s3);
		}//--for 패널2 문자 바꾸는 반복문
		if(obj==btn2) {
			btn2.setBounds(300-2, 20-2, 44, 38);
			int offset = btn2.getInsets().left; //버튼 크기 재기
			btn2.setIcon(resizeIcon(iconHeart, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
		btn2.setBounds(300, 20, 40, 34);
		int offset = btn2.getInsets().left; //버튼 크기 재기
		btn2.setIcon(resizeIcon(iconHeart, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
		btn2.setBounds(300-2, 20-2, 44, 38);
		int offset = btn2.getInsets().left; //버튼 크기 재기
		btn2.setIcon(resizeIcon(iconHeart, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		String dft = tf.getText();
		if(obj==tf&&dft.equals("도서명을 입력하세요.")) {
			tf.setText("");
		}else if(obj==btn2) {
			btn2.setBounds(300-2, 20-2, 44, 38);
			int offset = btn2.getInsets().left; //버튼 크기 재기
			btn2.setIcon(resizeIcon(iconHeart, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
			btn2.setBounds(300, 20, 40, 34);
			int offset = btn2.getInsets().left; //버튼 크기 재기
			btn2.setIcon(resizeIcon(iconHeart, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	
	
	public static void main(String[] args) {
		new VFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			 if(obj.equals(btn1)){            
				 
				 model.setNumRows(0);//행 초기화 메소드
				 
				 
				 String item = tf.getText(); 
			ParseEx3 ex3 = new ParseEx3(item);
			for (int i = 0; i < ex3.title1.size(); i++) {
				 model.insertRow(i,
						 new Object[] {
								 ex3.title1.get(i),             
								 ex3.author1.get(i),
								 ex3.pub1.get(i),
								 ex3.isbn1.get(i)});
					//table.updateUI();
					}
			}
			 
		}
		
	}

