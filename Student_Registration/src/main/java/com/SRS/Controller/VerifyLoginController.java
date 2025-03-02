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

@WebServlet("/verifyLogin")
public class VerifyLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VerifyLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	DAOServiceImpl service = new DAOServiceImpl();
	service.connectDB();
	
	boolean status = service.verifyLogin(email, password);
	if(status) {
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		session.setMaxInactiveInterval(50);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/addInquiry.jsp");
		rd.forward(request,response);
		
	}
	else {
		request.setAttribute("error", "invalid username/password");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request,response);
	}
	
	
	}catch(Exception e) {
		request.setAttribute("error", "Session timedout!!");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
		
	}

}
