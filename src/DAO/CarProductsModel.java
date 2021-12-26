package DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import DTO.SimpleCar;

public class CarProductsModel extends AbstractTableModel {
	private String [] columnNames = {"ID","Name","TradeMark","Type","Color","Status","AddPrice","AddDate","Check"};
	private ArrayList<SimpleCar> carListTbM;
	public CarProductsModel(CarProductsDAO cpDao) {
		carListTbM = cpDao.getCarList();
	}
	

	@Override
	public int getRowCount() {
		int size ;
		if(carListTbM == null) {
			size = 0;
		}
		else {
			size = carListTbM.size();
		}
		return size;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
		if(columnIndex ==0) {
			temp = new Integer(carListTbM.get(rowIndex).getProducts_id());
		}
		if(columnIndex == 1) {
			temp = carListTbM.get(rowIndex).getProducts_name();
		}
		if(columnIndex == 2) {
			temp = carListTbM.get(rowIndex).getProducts_trademark();
		}
		if(columnIndex == 3) {
			temp = carListTbM.get(rowIndex).getProducts_type();
		}
		if(columnIndex == 4) {
			temp = carListTbM.get(rowIndex).getProducts_color();
		}
		if (columnIndex == 5) {
			temp = carListTbM.get(rowIndex).getProducts_status();
		}
		if(columnIndex == 6) {
			temp = new Double(carListTbM.get(rowIndex).getProducts_add_price());
		}
		if(columnIndex == 7) {
			temp = carListTbM.get(rowIndex).getProducts_add_date();
		}
		if(columnIndex == 8) {
			temp = carListTbM.get(rowIndex).getProducts_check();
		}
		return temp;
	}
	public String getColumnName(int col) {
		return columnNames[col];
	}
	public Class getColumnClass(int col) {
		if(col == 0) {
			return Integer.class;
		}
		if(col == 6) {
			return Double.class;
		}
		if(col == 7) {
			return LocalDate.class;
		}
		else {
			return String.class;
		}
	}
}
