package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		
		User user = new User();
		user.setEmail(email);
		user.setPass(pass);
		
		
		UserDao dao = new UserDao();
		boolean b =  dao.login(user);
		
		if(b)
		{
			req.getRequestDispatcher("home.jsp").forward(req, resp);;
		}
		else
		{
			req.setAttribute("err", "Invalid credentials !!!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);;
		}
		
	}
}
