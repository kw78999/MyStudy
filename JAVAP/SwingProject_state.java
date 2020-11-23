package JAVAP;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

//이용현황
public class SwingProject_state {
	static String col[] = {"대출번호","회원번호","회원 이름","도서 번호","도서 이름","대출 날짜","반납 날짜"};
	static String row1 [][];
	JPanel npanel = new JPanel();
	static JPanel mpanel = new JPanel();
	static JPanel tpanel = new JPanel();
	JPanel cpanel=new ChatClient();
	JButton reset =new JButton("reset");
	JButton delete =new JButton("delete");
	static JTable table;                             //테이블에 필요한 클래스
	static DefaultTableModel model;
	static JScrollPane scr;
	static DefaultTableModel m;
	
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("검색");
	
	static BMEMBERSMgr bmgr = new BMEMBERSMgr();
	static  BrentalMgr  mgr= new BrentalMgr();
	 static    Vector <BrentalBean>  vlist ;
	BooksMgr mgr1 = new BooksMgr();
	BooksMgr mgr12 = new BooksMgr();
	
	public static void viewstate() {
		vlist = mgr.getListBRental();
		row1 = new String [vlist.size()][7];
		for (int i = 0; i < row1.length; i++) {
			BrentalBean bean = vlist.elementAt(i);
			row1[i][0] = bean.getRID()+"";
			row1[i][1] = bean.getRMID()+"";
			row1[i][2] = bean.getRNAME();
			row1[i][3] = bean.getBMID()+"";
			row1[i][4] = bean.getBTITLE();
			row1[i][5] = bean.getRENTAL().substring(0, 10);  //날짜 일까지만 보이게하기 
			row1[i][6] = bean.getENDRENTAL().substring(0, 10);
		}
		model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
		table = new JTable(model);         //테이블에 테이블모델 입히기
		scr = new JScrollPane(table); 	//스크롤 생성
		 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
		    table.getColumnModel().getColumn(1).setPreferredWidth(90);
		    table.getColumnModel().getColumn(2).setPreferredWidth(110);
		    table.getColumnModel().getColumn(3).setPreferredWidth(90);
		    table.getColumnModel().getColumn(4).setPreferredWidth(400);
		    table.getColumnModel().getColumn(5).setPreferredWidth(200);
		    table.getColumnModel().getColumn(6).setPreferredWidth(200);
		    table.setFont(new Font( "Times", Font.BOLD, 20) );
		    table.setRowHeight(30);
		    scr.setBounds(0, 0, 1175, 300);
			tpanel.removeAll();
			tpanel.revalidate();
		    tpanel.add(scr);
		
	}
	
         public SwingProject_state() {
        	 viewstate();
        	 mpanel.setBackground(new  Color(170,220,255));
        	 npanel.setBackground(new  Color(170,220,255));
        	 tpanel.setBackground(new Color(170,220,255));
             npanel.setLayout(null);
             mpanel.setLayout(null);
             tpanel.setLayout(null);
             
         	TitledBorder jtx=          //검색창 보더
    	    		new TitledBorder(new LineBorder(Color.white),"검색");
    		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    	     
         /* 	TitledBorder jtx1=          //검색창 보더
     	    		new TitledBorder(new LineBorder(Color.white),"회원과의 채팅");
     		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
     		 cpanel.setBorder(jtx1);*/
     		 
    		 cho.add("대출 번호");
    		 cho.add("회원 번호");
    		 cho.add("도서 번호");
    		 cho.setBounds(250, 50, 150, 50);
    		 tf.setBounds(430,50 , 150, 27);
    		 reset.setBounds(1050, 70, 100, 40);
    		 delete.setBounds(900, 70, 100, 40);
    		 
    		 
    		 btn.setBounds(580, 50, 100, 27);
    	     btn.addActionListener(ac);
    	 cpanel.setBounds(600, 430, 570,260);
    	 tpanel.setBounds(0, 120, 1175, 300);
    	 npanel.add(tf);
    	 npanel.add(btn);
    	 npanel.add(cho);
    	 npanel.add(reset);
    	 npanel.add(delete);
    	 reset.addActionListener(re);
    	 delete.addActionListener(de);
    	 npanel.setBounds(0, 0, 1200, 120);
    	 scr.setBounds(0, 0, 1175, 300);
    	 npanel.setBorder(jtx);
    	 mpanel.add(npanel);
    	 mpanel.add(cpanel);
    	 mpanel.add(tpanel);
    	 npanel.setPreferredSize(new Dimension(1200,120));	 
            	 
          }
         
