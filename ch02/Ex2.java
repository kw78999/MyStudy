package ch02;

public class Ex2 {

	public static void main(String[] args) {
		// 2����,8����,10����,16���� ��ȯ
		int i = 922; // ����Ÿ�� ������ = ������
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toOctalString(i));
		System.out.println(Integer.toHexString(i));
		// 2����, 8����, 16���� ǥ��
		int i1 = 0B1010; // 2 ����(0B)
		int i2 = 012; // 8����(0)
		int i3 = 0XA; // 16���� (0X)
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		// Integer Ŭ�������� ���������� �������� ������ ��ȯ
		String s1 = "22";
		String s2 = "23";
		System.out.println(s1 + s2);
		// Integer�� SUN���� �����Ǵ� ������ ��üȭ�� Ŭ����
		int j1 = Integer.parseInt(s1);// ���ڸ� ������ ��ȯ
		int j2 = Integer.parseInt(s2);// ���ڸ� ������ ��ȯ
		System.out.println(j1 + j2);
	}

}
