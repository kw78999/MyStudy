package ch14;

public class Ex1 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		try {
			System.out.println(a+b);
			System.out.println(a-b);
			System.out.println(a*b);
			System.out.println(a/b);
			System.out.println("End~~");
		} catch (Exception e) {
			System.out.println("0으로 나누면 안되요.");
			System.out.println(e.getMessage());
		}
	}
}
