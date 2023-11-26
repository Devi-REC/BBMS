import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Project.ConnectionProvider;
public class addNewDonar extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField, emailField, bloodGroupField;
    private JButton submitButton;
    private JButton btnClose;
    private JLabel lblNewLabel;
    private JSeparator separator;
    private JSeparator separator_1;
    private JLabel lblNewLabel_1;

    public addNewDonar() {
        setTitle("Donor Information");
        setSize(708, 559);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        nameLabel.setBounds(18, 114, 171, 67);
        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameField.setBounds(320, 118, 364, 59);
        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        emailLabel.setBounds(18, 210, 228, 74);
        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        emailField.setBounds(320, 218, 364, 59);
        JLabel bloodGroupLabel = new JLabel("Blood Group: ");
        bloodGroupLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        bloodGroupLabel.setBounds(18, 309, 228, 74);
        bloodGroupField = new JTextField();
        bloodGroupField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bloodGroupField.setBounds(320, 317, 364, 59);
        submitButton = new JButton("Submit");
        submitButton.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\save.png"));
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        submitButton.setBounds(40, 415, 196, 74);
        getContentPane().setLayout(null);

        getContentPane().add(nameLabel);
        getContentPane().add(nameField);
        getContentPane().add(emailLabel);
        getContentPane().add(emailField);
        getContentPane().add(bloodGroupLabel);
        getContentPane().add(bloodGroupField);
        getContentPane().add(submitButton);
        
        btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
        btnClose.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Exit application.png"));
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnClose.setBounds(352, 415, 196, 74);
        getContentPane().add(btnClose);
        separator = new JSeparator();
        separator.setBounds(0, 103, 702, 38);
        getContentPane().add(separator);
        separator_1 = new JSeparator();
        separator_1.setBounds(-113, 393, 702, 38);
        getContentPane().add(separator_1);
        lblNewLabel_1 = new JLabel("ADD NEW DONAR");
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 26));
        lblNewLabel_1.setBounds(172, 41, 330, 38);
        getContentPane().add(lblNewLabel_1);
        
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\all page background image.png"));
        lblNewLabel.setBounds(0, 10, 694, 512);
        getContentPane().add(lblNewLabel);
        
        
        

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveDonorInformation();
            }
        });

        setVisible(true);
    }

    private void saveDonorInformation() {
        String name = nameField.getText();
        String email = emailField.getText();
        String bloodGroup = bloodGroupField.getText();

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "devi");
            String sql = "INSERT INTO Donors (donor_name, donor_email, blood_group) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, bloodGroup);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Donor information saved successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Unable to save donor information.");
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
        SwingUtilities.invokeLater(() -> new addNewDonar());
    }
}
