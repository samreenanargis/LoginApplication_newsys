package com.ikigai.user_app.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ikigai.user_app.bean.LoginBean;
import com.ikigai.user_app.service.LoginServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController doPost START");
		LoginBean userLoginBean = new LoginBean();
		
		userLoginBean.setUsername(request.getParameter("username"));
		userLoginBean.setPassword(request.getParameter("password")); 
		
		System.out.println("username: " + request.getParameter("username"));
		System.out.println("password: " + request.getParameter("password"));

		
		LoginServiceImpl loginService = new LoginServiceImpl();
		
		boolean loginValid = false;
		try {
			loginValid = loginService.isLoginValid(userLoginBean);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(loginValid == true) {
			response.sendRedirect("Users.jsp");
		} else {
			response.sendRedirect("LoginError.jsp");
		}
	}
	
}
