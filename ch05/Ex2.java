package ch05;

public class Ex2 {

	/*메서드(객체가 반복적인 기능을 함수로 만든것) 4가지 타입
	 * 1.리턴타입 없고 매개변수 없음
	 * 2.리턴타입 있고(only one) 매개변수 없음
	 * 3.리턴타입 없고 매개변수 있음
	 * 4.리턴타입 있고 매개변수 있음 
	 */
	
	void a1() {
		
	}
	int a2() {
	int a = 22;
	return a;
	}
	String a3() {
		String s = "오늘은화요일";  //유일하게 new 연산자 없이 객체 생성 가능
        return s;		
	}
	void a4(int a,String s,boolean flag ) {
		
	}
	String a5(String s1,String s2) {
		String s = s1 +s2;
         return s;	
 	}
	
	
	//메서드 : 오버로딩(Overloading)
	int plus(int a,int b) {
		return a+b;
	}
	double plus(double a,double b) {
		return a+b;
	}
	
	
	public static void main(String[] args) {

		
		
		
		System.out.println();
		
		
		
	}

}
