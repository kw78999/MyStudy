package ch15;

import java.io.InputStream;

public class InputStreamEx1 {

	public static void main(String[] args) {
		InputStream is = System.in; //키보드에 연결된 Input스트림
		while(true) {
			try {
				int i = is.read(); //내부적으로 대기상태 -> 키보드 입력하면 실행
				System.out.println((char)i);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		
		
	}

}
