package ch15;

import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {

		
		File f = new File("ch15/FileEx1.java");
		if(f.exists()) {
			System.out.println("�����̸� : "+ f.getName());
			System.out.println("����� : "+ f.getPath());
			System.out.println("������ : "+ f.getAbsolutePath());
			System.out.println("���Ⱑ�� : "+ f.canWrite());
			System.out.println("�бⰡ�� : "+ f.canRead());
			System.out.println("����ũ�� : "+ f.length()+"byte");
		}else {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
	}

}
