package DTO;

import java.time.LocalDate;

public class Customer {
	private int customer_id;
	private String customer_name;
	private LocalDate customer_date;
	private String customer_address;
	private String customer_phone;
	private int customer_products_id;
	public Customer() {
		
	}
	public Customer(int customer_id, String customer_name, LocalDate customer_date, String customer_address, String customer_phone, int customer_products_id) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_date = customer_date;
		this.customer_address = customer_address;
		this.customer_phone = customer_phone;
		this.customer_products_id = customer_products_id;
	}
	public Customer(int customer_id, String customer_name, LocalDate customer_date, String customer_address, String customer_phone) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_date = customer_date;
		this.customer_address = customer_address;
		this.customer_phone = customer_phone;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public LocalDate getCustomer_date() {
		return customer_date;
	}
	public void setCustomer_date(LocalDate customer_date) {
		this.customer_date = customer_date;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public int getCustomer_products_id() {
		return customer_products_id;
	}
	public void setCustomer_products_id(int customer_products_id) {
		this.customer_products_id = customer_products_id;
	}
}
