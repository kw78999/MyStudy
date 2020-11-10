package ch06;

public class Student {

	public String studentName; //학생이름
	public int grade;
	public int money;
	
	
	public Student(String name,int money) {
		this.studentName = name;
		this.money=money;
	}
	public void takeBus(Bus bu) {
		bu.take(1000);
		this.money -=1000;
	}

	public void takeSubway(Subway subway) {
		subway.take(1500);
		this.money -=1500;
	}
	public void showInfo() {
		System.out.println(studentName+"의 남은 돈은 "+money+"원 입니다");
	}
	
	public static void main(String[] args) {

	}

}
