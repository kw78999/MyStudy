package ch04;

public class Ex12 {

	public static void main(String[] args) {
//while ���� �׿��ؼ� 1~10 ���� ���� ���Ͻÿ�/

		int sum = 0;
		int i = 1;
		while (i < 11) {
			sum += i;
			i++;

		}
		System.out.println(sum);

		
		//break; �ڱ⸦ ���ΰ� �ִ� �ݺ����� ���� ����.
		int j = 0;
		while (true) {       //���ѹݺ��� ���� while ���� ����Ѵ�
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
