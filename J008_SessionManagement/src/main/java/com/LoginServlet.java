package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname =req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		if(uname.equals("admin") && pass.equals("admin"))
		{
			HttpSession session = req.getSession();
			session.setAttribute("uname", uname);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("err", "Invalid Credentials");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
}
