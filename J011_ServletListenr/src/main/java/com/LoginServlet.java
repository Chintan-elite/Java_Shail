package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass  =request.getParameter("pass");
		
		
		if(uname.equals("admin") && pass.equals("admin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
		}
		
		PrintWriter pw=response.getWriter();
		pw.write("<a href='logout'>Logout</a>");
		
		ServletContext cx = request.getServletContext();
		String c = (String)cx.getAttribute("cUser");
		String t = (String)cx.getAttribute("tUser");
		
		pw.write("<h1>Current user : "+c+"</h1>");
		pw.write("<h1>Total user : "+t+"</h1>");
		
		
		
	}

}
