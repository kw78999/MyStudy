package ch10;

interface A2{
	//�������̽� �ʵ�� �ڵ����� ����̱⿡ �ʱ�ȭ�� �ʼ�
	int A=22;
	//�������̽� �޼ҵ�� �ڵ����� �߻�޼ҵ�
	void prn();
}
class B2   implements A2,C2{
	public void prn() {};
	@Override
	public void prn1() {
	}
}

interface C2 {
	void prn1();
}
class D2 extends B2 implements A2,C2{
	
	@Override
	public void prn() {
	}
	@Override
	public void prn1() {
		System.out.println(A);
	}
}
public class Ex2 {

	public static void main(String[] args) {
		B2 d1 = new D2();
		d1.prn1();
	}

}
