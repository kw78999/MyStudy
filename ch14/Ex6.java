package ch14;

class MyException extends Exception{
	public MyException() {
		super("����� ���� ���� ��ü");
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
		//�������� ���� ��ü�� ���� ������
		throw new MyException();
	}
}
