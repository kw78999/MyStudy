package ch05;
//1 . Ŭ���� ���� : �ʵ�� �޼ҵ� ����
//�ʵ�: ��ü�� �Ӽ� (���)
//�޼ҵ�:��ü�� �ݺ����� ���(����)
class Car1{
	//�ʵ��� ����: �ݵ�� Ŭ���� �ȿ� ����� ������ ���Ѵ�.
	String carName;
	int velocity;
	String carColor;
	
	//�޼ҵ� ����  : ����Ÿ�� ���� �޼ҵ�� (){}
	void speedUp() {
		velocity++;
	}
	void speedDown() {
		velocity--;
		if(velocity<0) {
			velocity=0;
		}
	}
	
	void stop() {
		velocity=0;
	}
	
	
}








public class CarEx1 {

	public static void main(String[] args) {

	//��ü�� : �� ������� Ŭ������ ������ ������ ����� 
		Car1 c1;  //Car1 Ÿ���� ���� ����
		c1 = new Car1(); //newŰ���尡 ��ü�� �����Ѵ� 
		//���۷��� ���� : c1 
		//������ ��ü�� �ʵ�� �޼ҵ� ����� : ���۷��� ����. �ʵ� or �޼ҵ�
		c1.carName = "BMW 5�ø���";
		c1.carColor = "���";
		c1.speedUp();
		System.out.println(c1.velocity);
		System.out.println(c1.carColor);
		System.out.println(c1.carName);
		//String Ŭ���� ���ؼ� ��ü�� ����
		String s = new String("abcd123ASg");
		//s�� ���ڸ� �빮�ڷ� ��� 
		System.out.println(s.toUpperCase()); 
		//�� ������ ���� ���
		System.out.println(s.length());
		
		
		
		
		
		
		
		
		
		
		
	}

}
