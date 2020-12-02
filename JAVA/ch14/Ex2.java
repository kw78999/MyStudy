package ch14;

public class Ex2 {
	public static void main(String[] args) {
		try {
			String s = null;
			int arr[] = new int[3];
			s= "오늘은 수요일";
			arr[0] = 10;
			arr[1] = 20;
			arr[2] = 30;
			arr[3] = 40;
		} catch (Exception e) {
			System.out.println("배열예외입니다.");
			System.out.println(e.getMessage());
		} finally {
			//예외가 일어나든 안나든 반드시 실행되는 영역
			System.out.println("무조건 실행");
		}
	}
}
