package ch06;

/*static �ʵ� �޼ҵ� Ŭ����(Ư���� ��Ȳ) �տ��� �� �ִ� 
 * Ŭ���� �տ� �� �� �ִ� ���� �����ڴ� public �ۿ� ���� 
 * static �� ������ ������ ������ �޸� ������ : ��ü�� �����Ǳ� ���� �̸� ��������� �޸� ���� 
 * 
 */
class A2{
	/*static ������ non-static ���� �߿� ���� ���� �޸𸮿� ����� ����?
	 * -> static ���� , ��� ��ü ���������ʰ� ��� ������ ������ static �̹Ƿ� 
	 * static ������ Ŭ���� ������ ���ٰ���
	 * ex) A2.a
	 * */
	static int a;
	int b;
	
	static void prn() {
		//non-static ������ static �޼ҵ忡 ��� �Ұ�, non - static ������ �ݵ�� ��ü �����Ͽ��� ����� �� �ִ�.
	//	System.out.println(a+b);
	}
	void prn1() {
		System.out.println(a+b);
	}
}

public class Ex2 {

	public static void main(String[] args) {
		A2.a=22;
		//A2.b=22;
		A2 aa = new A2();
		aa.a=23;
		aa.b=24;
		
	}

}
