package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UserDAO;
import DTO.User;
import hash_password.PBKDF2_Verify_Password;
import Untilities.DBConnection;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class LoginDemo extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;
    private JLabel lblNewLabel;

    LoginDemo() {

        panel = new JPanel();
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] {60, 120};
        gbl_panel.rowHeights = new int[] {50, 30, 30, 30};
        gbl_panel.columnWeights = new double[]{0.0, 0.0};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        panel.setLayout(gbl_panel);
        userName_text = new JTextField();
        GridBagConstraints gbc_userName_text = new GridBagConstraints();
        gbc_userName_text.fill = GridBagConstraints.BOTH;
        gbc_userName_text.insets = new Insets(0, 0, 5, 5);
        gbc_userName_text.gridx = 1;
        gbc_userName_text.gridy = 1;
        panel.add(userName_text, gbc_userName_text);
        
        // User Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        GridBagConstraints gbc_user_label = new GridBagConstraints();
        gbc_user_label.anchor = GridBagConstraints.WEST;
        gbc_user_label.fill = GridBagConstraints.VERTICAL;
        gbc_user_label.insets = new Insets(0, 0, 5, 5);
        gbc_user_label.gridx = 0;
        gbc_user_label.gridy = 1;
        panel.add(user_label, gbc_user_label);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(null);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);
        
        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        GridBagConstraints gbc_password_label = new GridBagConstraints();
        gbc_password_label.anchor = GridBagConstraints.WEST;
        gbc_password_label.fill = GridBagConstraints.VERTICAL;
        gbc_password_label.insets = new Insets(0, 0, 5, 5);
        gbc_password_label.gridx = 0;
        gbc_password_label.gridy = 2;
        panel.add(password_label, gbc_password_label);
                        password_text = new JPasswordField();
                        GridBagConstraints gbc_password_text = new GridBagConstraints();
                        gbc_password_text.fill = GridBagConstraints.BOTH;
                        gbc_password_text.insets = new Insets(0, 0, 5, 5);
                        gbc_password_text.gridx = 1;
                        gbc_password_text.gridy = 2;
                        panel.add(password_text, gbc_password_text);
                
                        // Submit
                
                        submit = new JButton("SUBMIT");
                        GridBagConstraints gbc_submit = new GridBagConstraints();
                        gbc_submit.anchor = GridBagConstraints.WEST;
                        gbc_submit.fill = GridBagConstraints.VERTICAL;
                        gbc_submit.insets = new Insets(0, 0, 0, 5);
                        gbc_submit.gridx = 1;
                        gbc_submit.gridy = 3;
                        panel.add(submit, gbc_submit);
                        
                        // Adding the listeners to components..
                        submit.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(415, 297);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new LoginDemo();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        @SuppressWarnings("deprecation")
		String password = password_text.getText();
       
        try {
			DBConnection.init("database.properties");
			Connection conn;
			try {
				conn = DBConnection.getConnection();
				UserDAO user_dao = new UserDAO(conn);
				if(user_dao.getUserIdByUsername(userName)>0){
					String stored_password = user_dao.getUserPasswordByUsername(userName);
					//System.out.println(stored_password);
					boolean is_match = PBKDF2_Verify_Password.validatePassword(password, stored_password);
					if (is_match){
						System.out.println("Login success.");
						System.out.println("User id " + user_dao.getUserByUsername(userName).getId());
						User current_user = user_dao.getUserByUsername(userName);
						//user_dao.displayPersonalForm(current_user);
						new Application(current_user);
						setVisible(true);
						this.dispose();
					}else
						System.out.println("Invalid username or password.");
				}else{
					System.out.println("Invalid username or password.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
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

    }

}