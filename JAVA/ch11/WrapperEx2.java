package ch11;

public class WrapperEx2 {

	public static void main(String[] args) {
		char date[] = {'A','a','4',' ','#'};
		for (int i = 0; i < date.length; i++) {
			if(Character.isUpperCase(date[i]))      // ~~이다, ~~가 아니다  : is~ 
				System.out.println(date[i] + " : 대문자");
			if(Character.isLowerCase(date[i]))   
				System.out.println(date[i] + " : 소문자");
			if(Character.isDigit(date[i]))    
				System.out.println(date[i] + " : 숫자");
			if(Character.isWhitespace(date[i]))       
				System.out.println(date[i] + " : 공백문자");
	}
  }
}
