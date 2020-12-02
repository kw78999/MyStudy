package ch08;

public class Ex3 {

	public static void main(String[] args) {
		Customer ct = new Customer();
		VIPCustomer vct = new VIPCustomer();
		
		
		//업캐스팅(Up Casting)
		//Customer 가 VIPCustomer 을 가르킨다.
		Customer ct1 =new VIPCustomer(10003,"김구라",2000);
		
		
		int price = ct1.calcPrice(100000);
		System.out.println(price);
		System.out.println(ct1.showCustomerInfo());
		
	}

}
