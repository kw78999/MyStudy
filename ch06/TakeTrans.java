package ch06;

public class TakeTrans {

	public static void main(String[] args) {
		//�л��θ��� �����ϰ� ���� ������ ����ö�� ž�½�Ų��
		
		Student student1001 = new Student("ȫ�浿",100000);
		Student student1002 = new Student("��ȣ��",7000);
		
		//ȫ�浿�� ����ö ž��
		Subway subway02 = new Subway("2ȣ��");
		student1001.takeSubway(subway02);
		student1001.showInfo();
		subway02.showInfo();
		
		Bus bus169 = new Bus(169);
		student1002.takeBus(bus169);
		student1002.showInfo();
		bus169.showInfo();
	}

}
