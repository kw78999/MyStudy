package ch15;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriterEx1 {

	public static void main(String[] args) {
		try {
			int i = 'A';
			char c = 'b';
			char c1 = '��';
			OutputStream os = System.out;
			Writer writer = new OutputStreamWriter(os);
			writer.write(i);
			writer.write(c);
			writer.write(c1);
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
