package JAVAP;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class ColorThread implements Runnable{
	static Color red = new Color(255,184,249);
	static Color cor= Color.white;
	
	static LineBorder lb = new LineBorder(red,5);
	static LineBorder bb = new LineBorder(cor,5);
	TitledBorder jtx2=new TitledBorder(lb,"ȸ������ ä��");
	TitledBorder jtx3=new TitledBorder(bb,"ȸ������ ä��");
    

	public void run() {
		
		jtx2.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
		jtx3.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
		try {
			ChatClient.mpanel.setBorder(jtx2);
			Thread.sleep(1000);
			ChatClient.mpanel.setBorder(jtx3);
			Thread.sleep(1000);
			ChatClient.mpanel.setBorder(jtx2);
			Thread.sleep(1000);
			ChatClient.mpanel.setBorder(jtx3);
			Thread.sleep(1000);
			}catch(Exception e){
				
			}}
}
	