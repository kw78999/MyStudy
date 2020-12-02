package ch15;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BufferedWriterEx1 {

	public static void main(String[] args) {
		String s = "오늘은 행복한 금요일";
		BufferedWriter bw = 
				new BufferedWriter(
						new OutputStreamWriter(
								System.out));
	try {
		bw.write(s,0,s.length()); //s를 0부터 length까지 
		bw.newLine();
		bw.write(s);
		bw.flush();
		bw.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
