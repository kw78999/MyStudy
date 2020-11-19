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
		p.add(selectFileBt = new JButton("���ε� ���ϼ���"));
		p.add(uploadBt = new JButton("���ε�"));
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
						int confimReturnVal = confirmMessage("�ߺ��� ������ �ֽ��ϴ�. �����ðڽ��ϱ�?");
						if (confimReturnVal != 0) {
							showMessage("��� �ϼ̽��ϴ�");
							uploadBt.setVisible(false);
							return;
						}
					}
					fs.saveFile(selectedFile, basePath, selectedFile.getName());
					filename = selectedFile.getName();
				} catch (Exception e1) {
					showMessage("���Ͼ��ε� �� ������ �߻��Ͽ����ϴ�.");
					e1.printStackTrace();
				}
				showMessage("���������� ���ε� �Ǿ����ϴ�.");
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
