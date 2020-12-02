package ch16;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialogEx1 extends MFrame implements ActionListener{

	FileDialog openFile,saveFile;
	Button openBtn, saveBtn;
	
	public FileDialogEx1() {
		openFile =  new FileDialog(this,"파일열기 ",FileDialog.LOAD);
		saveFile = new FileDialog(this,"파일저장",FileDialog.SAVE);
		Panel p = new Panel();
		p.add(openBtn = new Button("파일열기"));
		p.add(saveBtn = new Button("파일저장"));
		add(p);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		validate();
	}
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼이 두개이므로 둘중에 어떤 버튼인지 구분
		if(e.getSource()==openBtn)
			openFile.setVisible(true);
		else if (e.getSource()==saveBtn)
			saveFile.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new FileDialogEx1();
	}

}
