package ch05;


class A9{
	public String name;
	public int age;
}
class B9{
	public String name;
    private  int age;
    
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<1)age=1;
		this.age = age;
	}
    


}
public class Ex9 {

	public static void main(String[] args) {
		A9 a = new A9();
		a.name = "ȫ�浿";
		a.age = 26;
		A9 b = new A9();
		b.name = "ȫ����";
		b.age = -10;
		B9 aa = new B9();
		aa.name = "��ȣ��";
		//aa.age = -10;
		aa.setAge(-10);
		System.out.println(aa.name+"�� ���̴� "+ aa.getAge());
		//Math.
	
	}

}
