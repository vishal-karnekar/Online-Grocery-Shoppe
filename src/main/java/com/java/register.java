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




@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public register() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		String e=request.getParameter("email");
		String p=request.getParameter("password");
		String a=request.getParameter("address");
		String g=request.getParameter("gender");
		String mn=request.getParameter("mobile");
		
		Bean b1=new Bean();
		b1.setName(fn);
		b1.setLname(ln);
		b1.setEmail(e);
		b1.setAddress(a);
		b1.setPassword(p);		
		b1.setGender(g);
		b1.setMobile(mn);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glocery", "root", "");
			PreparedStatement ps = con.prepareStatement("insert into  reg (fname,lname,address,email,password,mobile_no,gender) values(?,?,?,?,?,?,?)");	
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, a);
			ps.setString(4, e);
			ps.setString(5, p);
			ps.setString(6, mn);
			ps.setString(7, g);
			int k=ps.executeUpdate();
			if(k>0) {
				response.sendRedirect("show2.jsp");
			}
			else {
				pw.print("error....");
			}

			
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}


	}


