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
		System.out.println("환영합니다.");
	}

}

class Customer extends Vip {

	Customer() {
		this("회원정보 없음", "회원정보 없음", 0);
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
		System.out.println("회원 이름 : " + name + "    회원 등급 : " + level + "    보유 잔액" + money);
	}
}

public class Demo1 {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.info();
		Customer c2 = new Customer("철수", "신규", 10000);
		c2.info();
		Customer c3 = new Customer("이건희");
		c3.info();
		

	}
}
