package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class TextAreaTest extends JFrame 
implements ActionListener{
	
	JTextField tf;
	JTextArea ta;
	
	public TextAreaTest() {
		setTitle("FormattedFieldTest");
		//setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf = new JTextField(30);
		tf.addActionListener(this);
		ta = new JTextArea(10,10);
		JScrollPane sc = new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(tf,BorderLayout.PAGE_START);
		add(sc);
		//자동으로 사이즈를 만들어 주는 메소드
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = tf.getText();
		//ta.append(text+"\n");
		ta.setText(ta.getText()+text+"\n");
		tf.selectAll();
		ta.setCaretPosition(ta.getDocument().getLength());
	}

	public static void main(String[] args) {
		 try {
				// 1. 자바 내장 룩앤필
				 //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

				// 2. quaqua.jar : Quaqua Look and Feel
				UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
				JFrame.setDefaultLookAndFeelDecorated(true);

				// 3. liquidlnf.jar : Liquid Look and Feel
				//UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");

				// 4. idw-gpl.jar : InfoNode Look and Feel
				 //UIManager.setLookAndFeel("net.infonode.gui.laf.InfoNodeLookAndFeel");

				// 5. JTattoo.jar : JTattoo Look and Feel
				//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
				//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			
		    }  catch (Exception e) { }
		new TextAreaTest();
	}
}
