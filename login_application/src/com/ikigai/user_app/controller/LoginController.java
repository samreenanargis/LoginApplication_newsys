package com.ikigai.user_app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ikigai.user_app.bean.LoginBean;
import com.ikigai.user_app.service.ILoginService;
import com.ikigai.user_app.service.Impl.LoginServiceImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	 
    /**
	 * <P>
	 * This method gets the parameters from the login jsp and sets them in the LoginBean.
	 * Then it calls the isLoginValid() method from LoginServiceImpl class and checks if the login credentials are
	 * valid. If the method returns true it takes the user to the LoginSuccessful page. Otherwise it redirects to
	 * LoginError.jsp 
	 * </P>
	 * @param  HttpServletRequest request, HttpServletResponse response
	 * @return void
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginController doPost START");
		
		// Method Level Variables
		boolean isLoginValid = false;
		String redirectJSP = null;
		LoginBean userLoginBean = new LoginBean();
		ILoginService loginService = new LoginServiceImpl();
		
		// Method Implementation
		try {
			
			/* Get the username and password from the request and set it into a Userinformation Bean to be sent to the service. */
			userLoginBean.setUsername(request.getParameter("username"));
			userLoginBean.setPassword(request.getParameter("password")); 
			
			/* Log the values for debugging */
			System.out.println("username: " + request.getParameter("username"));
			System.out.println("password: " + request.getParameter("password"));
			
			/* Call the login service to determine if the given username password is valid. */
			isLoginValid = loginService.isLoginValid(userLoginBean);
		} 
		catch (Exception e) {
			
			System.out.println(e.getStackTrace());
		} 
		
		/* Choose the redirect jsp based on login validity. */
		redirectJSP = (isLoginValid) ? "LoginSuccessful.jsp" : "LoginError.jsp";
		response.sendRedirect(redirectJSP);
	}
	
}
