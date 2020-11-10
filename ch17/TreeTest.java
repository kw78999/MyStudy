package ch17;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeTest extends JFrame 
implements TreeSelectionListener{
	
	JTree tree;
	JLabel label;
	DefaultTreeModel model;
	
	public TreeTest() {
		setTitle("TreeTest");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode root = 
				new DefaultMutableTreeNode("나의 문서함");
		DefaultMutableTreeNode ch1 = new DefaultMutableTreeNode("편지");
		DefaultMutableTreeNode ch2 = new DefaultMutableTreeNode("음악");
		DefaultMutableTreeNode ch3 = new DefaultMutableTreeNode("한국");
		DefaultMutableTreeNode ch4 = new DefaultMutableTreeNode("전통");
		DefaultMutableTreeNode ch5 = new DefaultMutableTreeNode("힙팝");
		DefaultMutableTreeNode ch6 = new DefaultMutableTreeNode("외국");
		DefaultMutableTreeNode ch7 = new DefaultMutableTreeNode("소설");
		DefaultMutableTreeNode ch8 = new DefaultMutableTreeNode("추리");
		root.add(ch1);
		root.add(ch2);
		root.add(ch7);
		ch2.add(ch3);
		ch2.add(ch6);
		ch3.add(ch4);
		ch3.add(ch5);
		ch7.add(ch8);
		
		tree = new JTree(root);
		//보여지는 행의 갯수가 10
		tree.setVisibleRowCount(10);
		tree.addTreeSelectionListener(this);
		JPanel p = new JPanel();
		JScrollPane sc = new JScrollPane(tree);
		p.add(sc);
		p.add(label = new JLabel());
		add(p);
		setVisible(true);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		//선택한 노드를 리턴한다.
		DefaultMutableTreeNode node = 
				(DefaultMutableTreeNode)
				tree.getLastSelectedPathComponent();
		if(node==null)
			return;
		String s = (String)node.getUserObject();
		label.setText(s);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.
			//setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			//setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TreeTest();
	}
}



