package ch06;

/*static 필드 메소드 클래스(특수한 상황) 앞에올 수 있다 
 * 클래스 앞에 올 수 있는 접근 제어자는 public 밖에 없다 
 * static 은 정적인 개념을 가진다 메모리 영역은 : 객체가 생성되기 전에 미리 만들어지는 메모리 영역 
 * 
 */
class A2{
	/*static 변수롸 non-static 변수 중에 누가 먼저 메모리에 만들어 질까?
	 * -> static 변수 , 대신 객체 생성하지않고도 사용 가능한 변수가 static 이므로 
	 * static 변수는 클래스 명으로 접근가능
	 * ex) A2.a
	 * */
	static int a;
	int b;
	
	static void prn() {
		//non-static 변수는 static 메소드에 사용 불가, non - static 변수는 반드시 객체 생성하여야 사용할 수 있다.
	//	System.out.println(a+b);
	}
	void prn1() {
		System.out.println(a+b);
	}
}

public class Ex2 {

	public static void main(String[] args) {
		A2.a=22;
		//A2.b=22;
		A2 aa = new A2();
		aa.a=23;
		aa.b=24;
		
	}

}
