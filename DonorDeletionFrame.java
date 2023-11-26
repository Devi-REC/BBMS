import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class DonorDeletionFrame extends JFrame {
    private JTextField donorIDField;
    private JButton deleteButton;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private JLabel lblNewLabel;
    private JButton btnClose;
    private JLabel lblNewLabel_1;

    public DonorDeletionFrame() {
        setTitle("Delete Donor");
        setSize(708, 505);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
                donorIDField = new JTextField(10);
                donorIDField.setBounds(247, 199, 207, 37);
                getContentPane().add(donorIDField);
                deleteButton = new JButton("Delete");
                deleteButton.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\delete donor.png"));
                deleteButton.setFont(new Font("Tahoma", Font.BOLD, 16));
                deleteButton.setBounds(98, 333, 172, 66);
                getContentPane().add(deleteButton);
                
                        JLabel lblDonorId = new JLabel("Donor ID:");
                        lblDonorId.setFont(new Font("Tahoma", Font.BOLD, 15));
                        lblDonorId.setBounds(98, 193, 110, 45);
                        getContentPane().add(lblDonorId);
                        
                        lblNewLabel = new JLabel("Delete Donor Details");
                        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
                        lblNewLabel.setBounds(151, 52, 359, 37);
                        getContentPane().add(lblNewLabel);
                        
                        JSeparator separator = new JSeparator();
                        separator.setBounds(10, 121, 674, 44);
                        getContentPane().add(separator);
                        
                        btnClose = new JButton("Close");
                        btnClose.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		setVisible(false);
                        	}
                        });
                        btnClose.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Exit application.png"));
                        btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
                        btnClose.setBounds(356, 333, 172, 66);
                        getContentPane().add(btnClose);
                        
                        lblNewLabel_1 = new JLabel("New label");
                        lblNewLabel_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\all page background image.png"));
                        lblNewLabel_1.setBounds(10, 10, 674, 448);
                        getContentPane().add(lblNewLabel_1);
                
                        deleteButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                deleteDonor();
                            }
                        });
        setLocationRelativeTo(null);

        // Connect to the database
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "devi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteDonor() {
        try {
            int donorID = Integer.parseInt(donorIDField.getText());
            String deleteQuery = "DELETE FROM Donors WHERE donor_id = ?";

            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, donorID);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Donor deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "No donor found with that ID.");
            }
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ensure the database driver is loaded (e.g., for MySQL)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        SwingUtilities.invokeLater(() -> {
        	DonorDeletionFrame frame = new DonorDeletionFrame();
            frame.setVisible(true);
        });
    }
}
