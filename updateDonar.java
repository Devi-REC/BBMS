import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class updateDonar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	private JButton updateButton;
	 
	 private JTextField textField;
	 private JLabel emailLabel;
	 private JTextField textField_1;
	 private JLabel bloodGroupLabel;
	 private JTextField textField_2;
	 private JLabel lblNewLabel_1;
	
	public updateDonar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		 contentPane.setLayout(null);
		 updateButton = new JButton("Update");
	        updateButton.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Details.png")); // Change the path to your icon
	        updateButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	        updateButton.setBounds(62, 423, 156, 68);
	        getContentPane().add(updateButton);
	        
	        JLabel nameLabel = new JLabel("Name: ");
	        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	        nameLabel.setBounds(37, 83, 134, 111);
	        contentPane.add(nameLabel);
	        
	        textField = new JTextField();
	        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        textField.setBounds(299, 104, 372, 68);
	        contentPane.add(textField);
	        
	        emailLabel = new JLabel("Email: ");
	        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	        emailLabel.setBounds(37, 197, 140, 111);
	        contentPane.add(emailLabel);
	        
	        textField_1 = new JTextField();
	        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        textField_1.setBounds(299, 218, 372, 68);
	        contentPane.add(textField_1);
	        
	        bloodGroupLabel = new JLabel("Blood Group: ");
	        bloodGroupLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	        bloodGroupLabel.setBounds(37, 302, 140, 111);
	        contentPane.add(bloodGroupLabel);
	        
	        textField_2 = new JTextField();
	        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        textField_2.setBounds(299, 323, 372, 68);
	        contentPane.add(textField_2);
	        
	        JButton btnClose = new JButton("Close");
	        btnClose.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Exit application.png"));
	        btnClose.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		setVisible(false);
	        	}
	        });
	        btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
	        btnClose.setBounds(363, 423, 169, 68);
	        contentPane.add(btnClose);
	        
	        JSeparator separator = new JSeparator();
	        separator.setBounds(10, 405, 721, 31);
	        contentPane.add(separator);
	        
	        JSeparator separator_1 = new JSeparator();
	        separator_1.setBounds(10, 83, 721, 21);
	        contentPane.add(separator_1);
	        
	        JLabel lblNewLabel = new JLabel("UPDATE DONAR DETAILS");
	        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 28));
	        lblNewLabel.setBounds(163, 20, 350, 53);
	        contentPane.add(lblNewLabel);
	        
	        lblNewLabel_1 = new JLabel("New label");
	        lblNewLabel_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\all page background image.png"));
	        lblNewLabel_1.setBounds(0, -99, 769, 707);
	        contentPane.add(lblNewLabel_1);

	        updateButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                updateDonorInformation();
	            }
	        });

	        setVisible(true);
	        
	}
	private void updateDonorInformation() {
        String name = textField.getText();
        String email = textField_1.getText();
        String bloodGroup = textField_2.getText();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "devi");
           
            String sql = "UPDATE Donors SET donor_email = ?, blood_group = ? WHERE donor_name = ?";
            
            	stmt = conn.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, bloodGroup);
                stmt.setString(3, name);
                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Donor information updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Unable to update donor information.");
                }
            
           
    }
        catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Unable to update donor information.");
        }
        finally {
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
        SwingUtilities.invokeLater(() -> new updateDonar());
    }
}
