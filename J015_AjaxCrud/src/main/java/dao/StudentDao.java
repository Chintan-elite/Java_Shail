package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentDao {
	
		Connection cn = null;
		public StudentDao() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public ArrayList<Student> getAllStudent()
		{
			ArrayList<Student> al = new ArrayList();
			try {
				PreparedStatement ps = cn.prepareStatement("select * from student");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					Student s = new Student();
					s.setId(rs.getInt(1));
					s.setFirstName(rs.getString(2));
					s.setLastName(rs.getString(3));
					s.setEmail(rs.getString(4));
					
					al.add(s);
				}
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return al;
		}
		
		
		
		
		
		
		
}
