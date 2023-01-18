package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/clientlogin")
public class clientlogin extends HttpServlet  {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  resp.setContentType("text/html");  
	        PrintWriter out=resp.getWriter();  
	          
	        req.getRequestDispatcher("link.html").include(req, resp);  
	          
	        String name=req.getParameter("name");  
	        String password=req.getParameter("password");  
	          
	        if(password.equals("123456")){  
	            out.print("                       You are successfully logged in!");  
	            out.print("<br>                       Welcome, "+name);  
	              
	            Cookie ck=new Cookie("name",name);  
	            resp.addCookie(ck);  
	        }else{  
	            out.print("                                Sorry, username or password error!");  
	            req.getRequestDispatcher("clientlogin.html").include(req, resp);  
	        }  
	          
	        out.close();  
	}
	
}
