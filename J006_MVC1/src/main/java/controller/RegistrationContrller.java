package controller;

import java.io.IOException;

import dao.EmpDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emp;

@WebServlet("/reg")
public class RegistrationContrller extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		
		Emp emp = new Emp();
		emp.setUname(uname);
		emp.setEmail(email);
		emp.setPass(pass);
		
		
		EmpDAO dao = new EmpDAO();
		dao.addEmp(emp);
		
		
	}
}
