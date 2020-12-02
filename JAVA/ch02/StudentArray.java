package ch02;

import java.util.ArrayList;

  class Student {
	private int studentID;
	protected String name;

     public Student(int studentID, String name) {
		this.studentID = studentID;
		this.name = name;
	}

	public void showStudentinfo() {
		System.out.println("ID : " + studentID);
		System.out.println("name : " + name);
		System.out.println();
	}
}
public class StudentArray{
	public static void main(String[] args) {
		ArrayList<Student> sd;
		sd = new ArrayList<Student>();
		

		Student adde = new Student(2020, "yeas");
		Student add = new Student(2020, "yeas");
		Student ad = new Student(2020, "yeas");

		sd.add(new Student(1001, "James"));
		sd.add(new Student(1002, "Tomas"));
		sd.add(new Student(1003, "Edward"));

		for (Student asdads : sd) {
			asdads.showStudentinfo();
		}

		System.out.println(adde);
		adde.showStudentinfo();
	}}

