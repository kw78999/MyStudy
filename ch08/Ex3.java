package ch08;

public class Ex3 {

	public static void main(String[] args) {
		Customer ct = new Customer();
		VIPCustomer vct = new VIPCustomer();
		
		
		//��ĳ����(Up Casting)
		//Customer �� VIPCustomer �� ����Ų��.
		Customer ct1 =new VIPCustomer(10003,"�豸��",2000);
		
		
		int price = ct1.calcPrice(100000);
		System.out.println(price);
		System.out.println(ct1.showCustomerInfo());
		
	}

}
