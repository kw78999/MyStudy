package ch05;

import java.util.Scanner;

public class ExceptionDemo {
 
	
	 static void cal() {
		
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("������  �ʿ��� ���� �ΰ��� �Է��ϼ���.");
					System.out.print("ù��° ���� : ");
					int a = sc.nextInt();
					System.out.print("�ι�° ���� : ");
					int b = sc.nextInt();
					try{System.out.println(a/b);
 }catch(Exception e) {
				 System.out.println("0�� ������ ���� �� �����ϴ� . �ٽ��Է� �ϼ���");
				 cal();
 }
					
			}}
	public static void main(String[] args)     {
	
			cal();
			System.out.println("asdasd");
  
  
  
  
	}

	}
