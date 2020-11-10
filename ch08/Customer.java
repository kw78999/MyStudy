package ch08;

public class Customer {
 
	public int customerID;
	public String customerName;
	public String customerGrade;
	public int bonusPoint;
	public double bonusRatio;
	
	public Customer() {
		customerGrade = "SIVER";
		bonusRatio=0.01;
	}
	public Customer(int customerID,String custoName) {
		this.customerID = customerID;
		this.customerName = custoName;
		customerGrade = "SIVER";
		bonusRatio=0.01;
	}
	public int calcPrice	(int price) {
		bonusPoint +=price*bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		String str = customerName+"님의 등급은"+customerGrade+"이며 보너스 포인트는"+bonusPoint+"입니다.";
		return str;
		}
}
