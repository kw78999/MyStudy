package ch15;

import java.io.OutputStream;

public class OutputStreamEx1{

	public static void main(String[] args) {
		try {
			int i = 'A';
			char c = 'q';
			char c1 = '��';
			OutputStream os = System.out;
			os.write(i);
			os.write(c);
			os.write(c1);
			os.flush();    //��Ʈ���� �����ִ� data�� ����
			os.close();   // ���̻� ������� �ʴ� ��Ʈ���� close �Ѵ� 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
