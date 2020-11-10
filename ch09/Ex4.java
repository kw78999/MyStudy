package ch09;

import java.awt.Component;

abstract class A4{
	
	abstract void prn();
}
//추상 클래스 간의 상속은 오버라이딩할 필요가 없다.
abstract class B4 extends A4{
	abstract void prn1();
}
//상속 추상 클래스를 상속할땐 모든 추상메소드를 구현해야 한다
class C4 extends B4{
	@Override
	void prn() {
	}
	@Override
	void prn1() {
	}
}//추상 메소드가없지만 추상적인 개념때문에 추상클래스이다. 
class D4 extends Component{}



public class Ex4 {

	public static void main(String[] args) {

	}

}
