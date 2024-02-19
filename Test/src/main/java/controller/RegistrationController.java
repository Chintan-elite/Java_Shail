package controller;

import java.io.IOException;



import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emp;

@WebServlet("/reg")
public class RegistrationController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id;
		String uid =req.getParameter("id");
		if(uid.equals("")||uid.equals(null))
		{
			id = 0;
		}
		else
		{
			id = Integer.parseInt(uid);
		}
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String dept = req.getParameter("dept");
		double sal = Double.parseDouble(req.getParameter("sal"));
		
		
		Emp e = new Emp();
		e.setId(id);
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
