package ch12;

import java.util.ArrayList;

public class ArrayListEx1 {

	public static void main(String[] args) {
		//객체를 저장하는 클래스 : 배열의 약점을 보완한다
		//배열 : 동일한 Date 타입 이어야하고, 크기가 정해져있다.
		//ArrayList or Vector 는 타입 및 크기가 유동적이다.
		ArrayList list = new ArrayList();
		list.add("JAVA");
		list.add("JSP");
		list.add("DATABASE");
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove(0);
		System.out.println("________________");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
	}

}
