package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.Customer;

public class CustomerDAO {
	private Connection conn;
	private ArrayList<Customer> customerList;
	public CustomerDAO(Connection conn) {
		this.conn = conn;
	}
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	public void addNewCustomerToList(Customer cus) {
		customerList.add(cus);
	}
	public int getNewIDInTableCustomer() throws SQLException {
		int new_id = 1; 
		String query = "SELECT max(customer_id) + 1 FROM car_customer";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next()) {
			if(result.getInt(1) > 0) {
				return result.getInt(1);
			}
		}
		return new_id;
	}
	public boolean createNewCustomerInTable(Customer cus) throws SQLException {
		int id = cus.getCustomer_id();
		String name = cus.getCustomer_name();
		String date = cus.getCustomer_date().toString();
		String address = cus.getCustomer_address();
		String phone = cus.getCustomer_phone();
		int products_id = cus.getCustomer_products_id();
		String query = "INSERT INTO car_customer VALUES(?,?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setInt(1, id);
		stat.setString(2, name);
		stat.setString(3, date);
		stat.setString(4, address);
		stat.setString(5, phone);
		stat.setInt(6, products_id);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean updateCustomerInTable(Customer cus) throws SQLException {
		int id = cus.getCustomer_id();
		String name = cus.getCustomer_name();
		String date = cus.getCustomer_date().toString();
		String address = cus.getCustomer_address();
		String phone = cus.getCustomer_phone();
		String query = "UPDATE car_customer SET customer_name = ?, customer_date = ?, customer_address = ?, customer_phone = ? WHERE customer_id = ?";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, name);
		stat.setString(2, date);
		stat.setString(3, address);
		stat.setString(4, phone);
		stat.setInt(5, id);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public void updateCustomerInList(Customer cus) {
		for(Customer customer : customerList) {
			if(customer.getCustomer_id() == cus.getCustomer_id()) {
				customer.setCustomer_name(cus.getCustomer_name());
				customer.setCustomer_date(cus.getCustomer_date());
				customer.setCustomer_address(cus.getCustomer_address());
				customer.setCustomer_phone(cus.getCustomer_phone());
				break;
			}
		}
	}
	public ArrayList<Customer> loadDataToList() throws SQLException{
		String query = "SELECT * FROM car_customer";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if (result.next() != false) {
			customerList = new ArrayList<Customer>();
			Customer cus;
			int id, products_id;
			String name, address,phone;
			LocalDate date;
			do {
				id = result.getInt(1);
				name = result.getString(2);
				date = LocalDate.parse(result.getString(3));
				address = result.getString(4);
				phone = result.getString(5);
				products_id = result.getInt(6);
				cus = new Customer(id, name, date, address, phone, products_id);
				customerList.add(cus);
			} while (result.next() != false);
		}
		return customerList;
	}
}
