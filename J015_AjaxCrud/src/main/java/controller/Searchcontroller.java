package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/search")
public class Searchcontroller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cdata = req.getParameter("cdata");
		
		StudentDao dao = new StudentDao();
		ArrayList<Student> al =  dao.getSearchStudent(cdata);
		PrintWriter pw = resp.getWriter();
		Gson gson = new Gson();
		String data =  gson.toJson(al);
		
		
		pw.append(data);
		
		
		
	}
}
