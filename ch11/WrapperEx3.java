package ch11;

import java.util.Vector;

public class WrapperEx3 {

	public static void main(String[] args) {
		//�ڹ� �⺻�� ������ <-->  Warapper Ŭ���� : 5.0���� �����Ǵ� ���� 
		int a = 10;
		Integer ie = a;       //���� �ڽ�
		int b = ie;				//���� ��ڽ� 
		
		int c = ie.intValue();        //5.0������ ��ڽ��ϱ�
		Integer ie2 = Integer.valueOf(10);
		
		Vector v = new Vector();
		v.add(10);  //����ڽ��� ���������� �߻�
		
		
		
		
		
		
		
	}

}
