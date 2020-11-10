package ch04;

import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		// 입력한 달 숫자 별로 계절을 출력하시오.(12~2 : 겨울)(3~5 : 봄)(6~8:여름)(9~11:가을)
		Scanner sc = new Scanner(System.in);
		System.out.print("달 (month) 입력하세요 .");
		int m = sc.nextInt();
		switch (m) {
		case 12:
		case 1:
		case 2:
			System.out.println("겨울입니다.");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을입니다.");
			break;
		default:
			System.out.println("달이 아닙니다.");
			break;
		}
		
		
		
		
		String m1 = "february";
		switch (m1) {
		case "january":
			System.out.println("1월달");
			break;
		case " february":
			System.out.println("2월달");
			break;
        default:
			break;
		}
		
	}
}
