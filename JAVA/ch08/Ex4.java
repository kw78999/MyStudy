package ch08;

class Animal{
	void move() {
		System.out.println("������ �����δ�");
	}
}
class Human extends Animal{
	void move() {
		//���� Ŭ�������� �������̵� �� �޼ҵ� ȣ���� (super.�޼ҵ�)
		System.out.println("����� �����δ�");
	}
}
class Tiger extends Animal{
	void move() {
		System.out.println("ȣ���̰� �����δ�");
	}
}
class Eagle extends Animal{
	void move() {
		System.out.println("�������� �����δ�");
	}
}
public class Ex4 {

	public static void main(String[] args) {
		//������ : ���� Ŭ������ ���۷��� ������ ���� Ŭ������ �������̵��� �޼ҵ带 �پ��ϰ� ȣ�� ������ ����
		
		Animal ani = new Human();
		ani.move();
		Animal ani1 = new Tiger();
		ani1.move();
		Animal ani2 = new Eagle();
		ani2.move();
		
		
		
		
		
	}

}
