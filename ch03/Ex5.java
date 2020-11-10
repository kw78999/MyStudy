package ch03;

public class Ex5 {

	public static void main(String[] args) {

		// 영어 숫자 특수문자 : 1byte, 한글 :2 byte
		// A , 가
		//System.out.println(Integer.toBinaryString(a));
		//System.out.println(Integer.toBinaryString(b));

		int a = 5; // 0000 0101
		int b = 10; // 0000 1010
		int c = a&b;   //둘다 1이면 1
		int d = a|b;    //둘중 하나만 1이면 1
		System.out.println(c);
		System.out.println(d);
		int e = a^b;  // ^(XOR) 두 비트가 다른값이면 1 같으면 0
		int f = ~a;   //  ~0은 1로  1은 0으로 바꿈
System.out.println(e);
System.out.println(f);
int num = 1172;
System.out.println(Integer.toBinaryString(num));
	}

}
