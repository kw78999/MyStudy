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
		JLabel label = new JLabel("���� ���ñ� ������Ʈ �׽�Ʈ�Դϴ�.");
		open = new JButton("���� ����");
		save = new JButton("���� ����");
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
				//����
				System.out.println(f.getSelectedFile());
			}else{
				//���
			}
		}else if(e.getSource()==save){
			int val = f.showSaveDialog(this);
			if(val==JFileChooser.APPROVE_OPTION){
				//����
				System.out.println(f.getSelectedFile());
			}else{
				//���
			}
		}
	}

	public static void main(String[] args) {
		new FileChooserTest();
	}
}
