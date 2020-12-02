package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;

public class FormattedFieldTest extends JFrame
implements PropertyChangeListener{
	
	//데이터 입력을 위한 포매터
	JFormattedTextField amountF;
	JFormattedTextField dateF;
	JLabel result;
	
	public FormattedFieldTest() {
		setTitle("FormattedFieldTest");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1, p2;
		//숫자만 입력 받을수 있는 필드
		amountF = 
		new JFormattedTextField(new NumberFormatter());
		amountF.setValue(100);
		amountF.setColumns(10);
		amountF.addPropertyChangeListener("value", this);
		p1 = new JPanel();
		p1.add(new JLabel("금액: "));
		p1.add(amountF);
		
		dateF = 
		new JFormattedTextField(new DateFormatter());
		dateF.setValue(new Date());
		dateF.setColumns(10);
		dateF.addPropertyChangeListener("value", this);
		p2 = new JPanel();
		p2.add(new JLabel("날짜: "));
		p2.add(dateF);
	
		add(p1,BorderLayout.PAGE_START);
		add(p2,BorderLayout.CENTER);
		add(result = new JLabel("출력내용"),
				BorderLayout.PAGE_END);
		result.setForeground(Color.blue);
		setVisible(true);
	}
	
	//속성값이 변경이 될때 호출되는 이벤트
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if(e.getSource()==amountF){
			double d = 
					((Number)amountF.getValue()).doubleValue();
			result.setText(new Double(d).toString());
		}else if(e.getSource()==dateF){
			Date d =(Date)(dateF.getValue());
			result.setText(d.toString());
		}
	}

	public static void main(String[] args) {
		new FormattedFieldTest();
	}
}
