package DAO;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

import DTO.User;
import hash_password.PBKDF2_Verify_Password;
public class UserDAO {
	private Connection conn;
	public UserDAO(Connection conn){
		this.conn = conn;
	}
	
	public int getNewIdFromTable(String tableName) throws SQLException{
		int new_id = 1;
		String query = "SELECT max(account_id)+1 FROM " + tableName;
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet rs = stat.executeQuery();
		if (rs.next()){
			if (rs.getInt(1) > 0)
				return rs.getInt(1);
		}
		//
		//rs.close();
		return new_id;			
	}
	
	public User createUserObject(String username, String password, String name, String email){
		User new_user = new User(username, password, name, email);
		return new_user;	
	}
	
	public boolean createUserInTable(User u) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
		int id = this.getNewIdFromTable("car_account");
		String username = u.getUsername();
		String password = u.getPassword();
		String hash_password = PBKDF2_Verify_Password.generateStrongPasswordHash(password);
		String email = u.getEmail();
		String name = u.getName();
		int role = u.getRole();
	
		
		String query = "INSERT INTO car_account VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stat = conn.prepareStatement(query)){
			stat.setInt(1, id);
			stat.setString(2, username);
			stat.setString(3, hash_password);
			stat.setString(4, email);
			stat.setString(5, name);
			stat.setInt(6, role);
			// image
			int p = stat.executeUpdate();
			if (p == 1){
				System.out.println("Insert new record");
				
				return true;
			}
		}
		return false;	
	}
	
	public int getUserIdByUsername(String username) throws SQLException{
		int id = -1;
		String query = "SELECT account_id FROM car_account WHERE account_username = ?";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, username);
		ResultSet result = stat.executeQuery();
		if (result.next()){
			
			return result.getInt(1);
		}
		return id;
	}
	
	public String getUserPasswordByUsername(String username) throws SQLException{
		String password = "";
		String query = "SELECT account_password FROM car_account WHERE account_username = ?";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, username);
		ResultSet result = stat.executeQuery();
		if (result.next()){
			password = result.getString(1);
		}
		return password;
	}
	
	public User getUserByUsername(String username) throws SQLException{
		User current_user = null;
		String query = "SELECT * FROM car_account WHERE account_username = ?";
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, username);
		ResultSet result = stat.executeQuery();
		if (result.next()){
			int id = result.getInt(1);
			String userName = result.getString(2);
			String password = result.getString(3);
			String email = result.getString(4);
			String name = result.getString(5);
			int role = result.getInt(6);
			current_user = new User(id, userName, password, email, name, role);
		}
		return current_user;	
	}
	
//	public void displayPersonalForm(User user){
//		PersonalForm pForm = new PersonalForm(user);
//	pForm.getTxtUsername().setText(user.getUsername());
//		pForm.getTxtEmail().setText(user.getEmail());
//		pForm.getTxtName().setText(user.getName());
//		pForm.setVisible(true);
//	}
	
//	public boolean saveUserImage(User u, String encoded_img) throws SQLException{
//		String query = "UPDATE users SET image = ? " +
//					" WHERE id = ?";
//		PreparedStatement stat = conn.prepareStatement(query);
//		stat.setString(1, encoded_img);
//		stat.setInt(2, u.getId());
////		System.out.println("encoded_img: " + encoded_img.length());
////		System.out.println("id : " + u.getId());
//		int p = stat.executeUpdate();
//		if (p == 1){
//			System.out.println("Update current record");
//			//
//			stat.close();
//			return true;
//			
//		}
//		stat.close();
//		return false;
//	}
//	
//	public ImageIcon loadUserImage(User u) throws SQLException{
//		String query = "SELECT image FROM users WHERE id = ?";
//		PreparedStatement stat = conn.prepareStatement(query);
//		stat.setInt(1, u.getId());
//		ResultSet result = stat.executeQuery();
//		if (result.next()){
//			String encoded_img = result.getString(1);
//			// new
//			ImageIcon imgIcon = ImageConvert.getImageIcon(encoded_img);
//			
//			stat.close();
//			result.close();
//			return imgIcon;
//		}
//		return null;	
//	}
}

