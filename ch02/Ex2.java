package ch02;

public class Ex2 {

	public static void main(String[] args) {
		// 2진수,8진수,10진수,16진수 변환
		int i = 922; // 변수타입 변수명 = 변수값
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toOctalString(i));
		System.out.println(Integer.toHexString(i));
		// 2진수, 8진수, 16진수 표기
		int i1 = 0B1010; // 2 진수(0B)
		int i2 = 012; // 8진수(0)
		int i3 = 0XA; // 16진수 (0X)
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		// Integer 클래스에서 문자형태의 정수값을 정수로 변환
		String s1 = "22";
		String s2 = "23";
		System.out.println(s1 + s2);
		// Integer은 SUN에서 저공되는 정수를 객체화한 클래스
		int j1 = Integer.parseInt(s1);// 문자를 정수로 변환
		int j2 = Integer.parseInt(s2);// 문자를 정수로 변환
		System.out.println(j1 + j2);
	}

}
