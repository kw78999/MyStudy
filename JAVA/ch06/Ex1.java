package ch06;

/*자기 자신(메모리에 만들어진 객체)을 가르키는 키워드 this
 * 1.this() : 자신의 생성을 의미  
 * 2.this.필드 : 객체의 속성을 뜻하는 필드를 사용할떄
 * 메소드 안에 지역변수와 동일한 변수명일때 필드를 사용하기위한 목적
 * 3. 자신의 객체를 반환할때 (지금은 절대 안함)
 * */
class A1{
	//생성자는 객체를 만드는 메소드 
	//생성자를 선언하는 이유 : 객체가 생성될때 필요한 초기적인 값을 구현할 목적.
	public A1() {
		super();//super는 Object
	}
	public A1(int i) {
		this();
	}
}

class B1{
	
	int age=1;
	int num;
	
	public void setAge(int age1) {
		int num = age *10;
		System.out.println(age);
		System.out.println(age1);
	}
}
public class Ex1 {
	
	public static void main(String[] args) {
		B1 b = new B1();
		b.setAge(33);
		
		
	}
}

