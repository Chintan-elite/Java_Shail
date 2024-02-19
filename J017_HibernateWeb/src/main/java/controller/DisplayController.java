package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import model.Emp;


public class DisplayController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpDao dao = new EmpDao();
		ArrayList<Emp> all =  dao.getAllEmp();
		req.setAttribute("data", all);
		req.getRequestDispatcher("view.jsp").forward(req, resp);
	}
}
