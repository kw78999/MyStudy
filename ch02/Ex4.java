package ch02;

public class Ex4 {

	static boolean b1;
	static int i1;

	public static void main(String[] args) {
//�ڹ� �⺻�� Data Type 8����
		System.out.println(b1);
		System.out.println(i1);
		boolean b = true; // �⺻�� => false
		char c = '��';
		// char c1='����'; ����
		// char c2='ab'; ����
		byte bt = 10;
		// byte bt1 = 128; byte = -128~127
		short s = 200;
		int i = 2000;
		long l = 1234567890;
		// 4���� ������ ���� ���
		System.out.println(Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE + "~" + Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE + "~" + Long.MAX_VALUE);
    float f = 3.14f; // �Ǽ����� �⺻���� double �̹Ƿ� �� ���� Ÿ������ �����Ҷ� �ݵ�� f �Ǵ� or F�� ���δ�.
    double d = 3.33;
    
	}

}
