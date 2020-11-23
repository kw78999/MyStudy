package JAVAP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChatClient extends JPanel{
	static JTextField ctf = new JTextField("",50);
	static JTextArea cta = new JTextArea();
	static JButton cbtn = new JButton("보내기");
	static JButton cbtn5 = new JButton("시작");
	static Color cor= Color.white;
	static Color bg = new  Color(170,220,255);
	static BufferedReader in;
	static 	PrintWriter out;
	static String id;
	static JScrollPane chatScroll ;
	static Socket socket;
	
	
	public ChatClient() {
		if(socket==null) {
		System.out.println("소켓은 널");
		}
		 TitledBorder jtx2=                       
		    		new TitledBorder(new LineBorder(bg,5),"회원과의 채팅");
		  jtx2.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
	setLayout(null);
	setBackground(cor);
		setBorder(jtx2);
		ChatAction ca = new ChatAction();
		  cbtn5.addActionListener(ca.acc);
		  cbtn5.setBounds(0, 0, 100,30);
		  cbtn.addActionListener(ca.acc);
		  ctf.addActionListener(ca.acc);
		  cbtn.setBounds(470	, 220, 80,30);
		  ctf.setBounds(20, 220, 450, 30);
		  chatScroll = new JScrollPane(cta);
		  chatScroll.setBounds(20,30	, 530, 190);
		  chatScroll.setBackground(bg);
		  add(cbtn);
		  add(ctf);
		  add(chatScroll);
		  add(cbtn5);
		  validate();//갱신
	}
}
	
	

