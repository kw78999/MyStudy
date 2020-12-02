package ch04;

public class Ex12 {

	public static void main(String[] args) {
//while 문을 잉요해서 1~10 까지 합을 구하시오/

		int sum = 0;
		int i = 1;
		while (i < 11) {
			sum += i;
			i++;

		}
		System.out.println(sum);

		
		//break; 자기를 감싸고 있는 반복문을 빠져 나옴.
		int j = 0;
		while (true) {       //무한반복을 쓸때 while 문을 사용한다
			if (j == 32) {
				break;
			}
			j++;
			System.out.println(j);
		}
		
		int k = 0;
		do {
			if(k==5) {break;}
			k++;
		}while (true);
			

	}

}
