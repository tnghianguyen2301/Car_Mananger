package GUI;

import java.awt.BorderLayout;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CarHistoryModel;
import DAO.CarProductsDAO;
import DAO.CarProductsModel;
import DAO.HistoryProdutcsDAO;
import DTO.User;
import Untilities.DBConnection;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Application extends JFrame {

	private JPanel contentPane;
	private JTextField Filter_Name;
	private CarProductsModel tableModel;
	private JTable table;
	private JTextField Cus_Name;
	private JTextField Cus_Birth;
	private JTextField Cus_Address;
	private JTextField Cus_Phone;
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
					Application frame = new Application();
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
	public Application() throws ClassNotFoundException, IOException, SQLException {
		setTitle("Car Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setVisible(true);
		setLocationRelativeTo(null);
		
		//Data Table
		DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  cpDAO = new CarProductsDAO(conn);
		  cpDAO.loadDataCarToList();
		  tableModel = new CarProductsModel(cpDAO);
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(0, 0, 800, 400);
	      scrollPane.setPreferredSize(new Dimension(800, 400));
	      contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//Bot Pane (Filter)
		JPanel Bot_Pane = new JPanel();
		contentPane.add(Bot_Pane, BorderLayout.SOUTH);
		GridBagLayout gbl_Bot_Pane = new GridBagLayout();
		gbl_Bot_Pane.columnWidths = new int[] {120, 120, 120, 120, 180};
		gbl_Bot_Pane.rowHeights = new int[] {20, 20, 20};
		gbl_Bot_Pane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_Bot_Pane.rowWeights = new double[]{0.0, 0.0, 0.0};
		Bot_Pane.setLayout(gbl_Bot_Pane);
		
		JLabel lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 0;
		Bot_Pane.add(lblStatus, gbc_lblStatus);
		
		JLabel lblTrademark = new JLabel("Trademark");
		GridBagConstraints gbc_lblTrademark = new GridBagConstraints();
		gbc_lblTrademark.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrademark.gridx = 1;
		gbc_lblTrademark.gridy = 0;
		Bot_Pane.add(lblTrademark, gbc_lblTrademark);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 2;
		gbc_lblType.gridy = 0;
		Bot_Pane.add(lblType, gbc_lblType);
		
		JLabel lblColor = new JLabel("Color");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 3;
		gbc_lblColor.gridy = 0;
		Bot_Pane.add(lblColor, gbc_lblColor);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 4;
		gbc_lblName.gridy = 0;
		Bot_Pane.add(lblName, gbc_lblName);
		
		//Status
		JComboBox Filter_Status = new JComboBox();
		Filter_Status.setForeground(Color.BLACK);
		Filter_Status.setFont(new Font("Arial", Font.BOLD, 13));
		Filter_Status.setModel(new DefaultComboBoxModel(new String[] {"All", "New", "Old"}));
		GridBagConstraints gbc_Filter_Status = new GridBagConstraints();
		gbc_Filter_Status.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Status.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Status.gridx = 0;
		gbc_Filter_Status.gridy = 1;
		Bot_Pane.add(Filter_Status, gbc_Filter_Status);
		
		//Trademark
		JComboBox Filter_Trademark = new JComboBox();
		Filter_Trademark.setForeground(Color.BLACK);
		Filter_Trademark.setFont(new Font("Arial", Font.BOLD, 13));
		Filter_Trademark.setModel(new DefaultComboBoxModel(new String[] {"All", "Honda", "Toyota", "Mazda", "Mitsubishi", "Hyundai", "Kia", "Others"}));
		GridBagConstraints gbc_Filter_Trademark = new GridBagConstraints();
		gbc_Filter_Trademark.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Trademark.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Trademark.gridx = 1;
		gbc_Filter_Trademark.gridy = 1;
		Bot_Pane.add(Filter_Trademark, gbc_Filter_Trademark);
		
		//Type
		JComboBox Filter_Type = new JComboBox();
		Filter_Type.setForeground(Color.BLACK);
		Filter_Type.setFont(new Font("Arial", Font.BOLD, 13));
		Filter_Type.setModel(new DefaultComboBoxModel(new String[] {"All", "Sedan", "HatchBack", "SUV", "Crossover", "MPV", "Pickup", "Others"}));
		GridBagConstraints gbc_Filter_Type = new GridBagConstraints();
		gbc_Filter_Type.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Type.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Type.gridx = 2;
		gbc_Filter_Type.gridy = 1;
		Bot_Pane.add(Filter_Type, gbc_Filter_Type);
		
		//Color
		JComboBox Filter_Color = new JComboBox();
		Filter_Color.setModel(new DefaultComboBoxModel(new String[] {"All", "White", "Black", "Gray", "Silver", "Blue", "Red", "Brown", "Yellow", "Green", "Others"}));
		Filter_Color.setForeground(Color.BLACK);
		Filter_Color.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_Filter_Color = new GridBagConstraints();
		gbc_Filter_Color.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Color.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Color.gridx = 3;
		gbc_Filter_Color.gridy = 1;
		Bot_Pane.add(Filter_Color, gbc_Filter_Color);
		
		//Name
		Filter_Name = new JTextField();
		Filter_Name.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_Filter_Name = new GridBagConstraints();
		gbc_Filter_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Name.gridx = 4;
		gbc_Filter_Name.gridy = 1;
		Bot_Pane.add(Filter_Name, gbc_Filter_Name);
		Filter_Name.setColumns(10);
		
		//Apply Button
		JButton Apply_Btn = new JButton("Apply Filter");
		Apply_Btn.setForeground(new Color(0, 153, 255));
		Apply_Btn.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_Apply_Btn = new GridBagConstraints();
		gbc_Apply_Btn.gridwidth = 2;
		gbc_Apply_Btn.insets = new Insets(5, 0, 0, 5);
		gbc_Apply_Btn.gridx = 2;
		gbc_Apply_Btn.gridy = 2;
		Bot_Pane.add(Apply_Btn, gbc_Apply_Btn);
		
		//Top Pane (Info user)
		JPanel Top_Pane = new JPanel();
		contentPane.add(Top_Pane, BorderLayout.NORTH);
		GridBagLayout gbl_Top_Pane = new GridBagLayout();
		gbl_Top_Pane.columnWidths = new int[] {50, 43, 70, 56, 100};
		gbl_Top_Pane.rowHeights = new int[] {30, 0};
		gbl_Top_Pane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_Top_Pane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		Top_Pane.setLayout(gbl_Top_Pane);
		
		JLabel lblNameUser = new JLabel("Name:");
		lblNameUser.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNameUser = new GridBagConstraints();
		gbc_lblNameUser.gridx = 0;
		gbc_lblNameUser.gridy = 0;
		Top_Pane.add(lblNameUser, gbc_lblNameUser);
		
		//Name
		JLabel User_Name = new JLabel("User_Variable");
		User_Name.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_User_Name = new GridBagConstraints();
		gbc_User_Name.insets = new Insets(0, 5, 0, 5);
		gbc_User_Name.gridx = 1;
		gbc_User_Name.gridy = 0;
		Top_Pane.add(User_Name, gbc_User_Name);
		
		JLabel lblRole = new JLabel("Position:");
		lblRole.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblRole = new GridBagConstraints();
		gbc_lblRole.insets = new Insets(0, 15, 0, 5);
		gbc_lblRole.gridx = 2;
		gbc_lblRole.gridy = 0;
		Top_Pane.add(lblRole, gbc_lblRole);
		
		//Role
		JLabel Role = new JLabel("Role_Variable");
		Role.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_Role = new GridBagConstraints();
		gbc_Role.insets = new Insets(0, 5, 0, 5);
		gbc_Role.gridx = 3;
		gbc_Role.gridy = 0;
		Top_Pane.add(Role, gbc_Role);
		
		//Manage Button
		JButton Manage_Btn = new JButton("Manage");
		Manage_Btn.setVisible(false);
		Manage_Btn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_Manage_Btn = new GridBagConstraints();
		gbc_Manage_Btn.gridx = 4;
		gbc_Manage_Btn.gridy = 0;
		Top_Pane.add(Manage_Btn, gbc_Manage_Btn);
	    this.setPreferredSize(new Dimension(800, 600));
	    
	  //Sale Pane
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
	    gbl_panel.rowHeights = new int[] {30, 20, 30, 20, 30, 20, 30, 20, 30, 30};
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
	    
	    JButton Save_Btn = new JButton("Save Info");
	    GridBagConstraints gbc_Save_Btn = new GridBagConstraints();
	    gbc_Save_Btn.anchor = GridBagConstraints.SOUTH;
	    gbc_Save_Btn.fill = GridBagConstraints.HORIZONTAL;
	    gbc_Save_Btn.insets = new Insets(0, 0, 0, 5);
	    gbc_Save_Btn.gridx = 0;
	    gbc_Save_Btn.gridy = 9;
	    panel.add(Save_Btn, gbc_Save_Btn);
	    
	    JButton Sale_Btn = new JButton("Sale");
	    GridBagConstraints gbc_Sale_Btn = new GridBagConstraints();
	    gbc_Sale_Btn.anchor = GridBagConstraints.SOUTH;
	    gbc_Sale_Btn.fill = GridBagConstraints.HORIZONTAL;
	    gbc_Sale_Btn.gridx = 1;
	    gbc_Sale_Btn.gridy = 9;
	    panel.add(Sale_Btn, gbc_Sale_Btn);
    /**
     * Apply Filter Button click even
     * Su ly khi nhan Apply filter
     */
	    Apply_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String status = Filter_Status.getSelectedItem().toString();
				String type = Filter_Type.getSelectedItem().toString();
				String color = Filter_Color.getSelectedItem().toString();
				String trademark = Filter_Trademark.getSelectedItem().toString();
				String name = Filter_Name.getText();
				scrollPane.add(scrollPane, BorderLayout.CENTER);
				contentPane.setLayout(null);
				try {
					DBConnection.init("database.properties");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  Connection conn = null;
				try {
					conn = DBConnection.getConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  cpDAO = new CarProductsDAO(conn);
				  try {
					cpDAO.loadDataFilter(status, type, color, trademark, name);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  tableModel = new CarProductsModel(cpDAO);
			      table = new JTable(tableModel);
			      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
			      table.setAutoCreateRowSorter(true);
			      JScrollPane scrollPane = new JScrollPane(table);
			      scrollPane.setBounds(350, 50, 800, 200);
			      scrollPane.setPreferredSize(new Dimension(900, 200));
			      contentPane.add(scrollPane, BorderLayout.CENTER);
			}
		});
	    Manage_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Manage();
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(true);
				dispose();
			}
		});
	}
	public Application(User user) throws ClassNotFoundException, IOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		this.setVisible(true);
		this.user = user;
	/**
	 * Main _Interface layout
	 * Hien thi sua khi Login thanh cong
	 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Main_Pane = new JPanel();
		contentPane.add(Main_Pane, BorderLayout.CENTER);
		Main_Pane.setLayout(null);
		
		//Data Table
		DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  cpDAO = new CarProductsDAO(conn);
		  cpDAO.loadDataCarToList();
		  tableModel = new CarProductsModel(cpDAO);
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(350, 50, 800, 200);
	      scrollPane.setPreferredSize(new Dimension(900, 200));
		Main_Pane.add(scrollPane, BorderLayout.CENTER);
		
		//Bot Pane (Filter)
		JPanel Bot_Pane = new JPanel();
		contentPane.add(Bot_Pane, BorderLayout.SOUTH);
		GridBagLayout gbl_Bot_Pane = new GridBagLayout();
		gbl_Bot_Pane.columnWidths = new int[] {120, 120, 120, 120, 180};
		gbl_Bot_Pane.rowHeights = new int[] {20, 20, 20};
		gbl_Bot_Pane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_Bot_Pane.rowWeights = new double[]{0.0, 0.0, 0.0};
		Bot_Pane.setLayout(gbl_Bot_Pane);
		
		JLabel lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 0;
		Bot_Pane.add(lblStatus, gbc_lblStatus);
		
		JLabel lblTrademark = new JLabel("Trademark");
		GridBagConstraints gbc_lblTrademark = new GridBagConstraints();
		gbc_lblTrademark.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrademark.gridx = 1;
		gbc_lblTrademark.gridy = 0;
		Bot_Pane.add(lblTrademark, gbc_lblTrademark);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 2;
		gbc_lblType.gridy = 0;
		Bot_Pane.add(lblType, gbc_lblType);
		
		JLabel lblColor = new JLabel("Color");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 3;
		gbc_lblColor.gridy = 0;
		Bot_Pane.add(lblColor, gbc_lblColor);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 4;
		gbc_lblName.gridy = 0;
		Bot_Pane.add(lblName, gbc_lblName);
		
		//Status
		JComboBox Filter_Status = new JComboBox();
		Filter_Status.setForeground(Color.BLACK);
		Filter_Status.setFont(new Font("Arial", Font.BOLD, 13));
		Filter_Status.setModel(new DefaultComboBoxModel(new String[] {"All", "New", "Old"}));
		GridBagConstraints gbc_Filter_Status = new GridBagConstraints();
		gbc_Filter_Status.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Status.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Status.gridx = 0;
		gbc_Filter_Status.gridy = 1;
		Bot_Pane.add(Filter_Status, gbc_Filter_Status);
		
		//Trademark
		JComboBox Filter_Trademark = new JComboBox();
		Filter_Trademark.setForeground(Color.BLACK);
		Filter_Trademark.setFont(new Font("Arial", Font.BOLD, 13));
		Filter_Trademark.setModel(new DefaultComboBoxModel(new String[] {"All", "Honda", "Toyota", "Mazda", "Mitsubishi", "Hyundai", "Kia", "Others"}));
		GridBagConstraints gbc_Filter_Trademark = new GridBagConstraints();
		gbc_Filter_Trademark.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Trademark.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Trademark.gridx = 1;
		gbc_Filter_Trademark.gridy = 1;
		Bot_Pane.add(Filter_Trademark, gbc_Filter_Trademark);
		
		//Type
		JComboBox Filter_Type = new JComboBox();
		Filter_Type.setForeground(Color.BLACK);
		Filter_Type.setFont(new Font("Arial", Font.BOLD, 13));
		Filter_Type.setModel(new DefaultComboBoxModel(new String[] {"All", "Sedan", "HatchBack", "SUV", "Crossover", "MPV", "Pickup", "Others"}));
		GridBagConstraints gbc_Filter_Type = new GridBagConstraints();
		gbc_Filter_Type.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Type.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Type.gridx = 2;
		gbc_Filter_Type.gridy = 1;
		Bot_Pane.add(Filter_Type, gbc_Filter_Type);
		
		//Color
		JComboBox Filter_Color = new JComboBox();
		Filter_Color.setModel(new DefaultComboBoxModel(new String[] {"All", "White", "Black", "Gray", "Silver", "Blue", "Red", "Brown", "Yellow", "Green", "Others"}));
		Filter_Color.setForeground(Color.BLACK);
		Filter_Color.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_Filter_Color = new GridBagConstraints();
		gbc_Filter_Color.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Color.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Color.gridx = 3;
		gbc_Filter_Color.gridy = 1;
		Bot_Pane.add(Filter_Color, gbc_Filter_Color);
		
		//Name
		Filter_Name = new JTextField();
		Filter_Name.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_Filter_Name = new GridBagConstraints();
		gbc_Filter_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_Filter_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Filter_Name.gridx = 4;
		gbc_Filter_Name.gridy = 1;
		Bot_Pane.add(Filter_Name, gbc_Filter_Name);
		Filter_Name.setColumns(10);
		
		//Apply Button
		JButton Apply_Btn = new JButton("Apply Filter");
		Apply_Btn.setForeground(new Color(0, 153, 255));
		Apply_Btn.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_Apply_Btn = new GridBagConstraints();
		gbc_Apply_Btn.gridwidth = 2;
		gbc_Apply_Btn.insets = new Insets(5, 0, 0, 5);
		gbc_Apply_Btn.gridx = 2;
		gbc_Apply_Btn.gridy = 2;
		Bot_Pane.add(Apply_Btn, gbc_Apply_Btn);
		
		//Top Pane (Info user)
		JPanel Top_Pane = new JPanel();
		contentPane.add(Top_Pane, BorderLayout.NORTH);
		GridBagLayout gbl_Top_Pane = new GridBagLayout();
		gbl_Top_Pane.columnWidths = new int[] {50, 43, 70, 56, 100};
		gbl_Top_Pane.rowHeights = new int[] {30, 0};
		gbl_Top_Pane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_Top_Pane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		Top_Pane.setLayout(gbl_Top_Pane);
		
		JLabel lblNameUser = new JLabel("Name:");
		lblNameUser.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNameUser = new GridBagConstraints();
		gbc_lblNameUser.gridx = 0;
		gbc_lblNameUser.gridy = 0;
		Top_Pane.add(lblNameUser, gbc_lblNameUser);
		
		//Name
		JLabel User_Name = new JLabel(user.getName());
		User_Name.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_User_Name = new GridBagConstraints();
		gbc_User_Name.insets = new Insets(0, 5, 0, 5);
		gbc_User_Name.gridx = 1;
		gbc_User_Name.gridy = 0;
		Top_Pane.add(User_Name, gbc_User_Name);
		
		JLabel lblRole = new JLabel("Position:");
		lblRole.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblRole = new GridBagConstraints();
		gbc_lblRole.insets = new Insets(0, 15, 0, 5);
		gbc_lblRole.gridx = 2;
		gbc_lblRole.gridy = 0;
		Top_Pane.add(lblRole, gbc_lblRole);
		
		//Role
		JLabel Role = new JLabel(user.getRole());
		Role.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_Role = new GridBagConstraints();
		gbc_Role.insets = new Insets(0, 5, 0, 5);
		gbc_Role.gridx = 3;
		gbc_Role.gridy = 0;
		Top_Pane.add(Role, gbc_Role);
		
		//Manage Button
		JButton Manage_Btn = new JButton("Manage");
		if(user.getRole().compareTo("Manager")==0 ) {
			Manage_Btn.setVisible(true);
		}
		else {
			Manage_Btn.setVisible(false);
		}
		//Manage_Btn.setEnabled(false);
		Manage_Btn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_Manage_Btn = new GridBagConstraints();
		gbc_Manage_Btn.gridx = 4;
		gbc_Manage_Btn.gridy = 0;
		Top_Pane.add(Manage_Btn, gbc_Manage_Btn);
	    this.setPreferredSize(new Dimension(800, 600));
	    
	    
    /**
     * Apply Filter Button click even
     * Su ly khi nhan Apply filter
     */
	    Apply_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String status = Filter_Status.getSelectedItem().toString();
				String type = Filter_Type.getSelectedItem().toString();
				String color = Filter_Color.getSelectedItem().toString();
				String trademark = Filter_Trademark.getSelectedItem().toString();
				String name = Filter_Name.getText();
				contentPane.add(Main_Pane, BorderLayout.CENTER);
				Main_Pane.setLayout(null);
				try {
					DBConnection.init("database.properties");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  Connection conn = null;
				try {
					conn = DBConnection.getConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  cpDAO = new CarProductsDAO(conn);
				  try {
					cpDAO.loadDataFilter(status, type, color, trademark, name);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  tableModel = new CarProductsModel(cpDAO);
			      table = new JTable(tableModel);
			      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
			      table.setAutoCreateRowSorter(true);
			      JScrollPane scrollPane = new JScrollPane(table);
			      scrollPane.setBounds(350, 50, 800, 200);
			      scrollPane.setPreferredSize(new Dimension(900, 200));
			      Main_Pane.add(scrollPane, BorderLayout.CENTER);
			}
		});
	    
	    	Manage_Btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Manage(Application.this.user);
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(true);
				dispose();
			}
		});
	}

}
