package ch14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner s = null;
		try {
			int a, b;
			s = new Scanner(System.in);
			System.out.println("입력 받은 두수를 나누기");
			System.out.print("첫번째 숫자 : ");
			a = s.nextInt();
			System.out.print("두번째 숫자 : ");
			b = s.nextInt();
			System.out.println(a+" / " + b + " = " + (a/b));
		} catch (ArithmeticException e) {
			System.out.println("계산예외");
		} catch (InputMismatchException e) {
			System.out.println("포맷예외");
		} finally {
			s.close();
		}
	}
}









