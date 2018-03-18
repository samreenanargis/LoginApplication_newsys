package com.ikigai.user_app.dao;

import java.sql.SQLException;

import com.ikigai.user_app.bean.RegisterUserBean;

public interface IRegisterDao {
	
	public boolean registerUser(RegisterUserBean registerUserBean) throws SQLException;

}
