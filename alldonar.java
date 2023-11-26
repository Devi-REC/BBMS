import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class alldonar extends JFrame {
    private JTable donorTable;
    private DefaultTableModel tableModel;

    public alldonar() {
        setTitle("Donor Details");
        setSize(705, 518);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        donorTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(donorTable);
        scrollPane.setBounds(10, 71, 673, 326);

        JButton printButton = new JButton("Print");
        printButton.setBounds(131, 417, 112, 42);
        printButton.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\print.png"));
        printButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        getContentPane().setLayout(null);
        getContentPane().add(scrollPane);
        getContentPane().add(printButton);
        
        JLabel lblNewLabel = new JLabel("All Donor Details");
        lblNewLabel.setBounds(200, 23, 344, 42);
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 26));
        getContentPane().add(lblNewLabel);

        JButton printButton_2 = new JButton("Close");
        printButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
        printButton_2.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Exit application.png"));
        printButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        printButton_2.setBounds(368, 417, 112, 42);
        getContentPane().add(printButton_2);
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(0, -29, 776, 531);
        lblNewLabel_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\all page background image.png"));
        getContentPane().add(lblNewLabel_1);
        
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    donorTable.print(); // Prints the table content
                } catch (java.awt.print.PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        });

        populateDonorsTable();

        setVisible(true);
    }

    private void populateDonorsTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "devi");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT donor_id, donor_name, donor_email, blood_group FROM Donors");

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new alldonar());
    }
}
