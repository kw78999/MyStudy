package ch04;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		// 입력한 달 숫자 별로 계절을 출력하시오.(12~2 : 겨울)(3~5 : 봄)(6~8:여름)(9~11:가을)
		Scanner sc = new Scanner(System.in);
		System.out.print("달 (month) 입력하세요 .");
		int a = sc.nextInt();
		if (a == 12 || a == 1 || a == 2) {
			System.out.println("겨울 입니다");
		} else if (a == 3 | a == 4 | a == 5) {
			System.out.println("봄입니다.");
		} else if (a == 6 | a == 7 | a == 8) {
			System.out.println("여름 입니다.");
		} else if (a == 9 | a == 10 | a == 11) {
			System.out.println("가을 입니다.");
		} else {
			System.out.println("달 이 아닙니다.");
		}
	}
}
