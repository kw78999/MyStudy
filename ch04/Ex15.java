package ch04;

public class Ex15 {
	public static void main(String[] args) {

		//���� 1. 1~10������ ¦���� ����Ͻÿ�
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
