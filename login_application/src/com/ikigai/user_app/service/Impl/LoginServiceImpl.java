package com.ikigai.user_app.service.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ikigai.user_app.bean.LoginBean;
import com.ikigai.user_app.dao.ILoginDao;
import com.ikigai.user_app.dao.Impl.LoginDaoImpl;
import com.ikigai.user_app.service.ILoginService;

public class LoginServiceImpl implements ILoginService{
	
	/**
	 * <P>
	 * This method calls the getLoginInfo() method of LoginDaoImpl class which returns an object of ResultSet. 
	 * The method then uses the rSet.next() method to check if the rSet has any values.
	 * If the rSet has values then it returns true.
	 * Else the method returns false. 
	 * </P>
	 * @param  LoginBean
	 * @return boolean
	 * @throws ClassNotFoundException, SQLException
	 */
	public boolean isLoginValid(LoginBean loginBean) throws ClassNotFoundException, SQLException {
		
		System.out.println("LoginServiceImpl isLoginValid START");
		
		boolean isLoginValid = false;
		ResultSet rSet = null;
		ILoginDao loginDaoImpl = new LoginDaoImpl();
		
		System.out.println("LoginServiceImpl is loginBeanNull:" + loginBean == null);
		
		rSet = loginDaoImpl.getLoginInfo(loginBean);
		
		System.out.println("rSet: " + rSet.toString());
		isLoginValid = rSet.next();
		
		
		System.out.println("isLoginValid: " + isLoginValid);
		System.out.println("LoginServiceImpl isLoginValid END");
		return isLoginValid;

	}

}
