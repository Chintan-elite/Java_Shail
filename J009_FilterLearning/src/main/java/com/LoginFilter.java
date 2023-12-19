package com;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/login")
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filer entry....");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		if(uname.equals("") || uname.equals(null))
		{
			request.setAttribute("unameErr", "Username require");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		if(pass.equals("") || pass.equals(null))
		{
			request.setAttribute("passErr", "Password require");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		chain.doFilter(request, response);
		System.out.println("Filter exit...");
	}
}
