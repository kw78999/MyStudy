package ch13;

//Outer1.class
/*내부클래스의 존재이유는 외부클래스 안에 아주 특별한 기능을 구현하고자 선언을 
 * 하지만 메소드드 아닌 상속의 기능이 있는 클래스로 선언을 한다. 이런한 내부클래스가
 * 또 다른 외부클래스로 선언하지 않는 이유는 외부클래스 안에서만 사용하기 위한 
 * 목적이다.*/
class Outer1{
	
	int i = 22;
	
	void prn() {
		System.out.println("i : " + i);
		//System.out.println(j+ i);
		/*내부클래스는 외부클래스 내에서만 일반적으로 사용을 하고
		 * 상당히 밀접한 관계의 클래스이다. 외부클래스에서 내부클래스의 
		 * 멤버변수와 메소드를 사용하기 위해서는 반드시 객체 생성이 필요하다.*/
		Inner1 in = new Inner1();
		System.out.println(i+in.j);
	}
	//내부클래스 : Outer1$Inner1.class
	class Inner1{
		int j = 23;
		void prn1() {
			/*외부클래스는 내부클래스를 아주 특별한 메소드로 인식한다.
			 * 그래서 외부클래스의 멤버변수와 메소드는 언제든지 내부클래스에서 사용
			 * 할 수 있다.*/
			System.out.println("i+j : " + (i+j));
		}
	}//-------class
}

class A1{
	int i = 22;//멤버변수
	void prn() {
		int j = 23;//지역변수
		System.out.println(i+j);
	}
	void prn1() {
		//System.out.println(i+j);
	}
}

public class Ex1 {
	public static void main(String[] args) {
		//제3의 클래스에서 내부클래스 사용방법
		//Inner1 in = new Inner1();//로컬(Outer1)에서 사용가능
		Outer1 out = new Outer1();
		Outer1.Inner1 in = out.new Inner1();
		in.prn1();
	}
}






