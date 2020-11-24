package ch20;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ChatLogin3 extends MFrame implements ActionListener {

	TextField idTx, pwTx;
	Label logo, idl, pwl, msgl;
	Button logBtn;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String id;
	int port = 8003;
	String title = "MyChat3.0";

	public ChatLogin3() {
		super(450, 400, new Color(100, 200, 100));
		setLayout(null);
		setTitle(title);
		logo = new Label(title);
		logo.setFont(new Font("Dialog", Font.BOLD, 50));

		idl = new Label("ID");
		pwl = new Label("PASS");
		idTx = new TextField("aaa");
		idTx.setBackground(Color.ORANGE);
		pwTx = new TextField("1234");
		pwTx.setBackground(Color.ORANGE);
		logBtn = new Button("로그인");
		logBtn.setBackground(Color.ORANGE);
		msgl = new Label("ID와 PASS을 입력하세요.");
		logo.setBounds(100, 50, 250, 100);
		idl.setBounds(150, 200, 50, 20);
		idTx.setBounds(200, 200, 100, 20);
		pwl.setBounds(150, 230, 50, 20);
		pwTx.setBounds(200, 230, 100, 20);
		logBtn.setBounds(150, 260, 150, 40);
		msgl.setBounds(150, 320, 180, 40);
		logBtn.addActionListener(this);
		add(logo);
		add(idl);
		add(idTx);
		add(pwl);
		add(pwTx);
		add(logBtn);
		add(msgl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		try {
			if (obj == logBtn) {
				if (sock == null) {
					sock = new Socket("10.100.105.5", port);
					//sock = new Socket("10.100.105.5", port);
					in = new BufferedReader(new InputStreamReader(
							sock.getInputStream()));
					out = new PrintWriter(sock.getOutputStream(), true);
				}
				//로그인 로직
				id = idTx.getText();
				out.println(ChatProtocol3.ID+":"+id+";"+pwTx.getText());
				String line = in.readLine();   //T or F
				int idx = line.indexOf(':');
				String cmd = line.substring(0,idx);
				String data = line.substring(idx+1);
				if(cmd.equals(ChatProtocol3.ID)&&data.equals("T")) {   //로그인 성공
					dispose(); //자신의 창이 사라짐
					new ChatClient3(in, out, id);
					
				}else {                     //로그인실패
					msgl.setForeground(Color.red);
					msgl.setText("ID와 PWD를 다시 확인하세요.");
				}
				
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatLogin3();
	}
}
