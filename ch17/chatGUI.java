package ch17;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
public class chatGUI {
  public static void main(String[] args) {
    // Frame ���� �� �߰�
    // Frame ���� ����ǥ���ٿ� Chat Room�� ǥ�õǵ��� �մϴ�.
    JFrame f = new JFrame("Chat Room");
    // Frame�� ����� �������� ���ϵ��� �մϴ�.
    f.setResizable(false);
    // Ÿ��Ʋ���� icon �̹����� �����մϴ�. 
    f.setIconImage(new ImageIcon("images/st.gif").getImage());
    // â�� ������ ���α׷��� ����ǵ��� �մϴ�.
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // �г� ���� �� �߰�
    // �г� ��ü�� �ΰ� �����ߴ�.
    JPanel upperPanel = new JPanel();  
    JPanel lowerPanel = new JPanel();
    
    //�� �Ʒ� �г��� ������ Ȯ���ϱ� ���ؼ� �гο� ������ �־���.
    upperPanel.setBackground(Color.gray);
    lowerPanel.setBackground(Color.pink);
    
    //frame �������ϰ�� �ټ� �������� �������� �� ���ʿ� upperPanel�� ���� �ְ�
    //�Ʒ��ʿ� lowerPanel�� ���� �־���.
    f.getContentPane().add(upperPanel, "North");
    f.getContentPane().add(lowerPanel, "South");
     // TextArea ���� �� �߰�
    // TextArea�� content�� ����Ű�� ���ڿ��� ǥ���ϰ� 50��, 50���� �����մϴ�.      
    JTextArea ta = new JTextArea(content, 50, 50);
    //�� �ѱ�� ��� �ѱ�
    ta.setLineWrap(true);
    //�� �ѱ� �� ���� ������ �ܾ ���࿡ ���� ������ �ʵ��� �ϱ�
    ta.setWrapStyleWord(true);
    // ������ �Ұ����ϵ��� ����
    ta.setEditable(true);
    // TextArea�� �׵θ����� ���� ���� �α��� 3px�� �����մϴ�.
    Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
    // �ؽ�Ʈ�� TextArea ��� ���̿� ������ �α� ���ؼ� emptyBorder�� �����մϴ�. 
    Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
    //TextArea�� lineBorder(�����׵θ�), emptyBorder(����)�� ������ ���� ��輱�� �����մϴ�.
    ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
    // TextArea�� ��ũ�� ����� �߰��� �� Panel�ȿ� ���� �ֽ��ϴ�.
    upperPanel.add(new JScrollPane(ta));
    // TextField ���� �� �߰�
    // TextField�� �ؽ�Ʈ �Է��̶�� ���ڿ��� ǥ���ϰ� 40���� �����մϴ�.
    JTextField tf = new JTextField("�ؽ�Ʈ �Է�", 40);
    //TextField�� ���� �����ϰ� �ʹٸ� Font Size�� �����ϸ� �ȴ�.
    // Font��, ����, ũ�⸦ �����ϰ� Font ��ü�� �����մϴ�.
    Font font = new Font("arian", Font.BOLD, 15);
    // TextField�� font�� �����մϴ�.
    tf.setFont(font);
    // TextField�� Bevel ��輱�� �����մϴ�. ���̶���Ʈ�� �κ��� ȸ������ �����κ��� �ʷϻ����� �����մϴ�.
    tf.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.gray, Color.gray));
    // �гο� TextField �߰��մϴ�.
    lowerPanel.add(tf);
    // button ���� �� �߰�
    // �����̶�� �ؽ�Ʈ�� ǥ�õǴ� ��ư ����
    JButton button = new JButton("����");
    // ��ư�� �Ʒ� �гο� �߰�
    lowerPanel.add(button);
    // frame �ȿ� �ִ� ��� ������� ���̵��� frame ����� �����մϴ�.
    f.pack();
    // frame�� ���̵��� �����մϴ�.
    f.setVisible(true);
  }
    static String content = "�ȳ��ϼ���.\n"
      + "�̰��� �ؽ�Ʈ�� ǥ�õ˴ϴ�. " + "�����մϴ�.\n";
}
