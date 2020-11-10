package ch17_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventEx1 extends MFrame 
implements ActionListener{
	/*�̺�Ʈ ����� 3�� ���
	 * 1.�̺�Ʈ �ҽ�
	 * 2.�̺�Ʈ Ŭ���� : �̺�Ʈ�� �߻��ϸ� ��������� �̺�Ʈ ��ü
	 * ex) ActionEvent
	 * 3.�̺�Ʈ �ڵ鷯 : �̺�Ʈ �ҽ�(��ư)�� �̺�Ʈ Ŭ������ ���� ������ �ϱ� ���ؼ� 
	 * �������̽��� �ϳ� ������ �ؾ� �Ѵ�. XXXListener -> ActionListener 
	 * */
	
	Button btn;//��ư�� Ŭ���ϸ� ActionEvent�� ��ü�� ���� : �̸� ������ ��.
	
	public EventEx1() {
		add(btn = new Button("��ư"),
				BorderLayout.SOUTH);
		//4.�̺�Ʈ �ҽ��� �̺�Ʈ �ڵ鷯�� ���� : addXXXListener
		//ch.addItemListener, tx.addKeyListener
		btn.addActionListener(this);
	}
	//�̺�Ʈ �ڵ鷯 : �������̽� �Ǵ� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx1();
	}
}




