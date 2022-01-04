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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Staff_Manager extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Manager frame = new Staff_Manager();
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
	public Staff_Manager() {
		setTitle("Staff Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Data Table
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(350, 50, 600, 350);
	    scrollPane.setPreferredSize(new Dimension(600, 350));
	    contentPane.add(scrollPane, BorderLayout.CENTER);
		
	    //Bot Pane
		JPanel Bot_Pane = new JPanel();
		contentPane.add(Bot_Pane, BorderLayout.SOUTH);
		GridBagLayout gbl_Bot_Pane = new GridBagLayout();
		gbl_Bot_Pane.columnWidths = new int[] {150, 150, 150};
		gbl_Bot_Pane.rowHeights = new int[] {40};
		gbl_Bot_Pane.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_Bot_Pane.rowWeights = new double[]{0.0};
		Bot_Pane.setLayout(gbl_Bot_Pane);
		
		JButton Add_Acc_Btn = new JButton("Add");
		Add_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Add_Acc_Btn = new GridBagConstraints();
		gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Acc_Btn.insets = new Insets(0, 0, 0, 5);
		gbc_Add_Acc_Btn.gridx = 0;
		gbc_Add_Acc_Btn.gridy = 0;
		Bot_Pane.add(Add_Acc_Btn, gbc_Add_Acc_Btn);
		
		JButton Edit_Acc_Btn = new JButton("Edit");
		Edit_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Edit_Acc_Btn = new GridBagConstraints();
		gbc_Edit_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Edit_Acc_Btn.insets = new Insets(0, 0, 0, 5);
		gbc_Edit_Acc_Btn.gridx = 1;
		gbc_Edit_Acc_Btn.gridy = 0;
		Bot_Pane.add(Edit_Acc_Btn, gbc_Edit_Acc_Btn);
		
		JButton Del_Acc_Btn = new JButton("Delete");
		Del_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Del_Acc_Btn = new GridBagConstraints();
		gbc_Del_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Del_Acc_Btn.gridx = 2;
		gbc_Del_Acc_Btn.gridy = 0;
		Bot_Pane.add(Del_Acc_Btn, gbc_Del_Acc_Btn);
		
		//Top Pane
		JPanel Top_Pane = new JPanel();
		contentPane.add(Top_Pane, BorderLayout.NORTH);
		Top_Pane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Staff List");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		Top_Pane.add(lblNewLabel, BorderLayout.WEST);
		
		JButton Back_Main_Interface = new JButton("Back");
		Top_Pane.add(Back_Main_Interface, BorderLayout.EAST);
	}

}
