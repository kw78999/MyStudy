package ch12;

import java.util.ArrayList;

public class ArrayListEx2 {

	public static void main(String[] args) {
		
		ArrayList list  = new ArrayList();
		list.add("JAva");
		list.add(10);//10�� int ���̹Ƿ� Object Ÿ���� �ƴ�����, Auto-Boxing �� ���ؼ� Integer�� ��ȯ�Ǿ� ����ȴ�
		list.add(true);
		list.add(new Object());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		ArrayList list2 = new ArrayList();
		list2.add("Java");
		list2.add("Jsp");
		list2.add("Oracle");
		
		for (int i = 0; i < list2.size(); i++) {
			//�����Ҷ� Ÿ������ ĳ���� ���� �����´�
			String s = (String)list2.get(i);
			System.out.println(s.length());
		}
		//���׸�(Generic): Collection ��ü�� �����Ҷ� Ÿ���� �̸�����
		ArrayList<String> list3 = new ArrayList<String>();

		list3.add("Java");
		list3.add("Jsp");
		list3.add("Oracle");
		//list3.add(11);  String �����Ͽ� String �� ����
		String s  = list3.get(0);
		
		
		
		
		
		
	}

}
