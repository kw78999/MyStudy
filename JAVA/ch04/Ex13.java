package ch04;

public class Ex13 {

	public static void main(String[] args) {
		// break �ݺ������� �߰��� ����Ǵ� ��� �����

		// ����. 1~100������ ���� ���Ͻÿ�.���� ���� 200������ ������ ���弼��

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
				if (i+j>3) {break;} // break�� �ڽ��� ���δ� �ݺ��� �ϳ��� �������´�. 
	         }
		}
		
		ns:  //ns ������ ���� 
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 2; j++) {
				if (i+j>3) {break ns;}    //��ü �ݺ����� ��������
			}
		}
		
		
		
		
	}

}
