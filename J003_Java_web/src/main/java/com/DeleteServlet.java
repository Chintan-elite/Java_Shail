package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet	 {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int did =Integer.parseInt(req.getParameter("did"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			
			PreparedStatement ps = cn.prepareStatement("delete from reg where id=?");
			ps.setInt(1, did);
			
			int i = ps.executeUpdate();
					
			if(i>0)
			{
				req.getRequestDispatcher("display").forward(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
