package DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import DTO.SimpleCar;

public class CarProductsModel extends AbstractTableModel {
	private String [] columnNames = {"ID","Name","Model","AddPrice","AddDate"};
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
		if(columnIndex ==1) {
			temp = carListTbM.get(rowIndex).getProducts_name();
		}
		if(columnIndex ==2) {
			temp = carListTbM.get(rowIndex).getProducts_model();
		}
		if(columnIndex ==3) {
			temp = new Double(carListTbM.get(rowIndex).getProducts_add_price());
		}
		if(columnIndex ==4) {
			temp =carListTbM.get(rowIndex).getProducts_add_date();
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
		if(col == 3) {
			return Double.class;
		}
		if(col == 4) {
			return LocalDate.class;
		}
		else {
			return String.class;
		}
	}
}
