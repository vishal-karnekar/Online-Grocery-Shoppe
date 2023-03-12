package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletser
 */
@WebServlet("/deletser")
public class deletser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deletser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			int id = Integer.parseInt(request.getParameter("delete"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glocery", "root", "");
				PreparedStatement ps = con.prepareStatement("delete from product where id=?");
				ps.setInt(1, id);
				int k = ps.executeUpdate();
				if (k > 0) {
					pw.print("<center><h2 style='color: red;'>Data Delete Sucessfully</h2></center>");
				} else

				{
					pw.print("<center><h2 style='color: red;'>Incorrect ID</h2></center>");
				}

			} catch (Exception e) {
				System.out.println(e);
			}

	}

}
