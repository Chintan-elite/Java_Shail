package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public boolean login(User user)
	{
		boolean b = false;
		try {
			PreparedStatement ps = cn.prepareStatement("select * from reg where email=? and pass=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPass());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				b = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
	}
	
	
	public ArrayList<User> viewUser()
	{
		
		ArrayList<User> al = new ArrayList<>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from reg");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
			
				al.add(u);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
	}
	
	public int deleteUser(int did)
	{
		int i=0;
		try {
			PreparedStatement ps = cn.prepareStatement("delete from reg where id=?");
			ps.setInt(1, did);
			
			 i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;	
	}
	
	public void updateUser()
	{
		
	}
	
}
