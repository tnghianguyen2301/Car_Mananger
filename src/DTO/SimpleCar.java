package DTO;

import java.time.LocalDate;

public class SimpleCar {
	private int products_id;
	private String products_name;
	private String products_model;
	private double products_add_price;
	private double products_export_price;
	private LocalDate products_add_date = LocalDate.now();
	
	public SimpleCar() {
		
	}
	public SimpleCar(int products_id, String products_name, String products_model, double products_add_price, LocalDate products_add_date) {
		this.products_id = products_id;
		this.products_name = products_name;
		this.products_model = products_model;
		this.products_add_price = products_add_price;
		this.products_add_date = products_add_date;
		
	}
	
	public SimpleCar(String products_name, String products_model,double products_add_price, LocalDate products_add_date) {
		this.products_name = products_name;
		this.products_model = products_model;
		this.products_add_price = products_add_price;
		this.products_add_date = products_add_date;
	}
	public SimpleCar(String products_name, String products_model,double products_add_price, double products_export_price, LocalDate products_add_date) {
		this.products_name = products_name;
		this.products_model = products_model;
		this.products_add_price = products_add_price;
		this.products_export_price = products_export_price;
		this.products_add_date = products_add_date;
	}
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public String getProducts_name() {
		return products_name;
	}
	public void setProducts_name(String products_name) {
		this.products_name = products_name;
	}
	public String getProducts_model() {
		return products_model;
	}
	public void setProducts_model(String products_model) {
		this.products_model = products_model;
	}
	public double getProducts_add_price() {
		return products_add_price;
	}
	public void setProducts_add_price(double products_add_price) {
		this.products_add_price = products_add_price;
	}
	public LocalDate getProducts_add_date() {
		return products_add_date;
	}
	public void setProducts_add_date(LocalDate products_add_date) {
		this.products_add_date = products_add_date;
	}
	public double getProducts_export_price() {
		products_export_price = products_add_price + (products_add_price / 100 * 20);
		return products_export_price;
	}
	public void setProducts_export_price(Double products_export_price) {
		this.products_export_price = products_export_price;
	}
}
