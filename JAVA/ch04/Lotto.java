package ch04;

import java.util.Random;

public class Lotto {

	public static void main(String[] args) {

		// 로또 1~45사이의 중복없는 6개의 번호 리턴

		Random r = new Random();
		int lotto[] = new int[6];

		for (int i = 0; i < lotto.length; i++) { // 6번 반복
			lotto[i] = r.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
		}
		int nul = 0;
		for (int u = 0; u < lotto.length; u++) {
			for (int i = 0, j = 1; i < lotto.length - 1; j++, i++) {
				if (lotto[i] > lotto[j]) {
					nul = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = nul;
				}
			}
		}
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}
	} 
}