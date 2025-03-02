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

@WebServlet("/updateInquiry")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String branch = request.getParameter("branch");
		
		request.setAttribute("name", name);
		request.setAttribute("branch", branch);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateInquiry.jsp");
		rd.forward(request,response);


	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String branch = request.getParameter("branch");
	
	DAOServiceImpl service = new DAOServiceImpl();
	service.connectDB();
	
	service.updateInquiry(name, branch);
	
	
	ResultSet result = service.getAllInquiry();
	request.setAttribute("res", result);
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_Inquiries.jsp");
	rd.forward(request,response);
	
	}

}
