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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String pn=request.getParameter("prod_name");
		String q=request.getParameter("qty");
		String e=request.getParameter("email");
		String a=request.getParameter("address");
		String mn=request.getParameter("mobile");
		
		Bean b1=new Bean();
		b1.setId(id);
		b1.setProd_name(pn);
		b1.setQty(q);
		b1.setEmail(e);
		b1.setAddress(a);
		b1.setMobile(mn);
		
		
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/glocery","root","");
			PreparedStatement ps=con.prepareStatement("update product set prod_name=?, quantity=?, email=?, address=?, mobile_no=? where id=?");
			
			ps.setString(1, pn);
			ps.setString(2, q);
			ps.setString(3, e);
			ps.setString(4, a);
			ps.setString(5, mn);
			ps.setInt(6, id);
			int j=ps.executeUpdate();
			
			
			if(j>0)
			{
				response.sendRedirect("show3.jsp");
			}
			else
			{
				pw.print("Errror!!!");
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}

}
