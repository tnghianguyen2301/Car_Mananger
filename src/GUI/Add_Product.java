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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 200};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 40};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Status:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lblNewLabel, gbc);
		
		//Status
		JComboBox Status = new JComboBox();
		Status.setModel(new DefaultComboBoxModel(new String[] {"New", "Old"}));
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_1.insets = new Insets(0, 0, 5, 0);
		gbc_1.gridx = 1;
		gbc_1.gridy = 0;
		panel.add(Status, gbc_1);
		
		JLabel lblNewLabel_1 = new JLabel("Trademark:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_2 = new GridBagConstraints();
		gbc_2.anchor = GridBagConstraints.WEST;
		gbc_2.insets = new Insets(0, 0, 5, 5);
		gbc_2.gridx = 0;
		gbc_2.gridy = 1;
		panel.add(lblNewLabel_1, gbc_2);
		
		//Trademark
		JComboBox Trademark = new JComboBox();
		Trademark.setModel(new DefaultComboBoxModel(new String[] {"Honda", "Toyota", "Mazda", "Mitsubishi", "Hyundai", "Kia", "Others"}));
		GridBagConstraints gbc_3 = new GridBagConstraints();
		gbc_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_3.insets = new Insets(0, 0, 5, 0);
		gbc_3.gridx = 1;
		gbc_3.gridy = 1;
		panel.add(Trademark, gbc_3);
		
		JLabel lblNewLabel_2 = new JLabel("Type:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_4 = new GridBagConstraints();
		gbc_4.anchor = GridBagConstraints.WEST;
		gbc_4.insets = new Insets(0, 0, 5, 5);
		gbc_4.gridx = 0;
		gbc_4.gridy = 2;
		panel.add(lblNewLabel_2, gbc_4);
		
		//Type
		JComboBox Type = new JComboBox();
		Type.setModel(new DefaultComboBoxModel(new String[] {"Sedan", "HatchBack", "SUV", "Crossover", "MPV", "Pickup", "Others"}));
		GridBagConstraints gbc_5 = new GridBagConstraints();
		gbc_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_5.insets = new Insets(0, 0, 5, 0);
		gbc_5.gridx = 1;
		gbc_5.gridy = 2;
		panel.add(Type, gbc_5);
		
		JLabel lblNewLabel_3 = new JLabel("Color:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_6 = new GridBagConstraints();
		gbc_6.anchor = GridBagConstraints.WEST;
		gbc_6.insets = new Insets(0, 0, 5, 5);
		gbc_6.gridx = 0;
		gbc_6.gridy = 3;
		panel.add(lblNewLabel_3, gbc_6);
		
		//Color
		JComboBox Color = new JComboBox();
		Color.setModel(new DefaultComboBoxModel(new String[] {"White", "Black", "Gray", "Silver", "Blue", "Red", "Brown", "Yellow", "Green", "Others"}));
		GridBagConstraints gbc_7 = new GridBagConstraints();
		gbc_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_7.insets = new Insets(0, 0, 5, 0);
		gbc_7.gridx = 1;
		gbc_7.gridy = 3;
		panel.add(Color, gbc_7);
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_8 = new GridBagConstraints();
		gbc_8.anchor = GridBagConstraints.WEST;
		gbc_8.insets = new Insets(0, 0, 5, 5);
		gbc_8.gridx = 0;
		gbc_8.gridy = 4;
		panel.add(lblNewLabel_4, gbc_8);
		
		//Name
		Name = new JTextField();
		Name.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_9 = new GridBagConstraints();
		gbc_9.fill = GridBagConstraints.BOTH;
		gbc_9.insets = new Insets(0, 0, 5, 0);
		gbc_9.gridx = 1;
		gbc_9.gridy = 4;
		panel.add(Name, gbc_9);
		Name.setColumns(10);
		
		//Add Button
		JButton Add_Btn = new JButton("Add Product");
		Add_Btn.setForeground(new Color(0, 153, 255));
		Add_Btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_Add_Btn = new GridBagConstraints();
		gbc_Add_Btn.fill = GridBagConstraints.HORIZONTAL;
		gbc_Add_Btn.gridwidth = 2;
		gbc_Add_Btn.insets = new Insets(0, 0, 5, 5);
		gbc_Add_Btn.gridx = 0;
		gbc_Add_Btn.gridy = 5;
		panel.add(Add_Btn, gbc_Add_Btn);
	}

}
