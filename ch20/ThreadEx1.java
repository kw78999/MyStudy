package ch20;


class Thread1  extends Thread{
	
	String name;
	
	public Thread1(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(name + " : "+ i);
				Thread.sleep(500);//0.5�ʵ��� �����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
class NoThread1{
	
String name;

public NoThread1(String name) {
	this.name = name;
}

public void run() {
	try {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " : "+ i);
			Thread.sleep(500);//0.5�ʵ��� �����
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void start() {
	run();
}

}


	public class ThreadEx1{
	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1("firsrt");
		Thread1 t2 = new Thread1("Second");
		//t1.start();
		//t2.start(); start �޼ҵ�� ������ �����ٷ����� ��� -> ����� �����ٷ��� �� �޼ҵ� ȣ��
		///////////////////////////////////
		NoThread1 n1 = new NoThread1("ù����");
		NoThread1 n2 = new NoThread1("�ι�°");
		n1.start();
		n2.start();
		
		
	}
}
