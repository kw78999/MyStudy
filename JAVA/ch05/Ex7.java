package ch05;

class A6{
	A6(){
		//this �� �ڱ� �ڽ��� ����Ű�� Ű����
		//this �����ڵ� �ݵ�� �������� ù���� ���ο� ��ġ�ؾ��Ѵ� 
		//�׷��� this()�� super()�� �����Ҽ� ���� . 
		this("msg");//�����ڰ� �����ڸ� ȣ���ϰ��ֵ�.
	}
	A6(int a){
		this("msg");
	}
	A6(String s){
		super();
		System.out.println("���ڿ� ������");
		System.out.println("���ڿ� ������");
		System.out.println("���ڿ� ������");
		//�����ڰ� �ؾ� �� ��Ȱ�� �ڵ尡 �� ����
		//�����ڰ� �ؾ� �� ���� �ִµ� �پ��� case�� �����ڰ� ���� ���� �ڵ��ۼ��� �ؾ��Ѵ�
		//���Ͱ��� ���� �ڵ� ������ ��ų���ִ�
	}
	

}
public class Ex7 {

	public static void main(String[] args) {
		A6 a = new A6();
	}

}
