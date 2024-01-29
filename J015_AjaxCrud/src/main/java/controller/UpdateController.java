package controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		int uid = Integer.parseInt(req.getParameter("uid"));
		PrintWriter pw = resp.getWriter();
		StudentDao dao = new StudentDao();
		if(action.equals("delete"))
		{
			int i = dao.deleteStudent(uid);
			if(i>0)
			{
				pw.append("Student deleted");
			}
		}
		else if(action.equals("edit"))
		{
			Student s = dao.getById(uid);
			Gson gson = new Gson();
			String data = gson.toJson(s);
			pw.append(data);
		}
		
		
		
		
	}
}