         ActionListener ac = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {      //대출번호로 가져오기 (하나만)
				if(cho.getSelectedIndex()==0) {
					int RID = Integer.parseInt(tf.getText());
					
					String row1[][] = new String [1][7];
					for (int i = 0; i < row1.length; i++) {
						BrentalBean bean = mgr.getett(RID);
						row1[i][0] = bean.getRID()+"";
						row1[i][1] = bean.getRMID()+"";
						row1[i][2] = bean.getRNAME();
						row1[i][3] = bean.getBMID()+"";
						row1[i][4] = bean.getBTITLE();
						if(row1[i][0].equals("0")) {  // 검색내용이 없으면 날짜형식 그대로 가져오기 (잘라서 가져오면 오류남)
							row1[i][5] = bean.getRENTAL();
							row1[i][6] = bean.getENDRENTAL();
						}else {
						row1[i][5] = bean.getRENTAL().substring(0,10);  //검색내용 있으면 잘라서 보기편하게 가져오기
						row1[i][6] = bean.getENDRENTAL().substring(0,10);
						}
					}
					model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
					table = new JTable(model);         //테이블에 테이블모델 입히기
					scr = new JScrollPane(table); 	//스크롤 생성
					 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
					    table.getColumnModel().getColumn(1).setPreferredWidth(90);
					    table.getColumnModel().getColumn(2).setPreferredWidth(110);
					    table.getColumnModel().getColumn(3).setPreferredWidth(90);
					    table.getColumnModel().getColumn(4).setPreferredWidth(400);
					    table.getColumnModel().getColumn(5).setPreferredWidth(200);
					    table.getColumnModel().getColumn(6).setPreferredWidth(200);
					    table.setFont(new Font( "Times", Font.BOLD, 20) );
					    table.setRowHeight(30);
					    scr.setBounds(0, 0, 1175, 300);
					tpanel.removeAll();
					tpanel.revalidate();
				//	vlist.removeAllElements();
					 tpanel.add(scr);
					 if(table.getValueAt(0, 0).equals("0")) {
						 MDialog md = new MDialog(SwingProject.frame,	"오류", true,"검색내용이 없습니다.");
					md.setVisible(true);
					 }
				}else if(cho.getSelectedIndex()==1) {  //(회원번호로 가져오기 다수)
					int RMID = Integer.parseInt(tf.getText());
					vlist = mgr.getett2(RMID);
					
					String row1[][] = new String [vlist.size()][7];
					for (int i = 0; i < row1.length; i++) {
						BrentalBean bean = vlist.elementAt(i);
						row1[i][0] = bean.getRID()+"";
						row1[i][1] = bean.getRMID()+"";
						row1[i][2] = bean.getRNAME();
						row1[i][3] = bean.getBMID()+"";
						row1[i][4] = bean.getBTITLE();
						if(row1[i][0].equals("0")) {  // 검색내용이 없으면 날짜형식 그대로 가져오기 (잘라서 가져오면 오류남)
							row1[i][5] = bean.getRENTAL();
							row1[i][6] = bean.getENDRENTAL();
						}else {
						row1[i][5] = bean.getRENTAL().substring(0,10);  //검색내용 있으면 잘라서 보기편하게 가져오기
						row1[i][6] = bean.getENDRENTAL().substring(0,10);
						}
						}
					model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
					table = new JTable(model);         //테이블에 테이블모델 입히기
					scr = new JScrollPane(table); 	//스크롤 생성
					 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
					    table.getColumnModel().getColumn(1).setPreferredWidth(90);
					    table.getColumnModel().getColumn(2).setPreferredWidth(110);
					    table.getColumnModel().getColumn(3).setPreferredWidth(90);
					    table.getColumnModel().getColumn(4).setPreferredWidth(400);
					    table.getColumnModel().getColumn(5).setPreferredWidth(200);
					    table.getColumnModel().getColumn(6).setPreferredWidth(200);
					    table.setFont(new Font( "Times", Font.BOLD, 20) );
					    table.setRowHeight(30);
					    scr.setBounds(0, 0, 1175, 300);
					tpanel.removeAll();
					tpanel.revalidate();
					vlist.removeAllElements();
					 tpanel.add(scr);
					 if(table.getRowCount()==0) {
						 MDialog md = new MDialog(SwingProject.frame,	"오류", true,"검색내용이 없습니다.");
					md.setVisible(true);
				}
				
				}else if (cho.getSelectedIndex()==2) {
					int BMID = Integer.parseInt(tf.getText()); //검색하기 
					
					String row1[][] = new String [1][7];
					for (int i = 0; i < row1.length; i++) {
						BrentalBean bean = mgr.getett3(BMID);
						row1[i][0] = bean.getRID()+"";
						row1[i][1] = bean.getRMID()+"";
						row1[i][2] = bean.getRNAME();
						row1[i][3] = bean.getBMID()+"";
						row1[i][4] = bean.getBTITLE();
						if(row1[i][0].equals("0")) {  // 검색내용이 없으면 날짜형식 그대로 가져오기 (잘라서 가져오면 오류남)
							row1[i][5] = bean.getRENTAL();
							row1[i][6] = bean.getENDRENTAL();
						}else {
						row1[i][5] = bean.getRENTAL().substring(0,10);  //검색내용 있으면 잘라서 보기편하게 가져오기
						row1[i][6] = bean.getENDRENTAL().substring(0,10);
						}
					}
					model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
					table = new JTable(model);         //테이블에 테이블모델 입히기
					scr = new JScrollPane(table); 	//스크롤 생성
					 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
					    table.getColumnModel().getColumn(1).setPreferredWidth(90);
					    table.getColumnModel().getColumn(2).setPreferredWidth(110);
					    table.getColumnModel().getColumn(3).setPreferredWidth(90);
					    table.getColumnModel().getColumn(4).setPreferredWidth(400);
					    table.getColumnModel().getColumn(5).setPreferredWidth(200);
					    table.getColumnModel().getColumn(6).setPreferredWidth(200);
					    table.setFont(new Font( "Times", Font.BOLD, 20) );
					    table.setRowHeight(30);
					    scr.setBounds(0, 0, 1175, 300);
					tpanel.removeAll();
					tpanel.revalidate();
					//vlist.removeAllElements();
					 tpanel.add(scr);
					 if(table.getValueAt(0, 0).equals("0")) {
						 MDialog md = new MDialog(SwingProject.frame,	"오류", true,"검색내용이 없습니다.");
					md.setVisible(true);
					 
				}
				}
			}
		};
         ActionListener re = new ActionListener() {  //새로고침 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewstate();
			}
		};
         ActionListener de = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					MDialog MD = new MDialog(SwingProject.frame, "오류", true, "반납할 도서를 선택하세요");
					MD.setVisible(true);
					}else {
					int to2 = Integer.parseInt((String)(table.getValueAt(table.getSelectedRow(),3)));
					int to  = Integer.parseInt((String)(table.getValueAt(table.getSelectedRow(), 1)));	
						BrentalBean bean = vlist.get(table.getSelectedRow());
					if(mgr.deleterental(bean.getRID())) {
						viewstate();
			          }
					
					
						BMEMBERSBean mbean = bmgr.getett(to);
						int mcount = mbean.getECOUNT();
						int limit = mbean.getELIMIT();
						BMEMBERSBean mbean2 = new BMEMBERSBean();
						mbean2.setMID(to);
						mbean2.setECOUNT(mcount);
						mbean2.setELIMIT(limit+1);
						if(bmgr.stateupdateBMEMBERS(mbean2)) {
							SwingProject.p.removeAll();
							SwingProject.p.revalidate();
							SwingProject.vlist.removeAllElements();
							SwingProject.memlist();
						 
						}
					
					//삭제하는 대출데이터의 도서번호로 대출횟수 가져오기 
					BooksBean bean3 = mgr1.getett(to2);
					int bcount = bean3.getBCOUNT();
					//삭제하는 도서 상태바꾸기,대출횟수는 그대로
					BooksBean bean2 = new BooksBean();
					bean2.setBOOKSTATE("대출가능");
					bean2.setBCOUNT(bcount);
					bean2.setBID(to2);
					if(mgr1.stateupdateBooks(bean2)) {
						SwingProject.p1.removeAll();
						SwingProject.p1.revalidate();
						SwingProject.vlist1.removeAllElements();
						SwingProject.viewList();
					} 
					
					MDialog md = new MDialog(SwingProject.frame, "대출", true, "반납 되었습니다.");
					md.setVisible(true);
					
					
					
		}
				
	}};
         
         	
         
         
         
         
			     
		}
