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
public class test extends JFrame implements ActionListener {
   private CarProductsModel tableModel;
   private JTable table;
   private CarProductsDAO myList_dao;
   private HistoryProdutcsDAO hpDAO;
   public test(String title) throws SQLException, ClassNotFoundException, IOException {
      super(title);
      setBounds(10,10,400,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // data
      DBConnection.init("database.properties");
	  Connection conn = DBConnection.getConnection();
      myList_dao = new CarProductsDAO(conn);
      myList_dao.loadDataCarToList();
      hpDAO = new HistoryProdutcsDAO(conn);
//      hpDAO.loadHistoryCarDataToList();
     // tableModel = new CarProductsModel(myList_dao);
      tableModel = new CarProductsModel(myList_dao);
      table = new JTable(tableModel);
      table.setAutoCreateRowSorter(true);
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setPreferredSize(new Dimension(380,280));
      JPanel panel = new JPanel();
      panel.add(scrollPane);
      add(panel,BorderLayout.CENTER);
      
      JPanel panel_control = new JPanel();
      
      JLabel lb1 = new JLabel("ID");
      JLabel lb2 = new JLabel("Name");
      JLabel lb3 = new JLabel("Model");
      JLabel lb4 = new JLabel("Price");
      JLabel lb5 = new JLabel("Date");
      
      lb1.setHorizontalAlignment(JLabel.CENTER);
      lb2.setHorizontalAlignment(JLabel.CENTER);
      lb3.setHorizontalAlignment(JLabel.CENTER);
      lb4.setHorizontalAlignment(JLabel.CENTER);
      lb5.setHorizontalAlignment(JLabel.CENTER);
      
      JTextField tf_id = new JTextField("ID");
      JTextField tf_title = new JTextField("Title");
      JTextField tf_author = new JTextField("Author");
      JTextField tf_price = new JTextField("Price");
      JTextField tf_date = new JTextField("Date");
      JTextField tf_search = new JTextField();
      
      JButton bt_add = new JButton("Add");
      JButton bt_delete = new JButton("Delete");
      JButton bt_update = new JButton("Update");
      JButton bt_clear = new JButton("Clear");
      JButton bt_search = new JButton("Search");
      
      panel_control.setLayout(new GridLayout(3,5));
      panel_control.add(lb1);
      panel_control.add(lb2);
      panel_control.add(lb3);
      panel_control.add(lb4);
      panel_control.add(lb5);
      
      panel_control.add(tf_id);
      panel_control.add(tf_title);
      panel_control.add(tf_author);
      panel_control.add(tf_price);
      panel_control.add(tf_date);
      
      panel_control.add(bt_add);
      panel_control.add(bt_delete);
      panel_control.add(bt_update);
      //panel_control.add(bt_clear);
      panel_control.add(bt_search);
      panel_control.add(tf_search);
      
      add(panel_control, BorderLayout.SOUTH);
      // bt_add
      bt_add.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//int id = Integer.parseInt(tf_id.getText());
			
			LocalDate date;
			try {
				SimpleCar sCar = new SimpleCar();
				HistoryCar hCar = new HistoryCar();
				int products_id = myList_dao.getNewIDInTable();
				int history_id =  hpDAO.getNewIDInHistoryTable();
				String name = tf_title.getText();
				String model = tf_author.getText();
				double price = Double.parseDouble(tf_price.getText());
				date = sCar.getProducts_add_date();
				//tf_date.setText(String.valueOf(date));
				double export_price = hCar.getHistory_export_price();
				//SimpleCar simpleCar = new SimpleCar(products_id,name,model,price,date);
				//HistoryCar historyCar = new HistoryCar(history_id,name,model,price,export_price,date);
				//myList_dao.createNewCarInTable(simpleCar);
				//myList_dao.addNewCarToList(simpleCar);
				//hpDAO.createNewCarHistoryInTable(historyCar);
				//hpDAO.addNewHistoryProducts(historyCar);
				tableModel.fireTableDataChanged();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
      });
      
      //bt_delete
      bt_delete.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int r = table.getSelectedRow();
			if (r != -1){
				int r_model = table.convertRowIndexToModel(r);
				int id = (int) tableModel.getValueAt(r_model, 0);
				try {
					//myList_dao.deleteCarInTable(id);
					hpDAO.updateHistoryInTable(id);
					tableModel.fireTableDataChanged();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
      });
      
      //bt_update
//      bt_update.addActionListener(new ActionListener(){
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
//			int r = table.getSelectedRow();
//			if (r != -1){
//				int r_model = table.convertRowIndexToModel(r);
//				// Truy cap object book tuong ung voi chi so r_model
//				// Thay doi thong tin cua book dua vao cac textField (tru id)
//				int id = Integer.parseInt(tf_id.getText());
//				String title = tf_title.getText();
//				String author = tf_author.getText();
//				double price = Double.parseDouble(tf_price.getText());
//				LocalDate date = LocalDate.parse(tf_date.getText());		
//				SimpleBook update_book = new SimpleBook(id, title, author, price, date);
//				try {
//					myList_dao.updateBookInTable(update_book);
//					myList_dao.updateBookInList(update_book);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				tableModel.fireTableDataChanged();
//			}
//		}
//      });
      
      //bt_search
//      bt_search.addActionListener(new ActionListener(){
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// sorter
//			TableRowSorter<SimpleBookTableModel> sorter = 
//					new TableRowSorter<SimpleBookTableModel>(tableModel);
//			table.setRowSorter(sorter);
//			// filter
//			RowFilter<SimpleBookTableModel, Object> rf = null;
//			rf = RowFilter.regexFilter(tf_search.getText(), 1);
//			
//			sorter.setRowFilter(rf);
//			
//		}
//      });
      
//      table.addMouseListener(new MouseListener(){
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			int r = table.getSelectedRow();
//			int r_model = -1;
//			if (r != -1){
//				r_model = table.convertRowIndexToModel(r);
//			}
//			
//			int c = table.getSelectedColumn();
//			int c_model = -1;
//			if (c != -1){
//				c_model = table.convertColumnIndexToModel(c);
//			}
//			tf_id.setText(String.valueOf(tableModel.getValueAt(r_model, 0)));
//			tf_title.setText((String) tableModel.getValueAt(r_model, 1));
//			tf_author.setText((String) tableModel.getValueAt(r_model, 2));
//			tf_price.setText(String.valueOf(tableModel.getValueAt(r_model, 3)));
//			tf_date.setText(tableModel.getValueAt(r_model, 4).toString());
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
    	  
 //     });
   }
   public void actionPerformed(ActionEvent ae) {

   }
   public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
	   test myApp = new test("Custom Book Table");
       myApp.setVisible(true);

   }
   
}