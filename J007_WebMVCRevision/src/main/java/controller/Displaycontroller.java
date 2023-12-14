package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/display")
public class Displaycontroller extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		UserDao dao = new UserDao();
		ArrayList<User> al = dao.viewUser();
		
		req.setAttribute("userdata", al);
		req.getRequestDispatcher("display.jsp").forward(req, resp);
		
	}
}
