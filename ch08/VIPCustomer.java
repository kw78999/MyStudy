package ch08;

public class VIPCustomer extends Customer{
//부모 클래스의 생성자 메소드는 상속 되지 않는다.
	public int agentID;
	public double saleRatio;
	//VIP는 전담판매원,  포인트 적립 비율 5%,  세일10%
	public VIPCustomer() {
		
		customerGrade="VIP";
		bonusRatio=0.05;
		saleRatio=0.1;
	}
	public VIPCustomer(int customerID,String custoName,int agentID) {
		
		super(customerID,custoName);
		customerGrade="VIP";
		bonusRatio=0.05;
		saleRatio=0.1;
		this.agentID=agentID;
	}
	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return (int) (price-price*saleRatio);
	}
}
