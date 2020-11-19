package JAVAP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TTTTFileUpload extends JFrame {
	JPanel p;
	JTextField tf;
	JButton selectFileBt;
	JButton uploadBt;
	String basePath = "C:\\Java\\eclipse-workspace\\myJava\\test";
	File selectedFile;
	static String filename;
	public TTTTFileUpload() {
		p = new JPanel();
		p.add(tf = new JTextField(20));
		p.add(selectFileBt = new JButton("업로드 파일선택"));
		p.add(uploadBt = new JButton("업로드"));
		uploadBt.setVisible(false);

		selectFileBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();

				int returnValue = fileChooser.showOpenDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					tf.setText(selectedFile.getAbsolutePath());
					uploadBt.setVisible(true);
				}
			}
		});

		uploadBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTTTFileService fs = new TTTTFileService();
				try {
					int cmd = fs.makeDirAndDulpleChk(basePath, selectedFile.getName());
					if (cmd == -1) {
						int confimReturnVal = confirmMessage("중복된 파일이 있습니다. 덮으시겠습니까?");
						if (confimReturnVal != 0) {
							showMessage("취소 하셨습니다");
							uploadBt.setVisible(false);
							return;
						}
					}
					fs.saveFile(selectedFile, basePath, selectedFile.getName());
					filename = selectedFile.getName();
				} catch (Exception e1) {
					showMessage("파일업로드 중 에러가 발생하였습니다.");
					e1.printStackTrace();
				}
				showMessage("정상적으로 업로드 되었습니다.");
				tf.setText("");
				uploadBt.setVisible(false);
				SwingProject_1.imaget.setText(selectedFile.getName());
			}
		});

		add(p);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);

		setVisible(true);
		setBounds(500, 200, 300, 300);
	}

	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public int confirmMessage(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}

	
}
