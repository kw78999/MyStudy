package ch16;

import java.awt.Button;

public class ButtonEx1 extends MFrame{

	Button btn1,btn2,btn3,btn4;
	
	public ButtonEx1() {
		super(250,250);
		setTitle("Button Example");
		/*btn1 = new Button("�߰�");
		 * add(btn1);
		 */
		add(btn1 = new Button("�߰�"));   //��ü ������ ���ÿ� add�Ͽ� �ڵ����� ���̱�
		add(btn2 = new Button("����"));   
		add(btn3 = new Button("��ü����"));   
		add(btn4 = new Button("����")); 
		
		setResizable(false);   //������ ũ�� ����	
		validate();
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new ButtonEx1();
	}

}
