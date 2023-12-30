package com;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/home")
public class HomeFilter extends HttpFilter {

	ServletContext cx;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		cx = filterConfig.getServletContext();
	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String value = cx.getInitParameter("underConstruction");
		if (value.equals("yes")) {
			request.getRequestDispatcher("error.jsp").forward(request, response);

		} else {
			chain.doFilter(request, response);
		}
	}
}
