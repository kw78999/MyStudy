package ch11;

public class StringEx2 {

	public static void main(String[] args) {
		//String 은 문자열을 가공하기 위한 기능을 객체화시킨 클래스이다
		String s1 = "Java Programming";
		//SUN에서 제공하는 메소드 중에 to~로 시작하면 ~~로 변환
		String s2 = s1.toUpperCase();
		String s3 = s1.toLowerCase();
		System.out.println(s2+"  "+s3);
		
		int len = s1.length();
		System.out.println(len);
		char c1 = s1.charAt(0);
		System.out.println(c1);
		
		
		for (int i = 0; i < s1.length(); i++) {
			System.out.println(s1.charAt(i));
		}
		
		//charAt 을 이용하여 s1에 사용된 a문자의 횟수는?
		int sum=0;
		for (int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i)=='a') {
				sum++;
			}
		}System.out.println(sum);
		
		String s4 = "무궁화 꽃이 피었습니다.";
	
		
		//charAt을 이용하여 s4의 공백문자에 '_'로 출력하시오.
		//ex)String s3 = "무궁화_꽃이_피었습니다.";
		for (int i = 0; i <s4.length(); i++) {
			char cha = s4.charAt(i);
			if(cha ==' ') {
				 cha =  '_' ;
			}
			System.out.print(cha);
		}
		System.out.println();
		
		
		//s1에 g는 앞에서 몇번쨰 자리일까?
		System.out.println(s1.indexOf('g'));
		
		//s1에 g는 뒤에서 몇번쨰 자리일까?
		System.out.println(s1.lastIndexOf('g'));
		
		
		
		
	
		
		
	}

}
