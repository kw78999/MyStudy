package ch06;

class A4{
	static int k;
	int p;
}
public class Ex4 {
	public static void main(String[] args) {
		
	//static ������ �޸𸮿� ���ѹ� �����Ǳ� ������.
		//non static ������ ��ü���� ���� �����ȴ�
		A4 a = new A4();
		A4 b = new A4();

		a.k=100;
		a.p=100;
		System.out.println(a.k+a.p);
		
		b.k=200;
		b.p=200;
		System.out.println(b.k+b.p);

		System.out.println(a.k+a.p);
	}

}
