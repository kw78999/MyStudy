package ch08;

import java.awt.Dialog;
import java.awt.Frame;
import java.util.Vector;

class Person{
	String name;
	public Person(String name) {
		this.name = name;
		
	}
}
class Student extends Person{
		String grade;
		public Student(String name) {
			super(name);
		}
	
}

//Ex5.java : 동일한 자바파일에 저장하는 클래스는 .java 파일로 선언된 클래스만 public 가능
public class Ex5 {

	public static void main(String[] args) {
		Frame f = new Frame();
		Dialog d = new Dialog(f);
		
		Person p;
		Student s = new Student("홍길동");
		
		p=s;  //업 캐스팅
		
		
		Vector v = new Vector();//객체를 저장하는 주머니 역활의 클래스
		String str = new String("하하");
		v.add(str);
		String str1 = (String)v.get(0);
		
		
		
		
		
		
		
		
		
		
		
		Student s1;
		Person p1 = new Person("강호동");
		s1 = (Student)p1;  //다운 캐스팅 
		//컴파일 에러가 나지 않지만 실행 시점에 캐스팅 예외가 발생
		s1.grade = "A";
		System.out.println(s1.grade);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
