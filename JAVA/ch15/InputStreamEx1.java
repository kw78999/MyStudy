package ch15;

import java.io.InputStream;

public class InputStreamEx1 {

	public static void main(String[] args) {
		InputStream is = System.in; //Ű���忡 ����� Input��Ʈ��
		while(true) {
			try {
				int i = is.read(); //���������� ������ -> Ű���� �Է��ϸ� ����
				System.out.println((char)i);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		
		
	}

}
