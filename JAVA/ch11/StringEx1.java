package ch11;

public class StringEx1 {

	public static void main(String[] args) {
		String s1 = new String ("JAVA");
		String s2 = new String ("JAVA");
		//String ����� " new ������ ���� ��ü�������ϸ� ��������°���
		//�ߺ��ȹ��ڿ��� �ִٸ� ���Ӱ� �������ʰ� �����ϴ� ����� �ִ�.
		
		String s3 = "JAVA";
		String s4 = "JAVA";
		//������ type���� ==�� ���۷��� �ּҰ� ��
		
		int a = 10;
		int b = 10;
		System.out.println(a==b);
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		
		//equals (Object) �޼ҵ�� ��ü�� ������ ��
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
		System.out.println(s3.equals(s4));
		}

}
