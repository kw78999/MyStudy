package ch13;

interface A2{
	void prn();//�޼��� �����
}

//�͸� Ŭ������ ������� �ʰ� �������̽��� ����
class B2 implements A2{
	@Override
	public void prn() {
	}
}

//�͸�Ŭ������ ����ϰ� �������̽� ����
class C2{
	void prn() {
		/*�͸�Ŭ������ �������̽� �Ǵ� �߻�Ŭ������ ��ü ������ ���ÿ� ������ �ϱ�
		����Ŭ���� �����̴�.*/
		new A2() {
			@Override
			public void prn() {
			}
		};
	}
}

public class Ex2 {
	public static void main(String[] args) {

	}
}


