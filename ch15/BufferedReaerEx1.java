package ch15;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaerEx1 {

	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String s = "";
		while(true) {
			try {
				s=br.readLine();
				System.out.println("Ãâ·Â : " + s);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
	}

}
