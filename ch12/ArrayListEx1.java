package ch12;

import java.util.ArrayList;

public class ArrayListEx1 {

	public static void main(String[] args) {
		//��ü�� �����ϴ� Ŭ���� : �迭�� ������ �����Ѵ�
		//�迭 : ������ Date Ÿ�� �̾���ϰ�, ũ�Ⱑ �������ִ�.
		//ArrayList or Vector �� Ÿ�� �� ũ�Ⱑ �������̴�.
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
