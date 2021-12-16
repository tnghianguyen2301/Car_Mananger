package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public boolean createNewCarHistoryInTable (HistoryCar hCar) throws SQLException {
		String name = hCar.getHistory_name();
		String model = hCar.getHistory_model();
		Double add_price = hCar.getHistory_add_price();
		Double export_price = hCar.getHistory_export_price();
		String add_date = hCar.getHistory_add_date().toString();
		String query = "INSERT INTO car_history (history_name, history_model, history_add_price, history_export_price, history_add_date )"
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, name);
		stat.setString(2, model);
		stat.setDouble(3, add_price);
		stat.setDouble(4, export_price);
		stat.setString(5,add_date);
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
		String date = car.getHistory_export_Date().toString();
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
}