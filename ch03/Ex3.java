package ch03;

public class Ex3 {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
        //System.out.println(a/b);
		//& : and ������  | : or ������ 
         System.out.println((a>b)&(a<b));	  //����� ������ ������ ������?
         System.out.println((a>b)&&(a<b));	//������� �տ��� false�� ���� �ڴ� ����x
    //System.out.println((a<b)&(a/b==0));     
    System.out.println((a<b)&&(a/b==0));     
    System.out.println((a>b)||(a/b==0));     
	
	
	}

}
