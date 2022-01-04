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
		setTitle("Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
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
	      scrollPane.setBounds(300, 50, 750, 350);
	      scrollPane.setPreferredSize(new Dimension(600, 350));
	      Main_Manage_Pane.add(scrollPane, BorderLayout.CENTER);
		
	    //Bot Pane
		JPanel Bot_Manage_Pane = new JPanel();
		Manage_Interface.add(Bot_Manage_Pane, BorderLayout.SOUTH);
		GridBagLayout gbl_Bot_Manage_Pane = new GridBagLayout();
		gbl_Bot_Manage_Pane.columnWidths = new int[] {150, 150, 150, 150, 150};
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
		
		JButton Man_Cus_Btn = new JButton("Manage Customer");
		Man_Cus_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Man_Cus_Btn = new GridBagConstraints();
		gbc_Add_Acc_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Acc_Btn.gridx = 2;
		gbc_Add_Acc_Btn.gridy = 0;
		Bot_Manage_Pane.add(Man_Cus_Btn, gbc_Man_Cus_Btn);
		
		JButton Rep_Car_Btn = new JButton("Report Car Type");
		Rep_Car_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Rep_Car_Btn = new GridBagConstraints();
		gbc_Add_Acc_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Acc_Btn.gridx = 3;
		gbc_Add_Acc_Btn.gridy = 0;
		Bot_Manage_Pane.add(Rep_Car_Btn, gbc_Rep_Car_Btn);
		
		JButton Rep_Tur_Btn = new JButton("Report Turnover");
		Rep_Tur_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Rep_Tur_Btn = new GridBagConstraints();
		gbc_Add_Acc_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Acc_Btn.gridx = 4;
		gbc_Add_Acc_Btn.gridy = 0;
		Bot_Manage_Pane.add(Rep_Tur_Btn, gbc_Rep_Tur_Btn);
		
		//Top Pane
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
	      scrollPane.setBounds(350, 50, 800, 200);
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
		
		JButton Man_Acc_Btn = new JButton("Manage Account");
		Man_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Man_Acc_Btn = new GridBagConstraints();
		gbc_Man_Acc_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Man_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Man_Acc_Btn.gridx = 1;
		gbc_Man_Acc_Btn.gridy = 0;
		Bot_Manage_Pane.add(Man_Acc_Btn, gbc_Man_Acc_Btn);
		
		JButton Man_Cus_Btn = new JButton("Manage Customer");
		Man_Cus_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Man_Cus_Btn = new GridBagConstraints();
		gbc_Man_Cus_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Man_Cus_Btn.fill = GridBagConstraints.BOTH;
		gbc_Man_Cus_Btn.gridx = 2;
		gbc_Man_Cus_Btn.gridy = 0;
		Bot_Manage_Pane.add(Man_Cus_Btn, gbc_Man_Cus_Btn);
		
		JButton Rep_Car_Btn = new JButton("Report Car Type");
		Rep_Car_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Rep_Car_Btn = new GridBagConstraints();
		gbc_Rep_Car_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Rep_Car_Btn.fill = GridBagConstraints.BOTH;
		gbc_Rep_Car_Btn.gridx = 3;
		gbc_Rep_Car_Btn.gridy = 0;
		Bot_Manage_Pane.add(Rep_Car_Btn, gbc_Rep_Car_Btn);
		
		JButton Rep_Tur_Btn = new JButton("Report Turnover");
		Rep_Tur_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Rep_Tur_Btn = new GridBagConstraints();
		gbc_Rep_Tur_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Rep_Tur_Btn.fill = GridBagConstraints.BOTH;
		gbc_Rep_Tur_Btn.gridx = 4;
		gbc_Rep_Tur_Btn.gridy = 0;
		Bot_Manage_Pane.add(Rep_Tur_Btn, gbc_Rep_Tur_Btn);
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
	    Add_Pd_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Add_Product(Manage.this.user);
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
	    Rep_Car_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new BarChartEx(Manage.this.user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(true);
				dispose();
				
			}
		});
	    Rep_Tur_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new LineChartEx(Manage.this.user);
				} catch (ClassNotFoundException e1) {
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
