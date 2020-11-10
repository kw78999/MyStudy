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
    // Frame 설정 및 추가
    // Frame 생성 제목표시줄에 Chat Room이 표시되도록 합니다.
    JFrame f = new JFrame("Chat Room");
    // Frame의 사이즈를 변경하지 못하도록 합니다.
    f.setResizable(false);
    // 타이틀바의 icon 이미지를 지정합니다. 
    f.setIconImage(new ImageIcon("images/st.gif").getImage());
    // 창을 닫으면 프로그램이 종료되도록 합니다.
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 패널 설정 및 추가
    // 패널 객체를 두개 생성했다.
    JPanel upperPanel = new JPanel();  
    JPanel lowerPanel = new JPanel();
    
    //위 아래 패널의 영역을 확인하기 위해서 패널에 배경색을 주었다.
    upperPanel.setBackground(Color.gray);
    lowerPanel.setBackground(Color.pink);
    
    //frame 동서남북가운데 다섯 영역으로 구분했을 때 위쪽에 upperPanel을 집어 넣고
    //아래쪽에 lowerPanel을 집어 넣었다.
    f.getContentPane().add(upperPanel, "North");
    f.getContentPane().add(lowerPanel, "South");
     // TextArea 설정 및 추가
    // TextArea에 content가 가리키는 문자열을 표시하고 50행, 50열로 설정합니다.      
    JTextArea ta = new JTextArea(content, 50, 50);
    //행 넘기기 기능 켜기
    ta.setLineWrap(true);
    //행 넘길 때 행의 마지막 단어가 두행에 걸쳐 나뉘지 않도록 하기
    ta.setWrapStyleWord(true);
    // 편집이 불가능하도록 설정
    ta.setEditable(true);
    // TextArea의 테두리선의 색을 검정 두깨를 3px로 설정합니다.
    Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
    // 텍스트와 TextArea 경계 사이에 여백을 두기 위해서 emptyBorder를 생성합니다. 
    Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
    //TextArea에 lineBorder(검정테두리), emptyBorder(여백)로 구성된 복합 경계선을 설정합니다.
    ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
    // TextArea에 스크롤 기능을 추가한 후 Panel안에 집어 넣습니다.
    upperPanel.add(new JScrollPane(ta));
    // TextField 설정 및 추가
    // TextField에 텍스트 입력이라는 문자열을 표시하고 40열로 설정합니다.
    JTextField tf = new JTextField("텍스트 입력", 40);
    //TextField의 높이 조정하고 싶다면 Font Size를 변경하면 된다.
    // Font명, 굵기, 크기를 설정하고 Font 객체를 생성합니다.
    Font font = new Font("arian", Font.BOLD, 15);
    // TextField의 font를 설정합니다.
    tf.setFont(font);
    // TextField에 Bevel 경계선을 설정합니다. 하이라이트된 부분을 회색으로 음영부분을 초록색으로 설정합니다.
    tf.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.gray, Color.gray));
    // 패널에 TextField 추가합니다.
    lowerPanel.add(tf);
    // button 설정 및 추가
    // 전송이라는 텍스트가 표시되는 버튼 생성
    JButton button = new JButton("전송");
    // 버튼을 아래 패널에 추가
    lowerPanel.add(button);
    // frame 안에 있는 모든 내용들이 보이도록 frame 사이즈를 조정합니다.
    f.pack();
    // frame이 보이도록 설정합니다.
    f.setVisible(true);
  }
    static String content = "안녕하세요.\n"
      + "이곳에 텍스트가 표시됩니다. " + "감사합니다.\n";
}
