package ch20;

public class RunnableEx1 implements Runnable{
	
	String name;
	
	public RunnableEx1(String name) {
	this.name = name;
	
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(name + " : " +i);
			Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		RunnableEx1 r1 = new RunnableEx1("first");
		RunnableEx1 r2 = new RunnableEx1("Second");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
}}
