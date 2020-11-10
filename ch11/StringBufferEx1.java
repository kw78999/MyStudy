package ch11;

public class StringBufferEx1 {

	public static void main(String[] args) {
		String s1 = "Java ";
		s1 += "Programming";
		System.out.println(s1);
		
		StringBuffer sb = new StringBuffer();
		//StringBuffer sb1 = "гого";
	sb.append("Java");
	System.out.println(sb);          //sb.toString
	sb.append(" Programming");
	System.out.println(sb);
	sb.replace(0, 4, "Android");
	System.out.println(sb);
	sb.deleteCharAt(0);
	System.out.println(sb);
	System.out.println(sb.reverse());
	
	
	
	
	
	}

}
