package ch15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class LIneNumEx1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = 
					new FileInputStream("ch15/LIneNumEx1.java");
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(fis));
			
			FileOutputStream fos =
					new FileOutputStream("ch15/LIneNumEx1.txt");
			//다목적 출력 스트림
			PrintStream ps = new PrintStream(fos);
			////////////////////////////////////////////////
			String s = "";
			int i = 1;
			while(true) {
				s = br.readLine();
				if(s == null)break;
				if(i < 10)
					s="0"+i+" : "+ s;
				else
					s= i+ "  : "+s;
				ps.println(s);
				i++;
			}
			System.out.println("성공");
			ps.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
