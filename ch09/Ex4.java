package ch09;

import java.awt.Component;

abstract class A4{
	
	abstract void prn();
}
//�߻� Ŭ���� ���� ����� �������̵��� �ʿ䰡 ����.
abstract class B4 extends A4{
	abstract void prn1();
}
//��� �߻� Ŭ������ ����Ҷ� ��� �߻�޼ҵ带 �����ؾ� �Ѵ�
class C4 extends B4{
	@Override
	void prn() {
	}
	@Override
	void prn1() {
	}
}//�߻� �޼ҵ尡������ �߻����� ���䶧���� �߻�Ŭ�����̴�. 
class D4 extends Component{}



public class Ex4 {

	public static void main(String[] args) {

	}

}
