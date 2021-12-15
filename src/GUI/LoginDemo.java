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

public class LoginDemo extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;

    LoginDemo() {
        
        // User Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        
        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(300, 100);
        setVisible(true);

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