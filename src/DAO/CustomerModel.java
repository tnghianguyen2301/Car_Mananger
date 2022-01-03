package DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import DTO.Customer;

public class CustomerModel extends AbstractTableModel {
	private String [] columnName = {"ID","Name","Date of Birth","Address","Phone","Products ID"};
	private ArrayList<Customer> customerListTbM;
	public CustomerModel(CustomerDAO cDao) {
		customerListTbM = cDao.getCustomerList();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		int size;
		if(customerListTbM == null) {
			size = 0;
		}
		else {
			size = customerListTbM.size();
		}
		return size;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object temp = null;
			if(columnIndex == 0) {
				temp = new Integer(customerListTbM.get(rowIndex).getCustomer_id());
			}
			if(columnIndex == 1) {
				temp = customerListTbM.get(rowIndex).getCustomer_name();
			}
			if(columnIndex == 2) {
				temp = customerListTbM.get(rowIndex).getCustomer_date();
			}
			if(columnIndex == 3) {
				temp = customerListTbM.get(rowIndex).getCustomer_address();
			}
			if(columnIndex == 4) {
				temp = customerListTbM.get(rowIndex).getCustomer_phone();
			}
			if(columnIndex == 5) {
				temp = new Integer(customerListTbM.get(rowIndex).getCustomer_products_id());
			}
		return temp;
	}
	public String getColumnName(int col) {
		return columnName[col];
	}
	public Class getColumnClass(int col) {
		if(col == 0 && col == 5) {
			return Integer.class;
		}
		if(col == 2) {
			return LocalDate.class;
		}
		else {
			return String.class;
		}
	}
}
