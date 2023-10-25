package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		;
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			
			
			PreparedStatement ps = cn.prepareStatement("select * from reg where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{				
				req.setAttribute("uname", rs.getString(2));
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}
			else
			{
				req.setAttribute("msg", "Invalid credentials");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
