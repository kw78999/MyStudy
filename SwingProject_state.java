package JAVAP;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
	String col[] = {"대출번호","회원번호","회원 이름","도서 번호","도서 이름","대출 날짜","반납 날짜"};
	String row[][] = {{"001","1","홍길동","24","자바 참고서","2020-11-12","2020-11-15"},
	                                {"002","2","강호동","94","참고서","2020-11-11","2020-11-16"},
	                                {"003","7","김길동","4","영어 참고서","2020-11-11","2020-11-16"},
	                                {"004","13","컴퓨터","44","교과서","2020-11-11","2020-11-16"},
	                                {"005","64","테스트","24","오라클 참고서","2020-11-11","2020-11-16"},
	                                {"006","45","테스트2","91","설계책","2020-11-11","2020-11-16"},
	                                {"007","33","박효신","12","오라클 참고서","2020-11-11","2020-11-16"},
	                                {"008","12","김철수","54","데이터","2020-11-11","2020-11-16"},
	                                {"009","8","강호동","32","베이스","2020-11-11","2020-11-16"},
	                                {"010","6","강호동","16","참고서","2020-11-11","2020-11-16"} };
	
	JPanel npanel = new JPanel();
	JPanel mpanel = new JPanel();
	JPanel cpanel = new JPanel();
	
	JTable table;                             //테이블에 필요한 클래스
	DefaultTableModel model;
	JScrollPane scr;
	DefaultTableModel m;
	
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("검색");
	
         public SwingProject_state() {
        	 mpanel.setBackground(new  Color(170,220,255));
        	 npanel.setBackground(new  Color(170,220,255));
        	 cpanel.setBackground(new Color(170,220,255));
             npanel.setLayout(null);
             mpanel.setLayout(null);
             
         	TitledBorder jtx=          //검색창 보더
    	    		new TitledBorder(new LineBorder(Color.white),"검색");
    		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    	     
          	TitledBorder jtx1=          //검색창 보더
     	    		new TitledBorder(new LineBorder(Color.white),"회원과의 채팅");
     		 jtx1.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
     		 cpanel.setBorder(jtx1);
     		 
    		 cho.add("대출 번호");
    		 cho.add("회원 번호");
    		 cho.add("도서 번호");
    		 cho.setBounds(250, 50, 150, 50);
    		 tf.setBounds(430,50 , 150, 27);
    	
    		 
    		 btn.setBounds(580, 50, 100, 27);
    	     	model = new DefaultTableModel(row,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
    			table = new JTable(model);         //테이블에 테이블모델 입히기
    			scr = new JScrollPane(table); 	//스크롤 생성
    		//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 가로스크롤 
    			 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
    			    table.getColumnModel().getColumn(1).setPreferredWidth(90);
    			    table.getColumnModel().getColumn(2).setPreferredWidth(110);
    			    table.getColumnModel().getColumn(3).setPreferredWidth(90);
    			    table.getColumnModel().getColumn(4).setPreferredWidth(400);
    			    table.getColumnModel().getColumn(5).setPreferredWidth(200);
    			    table.getColumnModel().getColumn(6).setPreferredWidth(200);
    			    table.setFont(new Font( "Times", Font.BOLD, 20) );
    			    table.setRowHeight(30);
    			    table.enable(false);
    			    
    	 cpanel.setBounds(600, 430, 570,260);
    	 npanel.add(tf);
    	 npanel.add(btn);
    	 npanel.add(cho);
    	 npanel.setBounds(0, 0, 1200, 120);
    	 mpanel.add(scr);
    	 scr.setBounds(0, 120, 1175, 300);
    	 npanel.setBorder(jtx);
    	 mpanel.add(npanel);
    	 mpanel.add(cpanel);
    	 npanel.setPreferredSize(new Dimension(1200,120));	 
            	 
            	 
            	 
            	 
            	 
            	 
            	 
            	 
            	 
            
            	 
          }
}
