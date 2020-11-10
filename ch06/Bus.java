package ch06;

public class Bus {

	public int busNumber;
	public int passengerCount;
	public int money;
	
	Bus(int busNumber){
		this.busNumber = busNumber;
	}
	
	public void take(int money) {
		this.money += money ;
		passengerCount++;
	}
	public void showInfo() {
		System.out.println("¹ö½º : "+ busNumber);
		System.out.println("½Â°´ : "+ passengerCount);
		System.out.println("¼öÀÔ : "+ money);
		System.out.println("----------------------------");
	}
	
}
