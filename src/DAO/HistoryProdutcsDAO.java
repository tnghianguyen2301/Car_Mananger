package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import DTO.HistoryCar;
import DTO.SimpleCar;

public class HistoryProdutcsDAO {
	private Connection conn;
	private ArrayList<HistoryCar> historyCarList;
	public HistoryProdutcsDAO(Connection conn) {
		this.conn = conn;
	}
	public ArrayList<HistoryCar> getHistoryCarList() {
		return historyCarList;
	}
	public void setHistoryCarList(ArrayList<HistoryCar> historyCarList) {
		this.historyCarList = historyCarList;
	}
	public void addNewHistoryProducts(HistoryCar hsCar) {
		historyCarList.add(hsCar);
	}
	public int getNewIDInHistoryTable() throws SQLException {
		int new_id = 1;
		String query = "SELECT max(history_id) + 1 FROM car_history";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next()) {
			if(result.getInt(1) > 0) {
				return result.getInt(1);
			}
		}
		return new_id;
	}
	public boolean createNewCarHistoryInTable (HistoryCar hCar) throws SQLException {
		String name = hCar.getHistory_name();
		String trademark = hCar.getHistory_trademark();
		String type = hCar.getHistory_type();
		String color = hCar.getHistory_color();
		String status = hCar.getHistory_status();
		Double add_price = hCar.getHistory_add_price();
		Double export_price = hCar.getHistory_export_price();
		String add_date = hCar.getHistory_add_date().toString();
		String query = "INSERT INTO car_history (history_name, history_trademark, history_type, history_color, history_status,"
				+ " history_add_price, history_export_price, history_add_date )"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, name);
		stat.setString(2, trademark);
		stat.setString(3, type);
		stat.setString(4, color);
		stat.setString(5, status);
		stat.setDouble(6, add_price);
		stat.setDouble(7, export_price);
		stat.setString(8, add_date);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean updateHistoryInTable(int id) throws SQLException {
		String query = "UPDATE car_history set history_export_date = ? where history_id = ?";
		PreparedStatement stat = conn.prepareStatement(query);
		HistoryCar car = new HistoryCar();
		String date = car.getHistory_export_date().toString();
		stat.setString(1, date);
		stat.setInt(2, id);
		int p = stat.executeUpdate();
		if(p == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<HistoryCar> loadHistoryCarDataToList() throws SQLException{
		String query = "SELECT * FROM car_history";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		if(result.next() != false) {
			int id;
			String name, trademark,type,color,status;
			Double add_price, export_price;
			LocalDate add_date, export_date;
			HistoryCar hCar;
			historyCarList = new ArrayList<HistoryCar>();
 			do {
				id = result.getInt(1);
				name = result.getString(2);
				trademark = result.getString(3);
				type = result.getString(4);
				color = result.getString(5);
				status = result.getString(6);
				add_price = result.getDouble(7);
				export_price = result.getDouble(8);
				add_date = LocalDate.parse(result.getString(9));
				String dateTest = result.getString(10);
				if(dateTest != null) {
					export_date = LocalDate.parse(result.getString(10));
					hCar = new HistoryCar(id, name, trademark, type, color, status, add_price, export_price, add_date, export_date);
					historyCarList.add(hCar);		
				}
				else {
					export_date = null;
					hCar = new HistoryCar(id, name, trademark, type, color, status, add_price, export_price, add_date, export_date);
					historyCarList.add(hCar);
				}
			} while (result.next()!= false);
		}
		return historyCarList;
	}
}
