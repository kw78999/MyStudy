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


public class ChatClient {
	static JTextField ctf = new JTextField("",50);
	static JTextArea cta = new JTextArea();
	static JButton cbtn = new JButton("������");
	static Color cor= Color.white;
	static String id;
	static JScrollPane chatScroll ;
	static Socket socket;
	static JPanel mpanel = new JPanel();
	static Color red = new Color(255,184,249);
	static Color bg = new Color(186,218,255);
	//static Color bg = new Color(186,218,255);
	//new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
	static TitledBorder jtx2;
	static LineBorder lb = new LineBorder(cor,5);
	
	
	public ChatClient() {
		 jtx2=                       
		    		new TitledBorder(lb,"ȸ������ ä��");
		  jtx2.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
		
		  mpanel.setLayout(null);
		  mpanel. setBackground(bg);
		  mpanel. setBorder(jtx2);
		  chatScroll = new JScrollPane(cta);
		  ChatAction ca = new ChatAction();
		  
				
		  //cta.setEnabled(false);
		  cta.setForeground(Color.black);
		  
		  cbtn.addActionListener(ca.acc);
		  ctf.addActionListener(ca.acc);
		  cbtn.setBounds(455, 220, 80,30);
		  ctf.setBounds(20, 220, 435, 30);
		  chatScroll.setBounds(20,30	, 515, 190);
		  mpanel.add(cbtn);
		  mpanel. add(ctf);
		  mpanel. add(chatScroll);
		  mpanel. validate();//����
		  ca.connect();  //������ ���ÿ� ������ Ŀ��Ʈ 
		  
		  }

}
	

	
	
	
	
	
	

