package ch11;

public class WrapperEx2 {

	public static void main(String[] args) {
		char date[] = {'A','a','4',' ','#'};
		for (int i = 0; i < date.length; i++) {
			if(Character.isUpperCase(date[i]))      // ~~�̴�, ~~�� �ƴϴ�  : is~ 
				System.out.println(date[i] + " : �빮��");
			if(Character.isLowerCase(date[i]))   
				System.out.println(date[i] + " : �ҹ���");
			if(Character.isDigit(date[i]))    
				System.out.println(date[i] + " : ����");
			if(Character.isWhitespace(date[i]))       
				System.out.println(date[i] + " : ���鹮��");
	}
  }
}
