package ch10;

/*클래스와 클래스 간의 강제성을 지닌 역활을 만드는 기능을 만든것  
 * */
interface Calc{
	//인터페이스에서 선언한 메소드는 -> 반드시 추상메소드가 된다
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
