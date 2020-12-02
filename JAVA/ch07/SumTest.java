package ch07;

import java.util.Scanner;

public class SumTest {

	
	public static int sol(int a,int b) {
		int sum = 0;
		
		for (int i = Math.min(a, b) ; i <= Math.max(a, b) ; i++) {
			sum +=  i;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 a 입력");
		int a = sca.nextInt();
		System.out.println("정수 b 입력");
		int b = sc.nextInt();
		
		if(a==b) {
			System.out.println("a와 b가 같으므로 기본출력"+a);
		}else if(a<b) {
			System.out.println(sol(a,b));
		}else {
			System.out.println(sol(a,b));
		}
		
		
	}

}
