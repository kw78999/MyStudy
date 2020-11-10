package ch14;

class MyException extends Exception{
	public MyException() {
		super("사용자 정의 에외 객체");
	}
}


public class Ex6 {

	public static void main(String[] args) {
		try {
			method();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void method() throws Exception{
		//실질적인 예외 객체를 만들어서 던진다
		throw new MyException();
	}
}
