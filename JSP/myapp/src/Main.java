import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
	public static int intSplit1(int a) {
		String str = a+"";
		int b = Integer.parseInt(str.substring(0,1));
		return b;
	}
	
	public static int intSplit2(int a) {
		String str = a+"";
		int b = Integer.parseInt(str.substring(1,2));
		return b;
	}
	
	public static void main(String[] args) {
		
	 try {
		BufferedWriter bw = 
		     new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = 
			 new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);
		
		int a = Integer.parseInt(str.substring(0,1));
		int b = Integer.parseInt(str.substring(1,2));
		int r=0,cnt=0,m;
		 r = a+b;
		 
		while(n!=r) {
			if(r>=10) {
			   a=intSplit1(r);
			   b= intSplit2(r);
			   m = a+b;
			   String str2 = b+""+intSplit2(m)+"";
			   r = Integer.parseInt(str2);
			}else if(r<10) {
				  String q = b+""+r+"";
				   r = Integer.parseInt(q);
				   
			}
		   
		   
		   
		   String q = b+""+r+"";
		   r = Integer.parseInt(q);
		   

		   cnt++;
		}
			System.out.println(cnt);
	
		bw.flush();
		bw.close();
	}catch(IOException e) {
	}
}}