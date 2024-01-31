package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import model.Emp;

@WebServlet("/reg")
public class RegistrationController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String dept = req.getParameter("dept");
		double sal = Double.parseDouble(req.getParameter("sal"));
		
		
		Emp e = new Emp();
		e.setName(uname);
		e.setEmail(email);
		e.setDept(dept);
		e.setSal(sal);
		
		EmpDao dao = new EmpDao();
		dao.addemp(e);
		req.setAttribute("msg", "registration success");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
