package DTO;

import java.time.LocalDate;

public class HistoryCar {
	private int history_id;
	private String history_name;
	private String history_trademark;
	private String history_type;
	private String history_color;
	private String history_status;
	private double history_add_price;
	private double history_export_price;
	private LocalDate history_add_date = LocalDate.now();
	private LocalDate history_export_date = LocalDate.now();
	public HistoryCar() {
		
	}
	
	public HistoryCar(int history_id, String history_name, String history_trademark, String history_type, String history_color, String history_status,
			double history_add_price, double history_export_price, LocalDate history_add_date
			)
	{
		this.history_id = history_id;
		this.history_name = history_name;
		this.history_trademark = history_trademark;
		this.history_type = history_type;
		this.history_color = history_color;
		this.history_status = history_status;
		this.history_add_price = history_add_price;
		this.history_export_price = history_export_price;
		this.history_add_date = history_add_date;
	}
	public HistoryCar(int history_id, String history_name, String history_trademark, String history_type, String history_color, String history_status,
			double history_add_price, double history_export_price, LocalDate history_add_date, LocalDate history_export_date
			)
	{
		this.history_id = history_id;
		this.history_name = history_name;
		this.history_trademark = history_trademark;
		this.history_type = history_type;
		this.history_color = history_color;
		this.history_status = history_status;
		this.history_add_price = history_add_price;
		this.history_export_price = history_export_price;
		this.history_add_date = history_add_date;
		this.history_export_date = history_export_date;
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

	public String getHistory_trademark() {
		return history_trademark;
	}

	public void setHistory_trademark(String history_trademark) {
		this.history_trademark = history_trademark;
	}

	public String getHistory_type() {
		return history_type;
	}

	public void setHistory_type(String history_type) {
		this.history_type = history_type;
	}

	public String getHistory_color() {
		return history_color;
	}

	public void setHistory_color(String history_color) {
		this.history_color = history_color;
	}

	public String getHistory_status() {
		return history_status;
	}

	public void setHistory_status(String history_status) {
		this.history_status = history_status;
	}

	public double getHistory_add_price() {
		return history_add_price;
	}

	public void setHistory_add_price(double history_add_price) {
		this.history_add_price = history_add_price;
	}

	public double getHistory_export_price() {
		history_export_price = history_add_price + (history_add_price / 100 * 20);
		return history_export_price;
	}

	public void setHistory_export_price(double history_export_price) {
		this.history_export_price = history_export_price;
	}

	public LocalDate getHistory_add_date() {
		return history_add_date;
	}

	public void setHistory_add_date(LocalDate history_add_date) {
		this.history_add_date = history_add_date;
	}

	public LocalDate getHistory_export_date() {
		return history_export_date;
	}

	public void setHistory_export_date(LocalDate history_export_date) {
		this.history_export_date = history_export_date;
	}
	}
