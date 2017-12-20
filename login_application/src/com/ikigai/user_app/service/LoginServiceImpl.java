package com.ikigai.user_app.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ikigai.user_app.bean.LoginBean;
import com.ikigai.user_app.dao.Impl.LoginDaoImpl;

public class LoginServiceImpl {
	
	public boolean isLoginValid(LoginBean loginBean) throws ClassNotFoundException, SQLException {
		System.out.println("LoginServiceImpl isLoginValid START");
		Boolean isLoginValid = false;
		
		LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
		ResultSet rSet = loginDaoImpl.getLoginInfo(loginBean);
		
		System.out.println("rSet: " + rSet.toString());
		
		if(rSet.next()) {
			isLoginValid = true;
		}else {
			isLoginValid = false;	
		}
		System.out.println("LoginServiceImpl isLoginValid END");
		System.out.println("isLoginValid: " + isLoginValid);

		return isLoginValid;

	}

}
