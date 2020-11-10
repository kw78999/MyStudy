package ch05;

//상속: 모든클래스는 super 클래스가 존재
//단 Object는 제외
class A5{
	public A5() {
		super();//super는 부모 Object를 지칭하는 키워드 super() 부모의 생성자
		//super 생성자는 sub 생성자의 반드시 첫번쨰라인에 위치한다 (생략가능)
		System.out.println("A5 클래스 생성자");
	}
}

class B5 extends A5{
	public B5() {
		super();//super는 부모 A5를 지칭
		System.out.println("B5 클래스 생성자");
	}
}
public class Ex6 {

	public static void main(String[] args) {
		B5 s = new B5();
		
	}

}
