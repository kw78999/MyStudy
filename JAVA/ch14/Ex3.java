package ch14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner s = null;
		try {
			int a, b;
			s = new Scanner(System.in);
			System.out.println("�Է� ���� �μ��� ������");
			System.out.print("ù��° ���� : ");
			a = s.nextInt();
			System.out.print("�ι�° ���� : ");
			b = s.nextInt();
			System.out.println(a+" / " + b + " = " + (a/b));
		} catch (ArithmeticException e) {
			System.out.println("��꿹��");
		} catch (InputMismatchException e) {
			System.out.println("���˿���");
		} finally {
			s.close();
		}
	}
}









