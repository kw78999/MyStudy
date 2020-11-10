package ch16;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;

public class DesignEx3_3 extends MFrame{

	List list;
	Button b[] = new Button[4];
	String lab[] = {"추가","지우기","전체지우기","종료"};
	TextField tf;
	String food[] ={"짜장면","짬뽕","우동"};
	Panel p1,p;
	
	public DesignEx3_3() {
		super(300,200);
		setTitle("디자인 예제3");
		setLayout(new BorderLayout());
		p1 = new Panel();
		p1.setLayout(new GridLayout(4,1));
		for (int i = 0; i < b.length; i++) {
			b[i] = new Button(lab[i]);
			p1.add(b[i]);
		}
		
		list = new List(3,true); //복수 다중선택
		for (int i = 0; i < food.length; i++) {
			list.add(food[i]);
		}
		add(list,BorderLayout.CENTER);
		add(tf = new TextField ("군만두"),BorderLayout.SOUTH);
		add(p1,BorderLayout.AFTER_LINE_ENDS);
		validate();
	}

	public static void main(String[] args) {
		new DesignEx3_3();
	}
}








