package ch08;

import java.awt.Frame;

import ch08_1.Ex2_1;
//���������� SUN���� �����Ǵ� Ŭ������ ������ packge�� �ɼ� ����.
//������ SUN���� �����Ǵ� �ʵ�� �޼ҵ��߿� protected�� ����̸� public�� �Ǵ°��̰� 
//����� �ƴϸ� private �� �ȴ�.
class A2 extends Ex2_1{
	public void prn() {
		//System.out.println("x: "+ x);
		System.out.println("y: "+ y);
		System.out.println("z: "+ z);
		//System.out.println("q: "+ q);
		
	}
	
}

class MyFrame extends Frame{
	public void prn() {
		paramString();  //����Ͽ� protected �޼ҵ带 ����Ҽ� �ִ�.
	}
}

public class Ex2{

	public static void main(String[] args) {
		Ex2_1 e = new Ex2_1();
		// e.x = 1;
		// e.y =1;
		e.z = 1;
			
	}

}
