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

//�̿���Ȳ
public class SwingProject_state {
	String col[] = {"�����ȣ","ȸ����ȣ","ȸ�� �̸�","���� ��ȣ","���� �̸�","���� ��¥","�ݳ� ��¥"};
	String row[][] = {{"001","1","ȫ�浿","24","�ڹ� ����","2020-11-12","2020-11-15"},
	                                {"002","2","��ȣ��","94","����","2020-11-11","2020-11-16"},
	                                {"003","7","��浿","4","���� ����","2020-11-11","2020-11-16"},
	                                {"004","13","��ǻ��","44","������","2020-11-11","2020-11-16"},
	                                {"005","64","�׽�Ʈ","24","����Ŭ ����","2020-11-11","2020-11-16"},
	                                {"006","45","�׽�Ʈ2","91","����å","2020-11-11","2020-11-16"},
	                                {"007","33","��ȿ��","12","����Ŭ ����","2020-11-11","2020-11-16"},
	                                {"008","12","��ö��","54","������","2020-11-11","2020-11-16"},
	                                {"009","8","��ȣ��","32","���̽�","2020-11-11","2020-11-16"},
	                                {"010","6","��ȣ��","16","����","2020-11-11","2020-11-16"} };
	
	JPanel npanel = new JPanel();
	JPanel mpanel = new JPanel();
	
	JTable table;                             //���̺� �ʿ��� Ŭ����
	DefaultTableModel model;
	JScrollPane scr;
	DefaultTableModel m;
	
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("�˻�");
	
         public SwingProject_state() {
        	 mpanel.setBackground(new  Color(170,220,255));
        	 npanel.setBackground(new  Color(170,220,255));
             npanel.setLayout(null);
             mpanel.setLayout(new BorderLayout());
             
         	TitledBorder jtx= 
    	    		new TitledBorder(new LineBorder(Color.white),"�˻�");
    		 jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    		 
    		 cho.add("���� ��ȣ");
    		 cho.add("ȸ�� ��ȣ");
    		 cho.add("���� ��ȣ");
    		 cho.setBounds(250, 50, 150, 50);
    		 tf.setBounds(430,50 , 150, 27);
    		 
    		 
    		 btn.setBounds(580, 50, 100, 27);
    	     	model = new DefaultTableModel(row,col);   //�߰� ���� ������ ������ DefaultTableModel ����
    			table = new JTable(model);         //���̺� ���̺�� ������
    			scr = new JScrollPane(table); 	//��ũ�� ����
    			
    			 table.getColumnModel().getColumn(0).setPreferredWidth(5);  //JTable �� �÷� ���� ����
    			    table.getColumnModel().getColumn(1).setPreferredWidth(5);
    			    table.getColumnModel().getColumn(2).setPreferredWidth(40);
    			    table.getColumnModel().getColumn(3).setPreferredWidth(5);
    			    table.getColumnModel().getColumn(4).setPreferredWidth(300);
    			    table.getColumnModel().getColumn(5).setPreferredWidth(100);
    			    table.getColumnModel().getColumn(6).setPreferredWidth(100);
    			    table.setFont(new Font( "Times", Font.BOLD, 20) );
    			    table.setRowHeight(30);
    			    table.enable(false);
    			    
    	 npanel.add(tf);
    	 npanel.add(btn);
    	 npanel.add(cho);
    	 mpanel.add(scr);
    	 npanel.setBorder(jtx);
    	 mpanel.add(npanel,BorderLayout.NORTH);
    	 npanel.setPreferredSize(new Dimension(1200,120));	 
            	 
            	 
            	 
            	 
            	 
            	 
            	 
            	 
            	 
            
            	 
          }
}
