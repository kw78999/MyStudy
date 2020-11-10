package ch10;

interface A2{
	//인터페이스 필드는 자동으로 상수이기에 초기화는 필수
	int A=22;
	//인터페이스 메소드는 자동으로 추상메소드
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
