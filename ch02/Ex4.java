package ch02;

public class Ex4 {

	static boolean b1;
	static int i1;

	public static void main(String[] args) {
//자바 기본형 Data Type 8가지
		System.out.println(b1);
		System.out.println(i1);
		boolean b = true; // 기본값 => false
		char c = '가';
		// char c1='가나'; 에러
		// char c2='ab'; 에러
		byte bt = 10;
		// byte bt1 = 128; byte = -128~127
		short s = 200;
		int i = 2000;
		long l = 1234567890;
		// 4가지 정수의 범의 출력
		System.out.println(Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE + "~" + Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE + "~" + Long.MAX_VALUE);
    float f = 3.14f; // 실수형의 기본값은 double 이므로 더 작은 타입으로 선언할때 반드시 f 또는 or F를 붙인다.
    double d = 3.33;
    
	}

}
