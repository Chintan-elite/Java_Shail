import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class UserServlet extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			PrintWriter pw = resp.getWriter();
			
			String name = req.getParameter("name");
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
				
				Statement st = cn.createStatement();
				
				ResultSet rs =  st.executeQuery("select * from product where pname like '"+name+"%'");
				String str = "<ul>";
				while(rs.next())
				{
					str=str+"<li>"+rs.getString(2)+"</li>";
				}
				
				str = str+"</ul>";
				
				pw.print(str);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
}
