package com.fooddelivery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.fooddelivery.dao.adminpage;
import com.fooddelivery.dto.addstaff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Addstaff_datainsert")
public class Addstaff_datainsert extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		
		String name =req.getParameter("Au1");
		 String Email =req.getParameter("Ae1"); 
		 String Pass =req.getParameter("Ap1");
		 String mobno =req.getParameter("Am1");
		 String time =req.getParameter("At1");
		 String date =req.getParameter("Ad1");
		 
		 
		 addstaff ad=new addstaff();
		 
		 ad.setName(name);
		 ad.setEmail(Email);
		 ad.setPass(Pass);
		 ad.setMobno(mobno);
		 ad.setTime(time);
		 ad.setDate(date);
		 
		 int status=adminpage.saveforaddstaff(ad);
		 
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
