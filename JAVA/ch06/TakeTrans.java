package ch06;

public class TakeTrans {

	public static void main(String[] args) {
		//학생두명을 생성하고 각각 버스와 지하철을 탑승시킨다
		
		Student student1001 = new Student("홍길동",100000);
		Student student1002 = new Student("강호동",7000);
		
		//홍길동은 지하철 탑승
		Subway subway02 = new Subway("2호선");
		student1001.takeSubway(subway02);
		student1001.showInfo();
		subway02.showInfo();
		
		Bus bus169 = new Bus(169);
		student1002.takeBus(bus169);
		student1002.showInfo();
		bus169.showInfo();
	}

}
