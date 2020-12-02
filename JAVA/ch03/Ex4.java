package ch03;

public class Ex4 {

	public static void main(String[] args) {
           int a = 10;
           a +=2;
           System.out.println(a);
           int b = 5;
           b+=a;
           System.out.println(b);
           System.out.println("----------------------------");
           int result = 0;
           //1에서 20까지 짝수의 합으 구하시오.
           for (int  i= 1;  i< 21; i++) {   //단락 또는 Block        	   
			if(i%2==0) {
				result +=i;
			}
		}
           System.out.println(result);
	}

}
