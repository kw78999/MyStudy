package ch03;

class Vip {
	String name;
	String level;
	int money;

	Vip() {}
	
	Vip(String name) {
		this.name = name;
		this.level = "VIP";
		this.money = 0;

		welcom();
	}

	void welcom() {
		System.out.println("ȯ���մϴ�.");
	}

}

class Customer extends Vip {

	Customer() {
		this("ȸ������ ����", "ȸ������ ����", 0);
	}
	Customer(String name) {
		super(name);
	}
	Customer(String name, String level, int money) {
		this.name = name;
		this.level = level;
		this.money = money;
	}

	void info() {
		System.out.println("ȸ�� �̸� : " + name + "    ȸ�� ��� : " + level + "    ���� �ܾ�" + money);
	}
}

public class Demo1 {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.info();
		Customer c2 = new Customer("ö��", "�ű�", 10000);
		c2.info();
		Customer c3 = new Customer("�̰���");
		c3.info();
		

	}
}
