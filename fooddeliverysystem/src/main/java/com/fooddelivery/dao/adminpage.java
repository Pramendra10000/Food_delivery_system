package com.fooddelivery.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.controller.*;


import com.fooddelivery.dto.*;

public class adminpage {

	public static Connection getconnection() {
	
		String url="jdbc:mysql://localhost:3306";
		String name ="root";
		String pass="root";
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, name, pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
//	======================================================================
	// save data of admin in db 


	public static int save(adminclass a) {
		int status =0;
		//String qry=" insert into food_delivery.foodadmin (USERNAME , PASS) values(?,?)";
		
	
		try {
			
			Connection con=adminpage.getconnection();
			PreparedStatement ps=con.prepareStatement("insert into food_delivery.foodadmin (USERNAME , PASS) values(?,?)");
			ps.setString(1,a.getUsername());
			ps.setString(2,a.getPassword());
			
			
			//execution of data
			status=ps.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	
//	======================================================================
	
	// saving info for the table food_delivery.addstaff
	
	public static int  saveforaddstaff(addstaff ad) {
		
		
		int status =0;
try {
			
			Connection con=adminpage.getconnection();
			PreparedStatement ps=con.prepareStatement("insert into food_delivery.addstaff (NAME ,Email, PASS,Mob_no,Time,date_a) values(?,?,?,?,?,?)");
			
			
			
			ps.setString(1,ad.getName());
			ps.setString(2, ad.getEmail());
			ps.setString(3, ad.getPass());
			ps.setString(4, ad.getMobno());
			ps.setString(5, ad.getTime());
			ps.setString(6, ad.getDate());
			
			
			
			//execution of data
			status=ps.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
//	======================================================================
	
	public static List<addstaff> viewstaff() {
		
		List<addstaff> li=new  ArrayList<addstaff>();
		
	
		try {
			Connection con=adminpage.getconnection();
			PreparedStatement ps=con.prepareStatement("select * from food_delivery.addstaff");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				addstaff ad=new addstaff();
				ad.setId(rs.getInt(1));
				ad.setName(rs.getString(2));
				ad.setEmail(rs.getString(3));
				ad.setPass(rs.getString(4));
				ad.setMobno(rs.getString(5));
				ad.setTime(rs.getString(6));
				ad.setDate(rs.getString(7));
				
				li.add(ad);
				
				
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return li;
		
		
	}
	
	
	
}


