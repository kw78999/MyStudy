package ch07;

public class test1_21 {

	public static void main(String[] args) {
		
		int j = 20;
		long pj = j;
		int cnt = 0;
			
		while(true) {
			
			for (int i = 1; i <=j; i++) {
				if(pj % i ==0) {
					cnt++;
					if(cnt==j) {
						System.out.println(pj);
						System.exit(0);
						break;
					}
				}else {
					cnt = 0;
					break;
				}
					
			}
			pj +=j;
		}
	}

}
