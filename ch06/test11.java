package ch06;

public class test11 {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < i + 1; j++) {
				System.out.print(j);
			}

			for (int k = i - 1; k >= 0; k--) {
				System.out.print(k);
			}

			System.out.println();
		}

	}
}