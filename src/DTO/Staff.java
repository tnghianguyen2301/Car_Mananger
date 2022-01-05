package DTO;

import java.time.LocalDate;

public class Staff {
	private int staff_id;
	private String staff_name;
	private LocalDate staff_date;
	private LocalDate staff_start;
	private String staff_position;
	private double staff_salary;
	public Staff() {
		
	}
	public Staff(int staff_id, String staff_name, LocalDate staff_date,LocalDate staff_start, String staff_position, double staff_salary) {
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_date = staff_date;
		this.staff_start = staff_start;
		this.staff_position = staff_position;
		this.staff_salary = staff_salary;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public LocalDate getStaff_date() {
		return staff_date;
	}
	public void setStaff_date(LocalDate staff_date) {
		this.staff_date = staff_date;
	}
	public LocalDate getStaff_start() {
		return staff_start;
	}
	public void setStaff_start(LocalDate staff_start) {
		this.staff_start = staff_start;
	}
	public String getStaff_position() {
		return staff_position;
	}
	public void setStaff_position(String staff_position) {
		this.staff_position = staff_position;
	}
	public double getStaff_salary() {
		return staff_salary;
	}
	public void setStaff_salary(double staff_salary) {
		this.staff_salary = staff_salary;
	}
}
