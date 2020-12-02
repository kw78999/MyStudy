package ch04;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//입력한 숫자가 짝수인지 홀수인지 출력하시오

		System.out.println("숫자 입력하세요.");
		int a = sc.nextInt(); // 입력한 숫자 a에 대입
		if (a % 2 == 0) {
			System.out.println(a + "는 짝수 입니다.");
		} else {
			System.out.println(a + "는 홀수 입니다.");
		}
	}
}
