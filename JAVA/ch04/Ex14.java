package ch04;

public class Ex14 {

	public static void main(String[] args) {
    //배열 Array
		//1. 배열변수의 선언 
		int arr[];
		String str[];
		//2.배열의 크기 지정
		arr = new int [5];
		str = new String[3];
		//3.배열의 선언
		int arr1[] = new int [5];
		//4.  배열방의 크기 - length
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
