package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		
		Student std = new Student();
		std.setFirstName(fname);
		std.setLastName(lname);
		std.setEmail(email);
		
		StudentDao dao = new StudentDao();
		int  i = dao.addStudent(std);
		if(i>0)
		{
			
			pw.append("Data inserted !!!");
		}
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		
		Student std = new Student();
		std.setId(id);
		std.setFirstName(fname);
		std.setLastName(lname);
		std.setEmail(email);
		
		StudentDao dao = new StudentDao();
		int  i = dao.UpdateStudent(std);
		if(i>0)
		{
			
			pw.append("Data Updated !!!");
		}
	}
}
