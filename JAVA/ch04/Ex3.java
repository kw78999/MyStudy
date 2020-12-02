package ch04;

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        //입력한 숫자가 3의 배수인지 아닌지 출력하시오.
		System.out.println("숫자 입력하세요 .");
		int a = sc.nextInt();
		if(a%3==0) {
			System.out.println(a+"는 3의 배수입니다");
		}else {
			System.out.println(a+"는 3의 배수가 아닙니다.");
		}
	}
}
