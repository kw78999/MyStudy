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
		String str = customerName+"���� �����"+customerGrade+"�̸� ���ʽ� ����Ʈ��"+bonusPoint+"�Դϴ�.";
		return str;
		}
}
