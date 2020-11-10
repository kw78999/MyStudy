package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame 
implements ListSelectionListener{
	
	private JLabel label;
	private JTextField selected;
	private JPanel panel;
	private JList list;
	private String[] cities = { "런던", "파리", "시드니", "로스엔젤레스", "뉴욕", "쮜리히", "벤쿠버" };

	
	public ListTest() {
		setTitle("ListTest");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1, p2;
		///////////////////////////////////////////
		list = new JList(cities);
		//list 경계선
		list.setBorder(
				BorderFactory.createLineBorder(Color.green,1));
		JScrollPane sc = new JScrollPane(list);
		sc.setPreferredSize(new Dimension(200,100));
		//단일모드 선택
		list.setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		p1 = new JPanel();
		p1.add(sc);
		///////////////////////////////////////////
		label = new JLabel("선택된 항목: ");
		selected = new JTextField(10);
		selected.setEditable(false);
		p2 = new JPanel();
		p2.add(label);
		p2.add(selected);
		//////////////////////////////////////////
		add(p1,BorderLayout.PAGE_START);
		add(p2,BorderLayout.CENTER);
		setVisible(true);
	}
	//ListSelectionListener
	@Override
	public void valueChanged(ListSelectionEvent e) {
		String city = (String)list.getSelectedValue();
		selected.setText(city);
	}
	
	public static void main(String[] args) {
		new ListTest();
	}

}
