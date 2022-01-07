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

import javax.swing.ImageIcon;
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
import java.awt.GridLayout;
import java.awt.FlowLayout;

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
		setBounds(100, 100, 900, 510);
		Manage_Interface = new JPanel();
		Manage_Interface.setBorder(new EmptyBorder(5, 5, 5, 5));
		Manage_Interface.setLayout(new BorderLayout(0, 0));
		setContentPane(Manage_Interface);
		this.setVisible(true);
		
		JPanel Main_Manage_Pane = new JPanel();
		Manage_Interface.add(Main_Manage_Pane, BorderLayout.CENTER);
		
		//Data Table
		  DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  cpDAO = new CarProductsDAO(conn);
		  cpDAO.loadDataCarToList();
		  hpDAO = new HistoryProdutcsDAO(conn);
		  hpDAO.loadHistoryCarDataToList();
		  tableModel = new CarHistoryModel(hpDAO);
	      Main_Manage_Pane.setLayout(new GridLayout(0, 1, 0, 0));
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setPreferredSize(new Dimension(800, 400));
	      Main_Manage_Pane.add(scrollPane);
		
	    //Bot Pane
	      JPanel Bot_Manage_Pane = new JPanel();
	      Manage_Interface.add(Bot_Manage_Pane, BorderLayout.SOUTH);
	      GridBagLayout gbl_Bot_Manage_Pane = new GridBagLayout();
	      gbl_Bot_Manage_Pane.columnWidths = new int[] {120, 120, 120, 120, 120};
	      gbl_Bot_Manage_Pane.rowHeights = new int[] {35};
	      gbl_Bot_Manage_Pane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
	      gbl_Bot_Manage_Pane.rowWeights = new double[]{0.0};
	      Bot_Manage_Pane.setLayout(gbl_Bot_Manage_Pane);
		
	      	JButton Add_Pd_Btn = new JButton("Add Product");
	      	Add_Pd_Btn.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent e) {
	      		}
	      	});
			Add_Pd_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Add_Pd_Btn = new GridBagConstraints();
			gbc_Add_Pd_Btn.fill = GridBagConstraints.BOTH;
			gbc_Add_Pd_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Add_Pd_Btn.gridx = 0;
			gbc_Add_Pd_Btn.gridy = 0;
			Bot_Manage_Pane.add(Add_Pd_Btn, gbc_Add_Pd_Btn);
			ImageIcon Add_Pd_Icon = new ImageIcon(this.getClass().getResource("/Add_Icon.png"));
			Add_Pd_Btn.setIcon(Add_Pd_Icon);
			
			JButton Add_Acc_Btn = new JButton("Manage Account");
			Add_Acc_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			Add_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Add_Acc_Btn = new GridBagConstraints();
			gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
			gbc_Add_Acc_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Add_Acc_Btn.gridx = 1;
			gbc_Add_Acc_Btn.gridy = 0;
			Bot_Manage_Pane.add(Add_Acc_Btn, gbc_Add_Acc_Btn);
			ImageIcon User_Icon = new ImageIcon(this.getClass().getResource("/User_Icon.png"));
			Add_Acc_Btn.setIcon(User_Icon);
		
			JButton Man_Cus_Btn = new JButton("Manage Customer");
			Man_Cus_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Man_Cus_Btn = new GridBagConstraints();
			gbc_Man_Cus_Btn.fill = GridBagConstraints.BOTH;
			gbc_Man_Cus_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Man_Cus_Btn.gridx = 2;
			gbc_Man_Cus_Btn.gridy = 0;
			Bot_Manage_Pane.add(Man_Cus_Btn, gbc_Man_Cus_Btn);
			ImageIcon Add_Cus_Icon = new ImageIcon(this.getClass().getResource("/Customer_Icon.png"));
			Man_Cus_Btn.setIcon(Add_Cus_Icon);
		
			JButton Rep_Car_Btn = new JButton("Report Car Type");
			Rep_Car_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			Rep_Car_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Rep_Car_Btn = new GridBagConstraints();
			gbc_Rep_Car_Btn.fill = GridBagConstraints.BOTH;
			gbc_Rep_Car_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Rep_Car_Btn.gridx = 3;
			gbc_Rep_Car_Btn.gridy = 0;
			Bot_Manage_Pane.add(Rep_Car_Btn, gbc_Rep_Car_Btn);
			ImageIcon Car_Icon = new ImageIcon(this.getClass().getResource("/Car_Icon.png"));
			Rep_Car_Btn.setIcon(Car_Icon);
		
			JButton Rep_Tur_Btn = new JButton("Report Turnover");
			Rep_Tur_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			Rep_Tur_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Rep_Tur_Btn = new GridBagConstraints();
			gbc_Rep_Tur_Btn.fill = GridBagConstraints.BOTH;
			gbc_Rep_Tur_Btn.gridx = 4;
			gbc_Rep_Tur_Btn.gridy = 0;
			Bot_Manage_Pane.add(Rep_Tur_Btn, gbc_Rep_Tur_Btn);
			ImageIcon Turnover_Icon = new ImageIcon(this.getClass().getResource("/Report_Icon.png"));
			Rep_Tur_Btn.setIcon(Turnover_Icon);
		
		//Top Pane
		JPanel Top_Manage_Pane = new JPanel();
		Manage_Interface.add(Top_Manage_Pane, BorderLayout.NORTH);
		Top_Manage_Pane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Transaction history");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		Top_Manage_Pane.add(lblNewLabel, BorderLayout.WEST);
		
		JButton Back_Main_Interface = new JButton("Back");
		Top_Manage_Pane.add(Back_Main_Interface, BorderLayout.EAST);
        ImageIcon Back_Icon = new ImageIcon(this.getClass().getResource("/Back_Icon.png"));
        Back_Main_Interface.setIcon(Back_Icon);
		
		JPanel Offset_Top = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Offset_Top.getLayout();
		flowLayout.setVgap(3);
		Top_Manage_Pane.add(Offset_Top, BorderLayout.NORTH);
		
		JPanel Offset_Bot = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) Offset_Bot.getLayout();
		flowLayout_1.setVgap(3);
		Top_Manage_Pane.add(Offset_Bot, BorderLayout.SOUTH);
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
		setTitle("Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 510);
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
	      Main_Manage_Pane.setLayout(new GridLayout(0, 1, 0, 0));
	      table = new JTable(tableModel);
<<<<<<< HEAD
	      table.setFont(new Font("Constantia", Font.PLAIN, 15));
=======
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
>>>>>>> branch 'master' of https://github.com/nhocwhy05/Car_Mananger
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(0, 0, 800, 400);
	      scrollPane.setPreferredSize(new Dimension(800, 400));
	      Main_Manage_Pane.add(scrollPane, BorderLayout.CENTER);
		
	    //Bot Pane
	      JPanel Bot_Manage_Pane = new JPanel();
	      Manage_Interface.add(Bot_Manage_Pane, BorderLayout.SOUTH);
	      GridBagLayout gbl_Bot_Manage_Pane = new GridBagLayout();
	      gbl_Bot_Manage_Pane.columnWidths = new int[] {120, 120, 120, 120, 120};
	      gbl_Bot_Manage_Pane.rowHeights = new int[] {35};
	      gbl_Bot_Manage_Pane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
	      gbl_Bot_Manage_Pane.rowWeights = new double[]{0.0};
	      Bot_Manage_Pane.setLayout(gbl_Bot_Manage_Pane);
		
	      	JButton Add_Pd_Btn = new JButton("Add Product");
			Add_Pd_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Add_Pd_Btn = new GridBagConstraints();
			gbc_Add_Pd_Btn.fill = GridBagConstraints.BOTH;
			gbc_Add_Pd_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Add_Pd_Btn.gridx = 0;
			gbc_Add_Pd_Btn.gridy = 0;
			Bot_Manage_Pane.add(Add_Pd_Btn, gbc_Add_Pd_Btn);
			ImageIcon Add_Pd_Icon = new ImageIcon(this.getClass().getResource("/Add_Icon.png"));
			Add_Pd_Btn.setIcon(Add_Pd_Icon);
			
			JButton Add_Acc_Btn = new JButton("Manage Staff");
			Add_Acc_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Add_Acc_Btn = new GridBagConstraints();
			gbc_Add_Acc_Btn.fill = GridBagConstraints.BOTH;
			gbc_Add_Acc_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Add_Acc_Btn.gridx = 1;
			gbc_Add_Acc_Btn.gridy = 0;
			Bot_Manage_Pane.add(Add_Acc_Btn, gbc_Add_Acc_Btn);
			ImageIcon User_Icon = new ImageIcon(this.getClass().getResource("/User_Icon.png"));
			Add_Acc_Btn.setIcon(User_Icon);
		
			JButton Man_Cus_Btn = new JButton("Manage Customer");
			Man_Cus_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Man_Cus_Btn = new GridBagConstraints();
			gbc_Man_Cus_Btn.fill = GridBagConstraints.BOTH;
			gbc_Man_Cus_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Man_Cus_Btn.gridx = 2;
			gbc_Man_Cus_Btn.gridy = 0;
			Bot_Manage_Pane.add(Man_Cus_Btn, gbc_Man_Cus_Btn);
			ImageIcon Add_Cus_Icon = new ImageIcon(this.getClass().getResource("/Customer_Icon.png"));
			Man_Cus_Btn.setIcon(Add_Cus_Icon);
		
			JButton Rep_Car_Btn = new JButton("Report Car Type");
			Rep_Car_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Rep_Car_Btn = new GridBagConstraints();
			gbc_Rep_Car_Btn.fill = GridBagConstraints.BOTH;
			gbc_Rep_Car_Btn.insets = new Insets(0, 0, 0, 5);
			gbc_Rep_Car_Btn.gridx = 3;
			gbc_Rep_Car_Btn.gridy = 0;
			Bot_Manage_Pane.add(Rep_Car_Btn, gbc_Rep_Car_Btn);
			ImageIcon Car_Icon = new ImageIcon(this.getClass().getResource("/Car_Icon.png"));
			Rep_Car_Btn.setIcon(Car_Icon);
		
			JButton Rep_Tur_Btn = new JButton("Report Turnover");
			Rep_Tur_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_Rep_Tur_Btn = new GridBagConstraints();
			gbc_Rep_Tur_Btn.fill = GridBagConstraints.BOTH;
			gbc_Rep_Tur_Btn.gridx = 4;
			gbc_Rep_Tur_Btn.gridy = 0;
			Bot_Manage_Pane.add(Rep_Tur_Btn, gbc_Rep_Tur_Btn);
			ImageIcon Turnover_Icon = new ImageIcon(this.getClass().getResource("/Report_Icon.png"));
			Rep_Tur_Btn.setIcon(Turnover_Icon);
		
		//Top Pane
		JPanel Top_Manage_Pane = new JPanel();
		Manage_Interface.add(Top_Manage_Pane, BorderLayout.NORTH);
		Top_Manage_Pane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Transaction history");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		Top_Manage_Pane.add(lblNewLabel, BorderLayout.WEST);
		
		JButton Back_Main_Interface = new JButton("Back");
		Top_Manage_Pane.add(Back_Main_Interface, BorderLayout.EAST);
		ImageIcon Back_Icon = new ImageIcon(this.getClass().getResource("/Back_Icon.png"));
        Back_Main_Interface.setIcon(Back_Icon);
	    this.setPreferredSize(new Dimension(800, 600));
	    
	    JPanel Offset_Top = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Offset_Top.getLayout();
		flowLayout.setVgap(3);
		Top_Manage_Pane.add(Offset_Top, BorderLayout.NORTH);
		
		JPanel Offset_Bot = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) Offset_Bot.getLayout();
		flowLayout_1.setVgap(3);
		Top_Manage_Pane.add(Offset_Bot, BorderLayout.SOUTH);
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
	    Man_Cus_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Customer_Manager(Manage.this.user);
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
	   Add_Acc_Btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				new Staff_Manager(Manage.this.user);
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
