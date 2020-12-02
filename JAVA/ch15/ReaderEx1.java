package ch15;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx1 {

	public static void main(String[] args) {
		try {
			InputStream is = System.in;
			Reader reader = new InputStreamReader(is);
			while(true)
			{
				int i = reader.read();
				System.out.print((char)i);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
