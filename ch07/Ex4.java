package ch07;

public class Ex4 {

	public static void main(String[] args) {
		//�迭 ����
		int arr1[] = {10,20,30,40,50};
		int arr2[] = new int[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=arr1[i];
			System.out.println(arr2[i]);
		}
		
		int arr3[] = new int [arr1.length];
		//                         (������ �迭,  �������  ù��ġ, ��� �迭,���� �� ù��ġ,����)
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);  //�迭���� �޼ҵ� 
		for (int s = 0; s < arr3.length; s++) {
			System.out.println(arr3[s]);
		}
		
		String str [] = {"īī��","������","�ν�Ÿ","ƽ��","Ʈ��Ʈ"};
		for (String st : str) {
			System.out.println(st);
		}
		
		
		
		
		
		
		
	}

}
