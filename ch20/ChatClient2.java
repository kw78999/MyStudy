package ch20;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ChatClient2 extends MFrame 
implements ActionListener, Runnable {

	Button bt1, bt2, bt3, bt4;
	TextField tf1, tf2, tf3;
	TextArea area;
	List list;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String listTitle = "*******��ȭ�ڸ��*******";
	boolean flag = false;

	public ChatClient2() {
		super(450, 500);
		setTitle("ChatClient 2.0");
		Panel p1 = new Panel();
		p1.add(new Label("Host", Label.RIGHT));
		p1.add(tf1 = new TextField("127.0.0.1"));
		p1.add(new Label("Port", Label.RIGHT));
		p1.add(tf2 = new TextField("8002"));
		bt1 = new Button("connect");
		bt1.addActionListener(this);
		p1.add(bt1);
		add(BorderLayout.NORTH, p1);
		// //////////////////////////////////////////////////////////////////////////////////////////
		area = new TextArea("ChatClient 2.0");
		area.setBackground(Color.DARK_GRAY);
		area.setForeground(Color.PINK);
		area.setEditable(false);
		add(BorderLayout.CENTER, area);
		// /////////////////////////////////////////////////////////////////////////////////////////
		Panel p2 = new Panel();
		p2.setLayout(new BorderLayout());
		list = new List();
		list.add(listTitle);
		p2.add(BorderLayout.CENTER, list);
		Panel p3 = new Panel();
		p3.setLayout(new GridLayout(1, 2));
		bt2 = new Button("Save");
		bt2.addActionListener(this);
		bt3 = new Button("Message");
		bt3.addActionListener(this);
		p3.add(bt2);
		p3.add(bt3);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		Panel p4 = new Panel();
		tf3 = new TextField("", 50);
		tf3.addActionListener(this);
		bt4 = new Button("send");
		bt4.addActionListener(this);
		p4.add(tf3);
		p4.add(bt4);
		add(BorderLayout.SOUTH, p4);
		validate();
	}
	public void run() {
		try {
			int port = Integer.parseInt(tf2.getText());
			sock = new Socket(tf1.getText(),port);
			in = new BufferedReader(
					new InputStreamReader(
							sock.getInputStream()));
			out = new PrintWriter(
					sock.getOutputStream(),true);
			//����Ͻ� ���̵� �Է��ϼ���.
			area.append(in.readLine()+"\n");
			while(true){
				String line = in.readLine();
				if(line==null){
					break;
				}else {
					routine(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt1/*connect*/) {
			bt1.setEnabled(false);
			tf1.setEnabled(false);
			tf2.setEnabled(false);
			new Thread(this).start();
			area.setText("");
		}else if(obj==bt2/*save*/) {
			String str = area.getText();
			try {
				FileWriter fw =
						new FileWriter("ch20/"+System.currentTimeMillis()+".txt");
				fw.write(str);
				fw.flush();
				fw.close();
				area.setText("");
				new MDialog(this,"Save","��ȭ ������ �����Ͽ����ϴ�.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(obj==bt3/*message*/) {
			new Message("TO:");
		}else if(obj==bt4/*send*/||obj==tf3) {
			String str = tf3.getText();
			if(filterMgr(str)) {
				new MDialog(this,"���","�Է��Ͻ� ���ڴ� �������Դϴ�.");
				return;
			}
			if(!flag) /*���̵� �Է� �϶�*/{
				sendMessage(ChatProtocol2.ID+":"+str);
				setTitle(getTitle()+" - " +str+"�� �ݰ����ϴ�.");
				area.setText("");
				tf3.setText("");
				tf3.requestFocus();
				flag = true;
			}else/*�Ϲ� ä��*/ {
				int i = list.getSelectedIndex();
				if(i==-1||i==0)/*��ü ä��*/ {
					sendMessage(ChatProtocol2.CHATALL+":"+str);
				}else/*�ӼӸ�*/ {
					String id = list.getSelectedItem();
					sendMessage(ChatProtocol2.CHAT+":"+id+";"+str);
				}
				tf3.setText("");
				tf3.requestFocus();
			}
		}
	}//----------actionPerformed

	public void routine(String line) {
		int idx = line.indexOf(':');
		String cmd = line.substring(0,idx);
		String data = line.substring(idx+1 ); 
		if(cmd.equals(ChatProtocol2.CHATLIST)) {
			//data : aaa;bbb;ccc;
			StringTokenizer st = new StringTokenizer(data,";");
			list.removeAll();
			list.add(listTitle);
			while(st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
		}else if(cmd.equals(ChatProtocol2.CHAT)||
				(cmd.equals(ChatProtocol2.CHATALL))) {
			area.append(data+ "\n");
		}else if(cmd.equals(ChatProtocol2.MESSAGE)) {
			//data - bbb ; �����. 
	        	idx = data.indexOf(':');
			 cmd = data.substring(0,idx); //bbb
			 data = data.substring(idx+1 ); //�����
			 new Message("FROM",cmd,data);
		}
	}//routine
	
	public void sendMessage(String msg) {
		out.println(msg);
	}

	public boolean filterMgr(String msg){
		boolean flag = false;//false�̸� ������ �ƴ�
		String str[] = {"�ٺ�","������","����","�ڹ�","java"};
		//���� ȣȣ ����
		StringTokenizer st = new StringTokenizer(msg);
		String msgs[] = new String[st.countTokens()];
		for (int i = 0; i < msgs.length; i++) {
			msgs[i] = st.nextToken();
		}
		for (int i = 0; i < str.length; i++) {
			if(flag) break;
			for (int j = 0; j < msgs.length; j++) {
				if(str[i].equals(msgs[j])){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	

	class Message extends Frame implements ActionListener {

		Button send, close;
		TextField name;
		TextArea ta;
		String mode;// to/from
		String id;

		public Message(String mode) {
			setTitle("����������");
			this.mode = mode;
			id = list.getSelectedItem();
			layset("");
			validate();
		}
		public Message(String mode, String id, String msg) {
			setTitle("�����б�");
			this.mode = mode;
			this.id = id;
			layset(msg);
			validate();
		}
		public void layset(String msg) {
			 addWindowListener(new WindowAdapter() {
				   public void windowClosing(WindowEvent e) {
				    dispose();
				   }
			});
			Panel p1 = new Panel();
			p1.add(new Label(mode, Label.CENTER));
			name = new TextField(id, 20);
			p1.add(name);
			add(BorderLayout.NORTH, p1);
			
			ta = new TextArea("");
			add(BorderLayout.CENTER, ta);
			ta.setText(msg);
			Panel p2 = new Panel();
			if (mode.equals("TO:")) {
				p2.add(send = new Button("send"));
				send.addActionListener(this);
			}
			p2.add(close = new Button("close"));
			close.addActionListener(this);
			add(BorderLayout.SOUTH, p2);
			
			setBounds(200, 200, 250, 250);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==send){
				sendMessage(ChatProtocol2.MESSAGE+
						":"+id+";"+ ta.getText());
			}
			setVisible(false);
			dispose();
		}
	}

	class MDialog extends Dialog implements ActionListener{
		
		Button ok;
		ChatClient2 ct2;
		
		public MDialog(ChatClient2 ct2,String title, String msg) {
			super(ct2, title, true);
			this.ct2 = ct2;
			 //////////////////////////////////////////////////////////////////////////////////////////
			   addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent e) {
			     dispose();
			    }
			   });
			   /////////////////////////////////////////////////////////////////////////////////////////
			   setLayout(new GridLayout(2,1));
			   Label label = new Label(msg, Label.CENTER);
			   add(label);
			   add(ok = new Button("Ȯ��"));
			   ok.addActionListener(this);
			   layset();
			   setVisible(true);
			   validate();
		}
		
		public void layset() {
			int x = ct2.getX();
			int y = ct2.getY();
			int w = ct2.getWidth();
			int h = ct2.getHeight();
			int w1 = 150;
			int h1 = 100;
			setBounds(x + w / 2 - w1 / 2, 
					y + h / 2 - h1 / 2, 200, 100);
		}

		public void actionPerformed(ActionEvent e) {
			tf3.setText("");
			dispose();
		}
	}
	
	public static void main(String[] args) {
		new ChatClient2();
	}
}