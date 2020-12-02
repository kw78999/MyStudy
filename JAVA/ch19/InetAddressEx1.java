package ch19;

import java.net.InetAddress;

public class InetAddressEx1 {
	public static void main(String[] args) {
		try {
			InetAddress add = InetAddress.getLocalHost();
			System.out.println("로컬컴퓨터이름 : " +  add.getHostName());
			System.out.println("로컬컴퓨터IP : " +  add.getHostAddress());
			add = InetAddress.getByName("auction.co.kr");
			System.out.println("옥션 : " + add.getHostAddress());
			InetAddress adds[] =
					InetAddress.getAllByName("naver.com");
							for (int i = 0; i < adds.length; i++) {
								System.out.println(adds[i]);
							}
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

