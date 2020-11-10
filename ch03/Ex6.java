package ch03;

public class Ex6 {

	public static void main(String[] args) {
		int a = 10;
		// a´Â Â¦¼ö ¶Ç´Â È¦¼öÀÔ´Ï±î?
		String str = (a % 2 == 0) ? "Â¦¼ö" : "È¦¼ö";
		System.out.println(str);

		int b = 10;
		int c = (a > b) ? a : b;
		System.out.println(c);

		int d = Math.max(a, b);
		System.out.println(d);
	}

}
