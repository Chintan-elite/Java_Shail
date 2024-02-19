package controller;

import java.io.IOException;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emp;

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		int did = Integer.parseInt(req.getParameter("did"));
		EmpDao dao = new EmpDao();
		if(action.equals("delete"))
		{
			dao.deleteEmp(did);
			req.getRequestDispatcher("display").forward(req, resp);
		}
		else if(action.equals("edit"))
		{
			Emp e = dao.getById(did);
			req.setAttribute("edata", e);
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
		
	}
	
}
