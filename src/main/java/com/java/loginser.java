package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginser")
public class loginser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginser() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String fn = request.getParameter("fname");
		String p = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glocery", "root", "");
			PreparedStatement ps = con.prepareStatement("select fname,password from reg where fname=? and password=?");
			ps.setString(1, fn);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (fn.equals(rs.getString(1)) && p.equals(rs.getString(2))) {
					response.sendRedirect("products.html");
				}

				else {
					pw.print("<h3>error...</h3>");
				}
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
