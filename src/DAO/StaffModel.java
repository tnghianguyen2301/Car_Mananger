package DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import DTO.Staff;

public class StaffModel extends AbstractTableModel {
	private String[] columnName = {"ID","Name","DateofBirth","DateofStart","Position","Salary"};
	private ArrayList<Staff> staffList;
	public StaffModel (StaffDAO sDAO) {
		staffList = sDAO.getStaffList();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		int size ;
		if(staffList == null) {
			 size = 0;
		}
		else{
			size = staffList.size();
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
			temp = new Integer(staffList.get(rowIndex).getStaff_id());
		}
		if(columnIndex == 1) {
			temp = staffList.get(rowIndex).getStaff_name();
		}
		if(columnIndex == 2) {
			temp = staffList.get(rowIndex).getStaff_date();
		}
		if(columnIndex == 3) {
			temp = staffList.get(rowIndex).getStaff_start();
		}
		if(columnIndex == 4) {
			temp = staffList.get(rowIndex).getStaff_position();
		}
		if(columnIndex == 5) {
			temp = new Double(staffList.get(rowIndex).getStaff_salary());
		}
		return temp;
	}
	public String getColumnName(int col) {
		return columnName[col];
	}
	public Class getColumnClass(int col) {
		if(col == 0) {
			return Integer.class;
		}
		if(col == 6) {
			return Double.class;
		}
		if(col == 2 || col == 3) {
			return LocalDate.class;
		}
		else {
			return String.class;
		}
	}
}
