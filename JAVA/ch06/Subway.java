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
		System.out.println("ÁöÇÏÃ¶ : "+ lineNumber);
		System.out.println("½Â°´ : "+ passengerCount);
		System.out.println("¼öÀÔ : "+ money);
		System.out.println("----------------------------");
	}
	
}
