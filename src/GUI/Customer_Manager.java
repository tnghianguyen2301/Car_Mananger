package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Font;

public class Customer_Manager extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Manager frame = new Customer_Manager();
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
	public Customer_Manager() {
		setTitle("Customer Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Data Table
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(350, 50, 600, 350);
	    scrollPane.setPreferredSize(new Dimension(600, 350));
	    contentPane.add(scrollPane, BorderLayout.CENTER);
	    
	    //Top Pane
	    JPanel Top_Pane = new JPanel();
	    contentPane.add(Top_Pane, BorderLayout.NORTH);
	    Top_Pane.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel = new JLabel("Customer List");
	    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
	    Top_Pane.add(lblNewLabel, BorderLayout.WEST);
	    
	    JButton Back_Main_Interface = new JButton("Back");
	    Top_Pane.add(Back_Main_Interface, BorderLayout.EAST);
	    
	    //Bot Pane
	    JPanel Bot_Pane = new JPanel();
	    contentPane.add(Bot_Pane, BorderLayout.SOUTH);
	    Bot_Pane.setLayout(new GridLayout(0, 1, 40, 0));
	    
	    JButton Edit_Cus_Btn = new JButton("Edit Profile");
	    Edit_Cus_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
	    Bot_Pane.add(Edit_Cus_Btn);
	}

}
