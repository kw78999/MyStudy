package ch14;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex5 {

	public static void main(String[] args) {
		try {
			FileReader fr = myRead("aaa.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//throws : �� �޼ҵ带 ȣ���Ѱ��� ���ܰ�ü�� �����ڴ�.
	public static FileReader myRead(String name) throws FileNotFoundException {
		FileReader fr = new FileReader(name);
		return fr;
	}
	
	
	
}
