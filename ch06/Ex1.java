package ch06;

/*�ڱ� �ڽ�(�޸𸮿� ������� ��ü)�� ����Ű�� Ű���� this
 * 1.this() : �ڽ��� ������ �ǹ�  
 * 2.this.�ʵ� : ��ü�� �Ӽ��� ���ϴ� �ʵ带 ����ҋ�
 * �޼ҵ� �ȿ� ���������� ������ �������϶� �ʵ带 ����ϱ����� ����
 * 3. �ڽ��� ��ü�� ��ȯ�Ҷ� (������ ���� ����)
 * */
class A1{
	//�����ڴ� ��ü�� ����� �޼ҵ� 
	//�����ڸ� �����ϴ� ���� : ��ü�� �����ɶ� �ʿ��� �ʱ����� ���� ������ ����.
	public A1() {
		super();//super�� Object
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

