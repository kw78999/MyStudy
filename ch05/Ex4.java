package ch05;

class A4aa{
	int a;
	//������: ��ü�� ����� Ư���� �޼���
	//1.Ŭ������� ����
	//2.����Ÿ�� ���� ��ü�� ����
	//3.���࿡ Ŭ�����ȿ� �����ڰ� �����Ǿ����� �ʴٸ� JVM�� �ڵ����� ����Ʈ ������ ����.
	//4.�����ڰ� �ϳ��� ���ǵǾ��ִٸ� JVM�� ����Ʈ �����ڸ� ������������ .
	A4aa(){
		System.out.println("����Ʈ ������ ȣ��");
	}
	A4aa(String s){
		System.out.println("��Ʈ��");
	}
	A4aa(int a){
		System.out.println("��Ʈ");
	}
	
}
public class Ex4 {

	public static void main(String[] args) {
		//�����ڰ� ���� �����ϴ� ������ �پ��� case �� �ֱ⋚��
		A4aa aa = new A4aa();
		A4aa bb = new A4aa("asd");
		A4aa cc = new A4aa(1);
		new String();//String Ŭ������ �����ڰ� 15������.
	}

}
