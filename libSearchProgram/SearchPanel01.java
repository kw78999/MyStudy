package libSearchProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import libSearchProgram.BooksBean;




public class SearchPanel01 extends JPanel
implements MouseListener{
	
	
	SearchPanel02 eventInfo;
	SearchPanel04 eventMap;
	JTable table;
	static DefaultTableModel model;
	static DefaultTableModel model2;
	
	ImageIcon bookB = new ImageIcon("libSearchProgram/babybook.jpg");
	ImageIcon bookD = new ImageIcon("libSearchProgram/deepbook.jpg");
	ImageIcon bookH = new ImageIcon("libSearchProgram/htmlbook.jpg");
	ImageIcon bookJ = new ImageIcon("libSearchProgram/jspbook.jpg");
	ImageIcon bookL = new ImageIcon("libSearchProgram/laspbook.jpg");
	ImageIcon bookLI = new ImageIcon("libSearchProgram/livebook.jpg");
	ImageIcon bookP = new ImageIcon("libSearchProgram/prophetbook.jpg");
	ImageIcon bookZ = new ImageIcon("libSearchProgram/zarbook.jpg");
	
	
	SearchPanel02 panel02 = new SearchPanel02();
	
	BooksMgr mgr = new BooksMgr();
	Vector<BooksBean> vlist;
	
	public void SearchTitle() {
		
		model.setNumRows(0); //model(테이블) 행 초기화
		
		JScrollPane scroll;
		
		String[] col = {"도서명", "저자", "출판사", "도서위치", "대출여부", "경로"};
		
		String bTitle = panel02.keyWord;
		
		Vector<BooksBean> vlist = mgr.getBookTitle(bTitle);
		String row[][] = new String[vlist.size()][6];
		for (int i = 0; i < row.length; i++) {
			BooksBean bean = vlist.elementAt(i);
			row[i][0] = bean.getTITLE();
			row[i][1] = bean.getAUTHOR();
			row[i][2] = bean.getPUBLISHER();
			row[i][3] = bean.getLOCATION();
			row[i][4] = bean.getBOOKSTATE();
			row[i][5] = bean.getBCOUNT();
		}
		
		System.out.println("도서명검색 생성자입니다 서치패널01\n"+bTitle);
		
		model2 = new DefaultTableModel(row, col);
		model2.fireTableDataChanged();
		
		table = new JTable(model2);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);//가로 선 제거
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일행 선택
		table.setDefaultEditor(Object.class, null);//테이블 수정 불가능 (null)
		table.getColumnModel().getColumn(0).setPreferredWidth(200);//JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setMaxWidth(5);
		table.setRowHeight(25);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(Object.class, centerRenderer); 
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 24, 650, 400);
		add(scroll);
		
		setVisible(true);
		revalidate();
	}
	
	
	
	public SearchPanel01() {
	
		JScrollPane scroll;
		
		String[] col = {"도서명", "저자", "출판사", "도서위치", "대출여부", "경로"};
//		Object[][] data = {
//				{"JSPstudy의 JSP 웹프로그래밍 입문 + 활용", "정동진, 최주호, 윤성훈", "이푸만약에", "A-13", "대출가능","jspbook"},
//				{"IoT 사물인터넷을 위한 라즈베리파이 4 정석", "최주호, 김재범, 정동진", "이푸만약에", "C-24", "대출가능","laspbook"},
//				{"생활코딩! HTML+CSS+자바스크립트", "이고잉", "위키북스", "D-16", "대출가능","htmlbook"},
//				{"일찍 일어나는 새가 단명한다","천행운","행운","B-12", "대출중","zarbook"}
//		};
		
		Vector<BooksBean> vlist = mgr.getListBooks();
		String row[][] = new String[vlist.size()][6];
		for (int i = 0; i < row.length; i++) {
			BooksBean bean = vlist.elementAt(i);
			row[i][0] = bean.getTITLE();
			row[i][1] = bean.getAUTHOR();
			row[i][2] = bean.getPUBLISHER();
			row[i][3] = bean.getLOCATION();
			row[i][4] = bean.getBOOKSTATE();
			row[i][5] = bean.getBCOUNT();
		}
		
		TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"도서 목록");
		tB3.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 18) );
		setBorder(tB3);
		setLayout(null);
		model = new DefaultTableModel(/*data*/row, col);
		
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);//가로 선 제거
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일행 선택
		table.setDefaultEditor(Object.class, null);//테이블 수정 불가능 (null)
		table.getColumnModel().getColumn(0).setPreferredWidth(200);//JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setMaxWidth(5);
		table.setRowHeight(25);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(Object.class, centerRenderer); 		//table.set
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 24, 650, 400);
		add(scroll);
		
		
		setVisible(true);
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		for (int i = 0; i < table.getColumnCount(); i++) {
			String s1 = (String) table.getValueAt(row, 0);
			String s2 = (String) table.getValueAt(row, 1);
			String s3 = (String) table.getValueAt(row, 3);
			eventInfo.infoTitle.setText("도서명: "+s1);
			eventInfo.infoAuthor.setText("저자: "+s2);
			eventInfo.infoLocate.setText("위치: "+s3);
		}//--for 패널2 문자 바꾸는 반복문
		
		String s = (String) table.getValueAt(row, 5);
				 if(s.equals("zarbook")) {
			eventInfo.infoImg.setIcon(bookZ);
		}else if(s.equals("jspbook")) {
			eventInfo.infoImg.setIcon(bookJ);
		}else if(s.equals("htmlbook")) {
			eventInfo.infoImg.setIcon(bookH);
		}else if(s.equals("laspbook")) {
			eventInfo.infoImg.setIcon(bookL);
		}
		
		
		String[] subStr = new String[4];
		for (int i = 0; i < subStr.length; i++) {
			String str = (String) table.getValueAt(row, 3);
			subStr[i] = str.substring(0, 1);
			
			
			if(subStr[i].equals("A")) {
				eventMap.map.setIcon(eventMap.MAPA);
			}else if(subStr[i].equals("B")) {
				eventMap.map.setIcon(eventMap.MAPB);
			}else if(subStr[i].equals("C")) {
				eventMap.map.setIcon(eventMap.MAPC);
			}else if(subStr[i].equals("D")) {
				eventMap.map.setIcon(eventMap.MAPD);
			}
		}//--for 패널3 지도 바꾸는 반복문
		
			
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
