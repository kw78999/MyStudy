package ch07;

public class test1_20 {
	static int num = 60;
	static int i =1;
	
	public static void main(String[] args) {
		// 1~20���� ��� ���� ����� ���������� ���� �������� ���ϱ�
	
		
		while (true) {
			for(i =1;i<8;i++) {
				if(num%i!=0) 
					break;
			}
			
			if(i==5) 
				break;
			
			num++;
		}
		System.out.println(num);

	}
}