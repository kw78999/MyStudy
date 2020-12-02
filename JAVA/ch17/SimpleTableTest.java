package ch17;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class SimpleTableTest extends JFrame 
implements TableModelListener{
	
	String colName[] ={"�̸�","�ּ�","����","���Կ���"};
	String citys[] = {"����","��õ","����","�뱸","�λ�","����"};
	Object data[][] = {
			{"�̿��� ","����",28, false},
			{"��ä��  ","��õ",30, false},
			{"���� ","�λ�",24, true}
	};
	JTable table;

	public SimpleTableTest() {
		setTitle("SimpleTableTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		table = new JTable(data, colName);
		//table�� �̺�Ʈ ����
		table.getModel().addTableModelListener(this);
		//�÷����� Ŭ���ϸ� �ڵ�����
		table.setAutoCreateRowSorter(true);
		//�ּҿ� �Է½� ������ ���ø� �Է� �����ϵ��� ����
		TableColumn city = table.getColumnModel().getColumn(1);
		JComboBox combo = new JComboBox();
		for (int i = 0; i < citys.length; i++) {
			combo.addItem(citys[i]);
		}
		city.setCellEditor(new DefaultCellEditor(combo));
		
		JScrollPane sc = new JScrollPane(table);
		add(sc);
		setVisible(true);
	}
	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		if(column==2){
			TableModel model = (TableModel)e.getSource();
			String cName = model.getColumnName(column);
			Object data = model.getValueAt(row, column);
			String s = (String)data;
			if(Integer.parseInt(s)>100){
				JOptionPane.showMessageDialog(this, 
						"������ �ʰ��Ͽ����ϴ�: " + s, "���", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		new SimpleTableTest();
	}
}




