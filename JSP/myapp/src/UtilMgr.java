package ch06;

public class UtilMgr {
	//�Ű������� �����̸� true, ���ڰ� �ƴϸ� false
	public static boolean isNumeric(String s) {
		  try {
		      Integer.parseInt(s);
		      return true;
		  } catch(NumberFormatException e) {
		      return false;
		  }
	}
}
