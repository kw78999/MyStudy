package ch06;

import java.awt.Color;

class A3{
	private A3() {}  // private������ ������ �����ϸ� ��ü ���� ��������� �ǹ�
	static int i;
	static void prn() {
		System.out.println(i);
	}
}
public class Ex3 {

	public static void main(String[] args) {
 /*static ������ �޼ҵ�� ��ü�� �������� �ʰ�*/
		A3.i=22;
		A3.prn();
		
		int a = -22;
		int b = Math.abs(a); //Math Ŭ������ �����ڴ� private �̰� �ʵ�� �޼ҵ�� static�̴�.
		 /*Frame�� �Է��� ������ ��� ���ڿ� Ÿ���̴� 
		  * �̷��� ���ڸ���� ���ڿ��� ����ϱ� ���ϼ��� ������ ��ȯ*/
		 String s1 = "22";
		 String s2 = "23";
		 Integer it = new Integer(0);
		 int i=it.parseInt(s1);
	System.out.println(s1+s2);
	//PI�� ���(static fanal)
	System.out.println( Math.PI);
	System.out.println(Color.GREEN);
	
	}
	
	
	

}
