package ch11;

public class WrapperEx4 {

	
	public static void plus (int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum : " +sum);
	}
	

	public static void plus (int a,int b) {
		int sum = a+ b;
		System.out.println("sum : " +sum);
	}
	
	
	//�����μ� �޼ҵ�
	public static void vplus(int...arr)/*���������� �迭*/ {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		plus(22,23);  //�Ű������� �ΰ��϶� 
		
		int arr[] = {1,2,3,4,5};     //�迭�� ���� ���� �Ű������� �迭�ι޴� �޼ҵ�  
		plus(arr);
		
		vplus(1,23,5,7,2,5,35,100);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
