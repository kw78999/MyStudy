package ch10;

/*Ŭ������ Ŭ���� ���� �������� ���� ��Ȱ�� ����� ����� �����  
 * */
interface Calc{
	//�������̽����� ������ �޼ҵ�� -> �ݵ�� �߻�޼ҵ尡 �ȴ�
	public void m(int a,int b);
}


class Function implements Calc{
	public void plus(int a,int b) {
		
	}
	@Override
	public void m(int a, int b) {
	}
}

class MyFrame implements Calc{
	public void draw(int w,int h) {
		
	}
	@Override
	public void m(int a, int b) {
	}
}


public class Ex1 {
	public static void main(String[] args) {
		
	}
}
