package ch05;

import ch05_1.Ex55;

class A10{
	protected int a;
}
public class Ex10 {

	public static void main(String[] args) {
		//protected : ������ ��Ű���� �����public
		//SUN���� �����Ǵ� ��κ��� �ʵ�� �޼ҵ�� public 
		//���࿡ protected �� ����� �ʵ�� �޼ҵ带 ����Ϸ��� ��ӹۿ� ����̾���
		//������ ������ ����� Ŭ������ SUN���� �����Ǵ� Ŭ������ ������ ��Ű�� ���� �Ұ��� 
		//
		A10  a = new A10();
		a.a=22; // ������ ��Ű�� �̹Ƿ� ���ٰ���
		Ex55 e1 = new Ex55();
		e1.a =10;
	//	e1.b = 22; prtected ���� �Ұ���
		
	}

}
