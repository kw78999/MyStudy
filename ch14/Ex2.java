package ch14;

public class Ex2 {
	public static void main(String[] args) {
		try {
			String s = null;
			int arr[] = new int[3];
			s= "������ ������";
			arr[0] = 10;
			arr[1] = 20;
			arr[2] = 30;
			arr[3] = 40;
		} catch (Exception e) {
			System.out.println("�迭�����Դϴ�.");
			System.out.println(e.getMessage());
		} finally {
			//���ܰ� �Ͼ�� �ȳ��� �ݵ�� ����Ǵ� ����
			System.out.println("������ ����");
		}
	}
}
