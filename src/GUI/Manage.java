package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Manage extends JFrame {

	private JPanel Manage_Interface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage frame = new Manage();
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
	public Manage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Manage_Interface = new JPanel();
		Manage_Interface.setBorder(new EmptyBorder(5, 5, 5, 5));
		Manage_Interface.setLayout(new BorderLayout(0, 0));
		setContentPane(Manage_Interface);
		
		JPanel Main_Manage_Pane = new JPanel();
		Manage_Interface.add(Main_Manage_Pane, BorderLayout.CENTER);
		Main_Manage_Pane.setLayout(new BorderLayout(0, 0));
		
		//Data Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(800, 200));
		Main_Manage_Pane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel Bot_Manage_Pane = new JPanel();
		Manage_Interface.add(Bot_Manage_Pane, BorderLayout.SOUTH);
		GridBagLayout gbl_Bot_Manage_Pane = new GridBagLayout();
		gbl_Bot_Manage_Pane.columnWidths = new int[] {300, 300};
		gbl_Bot_Manage_Pane.rowHeights = new int[] {40};
		gbl_Bot_Manage_Pane.columnWeights = new double[]{0.0, 0.0};
		gbl_Bot_Manage_Pane.rowWeights = new double[]{0.0};
		Bot_Manage_Pane.setLayout(gbl_Bot_Manage_Pane);
		
		JButton Add_Pd_Btn = new JButton("Add Product");
		Add_Pd_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Add_Pd_Btn = new GridBagConstraints();
		gbc_Add_Pd_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Pd_Btn.insets = new Insets(5, 0, 5, 5);
		gbc_Add_Pd_Btn.gridx = 0;
		gbc_Add_Pd_Btn.gridy = 0;
		Bot_Manage_Pane.add(Add_Pd_Btn, gbc_Add_Pd_Btn);
		
		JButton Add_Acc_Btn = new JButton("Manage Account");
		Add_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Add_Acc_Btn = new GridBagConstraints();
		gbc_Add_Acc_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Acc_Btn.gridx = 1;
		gbc_Add_Acc_Btn.gridy = 0;
		Bot_Manage_Pane.add(Add_Acc_Btn, gbc_Add_Acc_Btn);
		
		JPanel Top_Manage_Pane = new JPanel();
		Manage_Interface.add(Top_Manage_Pane, BorderLayout.NORTH);
		Top_Manage_Pane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Transaction history");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		Top_Manage_Pane.add(lblNewLabel, BorderLayout.WEST);
		
		JButton Back_Main_Interface = new JButton("Back");
		Top_Manage_Pane.add(Back_Main_Interface, BorderLayout.EAST);
	    this.setPreferredSize(new Dimension(800, 600));
	}

}
