package JAVAP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicChartEx1 {
	
	DrawPanel draw = new DrawPanel();
	JPanel panel1, panel2,mpanel;
	JLabel lb1, lb2, lb3;
	Font infoFont;
	int read;
	int AVGread;
	
	public GraphicChartEx1() {
		/*setTitle("그래프");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setContentPane(chartPanel);//애드패널로 대체. 차이점은 무엇인지?
		setSize(1200, 800);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);*/
		
		panel1 = new JPanel();
		panel1.setBounds(900, 0, 300, 520);
		panel1.setBackground(Color.CYAN);
		mpanel = new JPanel();
		mpanel.setLayout(null);
		
		String s = "천행운"; 	//독서왕 이름 DB에서 가져오기
		lb1 = new JLabel("이 달의 독서왕은 "+s+"님 입니다.");
		lb1.setBounds(10, 10, 500, 20);
		
		read = 25; 			//독서왕 독서량 DB연동
		lb2 = new JLabel(s+"님이 읽은 책은 "+read+"권 입니다.");
		lb2.setBounds(10, 30, 500, 20);
		
		AVGread = 12;		//도서관 평균 독서량 DB연동
		lb3 = new JLabel("평균 독서량은 "+AVGread+"권 입니다.");
		lb3.setBounds(10, 50, 500, 20);
		
		infoFont = new Font("Times", Font.BOLD, 18);
		lb1.setFont(infoFont);
		lb2.setFont(infoFont);
		lb3.setFont(infoFont);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 520, 1200, 280);
		
		panel2.add(lb1);
		panel2.add(lb2);
		panel2.add(lb3);
		
		draw.setBounds(0, 0, 900, 520);
		draw.setBackground(Color.LIGHT_GRAY);
		
		
		mpanel.add(draw);
		mpanel.add(panel1);
		mpanel.add(panel2);
	}
	
	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);	//그래프 축
			g.drawLine(140, 20, 140, 400); //Y축
			g.drawLine(140, 400, 800, 400);//X축
			
			g.setColor(Color.WHITE); //데이터 1
			g.drawLine(405, 500, 420, 500);
			g.fillRect(500, 500, 20, 10);
			
			g.fillRect(140+40, 400-read*5, 30, read*5);	//독서왕 독서량 그래프
			g.drawRect(140+69, 399-AVGread*5, 25, AVGread*5);//대조군(평균) 그래프
			
			g.setColor(Color.BLUE);
			
		
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicChartEx1();
		
	}

}
