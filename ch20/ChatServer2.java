package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer2 {
	
	ServerSocket server;
	//CThread1�� �����ϴ� Vector
	Vector<CThread1> vc;
	
	public ChatServer2() {
		try {
			server = new ServerSocket(8001);
			vc = new Vector<CThread1>();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);//���������� ����.
		}
		System.out.println("***************************");
		System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�.");
		System.out.println("***************************");
		try {
			while(true) {
				Socket sock = server.accept();
				CThread1 ct = new CThread1(sock);
				ct.start();
				//�������� ���� �Ŀ� CThread1 ��ü�� Vector�� ����
				vc.addElement(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}
	
	//���ӵ� ��� Client(Vector ����)���� �޼��� ����
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			//Vector�� ����� CThread1�� �ϳ��� ���������� ����
			CThread1 ct = vc.get(i);
			ct.sendMessage(msg);
		}
	}
	
	class CThread1 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public CThread1(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new 
						InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(
						sock.getOutputStream(),true/*auto flush*/);
				System.out.println(sock + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//---CThread1
		
		@Override
		public void run() {
			try {
				//Ŭ���̾�Ʈ�� ���� �Ŀ� ���ʷ� �޴� �޼���
				out.println("����Ͻ� ���̵� �Է��ϼ���");
				id = in.readLine();
				//��� Client���� �޼��� ����
				sendAllMessage("[" + id+"] �� �����Ͽ����ϴ�.");
				String data = "";
				while(true){
					data = in.readLine();
					if(data ==null)break;
					else sendAllMessage("[" +id+"] "+data);
				}
				in.close();
				out.close();
			} catch (Exception e) {
				//������ ���� ������ �������� Vector ���� ���� ��ü�� ���� �ؾ��Ѵ� 
				vc.remove(this);
				System.err.println(sock + "������...");
				e.printStackTrace();
			}
		}
		//����� Client���� �޼��� ������ ���
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer2();
	}
}




