package ch15;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileCopyEx1 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("원본파일 : ");//FileCopyEx1.java
			String sFile = sc.nextLine();
			System.out.print("복사파일 : ");//FileCopyEx1.txt
			String cFile = sc.nextLine();
			FileReader fr = new FileReader("ch15/"+sFile);
			FileWriter fw = new FileWriter("ch15/"+cFile);
			int c;
			while((c=fr.read())!=-1) {
				fw.write(c);
			}
			fw.flush();
			fw.close();
			fr.close();
			System.out.println("Copy End~~~~~~~");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}






