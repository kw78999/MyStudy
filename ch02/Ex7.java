package ch02;

public class Ex7 {

	public static void main(String[] args) {
		// byte > short > int >long
		byte b = 100;
		short s = b; // ������ �� ��ȯ
		System.out.println(b + " :" + s);
		short s1 = 128;
		byte b1 = (byte) s1; // ����� ����ȯ
		System.out.println(b1 + " : " + s1);

		int i = 10;
		int j = 3;
		double d = 3.0;
		System.out.println(i / j);
		System.out.println(i / d); // i��� ������ �Ǽ����·� ������ ����ȯ
		// ��Ģ���� (+,-,*,/,%)
		System.out.println(i % j);
		// 1���� 20���� ���� �߿� 3�� ����� ����Ͻÿ�
		// ���� Refactor -> Rename �ٸ� Ŭ������ ������ �̸������� �ѹ����ٲ�
		//for (int a = 0; a <= 20; a++) {
			//if (a % 3 == 0) 
				//System.out.println(a);
			
		

		//}

	}

}
