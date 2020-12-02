package member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch17_1.MColor;

public class MemberSwing extends JFrame implements ActionListener {

	JButton b1, b2, b3, b4;
	List list;

	JLabel label;
	JTextField tf1, tf2, tf3;
	JPanel p1, p2, p3, p4, p5, p6;
	JButton insBtn, upBtn;
	Vector<MemberBean> vlist;
	MemberMgr mgr;
	int idx;

	public MemberSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setTitle("ȸ������ ���α׷�");
		mgr = new MemberMgr();
		p1 = new JPanel();
		p2 = new JPanel();
		label = new JLabel("");
		add(label, BorderLayout.PAGE_START);
		b1 = new JButton("����");
		b2 = new JButton("����");
		b3 = new JButton("�Է�");
		b4 = new JButton("����Ʈ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		add(p1, BorderLayout.PAGE_END);
		viewList();
		setVisible(true);
		setResizable(false);
	}

	// DB�� �����ؼ� ����Ʈ�� List��ü add�Ѵ�.
	public void viewList() {
		label.setOpaque(true);//���� ����
		label.setText(" IDX   NAME       PHONE               TEAM");
		label.setBackground(Color.CYAN);
		vlist = mgr.getListMember();
				//System.out.println(vlist.size());
		list = new List(vlist.size(),false);
		for (int i = 0; i < vlist.size(); i++) {
			MemberBean bean = vlist.get(i);
			String s = (i+1) +  "      ";
			s += bean.getName().trim()+"      ";
			s += bean.getPhone().trim()+"    ";
			s += bean.getTeam().trim()+" ";
			list.add(s);
		}
		add(list,BorderLayout.CENTER);
		//�������� �ϳ��̻��� ��� 0��° �ε��� �����Ͽ� ����
		if(list.getItemCount()>0)
			list.select(0);
	}

	// ȸ���Է���
	public void insertForm() {
		label.setText("ȸ���Է���");
		label.setBackground(Color.GRAY);
		p2.setLayout(new GridLayout(4, 1));

		p3 = new JPanel();
		p3.add(new JLabel("NAME  :"));
		tf1 = new JTextField(20);
		p3.add(tf1);
		p2.add(p3);

		p4 = new JPanel();
		p4.add(new JLabel("PHONE  :"));
		tf2 = new JTextField(20);
		p4.add(tf2);
		p2.add(p4);

		p5 = new JPanel();
		p5.add(new JLabel("TEAM  :"));
		tf3 = new JTextField(20);
		p5.add(tf3);
		p2.add(p5);

		p6 = new JPanel();
		insBtn = new JButton("����");
		insBtn.addActionListener(this);
		p6.add(insBtn);
		p2.add(p6);

		add(p2, BorderLayout.CENTER);
	}

	// ȸ��������
	public void updateForm(MemberBean bean) {
		label.setText("ȸ��������");
		label.setBackground(Color.YELLOW);
		p2.setLayout(new GridLayout(4, 1));
		idx = bean.getIdx();

		p3 = new JPanel();
		p3.add(new JLabel("NAME  :"));
		tf1 = new JTextField(bean.getName(), 20);
		p3.add(tf1);
		p2.add(p3);

		p4 = new JPanel();
		p4.add(new JLabel("PHONE  :"));
		tf2 = new JTextField(bean.getPhone(), 20);
		p4.add(tf2);
		p2.add(p4);

		p5 = new JPanel();
		p5.add(new JLabel("TEAM  :"));
		tf3 = new JTextField(bean.getTeam(), 20);
		p5.add(tf3);
		p2.add(p5);

		p6 = new JPanel();
		upBtn = new JButton("��������");
		upBtn.addActionListener(this);
		p6.add(upBtn);
		p2.add(p6);

		add(p2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b1/* ���� */) {
			//list���� ���õ� ������ index�� 
			int i = list.getSelectedIndex();
			//System.out.println(i);
			MemberBean bean = vlist.get(i);
			//���� list�� �ִ� ������ ��� ����
			list.removeAll();
			//Frame�� �����ߴ� list�� ����
			remove(list);
			updateForm(bean);
		} else if (obj == b2/* ���� */) {
			int i = list.getSelectedIndex()	;
			//Vector���� ���õ� ��� �����´�.
			MemberBean bean = vlist.get(i);
			if(mgr.deleteMemvber(bean.getIdx())) {
				//��������
				p2.removeAll();
				remove(p2);
				list.removeAll();
				remove(list);
				//Vector �� ����� ������ ��� ����
				vlist.removeAllElements();
				viewList();
			}
		} else if (obj == b3/* �Է� */) {
			p2.removeAll();
			list.removeAll();
			remove(list);
			insertForm();
		} else if (obj == b4/* ����Ʈ */) {
			p2.removeAll();
			remove(p2);
			list.removeAll();
			remove(list);
			vlist.removeAllElements();
			viewList();
		} else if (obj == insBtn/* ���� */) {
			MemberBean bean = new MemberBean();
			bean.setName(tf1.getText());
			bean.setPhone(tf2.getText());
			bean.setTeam(tf3.getText());
			if(mgr.insertMember(bean)) {
				//������ ���� 
				p2.removeAll();
				remove(p2);
				vlist.removeAllElements();
				viewList();
			}
		} else if (obj == upBtn/* ����(DB) */) {
			MemberBean bean = new MemberBean();
			bean.setIdx(idx);
			bean.setName(tf1.getText());
			bean.setPhone(tf2.getText());
			bean.setTeam(tf3.getText());
			if(mgr.updateMember(bean)) {
				//������ ���� 
				p2.removeAll();
				remove(p2);
				vlist.removeAllElements();
				viewList();
			}
		}
		validate();// frame�� �ٽ� �׸���.
	}

	public static void main(String[] args) {
		new MemberSwing();
	}
}
