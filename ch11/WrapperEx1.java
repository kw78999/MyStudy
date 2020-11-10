package ch11;

public class WrapperEx1 {

	public static void main(String[] args) {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer("22");
		int num1 = Integer.valueOf(10);
		int num2 = Integer.valueOf("20");
		int sum = num1+num2;
		System.out.println(sum);
		//10���� 30�� 2����, 8���� ,16������ ���
		System.out.println("sum�� 2���� : "+Integer.toBinaryString(sum));
		System.out.println("sum�� 8���� : "+Integer.toOctalString(sum));
		System.out.println("sum�� 16���� : "+Integer.toHexString(sum));
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Integer.toHexString(i));
			
			
		}
		//int ���� ������ ���Ͻÿ�
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(UtilMgr.intFormat(Integer.MAX_VALUE));
		System.out.println(UtilMgr.intFormat(Integer.MIN_VALUE));
	}
}
