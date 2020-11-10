package ch15;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyFrame extends MFrame implements ActionListener{
	
	Button open, save;
	TextArea ta;
	FileDialog openDialog, saveDialog;
	String sourceDir;
	String sourceFile;
	
	public FileCopyFrame() {
		super(400,500);
		setTitle("FileCopyFrame");
		add(ta = new TextArea());
		Panel p = new Panel();
		p.add(open = new Button("OPEN"));
		p.add(save = new Button("SAVE"));
		open.addActionListener(this);
		save.addActionListener(this);
		add(p,BorderLayout.SOUTH);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==open) {
			openDialog = new FileDialog(this, "파일열기",FileDialog.LOAD);
			openDialog.setVisible(true);
			String dir = openDialog.getDirectory();
			String file = openDialog.getFile();
			fileReader(dir+file);
		}else if(e.getSource()==save) {
			saveDialog = new FileDialog(this, "파일저장",FileDialog.SAVE);
			saveDialog.setVisible(true);
			String dir = saveDialog.getDirectory();
			String file = saveDialog.getFile();
			fileWriter(dir+file);
		}
	}
	
	public void fileReader(String file){
		try {
			FileReader fr = new FileReader(file);
			int c;
			String s = "";
			while((c=fr.read())!=-1){
				s+=(char)c;
			}
			ta.setText(s);
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileWriter(String file){
		try {
			//FileWriter 파일이 생성
			FileWriter fw = new FileWriter(file);
			fw.write(ta.getText());
			for (int i = 5; i > 0; i--) {
				ta.setText("저장 하였습니다. - " + i + "초 후에 사라집니다.");
				Thread.sleep(1000);//1초 간격으로 일을 하지마.
			}
			ta.setText("");
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FileCopyFrame();
	}
}



