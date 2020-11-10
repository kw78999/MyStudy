package ch05;

import java.util.Scanner;

public class ExceptionDemo {
 
	
	 static void cal() {
		
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("연산이  필요한 숫자 두개를 입력하세요.");
					System.out.print("첫번째 숫자 : ");
					int a = sc.nextInt();
					System.out.print("두번째 숫자 : ");
					int b = sc.nextInt();
					try{System.out.println(a/b);
 }catch(Exception e) {
				 System.out.println("0과 음수로 나눌 수 없습니다 . 다시입력 하세요");
				 cal();
 }
					
			}}
	public static void main(String[] args)     {
	
			cal();
			System.out.println("asdasd");
  
  
  
  
	}

	}
