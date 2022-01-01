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
		getContentPane().setLayout(null);

		// Header Title
		JLabel hRegister = new JLabel("Register Data");
		hRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		hRegister.setHorizontalAlignment(SwingConstants.CENTER);
		hRegister.setBounds(121, 11, 132, 20);
		getContentPane().add(hRegister);

		// *** Header ***//
		JLabel hUsername = new JLabel("Username :");
		hUsername.setBounds(78, 52, 89, 14);
		getContentPane().add(hUsername);
		
		JLabel hPassword = new JLabel("Password :");
		hPassword.setBounds(78, 84, 89, 14);
		getContentPane().add(hPassword);
		
		JLabel hConfirmPassword = new JLabel("Confirm Password :");
		hConfirmPassword.setBounds(77, 113, 130, 14);
		getContentPane().add(hConfirmPassword);
		
		JLabel hName = new JLabel("Name :");
		hName.setBounds(78, 148, 89, 14);
		getContentPane().add(hName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(80, 176, 89, 14);
		getContentPane().add(hEmail);


		// CustomerID
		txtUsername = new JTextField("");
		txtUsername.setBounds(217, 47, 99, 20);
		getContentPane().add(txtUsername);
		
		// Password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(217, 77, 102, 20);
		getContentPane().add(txtPassword);
		
		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(217, 112, 102, 20);
		getContentPane().add(txtConfirmPassword);

		// Name
		txtName = new JTextField("");
		txtName.setBounds(217, 140, 176, 20);
		getContentPane().add(txtName);

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(217, 172, 176, 20);
		getContentPane().add(txtEmail);

		// Save Button
		JButton btnSave = new JButton("Save");
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
		btnSave.setBounds(164, 252, 89, 23);
		getContentPane().add(btnSave);		
		
		JLabel lblNewLabel = new JLabel("Roll");
		lblNewLabel.setBounds(78, 200, 45, 14);
		getContentPane().add(lblNewLabel);
		
		txtRoll = new JComboBox();
		txtRoll.setModel(new DefaultComboBoxModel(new String[] {"Sale", "Manager"}));
		txtRoll.setBounds(217, 202, 99, 21);
		getContentPane().add(txtRoll);

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

