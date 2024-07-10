package july9thcrudP;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class registerC extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
	res.setContentType("text/html");
	PrintWriter pw = res.getWriter();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/IBM9july","root", "");
		String name = req.getParameter("user");
		String mail = req.getParameter("mail");
		String phone = req.getParameter("phone");
		String city = req.getParameter("location");
		//pw.println(name+"--"+mail+"--"+phone+"--"+city);
		if(name!=null) {
		String query = "insert into student values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, mail);
		ps.setString(3, phone);
		ps.setString(4, city);
		
		
		ps.executeUpdate();
		pw.println("<h1>data has been successfully inserted</h1>");
		
		}
//		
//		if(insreted>0) {
//			pw.print("data inserted");
//		}
//		else {
//			pw.print("some error");
//		}
		
		
		
//		String query = "create database IBM9july";
		
//		String query = "create table student(name varchar(30), mail varchar(40) primary key,phone varchar(12), location varchar(40))";
//		Statement st = conn.createStatement();
//		st.executeUpdate(query);
//		pw.println("table created");
//			pw.println("Connected");
				
	} catch(ClassNotFoundException | SQLException e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	}

}
