package com.ikigai.user_app.service.Impl;

import java.sql.SQLException;

import com.ikigai.user_app.bean.RegisterUserBean;
import com.ikigai.user_app.dao.IRegisterDao;
import com.ikigai.user_app.dao.Impl.RegisterDaoImpl;
import com.ikigai.user_app.service.IRegisterUserService;

/**
 * <P>
 * This method calls the registerUser() method from the RegisterDaoImpl class which returns a boolean.
 * The same boolean value is returned by isUserRegistered() method. 
 * </P> 
 * @param RegisterUserBean
 * @return boolean
 * @throws SQLException
 */
public class RegisterUserServiceImpl implements IRegisterUserService{
	
	public boolean isUserRegistered(RegisterUserBean registerUserBean) throws SQLException {
		
		boolean isUserRegistered = false;
		
		IRegisterDao registerDaoImpl = new RegisterDaoImpl();
		isUserRegistered = registerDaoImpl.registerUser(registerUserBean);
		
		return isUserRegistered;
	}

}
