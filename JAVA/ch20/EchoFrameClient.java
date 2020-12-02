package ch20;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class EchoFrameClient extends MFrame
implements ActionListener{
	
	Button btn1, btn2;
	TextField tf1, tf2;
	TextArea ta;
	Panel p1, p2;
	BufferedReader in;
	PrintWriter out;
	int port = 8000;
	
	public EchoFrameClient() {
		super(350,400);
		setTitle("EchoFrameClient");
		p1 = new Panel();
		p1.add(new Label("HOST ",Label.CENTER));
		p1.add(tf1 = new TextField("127.0.0.1",25));
		p1.add(btn1 = new Button("Connect"));
		
		p2 = new Panel();
		p2.add(new Label("CHAT ",Label.CENTER));
		p2.add(tf2 = new TextField("",25));
		p2.add(btn2 = new Button("SEND"));	
		
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(ta=new TextArea());
		add(p2,BorderLayout.SOUTH);
		validate();//����
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==tf1||obj==btn1) {
			//��������
			connect(tf1.getText().trim());
			//��Ȱ��ȭ 
			tf1.setEnabled(false);
			btn1.setEnabled(false);
			tf2.requestFocus();
		}else if(obj==tf2||obj==btn2) {
			try {
				//tf2�� �Էµ� ���ڸ� ������ ������
				out.println(tf2.getText());
				//�������� ���ڹ��ڿ��� �´�
				ta.append(in.readLine()+"\n");
				tf2.setText("");
				tf2.requestFocus();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//server sock �� �����ϴ� ���
	public void connect(String host){
	try {
		Socket sock = new Socket(host,port);
		in = new BufferedReader(new
				InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(
				sock.getOutputStream(),true/*auto flush*/);
		//���� ���ӽ� ���� �޴� �޼��� ���
		ta.append(in.readLine()+"\n");
		tf2.requestFocus();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
		new EchoFrameClient();
	}
}





