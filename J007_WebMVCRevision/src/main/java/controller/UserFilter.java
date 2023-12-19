package controller;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/reg")
public class UserFilter extends HttpFilter {
		
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		if(uname.equals("")||uname.equals(null))
		{
			req.setAttribute("unameErr", "uname required");
			rd.forward(req, resp);
		}
		
		
		
		
		chain.doFilter(req, resp);
		
	}
}
