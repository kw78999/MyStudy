package JAVAP;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChartPanel02 extends JPanel {
	Color beige = new Color(255, 229, 178);//#ffe5b2
	Color skyBlue = new Color(89, 158, 255);//#599eff
	Color ashe = new Color(212, 212, 212);//#d4d4d4
	Color magenta = new Color(255, 0, 255);//ff00ff
	
	public ChartPanel02() {
		Draw2 drawP2 = new Draw2();	//아래에 클래스로 만들어 둔 그래프 패널
		JLabel lb3;  									//그래프 Y축 단위표기
		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"독서왕");//패널 외곽선 꾸미기 정의
		tB2.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 15));
		Font lbFont = new Font("Times", Font.ITALIC, 12);// Y축 단위 폰트 정의
		Font infoFont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 12);
		//그래프 패널 오른쪽에 담을 정보패널(막대색깔 아이콘, 이름)////////////////////////////////
		JPanel info = new JPanel();
		info = new JPanel();
		info.setLayout(null);
		info.setBounds(380, 20, 180, 280);
		info.setBackground(Color.WHITE);
		//////////////////////////////////////////////////////////////////
		//그래프 막대 범례 (패널 우측 정보소패널에 들어갈 아이콘과 이름)/////////////////////////////
		ImageIcon iconColor[] = {
				new ImageIcon("graphEx3/copy/magenta.png"),
				new ImageIcon("graphEx3/copy/skyblue.png"),
				new ImageIcon("graphEx3/copy/beige.png"),
				new ImageIcon("graphEx3/copy/ashe.png")};
		String name[] = {"천행운", "최민석", "이경준", "회원 평균"};
		JLabel lbName[] = new JLabel[4];
		JLabel lbIcon[] = new JLabel[4];
		for (int i = 0; i < iconColor.length; i++) {//정보패널에 막대 색깔아이콘과 이름을 붙일 반복문
			lbIcon[i] = new JLabel(iconColor[i]);			//아이콘
			lbIcon[i].setBounds(63, 20+20*i, 12, 12);
			info.add(lbIcon[i]);
			lbName[i] = new JLabel(name[i]);				//이름
			lbName[i].setBounds(80, 20+20*i, 100, 12);
			lbName[i].setFont(infoFont);
			info.add(lbName[i]);
		}////////////////////////////////////////////////////////////////
		//Y축에 들어갈 값들/////////////////////////////////////////////////////
		String point[] = {"  3","  6","  9","12","15"};
		JLabel lbPoint[] = new JLabel[5];
		for (int i = 0; i < lbPoint.length; i++) {
			lbPoint[i] = new JLabel(point[i]);
			lbPoint[i].setBounds(60, 220-30*i, 20, 10);
			drawP2.add(lbPoint[i]);
		}////////////////////////////////////////////////////////////////
		//그래프 그리기 패널/////////////////////////////////////////////////////
		drawP2.setBorder(tB2);
		drawP2.setLayout(null);
		drawP2.setBounds(10, 10, 570, 310);
		drawP2.setBackground(Color.WHITE);
		/////////////////////////////////////////////////////////////////
		lb3 = new JLabel("(단위: 권)");
		lb3.setFont(lbFont);
		lb3.setBounds(20, 80, 100, 18);
		
		drawP2.add(lb3);
		drawP2.add(info);
		add(drawP2);
		
		setVisible(true);
		setBackground(Color.WHITE);
	}
	class Draw2 extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int readGold = 15; //막대1 값 DB에서 지난 달 대출한 권수 가져오기
			int readSilver = 14;//2
			int readBronze = 13;//3
			int readAVG = 8;//평균
			
			Graphics2D g2=(Graphics2D)g;//XY축 선두께
			g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));
			g2.setColor(Color.LIGHT_GRAY);
			g2.drawLine(70,250+1,370,250+1);//X축. 그래프와 Y좌표가 같으면 막대 아래와 X축이 겹쳐지기 때문에 X축의 Y좌표를 +1 해준다.
			//그래프 내부 구분선///////////////////////////////////////////////////////////
			g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE,0));
			g2.setColor(new Color(228, 235, 247));
			for (int i = 0; i < 5; i++) {
				g2.drawLine(80, 220-30*i, 360, 220-30*i);
			}//////////////////////////////////////////////////////////////////////
			//대조군 (전체회원 평균 독서량)////////////////////////////////////////////////////
			g2.setColor(ashe);
			g2.fillRect(80+60, 250-readAVG*10, 20, readAVG*10); //시작점과 높이에 변수랑 수식 해야함
			g2.fillRect(80+140, 250-readAVG*10, 20, readAVG*10); //규칙적으로 늘어남
			g2.fillRect(80+220, 250-readAVG*10, 20, readAVG*10);//Y 시작점을 축의 길이에서 빼야 위에서 아래로 그리는 공식
			
			//막대 1
			g2.setColor(magenta);
			g2.fillRect(80+40, 250-readGold*10, 20, readGold*10); //*10을 해서 1권이 1px이 아닌 10px만큼 높아지게 보정해주는 공식
			
			//막대 2
			g2.setColor(skyBlue);
			g2.fillRect(80+120, 250-readSilver*10, 20, readSilver*10);
			
			//막대 3
			g2.setColor(beige);
			g2.fillRect(80+200, 250-readBronze*10, 20, readBronze*10);
		}
	}
}
