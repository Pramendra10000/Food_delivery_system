package com.fooddelivery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.fooddelivery.dto.addstaff;
import com.fooddelivery.dto.adminclass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fooddelivery.dao.*;


@WebServlet("/Adminpage")
public class Adminpage  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("Au1");
		String pass=req.getParameter("Ap1");
		
		
		
		
		adminclass a=new adminclass();
		
		a.setUsername(name);
		a.setPassword(pass);
		
		int status=adminpage.save(a);
		
		if(status>0) {
		//	out.println("<p> Record saved successfully!!</p>");
			req.getRequestDispatcher("homepage.html").include(req, resp);
			
		}
		
		else {
			
			out.println(" ");
			out.println("Record not saved !!");
		}
		
		out.close();
		
		
		
		
	}

}
