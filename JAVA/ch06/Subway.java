package ch06;

public class Subway {

	public String lineNumber;
	public int passengerCount;
	public int money;
	
	Subway(String lineNumber){
		this.lineNumber = lineNumber;
	}
	
	public void take(int money) {
		this.money += money ;
		passengerCount++;
	}
	public void showInfo() {
		System.out.println("����ö : "+ lineNumber);
		System.out.println("�°� : "+ passengerCount);
		System.out.println("���� : "+ money);
		System.out.println("----------------------------");
	}
	
}
