package ch16;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.plaf.basic.BasicScrollBarUI;
/*AWT����� ���
 * 1. �ʿ��� ������Ʈ �����Ѵ�.
 * 2. ������Ʈ�� �����̳�(Frame->MFrame �߰�)
 * 3. ���̾ƿ� �Ŵ����� ����Ѵ�
 * 4.�̺�Ʈ�� ����߰�(�ڿ�...)
 * 
 * */
public class LabelEx1 extends MFrame{
	
	Label label1,label2,label3,label4;
	
	
	
	
	public LabelEx1() {
		super(230,200);
		setTitle("Label Example");
		String str = "������ ���ְ� ���۵Ǵ� ������";
		label1 = new Label(str);
		//����� �� �����ϴ��� = 1�� Label.CENTER�� ������ 1�� ���� �����Ҽ� ����.
		label2 = new Label(str,1);
		label2.setBackground(MColor.rColor());
		label3 = new Label(str,Label.RIGHT);
		label3.setBackground(MColor.rColor());
		label4 = new Label(str,Label.LEFT);
		label4.setForeground(MColor.rColor());  //�����(���ڻ�)
		//�ʿ��� ������Ʈ ����
		add(label1);add(label2);add(label3);add(label4);
		validate();//���ΰ�ħ
	}
	public static void main(String[] args) {
		new LabelEx1();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
