package ch16;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.plaf.basic.BasicScrollBarUI;
/*AWT만드는 방법
 * 1. 필요한 컴포넌트 생성한다.
 * 2. 컴포넌트를 컨테이너(Frame->MFrame 추가)
 * 3. 레이아웃 매니저를 사용한다
 * 4.이벤트를 기능추가(뒤에...)
 * 
 * */
public class LabelEx1 extends MFrame{
	
	Label label1,label2,label3,label4;
	
	
	
	
	public LabelEx1() {
		super(230,200);
		setTitle("Label Example");
		String str = "오늘은 한주가 시작되는 월요일";
		label1 = new Label(str);
		//상수를 왜 선언하는지 = 1과 Label.CENTER는 같지만 1은 보고 이해할수 없다.
		label2 = new Label(str,1);
		label2.setBackground(MColor.rColor());
		label3 = new Label(str,Label.RIGHT);
		label3.setBackground(MColor.rColor());
		label4 = new Label(str,Label.LEFT);
		label4.setForeground(MColor.rColor());  //전경색(글자색)
		//필요한 컴포넌트 생성
		add(label1);add(label2);add(label3);add(label4);
		validate();//새로고침
	}
	public static void main(String[] args) {
		new LabelEx1();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
