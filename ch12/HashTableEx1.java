package ch12;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableEx1 {

	public static void main(String[] args) {
		
		//key = value �ѽ����� ����Ǵ� Collection
Hashtable<String, String> ht = new Hashtable<String, String>();

	ht.put("���", "Apple");
	ht.put("����", "Grapes");
	ht.put("����", "Strawbery");
	ht.put("���","Melon");
	//Enumeration : ������ ����
	Enumeration<String>  e = ht.keys();
	while(e.hasMoreElements()/*��Ұ� ������ ����*/) {
		String key = e.nextElement();
		String value = ht.get(key);
		System.out.println(key+"   :   " + value);
	}






	}

}
