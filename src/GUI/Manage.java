package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import DAO.CarHistoryModel;
import DAO.CarProductsDAO;
import DAO.CarProductsModel;
import DAO.HistoryProdutcsDAO;
import DTO.User;
import Untilities.DBConnection;

public class Manage extends JFrame {

	private JPanel Manage_Interface;
	private CarHistoryModel tableModel;
	private JTable table;
	private CarProductsDAO cpDAO;
	private HistoryProdutcsDAO hpDAO;
	private User user;

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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Manage() throws ClassNotFoundException, IOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Manage_Interface = new JPanel();
		Manage_Interface.setBorder(new EmptyBorder(5, 5, 5, 5));
		Manage_Interface.setLayout(new BorderLayout(0, 0));
		setContentPane(Manage_Interface);
		this.setVisible(true);
		
		JPanel Main_Manage_Pane = new JPanel();
		Manage_Interface.add(Main_Manage_Pane, BorderLayout.CENTER);
		Main_Manage_Pane.setLayout(null);
		//Data Table
		  DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  cpDAO = new CarProductsDAO(conn);
		  cpDAO.loadDataCarToList();
		  hpDAO = new HistoryProdutcsDAO(conn);
		  hpDAO.loadHistoryCarDataToList();
		  tableModel = new CarHistoryModel(hpDAO);
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(300, 50, 800, 200);
	      scrollPane.setPreferredSize(new Dimension(900, 200));
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
	    
	    Back_Main_Interface.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Application();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(true);
				dispose();
			}
		});
	}

	public Manage(User user) throws ClassNotFoundException, IOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Manage_Interface = new JPanel();
		Manage_Interface.setBorder(new EmptyBorder(5, 5, 5, 5));
		Manage_Interface.setLayout(new BorderLayout(0, 0));
		setContentPane(Manage_Interface);
		this.setVisible(true);
		this.user = user;
		
		JPanel Main_Manage_Pane = new JPanel();
		Manage_Interface.add(Main_Manage_Pane, BorderLayout.CENTER);
		Main_Manage_Pane.setLayout(null);
		//Data Table
		  DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  cpDAO = new CarProductsDAO(conn);
		  cpDAO.loadDataCarToList();
		  hpDAO = new HistoryProdutcsDAO(conn);
		  hpDAO.loadHistoryCarDataToList();
		  tableModel = new CarHistoryModel(hpDAO);
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(300, 50, 800, 200);
	      scrollPane.setPreferredSize(new Dimension(900, 200));
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
	    
	    Back_Main_Interface.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Application(Manage.this.user);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(true);
				dispose();
			}
		});
	}
}