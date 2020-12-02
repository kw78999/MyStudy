package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class URLEx1 {
	public static void main(String[] args) {
		try {
	  String s = "https://search.naver.com:/search.naver?where=nexearch&query=java#top";
	  
	  //url 분석하기 위해서는 먼저 객체화 
	  URL url = new URL(s);
	  System.out.println("Protocol : "+ url.getProtocol());
	  System.out.println("Host : "+ url.getHost());
	  System.out.println("Port : "+ url.getPort());
	  System.out.println("Path : "+ url.getPath());
	  System.out.println("Query : "+ url.getQuery());
	  System.out.println("Filename : "+ url.getFile());
	  System.out.println("Ref : "+ url.getRef());
	  url = new URL("http://auction.co.kr");
	  
	  BufferedReader br = 
			  new BufferedReader(new InputStreamReader(url.openStream(),"KSC_5601"));
	  String line = "";
	  while(true) {
		  line = br.readLine();
		  if(line==null)break;
		  System.out.println(line);
	  }
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
