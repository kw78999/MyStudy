package ch11;

public class StringEx1 {

	public static void main(String[] args) {
		String s1 = new String ("JAVA");
		String s2 = new String ("JAVA");
		//String 저장소 " new 연산자 없이 객체를생성하면 만들어지는공간
		//중복된문자열이 있다면 새롭게 만들지않고 재사용하는 기능이 있다.
		
		String s3 = "JAVA";
		String s4 = "JAVA";
		//참조형 type에서 ==은 레퍼런스 주소값 비교
		
		int a = 10;
		int b = 10;
		System.out.println(a==b);
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		
		//equals (Object) 메소드는 객체의 내용을 비교
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
		System.out.println(s3.equals(s4));
		}

}
