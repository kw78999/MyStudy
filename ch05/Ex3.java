package ch05;

import java.awt.Frame;

class A2{
	
}
//주석 단축기는 ctrl + shift +?
/* class String{} */
public class Ex3 {

	public static void main(String[] args) {
		//동일한 패키지에 있는 클래스는 따로 import 하지 않아도 사용 가능하다 
		//그러나 다른 패키지에있는 클래스를 사용할땐 import를 반드시 해야한다.
		//단 java.lang 에잇는 클래스들은 예외
A2 a = new A2();
Frame f = new Frame(); 
	}

}
