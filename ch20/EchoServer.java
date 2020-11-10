package ch20;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	
	int cnt = 0; //Client 의 접속 갯수 
	ServerSocket server;
	int port = 8000;  //포트 번호 
	
	public EchoServer() {
		try {
			server = new ServerSocket(port);
				System.out.println("ServerSocket Start**********");
				
				while(true){
					//client가 접속할떄까지 대기상태 
					Socket sock = server.accept();
					EchoThread et = new EchoThread(sock);
					et.start();//run메소드 호출
					cnt++;
					System.out.println("Clint"+cnt+"Socket");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//접속된 클라이언트 대응하기위해 Thread 상속받은 클래스 
	class EchoThread extends Thread{
		
		Socket sock;
		BufferedReader in; //클라이언트가 보내는 메세지 받느 스트림
		PrintWriter out ; //클라이언로 메세지 보내는 스트림 
		
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
				//client 가 받는 첫 메세지
				out.println("Hello Enter BYB to exit");
				while(true) {
					String line = in.readLine();//Client 에서 메세지가 들어올떄까지 대가상태 
					if(line == null) {
						break;  // client에서 접속을 끊으면 연결해제
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
