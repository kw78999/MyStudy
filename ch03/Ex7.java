package ch03;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		//�ܼ�â�� ���� �Է¹ޱ� ���� Scaner ��ü ����(new)
		Scanner sc = new Scanner(System.in);
		System.out.println("�񱳰� �ʿ��� ���� �ΰ��� �Է��ϼ���.");
		System.out.print("ù��° ���� : ");
		int a = sc.nextInt();
		System.out.print("�ι�° ���� : ");
		int b = sc.nextInt();
		//System.out.println(a+" : "+b);
		int c = (a>b)?a:b;
		System.out.println("�Է��� ���� �߿� ū ���� " +c+"�̴�.");
		
	}

}
