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
		setTitle("회원관리 프로그램");
		mgr = new MemberMgr();
		p1 = new JPanel();
		p2 = new JPanel();
		label = new JLabel("");
		add(label, BorderLayout.PAGE_START);
		b1 = new JButton("수정");
		b2 = new JButton("삭제");
		b3 = new JButton("입력");
		b4 = new JButton("리스트");
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

	// DB에 연결해서 리스트를 List객체 add한다.
	public void viewList() {
		label.setOpaque(true);//배경색 변경
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
		//아이템이 하나이상일 경우 0번째 인덱스 셀렉하여 실행
		if(list.getItemCount()>0)
			list.select(0);
	}

	// 회원입력폼
	public void insertForm() {
		label.setText("회원입력폼");
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
		insBtn = new JButton("저장");
		insBtn.addActionListener(this);
		p6.add(insBtn);
		p2.add(p6);

		add(p2, BorderLayout.CENTER);
	}

	// 회원수정폼
	public void updateForm(MemberBean bean) {
		label.setText("회원수정폼");
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
		upBtn = new JButton("수정저장");
		upBtn.addActionListener(this);
		p6.add(upBtn);
		p2.add(p6);

		add(p2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b1/* 수정 */) {
			//list에서 선택된 아이템 index값 
			int i = list.getSelectedIndex();
			//System.out.println(i);
			MemberBean bean = vlist.get(i);
			//기존 list에 있는 아이템 모두 삭제
			list.removeAll();
			//Frame에 저장했던 list도 삭제
			remove(list);
			updateForm(bean);
		} else if (obj == b2/* 삭제 */) {
			int i = list.getSelectedIndex()	;
			//Vector에서 선택된 빈즈를 가져온다.
			MemberBean bean = vlist.get(i);
			if(mgr.deleteMemvber(bean.getIdx())) {
				//삭제성공
				p2.removeAll();
				remove(p2);
				list.removeAll();
				remove(list);
				//Vector 에 저장된 아이템 모두 삭제
				vlist.removeAllElements();
				viewList();
			}
		} else if (obj == b3/* 입력 */) {
			p2.removeAll();
			list.removeAll();
			remove(list);
			insertForm();
		} else if (obj == b4/* 리스트 */) {
			p2.removeAll();
			remove(p2);
			list.removeAll();
			remove(list);
			vlist.removeAllElements();
			viewList();
		} else if (obj == insBtn/* 저장 */) {
			MemberBean bean = new MemberBean();
			bean.setName(tf1.getText());
			bean.setPhone(tf2.getText());
			bean.setTeam(tf3.getText());
			if(mgr.insertMember(bean)) {
				//저장을 성공 
				p2.removeAll();
				remove(p2);
				vlist.removeAllElements();
				viewList();
			}
		} else if (obj == upBtn/* 수정(DB) */) {
			MemberBean bean = new MemberBean();
			bean.setIdx(idx);
			bean.setName(tf1.getText());
			bean.setPhone(tf2.getText());
			bean.setTeam(tf3.getText());
			if(mgr.updateMember(bean)) {
				//저장을 성공 
				p2.removeAll();
				remove(p2);
				vlist.removeAllElements();
				viewList();
			}
		}
		validate();// frame을 다시 그리다.
	}

	public static void main(String[] args) {
		new MemberSwing();
	}
}
