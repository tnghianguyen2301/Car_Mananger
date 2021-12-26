package DAO;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.lang.model.element.NestingKind;

import DTO.SimpleCar;

public class CarProductsDAO {
	private Connection conn;
	private ArrayList<SimpleCar> carList;
	public CarProductsDAO(Connection conn) {
		this.conn = conn;
	}
	public ArrayList<SimpleCar> getCarList(){
		return carList;
	}
	public void setCarList(ArrayList<SimpleCar> carList) {
		this.carList = carList;
	}
	public void addNewCarToList(SimpleCar sCar) {
		carList.add(sCar);
	}
	public int getNewIDInTable() throws SQLException {
		int new_id = 1; 
		String query = "SELECT max(products_id) + 1 FROM car_products";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next()) {
			if(result.getInt(1) > 0) {
				return result.getInt(1);
			}
		}
		return new_id;
	}
	public boolean createNewCarInTable(SimpleCar sCar) throws SQLException {
		String name = sCar.getProducts_name();
		String model = sCar.getProducts_model();
		Double price = sCar.getProducts_add_price();
		String date = sCar.getProducts_add_date().toString();
		String status = sCar.getProducts_status();
		String query = "INSERT INTO car_products (products_name, products_model, products_add_price, products_add_date, products_status)"
				+ " VALUES (?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, name);
		stat.setString(2, model);
		stat.setDouble(3, price);
		stat.setString(4, date);
		stat.setString(5, status);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean deleteCarInTable(int id) throws SQLException {
		String query = "DELETE FROM car_products WHERE products_id = ?";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setInt(1, id);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean updateStatus (int id) throws SQLException {
		SimpleCar sc = new SimpleCar();
		String upStatus = "Sold Out";
		String query = "UPDATE car_products set products_status = ? WHERE products_id = ? ";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, upStatus);
		stat.setInt(2, id);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else
			return false;
	}
	public void updateCarInList(int id, String update) {
		for(SimpleCar cars : carList) {
			if(cars.getProducts_id() == id) {
				cars.setProducts_status(update);
			}
		}
	}
	public ArrayList<SimpleCar>loadDataCarToList() throws SQLException{
		String query = "SELECT * FROM car_products";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next() != false) {
			int id;
			String name, model, status;
			Double price;
			LocalDate date;
			SimpleCar sCar;
			carList = new ArrayList<SimpleCar>();
			do {
				id = result.getInt(1);
				name = result.getString(2);
				model = result.getString(3);
				price = result.getDouble(4);
				date = LocalDate.parse(result.getString(5));
				status = result.getString(6);
				sCar = new SimpleCar(id, name, model, price, date, status);
				carList.add(sCar);
			}while(result.next() !=false);
		}
		return carList;
	}
}
