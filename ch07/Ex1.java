package ch07;

public class Ex1 {

	public static void main(String[] args) {
		int arr1[] = new int [10];
		int[] arr2 = new int[10];
		int arr3[] = new int[] {1,2,3,4,5};
		int arr4[] = {1,2,3,4,5};
		String str1[] = new String [3];  //기본형이 아닌 클래스 타입의 기본형은 null 이다 
		System.out.println(str1[0]);
		Ex1 e = new Ex1();
		Ex1 e1 = null;// null은 객체를 가르키고 있지 않은 상태 
		System.out.println(e);
	}

}
