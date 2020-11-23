package JAVAP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ChatAction extends Thread implements Runnable {
	static Socket socket;
	static BufferedReader in;
	static 	PrintWriter out;
	
	
	
	 ActionListener acc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==ChatClient.cbtn5) {
				if(socket==null) {
					System.out.println("소켓은 널1111");
					}
				connect();
				if(socket==null) {
					System.out.println("소켓은 널33333");
					}
				ChatClient.cbtn5.setEnabled(false);
				ChatClient.ctf.requestFocus();  //포커스
				
			}else if(obj==ChatClient.ctf||obj==ChatClient.cbtn) {
				if(ChatClient.id==null) {
					ChatClient.id = ChatClient.ctf.getText();
					ChatClient.cta.setText("관리자 모드로 채팅을 시작합니다");
					
				}
				out.println(ChatClient.ctf.getText());
				ChatClient.ctf.setText("");
				ChatClient.	ctf.requestFocus();
				int pos = ChatClient.cta.getText().length();
				ChatClient.cta.setCaretPosition(pos);
		}
	}
	};
	
	
	
	
	
	



	@Override
	public void run() {
		try {
			while(true) {
		
				
				ChatClient.cta.append(in.readLine()+"\n");
				
				ChatClient.ctf.requestFocus();
			}
			
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void connect() {
		try {
		 socket = new Socket("127.0.0.1",8001);
			in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			out = new PrintWriter(
					socket.getOutputStream(),true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread(this).start();
	}
	
	
}