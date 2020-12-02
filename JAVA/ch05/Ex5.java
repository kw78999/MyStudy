package ch05;

class A4a{
	//JVM은 생성자가 하나도 없을떄 디폴트 생성자를 제공 한다
	//매개변수 int를 받는 생성자 존재하기 때문에 디폴트 생성자는 따로 정의내린다
	A4a(){}
	A4a(int a){}
}
public class Ex5 {

	public static void main(String[] args) {
		A4a a = new A4a();
	}

}
