package ch11;

public class StringEx3 {

	public static void main(String[] args) {
		//args.length �� ���� : �迭�� ������ �Ǹ� ���������� �迭��ü�� ����� ����.
		String s1 = "�������̰� ��ȭ������ �һ���ȸ�� ����."
				 + "�������� 5�� ���� 3�� ���� �Ұ��� �Ե� ��ȭ��"
				 + " 8�� �̺�ƮȦ����... ���� �귣�� ������ȭ��" 
				 + " ȫ���� ���� �һ���ȸ�� �����Ѵ�.";
		/*1��. ���������� ���鹮���� index��ȣ�� ����Ͻÿ�.
		 * ex)4,7,9,11
		 * hint indexOf �̿�
		 * 
		 * 2��. ���������� ���鹮���� index��ȣ�� ����Ͻÿ�.
		 * hint : lastIncdexOf �̿�
		 */
		
		        //3�� ������ '_'�� ��ȯ�Ͽ� ���
		        for (int i = 0; i < s1.length(); i++) {
					char c = s1.charAt(i);
					if ( c == ' ')System.out.print('_');
					else System.out.print(c);
				}
		
		        String s2 = s1.replace(' ','_' );  //~�� ~���� ��ȯ
		        System.out.println("\n"+s2);
		        
		        //4��. ù�ܾ ����ϱ�
		        int a = s1.indexOf(' ');
		        String s3 = s1.substring(0,a);  // ~�������� ~���� �ܾ� ���
		        System.out.println(s3+"**");
		        
		        //5�� ������ �ܾ� ����ϱ�
		        int b = s1.lastIndexOf(' ');
		        String s4 = s1.substring(b+1,s1.length());
		        System.out.println(s4);
		        
		        //6�� �յڿ� ���� ����
		        String s5 = "  ��Ʋ��  �ȵ���̵�&�ڹ�    ";
		        System.out.println(s5.trim());   //�յڷ� ������ �����Ѵ� 
		        
		        //7�� �������� ���ڿ��� ��ȯ
		        String s6 = "22";
		        int c = Integer.parseInt(s6);
		        String s7 = String.valueOf(c);
		        System.out.println(s7);
		        String s8 = c+"";    //���� + ���ڿ��� ���ڿ��� �ڵ� ����ȯ
		        
		        //8�� ���ڿ��� Ư������ �����Ͽ� ������
		        String s9 = "JAVA&JSP&Android&Spring";
		        String s10[] = s9.split("&");
		        for (int i = 0; i < s10.length; i++) {
					System.out.println(s10[i]);
				}
		        
		        
		        
		        
		        
		        
		}
}
	

