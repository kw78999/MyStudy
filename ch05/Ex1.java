package ch05;

class Man{
	int age;
	String name;
	String merry;
	int cild;
	
	void manInfo() {
		System.out.println("나이는"+age+"살 이름은 "+name+"결혼 유무는 "+merry+"이고 자식이 "+cild+"명 있습니다");
		
	}
}
public class Ex1 {

	public static void main(String[] args) {

		Man m1 = new Man();

		Man m2 = new Man();
		m2 = m1;
		m1.age= 40;
		m1.name= "James";
	   m1.merry ="true";
	   m1.cild=3;
	   m1.manInfo();
	
			m2.manInfo();	
	}

}
