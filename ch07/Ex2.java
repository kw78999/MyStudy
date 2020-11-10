package ch07;

public class Ex2 {

	public static void main(String[] args) {
		//arr1[0]은 1을 넣고 다음방은 순차적으로 증가 
		int arr1[] = new int[10];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i+1;
		}
		String str1[]= {"NC","KT","키움","LG","두산"};
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}
	}

}
