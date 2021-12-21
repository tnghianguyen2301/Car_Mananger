import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.CarHistoryModel;
import DAO.HistoryProdutcsDAO;
import Untilities.DBConnection;

public class HistoryPanel extends JPanel {
	private CarHistoryModel tableModel;
	   private JTable table;
	   private HistoryProdutcsDAO hpDAO;
	public HistoryPanel() throws ClassNotFoundException, IOException, SQLException {
		setBounds(10,10,400,300);
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
	      add(panel,BorderLayout.WEST);

		this.setPreferredSize(new Dimension(800, 600));
		this.setVisible(true);
	}
}
