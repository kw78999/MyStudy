package ch04;

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        //�Է��� ���ڰ� 3�� ������� �ƴ��� ����Ͻÿ�.
		System.out.println("���� �Է��ϼ��� .");
		int a = sc.nextInt();
		if(a%3==0) {
			System.out.println(a+"�� 3�� ����Դϴ�");
		}else {
			System.out.println(a+"�� 3�� ����� �ƴմϴ�.");
		}
	}
}
