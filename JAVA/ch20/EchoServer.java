package ch20;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	
	int cnt = 0; //Client �� ���� ���� 
	ServerSocket server;
	int port = 8000;  //��Ʈ ��ȣ 
	
	public EchoServer() {
		try {
			server = new ServerSocket(port);
				System.out.println("ServerSocket Start**********");
				
				while(true){
					//client�� �����ҋ����� ������ 
					Socket sock = server.accept();
					EchoThread et = new EchoThread(sock);
					et.start();//run�޼ҵ� ȣ��
					cnt++;
					System.out.println("Clint"+cnt+"Socket");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//���ӵ� Ŭ���̾�Ʈ �����ϱ����� Thread ��ӹ��� Ŭ���� 
	class EchoThread extends Thread{
		
		Socket sock;
		BufferedReader in; //Ŭ���̾�Ʈ�� ������ �޼��� �޴� ��Ʈ��
		PrintWriter out ; //Ŭ���̾�� �޼��� ������ ��Ʈ�� 
		
		public EchoThread(Socket sock) {
		try {
			this.sock = sock;
			in = new BufferedReader(new
					InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(
					sock.getOutputStream(),true/*auto flush*/);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
		@Override
		public void run() {
			try {
				//client �� �޴� ù �޼���
				out.println("Hello Enter BYB to exit");
				while(true) {
					String line = in.readLine();//Client ���� �޼����� ���Ë����� �밡���� 
					if(line == null) {
						break;  // client���� ������ ������ ��������
					}
					else {
						out.println("Echo : "+ line );
						if(line.equals("BYB"));
						break;
					}
				
				}
				out.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
			new EchoServer();
		
		
	}

}
