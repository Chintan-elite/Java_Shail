package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class HelloServlet extends HttpServlet {
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//System.out.println("Hello");
		String name =  req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		
		PrintWriter pw = resp.getWriter();
//		pw.write("<h1>Welcome to home</h1>");
//		pw.write("<h2>Hello, "+name + lname+" </h2>");
//		pw.write("<h2>"+email+"</h2>");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			
			System.out.println("connected...");
			PreparedStatement ps = cn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, lname);
			ps.setString(4, email);
			
			int i =  ps.executeUpdate();
			
			if(i>0)
			{
				req.setAttribute("msg", "Registration successfully Done !!!");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
}
