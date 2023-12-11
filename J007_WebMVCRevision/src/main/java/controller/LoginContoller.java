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
public class LoginContoller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		
		User u = new User();
		u.setEmail(email);
		u.setPass(pass);
		
		
		UserDao dao = new UserDao();
		boolean b = dao.loginCheck(u);
		
		
		
		if(b)
		{
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}
		else
		{
			req.setAttribute("err", "invalid credentials !!!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		}
		
		
		
		
		
	}
}
