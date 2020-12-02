package ch09;
/*final (마지막) : 클래스 , 필드(매개변수),메소드
 * 1.클래스 sub클래스가 없는 클래스 (상속불가)
 *  2.필드 : 상수 가 된다
 *  3.메소드 : 오버라이딩 불가 메소드 
 *  */

import java.awt.Color;
import java.awt.Frame;

final class A1{}
//class B1 extends A1{}

class B1{
	int a;// 필드는 초기화를 JVM이 합니다. 0,false,null 등 
	//final int B;   상수는 JVM이 관여 하지 못함 
	public void prn(final int n ) {
		//n=23; //final 매개 변수 변경 불가 
		System.out.println(5*5*Math.PI);
		Frame f = new Frame();
		f.setBackground(new Color(255,255,0));
	}
}


class E1{
	void prn1() {}
	final void prn2() {}
}
class E2 extends E1{
	void prn1() {}
	//void prn2() {} 오버라이딩 불가.
}



public class Ex1 {

	public static void main(String[] args) {

	}

}
