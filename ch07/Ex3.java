package ch07;

public class Ex3 {

	public static void main(String[] args) {
		//������ �迭
		//������ �迭�� �迭�ȿ� �迭�� �ִ°� �̴�.
		int arr1[][] = new int[3][2];//1���� �迭 [3] �ȿ� 2���� �迭 [2]�� ���� ������
		int arr2[][] = {{1,2},{3,4,5},{6}};
		
		
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr1[i].length; j++) {
			System.out.println("arr1["+i+"]["+j+"] : ");
		}	
		}
			//arr 2�� ��Ұ��� �������Ͻÿ� 
			int result = 0;
			for (int i = 0; i < arr2.length; i++) {
				for (int j = 0; j < arr2[i].length; j++) {
					result += arr2[i][j];
				}
			}
			System.out.println(result);
			
			int arr3[][][] = {
					{ {1,2},{3,4},{5,6} }  ,
					{ {7,8},{9,10},{11,15,2,3,} } 
					,   { {12},{13,14},{15,16} }
					};
			int sum=0;
			for (int i = 0; i < arr3.length; i++) {
				for (int j = 0; j < arr3[i].length; j++) {
					for (int k = 0; k < arr3[i][j].length; k++) {
						sum+=arr3[i][j][k];
					}
				}
			}
			System.out.println(sum);
			
			
		
		
	}

}       