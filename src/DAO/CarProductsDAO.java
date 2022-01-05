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
		String trademark = sCar.getProducts_trademark();
		String type = sCar.getProducts_type();
		String color = sCar.getProducts_color();
		String status = sCar.getProducts_status();
		Double price = sCar.getProducts_export_price();
		String date = sCar.getProducts_add_date().toString();
		String check = sCar.getProducts_check();
		String query = "INSERT INTO car_products (products_name, products_trademark, products_type, products_color, products_status,"
				+ " products_add_price, products_add_date, products_check)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, name);
		stat.setString(2, trademark);
		stat.setString(3, type);
		stat.setString(4, color);
		stat.setString(5, status);
		stat.setDouble(6, price);
		stat.setString(7, date);
		stat.setString(8, check);
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
		String query = "UPDATE car_products set products_check = ? WHERE products_id = ? ";
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
				cars.setProducts_check(update);
			}
		}
	}
	public ArrayList<SimpleCar>loadDataCarToList() throws SQLException{
		String query = "SELECT * FROM car_products";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next() != false) {
			int id;
			String name, trademark, status, type, color, check;
			Double price;
			LocalDate date;
			SimpleCar sCar;
			carList = new ArrayList<SimpleCar>();
			do {
				id = result.getInt(1);
				name = result.getString(2);
				trademark = result.getString(3);
				type = result.getString(4);
				color = result.getString(5);
				status = result.getString(6);
				price = result.getDouble(7);
				date = LocalDate.parse(result.getString(8));
				check = result.getString(9);
				sCar = new SimpleCar(id, name, trademark, type, color, status, price, date, check);
				carList.add(sCar);
			}while(result.next() !=false);
		}
		return carList;
	}
	public ArrayList<SimpleCar> loadDataFilter(String status, String type, String color, String trademark, String name) throws SQLException{
		String Query = "SELECT * FROM car_products WHERE ";
		String[] S1 = {status, type, color, trademark, name};
		String[] S2 = {"products_status = ", "products_type = ", "products_color = ", "products_trademark = ", "products_name = "};
		int Save = 0;
		for (int i = 0; i < 6; i++) {
			if (i < 4) {
				if (S1[i] != " All ") {
					if(Save > 0) {Query = Query + " AND "; Save--;};
					Query = Query + S2[i] + S1[i];
					Save++;
		        }
			} else if (i == 4){
				if (S1[i] != "") {
					if(Save > 0) {Query = Query + " AND "; Save--;};
					Query = Query + S2[i] + S1[i];
					Save++;
		        }
			}
		}
		PreparedStatement stat = conn.prepareStatement(Query);
		ResultSet result = stat.executeQuery();
			if(result.next() != false) {
				int id;
				String f_name, f_trademark, f_status, f_type, f_color, check;
				Double price;
				LocalDate date;
				SimpleCar sCar;
				carList = new ArrayList<SimpleCar>();
				do {
					id = result.getInt(1);
					f_name = result.getString(2);
					f_trademark = result.getString(3);
					f_type = result.getString(4);
					f_color = result.getString(5);
					f_status = result.getString(6);
					price = result.getDouble(7);
					date = LocalDate.parse(result.getString(8));
					check = result.getString(9);
					sCar = new SimpleCar(id, f_name, f_trademark, f_type, f_color, f_status, price, date, check);
					carList.add(sCar);
				}while(result.next() !=false);
			}
		return carList;
	}
}
