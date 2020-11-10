package ch12;

import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector<String> vec = new Vector();
		vec.add("JAva");
		vec.add("Jsp");
		vec.add("Andorid");
		vec.add("Jsp");
		vec.add("Oracle");
		System.out.println(vec.size());
		vec.remove(0);
		if (vec.contains("Andorid")) {
			int idx = vec.indexOf("Andorid");
			System.out.println(idx);
		}
		System.out.println(vec.isEmpty());
		vec.addElement("String");//add¶û ºñ½Á
		System.out.println(vec.get(0));
		System.out.println(vec.elementAt(1));
	}

}
