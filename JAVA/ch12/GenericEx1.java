package ch12;

class Box<T>{
	
	private T t;
	
	public void set(T t) {
		this.t = t;
	}


public T get () {
	return t;
}
}






public class GenericEx1 {

	public static void main(String[] args) {
		Box<String> sBox = new Box<String>();
		Box<Integer> iBox = new Box<Integer>();
		sBox.set("гого");
		iBox.set(10);   
		System.out.println(sBox.get());
		System.out.println(iBox.get());
	}

}
