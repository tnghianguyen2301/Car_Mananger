package DTO;

public class User {
	int id;
	String username;
	String password;
	String email;
	String name;
	String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(int id, String username, String password, String email, String name, String role){
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.role = role;
	}
	
	public User(int id, String username, String email, String name, String role){
		this.id = id;
		this.username = username;
		this.email = email;
		this.name = name;
		this.role = role;
	}
	
	public User(String username, String password, String email, String name, String role){
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.role = role;
	}
	

}
