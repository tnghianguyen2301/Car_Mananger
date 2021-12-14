package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class Login extends JFrame {

	private JPanel Background_Login;
	private JTextField User;
	private JPasswordField Password;
	private JButton Login_btn;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setType(Type.POPUP);
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 13));
		setTitle("Car Mananger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		Background_Login = new JPanel();
		Background_Login.setForeground(Color.WHITE);
		Background_Login.setBackground(Color.WHITE);
		Background_Login.setToolTipText("");
		Background_Login.setBorder(null);
		setContentPane(Background_Login);
		Background_Login.setLayout(null);
		
		JPanel Login_Panel = new JPanel();
		Login_Panel.setForeground(new Color(255, 255, 255));
		Login_Panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(192, 192, 192)));
		Login_Panel.setBounds(150, 50, 300, 250);
		Background_Login.add(Login_Panel);
		Login_Panel.setLayout(null);
		
		User = new JTextField();
		User.setFont(new Font("Arial", Font.BOLD, 13));
		User.setHorizontalAlignment(SwingConstants.LEFT);
		User.setBounds(50, 65, 200, 30);
		Login_Panel.add(User);
		User.setColumns(10);
		
		Password = new JPasswordField();
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		Password.setFont(new Font("Arial", Font.BOLD, 13));
		Password.setBounds(50, 125, 200, 30);
		Login_Panel.add(Password);
		
		Login_btn = new JButton("Login");
		Login_btn.setBackground(new Color(255, 255, 255));
		Login_btn.setForeground(new Color(0, 153, 255));
		Login_btn.setFont(new Font("Anton", Font.PLAIN, 20));
		Login_btn.setBounds(90, 180, 120, 40);
		Login_Panel.add(Login_btn);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setLabelFor(User);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(50, 45, 192, 20);
		Login_Panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setLabelFor(Password);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 13));
		lblPassword.setBounds(50, 105, 192, 20);
		Login_Panel.add(lblPassword);
	}
}
