package ch06;

import java.awt.Color;

class A3{
	private A3() {}  // private값으로 생성자 생성하면 객체 생성 하지말라는 의미
	static int i;
	static void prn() {
		System.out.println(i);
	}
}
public class Ex3 {

	public static void main(String[] args) {
 /*static 변수및 메소드는 객체를 생성하지 않고도*/
		A3.i=22;
		A3.prn();
		
		int a = -22;
		int b = Math.abs(a); //Math 클래스의 생성자는 private 이고 필드와 메소드는 static이다.
		 /*Frame에 입려한 값들은 모두 문자열 타입이다 
		  * 이러한 숫자모양의 문자열을 계산하기 위하서는 정수로 변환*/
		 String s1 = "22";
		 String s2 = "23";
		 Integer it = new Integer(0);
		 int i=it.parseInt(s1);
	System.out.println(s1+s2);
	//PI는 상수(static fanal)
	System.out.println( Math.PI);
	System.out.println(Color.GREEN);
	
	}
	
	
	

}
