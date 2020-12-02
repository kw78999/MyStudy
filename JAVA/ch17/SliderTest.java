package ch17;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest extends JFrame 
implements ChangeListener{
	
	final static int INIT_VALUE = 15;
	JButton btn;
	JSlider slider;
	
	public SliderTest() {
		setTitle("SliderTest");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		///////////////////////////////////////////
		JPanel p = new JPanel();
		JLabel label = new JLabel("슬라이더를 움직여보세요.",
				JLabel.CENTER);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(label);
		/////////////////////////////////////////////
		slider = new JSlider(0,30,INIT_VALUE);
		slider.setMajorTickSpacing(10);//큰 눈금 간격
		slider.setMinorTickSpacing(1);//작은 눈금 간격
		slider.setPaintTicks(true);//눈금표시 유무
		slider.setPaintLabels(true);//값을 레이블로 표시
		slider.addChangeListener(this);
		p.add(slider);
		//////////////////////////////////////////////
		btn = new JButton("강남자바");
		ImageIcon icon = new ImageIcon("ch11/dog.gif");
		btn.setIcon(icon);
		btn.setSize(INIT_VALUE*10, INIT_VALUE*10);
		p.add(btn);
		
		add(p);
		setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider s = (JSlider)e.getSource();
		if(s.getValueIsAdjusting()){
			int value = (int)s.getValue();
			btn.setSize(value*10, value*10);
		}
	}
	
	public static void main(String[] args) {
		new SliderTest();
	}
}



