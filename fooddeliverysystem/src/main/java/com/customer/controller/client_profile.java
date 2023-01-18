package com.customer.controller;

 

import java.io.IOException;  
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 

@WebServlet("/client_profile")
public class client_profile extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

    resp.setContentType("text/html");  
    PrintWriter out=resp.getWriter();  
      
    req.getRequestDispatcher("link.html").include(req, resp);  
      
    Cookie ck[]=req.getCookies();  
    if(ck!=null){  
     String name=ck[0].getValue();  
    if(!name.equals("")||name!=null){  
        out.print("<b>Welcome to Profile</b>");  
        out.print("<br>Welcome, "+name);  
    }  
    }else{  
        out.print("                    <h2>  Please login first !!</h2>");  
        req.getRequestDispatcher("clientlogin.html").include(req, resp);  
    }  
    out.close();
} 
	
	}


