package ch07;

import java.util.Scanner;

public class SnailArray {
	static int num = 1;

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("n x n 의 정사각형 배열 길이값 입력 : ");
		int a = sca.nextInt();
		int arr[][] = new int[a][a];

		for (int i = 0, j = a - 1; i < a ; i++, j--) {

			for (int k = 0; k < arr[0].length; k++, num++) {
				if (arr[i][k] == 0)
					arr[i][k] = num;
				else {
					num--;
				}
			}

			for (int t = 0; t < a; t++, num++) {
				if (arr[t][j] == 0)
					arr[t][j] = num;
				else {
					num--;
				}
			}

			for (int r = a - 1; r >= 0; r--, num++) {
				if (arr[j][r] == 0)
					arr[j][r] = num;
				else
					num--;
			}

			for (int v = a - 1; v >= 0; v--, num++) {
				if (arr[v][i] == 0)
					arr[v][i] = num;
				else
					num--;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}}
}
