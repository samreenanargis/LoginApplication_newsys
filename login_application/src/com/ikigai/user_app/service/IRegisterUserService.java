package com.ikigai.user_app.service;

import java.sql.SQLException;

import com.ikigai.user_app.bean.RegisterUserBean;

public interface IRegisterUserService {
	
	public boolean isUserRegistered(RegisterUserBean registerUserBean) throws SQLException;

}
