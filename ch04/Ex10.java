package ch04;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		// 문제 1. 1~30사이의 값중에 3의 배수의 합을 구하시오

		int sum = 0;
		for (int i = 1; i < 31; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);

		// 문제 2. 1~30사이의 값중에 짝수와 홀수의 합을 각각 구하시오

		int sum1 = 0;
		int sum2 = 0;

		for (int i = 1; i < 31; i++) {
			if (i % 2 == 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
		}
		System.out.println("짝수의 합 : " + sum1);
		System.out.println("홀수의 합 : " + sum2);

		// 문제 3. 입력한 숫자의 구구단을 출력하시오 .
		// Scanner sc = new Scanner(System.in);
		// System.out.print("출력할 구구단 숫자를 입력하세요");
		// int a = sc.nextInt();

		// for(int i= 1;i<10;i++) {
		// System.out.println(a+" x " +i +" = " +a*i);
		// }
		// 문제 4. 1~50사이의 숫자중에 3,6,9 게임의 숫자의 합은?
		// 3+6+9+13+16+19....+30+31+32+33+....+43+46+49
		int sum3 = 0;
		for (int i = 1; i < 51; i++) {
			int j = i % 10;
			if (j == 3 || j == 6 || j == 9) {
				sum3 += i;
			} else if (i / 10 == 3) {
				sum3 += i;
			}
		}
		System.out.println(sum3);

	}
}
