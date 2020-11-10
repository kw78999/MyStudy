package ch04;

public class Ex15 {
	public static void main(String[] args) {

		//문제 1. 1~10사이의 짝수를 출력하시오
		for (int i = 1; i < 11; i++) {
			if(i%2==0) {
				System.out.print(i+"\t");
			}
		}
		
		for (int i = 1; i <11; i++) {
			if(i%2!=0) {
				continue;
			}
			System.out.print(i+"\t");
		}
		
	}

}
