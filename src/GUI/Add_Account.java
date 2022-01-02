package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Add_Account extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	private JTextField Name;
	private JTextField Email;
	private JPasswordField Password;
	private JPasswordField Re_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Account frame = new Add_Account();
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
	public Add_Account() {
		setTitle("Add Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {150, 200};
		gbl_panel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 40};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		//Username
		Username = new JTextField();
		Username.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_Username = new GridBagConstraints();
		gbc_Username.fill = GridBagConstraints.BOTH;
		gbc_Username.insets = new Insets(0, 0, 5, 0);
		gbc_Username.gridx = 1;
		gbc_Username.gridy = 0;
		panel.add(Username, gbc_Username);
		Username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		//Password
		Password = new JPasswordField();
		Password.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_Password = new GridBagConstraints();
		gbc_Password.fill = GridBagConstraints.BOTH;
		gbc_Password.insets = new Insets(0, 0, 5, 0);
		gbc_Password.gridx = 1;
		gbc_Password.gridy = 1;
		panel.add(Password, gbc_Password);
		
		JLabel lblNewLabel_5 = new JLabel("Repeat Password:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		//Repeat Password
		Re_Password = new JPasswordField();
		Re_Password.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_Re_Password = new GridBagConstraints();
		gbc_Re_Password.fill = GridBagConstraints.BOTH;
		gbc_Re_Password.insets = new Insets(0, 0, 5, 0);
		gbc_Re_Password.gridx = 1;
		gbc_Re_Password.gridy = 2;
		panel.add(Re_Password, gbc_Re_Password);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//Name
		Name = new JTextField();
		Name.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.fill = GridBagConstraints.BOTH;
		gbc_Name.insets = new Insets(0, 0, 5, 0);
		gbc_Name.gridx = 1;
		gbc_Name.gridy = 3;
		panel.add(Name, gbc_Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		//Email
		Email = new JTextField();
		Email.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_Email = new GridBagConstraints();
		gbc_Email.fill = GridBagConstraints.BOTH;
		gbc_Email.insets = new Insets(0, 0, 5, 0);
		gbc_Email.gridx = 1;
		gbc_Email.gridy = 4;
		panel.add(Email, gbc_Email);
		Email.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Role:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		//Role
		JComboBox Role = new JComboBox();
		Role.setFont(new Font("Tahoma", Font.BOLD, 13));
		Role.setModel(new DefaultComboBoxModel(new String[] {"Director", "Vice Director", "Supervisor", "Employee"}));
		GridBagConstraints gbc_Role = new GridBagConstraints();
		gbc_Role.fill = GridBagConstraints.HORIZONTAL;
		gbc_Role.insets = new Insets(0, 0, 5, 0);
		gbc_Role.gridx = 1;
		gbc_Role.gridy = 5;
		panel.add(Role, gbc_Role);
		
		//Add Button
		JButton Add_Btn = new JButton("Add Account");
		Add_Btn.setForeground(new Color(0, 153, 255));
		Add_Btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_Add_Btn = new GridBagConstraints();
		gbc_Add_Btn.fill = GridBagConstraints.HORIZONTAL;
		gbc_Add_Btn.gridwidth = 2;
		gbc_Add_Btn.gridx = 0;
		gbc_Add_Btn.gridy = 6;
		panel.add(Add_Btn, gbc_Add_Btn);
	}

}
