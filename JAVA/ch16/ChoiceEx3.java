package ch16;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx3 extends MFrame implements ItemListener{

	Choice name, star;
	String ms[] = {"�� ��","�� ��","�̹�ȣ","�����","����","������"};
	String fs[] = {"��ƶ�","�̿���","���ϴ�","��ä��","�� ��","�迬��"};
	
public ChoiceEx3() {
		setTitle("������ ����");
		name =new Choice();
		name.add("���� ������");
		name.add("���� ������");
		star = new Choice();
		//�⺻������ ���ڿ������̱⶧���� ms�� ���� add�ȴ� .
		inputItem(star,ms);
		add(name);
		add(star);
		//name ���̽� �̺�Ʈ ����
		name.addItemListener(this);
}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(name.getSelectedItem().equals("���ڿ�����")) {
			inputItem(star,ms);
		}else {
			inputItem(star,fs);
		}
}
		//ù���� �Ű����� Choice�� �ι�° �Ű����� Item�� �߰�
	public void inputItem(Choice c,String item[]) {
		//������ item�� ��� ������ �Ŀ� 
		c.removeAll();
		for (int i = 0; i < item.length; i++) {
			c.add(item[i]);
		}
	}

	public static void main(String[] args) {

		new ChoiceEx3();
		
	}

}
