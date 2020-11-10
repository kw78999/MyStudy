package ch09;

abstract class A2{
	//추상 메서드는 선언부만 있고 실질적인 구현부가 없다.
	abstract void prn();
}

//A2의 prn 메소드는 반드시 강제적으로 오버라이딩 해야한다 
class B2 extends A2{
	void prn() {
		
	}
}

class C2 extends A2{
	@Override
	void prn() {
	}
}

public class Ex2 {

	public static void main(String[] args) {

	}

}
