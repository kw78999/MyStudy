package ch09;

//Shape ������ �߻�ȭ ��Ų Ŭ����
abstract class Shape{
	int x,y;//�߻�Ŭ������ �Ϲ����� �ʵ� ���𰡴�
	void move(int x,int y) {//�߻�Ŭ������ �Ϲ����� �޼ҵ� ���𰡴�
		this.x=x;
		this.y=y;
	}
	abstract void draw(); // �������̵� �����ϴ� �߻� �޼��� 
}

class Triangle extends Shape{
	void draw() {
		System.out.println("�ﰢ��");
	}
}
class Rectangle extends Shape{
void draw() {
		System.out.println("�簢��");
	}
}
class  Circle extends Shape{
void draw() {
		System.out.println("��");
	}
}
public class Ex3 {

	public static void main(String[] args) {
		//Shape s = new Shape();  �߻� Ŭ���� ��ü���� �Ұ�
	}

}
