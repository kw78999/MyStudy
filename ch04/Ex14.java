package ch04;

public class Ex14 {

	public static void main(String[] args) {
    //�迭 Array
		//1. �迭������ ���� 
		int arr[];
		String str[];
		//2.�迭�� ũ�� ����
		arr = new int [5];
		str = new String[3];
		//3.�迭�� ����
		int arr1[] = new int [5];
		//4.  �迭���� ũ�� - length
		System.out.println(arr1.length);
		//arr1[0]=10;
		//arr1[1]=20;
		//arr1[2]=30;
		//arr1[3]=40;
	//	arr1[4]=50;
		for (int i = 0; i < arr1.length; i++) {
			arr[i]=i*10+10;
			System.out.println(arr[i]);
			int [] num1= {1,2,3,4,5};
			for (int j = 0; j < num1.length; j++) {
				System.out.println(num1[j]);
			}
		}
		
	
	}

}
