import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import DAO.CarHistoryModel;
import DAO.HistoryProdutcsDAO;
import Untilities.DBConnection;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class HistoryPanel extends JPanel {
	private CarHistoryModel tableModel;
	   private JTable table;
	   private HistoryProdutcsDAO hpDAO;
	   private JTextField textField ;
	public HistoryPanel() throws ClassNotFoundException, IOException, SQLException {
		this.setLayout(null);
		  //setBounds(10,100,400,300);
		  textField = new JTextField("Search");
		  textField.setBounds(86, 12, 91, 20);
	      DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  hpDAO = new HistoryProdutcsDAO(conn);
		  hpDAO.loadHistoryCarDataToList();
		  tableModel = new CarHistoryModel(hpDAO);
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	      table.setAutoCreateRowSorter(true);
	      this.add(textField);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(10, 50, 800, 200);
	      this.add(scrollPane);
	      //table.setBounds(10, 200, 800, 200);
	      scrollPane.setPreferredSize(new Dimension(800, 200));
		this.setPreferredSize(new Dimension(800, 600));
		
		JLabel lblNewLabel = new JLabel("Searching: ");
		lblNewLabel.setBounds(10, 13, 66, 17);
		add(lblNewLabel);
		
		JButton btn_search = new JButton("Search");
		btn_search.setBounds(203, 11, 85, 21);
		add(btn_search);
		//this.setVisible(true);
		btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<CarHistoryModel> sorter = new TableRowSorter<CarHistoryModel>(tableModel);
				table.setRowSorter(sorter);
				RowFilter<CarHistoryModel, Object> rFilter = null;
				rFilter = RowFilter.regexFilter(textField.getText(), 0);
				
				sorter.setRowFilter(rFilter);
			}
		});
	}
}
	
