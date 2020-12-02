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
	
	String colName[] ={"이름","주소","나이","가입여부"};
	String citys[] = {"서울","인천","대전","대구","부산","광주"};
	Object data[][] = {
			{"이연희 ","서울",28, false},
			{"문채원  ","인천",30, false},
			{"리지 ","부산",24, true}
	};
	JTable table;

	public SimpleTableTest() {
		setTitle("SimpleTableTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		table = new JTable(data, colName);
		//table에 이벤트 연결
		table.getModel().addTableModelListener(this);
		//컬럼헤터 클릭하면 자동정렬
		table.setAutoCreateRowSorter(true);
		//주소에 입력시 지정된 도시만 입력 가능하도록 편집
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
						"범위를 초과하였습니다: " + s, "경고", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		new SimpleTableTest();
	}
}




