package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserDao {
	
	Connection cn = null;
	public UserDao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addUser(User user)
	{
		int i=0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into reg values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, user.getUname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPass());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public void viewUser()
	{
		
	}
	
	public void deleteUser()
	{
		
	}
	
	public void updateUser()
	{
		
	}
	
}
