import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class home extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 853);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1555, 71);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Donor");
		mnNewMenu.setFont(new Font("SansSerif", Font.BOLD, 16));
		mnNewMenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		mnNewMenu.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Donor.png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add New");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new addNewDonar().setVisible(true);	
			}
		});
		mntmNewMenuItem_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Add new.png"));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Update");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new updateDonar().setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Update details.png"));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Search Blood Donar");
		mnNewMenu_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		mnNewMenu_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\search user.png"));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Blood Group");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BloodGroupSearch().setVisible(true);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mntmNewMenuItem_4.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Blood group.png"));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Details");
		mnNewMenu_2.setFont(new Font("SansSerif", Font.BOLD, 16));
		mnNewMenu_2.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\stock.png"));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("All Donar Details");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new alldonar().setVisible(true);
			}
		});
		mntmNewMenuItem_2_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Details.png"));
		mntmNewMenuItem_2_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_2_1);
		
		JMenu mnNewMenu_3 = new JMenu("Delete Donar");
		mnNewMenu_3.setFont(new Font("SansSerif", Font.BOLD, 16));
		mnNewMenu_3.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\delete donor.png"));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Delete Donar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     new DonorDeletionFrame().setVisible(true);
			}
			
		});
		mntmNewMenuItem_8.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mntmNewMenuItem_8.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\delete.png"));
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_4 = new JMenu("Exit");
		mnNewMenu_4.setFont(new Font("SansSerif", Font.BOLD, 16));
		mnNewMenu_4.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\exit.png"));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Logout");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to logout","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new login().setVisible(true);
				}
			}
		});
		mntmNewMenuItem_9.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mntmNewMenuItem_9.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Logout.png"));
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Exit Application");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to Close the Application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
			}
		});
		mntmNewMenuItem_10.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mntmNewMenuItem_10.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\Exit application.png"));
		mnNewMenu_4.add(mntmNewMenuItem_10);
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\blood 10.jpg"));
		lblNewLabel_2_1.setBounds(519, 231, 188, 163);
		contentPane.add(lblNewLabel_2_1);
		JLabel lblNewLabel_2_1_1_1 = new JLabel("“Be the reason someone smiles today");
		lblNewLabel_2_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 55));
		lblNewLabel_2_1_1_1.setBounds(10, 462, 1332, 195);
		contentPane.add(lblNewLabel_2_1_1_1);
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\g5.jpg"));
		lblNewLabel_2.setBounds(769, 168, 413, 240);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\b19.jpg"));
		lblNewLabel_2_1_1.setBounds(351, 168, 372, 240);
		contentPane.add(lblNewLabel_2_1_1);
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Donate Blood\"");
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 55));
		lblNewLabel_2_1_1_1_1.setBounds(905, 576, 1035, 163);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
				JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\background1.jpg"));
		lblNewLabel.setBounds(772, -163, 1943, 1170);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\devi\\countdown\\countdown\\newyear\\src\\assets\\back 2.jpg"));
		lblNewLabel_1.setBounds(10, 10, 1906, 1170);
		contentPane.add(lblNewLabel_1);
		
	
	}
}
