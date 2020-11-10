package ch04;

public class Ex13 {

	public static void main(String[] args) {
		// break 반복문에서 중간에 종료되는 기능 예약어

		// 문제. 1~100사이의 합을 구하시오.만약 합이 200이하의 값으로 만드세요

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			if (sum > 200) {
				sum -= i;
				break;
			}
			sum += i;
		}
		System.out.println(sum);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if (i+j>3) {break;} // break는 자신을 감싸는 반복문 하나를 빠져나온다. 
	         }
		}
		
		ns:  //ns 영역의 시작 
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 2; j++) {
				if (i+j>3) {break ns;}    //전체 반복문을 빠져나옴
			}
		}
		
		
		
		
	}

}
