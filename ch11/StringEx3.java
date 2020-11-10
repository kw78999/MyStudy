package ch11;

public class StringEx3 {

	public static void main(String[] args) {
		//args.length 는 변수 : 배열이 선언이 되면 내부적으로 배열객체가 만들어 진다.
		String s1 = "전지현이가 백화점에서 팬사인회를 연다."
				 + "전지현은 5일 오후 3시 서울 소공동 롯데 백화점"
				 + " 8층 이벤트홀에서... 구두 브랜드 조이제화의" 
				 + " 홍보를 위한 팬사인회에 참석한다.";
		/*1번. 순방향으로 공백문자의 index번호를 출력하시오.
		 * ex)4,7,9,11
		 * hint indexOf 이용
		 * 
		 * 2번. 역반향으로 공백문자의 index번호를 출력하시오.
		 * hint : lastIncdexOf 이용
		 */
		
		        //3번 공백을 '_'로 변환하여 출력
		        for (int i = 0; i < s1.length(); i++) {
					char c = s1.charAt(i);
					if ( c == ' ')System.out.print('_');
					else System.out.print(c);
				}
		
		        String s2 = s1.replace(' ','_' );  //~을 ~으로 변환
		        System.out.println("\n"+s2);
		        
		        //4번. 첫단어를 출력하기
		        int a = s1.indexOf(' ');
		        String s3 = s1.substring(0,a);  // ~에서부터 ~까지 단어 출력
		        System.out.println(s3+"**");
		        
		        //5번 마지막 단어 출력하기
		        int b = s1.lastIndexOf(' ');
		        String s4 = s1.substring(b+1,s1.length());
		        System.out.println(s4);
		        
		        //6번 앞뒤에 공백 제거
		        String s5 = "  코틀린  안드로이드&자바    ";
		        System.out.println(s5.trim());   //앞뒤로 공백을 제거한다 
		        
		        //7번 정수값을 문자열로 변환
		        String s6 = "22";
		        int c = Integer.parseInt(s6);
		        String s7 = String.valueOf(c);
		        System.out.println(s7);
		        String s8 = c+"";    //숫자 + 문자열은 문자열로 자동 형변환
		        
		        //8번 문자열을 특수문자 구분하여 나누기
		        String s9 = "JAVA&JSP&Android&Spring";
		        String s10[] = s9.split("&");
		        for (int i = 0; i < s10.length; i++) {
					System.out.println(s10[i]);
				}
		        
		        
		        
		        
		        
		        
		}
}
	

