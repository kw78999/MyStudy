package ch05;

class A4aa{
	int a;
	//생성자: 객체를 만드는 특별한 메서드
	//1.클래스명과 동일
	//2.리턴타입 선언 자체가 없다
	//3.만약에 클래스안에 생성자가 구현되어있지 않다면 JVM이 자동으로 디폴트 생성자 생성.
	//4.생성자가 하나라도 정의되어있다면 JVM이 디폴트 생성자를 생성하지않음 .
	A4aa(){
		System.out.println("디폴트 생성자 호출");
	}
	A4aa(String s){
		System.out.println("스트링");
	}
	A4aa(int a){
		System.out.println("인트");
	}
	
}
public class Ex4 {

	public static void main(String[] args) {
		//생성자가 많이 존재하는 이유는 다양한 case 가 있기떄문
		A4aa aa = new A4aa();
		A4aa bb = new A4aa("asd");
		A4aa cc = new A4aa(1);
		new String();//String 클래스는 생성자가 15개선언.
	}

}
