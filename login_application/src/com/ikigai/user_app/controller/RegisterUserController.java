package com.ikigai.user_app.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ikigai.user_app.bean.RegisterUserBean;
import com.ikigai.user_app.service.Impl.RegisterUserServiceImpl;

/**
 * Servlet implementation class RegisterUserController
 */
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * <P>
	 * This method gets the values entered by the user in RegisterUser.jsp and sets it in the registerUserBean.
	 * Then it calls the isUserRegistered() method of the registerUserServiceImpl class which returns a boolean value. 
	 * If the method returns true the user is redirected to RegistrationSuccessful.jsp.
	 * Else to RegistrationUnsuccessful.jsp
	 * </P>
	 * @param  HttpServletRequest request, HttpServletResponse response
	 * @return void
	 * @throws throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterUserBean registerUserBean = new RegisterUserBean();
		
		registerUserBean.setFirstName(request.getParameter("firstName"));
		registerUserBean.setLastName(request.getParameter("lastName"));
		registerUserBean.setDob(request.getParameter("dob"));
		registerUserBean.setSex(request.getParameter("sex"));
		registerUserBean.setUsername(request.getParameter("username"));
		registerUserBean.setPassword(request.getParameter("password"));
		
		RegisterUserServiceImpl registerUserServiceImpl = new RegisterUserServiceImpl();
		
		boolean userRegistered = false;
		
		try {
			userRegistered = registerUserServiceImpl.isUserRegistered(registerUserBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(userRegistered == true) {
			response.sendRedirect("RegistrationSuccessful.jsp");
		} else {
			response.sendRedirect("RegistrationUnsuccessful.jsp");
		}
		
	}
}
