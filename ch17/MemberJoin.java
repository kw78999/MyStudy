package ch17;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MemberJoin extends JFrame {
	JPanel pMain;
	JPanel[] p;
	// 아이디, 비밀번호, 핸드폰, 이메일, 주소, 성별, 이름, 생일, 자기소개, 취미
	JTextField tfId;
	JPasswordField pfPwd;
	JComboBox comboTel1;
	JTextField tfTel2, tfTel3;
	JTextField tfEmail;
	JTextField tfAddr;
	JRadioButton rMan, rWoman;
	JTextField tfName;
	JTextField tfBirth;
	JCheckBox cbMovie, cbMt, cbMusic, cbBook;
	JTextArea taIntro;
	JButton btnJoin, btnCancel;
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static final String USER = "scott";
	private static final String PASS = "tiger";

	public MemberJoin() {
		pMain = new JPanel();
		pMain.setLayout(new GridLayout(11, 1));
		add(pMain);
		p = new JPanel[11];
		for (int i = 0; i < p.length; i++) {
			p[i] = new JPanel();
			// p[i].setBackground(new Color(20*i, 10*i, i));
			pMain.add(p[i]);
		}// for
		p[0].add(new JLabel("아이디 : "));
		tfId = new JTextField(20);
		p[0].add(tfId);
		p[1].add(new JLabel("비밀번호 : "));
		pfPwd = new JPasswordField(20);
		p[1].add(pfPwd);
		p[2].add(new JLabel("핸드폰 : "));
		String[] tel1 = { "010", "011", "016", "017", "018", "019" };
		comboTel1 = new JComboBox(tel1);
		p[2].add(comboTel1);
		p[2].add(new JLabel("-"));
		tfTel2 = new JTextField(4);
		p[2].add(tfTel2);
		p[2].add(new JLabel("-"));
		tfTel3 = new JTextField(4);
		p[2].add(tfTel3);
		p[3].add(new JLabel("이메일 : "));
		tfEmail = new JTextField(20);
		p[3].add(tfEmail);
		p[4].add(new JLabel("주소 : "));
		tfAddr = new JTextField(20);
		p[4].add(tfAddr);
		p[5].add(new JLabel("성별 : "));
		rMan = new JRadioButton("남자", true);
		rWoman = new JRadioButton("여자");
		ButtonGroup group = new ButtonGroup();
		group.add(rMan);
		group.add(rWoman);
		p[5].add(rMan);
		p[5].add(rWoman);
		p[6].add(new JLabel("이름 : "));
		tfName = new JTextField(12);
		p[6].add(tfName);
		p[7].add(new JLabel("생일 : "));
		tfBirth = new JTextField(4);
		p[7].add(tfBirth);
		p[7].add(new JLabel("형식) MMDD "));
		p[8].add(new JLabel("취미 : "));
		cbMovie = new JCheckBox("영화");
		cbBook = new JCheckBox("독서");
		cbMt = new JCheckBox("등산");
		cbMusic = new JCheckBox("음악");
		p[8].add(cbMovie);
		p[8].add(cbBook);
		p[8].add(cbMt);
		p[8].add(cbMusic);
		p[9].add(new JLabel("자기 소개 : "));
		taIntro = new JTextArea(3, 20);
		JScrollPane pane = new JScrollPane(taIntro);
		p[9].add(pane);
		btnJoin = new JButton("가입");
		btnCancel = new JButton("취소");
		p[10].add(btnJoin);
		p[10].add(btnCancel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("회원 가입");
		setSize(400, 570);
		// pack(); // 자동으로 크기 지정
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			// 1. 자바 내장 룩앤필
			 //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

			// 2. quaqua.jar : Quaqua Look and Feel
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);

			// 3. liquidlnf.jar : Liquid Look and Feel
			 //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");

			// 4. idw-gpl.jar : InfoNode Look and Feel
			 //UIManager.setLookAndFeel("net.infonode.gui.laf.InfoNodeLookAndFeel");

			// 5. JTattoo.jar : JTattoo Look and Feel
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
		}
		new MemberJoin();
	}// main
}// end