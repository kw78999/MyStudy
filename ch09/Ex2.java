package ch09;

abstract class A2{
	//�߻� �޼���� ����θ� �ְ� �������� �����ΰ� ����.
	abstract void prn();
}

//A2�� prn �޼ҵ�� �ݵ�� ���������� �������̵� �ؾ��Ѵ� 
class B2 extends A2{
	void prn() {
		
	}
}

class C2 extends A2{
	@Override
	void prn() {
	}
}

public class Ex2 {

	public static void main(String[] args) {

	}

}
