package ch02;

public class Ex7 {

	public static void main(String[] args) {
		// byte > short > int >long
		byte b = 100;
		short s = b; // 묵시적 형 변환
		System.out.println(b + " :" + s);
		short s1 = 128;
		byte b1 = (byte) s1; // 명시적 형변환
		System.out.println(b1 + " : " + s1);

		int i = 10;
		int j = 3;
		double d = 3.0;
		System.out.println(i / j);
		System.out.println(i / d); // i라는 정수는 실수형태로 묵시적 형변환
		// 오칙연산 (+,-,*,/,%)
		System.out.println(i % j);
		// 1에서 20까지 숫자 중에 3의 배수를 출력하시오
		// 오마 Refactor -> Rename 다른 클래스의 변수의 이름까지도 한번에바꿈
		//for (int a = 0; a <= 20; a++) {
			//if (a % 3 == 0) 
				//System.out.println(a);
			
		

		//}

	}

}
