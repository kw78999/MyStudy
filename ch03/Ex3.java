package ch03;

public class Ex3 {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
        //System.out.println(a/b);
		//& : and 연산자  | : or 연산자 
         System.out.println((a>b)&(a<b));	  //결과도 보지만 에러가 나는지?
         System.out.println((a>b)&&(a<b));	//결과위주 앞에서 false가 나면 뒤는 연산x
    //System.out.println((a<b)&(a/b==0));     
    System.out.println((a<b)&&(a/b==0));     
    System.out.println((a>b)||(a/b==0));     
	
	
	}

}
