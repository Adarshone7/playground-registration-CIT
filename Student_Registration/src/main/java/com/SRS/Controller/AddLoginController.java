package com.SRS.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SRS.Model.DAOServiceImpl;
@WebServlet("/addInquiryController")
public class AddLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addInquiry.jsp");
		rd.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(50);
		if(session.getAttribute("email")!=null){
		
		
		
		String name = request.getParameter("name");
	String rollno = request.getParameter("rollno");
	String mobileno = request.getParameter("mobileno");
	String branch = request.getParameter("branch");
	String year = request.getParameter("year");
	
	
	
	
	DAOServiceImpl service = new DAOServiceImpl();
	service.connectDB();
	
	service.addInquiry(name, rollno, mobileno, branch, year );
	request.setAttribute("msg", "Record is Saved!");
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addInquiry.jsp");
	rd.forward(request, response);
	}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}catch(Exception e) {
		request.setAttribute("error", "Session timedout!!");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
		
	
	
	}

}
