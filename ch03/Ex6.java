package ch03;

public class Ex6 {

	public static void main(String[] args) {
		int a = 10;
		// a�� ¦�� �Ǵ� Ȧ���Դϱ�?
		String str = (a % 2 == 0) ? "¦��" : "Ȧ��";
		System.out.println(str);

		int b = 10;
		int c = (a > b) ? a : b;
		System.out.println(c);

		int d = Math.max(a, b);
		System.out.println(d);
	}

}
