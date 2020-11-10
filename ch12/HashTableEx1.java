package ch12;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableEx1 {

	public static void main(String[] args) {
		
		//key = value 한쌍으로 저장되는 Collection
Hashtable<String, String> ht = new Hashtable<String, String>();

	ht.put("사과", "Apple");
	ht.put("포도", "Grapes");
	ht.put("딸기", "Strawbery");
	ht.put("멜론","Melon");
	//Enumeration : 줄줄이 사탕
	Enumeration<String>  e = ht.keys();
	while(e.hasMoreElements()/*요소가 있을때 까지*/) {
		String key = e.nextElement();
		String value = ht.get(key);
		System.out.println(key+"   :   " + value);
	}






	}

}
