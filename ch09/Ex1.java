package ch09;
/*final (������) : Ŭ���� , �ʵ�(�Ű�����),�޼ҵ�
 * 1.Ŭ���� subŬ������ ���� Ŭ���� (��ӺҰ�)
 *  2.�ʵ� : ��� �� �ȴ�
 *  3.�޼ҵ� : �������̵� �Ұ� �޼ҵ� 
 *  */

import java.awt.Color;
import java.awt.Frame;

final class A1{}
//class B1 extends A1{}

class B1{
	int a;// �ʵ�� �ʱ�ȭ�� JVM�� �մϴ�. 0,false,null �� 
	//final int B;   ����� JVM�� ���� ���� ���� 
	public void prn(final int n ) {
		//n=23; //final �Ű� ���� ���� �Ұ� 
		System.out.println(5*5*Math.PI);
		Frame f = new Frame();
		f.setBackground(new Color(255,255,0));
	}
}


class E1{
	void prn1() {}
	final void prn2() {}
}
class E2 extends E1{
	void prn1() {}
	//void prn2() {} �������̵� �Ұ�.
}



public class Ex1 {

	public static void main(String[] args) {

	}

}
