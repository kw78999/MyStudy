package ch08;

public class VIPCustomer extends Customer{
//�θ� Ŭ������ ������ �޼ҵ�� ��� ���� �ʴ´�.
	public int agentID;
	public double saleRatio;
	//VIP�� �����Ǹſ�,  ����Ʈ ���� ���� 5%,  ����10%
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
