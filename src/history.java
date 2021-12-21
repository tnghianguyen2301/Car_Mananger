import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import DAO.CarHistoryModel;
import DAO.CarProductsDAO;
import DAO.CarProductsModel;
import DAO.HistoryProdutcsDAO;
import DTO.HistoryCar;
import DTO.SimpleCar;
import Untilities.DBConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
public class history extends JFrame  {
	   private CarHistoryModel tableModel;
	   private JTable table;
	   private HistoryProdutcsDAO hpDAO;
	   public history (String title) throws ClassNotFoundException, IOException, SQLException {
		   super(title);
		      setBounds(10,10,400,300);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      DBConnection.init("database.properties");
			  Connection conn = DBConnection.getConnection();
			  hpDAO = new HistoryProdutcsDAO(conn);
			  hpDAO.loadHistoryCarDataToList();
			  tableModel = new CarHistoryModel(hpDAO);
		      table = new JTable(tableModel);
		      table.setAutoCreateRowSorter(true);
		      JScrollPane scrollPane = new JScrollPane(table);
		      scrollPane.setPreferredSize(new Dimension(380,280));
		      JPanel panel = new JPanel();
		      panel.add(scrollPane);
		      add(panel,BorderLayout.CENTER);
	   }

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		 history myApp = new history("Custom Book Table");
	     myApp.setVisible(true);
	}

}
