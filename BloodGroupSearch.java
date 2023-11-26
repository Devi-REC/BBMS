import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BloodGroupSearch extends JFrame {
    private JTextField bloodGroupField;
    private JTextArea resultArea;

    public BloodGroupSearch() {
        setTitle("Search Blood Group");
        setSize(679, 506);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel bloodGroupLabel = new JLabel("Enter Blood Group:");
        bloodGroupLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        bloodGroupLabel.setBounds(34, 135, 174, 33);
        bloodGroupField = new JTextField();
        bloodGroupField.setBounds(260, 122, 337, 59);

        JButton searchButton = new JButton("Search");
        searchButton.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\search1.png"));
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchButton.setBounds(60, 227, 148, 44);

        resultArea = new JTextArea();
        resultArea.setBounds(34, 305, 574, 129);
        resultArea.setEditable(false);

        getContentPane().setLayout(null);
        getContentPane().add(bloodGroupLabel);
        getContentPane().add(bloodGroupField);
        getContentPane().add(searchButton);
        getContentPane().add(resultArea);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 102, 691, 10);
        getContentPane().add(separator);
        
        JLabel lblNewLabel = new JLabel("Search Donor Details");
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 27));
        lblNewLabel.setBounds(158, 41, 337, 33);
        getContentPane().add(lblNewLabel);
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
        btnClose.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Exit application.png"));
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(306, 227, 148, 44);
        getContentPane().add(btnClose);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\all page background image.png"));
        lblNewLabel_1.setBounds(0, 10, 667, 461);
        getContentPane().add(lblNewLabel_1);
        

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchBloodGroup();
            }
        });

        setVisible(true);
    }

    private void searchBloodGroup() {
        String bloodGroup = bloodGroupField.getText();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "devi");

            String sql = "SELECT * FROM Donors WHERE blood_group = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bloodGroup);

            rs = stmt.executeQuery();

            StringBuilder result = new StringBuilder();

            while (rs.next()) {
                int donorId = rs.getInt("donor_id");
                String donorName = rs.getString("donor_name");
                String donorEmail = rs.getString("donor_email");
                String donorBloodGroup = rs.getString("blood_group");
                
                result.append("Donor ID: ").append(donorId)
                    .append(", Name: ").append(donorName)
                    .append(", Email: ").append(donorEmail)
                    .append(", Blood Group: ").append(donorBloodGroup)
                    .append("\n");
            }

            if (result.length() == 0) {
                resultArea.setText("No donors found for blood group: " + bloodGroup);
            } else {
                resultArea.setText(result.toString());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            resultArea.setText("Error: Unable to retrieve donors.");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        SwingUtilities.invokeLater(() -> new BloodGroupSearch());
    }
}
