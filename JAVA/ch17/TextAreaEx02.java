package ch17;

import java.awt.*;

import javax.swing.JFrame;

public class TextAreaEx02 {
	public static void main(String argv[]) {
		JFrame f = new JFrame("TextArea Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		String str = "1234567890 234567890 34567890 4567890 567890";
		TextArea ta3 = new TextArea(str, 5, 20,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		f.add(ta3);
		//지정한 위치에 커서 세팅
		ta3.setCaretPosition(0);
		//ta3.setCaretPosition(20);
		//ta3.setCaretPosition(str.length());
		f.pack();
		f.setVisible(true);
	}
}
