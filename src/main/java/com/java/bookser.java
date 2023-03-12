package com.java;

import java.beans.Statement;
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

/**
 * Servlet implementation class bookser
 */
@WebServlet("/bookser")
public class bookser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public bookser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String pn=request.getParameter("prod_name");
		String q=request.getParameter("qty");
		String e=request.getParameter("email");
		String a=request.getParameter("address");
		String mn=request.getParameter("mobile");
		
		Bean b1=new Bean();
		b1.setProd_name(pn);
		b1.setQty(q);
		b1.setEmail(e);
		b1.setAddress(a);
		b1.setMobile(mn);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glocery", "root", "");
			PreparedStatement ps = con.prepareStatement(
					"insert into product(prod_name,quantity,email,address,mobile_No) values(?,?,?,?,?)");
			
			ps.setString(1, pn);
			ps.setString(2, q);
			ps.setString(3, e);
			ps.setString(4, a);
			ps.setString(5, mn);

			int k = ps.executeUpdate();
			if(k>0) {
				response.sendRedirect("show3.jsp");
			}
			else {
				pw.print("error....");
			}

		} catch (Exception e2) {
			System.out.println(e2);
	}

}}
