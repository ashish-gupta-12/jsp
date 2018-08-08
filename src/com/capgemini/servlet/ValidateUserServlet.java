package com.capgemini.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.InvalidUserException;
import com.capgemini.dal.UserDAO;

/**
 * Servlet implementation class ValidateUserServlet
 */
@WebServlet(description = "this servlet will help me to validate user type", urlPatterns = { "/validate" })
public class ValidateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		UserDAO dao=new UserDAO();
		String userType=null;
		
		RequestDispatcher requestDispatcher;

		try {
			userType=dao.getUserType(userName, password);
		if(userType.equals("Admin")) {
			requestDispatcher=request.getRequestDispatcher("/jsp/Admin.jsp");
		}
		else if(userType.equals("User")) {
			requestDispatcher=request.getRequestDispatcher("/jsp/User.jsp");
		}
		else {
			throw new InvalidUserException("Invalid");
		}
	}
		catch(InvalidUserException  e) {
			requestDispatcher=request.getRequestDispatcher("/jsp/InvalidUser.jsp");
		}
		requestDispatcher.forward(request, response);
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request, response);
	}

}
