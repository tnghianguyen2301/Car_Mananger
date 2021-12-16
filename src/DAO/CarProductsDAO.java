package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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
	public boolean createNewCarInTable(SimpleCar sCar) throws SQLException {
		String name = sCar.getProducts_name();
		String model = sCar.getProducts_model();
		Double price = sCar.getProducts_add_price();
		String date = sCar.getProducts_add_date().toString();
		
		String query = "INSERT INTO car_products (products_name, products_model, products_add_price, products_add_date)"
				+ " VALUES (?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, name);
		stat.setString(2, model);
		stat.setDouble(3, price);
		stat.setString(4, date);
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
	public ArrayList<SimpleCar>loadDataCarToList() throws SQLException{
		String query = "SELECT * FROM car_products";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next() != false) {
			int id;
			String name, model;
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
				sCar = new SimpleCar(id, name, model, price, date);
				carList.add(sCar);
			}while(result.next() !=false);
		}
		return carList;
	}
}
