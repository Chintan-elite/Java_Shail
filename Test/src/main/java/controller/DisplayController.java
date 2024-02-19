package controller;

import java.io.IOException;
import java.util.ArrayList;



import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emp;

@WebServlet("/display")
public class DisplayController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException
	, IOException {
		
		EmpDao dao = new EmpDao();
		ArrayList<Emp> all =  dao.getAllEmp();
		req.setAttribute("data", all);
		req.getRequestDispatcher("view.jsp").forward(req, resp);
	}
}
