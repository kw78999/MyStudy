package ch13;

interface A2{
	void prn();//메서드 선언부
}

//익명 클래스를 사용하지 않고 인터페이스를 구현
class B2 implements A2{
	@Override
	public void prn() {
	}
}

//익명클래스를 사용하고 인터페이스 구현
class C2{
	void prn() {
		/*익명클래스는 인터페이스 또는 추상클래스를 객체 생성과 동시에 선언을 하기
		내부클래스 문법이다.*/
		new A2() {
			@Override
			public void prn() {
			}
		};
	}
}

public class Ex2 {
	public static void main(String[] args) {

	}
}


