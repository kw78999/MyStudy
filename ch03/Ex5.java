package ch03;

public class Ex5 {

	public static void main(String[] args) {

		// ���� ���� Ư������ : 1byte, �ѱ� :2 byte
		// A , ��
		//System.out.println(Integer.toBinaryString(a));
		//System.out.println(Integer.toBinaryString(b));

		int a = 5; // 0000 0101
		int b = 10; // 0000 1010
		int c = a&b;   //�Ѵ� 1�̸� 1
		int d = a|b;    //���� �ϳ��� 1�̸� 1
		System.out.println(c);
		System.out.println(d);
		int e = a^b;  // ^(XOR) �� ��Ʈ�� �ٸ����̸� 1 ������ 0
		int f = ~a;   //  ~0�� 1��  1�� 0���� �ٲ�
System.out.println(e);
System.out.println(f);
int num = 1172;
System.out.println(Integer.toBinaryString(num));
	}

}
