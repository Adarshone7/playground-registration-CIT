package com.SRS.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SRS.Model.DAOServiceImpl;

@WebServlet("/deleteInquiry")
public class DeleteInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteInquiryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String rollno = request.getParameter("rollno");
	//System.out.println(rollno);
	DAOServiceImpl service = new DAOServiceImpl();
	service.connectDB();
	service.deleteInquiry(rollno);
	

	ResultSet result = service.getAllInquiry();
	request.setAttribute("res", result);
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_Inquiries.jsp");
	rd.forward(request,response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
