package ch08;

public class Ex1 {

	public static void main(String[] args) {
		Customer lee = new Customer(1000,"�̼���");
		lee.bonusPoint = 1000;
		lee.calcPrice(100000);
		System.out.println(lee.showCustomerInfo());
		lee.calcPrice(50000);
		System.out.println(lee.showCustomerInfo());
	
	
		VIPCustomer jung = new VIPCustomer(10001,"������",2001);
		jung.bonusPoint=10000;
		int price = jung.calcPrice(2000000);
		System.out.println("���������� ������ �ݾ� : "+price);
		System.out.println(jung.showCustomerInfo());
	
	
	}

}
