package ch17;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxTest extends JPanel 
implements ItemListener{
	
	JCheckBox[] cb = new JCheckBox[3];
	String[] fruits = {"apple","grape","orange"};
	JLabel[] picLabel = new JLabel[3];
	ImageIcon[] icon = new ImageIcon[3];
	
	public CheckBoxTest() {
		super(new GridLayout(0, 4));
		for (int i = 0; i < cb.length; i++) {
			cb[i] = new JCheckBox(fruits[i]);
			cb[i].addItemListener(this);
			picLabel[i] = new JLabel(fruits[i]+".gif");
			icon[i] = new ImageIcon("ch17/"+fruits[i]+".gif");
		}
		////////////////////////////////////////////
		JPanel chP  = new JPanel(new GridLayout(0, 1));
		for (int i = 0; i < cb.length; i++) {
			chP.add(cb[i]);
		}
		////////////////////////////////////////////
		add(chP);
		for (int i = 0; i < picLabel.length; i++) {
			add(picLabel[i]);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getItemSelectable();
		for (int i = 0; i < cb.length; i++) {
			if(obj==cb[i]){
				if(e.getStateChange()==ItemEvent.DESELECTED){
					//선택을 해제할때	
					picLabel[i].setIcon(null);
				}else{
					//선택할때
					picLabel[i].setIcon(icon[i]);
				}//if2
			}//if1
		}//for
	}//itemStateChanged
	
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBoxTest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckBoxTest cbt = new CheckBoxTest();
		//cbt.setOpaque(false);
		cbt.setBackground(Color.magenta);
		//변경된것을 적용-디폴트:false
		//cbt.setOpaque(true);
		f.setContentPane(cbt);
		f.setSize(500, 200);
		f.setVisible(true);
	}
}





