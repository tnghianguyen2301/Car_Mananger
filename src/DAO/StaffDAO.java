package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.Staff;


public class StaffDAO {
	private Connection conn;
	private ArrayList<Staff> staffList;
	public StaffDAO(Connection conn) {
		this.conn = conn;
	}
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}
	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}
	public void addNewStaffToList(Staff staff) {
		staffList.add(staff);
	}
	public int getNewIDInTableStaff() throws SQLException {
		int new_id = 1; 
		String query = "SELECT max(staff_id) + 1 FROM car_staff";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next()) {
			if(result.getInt(1) > 0) {
				return result.getInt(1);
			}
		}
		return new_id;
	}
	public boolean createNewStaffInTable(Staff staff) throws SQLException {
		int id = staff.getStaff_id();
		String name = staff.getStaff_name();
		String date = staff.getStaff_date().toString();
		String dateStart = staff.getStaff_start().toString();
		String position = staff.getStaff_position();
		double salary = staff.getStaff_salary();
		String query = "INSERT INTO car_staff VALUES(?,?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setInt(1, id);
		stat.setString(2, name);
		stat.setString(3, date);
		stat.setString(4, dateStart);
		stat.setString(5, position);
		stat.setDouble(6, salary);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean updateStaffInTable(Staff staff) throws SQLException {
		int id = staff.getStaff_id();
		String name = staff.getStaff_name();
		String date = staff.getStaff_date().toString();
		String dateStart = staff.getStaff_start().toString();
		String position = staff.getStaff_position();
		double salary = staff.getStaff_salary();
		String query = "UPDATE car_staff SET staff_name = ?, staff_date = ?, staff_dateofstart = ?, staff_position = ?, staff_salary = ? WHERE staff_id = ?";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, name);
		stat.setString(2, date);
		stat.setString(3, dateStart);
		stat.setString(4, position);
		stat.setDouble(5, salary);
		stat.setInt(6, id);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public void deleteStaffInTable(int id) throws SQLException {
		String query = "DELETE FROM car_staff WHERE staff_id = "+id;
		java.sql.Statement stat = conn.createStatement();
		stat.executeUpdate(query);
		
	}
	public ArrayList<Staff> loadStaffInTable() throws SQLException{
		String query = "SELECT * FROM car_staff";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next() !=false) {
			int id;
			String name, position;
			LocalDate date, dateStart;
			double salary;
			staffList = new ArrayList<Staff>();
			Staff staff;
			do {
				id = result.getInt(1);
				name = result.getString(2);
				date = LocalDate.parse(result.getString(3));
				dateStart = LocalDate.parse(result.getString(4));
				position = result.getString(5);
				salary = result.getDouble(6);
				staff = new Staff(id, name, date, dateStart, position, salary);
				staffList.add(staff);
			} while (result.next()!= false);
		}
		return staffList;
	}
	public void updateStaffInList(Staff s){
		for(Staff staff: staffList){
			if(staff.getStaff_id() == s.getStaff_id()) {
				staff.setStaff_name(s.getStaff_name());
				staff.setStaff_date(s.getStaff_date());
				staff.setStaff_start(s.getStaff_start());
				staff.setStaff_position(s.getStaff_position());
				staff.setStaff_salary(s.getStaff_salary());
				break;
			}
		}
	}
	public void removeStaffFromList(int id){
		for (Staff staff : staffList){
			if(staff.getStaff_id() == id) {
				staffList.remove(staff);
				break;
			}
		}
	}
}
