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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.result.DoubleValueFactory;

import DAO.CustomerDAO;
import DAO.CustomerModel;
import DAO.StaffDAO;
import DAO.StaffModel;
import DTO.Staff;
import DTO.User;
import Untilities.DBConnection;

public class Staff_Manager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Sta_Name;
	private JTextField Sta_Birth;
	private JTextField Sta_Date;
	private JTextField Sta_Pos;
	private JTextField Sta_Sal;
	private StaffModel tableModel;
	private StaffDAO sDAO;
	private User user;

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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Staff_Manager() throws ClassNotFoundException, IOException, SQLException {
		setTitle("Staff Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Data Table
		DBConnection.init("database.properties");
		Connection conn = DBConnection.getConnection();
		sDAO = new StaffDAO(conn);
		sDAO.loadStaffInTable();
		tableModel = new StaffModel(sDAO);
	    table = new JTable(tableModel);
	    table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	    table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(0, 0, 800, 400);
	    scrollPane.setPreferredSize(new Dimension(800, 400));
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
	    gbl_panel.rowHeights = new int[] {30, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30};
	    gbl_panel.columnWeights = new double[]{0.0, 0.0};
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	    panel.setLayout(gbl_panel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Staff Infomation:");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	    gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNewLabel_1.gridwidth = 2;
	    gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
	    gbc_lblNewLabel_1.gridx = 0;
	    gbc_lblNewLabel_1.gridy = 0;
	    panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Staff Name:");
	    GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2.gridx = 0;
	    gbc_lblNewLabel_2.gridy = 1;
	    panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
	    
	    Sta_Name = new JTextField();
	    Sta_Name.setFont(new Font("Tahoma", Font.BOLD, 11));
	    GridBagConstraints gbc_Sta_Name = new GridBagConstraints();
	    gbc_Sta_Name.gridwidth = 2;
	    gbc_Sta_Name.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Name.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Name.gridx = 0;
	    gbc_Sta_Name.gridy = 2;
	    panel.add(Sta_Name, gbc_Sta_Name);
	    Sta_Name.setColumns(10);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Date of birth:");
	    GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
	    gbc_lblNewLabel_2_1.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_1.gridx = 0;
	    gbc_lblNewLabel_2_1.gridy = 3;
	    panel.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
	    
	    Sta_Birth = new JTextField();
	    Sta_Birth.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Birth.setColumns(10);
	    GridBagConstraints gbc_Sta_Birth = new GridBagConstraints();
	    gbc_Sta_Birth.gridwidth = 2;
	    gbc_Sta_Birth.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Birth.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Birth.gridx = 0;
	    gbc_Sta_Birth.gridy = 4;
	    panel.add(Sta_Birth, gbc_Sta_Birth);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Start day:");
	    GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2.gridx = 0;
	    gbc_lblNewLabel_2_2.gridy = 5;
	    panel.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);
	    
	    Sta_Date = new JTextField();
	    Sta_Date.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Date.setColumns(10);
	    GridBagConstraints gbc_Sta_Date = new GridBagConstraints();
	    gbc_Sta_Date.gridwidth = 2;
	    gbc_Sta_Date.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Date.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Date.gridx = 0;
	    gbc_Sta_Date.gridy = 6;
	    panel.add(Sta_Date, gbc_Sta_Date);
	    
	    JLabel lblNewLabel_2_2_1 = new JLabel("Position:");
	    GridBagConstraints gbc_lblNewLabel_2_2_1 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2_1.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2_1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2_1.gridx = 0;
	    gbc_lblNewLabel_2_2_1.gridy = 7;
	    panel.add(lblNewLabel_2_2_1, gbc_lblNewLabel_2_2_1);
	    
	    Sta_Pos = new JTextField();
	    Sta_Pos.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Pos.setColumns(10);
	    GridBagConstraints gbc_Sta_Pos = new GridBagConstraints();
	    gbc_Sta_Pos.gridwidth = 2;
	    gbc_Sta_Pos.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Pos.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Pos.gridx = 0;
	    gbc_Sta_Pos.gridy = 8;
	    panel.add(Sta_Pos, gbc_Sta_Pos);
	    
	    JLabel lblNewLabel_2_2_2 = new JLabel("Salary:");
	    GridBagConstraints gbc_lblNewLabel_2_2_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2_2.gridx = 0;
	    gbc_lblNewLabel_2_2_2.gridy = 9;
	    panel.add(lblNewLabel_2_2_2, gbc_lblNewLabel_2_2_2);
	    
	    Sta_Sal = new JTextField();
	    Sta_Sal.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Sal.setColumns(10);
	    GridBagConstraints gbc_Sta_Sal = new GridBagConstraints();
	    gbc_Sta_Sal.gridwidth = 2;
	    gbc_Sta_Sal.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Sal.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Sal.gridx = 0;
	    gbc_Sta_Sal.gridy = 10;
	    panel.add(Sta_Sal, gbc_Sta_Sal);
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
				Sta_Name.setText((String) tableModel.getValueAt(r_model, 1));
				Sta_Birth.setText(tableModel.getValueAt(r_model, 2).toString());
				Sta_Date.setText(tableModel.getValueAt(r_model, 3).toString());
				Sta_Pos.setText((String) tableModel.getValueAt(r_model, 4));
				Sta_Sal.setText(tableModel.getValueAt(r_model, 5).toString());
			}
		});
	    Del_Acc_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if(r != -1) {
					int r_model = table.convertRowIndexToModel(r);
					int id = (int) tableModel.getValueAt(r_model, 0);
					try {
						sDAO.deleteStaffInTable(id);
						sDAO.removeStaffFromList(id);
						tableModel.fireTableDataChanged();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
	    Add_Acc_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = 0;
				try {
					id = sDAO.getNewIDInTableStaff();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String name = Sta_Name.getText();
				LocalDate date = LocalDate.parse(Sta_Birth.getText());
				LocalDate dateStart = LocalDate.parse(Sta_Date.getText());
				String position = Sta_Pos.getText();
				double salary = Double.parseDouble(Sta_Sal.getText());
				Staff staff = new Staff(id, name, date, dateStart, position, salary);
				try {
					sDAO.createNewStaffInTable(staff);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sDAO.addNewStaffToList(staff);
				tableModel.fireTableDataChanged();
			}
		});
	    Edit_Acc_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if(r != -1) {
					int r_model = table.convertRowIndexToModel(r);
					int id = (int) tableModel.getValueAt(r_model, 0);
					String name = Sta_Name.getText();
					LocalDate date = LocalDate.parse(Sta_Birth.getText());
					LocalDate dateStart = LocalDate.parse(Sta_Date.getText());
					String position = Sta_Pos.getText();
					double salary = Double.parseDouble(Sta_Sal.getText());
					Staff staff = new Staff(id, name, date, dateStart, position, salary);
					try {
						sDAO.updateStaffInTable(staff);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sDAO.updateStaffInList(staff);
					tableModel.fireTableDataChanged();
							
				}
			}
		});
	    Back_Main_Interface.addActionListener(new ActionListener() {
			
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
	public Staff_Manager(User user) throws ClassNotFoundException, IOException, SQLException {
		setTitle("Staff Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		this.user = user;
		
		//Data Table
		DBConnection.init("database.properties");
		Connection conn = DBConnection.getConnection();
		sDAO = new StaffDAO(conn);
		sDAO.loadStaffInTable();
		tableModel = new StaffModel(sDAO);
	    table = new JTable(tableModel);
	    table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	    table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(0, 0, 800, 400);
	    scrollPane.setPreferredSize(new Dimension(800, 400));
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
	    gbl_panel.rowHeights = new int[] {30, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30};
	    gbl_panel.columnWeights = new double[]{0.0, 0.0};
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	    panel.setLayout(gbl_panel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Staff Infomation:");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	    gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNewLabel_1.gridwidth = 2;
	    gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
	    gbc_lblNewLabel_1.gridx = 0;
	    gbc_lblNewLabel_1.gridy = 0;
	    panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Staff Name:");
	    GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2.gridx = 0;
	    gbc_lblNewLabel_2.gridy = 1;
	    panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
	    
	    Sta_Name = new JTextField();
	    Sta_Name.setFont(new Font("Tahoma", Font.BOLD, 11));
	    GridBagConstraints gbc_Sta_Name = new GridBagConstraints();
	    gbc_Sta_Name.gridwidth = 2;
	    gbc_Sta_Name.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Name.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Name.gridx = 0;
	    gbc_Sta_Name.gridy = 2;
	    panel.add(Sta_Name, gbc_Sta_Name);
	    Sta_Name.setColumns(10);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Date of birth:");
	    GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
	    gbc_lblNewLabel_2_1.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_1.gridx = 0;
	    gbc_lblNewLabel_2_1.gridy = 3;
	    panel.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
	    
	    Sta_Birth = new JTextField();
	    Sta_Birth.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Birth.setColumns(10);
	    GridBagConstraints gbc_Sta_Birth = new GridBagConstraints();
	    gbc_Sta_Birth.gridwidth = 2;
	    gbc_Sta_Birth.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Birth.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Birth.gridx = 0;
	    gbc_Sta_Birth.gridy = 4;
	    panel.add(Sta_Birth, gbc_Sta_Birth);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Start day:");
	    GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2.gridx = 0;
	    gbc_lblNewLabel_2_2.gridy = 5;
	    panel.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);
	    
	    Sta_Date = new JTextField();
	    Sta_Date.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Date.setColumns(10);
	    GridBagConstraints gbc_Sta_Date = new GridBagConstraints();
	    gbc_Sta_Date.gridwidth = 2;
	    gbc_Sta_Date.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Date.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Date.gridx = 0;
	    gbc_Sta_Date.gridy = 6;
	    panel.add(Sta_Date, gbc_Sta_Date);
	    
	    JLabel lblNewLabel_2_2_1 = new JLabel("Position:");
	    GridBagConstraints gbc_lblNewLabel_2_2_1 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2_1.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2_1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2_1.gridx = 0;
	    gbc_lblNewLabel_2_2_1.gridy = 7;
	    panel.add(lblNewLabel_2_2_1, gbc_lblNewLabel_2_2_1);
	    
	    Sta_Pos = new JTextField();
	    Sta_Pos.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Pos.setColumns(10);
	    GridBagConstraints gbc_Sta_Pos = new GridBagConstraints();
	    gbc_Sta_Pos.gridwidth = 2;
	    gbc_Sta_Pos.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Pos.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Pos.gridx = 0;
	    gbc_Sta_Pos.gridy = 8;
	    panel.add(Sta_Pos, gbc_Sta_Pos);
	    
	    JLabel lblNewLabel_2_2_2 = new JLabel("Salary:");
	    GridBagConstraints gbc_lblNewLabel_2_2_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2_2_2.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel_2_2_2.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_2_2_2.gridx = 0;
	    gbc_lblNewLabel_2_2_2.gridy = 9;
	    panel.add(lblNewLabel_2_2_2, gbc_lblNewLabel_2_2_2);
	    
	    Sta_Sal = new JTextField();
	    Sta_Sal.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Sta_Sal.setColumns(10);
	    GridBagConstraints gbc_Sta_Sal = new GridBagConstraints();
	    gbc_Sta_Sal.gridwidth = 2;
	    gbc_Sta_Sal.fill = GridBagConstraints.BOTH;
	    gbc_Sta_Sal.insets = new Insets(0, 0, 5, 0);
	    gbc_Sta_Sal.gridx = 0;
	    gbc_Sta_Sal.gridy = 10;
	    panel.add(Sta_Sal, gbc_Sta_Sal);
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
				Sta_Name.setText((String) tableModel.getValueAt(r_model, 1));
				Sta_Birth.setText(tableModel.getValueAt(r_model, 2).toString());
				Sta_Date.setText(tableModel.getValueAt(r_model, 3).toString());
				Sta_Pos.setText((String) tableModel.getValueAt(r_model, 4));
				Sta_Sal.setText(tableModel.getValueAt(r_model, 5).toString());
			}
		});
	    Del_Acc_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if(r != -1) {
					int r_model = table.convertRowIndexToModel(r);
					int id = (int) tableModel.getValueAt(r_model, 0);
					try {
						sDAO.deleteStaffInTable(id);
						sDAO.removeStaffFromList(id);
						tableModel.fireTableDataChanged();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
	    Add_Acc_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = 0;
				try {
					id = sDAO.getNewIDInTableStaff();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String name = Sta_Name.getText();
				LocalDate date = LocalDate.parse(Sta_Birth.getText());
				LocalDate dateStart = LocalDate.parse(Sta_Date.getText());
				String position = Sta_Pos.getText();
				double salary = Double.parseDouble(Sta_Sal.getText());
				Staff staff = new Staff(id, name, date, dateStart, position, salary);
				try {
					sDAO.createNewStaffInTable(staff);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sDAO.addNewStaffToList(staff);
				tableModel.fireTableDataChanged();
			}
		});
	    Edit_Acc_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if(r != -1) {
					int r_model = table.convertRowIndexToModel(r);
					int id = (int) tableModel.getValueAt(r_model, 0);
					String name = Sta_Name.getText();
					LocalDate date = LocalDate.parse(Sta_Birth.getText());
					LocalDate dateStart = LocalDate.parse(Sta_Date.getText());
					String position = Sta_Pos.getText();
					double salary = Double.parseDouble(Sta_Sal.getText());
					Staff staff = new Staff(id, name, date, dateStart, position, salary);
					try {
						sDAO.updateStaffInTable(staff);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sDAO.updateStaffInList(staff);
					tableModel.fireTableDataChanged();
							
				}
			}
		});
	    Back_Main_Interface.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Manage(Staff_Manager.this.user);
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
