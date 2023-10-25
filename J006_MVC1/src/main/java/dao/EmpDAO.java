package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Emp;

public class EmpDAO {
			
		Connection cn = null;
		public EmpDAO() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	
	
		public void addEmp(Emp emp)
		{
			try {
				PreparedStatement ps = cn.prepareStatement("insert into emp values(?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, emp.getUname());
				ps.setString(3, emp.getEmail());
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
