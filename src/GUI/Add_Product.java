package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Add_Product extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Product frame = new Add_Product();
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
	public Add_Product() {
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100, 200, 0};
		gbl_panel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 40};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Status:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		//Status
		JComboBox Status = new JComboBox();
		Status.setModel(new DefaultComboBoxModel(new String[] {"New", "Old"}));
		GridBagConstraints gbc_Status = new GridBagConstraints();
		gbc_Status.fill = GridBagConstraints.BOTH;
		gbc_Status.insets = new Insets(0, 0, 5, 0);
		gbc_Status.gridx = 1;
		gbc_Status.gridy = 0;
		panel.add(Status, gbc_Status);
		
		JLabel lblNewLabel_1 = new JLabel("Trademark:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		//Trademark
		JComboBox Trademark = new JComboBox();
		Trademark.setModel(new DefaultComboBoxModel(new String[] {"Honda", "Toyota", "Mazda", "Mitsubishi", "Hyundai", "Kia", "Others"}));
		GridBagConstraints gbc_Trademark = new GridBagConstraints();
		gbc_Trademark.fill = GridBagConstraints.BOTH;
		gbc_Trademark.insets = new Insets(0, 0, 5, 0);
		gbc_Trademark.gridx = 1;
		gbc_Trademark.gridy = 1;
		panel.add(Trademark, gbc_Trademark);
		
		JLabel lblNewLabel_2 = new JLabel("Type:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//Type
		JComboBox Type = new JComboBox();
		Type.setModel(new DefaultComboBoxModel(new String[] {"Sedan", "HatchBack", "SUV", "Crossover", "MPV", "Pickup", "Others"}));
		GridBagConstraints gbc_Type = new GridBagConstraints();
		gbc_Type.fill = GridBagConstraints.BOTH;
		gbc_Type.insets = new Insets(0, 0, 5, 0);
		gbc_Type.gridx = 1;
		gbc_Type.gridy = 2;
		panel.add(Type, gbc_Type);
		
		JLabel lblNewLabel_3 = new JLabel("Color:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		//Color
		JComboBox Color = new JComboBox();
		Color.setModel(new DefaultComboBoxModel(new String[] {"White", "Black", "Gray", "Silver", "Blue", "Red", "Brown", "Yellow", "Green", "Others"}));
		GridBagConstraints gbc_Color = new GridBagConstraints();
		gbc_Color.fill = GridBagConstraints.BOTH;
		gbc_Color.insets = new Insets(0, 0, 5, 0);
		gbc_Color.gridx = 1;
		gbc_Color.gridy = 3;
		panel.add(Color, gbc_Color);
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		//Name
		Name = new JTextField();
		Name.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.fill = GridBagConstraints.BOTH;
		gbc_Name.insets = new Insets(0, 0, 5, 0);
		gbc_Name.gridx = 1;
		gbc_Name.gridy = 4;
		panel.add(Name, gbc_Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Price:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		//Price
		Price = new JTextField();
		Price.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_Price = new GridBagConstraints();
		gbc_Price.fill = GridBagConstraints.BOTH;
		gbc_Price.insets = new Insets(0, 0, 5, 0);
		gbc_Price.gridx = 1;
		gbc_Price.gridy = 5;
		panel.add(Price, gbc_Price);
		Price.setColumns(10);
		
		//Add Button
		JButton Add_Btn = new JButton("Add Product");
		Add_Btn.setForeground(new Color(0, 153, 255));
		Add_Btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_Add_Btn = new GridBagConstraints();
		gbc_Add_Btn.gridwidth = 2;
		gbc_Add_Btn.fill = GridBagConstraints.BOTH;
		gbc_Add_Btn.insets = new Insets(0, 0, 0, 5);
		gbc_Add_Btn.gridx = 0;
		gbc_Add_Btn.gridy = 6;
		panel.add(Add_Btn, gbc_Add_Btn);
	}

}
