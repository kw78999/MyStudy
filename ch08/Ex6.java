package ch08;

class A6{}
class B6 extends A6{}
class C6{}
public class Ex6 {

	public static void main(String[] args) {
		B6 b = new B6();
		if( b instanceof A6) {
			System.out.println("b��ü�� A6Ÿ�� �Դϴ�");
		}
		if(b instanceof Object) {
			System.out.println("b��ü�� Object Ÿ�� �Դϴ�");
		}
		A6 a = new A6();// ����
		if(a instanceof B6) {
			System.out.println("a��ü�� B6Ÿ�� �Դϴ�");
		}
	}

}
