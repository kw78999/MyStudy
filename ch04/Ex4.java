package ch04;

import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력하세요 .");
		int a = sc.nextInt();
		// 입려한 숫자가 양수,음수,0 인지 판별
		if (a > 0) {
			System.out.println("양수 입니다.");
		} else if (a < 0) {
			System.out.println("음수 입니다.");
		} else {
			System.out.println("0 입니다");
		}
	}
}
