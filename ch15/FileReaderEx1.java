package ch15;

import java.io.FileReader;

public class FileReaderEx1 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("ch15/aaa.txt");
			int i;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
