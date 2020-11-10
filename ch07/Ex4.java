package ch07;

public class Ex4 {

	public static void main(String[] args) {
		//배열 복사
		int arr1[] = {10,20,30,40,50};
		int arr2[] = new int[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=arr1[i];
			System.out.println(arr2[i]);
		}
		
		int arr3[] = new int [arr1.length];
		//                         (복사할 배열,  복사받을  첫위치, 대상 배열,복사 할 첫위치,개수)
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);  //배열복사 메소드 
		for (int s = 0; s < arr3.length; s++) {
			System.out.println(arr3[s]);
		}
		
		String str [] = {"카카오","유투브","인스타","틱톡","트위트"};
		for (String st : str) {
			System.out.println(st);
		}
		
		
		
		
		
		
		
	}

}
