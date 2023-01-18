package com.fooddelivery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fooddelivery.dao.adminpage;
import com.fooddelivery.dto.addstaff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/view_staff")
public class view_staff  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
     resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		
		List<addstaff> UL=adminpage.viewstaff();
		
		
		
		
		out.println("<html>");
		out.println("<title>VIEW STAFF DETAILS </title>\r\n"
				+ "\r\n"
				+ "<style type=\"text/css\">\r\n"
				+ "th,td,tr{\r\n"
				+ "border:1px solid grey;\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "th{\r\n"
				+ "color: orange ;}\r\n"
				+ "</style><body>");
		
		
		out.println("<h1 style=\" text-align: center;\">STAFF DETAILS</h1>");
		
//		out.println(" <div style=\"border: 2px solid black; \r\n"
//				+ "border-radius:10px;height:650px; width:700px;\r\n"
//				+ "  background-color: grey; \">");
		
		out.println("<table style=\"border: 2px solid grey; margin-left:413px; border-radius: 5px; \">\r\n");
		out.println("  <tr>\r\n"
				+ "    <th> ID </th>\r\n"
				+ "    <th> NAME</th>\r\n"
				+ "    <th> EMAIL ID</th>\r\n"
				+ "    <th> PASSWORD</th>\r\n"
				+ "    <th> MOBILE NO</th>\r\n"
				+ "    <th> TIME</th>\r\n"
				+ "    <th> DATE</th>\r\n"
				+ "  \r\n"
				+ "    \r\n"
				+ "  </tr> ");
		
		
		for(addstaff ad:UL) {
			out.println("    <tr>\r\n"
					+ "    <td> "+ad.getId()+"</td>\r\n"
					+ "    <td> "+ad.getName()+"</td>\r\n"
					+ "    <td> "+ad.getEmail()+"</td>\r\n"
					+ "    <td> "+ad.getPass()+"</td>\r\n"
					+ "    <td> "+ad.getMobno()+"</td>\r\n"
					+ "    <td> "+ad.getTime()+"</td>\r\n"
					+ "    <td> "+ad.getDate()+"</td>\r\n"
					+ "  </tr>\r\n");	
					
		}
		
		out.println( "</table> <br> <br>");	
		
		
		out.println("<a href=\"homepage.html\" style=\"margin-left: 882px;\"margin-top: 0px;\"><button type=\"button\">CLOSE</button></a>\r\n"
				+ "");
		
//		out.println("</div>");
		
		out.println("</body></html>");
		
		
	}
	
}
