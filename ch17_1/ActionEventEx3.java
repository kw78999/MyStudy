package ch17_1;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx3 extends MFrame
implements ActionListener{

	List list;
	Button b[] = new Button[4];
	String lab[] = {"추가","지우기","전체지우기","종료"};
	TextField tf;
	
	public ActionEventEx3() {
		super(300,200);
		setTitle("ActionEx3");
		//////////////////////////////////////////////
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,1));
		for (int i = 0; i < b.length; i++) {
			p.add(b[i]=new Button(lab[i]));
			b[i].addActionListener(this);
		}
		//////////////////////////////////////////////
		add(list=new  List());
		add(p,"East");
		add(tf=new TextField(),"South");
		tf.addActionListener(this);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals(lab[0])||tf==e.getSource()) {
			String item = tf.getText();//입력된 문자열 리터
			if(item.trim().length()==0) {
				MDialog md = new MDialog(this, "알림", "문자열을 입력하세요.");
				int width = 100;
				int height = 100;
				int px = getX();
				int py = getY();
				int x = px+getWidth()/2-width/2;
				int y = py+getHeight()/2-height/2;
				md.setBounds(x, y, width, height);
				md.setVisible(true);
				return;
			}
			list.add(item);//list에 입력된 문자열 추가
			tf.setText("");//빈값으로 초기화
			tf.requestFocus();//포커스를 가져온다.
		}else if(cmd.equals(lab[1])) {
			int idx = list.getSelectedIndex();
			if(idx==-1) {
				MDialog md = new MDialog(this, "알림", "삭제할 아이템을 선택하세요.");
				int width = 180;
				int height = 100;
				int px = getX();
				int py = getY();
				int x = px+getWidth()/2-width/2;
				int y = py+getHeight()/2-height/2;
				md.setBounds(x, y, width, height);
				md.setVisible(true);
				return;
			}
			list.remove(idx);
		}else if(cmd.equals(lab[2])) {
			list.removeAll();//추가된 모든 아이템 삭제(제거)
		}else if(cmd.equals(lab[3])) {
			System.exit(0);//시스템 종료
		}
	}
	
	class MDialog extends Dialog implements ActionListener{
		
		Button btn;

		public MDialog(Frame f, String title, String msg) {
			super(f,title,true);
			setLayout(new FlowLayout());
			add(new Label(msg, Label.CENTER));
			add(btn = new Button("확인"));
			btn.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();//MDialog가 사라진다.
		}
	}
	
	public static void main(String[] args) {
		new ActionEventEx3();
	}
}


