package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int did = Integer.parseInt(req.getParameter("did"));
		
		UserDao dao = new UserDao();
		int i = dao.deleteUser( did);
		if(i>0)
		{
			req.getRequestDispatcher("display").forward(req, resp);
			
		}
	}

}
