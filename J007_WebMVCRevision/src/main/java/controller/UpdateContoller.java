package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/update")
public class UpdateContoller  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		UserDao dao = new UserDao();
		if(action.equals("delete"))
		{
			int i = dao.deleteUser(uid);
			
			if(i>0)
			{
				req.getRequestDispatcher("display").forward(req, resp);
			}
			
		}
		else if(action.equals("edit"))
		{
			
			User user = dao.getUserById(uid);
			
			req.setAttribute("udata", user);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
			
			
		}
		
		
		
	}
	
	
}
