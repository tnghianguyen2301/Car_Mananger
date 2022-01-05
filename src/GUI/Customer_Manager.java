package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CarHistoryModel;
import DAO.CarProductsDAO;
import DAO.CustomerDAO;
import DAO.CustomerModel;
import DAO.HistoryProdutcsDAO;
import Untilities.DBConnection;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.Font;

public class Customer_Manager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Cus_Name;
	private JTextField Cus_Birth;
	private JTextField Cus_Address;
	private JTextField Cus_Phone;
	private CustomerModel tableModel;
	private CustomerDAO cDAO;
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Customer_Manager() throws ClassNotFoundException, IOException, SQLException {
		setTitle("Customer Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Data Table
		DBConnection.init("database.properties");
		Connection conn = DBConnection.getConnection();
		cDAO = new CustomerDAO(conn);
		cDAO.loadDataToList();
		tableModel = new CustomerModel(cDAO);
	    table = new JTable(tableModel);
	    table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	    table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(0, 0, 800, 400);
	    scrollPane.setPreferredSize(new Dimension(800, 400));
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
	    
	    //Infomation Pane
	    JPanel Sale_Pane = new JPanel();
	    contentPane.add(Sale_Pane, BorderLayout.EAST);
	    GridBagLayout gbl_Sale_Pane = new GridBagLayout();
	    gbl_Sale_Pane.columnWidths = new int[]{0, 0};
	    gbl_Sale_Pane.rowHeights = new int[]{0, 0};
	    gbl_Sale_Pane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	    gbl_Sale_Pane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
	    Sale_Pane.setLayout(gbl_Sale_Pane);
	    
	    JPanel panel = new JPanel();
	    GridBagConstraints gbc_panel = new GridBagConstraints();
	    gbc_panel.insets = new Insets(0, 5, 5, 5);
	    gbc_panel.fill = GridBagConstraints.BOTH;
	    gbc_panel.gridx = 0;
	    gbc_panel.gridy = 0;
	    Sale_Pane.add(panel, gbc_panel);
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[] {80, 80};
	    gbl_panel.rowHeights = new int[] {30, 20, 30, 20, 30, 20, 30, 20, 30};
	    gbl_panel.columnWeights = new double[]{0.0, 0.0};
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	    panel.setLayout(gbl_panel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Customer Infomation:");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	    gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNewLabel_1.gridwidth = 2;
	    gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
	    gbc_lblNewLabel_1.gridx = 0;
	    gbc_lblNewLabel_1.gridy = 0;
	    panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Customer Name:");
	    GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2.gridx = 0;
	    gbc_lblNewLabel_2.gridy = 1;
	    panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
	    
	    Cus_Name = new JTextField();
	    Cus_Name.setFont(new Font("Tahoma", Font.BOLD, 11));
	    GridBagConstraints gbc_Cus_Name = new GridBagConstraints();
	    gbc_Cus_Name.gridwidth = 2;
	    gbc_Cus_Name.fill = GridBagConstraints.BOTH;
	    gbc_Cus_Name.insets = new Insets(0, 0, 5, 0);
	    gbc_Cus_Name.gridx = 0;
	    gbc_Cus_Name.gridy = 2;
	    panel.add(Cus_Name, gbc_Cus_Name);
	    Cus_Name.setColumns(10);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Date of birth:");
	    GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
	    gbc_lblNewLabel_2_1.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_1.gridx = 0;
	    gbc_lblNewLabel_2_1.gridy = 3;
	    panel.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
	    
	    Cus_Birth = new JTextField();
	    Cus_Birth.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Cus_Birth.setColumns(10);
	    GridBagConstraints gbc_Cus_Birth = new GridBagConstraints();
	    gbc_Cus_Birth.gridwidth = 2;
	    gbc_Cus_Birth.fill = GridBagConstraints.BOTH;
	    gbc_Cus_Birth.insets = new Insets(0, 0, 5, 0);
	    gbc_Cus_Birth.gridx = 0;
	    gbc_Cus_Birth.gridy = 4;
	    panel.add(Cus_Birth, gbc_Cus_Birth);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Address:");
	    GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2.gridx = 0;
	    gbc_lblNewLabel_2_2.gridy = 5;
	    panel.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);
	    
	    Cus_Address = new JTextField();
	    Cus_Address.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Cus_Address.setColumns(10);
	    GridBagConstraints gbc_Cus_Address = new GridBagConstraints();
	    gbc_Cus_Address.gridwidth = 2;
	    gbc_Cus_Address.fill = GridBagConstraints.BOTH;
	    gbc_Cus_Address.insets = new Insets(0, 0, 5, 0);
	    gbc_Cus_Address.gridx = 0;
	    gbc_Cus_Address.gridy = 6;
	    panel.add(Cus_Address, gbc_Cus_Address);
	    
	    JLabel lblNewLabel_2_2_1 = new JLabel("Phone number:");
	    GridBagConstraints gbc_lblNewLabel_2_2_1 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2_1.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2_1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2_1.gridx = 0;
	    gbc_lblNewLabel_2_2_1.gridy = 7;
	    panel.add(lblNewLabel_2_2_1, gbc_lblNewLabel_2_2_1);
	    
	    Cus_Phone = new JTextField();
	    Cus_Phone.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Cus_Phone.setColumns(10);
	    GridBagConstraints gbc_Cus_Phone = new GridBagConstraints();
	    gbc_Cus_Phone.gridwidth = 2;
	    gbc_Cus_Phone.fill = GridBagConstraints.BOTH;
	    gbc_Cus_Phone.insets = new Insets(0, 0, 5, 0);
	    gbc_Cus_Phone.gridx = 0;
	    gbc_Cus_Phone.gridy = 8;
	    panel.add(Cus_Phone, gbc_Cus_Phone);
	    table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				int r_model = -1;
				if (r != -1){
					r_model = table.convertRowIndexToModel(r);
				}
				
				int c = table.getSelectedColumn();
				int c_model = -1;
				if (c != -1){
					c_model = table.convertColumnIndexToModel(c);
				}
				Cus_Name.setText((String) tableModel.getValueAt(r_model, 1));
				Cus_Birth.setText(tableModel.getValueAt(r_model, 2).toString());
				Cus_Address.setText((String) tableModel.getValueAt(r_model, 3));
				Cus_Phone.setText((String) tableModel.getValueAt(r_model, 4));
			}
		});
	}

}
