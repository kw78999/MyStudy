package ch19;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class URLFrameEx1 extends MFrame implements ActionListener {
	
	TextArea ta;
	TextField tf;
	Button connect;
	Button save;
	URL url;
	FileDialog saveDialog;
	
	public URLFrameEx1() {
		super(500, 500);
		setTitle("ViewHost");
		Panel p = new Panel();
		p.add(tf = new TextField("http://auction.co.kr", 40));
		p.add(connect = new Button("connect"));
		p.add(save = new Button("save"));
		ta = new TextArea();
		add("North", p);
		add("Center", ta);
		connect.addActionListener(this);
		save.addActionListener(this);
		tf.addActionListener(this);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String host = tf.getText();
		if(obj==tf||obj==connect) {
			ta.setText("");
			save.setEnabled(true);
			connectHost(host);
		}else if(obj==save) {
			createFile(host, ta.getText());
			save.setEnabled(false);
			tf.setText("http://");
			ta.setText("");
			ta.append("저장하였습니다.");
			tf.requestFocus();
		}
	}

	public void connectHost(String host) {
		try {
			url = new URL(tf.getText());
			 BufferedReader br = 
					  new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		 String line = "";
			  while(true) {
				  line = br.readLine();
				  if(line==null)break;
				 ta.append(line+"\n");
				 
			 
		} 
			  }catch (Exception e) {
			ta.append("해당된 호스트가 없습니다.");
		}
	}
	
	//file : host.txt => auction.co.kr.txt
	public void createFile(String host, String content) {
		try {
			host = host.substring(7);
			//FileWriter 는 파일이 생성됨 
			FileWriter fw = new FileWriter("ch19/"+host+".txt");
			fw.write(content)	;
			fw.flush();
			fw.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new URLFrameEx1();
	}
}
