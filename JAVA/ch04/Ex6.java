package ch04;

public class Ex6 {

	public static void main(String[] args) {
//1~20������ �����߿� 3,6,9 ���ӿ� ���ϴ� ¦���� ǥ���Ͻÿ�
		for (int a = 1; a <= 20; a++) {
			if (a / 10 == 0 && a % 3 == 0) {
				System.out.println("¦");
			} else if (a / 10 == 0 && a % 3 != 0) {
				System.out.println(a);
			} else if (a / 11 == 1 && a % 3 == 1) {
				System.out.println("¦");
			} else {
				System.out.println(a);
			}
		}
		for(int i =1;i<21;i++) {
			int j=i%10;
			if(j==3||j==6||j==9) {
				System.out.println("¦");
			}else {
				System.out.println(i+" ");
			}
	}}}


