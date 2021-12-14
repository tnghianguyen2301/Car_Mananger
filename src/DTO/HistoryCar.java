package DTO;

import java.time.LocalDate;

public class HistoryCar {
	private int history_id;
	private String history_name;
	private String history_model;
	private Double history_add_price;
	private Double history_export_price;
	private LocalDate history_add_date = LocalDate.now();
	private LocalDate history_export_date = LocalDate.now();
	
	public HistoryCar() {
		
	}
	public HistoryCar(int history_id, String history_name, String history_model,Double history_add_price, Double history_export_price, LocalDate history_add_date) {
		this.history_id = history_id;
		this.history_name = history_name;
		this.history_model = history_model;
		this.history_add_price = history_add_price;
		this.history_export_price = history_export_price;
		this.history_add_date = history_add_date;
	}
	public int getHistory_id() {
		return history_id;
	}
	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}
	public String getHistory_name() {
		return history_name;
	}
	public void setHistory_name(String history_name) {
		this.history_name = history_name;
	}
	public String getHistory_model() {
		return history_model;
	}
	public void setHistory_model(String history_model) {
		this.history_model = history_model;
	}
	public Double getHistory_add_price() {
		return history_add_price;
	}
	public void setHistory_add_price(Double history_add_price) {
		this.history_add_price = history_add_price;
	}
	public Double getHistory_export_price() {
		history_export_price = history_add_price + (history_add_price / 100 *20);
		return history_export_price;
	}
	public void setHistory_export_price(Double history_export_price) {
		this.history_export_price = history_export_price;
	}
	public LocalDate getHistory_add_date() {
		return history_add_date;
	}
	public void setHistory_add_date(LocalDate history_add_date) {
		this.history_add_date = history_add_date;
	}
	public LocalDate getHistory_export_Date() {
		return history_export_date;
	}
	public void setHistory_export_Date(LocalDate history_export_Date) {
		this.history_export_date = history_export_Date;
	}
}
