package DTO;

import java.time.LocalDate;

public class SimpleCar {
	private int products_id;
	private String products_name;
	private String products_trademark;
	private String products_type;
	private String products_color;
	private String products_status;
	private double products_add_price;
	private LocalDate products_add_date = LocalDate.now();
	private String products_check = "Stocking";
	

	public SimpleCar() {
		
	}
	public SimpleCar(int products_id, String products_name, String products_trademark, String products_type, String products_color,
			String products_status,double products_add_price, LocalDate products_add_date, String products_check) 
	{
		this.products_id = products_id;
		this.products_name =  products_name;
		this.products_trademark = products_trademark;
		this.products_type = products_type;
		this.products_color = products_color;
		this.products_status = products_status;
		this.products_add_price = products_add_price;
		this.products_add_date = products_add_date;
		this.products_check = products_check;
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
	public String getProducts_trademark() {
		return products_trademark;
	}
	public void setProducts_trademark(String products_trademark) {
		this.products_trademark = products_trademark;
	}
	public String getProducts_type() {
		return products_type;
	}
	public void setProducts_type(String products_type) {
		this.products_type = products_type;
	}
	public String getProducts_color() {
		return products_color;
	}
	public void setProducts_color(String products_color) {
		this.products_color = products_color;
	}
	public String getProducts_status() {
		return products_status;
	}
	public void setProducts_status(String products_status) {
		this.products_status = products_status;
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
	public String getProducts_check() {
		return products_check;
	}
	public void setProducts_check(String products_check) {
		this.products_check = products_check;
	}	
}
