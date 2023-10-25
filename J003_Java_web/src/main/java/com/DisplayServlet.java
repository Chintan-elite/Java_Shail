package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			

			PreparedStatement ps = cn.prepareStatement("select * from reg");
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<User> al = new ArrayList<>();
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
				
				
				al.add(u);
			}
			
			req.setAttribute("udata", al);
			req.getRequestDispatcher("display.jsp").forward(req, resp);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
