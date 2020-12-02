package ch17;

import java.awt.*;       // Dimension, BorderLayout
import java.awt.event.*; // ActionListener
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
class ChoiceItemPane extends JPanel
                     implements ActionListener, 
                                ChangeListener,
                                ListSelectionListener
{
 JComboBox combo;
    JList list;
    JSlider slider;
    JScrollPane scrollList;
    JRadioButton button1, button2, button3;
    JCheckBox check;
    JTextField result;
    
    public ChoiceItemPane()
    {
        setReady();
    }
    public void stateChanged(ChangeEvent e) 
    {
        int value = ((JSlider)e.getSource()).getValue();
        result.setText("(" + value + ")로 조절됨.");
 }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() instanceof JComboBox)
        {
            int si = ((JComboBox)e.getSource()).getSelectedIndex();
            String selected = si + " : " + ((JComboBox)e.getSource()).getSelectedItem();
            result.setText(selected);
            list.setSelectedIndex(si);
        }
        else if (e.getSource() instanceof JRadioButton)
        {
            JRadioButton obj = (JRadioButton)e.getSource();
            if (obj.isSelected())
                result.setText("(" + obj.getText() + ")이 선택됨.");
        }
        else if (e.getSource() instanceof JCheckBox)
        {
            JCheckBox obj = (JCheckBox)e.getSource();
            if (obj.isSelected())
                result.setText("(" + obj.getText() + ")이 선택됨.");
            else result.setText("(" + obj.getText() + ")이 선택 해제됨.");
        }
    }
    public void valueChanged(ListSelectionEvent e)
    {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        int firstIdx = lsm.getMinSelectionIndex();
        int lastIdx = lsm.getMaxSelectionIndex();
        String selected = "Selected Index : ";
        
        for (int i = firstIdx; i <= lastIdx; i++) // 다중 선택을 지원
        {
            if (lsm.isSelectedIndex(i))
            {
               selected += i + " ";
            }
        }
        result.setText(selected);
        combo.setSelectedIndex(firstIdx);
    }
    public void setReady()
    {
        createComponent();
        layoutComponent();
    }
    protected void createComponent()
    {
        // 콤보박스와 리스트
        String items[] = { "국어", "영어", "산수", "사회", "자연", "도덕" };
        // 콤보 박스
        combo = new JComboBox();
        for (int i = 0; i < items.length; i++) combo.addItem(items[i]);
        combo.addActionListener(this);
        // 리스트는 다중 항목 선택 및 스크롤바를 직접 지원하지 않는다.
        list = new JList(items);
        list.setVisibleRowCount(5);
  ListSelectionModel lsModel = list.getSelectionModel();
        lsModel.setSelectionMode(
                        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        // ListSelectionModel.SINGLE_SELECTION);
                        // ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lsModel.addListSelectionListener(this);
        scrollList = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                           ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                                           
        // 수평 슬라이드 생성 및 이벤트 리스너 추가
     slider = new JSlider(JSlider.HORIZONTAL, -5, 5, 1);
        slider.addChangeListener(this);
        // 주, 부 눈금 간격 설정
        slider.setMajorTickSpacing(5);
     slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        // 레이블을 위한 테이블 생성
        java.util.Hashtable labelTable = new java.util.Hashtable();
        labelTable.put( new Integer( -5 ), new JLabel("불황") );
        labelTable.put( new Integer( 0 ), new JLabel("?") );
        labelTable.put( new Integer( 5 ), new JLabel("호황") );
        slider.setLabelTable( labelTable );
        slider.setPaintLabels(true);
        // 슬라이드 홈 채우기 : (default : 없음)
     slider.putClientProperty( "JSlider.isFilled", Boolean.TRUE );
        // 어중간한 눈금을 조정해 준다.
      slider.setSnapToTicks( true );
        // text&image 라디오 버튼
        ImageIcon radio = new ImageIcon("radio.gif"); // red
        ImageIcon radioSelected = new ImageIcon("radioSelected.gif"); // blue
        ImageIcon radioPressed = new ImageIcon("radioPressed.gif"); // yellow
     
     button1 = new JRadioButton("FlatFile", radio);
     button1.setToolTipText("Save flat files only");
     button1.setSelected(true);
     button1.setSelectedIcon(radioSelected);
     button1.setPressedIcon(radioPressed);
  button1.setFocusPainted(false);
        button1.addActionListener(this);
     button2 = new JRadioButton("DataBase", radio);
     button2.setToolTipText("Save data base only");
     button2.setSelectedIcon(radioSelected);
     button2.setPressedIcon(radioPressed);
  button2.setFocusPainted(false);
        button2.addActionListener(this);
     button3 = new JRadioButton("Files & DB", radio);
     button3.setToolTipText("Save both flat file and data base");
     button3.setSelectedIcon(radioSelected);
     button3.setPressedIcon(radioPressed);
  button3.setFocusPainted(false);
        button3.addActionListener(this);
        ButtonGroup group = new ButtonGroup();
     group.add(button1);
     group.add(button2);
     group.add(button3);
        // 체크 박스
        ImageIcon chks1 = new ImageIcon("printer3.gif");
        ImageIcon chks2 = new ImageIcon("printer1.gif");
        ImageIcon chks3 = new ImageIcon("printer2.gif");
        check = new JCheckBox("프린터 사용", chks1);
     check.setSelectedIcon(chks2);
     check.setDisabledIcon(chks3);
        check.addActionListener(this);
        result = new JTextField("");
    }
    protected void layoutComponent()
    {
        setLayout(new BorderLayout(10,10));
  setBorder(new EmptyBorder(10,10,10,10));
        // 콤보박스, 리스트와 슬라이더
        JPanel selectPane = new JPanel();
        selectPane.setLayout(new GridLayout(0,2,10,10));
        JPanel choicePane = new JPanel();
  choicePane.setBorder(new EmptyBorder(10,10,10,10));
  JPanel sp = new JPanel();
     sp.setLayout(new BoxLayout(sp, BoxLayout.Y_AXIS));
     sp.setBorder(new TitledBorder("차기 경기 전망"));
     sp.add(Box.createRigidArea(new Dimension(1,5)));
     sp.add(slider);
  choicePane.add(combo);
        choicePane.add(scrollList);
        choicePane.add(sp);
        // 라디오 버튼과 체크 박스
        Dimension hpad10 = new Dimension(10,1);
        JPanel rightPane = new JPanel();
  rightPane.setBorder(new EmptyBorder(10,10,10,10));
        // 라디오 버튼        
        Font boldFont = new Font("Dialog", Font.BOLD, 12);
     JPanel radioPane = createVerticalPanel(true);
        radioPane.setAlignmentX(LEFT_ALIGNMENT);
        TitledBorder buttonBorder = new TitledBorder(null, "Backup facilities", 
                TitledBorder.LEFT, TitledBorder.TOP,
                boldFont);
     Border emptyBorder = new EmptyBorder(5,5,5,5);
     CompoundBorder compoundBorder = new CompoundBorder(buttonBorder, emptyBorder);
        radioPane.setBorder(compoundBorder);
        radioPane.add(button1);
     radioPane.add(Box.createRigidArea(hpad10));
     radioPane.add(button2);
     radioPane.add(Box.createRigidArea(hpad10));
     radioPane.add(button3);
     radioPane.add(Box.createHorizontalBox());
        // 체크 박스
        rightPane.add(radioPane);
        Dimension vpad10 = new Dimension(1,10);
        rightPane.add(Box.createRigidArea(vpad10));
     rightPane.add(check);
        selectPane.add(choicePane);
        selectPane.add(rightPane);
        add(selectPane, BorderLayout.CENTER);
        add(result, BorderLayout.SOUTH);
    }
    public static JPanel createVerticalPanel(boolean threeD) 
    {
     JPanel p = new JPanel();
     p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
     if(threeD) {
         p.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
     } 
     return p;
    }
    public static void main(String[] args) 
 {
        JFrame jf = new JFrame("Example Choice Item");
        ChoiceItemPane ci = new ChoiceItemPane();
        jf.getContentPane().add(ci, BorderLayout.CENTER);
        jf.setSize(320, 240);
        jf.setVisible(true);
 }
}


