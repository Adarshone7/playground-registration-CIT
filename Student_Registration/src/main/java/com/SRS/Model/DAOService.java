package com.SRS.Model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyLogin(String email, String password);
	public void addInquiry(String name, String rollno, String mobileno, String branch, String year );
	public void deleteInquiry(String rollno);
	public void updateInquiry(String name, String branch);
	public ResultSet getAllInquiry();
	public void closeDB();
	

}
