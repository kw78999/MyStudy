package ch15;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;


public class FileWriterFrame extends MFrame
implements ActionListener{
	
	TextArea ta;
	TextField tf;
	Button save;
	
	public FileWriterFrame() {
		super(320, 400);
		setTitle("FileWriterFrame");
		add(ta=new TextArea());
		Panel p = new Panel();
		p.add(tf = new TextField(30));
		p.add(save = new Button("SAVE"));
		ta.setEditable(false);
		tf.addActionListener(this);
		save.addActionListener(this);
		add(p,BorderLayout.SOUTH);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj ==tf) {
			ta.append(tf.getText()+"\n");
			tf.setText("");
			tf.requestFocus();
		}else if(obj==save) {
			saveFile(ta.getText());
			ta.setText("");
			for (int i = 5; i > 0; i--) {
				ta.setText("저장 되었습니다. - "+ i + "초 후에 사라집니다.");
				try {
					Thread.sleep(1000);  //1초 동안 일을 하지마.
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} 
			}
			ta.setText("");
		}
	}
	
	public void saveFile(String str) {
		try {
			long fName = System.currentTimeMillis()	;
			FileWriter fw = new FileWriter("ch15/"+fName+".txt");
			fw.write(str);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		new FileWriterFrame();
		//1970년1월1일~현재 : 1초 1000단위 계산된 값
		long fName = System.currentTimeMillis();
		System.out.println(fName);
	}
}






