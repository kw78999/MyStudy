package ch04;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		// �Է��� �� ���� ���� ������ ����Ͻÿ�.(12~2 : �ܿ�)(3~5 : ��)(6~8:����)(9~11:����)
		Scanner sc = new Scanner(System.in);
		System.out.print("�� (month) �Է��ϼ��� .");
		int a = sc.nextInt();
		if (a == 12 || a == 1 || a == 2) {
			System.out.println("�ܿ� �Դϴ�");
		} else if (a == 3 | a == 4 | a == 5) {
			System.out.println("���Դϴ�.");
		} else if (a == 6 | a == 7 | a == 8) {
			System.out.println("���� �Դϴ�.");
		} else if (a == 9 | a == 10 | a == 11) {
			System.out.println("���� �Դϴ�.");
		} else {
			System.out.println("�� �� �ƴմϴ�.");
		}
	}
}
