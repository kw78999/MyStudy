package ch08;

import java.awt.Frame;

import ch08_1.Ex2_1;
//현실적으로 SUN에서 제공되는 클래스와 동일한 packge는 될수 없다.
//때문에 SUN에서 제공되는 필드및 메소드중에 protected는 상속이면 public이 되는것이고 
//상속이 아니면 private 이 된다.
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
		paramString();  //상속하여 protected 메소드를 사용할수 있다.
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
