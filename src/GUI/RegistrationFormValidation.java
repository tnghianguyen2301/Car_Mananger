package GUI;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import DAO.UserDAO;
import DTO.User;
import Untilities.DBConnection;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RegistrationFormValidation extends JFrame {
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtName;
	private JTextField txtEmail;
	private JComboBox txtRoll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				RegistrationFormValidation frame = new RegistrationFormValidation();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationFormValidation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 343);
		setTitle("Registration Form");
						GridBagLayout gridBagLayout = new GridBagLayout();
						gridBagLayout.columnWidths = new int[] {110, 80, 80};
						gridBagLayout.rowHeights = new int[] {30, 25, 25, 25, 25, 25, 25, 30};
						gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
						gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
						getContentPane().setLayout(gridBagLayout);
						
								// Header Title
								JLabel hRegister = new JLabel("Register Data");
								hRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
								hRegister.setHorizontalAlignment(SwingConstants.CENTER);
								GridBagConstraints gbc_hRegister = new GridBagConstraints();
								gbc_hRegister.gridwidth = 3;
								gbc_hRegister.fill = GridBagConstraints.VERTICAL;
								gbc_hRegister.insets = new Insets(10, 0, 20, 0);
								gbc_hRegister.gridx = 0;
								gbc_hRegister.gridy = 0;
								getContentPane().add(hRegister, gbc_hRegister);
								
										// *** Header ***//
										JLabel hUsername = new JLabel("Username :");
										GridBagConstraints gbc_hUsername = new GridBagConstraints();
										gbc_hUsername.insets = new Insets(0, 0, 10, 5);
										gbc_hUsername.anchor = GridBagConstraints.WEST;
										gbc_hUsername.gridx = 0;
										gbc_hUsername.gridy = 1;
										getContentPane().add(hUsername, gbc_hUsername);
						
						
								// CustomerID
								txtUsername = new JTextField("");
								GridBagConstraints gbc_txtUsername = new GridBagConstraints();
								gbc_txtUsername.gridwidth = 2;
								gbc_txtUsername.insets = new Insets(0, 0, 10, 0);
								gbc_txtUsername.fill = GridBagConstraints.BOTH;
								gbc_txtUsername.gridx = 1;
								gbc_txtUsername.gridy = 1;
								getContentPane().add(txtUsername, gbc_txtUsername);
						
						JLabel hPassword = new JLabel("Password :");
						GridBagConstraints gbc_hPassword = new GridBagConstraints();
						gbc_hPassword.insets = new Insets(0, 0, 10, 5);
						gbc_hPassword.anchor = GridBagConstraints.WEST;
						gbc_hPassword.gridx = 0;
						gbc_hPassword.gridy = 2;
						getContentPane().add(hPassword, gbc_hPassword);
						
						// Password
						txtPassword = new JPasswordField();
						GridBagConstraints gbc_txtPassword = new GridBagConstraints();
						gbc_txtPassword.gridwidth = 2;
						gbc_txtPassword.fill = GridBagConstraints.BOTH;
						gbc_txtPassword.insets = new Insets(0, 0, 10, 0);
						gbc_txtPassword.gridx = 1;
						gbc_txtPassword.gridy = 2;
						getContentPane().add(txtPassword, gbc_txtPassword);
						
						JLabel hConfirmPassword = new JLabel("Confirm Password :");
						GridBagConstraints gbc_hConfirmPassword = new GridBagConstraints();
						gbc_hConfirmPassword.insets = new Insets(0, 0, 10, 5);
						gbc_hConfirmPassword.anchor = GridBagConstraints.WEST;
						gbc_hConfirmPassword.gridx = 0;
						gbc_hConfirmPassword.gridy = 3;
						getContentPane().add(hConfirmPassword, gbc_hConfirmPassword);
						
						// Confirm Password
						txtConfirmPassword = new JPasswordField();
						GridBagConstraints gbc_txtConfirmPassword = new GridBagConstraints();
						gbc_txtConfirmPassword.gridwidth = 2;
						gbc_txtConfirmPassword.fill = GridBagConstraints.BOTH;
						gbc_txtConfirmPassword.insets = new Insets(0, 0, 10, 0);
						gbc_txtConfirmPassword.gridx = 1;
						gbc_txtConfirmPassword.gridy = 3;
						getContentPane().add(txtConfirmPassword, gbc_txtConfirmPassword);
								
								JLabel hName = new JLabel("Name :");
								GridBagConstraints gbc_hName = new GridBagConstraints();
								gbc_hName.anchor = GridBagConstraints.WEST;
								gbc_hName.insets = new Insets(0, 0, 10, 5);
								gbc_hName.gridx = 0;
								gbc_hName.gridy = 4;
								getContentPane().add(hName, gbc_hName);
								
										// Name
										txtName = new JTextField("");
										GridBagConstraints gbc_txtName = new GridBagConstraints();
										gbc_txtName.gridwidth = 2;
										gbc_txtName.fill = GridBagConstraints.BOTH;
										gbc_txtName.insets = new Insets(0, 0, 10, 0);
										gbc_txtName.gridx = 1;
										gbc_txtName.gridy = 4;
										getContentPane().add(txtName, gbc_txtName);
						
								JLabel hEmail = new JLabel("Email :");
								GridBagConstraints gbc_hEmail = new GridBagConstraints();
								gbc_hEmail.fill = GridBagConstraints.HORIZONTAL;
								gbc_hEmail.insets = new Insets(0, 0, 10, 5);
								gbc_hEmail.gridx = 0;
								gbc_hEmail.gridy = 5;
								getContentPane().add(hEmail, gbc_hEmail);
						
								// Email
								txtEmail = new JTextField("");
								GridBagConstraints gbc_txtEmail = new GridBagConstraints();
								gbc_txtEmail.gridwidth = 2;
								gbc_txtEmail.fill = GridBagConstraints.BOTH;
								gbc_txtEmail.insets = new Insets(0, 0, 10, 0);
								gbc_txtEmail.gridx = 1;
								gbc_txtEmail.gridy = 5;
								getContentPane().add(txtEmail, gbc_txtEmail);
						
						JLabel lblNewLabel = new JLabel("Roll");
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
						gbc_lblNewLabel.insets = new Insets(0, 0, 10, 5);
						gbc_lblNewLabel.gridx = 0;
						gbc_lblNewLabel.gridy = 6;
						getContentPane().add(lblNewLabel, gbc_lblNewLabel);
						
						txtRoll = new JComboBox();
						txtRoll.setModel(new DefaultComboBoxModel(new String[] {"Sale", "Manager"}));
						GridBagConstraints gbc_txtRoll = new GridBagConstraints();
						gbc_txtRoll.gridwidth = 2;
						gbc_txtRoll.fill = GridBagConstraints.BOTH;
						gbc_txtRoll.insets = new Insets(0, 0, 10, 0);
						gbc_txtRoll.gridx = 1;
						gbc_txtRoll.gridy = 6;
						getContentPane().add(txtRoll, gbc_txtRoll);
								
								JButton btnLogin = new JButton("Log In");
								btnLogin.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										new LoginDemo();
										setVisible(true);
										dispose();
									}
								});
								GridBagConstraints gbc_btnLogin = new GridBagConstraints();
								gbc_btnLogin.anchor = GridBagConstraints.WEST;
								gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
								gbc_btnLogin.fill = GridBagConstraints.VERTICAL;
								gbc_btnLogin.gridx = 0;
								gbc_btnLogin.gridy = 7;
								getContentPane().add(btnLogin, gbc_btnLogin);
								
										// Save Button
										JButton btnSave = new JButton("Register");
										btnSave.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												try {
													if(RegisterData()) {
														JOptionPane.showMessageDialog(null,
																"Register Data Successfully");
													}
												} catch (HeadlessException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												} catch (NoSuchAlgorithmException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												} catch (InvalidKeySpecException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
										});
										GridBagConstraints gbc_btnSave = new GridBagConstraints();
										gbc_btnSave.anchor = GridBagConstraints.WEST;
										gbc_btnSave.gridwidth = 2;
										gbc_btnSave.insets = new Insets(0, 0, 0, 5);
										gbc_btnSave.fill = GridBagConstraints.VERTICAL;
										gbc_btnSave.gridx = 1;
										gbc_btnSave.gridy = 7;
										getContentPane().add(btnSave, gbc_btnSave);

	}
	
	private boolean RegisterData() throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		
		String strUsername = txtUsername.getText();
		String strPassword = new String(txtPassword.getPassword());
		String strConfirmPassword = new String(txtConfirmPassword.getPassword());
		String strName = txtName.getText();
		String strEmail = txtEmail.getText();
		String strRoll = txtRoll.getSelectedItem().toString();
		if(strUsername.equals("")) // Username
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Username)");
			txtUsername.requestFocusInWindow(); 
			return false;
		}
		if(strPassword.equals("")) // Password
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Password)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}
		
		if(strConfirmPassword.equals("")) // Confirm Password
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Confirm Password)");
			txtConfirmPassword.requestFocusInWindow(); 
			return false;
		}
		if(!strPassword.equals(strConfirmPassword)) // Password math
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Password Not Match!)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}		
		if(strName.equals("")) // Name
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Name)");
			txtName.requestFocusInWindow(); 
			return false;
		}	
		
		if(strEmail.equals("")) // Email
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Email)");
			txtEmail.requestFocusInWindow(); 
			return false;
		}	
		if(strRoll.equals(" ")) {
			JOptionPane.showMessageDialog(null,
					"Please Input (Roll)");
			txtEmail.requestFocusInWindow(); 
			return false;
		}
		boolean status = false;
		User new_user = new User(strUsername, strPassword, strEmail, strName, strRoll);
		try {
			DBConnection.init("database.properties");
			try {
				Connection conn = DBConnection.getConnection();
				UserDAO user_dao = new UserDAO(conn);
				
				status = user_dao.createUserInTable(new_user);
				resetRegistrationForm();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return status;

	}
	
	public void resetRegistrationForm(){
		txtUsername.setText("");
		txtPassword.setText("");
		txtConfirmPassword.setText("");
		txtName.setText("");
		txtEmail.setText("");
	}
}

