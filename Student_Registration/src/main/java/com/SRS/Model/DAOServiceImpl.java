package com.SRS.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService{
	Statement stm;
	Connection con;
	
			@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imsdb7","root","test");
			  stm = con.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet res = stm.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return res.next();
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addInquiry(String name, String rollno, String mobileno, String branch, String year) {
		try {
			stm.executeUpdate("insert into student values('"+name+"','"+rollno+"','"+mobileno+"','"+branch+"','"+year+"')");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteInquiry(String rollno) {
		try {
		stm.executeUpdate("delete from student where rollno='"+rollno+"'");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	

	@Override
	public void updateInquiry(String name, String branch) {
		try {
			stm.executeUpdate("update  student set branch='"+branch+"' where name='"+name+"'");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet getAllInquiry() {
		try {
			ResultSet res = stm.executeQuery("select * from student");
			return res;
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
