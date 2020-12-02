package ch17;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

public class TableGridProb2 {

    public static void main(String[] args) {
        UIManager.put("Table.gridColor", new ColorUIResource(Color.gray));
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Table Grid Prob2");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JScrollPane sp = new JScrollPane(new JTable(20, 5));
                JPanel p = new JPanel(new GridLayout());
                p.setBorder(new LineBorder(Color.green, 4));
                p.add(sp);
                frame.getContentPane().add(p);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
