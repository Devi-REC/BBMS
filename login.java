import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1487, 882);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 28));
		lblNewLabel.setBounds(571, 209, 126, 28);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 20));
		textField.setBounds(758, 200, 268, 54);
		contentPane.add(textField);
		textField.setColumns(10);

		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 28));
		lblNewLabel_2.setBounds(571, 321, 126, 37);
		contentPane.add(lblNewLabel_2);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordField.setBounds(758, 319, 268, 48);
		contentPane.add(passwordField);
		

		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals("bbms")&&passwordField.getText().equals("admin")) {
				setVisible(false);
				new home().setVisible(true);
			
			}
			else
				JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
			}
		});
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 26));
		btnNewButton.setBounds(480, 492, 160, 62);
		contentPane.add(btnNewButton);


		JButton btnNewButton_1 = new JButton("close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to close Application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				 System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD, 26));
		btnNewButton_1.setBounds(920, 492, 168, 62);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel_1_2 = new JLabel("\"Give the gift of life");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Algerian", Font.PLAIN, 45));
		lblNewLabel_1_2.setIcon(null);
		lblNewLabel_1_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_2.setBounds(304, 541, 500, 218);
		contentPane.add(lblNewLabel_1_2);
		JLabel lblNewLabel_1_2_1 = new JLabel("Donate Blood\"");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Algerian", Font.PLAIN, 45));
		lblNewLabel_1_2_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_2_1.setBounds(720, 627, 500, 218);
		contentPane.add(lblNewLabel_1_2_1);
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\b19.jpg"));
		lblNewLabel_1_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1_1.setBounds(355, -137, 703, 794);
		contentPane.add(lblNewLabel_1_1_1);
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\back 3.jpg"));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(786, -147, 843, 1065);
		contentPane.add(lblNewLabel_1_1);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\back 3.jpg"));
		lblNewLabel_1.setBounds(10, -73, 1186, 1065);
		contentPane.add(lblNewLabel_1);
		
		
		
			}
}
