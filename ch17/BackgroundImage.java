package ch17;

	import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

	public class BackgroundImage extends JFrame {
	    
			JScrollPane scrollPane;
	        // 멤버 필드에 ImageIcon 클래스 생성자    
	    	ImageIcon icon;
	    	
	    public BackgroundImage() {
	    	setLayout(null);

	        JButton button = new JButton("log in");
	        JLabel l1=new JLabel("id");
	        JTextField t1=new JTextField(15);
	        l1.setBounds(50, 20, 50, 25);
	        t1.setBounds(70, 20, 70, 25);
	        button.setBounds(50, 80, 90, 25);
	       
	        JLabel l2=new JLabel("pw");
	        JTextField t2=new JTextField(15);
	        l2.setBounds(50, 50, 50, 25);
	        t2.setBounds(70, 50, 70, 25);
	        
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(button);
	    }

	    public static void main(String[] args) {
	        BackgroundImage frame = new BackgroundImage();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 300);
	        frame.setVisible(true);
	    }
	}


