package ch05;

class Man{
	int age;
	String name;
	String merry;
	int cild;
	
	void manInfo() {
		System.out.println("���̴�"+age+"�� �̸��� "+name+"��ȥ ������ "+merry+"�̰� �ڽ��� "+cild+"�� �ֽ��ϴ�");
		
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
