package ch15;

import java.io.FileWriter;

public class FileWriterEx1 {

	public static void main(String[] args) {
		try {
			String str = "Dream as if you'll live foreverLive as if you'll die today-���ӽ���-";
			//������ ���ٸ� ��������� 
			FileWriter fw = new FileWriter("ch15/bb.txt");
			fw.write(str);
			fw.flush();
			fw.close();
			System.out.println("end");
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
