package JAVAP;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MemThread implements Runnable{

	
	static Color red = new Color(255,184,249);
	static Color cor= Color.white;
	
	static LineBorder lb = new LineBorder(red,5);
	static LineBorder bb = new LineBorder(cor,5);
	TitledBorder jtx2=new TitledBorder(lb,"회원정보        ");
	TitledBorder jtx3=new TitledBorder(bb,"회원정보        ");
	
	
	
	@Override
	public void run() {
		
	jtx2.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
	jtx3.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
	try {
		SwingProject.panel13.setBorder(jtx2);
		Thread.sleep(1000);
		SwingProject.panel13.setBorder(jtx3);
		//Thread.sleep(1000);
		//ChatClient.mpanel.setBorder(jtx2);
		//Thread.sleep(1000);
		//ChatClient.mpanel.setBorder(jtx3);
		//Thread.sleep(1000);
		}catch(Exception e){
			
		}

}}
