package ch05;

//���: ���Ŭ������ super Ŭ������ ����
//�� Object�� ����
class A5{
	public A5() {
		super();//super�� �θ� Object�� ��Ī�ϴ� Ű���� super() �θ��� ������
		//super �����ڴ� sub �������� �ݵ�� ù�������ο� ��ġ�Ѵ� (��������)
		System.out.println("A5 Ŭ���� ������");
	}
}

class B5 extends A5{
	public B5() {
		super();//super�� �θ� A5�� ��Ī
		System.out.println("B5 Ŭ���� ������");
	}
}
public class Ex6 {

	public static void main(String[] args) {
		B5 s = new B5();
		
	}

}
