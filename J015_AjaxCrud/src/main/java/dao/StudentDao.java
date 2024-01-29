package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Student;

public class StudentDao {

	Connection cn = null;

	public StudentDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Student> getAllStudent() {
		ArrayList<Student> al = new ArrayList();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setFirstName(rs.getString(2));
				s.setLastName(rs.getString(3));
				s.setEmail(rs.getString(4));

				al.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	public int addStudent(Student std) {
		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, std.getFirstName());
			ps.setString(3, std.getLastName());
			ps.setString(4, std.getEmail());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int deleteStudent(int uid) {
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("delete from student where id=?");
			ps.setInt(1, uid);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public Student getById(int uid) {
		Student std = new Student();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student where id=?");
			ps.setInt(1, uid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				std.setId(rs.getInt(1));
				std.setFirstName(rs.getString(2));
				std.setLastName(rs.getString(3));
				std.setEmail(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return std;
	}

	public int UpdateStudent(Student std) {

		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("update student set fname=?,lname=?,email=? where id=?");
			ps.setInt(4, std.getId());
			ps.setString(1, std.getFirstName());
			ps.setString(2, std.getLastName());
			ps.setString(3, std.getEmail());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public ArrayList<Student> getSearchStudent(String cdata) {
		ArrayList<Student> al = new ArrayList();
		try {
			
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from student where fname like '"+cdata+"%'");
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setFirstName(rs.getString(2));
				s.setLastName(rs.getString(3));
				s.setEmail(rs.getString(4));

				al.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

}
