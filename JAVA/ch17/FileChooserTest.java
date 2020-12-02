package ch17;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileChooserTest extends JFrame 
implements ActionListener{
	
	JButton open, save;
	JFileChooser f;
	
	public FileChooserTest() {
		setTitle("TreeTest");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f = new JFileChooser();
		Panel p = new Panel();
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		open = new JButton("파일 열기");
		save = new JButton("파일 저장");
		open.addActionListener(this);
		save.addActionListener(this);
		p.add(label);
		p.add(open);
		p.add(save);
		add(p);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==open){
			int val = f.showOpenDialog(this);
			if(val==JFileChooser.APPROVE_OPTION){
				//열기
				System.out.println(f.getSelectedFile());
			}else{
				//취소
			}
		}else if(e.getSource()==save){
			int val = f.showSaveDialog(this);
			if(val==JFileChooser.APPROVE_OPTION){
				//저장
				System.out.println(f.getSelectedFile());
			}else{
				//취소
			}
		}
	}

	public static void main(String[] args) {
		new FileChooserTest();
	}
}
