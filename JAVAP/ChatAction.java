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
				//if(socket==null) 
				connect();
				
				ChatClient.cbtn5.setEnabled(false);
				ChatClient.ctf.requestFocus();  //��Ŀ��
				
			}else if(obj==ChatClient.ctf||obj==ChatClient.cbtn||obj==SwingProject_state.cbtn||obj==SwingProject_state.ctf||
					obj==SwingProject_1.cbtn||obj==SwingProject_1.ctf||obj==SwingProject_2.cbtn||obj==SwingProject_2.ctf
					||obj==ChartFrame.ctf||obj==ChartFrame.cbtn) {
				if(ChatClient.id==null) {
					ChatClient.id ="������";
					ChatClient.cta.setText("������ ���� ä���� �����մϴ�");
					SwingProject_state.cta.setText("������ ���� ä���� �����մϴ�.");
					SwingProject_1.cta.setText("������ ���� ä���� �����մϴ�.");
					SwingProject_2.cta.setText("������ ���� ä���� �����մϴ�.");
					ChartFrame.cta.setText("������ ���� ä���� �����մϴ�.");
				}
				if(!ChatClient.ctf.getText().equals("")) {   //��Ǫ ctf�� ""�� �ƴҽÿ� 
					out.println(ChatClient.ctf.getText());    //���� �ؽ�Ʈ�� �ִ� tf�� ������ �����ϱ� 
					ChatClient.ctf.setText("");
				}else if(!SwingProject_state.ctf.getText().equals("")){
					out.println(SwingProject_state.ctf.getText());
					SwingProject_state.ctf.setText("");
				}else if(!SwingProject_1.ctf.getText().equals("")) {
					out.println(SwingProject_1.ctf.getText());
					SwingProject_1.ctf.setText("");
				}else if(!SwingProject_2.ctf.getText().equals("")) {
					out.println(SwingProject_2.ctf.getText());
					SwingProject_2.ctf.setText("");
				}else if(!ChartFrame.ctf.getText().equals("")) {
					out.println(ChartFrame.ctf.getText());
					ChartFrame.ctf.setText("");
				}
				int pos = ChatClient.cta.getText().length();
				ChatClient.cta.setCaretPosition(pos);
				SwingProject_1.cta.setCaretPosition(pos);
				SwingProject_2.cta.setCaretPosition(pos);
				SwingProject_state.cta.setCaretPosition(pos);
				ChartFrame.cta.setCaretPosition(pos);
		}
	}
	};

	@Override
	public void run() {
		try {
			while(true) {
				String str = in.readLine()+"\n";    //���� ���� ��Ʈ������Ƽ� �ϳ��� �����ֱ� 
				ChatClient.cta.append(str);
				SwingProject_state.cta.append(str);
				SwingProject_1.cta.append(str);
				SwingProject_2.cta.append(str);
				ChartFrame.cta.append(str);
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