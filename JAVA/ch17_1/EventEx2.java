package ch17_1;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventEx2 extends MFrame 
implements ItemListener/*XXXListener*/{
	
	Checkbox cb;

	public EventEx2() {
		add(cb = new Checkbox("üũ"),
				BorderLayout.NORTH);
		//�̺�Ʈ�ҽ�.addXXXListener
		//this : �� �ڽ��� ����Ű�� Ű���� -> �� �ڽ��� ��ü �ּ�
		cb.addItemListener(this);
		//üũ�ڽ� üũ �Ǵ� ���� ->itemStateChanged ȣ��
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx2();
	}

}



