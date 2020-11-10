package ch17;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

public class TableGridProb {

    public static void main(String[] args) {
    	try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }  catch (Exception e) { }
    	
        UIManager.put("Table.gridColor", new ColorUIResource(Color.gray));
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Table Grid Prob");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel leftPanel = new JPanel(new BorderLayout());
                JTree jt = new JTree();
                jt.expandRow(1);
                leftPanel.add(jt, BorderLayout.WEST);
                JTable table = new JTable(20, 1) {
                    @Override
                    public Dimension getPreferredScrollableViewportSize() {
                        return new Dimension(300, 200);
                    }
                };
                table.setBorder(new LineBorder(Color.green, 4));
                table.setTableHeader(null);
                leftPanel.add(new JScrollPane(table), BorderLayout.CENTER);

                JSplitPane splitPane = new JSplitPane();
                splitPane.setLeftComponent(leftPanel);
                frame.add(splitPane);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }
}
