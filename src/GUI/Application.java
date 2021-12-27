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

import DAO.CarProductsDAO;
import DAO.CarProductsModel;
import DAO.HistoryProdutcsDAO;
import Untilities.DBConnection;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel Main_Interface;
	private JTextField Filter_Name;
	private JPanel Manage_Interface;
	private CarProductsModel tableModel;
	private JTable table;
	private CarProductsDAO cpDAO;
	private HistoryProdutcsDAO hpDAO;
	private JButton Back_Main_Interface;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		this.setContentPane(contentPane);
		
	/**
	 * Main _Interface layout
	 * Hien thi sua khi Login thanh cong
	 */
		Main_Interface = new JPanel();
		Main_Interface.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Main_Interface);
		Main_Interface.setLayout(new BorderLayout(0, 0));
		
		JPanel Main_Pane = new JPanel();
		Main_Interface.add(Main_Pane, BorderLayout.CENTER);
		Main_Pane.setLayout(new BorderLayout(0, 0));
		
		//Data Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(800, 200));
		Main_Pane.add(scrollPane, BorderLayout.CENTER);
		
		//Bot Pane (Filter)
		JPanel Bot_Pane = new JPanel();
		Main_Interface.add(Bot_Pane, BorderLayout.SOUTH);
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
		Main_Interface.add(Top_Pane, BorderLayout.NORTH);
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
		Manage_Btn.setEnabled(false);
		Manage_Btn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_Manage_Btn = new GridBagConstraints();
		gbc_Manage_Btn.gridx = 4;
		gbc_Manage_Btn.gridy = 0;
		Top_Pane.add(Manage_Btn, gbc_Manage_Btn);
	    this.setPreferredSize(new Dimension(800, 600));
		    
		    
    /**
     * Manage layout
     * Hien thi khi nhan Manage button trong Main Interface Layout
     */
	    Manage_Interface = new JPanel();
		Manage_Interface.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Manage_Interface);
		
		Manage_Interface.setLayout(new BorderLayout(0, 0));
		
		JPanel Main_Manage_Pane = new JPanel();
		Manage_Interface.add(Main_Manage_Pane, BorderLayout.CENTER);
		Main_Manage_Pane.setLayout(null);
		//Data Table
		  DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  cpDAO = new CarProductsDAO(conn);
		  cpDAO.loadDataCarToList();
		  hpDAO = new HistoryProdutcsDAO(conn);
		  tableModel = new CarProductsModel(cpDAO);
	      table = new JTable(tableModel);
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane1 = new JScrollPane(table);
	      scrollPane1.setBounds(150, 50, 1200, 300);
	      scrollPane1.setPreferredSize(new Dimension(800, 200));
	      this.setPreferredSize(new Dimension(800, 600));
	      Main_Manage_Pane.add(scrollPane1, BorderLayout.CENTER);
		
		//Bot Pane
		JPanel Bot_Manage_Pane = new JPanel();
		Manage_Interface.add(Bot_Manage_Pane, BorderLayout.SOUTH);
		GridBagLayout gbl_Bot_Manage_Pane = new GridBagLayout();
		gbl_Bot_Manage_Pane.columnWidths = new int[] {300, 300};
		gbl_Bot_Manage_Pane.rowHeights = new int[] {40};
		gbl_Bot_Manage_Pane.columnWeights = new double[]{0.0, 0.0};
		gbl_Bot_Manage_Pane.rowWeights = new double[]{0.0};
		Bot_Manage_Pane.setLayout(gbl_Bot_Manage_Pane);
		
		// Add Products Button
		JButton Add_Pd_Btn = new JButton("Add Product");
		Add_Pd_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Add_Pd_Btn = new GridBagConstraints();
		gbc_Add_Pd_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Pd_Btn.insets = new Insets(5, 0, 5, 5);
		gbc_Add_Pd_Btn.gridx = 0;
		gbc_Add_Pd_Btn.gridy = 0;
		Bot_Manage_Pane.add(Add_Pd_Btn, gbc_Add_Pd_Btn);
		
		//Add Account Button
		JButton Add_Acc_Btn = new JButton("Manage Account");
		Add_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_Add_Acc_Btn = new GridBagConstraints();
		gbc_Add_Acc_Btn.insets = new Insets(5, 5, 5, 0);
		gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Acc_Btn.gridx = 1;
		gbc_Add_Acc_Btn.gridy = 0;
		Bot_Manage_Pane.add(Add_Acc_Btn, gbc_Add_Acc_Btn);
		
		//Top Pane
		JPanel Top_Manage_Pane = new JPanel();
		Manage_Interface.add(Top_Manage_Pane, BorderLayout.NORTH);
		Top_Manage_Pane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Transaction history");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		Top_Manage_Pane.add(lblNewLabel, BorderLayout.WEST);
		
		//Back to Main Interface Button
		Back_Main_Interface = new JButton("Back");
		Top_Manage_Pane.add(Back_Main_Interface, BorderLayout.EAST);
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
				String Query = "select * from car_products where ";
				String[] S1 = {status, type, color, trademark, name};
				String[] S2 = {"products_status = ", "products_type = ", "products_color = ", "products_trademark = ", "products_name = "};
				int Save = 0;
				for (int i = 0; i < 6; i++) {
					if (i < 4) {
						if (S1[i] != "All") {
							if(Save > 0) {Query = Query + " and "; Save--;};
							Query = Query + S2[i] + S1[i];
							Save++;
				        }
					} else if (i == 4){
						if (S1[i] != null) {
							if(Save > 0) {Query = Query + " and "; Save--;};
							Query = Query + S2[i] + S1[i];
							Save++;
				        }
					}
				}
			}
		});
	    Back_Main_Interface.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setContentPane(Main_Interface);
		this.revalidate();
	}
	
}
