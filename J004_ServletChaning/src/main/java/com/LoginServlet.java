package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		String uname = req.getParameter("uname");
		
		PrintWriter pw = resp.getWriter();
		pw.print("<h1>"+uname+"</h1>");
		
		
//		req.setAttribute("msg", "Username insrted !!!");
//		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//		//rd.include(req, resp);
//		rd.forward(req, resp);
//	
		resp.sendRedirect("index.jsp");
	
	}
	
}
