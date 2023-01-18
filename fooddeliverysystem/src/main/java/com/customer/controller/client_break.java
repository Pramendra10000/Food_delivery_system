package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/client_break")
public class client_break extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");  
	     PrintWriter out=resp.getWriter();  
	       
	       
	     req.getRequestDispatcher("link.html").include(req, resp);  
	       
	     Cookie ck=new Cookie("name","");  
	     ck.setMaxAge(0);  
	     resp.addCookie(ck);  
	       
	     out.print("you are successfully logged out!"); 
	}
	
}
