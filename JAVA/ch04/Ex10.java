package ch04;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		// ���� 1. 1~30������ ���߿� 3�� ����� ���� ���Ͻÿ�

		int sum = 0;
		for (int i = 1; i < 31; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);

		// ���� 2. 1~30������ ���߿� ¦���� Ȧ���� ���� ���� ���Ͻÿ�

		int sum1 = 0;
		int sum2 = 0;

		for (int i = 1; i < 31; i++) {
			if (i % 2 == 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
		}
		System.out.println("¦���� �� : " + sum1);
		System.out.println("Ȧ���� �� : " + sum2);

		// ���� 3. �Է��� ������ �������� ����Ͻÿ� .
		// Scanner sc = new Scanner(System.in);
		// System.out.print("����� ������ ���ڸ� �Է��ϼ���");
		// int a = sc.nextInt();

		// for(int i= 1;i<10;i++) {
		// System.out.println(a+" x " +i +" = " +a*i);
		// }
		// ���� 4. 1~50������ �����߿� 3,6,9 ������ ������ ����?
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
