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
	
	
	//가변인수 메소드
	public static void vplus(int...arr)/*내부적으로 배열*/ {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		plus(22,23);  //매개변수가 두개일때 
		
		int arr[] = {1,2,3,4,5};     //배열을 직접 만들어서 매개변수를 배열로받는 메소드  
		plus(arr);
		
		vplus(1,23,5,7,2,5,35,100);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
