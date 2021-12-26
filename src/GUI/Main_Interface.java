package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Main_Interface extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Interface frame = new Main_Interface();
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
	public Main_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Table_Contain = new JPanel();
		contentPane.add(Table_Contain, BorderLayout.CENTER);
		Table_Contain.setLayout(new GridLayout(0, 1, 0, 0));
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		Table_Contain.add(table);
		
		JPanel Tool_Contain = new JPanel();
		contentPane.add(Tool_Contain, BorderLayout.SOUTH);
		GridBagLayout gbl_Tool_Contain = new GridBagLayout();
		gbl_Tool_Contain.columnWidths = new int[]{0, 0, 0, 0};
		gbl_Tool_Contain.rowHeights = new int[]{0, 0, 0};
		gbl_Tool_Contain.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Tool_Contain.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		Tool_Contain.setLayout(gbl_Tool_Contain);
		
		JPopupMenu popupMenu = new JPopupMenu();
		GridBagConstraints gbc_popupMenu = new GridBagConstraints();
		gbc_popupMenu.gridx = 0;
		gbc_popupMenu.gridy = 0;
		Tool_Contain.add(popupMenu, gbc_popupMenu);
		
		JPanel Info_Contain = new JPanel();
		contentPane.add(Info_Contain, BorderLayout.EAST);
		GridBagLayout gbl_Info_Contain = new GridBagLayout();
		gbl_Info_Contain.columnWidths = new int[]{0, 0};
		gbl_Info_Contain.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_Info_Contain.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_Info_Contain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Info_Contain.setLayout(gbl_Info_Contain);
		
		JLabel Img = new JLabel("Img");
		GridBagConstraints gbc_Img = new GridBagConstraints();
		gbc_Img.gridheight = 3;
		gbc_Img.insets = new Insets(0, 0, 5, 0);
		gbc_Img.gridx = 0;
		gbc_Img.gridy = 0;
		Info_Contain.add(Img, gbc_Img);
		
		JLabel Name = new JLabel("Name");
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.gridx = 0;
		gbc_Name.gridy = 3;
		Info_Contain.add(Name, gbc_Name);
	}

}
