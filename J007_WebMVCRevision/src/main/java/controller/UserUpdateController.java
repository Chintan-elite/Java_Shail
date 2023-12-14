package controller;

import java.io.IOException;
import java.net.http.HttpClient;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/userupdate")
public class UserUpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		
		User user  = new User();
		user.setId(id);
		user.setName(uname);
		user.setEmail(email);
		user.setPass(pass);
		
		
		UserDao udao = new UserDao();
		int i = udao.updateUser(user);
		
		if(i>0)
		{
			req.setAttribute("msg","Update successfully !!!");
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
		
		
		
	}
	
}
