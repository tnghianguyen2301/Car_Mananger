package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Main_Interface extends JFrame {

	private JPanel Backgound_Interface;
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
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setFont(new Font("Arial", Font.PLAIN, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		Backgound_Interface = new JPanel();
		Backgound_Interface.setBackground(Color.WHITE);
		Backgound_Interface.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Backgound_Interface);
		Backgound_Interface.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(240, 240, 240));
		table.setBounds(20, 20, 400, 250);
		Backgound_Interface.add(table);
		
		JLabel Img = new JLabel("Img");
		Img.setForeground(Color.BLACK);
		Img.setHorizontalAlignment(SwingConstants.CENTER);
		Img.setBackground(Color.LIGHT_GRAY);
		Img.setBounds(440, 20, 120, 160);
		Backgound_Interface.add(Img);
		
		JLabel Name = new JLabel("Name");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setBackground(Color.LIGHT_GRAY);
		Name.setForeground(Color.BLACK);
		Name.setBounds(440, 190, 120, 20);
		Backgound_Interface.add(Name);
	}
}
