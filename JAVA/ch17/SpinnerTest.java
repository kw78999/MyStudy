package ch17;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class SpinnerTest extends JFrame {
	
	JSpinner sp;
	
	public SpinnerTest() {
		setTitle("SpinnerTest");
		setSize(500, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/////////////////////////////////////////////
		JPanel p = new JPanel();
		String[] items = { "소설", "잡지", "전공서적", "취미" };
		SpinnerListModel list = 
				new SpinnerListModel(items);
		p.add(sp=new JSpinner(list));
		/////////////////////////////////////////////
		SpinnerModel num = 
				new SpinnerNumberModel(1,0,9,1);
		p.add(sp=new JSpinner(num));
		/////////////////////////////////////////////
		Calendar c = Calendar.getInstance();
		Date value = c.getTime();//현재날짜
		c.add(Calendar.YEAR, -50);
		Date start = c.getTime();
		c.add(Calendar.YEAR, 100);
		Date end = c.getTime();
		SpinnerDateModel date = 
				new SpinnerDateModel(value, start, end, 
						Calendar.YEAR);
		sp=new JSpinner(date);
		sp.setEditor(new JSpinner.DateEditor(sp,"yyyy/MM/dd"));
		p.add(sp);
		
		/////////////////////////////////////////////
		add(p);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SpinnerTest();
	}
}
