package ch08;

class Animal{
	void move() {
		System.out.println("동물이 움직인다");
	}
}
class Human extends Animal{
	void move() {
		//하위 클래스에서 오버라이딩 된 메소드 호출방식 (super.메소드)
		System.out.println("사람이 움직인다");
	}
}
class Tiger extends Animal{
	void move() {
		System.out.println("호랑이가 움직인다");
	}
}
class Eagle extends Animal{
	void move() {
		System.out.println("독수리가 움직인다");
	}
}
public class Ex4 {

	public static void main(String[] args) {
		//다형성 : 상위 클래스의 레퍼런스 변수가 하위 클래스의 오버라이딩된 메소드를 다양하게 호출 가능한 형태
		
		Animal ani = new Human();
		ani.move();
		Animal ani1 = new Tiger();
		ani1.move();
		Animal ani2 = new Eagle();
		ani2.move();
		
		
		
		
		
	}

}
