package ch06;

public class UtilMgr {
	//매개변수가 숫자이면 true, 숫자가 아니면 false
	public static boolean isNumeric(String s) {
		  try {
		      Integer.parseInt(s);
		      return true;
		  } catch(NumberFormatException e) {
		      return false;
		  }
	}
}
