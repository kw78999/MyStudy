package ch05;

import ch05_1.Ex55;

class A10{
	protected int a;
}
public class Ex10 {

	public static void main(String[] args) {
		//protected : 동일한 패키지와 상속은public
		//SUN에서 제공되는 대부분의 필드와 메소드는 public 
		//만약에 protected 로 선언된 필드와 메소드를 사용하려면 상속밖에 방법이없다
		//이유는 본인이 만드는 클래스와 SUN에서 제공되는 클래스와 동일한 패키지 선언 불가능 
		//
		A10  a = new A10();
		a.a=22; // 동일한 패키지 이므로 접근가능
		Ex55 e1 = new Ex55();
		e1.a =10;
	//	e1.b = 22; prtected 변수 불가능
		
	}

}
