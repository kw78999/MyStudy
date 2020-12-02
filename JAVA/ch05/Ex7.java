package ch05;

class A6{
	A6(){
		//this 는 자기 자신을 가르키는 키워드
		//this 생성자도 반드시 생성자의 첫번쨰 라인에 위치해야한다 
		//그래서 this()와 super()는 공존할수 없다 . 
		this("msg");//생성자가 생성자를 호출하고있디.
	}
	A6(int a){
		this("msg");
	}
	A6(String s){
		super();
		System.out.println("문자열 생성자");
		System.out.println("문자열 생성자");
		System.out.println("문자열 생성자");
		//생성자가 해야 할 역활의 코드가 들어간 상태
		//생성자가 해야 할 일이 있는데 다양한 case의 생성자가 각각 전부 코드작성을 해야한다
		//위와같은 예로 코드 단축을 시킬수있다
	}
	

}
public class Ex7 {

	public static void main(String[] args) {
		A6 a = new A6();
	}

}
