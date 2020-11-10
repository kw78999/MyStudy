package ch05;
//CarEx2.java -> CarEx2.class,Car2.class 
/*클래스 및 필드, 메소드 네이밍 규칙
*1. 클래스는 반드시 대문자로 시작 ,합쳐진 단어에 첫번째 철자도 대문자
*ex)CarName.java ,BoardMgr.java
*2.필드 메소드는 반드시 소문자로 시작. 합쳐진 다어의 첫번째 철자는 대문자
*ex) speedUp(),carName
*/
class Car2{
	
	String carName;
	int velocity;
	String carColor;
	
	void speedUp() {
		velocity++;
	}
	void speedDown() {
		velocity--;
		if(velocity<0)
			velocity=0;
	}
	void stop() {
		velocity = 0;
		
	}
	

}
public class CarEx2 {

	public static void main(String[] args) {
   Car2 c1 = new Car2();
   Car2 c2 = new Car2();
    c1.carName = "소나타";
    c2.carName = "그랜져";
    //call by value , call by reference 
    //자바 Data type : 기본형과 참조형(클래스타입)
    c1.velocity = 10;
    c2.velocity = 20;
    
    System.out.println(c1.velocity);
    System.out.println(c2.velocity);
    c1=c2;
    System.out.println(c1.velocity);
    System.out.println(c2.velocity);
    
    
    
    
    
    
    
    
		
		
		
	}

}
