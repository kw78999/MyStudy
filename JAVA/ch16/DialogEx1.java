package ch16;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEx1 extends MFrame implements ActionListener {

		Button btn;
		String title = "메세지 대화상자";		
		
		public DialogEx1() {
			setLayout(null);
			btn = new Button("클릭");
			btn.setBounds(150, 100, 60, 30);  //x좌표 ,y좌표  ,button 넓이 , button 높이
			add(btn);
			btn.addActionListener(this);
			
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		MDialog md = new MDialog(this,title, true);
		int w = 100;
		int h = 100;
		int x = getX() +getWidth()/2-w/2;
		int y = getY()  + getHeight()/2-h/2;
		//MDialog가 프레임에 정중앙에 위치하도록 하기 
		md.setBounds(x,y,w,h);
		md.setVisible(true);
		
	}

	
	
	//내부클래스
//	super();   //생략 되어 있다.  -> Dialog 에는 디폴트 생성자가 없다.
	class MDialog extends Dialog implements ActionListener{
		
		Button b;
		
		public MDialog(Frame f,String title,boolean modal) {  //modal은 awt끼리의 관계이다 
			super (f,title,modal);
			setLayout(new FlowLayout());
			 b= new Button ("확인");
			 b.addActionListener(this);
			 add(b);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		dispose();  //사라진다.
		
		}
		
		
	}
	
	public static void main(String[] args) {
		new DialogEx1();
	}

}
