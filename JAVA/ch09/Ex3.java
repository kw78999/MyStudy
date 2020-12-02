package ch09;

//Shape 도형을 추상화 시킨 클래스
abstract class Shape{
	int x,y;//추상클래스는 일반적인 필드 선언가능
	void move(int x,int y) {//추상클래스는 일반적인 메소드 선언가능
		this.x=x;
		this.y=y;
	}
	abstract void draw(); // 오버라이딩 강제하는 추상 메서드 
}

class Triangle extends Shape{
	void draw() {
		System.out.println("삼각형");
	}
}
class Rectangle extends Shape{
void draw() {
		System.out.println("사각형");
	}
}
class  Circle extends Shape{
void draw() {
		System.out.println("원");
	}
}
public class Ex3 {

	public static void main(String[] args) {
		//Shape s = new Shape();  추상 클래스 객체생성 불가
	}

}
